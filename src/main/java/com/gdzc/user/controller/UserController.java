package com.gdzc.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Liu_Zhichao on 14-6-5.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @RequestMapping(value = "index" , method = RequestMethod.GET)
    public String index(HttpServletRequest request,Model model){
        model.addAttribute("name","幻想低调");
        return "index";
    }
}
