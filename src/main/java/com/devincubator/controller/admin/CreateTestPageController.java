package com.devincubator.controller.admin;

import com.devincubator.dto.TopicTestDTO;
import com.devincubator.entity.Test;
import com.devincubator.entity.Topic;
import com.devincubator.service.TestService;
import com.devincubator.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 25.02.2018.
 */
@Controller
@RequestMapping("/admin")
public class CreateTestPageController {

    @Autowired
    private TopicService topicService;
    @Autowired
    private TestService testService;

    @RequestMapping(value = "/create-test", method = RequestMethod.GET)
    public ModelAndView showForm() {
        ModelAndView model = new ModelAndView();
        Topic topic = new Topic();
        Test test = new Test();
        test.setTopic(topic);
        model.addObject("topicTestDTO", new TopicTestDTO(topic, test));
        List<Topic> topicList = topicService.getAll();
        List<String> topicNames = new ArrayList<>();
        for (Topic topics : topicList) {
            topicNames.add(topics.getName());
        }
        model.addObject("topicList", topicNames);
        return model;
    }

    @RequestMapping(value = "/create-test", method = RequestMethod.POST)
    public ModelAndView submitForm(@ModelAttribute("topicTestDTO") TopicTestDTO topicTestDTO) {
        Topic topic = topicService.create(topicTestDTO.getTopic());
        topicTestDTO.getTest().setTopic(topic);
        testService.create(topicTestDTO.getTest());
        return showForm();
    }
}

