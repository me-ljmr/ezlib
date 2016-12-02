/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.controller;

import ezlib.beans.Author;
import ezlib.data.AuthorDAO;
import ezlib.data.AuthorDAO;
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
public class AuthorController {
    AuthorDAO cdao ;
     public AuthorController() throws EZException{
        cdao = new AuthorDAO(DB.getConnection());
          
     }
    
    @RequestMapping("/authors") 
    public ModelAndView index() throws EZException{        
         
         
        List<Author> auths = cdao.getAuthors();
         cdao=null;
        return (new ModelAndView("authors")).addObject("authors", auths);
    }
    @RequestMapping( value="/author/edit/{id}", method=RequestMethod.GET)
    public ModelAndView entry(@PathVariable int id){
        try{
         if(cdao==null) 
             cdao = new AuthorDAO(DB.getConnection());
        }catch(EZException ex){
            
        }
         Author auth = cdao.getAuthor(id);
         
        
        return (new ModelAndView("author")).addObject("authorForm",auth);
    }
    @RequestMapping(value="/author/add", method=RequestMethod.GET)
    public ModelAndView entry(){
         Author auth = new Author();
         ModelAndView mv = new ModelAndView("author");
         mv.addObject("soru","save");
        
        mv.addObject("authorForm",auth);
        return mv;
    }
    @RequestMapping("/author/{id}")
    public ModelAndView detail(@PathVariable int id) throws EZException{
         try{
         if(cdao==null) 
             cdao = new AuthorDAO(DB.getConnection());
        }catch(EZException ex){
            
        }
         Author auth = cdao.getAuthor(id);
          
         return (new ModelAndView("author")).addObject("auth",auth);
         
    } 
    @RequestMapping(value="/author/save", method=RequestMethod.POST)
    public String update(@ModelAttribute("authorForm")Author auth)  {
        try{
         if(cdao==null) 
             cdao = new AuthorDAO(DB.getConnection());
        }catch(EZException ex){
            
        }
         try{
            if(auth.getAuthorId()==0){
                cdao.saveAuthor(auth);
            }else{
                cdao.updateAuthor(auth);
            }
            
         }catch(EZException  ex){
             
         }finally{
              return "redirect:/authors";
            
         } 
         
    }
 
}
