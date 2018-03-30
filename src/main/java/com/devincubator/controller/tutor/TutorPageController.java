package com.devincubator.controller.tutor;

import com.devincubator.entity.Question;
import com.devincubator.entity.Topic;
import com.devincubator.service.QuestionService;
import com.devincubator.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Main page controller for tutor
 *
 * @author Alex V.
 */

@Controller
public class TutorPageController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/tutor", method = RequestMethod.GET)
    public ModelAndView showForm() {
        ModelAndView model = new ModelAndView("tutor/tutor-main-page");
        return model;
    }


    @RequestMapping(value = "/getTopics", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getTopicPage(Model model) {
        List<Topic> topicList = topicService.getAll();
        model.addAttribute("topicList", topicList);
        return "tutor/tests";
    }

    @RequestMapping(value = "/getQuestions", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getQuestionPage(Model model) {
        List<Question> questionList = questionService.getAll();
        model.addAttribute("questionList", questionList);
        return "tutor/questions";
    }

    @RequestMapping(value = "/getStatistics", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getStatisticPage() {
        return "tutor/statistics";
    }
}