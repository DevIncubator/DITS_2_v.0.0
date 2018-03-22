package com.devincubator.controller.admin;

import com.devincubator.entity.TestStatistic;
import com.devincubator.service.TestStatisticServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Dmitry on 16.03.2018.
 */
@Controller
public class StatisticTestPageController {

    @Autowired
    private TestStatisticServiceImpl testStatisticServiceImpl;

    @RequestMapping(value = "/statistics-test", method = RequestMethod.GET)
    public ModelAndView showViews() {
        ModelAndView model = new ModelAndView("admin/statistic-test");
        List<TestStatistic> testStatistic;
        testStatistic = testStatisticServiceImpl.getAll();
        model.addObject("stat", testStatistic);
        return model;
    }
}
