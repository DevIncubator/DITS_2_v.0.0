package com.devincubator.controller.tutor;

import com.devincubator.dto.TopicTestDTO;
import com.devincubator.entity.Answer;
import com.devincubator.entity.Question;
import com.devincubator.entity.Test;
import com.devincubator.entity.Topic;
import com.devincubator.service.AnswerServiceImpl;
import com.devincubator.service.QuestionServiceImpl;
import com.devincubator.service.TestService;
import com.devincubator.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.devincubator.controller.admin.CreateTestPageController.getModelAndView;

@Controller
@RequestMapping("/tutor")
public class TutorQuestionController {

    private Question thisQuestion;
    private TopicService topicService;
    private TestService testService;
    private QuestionServiceImpl questionService;
    private AnswerServiceImpl answerService;

    @Autowired
    public TutorQuestionController(TopicService topicService, TestService testService, QuestionServiceImpl questionService, AnswerServiceImpl answerService) {
        this.topicService = topicService;
        this.testService = testService;
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @RequestMapping(value = "/tutor-create-test", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return getModelAndView(topicService);
    }

    @RequestMapping(value = "/tutor-create-test", method = RequestMethod.POST)
    public ModelAndView submitForm(@ModelAttribute("topicTestDTO") TopicTestDTO topicTestDTO) {
        Topic topic = topicService.create(topicTestDTO.getTopic());
        topicTestDTO.getTest().setTopic(topic);
        testService.create(topicTestDTO.getTest());
        return showForm();
    }


    @RequestMapping(value = "/tutor-choose-topic", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getTopics(Model model) {
        List<Topic> topicList = topicService.getAll();
        model.addAttribute("topic", new Topic());
        model.addAttribute("topicList", topicList);
        return "/tutor/tutor-choose-topic";
    }


    @RequestMapping(value = "/getQuestionsByTestId", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Question> getQuestionsByTestId(Model model, @ModelAttribute("test") String testName) {
        Test test = testService.findByName(testName);
        List<Question> questionList = questionService.findByTest(test);
        System.out.println("QUESTION LIST"+ questionList.size());
        return questionList;
    }

    @RequestMapping(value = "/getTestByTopicId", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getTestsByTopicId(Model model, @ModelAttribute("topic") String topicString) {
        Topic topic = topicService.findByName(topicString);
        List<Test> testList = testService.findByTopic(topic);
//        model.addAttribute("test", new Test());
        model.addAttribute("testList", testList);
        return "/tutor/tutor-choose-test";
    }

    @RequestMapping(value = "/createQuestions", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String addTopic(Model model, @ModelAttribute("test") String test) {
        Test testEntity = testService.findByName(test);

        List<Question> questionList = questionService.findByTest(testEntity);
        model.addAttribute("test", testEntity);
        model.addAttribute("questionList", questionList);
        return "/tutor/tutor-create-questions";
}

    @RequestMapping(value = "/createAnswer", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String addAnswer(Model model, @ModelAttribute("question") String question, @RequestParam(value = "testName") String testName) {
        System.out.println("----------------------------------TEST GOT IT IN ANSWERS:" +testName);
        List<Question> allQuestions = questionService.getAll();
        Test test = testService.findByName(testName);
        boolean flag = false;
        for(Question q : allQuestions){
            String buffer = q.getDescription();
            if(buffer.equals(question))
                flag = true;
        }
        thisQuestion = questionService.findByDescription(question);
        if(!flag){
            thisQuestion = new Question(question, test);
            questionService.addQuestion(thisQuestion);
            model.addAttribute("newQuestion", thisQuestion);
        }


        List<Answer> answerList = answerService.findByQuestion(thisQuestion);

        model.addAttribute("answerList", answerList);

        return "/tutor/tutor-create-answer";
    }

    @RequestMapping(value = "/checkAnswer", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public boolean checkQuestion(@ModelAttribute("answerName") String answerName) {
        Answer answer = answerService.findByDescription(answerName);
        if (answer == null) return false;
        return true;
    }

    @RequestMapping(value = "/addAnswer", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Answer> AddAnswer(@ModelAttribute("answerName") String answerName, @ModelAttribute("questionName") String questionName,
                                  @ModelAttribute("correct") boolean correct) {
        System.out.println("ANSWER-------------" + answerName);
        System.out.println("ANSWER-------------" + correct);
        System.out.println("ANSWER-------------" + questionName);

//        Question question = questionService.findByDescription(questionName);
        Answer answer = new Answer(answerName, correct, thisQuestion);
        answerService.addAnswer(answer);
        List<Answer> answerList = answerService.findByQuestion(thisQuestion);
        return answerList;
    }
}