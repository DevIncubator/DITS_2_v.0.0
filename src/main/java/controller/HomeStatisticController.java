package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Dmitry on 18.02.2018.
 */
@Controller
@RequestMapping(value = "admin")
public class HomeStatisticController {

    @RequestMapping(value = "/test-statistic", method = RequestMethod.GET)
    public String showTestStatistic() {
        return "/test-statistic";
    }

    @RequestMapping(value = "/question-statistic", method = RequestMethod.GET)
    public String showQuestionStatistic() {
        return "/question-statistic";
    }

    @RequestMapping(value = "/user-statistic", method = RequestMethod.GET)
    public String showUserStatistic() {
        return "/user-statistic";
    }
}
