package com.JavaTests.controller;

/*import com.JavaTests.entity.Test;
import com.JavaTests.repository.TestRepository;
import com.JavaTests.service.TestService;*/
import entity.Answer;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.AbstractService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class TutorTestController {

    @Autowired
    AbstractService abstractService;

    @RequestMapping("/")
    public String hello() {
        return "hello2";
    }

    @RequestMapping(value = "/getTests", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getAll(Model model) {
        List<Answer> testList = abstractService.getAll();
        model.addAttribute("testList", testList);
        return "answer";
    }

    @RequestMapping(value = "/addAnswer", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String addTest(@ModelAttribute("answer") Answer answer) {
        abstractService.create(answer);
        return "addAnswer";
    }

    @RequestMapping(value = "/deleteAnswer", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String deleteTest(@ModelAttribute("answer") Answer answer) {
        abstractService.remove(answer);
        return "deleteAnswer";
    }

    @RequestMapping(value = "/editTest", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String editTest(@ModelAttribute("test") Answer answer) {
        abstractService.update(answer);
        return "editAnswer";
    }

    @RequestMapping(value = "/getAnswerRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void getTestsRest() {
        abstractService.getAll();
    }

    @RequestMapping(value = "/getAnswerRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void addTestRest(@RequestBody Answer answer) {
        abstractService.create(answer);
    }

    @RequestMapping(value = "/deleteAnswer", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void deleteTestRest(@RequestBody Answer answer) {
        abstractService.remove(answer);
    }

    @RequestMapping(value = "/editAnswer", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void editTestRest(@RequestBody Answer answer) {
        abstractService.update(answer);
    }
}
