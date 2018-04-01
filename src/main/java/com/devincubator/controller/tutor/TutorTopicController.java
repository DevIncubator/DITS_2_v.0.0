package com.devincubator.controller.tutor;

import com.devincubator.entity.Test;
import com.devincubator.entity.Topic;
import com.devincubator.service.TestService;
import com.devincubator.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TutorTopicController {

    @Autowired
    private TopicService topicService;
    @Autowired
    private TestService testService;


    @RequestMapping(value = "/addTopic", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String addTopic(@ModelAttribute("topic") String topicName, @ModelAttribute("test") String testName) {
        Topic topic = topicService.findByName(topicName);
        if (topic == null){
            topic = new Topic(topicName);
            topicService.create(topic);
        }
        Test test = new Test(testName, topic);
        testService.create(test);
    return "redirect:/getTopics";
    }

    @RequestMapping(value = "/getTestsByTopicId", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Test> getTestsById(Model model, @ModelAttribute("topic") String topicName) {
        Topic topic = topicService.findByName(topicName);
        List<Test> testList = testService.findByTopicId(topic.getTopicId());
        return testList;
    }

    @RequestMapping(value = "/addTopicRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void addTopicRest(@RequestBody Topic topic) {
        topicService.create(topic);
    }



    @RequestMapping(value = "/getTopicsRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void getTopicsRest() {
        topicService.getAll();
    }
}
