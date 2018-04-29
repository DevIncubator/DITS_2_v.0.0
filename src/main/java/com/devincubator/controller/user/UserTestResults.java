package com.devincubator.controller.user;

import com.devincubator.dto.UserDTO;
import com.devincubator.entity.*;
import com.devincubator.service.*;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/user")
public class UserTestResults {

    QuestionServiceImpl questionService;
    AnswerServiceImpl answerService;
    TestServiceImpl testService;
    StatisticServiceImpl statisticService;
    LiteratureService literatureService;
    LinkServiceImpl linkService;
    UserServiceImpl userService;



    @Autowired
    UserTestResults(LinkServiceImpl linkService, LiteratureService literatureService, UserServiceImpl userService, StatisticServiceImpl statisticService, TestServiceImpl testService, QuestionServiceImpl questionService, AnswerServiceImpl answerService){
        System.out.println("INSIDE CONSTRUCTOR RESULT");
        this.testService = testService;
        this.questionService = questionService;
        this.answerService = answerService;
        this.statisticService = statisticService;
        this.userService = userService;
        this.literatureService = literatureService;
        this.linkService = linkService;

    }

    /**
     * МЕТОД ПОДСЧЁТА РЕЗУЛЬТАТОВ
     * ВЖУХ И ПОДСЧИТАНО!
     * */
    @RequestMapping(value = "/getTestResults", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String testResults(Model model,
                              @RequestParam(value = "checkedAnswers")List<Long> checkedAnswers,
                              @RequestParam(value = "testName")String testName
    ){

        model.addAttribute("testName", testName); //просто имя теста, который прошли
        Test thisTest = testService.findByName(testName);

        List<Answer> checkedAnswerResult = new ArrayList<>();// здесь будут храниться сущности ответов которые чекнул пользователь

        /**
         * соединяем в один список все чекнутые ответы
         * */
        for (Long answers : checkedAnswers) {
            Answer answer = answerService.findByAnswerId(answers);
            checkedAnswerResult.add(answer); // список чекнутых ответов
        }

        Map<Question, Boolean> map = testResult2(checkedAnswerResult, thisTest); //--------------ВЫЗОВ МЕТОДА--------------
        int right = 0;
        int all = 0;
        List<Question> thisQuestionList = new ArrayList<>();
        for(Map.Entry<Question, Boolean> entry : map.entrySet()) {
            thisQuestionList.add(entry.getKey());
            all++;
            boolean buffer = entry.getValue();
            if(buffer)right++;
        }

        double resultInPercent = ((double)right/map.size())*100;
        String formattedResult = new DecimalFormat("#00.00").format(resultInPercent);
        model.addAttribute("result", formattedResult);
        model.addAttribute("map", map);
        HashMap<Literature, List<Link>> mapOfLinks = new HashMap<>();
        for(Question q : thisQuestionList){
            List<Literature> buffer = literatureService.findByQuestion(q);
            for(Literature l : buffer){
                List<Link> bufferLinks = linkService.findByLiterature(l);
                mapOfLinks.put(l, bufferLinks);
            }

        }
        model.addAttribute("mapLink", mapOfLinks);

        return "user/test-results";
    }

    public Map<Question,  Boolean> testResult2(List<Answer> checkedAnswerResult, Test test) {

         //получим сущность теста, для списка вопросов
        List<Question> thisQuestionList = questionService.findByTest(test); //список всех вопросов по тесту
        List<Answer> thisAnswerList = new ArrayList<>();


        /**
         * создаём список всех ответов на все вопросы
         * которые есть в тесте (для создания списка нечекнутых)
         * */
        List<Answer> allTestAnswers = new ArrayList<>();
        for(Question q : thisQuestionList){
            List<Answer> bufferList = answerService.findByQuestion(q);
            allTestAnswers.addAll(bufferList);
        }

        /**
         * создаём список НЕчекнутых ответов
         * ЭТА ХУЕТА НЕ НУЖНА. ВМЕСТО СПИСКА АНЧЕКНУТЫХ ПОТОМ БУДЕТ ПРОСТО !ЛИСТ_СПИСОК_ЧЕКНУТЫХ
         * всё таки нужна! Напрямую сущности не сравниваются, ибо разные бины.
         * */
        List<Answer> uncheckedAnswers = new ArrayList<>();
        for(int i = 0; i < allTestAnswers.size(); i++){
            boolean flag = false;
            Answer answer = allTestAnswers.get(i);
            Long answerId = answer.getAnswerId();
            for(Answer a : checkedAnswerResult){
                if(a.getAnswerId().equals(answerId)){
                    flag = true;
                }
            }
            if(flag == false)
                uncheckedAnswers.add(answer);
        }

        List<Question> wrongQuestions = new ArrayList<>(); // список неправильно отвеченных вопросов
        List<Question> correctQuestions = new ArrayList<>();//список правильно отвеченных вопрсоов
        List<Long> wrongQuestionsDeduped = new ArrayList<>();
        List<Long> correctQuestionsDeduped = new ArrayList<>();

        /**
         * а)Прогоняем по одному вопросу,
         * б)Получаем от каждого вопроса список ответов
         * в)Разделяем этот список ответов на два списка: правильные-неправильные
         * */
        for(int i = 0; i < thisQuestionList.size(); ++i){ //прогоняем по одному вопросу
            List<Answer> allBufferAnsList = answerService.findByQuestion(thisQuestionList.get(i));
            List<Answer> correctAnswers = new ArrayList<>();//список правильных ответов вообще (без пользователя)
            List<Answer> wrongAnswers = new ArrayList<>();//список неправильных ответов вообще (без пользователя)
            for(int j = 0; j < allBufferAnsList.size(); j++){
                Answer answer = allBufferAnsList.get(j);
                if(answer.isCorrect()){
                    correctAnswers.add(answer);
                }
                else {
                    wrongAnswers.add(answer);
                }
            }
            /**
             * а) Прогоняем опять ответы по данному вопросу
             * б) Начинаем проверять, есть ли такой ответ в чекнутых и СПИСКЕ НЕПРАВИЛЬНЫХ
             * в) Начинаем проверять, есть ли такой ответ в чекнутых и СПИСКЕ ПРАВИЛЬНЫХ
             * г) Добавляем вопрос при соблюдении условия в лист ПРАВИЛЬНЫХ/НЕПРАВИЛЬНЫХ ОТВЕЧЕННЫХ ВОПРОСОВ
             * д) Сравниваем списки отвеченных вопросов. Убираем из правильных всё, что есть в неправильных
             * */
            for(int j = 0; j < allBufferAnsList.size(); j++) {//начинаем сравнивать
                Answer answer = allBufferAnsList.get(j);
                Long answerId = answer.getAnswerId();
                boolean test1 = correctAnswers.contains(answer);
                boolean test2 = !checkedAnswerResult.contains(answer);
                boolean test3 = checkedAnswerResult.contains(answer);
                /**
                 * НОВЫЙ ПОДХОД
                 * приходится вводить флаги, напрямую сущности ответов не сравниваются.
                 * Даже если ответы одинаковы они привязаны к вопросам, бины которых создавались
                 * в разных циклах. Поэтому сравнивать надо будет ответы по айдишникам.
                 * поэтому вводим новые циклы для проверки айдишников.
                 * */
                boolean flag1a = false;
                boolean flag1b = false;
                boolean flag2a = false;
                boolean flag2b = false;
                boolean flag3a = false;
                boolean flag3b = false;

                for(Answer a : wrongAnswers)
                    if(answerId.equals(a.getAnswerId()))
                        flag1a = true;
                for(Answer a : checkedAnswerResult)
                    if(answerId.equals(a.getAnswerId()))
                        flag1b = true;
                for(Answer a : correctAnswers)
                    if(answerId.equals(a.getAnswerId()))
                        flag2a = true;
                for(Answer a : uncheckedAnswers)
                    if(answerId.equals(a.getAnswerId()))
                        flag2b = true;
                for(Answer a : correctAnswers)
                    if(answerId.equals(a.getAnswerId()))
                        flag3a = true;
                for(Answer a : checkedAnswerResult)
                    if(answerId.equals(a.getAnswerId()))
                        flag3b = true;
                /**
                 * СТАРЫЕ УСЛОВИЯ с новым подходом (флаги)
                 * если ответ содержится в неправильных ответах и в чекнутых
                 * добавляем в список неправильно отвеченных вопросов
                 * */
                if(flag1a && flag1b){
                    wrongQuestions.add(thisQuestionList.get(i));
                }
                /**
                 * СТАРЫЕ УСЛОВИЯ с новым подходом (флаги)
                 * если ответ содержится в правильных ответах и НЕЧЕКНУТЫХ ответах
                 * добавляем в список неправильных
                 * */
                else if(flag2a && flag2b){
                    wrongQuestions.add(thisQuestionList.get(i));
                }
                /**
                 * СТАРЫЕ УСЛОВИЯ с новым подходом (флаги)
                 * если ответ содержится в правильных и чекнутых - добавляем
                 * в список правильных
                 * */
                else if(flag3a && flag3b){
                    correctQuestions.add(thisQuestionList.get(i));
                }
            }
            /**
             * убираем дубликаты из wrongQuestions && correctQuestions
             * */
            for(int k = 0; k < wrongQuestions.size(); k++){
                Question question = wrongQuestions.get(k);
                Long id = question.getQuestionId();
                if(!wrongQuestionsDeduped.contains(id))
                    wrongQuestionsDeduped.add(id);
            }
            for(int k = 0; k < correctQuestions.size(); k++){
                Question question = correctQuestions.get(k);
                Long id = question.getQuestionId();
                if(!correctQuestionsDeduped.contains(id))
                    correctQuestionsDeduped.add(id);
            }
            for(int k = 0; k < wrongQuestionsDeduped.size(); k++){
                if(correctQuestionsDeduped.contains(wrongQuestionsDeduped.get(k))){
                    correctQuestionsDeduped.remove(wrongQuestionsDeduped.get(k));
                }
            }
        }
        int questionsInTest = thisQuestionList.size();
        int questionsCorrect = correctQuestionsDeduped.size();
        double resultInPercent = ((double)questionsCorrect/questionsInTest)*100;
        String formattedResult = new DecimalFormat("#00.00").format(resultInPercent);
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User userId = userService.findByLogin(userName);
        Map<Question, Boolean> map = new HashMap<>();
        for(Long l : correctQuestionsDeduped){
            Question question = questionService.findByQuestionId(l);
            statisticService.addQuestionCorrect(userId, question, true);
            map.put(question, true);
        }
        for(Long l : wrongQuestionsDeduped){
            Question question = questionService.findByQuestionId(l);
            statisticService.addQuestionCorrect(userId, question, false);
            map.put(question, false);
        }
        return map;
    }

    @RequestMapping(value = "/spisocOtvetov", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Answer> spisocOtvetov(@RequestBody Question question) {
        List<Answer> answers = answerService.findByQuestion(question);
        return answers;
    }

    @RequestMapping(value = "/testResultRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<Question, Boolean> testResultRest(@RequestBody List<Answer> checkedAnswerResult) {
        Answer answer = checkedAnswerResult.get(0);
        Test test = answer.getQuestion().getTest();
        return testResult2(checkedAnswerResult, test);
    }



}


