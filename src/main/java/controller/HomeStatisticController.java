package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Dmitry on 18.02.2018.
 */
public class HomeStatisticController {

    @RequestMapping(value = "/test-statistic", method = RequestMethod.GET)
    public String goToCreateTest() {
        return "redirect:/test/add";
    }

    @RequestMapping(value = "/question-statistic", method = RequestMethod.GET)
    public String goToCreateUser() {
        return "redirect:/user/add";
    }

    @RequestMapping(value = "/user-statistic", method = RequestMethod.GET)
    public String goToStatistic() {
        return "redirect:/view-statistic";
    }
}
