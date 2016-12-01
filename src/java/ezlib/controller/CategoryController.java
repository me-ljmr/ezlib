/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.controller;

import ezlib.beans.Category;
import ezlib.data.CategoryDAO;
import ezlib.data.DB;
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
    CategoryDAO cdao ;
     public CategoryController() throws EZException{
        cdao = new CategoryDAO(DB.getConnection());
          
     }
    
    @RequestMapping("/categories") 
    public ModelAndView index() throws EZException{        
         
         
        List<Category> cats = cdao.getCategories();
         cdao=null;
        return (new ModelAndView("categories")).addObject("cats", cats);
    }
    @RequestMapping( value="/category/edit/{id}", method=RequestMethod.GET)
    public ModelAndView entry(@PathVariable int id){
        try{
         if(cdao==null) 
             cdao = new CategoryDAO(DB.getConnection());
        }catch(EZException ex){
            
        }
         Category cat = cdao.getCategory(id);
         
        
        return (new ModelAndView("category")).addObject("categoryForm",cat);
    }
    @RequestMapping(value="/category/add", method=RequestMethod.GET)
    public ModelAndView entry(){
         Category cat = new Category();
         ModelAndView mv = new ModelAndView("category");
         mv.addObject("soru","save");
        
        mv.addObject("categoryForm",cat);
        return mv;
    }
    @RequestMapping("/category/{id}")
    public ModelAndView detail(@PathVariable int id) throws EZException{
         try{
         if(cdao==null) 
             cdao = new CategoryDAO(DB.getConnection());
        }catch(EZException ex){
            
        }
         Category cat = cdao.getCategory(id);
          
         return (new ModelAndView("category")).addObject("cat",cat);
         
    } 
    @RequestMapping(value="/category/save", method=RequestMethod.POST)
    public String update(@ModelAttribute("categoryForm")Category cat)  {
        try{
         if(cdao==null) 
             cdao = new CategoryDAO(DB.getConnection());
        }catch(EZException ex){
            
        }
         try{
            if(cat.getCategoryId()==0){
                cdao.saveCategory(cat);
            }else{
                cdao.updateCategory(cat);
            }
            
         }catch(EZException  ex){
             
         }finally{
              return "redirect:/categories";
            
         } 
         
    }
 
}
