package com.devincubator.controller.admin;

import com.devincubator.entity.Topic;
import com.devincubator.service.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Dmitry on 25.02.2018.
 */
@Controller
public class CreateTestPageController {

    @Autowired
    private TopicServiceImpl topicServiceImpl;

    @RequestMapping(value = "/create-test", method = RequestMethod.GET)
    public ModelAndView showForm() {
        ModelAndView model = new ModelAndView ("admin/create-test");
        model.addObject("topic", new Topic());
        List<Topic> topicList = topicServiceImpl.getAll();

        List<String> topicNames = new ArrayList<>();
        for (Topic topic : topicList) {
            topicNames.add(topic.getName());
        }

        model.addObject("topicList", topicNames);
        return model;
    }

    @RequestMapping(value = "/create-test", method = RequestMethod.POST)
    public ModelAndView submitForm(@ModelAttribute("topic") Topic topic) {
        System.out.println(topic.toString());

        return showForm();
    }
}

