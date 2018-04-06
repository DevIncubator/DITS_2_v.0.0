package com.devincubator.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserHomeController {

    @RequestMapping("/user-home")
    public String userHome(Model model){

        return "user/user-home";

    }

}
