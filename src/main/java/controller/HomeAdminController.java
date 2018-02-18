package controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Dmitry on 18.02.2018.
 */
@Controller
@RequestMapping(value = "admin")
public class HomeAdminController {

    @RequestMapping(value = "test/create", method = RequestMethod.GET)
    public String goToCreateTest() {
        return "admin/create-test";
    }

    @RequestMapping(value = "user/create", method = RequestMethod.GET)
    public String goToCreateUser() {
        return "admin/create-user";
    }

    @RequestMapping(value = "/statistic", method = RequestMethod.GET)
    public String goToStatistic() {
        return "admin/statistic";
    }
}
