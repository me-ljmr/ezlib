/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author lujamanandhar
 */
@Controller
@RequestMapping(value="/")
public class HomeController {
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView showHome(){
        return (new ModelAndView("index"));
    }
}
