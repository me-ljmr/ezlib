/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SAUMIL
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginUser());
        return "login";
    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public String welcomeUser(@ModelAttribute("loginForm") @Valid LoginUser usr, BindingResult result, Model model) {

        String temp, message;
        if (result.hasErrors()) {
            temp = "login";
        } else {
            if (usr.getUserName().equalsIgnoreCase("saumil") && usr.getPassword().equals("sam")) {
                model.addAttribute("usrname", usr.getUserName());
                temp = "main";
            } else {
                model.addAttribute("command", new LoginUser());

                temp = "login";
            }
        }

        return temp;
    }

}
