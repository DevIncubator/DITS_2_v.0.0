package com.devincubator.controller.admin;

import com.devincubator.entity.UserStatistic;
import com.devincubator.service.UserStatisticServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Dmitry on 27.03.2018.
 */
@Controller
@RequestMapping("/admin")
public class StatisticUserPageController {

    @Autowired
    private UserStatisticServiceImpl userStatisticServiceImpl;

    @RequestMapping(value = "/statistics-user", method = RequestMethod.GET)
    public ModelAndView showViews() {
        ModelAndView model = new ModelAndView("admin/statistic-user");
        List<UserStatistic> userStatistic;
        userStatistic = userStatisticServiceImpl.getAll();
        model.addObject("stat", userStatistic);
        return model;
    }
}
