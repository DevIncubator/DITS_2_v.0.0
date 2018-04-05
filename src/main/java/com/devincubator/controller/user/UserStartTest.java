package com.devincubator.controller.user;


import com.devincubator.entity.Answer;
import com.devincubator.entity.Question;
import com.devincubator.entity.Test;
import com.devincubator.service.AnswerServiceImpl;
import com.devincubator.service.QuestionService;
import com.devincubator.service.QuestionServiceImpl;
import com.devincubator.service.TestServiceImpl;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserStartTest {

    QuestionServiceImpl questionService;

    AnswerServiceImpl answerService;

    TestServiceImpl testService;

    private List<Question> questions;

    @Autowired
    UserStartTest(TestServiceImpl testService, QuestionServiceImpl questionService, AnswerServiceImpl answerService){
        this.testService = testService;
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @RequestMapping(value = "/start-test", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String startTest(Model model, @ModelAttribute("test") String testName){
        Test test = testService.findByName(testName);
        model.addAttribute("testName", testName);
        this.questions = questionService.findByTest(test);
        Map<Question, List<Answer>> nextQuestion = new HashMap<>();
        for(int i = 0; i < questions.size(); i++){
            List<Answer> answerList = answerService.findByQuestion(questions.get(i));
            nextQuestion.put(questions.get(i), answerList);
        }
        model.addAttribute("map", nextQuestion);
        model.addAttribute("questionListSize", nextQuestion.size());
        return "user/start-test";
    }

  /*  @RequestMapping(value = "/nextQuestion", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Map<Question, List<Answer>> chooseNextQuestion(@ModelAttribute("counter")int counter){
        Map<Question, List<Answer>> nextQuestion = new HashMap<>();
        Question question = questions.get(counter);
        List<Answer> answerList = answerService.findByQuestion(question);
        nextQuestion.put(question, answerList);
        System.out.println();
        return nextQuestion;
    }*/


  /*  @RequestMapping(value = "/counter", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String counter(Model model, @ModelAttribute("counter")int counter){
        System.out.println("COUNTER FROM JSP = " + counter);
        System.out.println("ZERO COUNTER = " + counter);
        this.zeroCounter = counter;
        return "user/start-test";
    }*/


}
