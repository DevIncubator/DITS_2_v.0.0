package com.devincubator.controller.user;

import com.devincubator.entity.Topic;
import com.devincubator.service.TestServiceImpl;
import com.devincubator.service.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TopicTestPageController {

    @Autowired
    private TopicServiceImpl topicServiceImpl;

    @Autowired
    private TestServiceImpl testServiceImpl;

    ModelAndView model = new ModelAndView("user/topic-test");

    @RequestMapping(value = "/topic-test", method = RequestMethod.POST)
    public ModelAndView submitForm(@ModelAttribute("topic") Topic topic) {
        return showForm();
    }

//    @RequestMapping(value = "/topic-test", method = RequestMethod.POST)
//    public ModelAndView submitForm2(@RequestParam("topic") Topic topic) {
//        return showForm();
//    }


    @RequestMapping(value = "/topic-test", method = RequestMethod.GET)
    public ModelAndView showForm() {
        model.addObject("topic", new Topic());
        List<Topic> topicList = topicServiceImpl.getAll();
        List<String> topicNames = new ArrayList<>();
        for (Topic topic : topicList) {
            topicNames.add(topic.getName());
        }
        model.addObject("topicList", topicNames);
        return model;
    }

//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public ModelAndView getTopicId(@RequestParam(value = "topicId", required = true)Topic topic){
//        System.out.println("BINGO :::: " + topic.getName());
//        if(topic == null){
//            model.addObject("testList", "nothingToShow");
//            System.out.println("TOPIC IS NULL");
//        }
//        else {
//            System.out.println("Topic is not null!!!!!!!!!!!!");
//        }
//        /*List<Test> testList = testServiceImpl.findByTopicId(topic);
//        model.addObject("test", new Test());
//        List<String> testNames = new ArrayList<>();
//        for(Test test : testList){
//            testNames.add(test.getName());
//        }
//        model.addObject("testList", testNames);*/
//        return model;
//    }
}
