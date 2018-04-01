package com.devincubator.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class userHomeController {

    @RequestMapping("/user-home")
    public String userHome(Model model){

        return "user/user-home";

    }

}
