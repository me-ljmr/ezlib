/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.controller;

import ezlib.beans.Category;
import ezlib.data.DbQueries;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SAUMIL
 */
@Controller
public class BookController  {
  
    @RequestMapping("/books") 
    public ModelAndView index(){         
        ModelAndView modelandview  = new ModelAndView("category");
        List<Category> cats = new DbQueries().getCategories();
        modelandview.addObject("cats", cats);
  
        return modelandview;
    }
    
     

}
