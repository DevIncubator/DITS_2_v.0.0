package com.devincubator.controller.user;

import com.devincubator.entity.Statistic;
import com.devincubator.entity.User;
import com.devincubator.service.QuestionServiceImpl;
import com.devincubator.service.StatisticServiceImpl;
import com.devincubator.service.TestServiceImpl;
import com.devincubator.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(name = "/user")
public class UserStatisticController {

    QuestionServiceImpl questionService;
    TestServiceImpl testService;
    UserServiceImpl userService;
    StatisticServiceImpl statisticService;

    @Autowired
    UserStatisticController(StatisticServiceImpl statisticService, UserServiceImpl userService, QuestionServiceImpl questionService, TestServiceImpl testService) {
        this.questionService = questionService;
        this.testService = testService;
        this.userService = userService;
        this.statisticService = statisticService;
    }

    @RequestMapping(value = "/getStatistic", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String userStatistic(Model model) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByLogin(userName);
        String userFirstName = user.getFirstName();
        List<Statistic> statList = statisticService.findByUser(user);
        model.addAttribute("statList", statList);
        model.addAttribute("userName", userFirstName);
        return "user/user-statistic";
    }
}
