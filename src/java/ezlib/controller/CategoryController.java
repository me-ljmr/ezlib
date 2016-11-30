/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.controller;

import ezlib.beans.Category;
import ezlib.data.DbQueries;
import ezlib.exception.EZException;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author lujamanandhar
 */
@Controller
public class CategoryController {
    DbQueries dbq ;
     
    
    @RequestMapping("/categories") 
    public ModelAndView index(){        
        dbq = null;
         dbq = new DbQueries();
        List<Category> cats = dbq.getCategories();
         
        return (new ModelAndView("categories")).addObject("cats", cats);
    }
    @RequestMapping("/category/add")
    public ModelAndView add(){
         
        Category cat = new Category();
        return (new ModelAndView("category")).addObject("categoryForm",cat);
    }
    @RequestMapping("/category/{id}")
    public ModelAndView detail(@PathVariable int id){
         Category cat = new DbQueries().getCategory(id);
         return (new ModelAndView("category")).addObject("cat",cat);
         
    } 
    @RequestMapping(value="update", method=RequestMethod.POST)
    public String update(@ModelAttribute("categoryForm")Category cat){
        dbq = null;
        return "test";
    }
    @RequestMapping(value="/category/save", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("categoryForm")Category cat){
        dbq = null;
         dbq = new DbQueries();
         try{
            dbq.saveCategory(cat);
         }catch(EZException ex){
             
         }
        return new ModelAndView("redirect:/categories");
    }
}
