package com.devincubator.controller.admin;

import com.devincubator.entity.QuestionStatistic;
import com.devincubator.service.QuestionStatisticServiceImpl;
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
public class StatisticQuestionPageController {

    @Autowired
    private QuestionStatisticServiceImpl questionStatisticServiceImpl;

    @RequestMapping(value = "admin/statistics-questions", method = RequestMethod.GET)
    public ModelAndView showViews() {
        ModelAndView model = new ModelAndView("admin/statistic-questions");
        List<QuestionStatistic> questionStatistic = questionStatisticServiceImpl.getAll();
        model.addObject("stat", questionStatistic);
        return model;
    }
}
