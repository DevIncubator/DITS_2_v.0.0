package com.devincubator.controller.user;


import com.devincubator.entity.Test;
import com.devincubator.entity.Topic;
import com.devincubator.service.TestServiceImpl;
import com.devincubator.service.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserTopicTestController {

    TopicServiceImpl topicService;

    TestServiceImpl testService;

    @Autowired
    UserTopicTestController(TopicServiceImpl topicService, TestServiceImpl testService){
        this.topicService = topicService;
        this.testService = testService;
    }

    @RequestMapping(value = "/getUserTopics", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getTopics(Model model) {
        List<Topic> topicList = topicService.getAll();
        model.addAttribute("topic", new Topic());
        model.addAttribute("topicList", topicList);
        return "user/choose-topic";
    }


    @RequestMapping(value = "/getTestByTopicId", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getTestsByTopicId(Model model, @ModelAttribute("topic") String topicString) {
        Topic topic = topicService.findByName(topicString);
        List<Test> testList = testService.findByTopic(topic);
//        model.addAttribute("test", new Test());
        model.addAttribute("testList", testList);
        return "user/choose-test";
    }


}
