package com.devincubator.controller.user;

import com.devincubator.entity.Answer;
import com.devincubator.entity.Question;
import com.devincubator.entity.Statistic;
import com.devincubator.entity.Test;
import com.devincubator.service.*;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserTestResults {

    QuestionServiceImpl questionService;

    AnswerServiceImpl answerService;

    TestServiceImpl testService;

    StatisticServiceImpl statisticService;



    @Autowired
    UserTestResults(StatisticServiceImpl statisticService, TestServiceImpl testService, QuestionServiceImpl questionService, AnswerServiceImpl answerService){
        System.out.println("INSIDE CONSTRUCTOR RESULT");
        this.testService = testService;
        this.questionService = questionService;
        this.answerService = answerService;
        this.statisticService = statisticService;
    }

    @RequestMapping(value = "/getTestResults", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String testResults(Model model,
                              @RequestParam(value = "checkedAnswers")List<Long> checkedAnswers,
                              @RequestParam(value = "testName")String testName
    ){

        model.addAttribute("testName", testName);
        Test thisTest = testService.findByName(testName);
        List<Question> thisQuestionList = questionService.findByTest(thisTest);
        List<Answer> thisAnswerList = new ArrayList<>();
        int allCorrectAnswers = 0;
        int userCorrectAnswers = 0;
        for(Question q : thisQuestionList){ //соединяем в один список все вопросы вообще
            List<Answer> bufferList = answerService.findByQuestion(q);
            for(int i = 0; i < bufferList.size(); i++){
                thisAnswerList.add(bufferList.get(i));
            }
        }
        model.addAttribute("answerQuantity", thisAnswerList.size());
        for(Answer correctAnswer : thisAnswerList){ //выясняем количество правильных ответов в тесте вообще
            if(correctAnswer.isCorrect()){
                allCorrectAnswers++;
            }
        }

        List<Answer> checkedAnswerResult = new ArrayList<>();
        for(Long answers : checkedAnswers){ //соединяем в один список все чекнутые ответы
            Answer answer = answerService.findByAnswerId(answers);
            checkedAnswerResult.add(answer);
        }
        for(Answer answer : checkedAnswerResult){
            if(answer.isCorrect()){
                Question q = answer.getQuestion();
                System.out.println("QUESTION IS RIGHT: " + q);
                userCorrectAnswers++;
               statisticService.addQuestionCorrect(q, true);
                System.out.println("Question: " + q);
            }
            else{
                Question q = answer.getQuestion();
                statisticService.addQuestionCorrect(q, false);
            }
        }
        model.addAttribute("userCorrectAnswers", userCorrectAnswers);
        double resultInPercent = (double)userCorrectAnswers/allCorrectAnswers;
        double result = (Math.round(resultInPercent * Math.pow(10, 2))/Math.pow(10,2))*100;
        model.addAttribute("result", result);
        return "user/test-results";
    }

}
