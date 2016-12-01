/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.controller;

import ezlib.beans.Author;
import ezlib.beans.Book;
import ezlib.beans.Category;
import ezlib.beans.Publisher;
import ezlib.data.DbQueries;
import ezlib.exception.EZException;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SAUMIL
 */
@Controller
public class BookController  {
    DbQueries dbq ;
    
     @RequestMapping("/addBook") 
    public ModelAndView index(){        
        ModelAndView modelandview  = new ModelAndView("addBook");
      
        dbq = null;
         dbq = new DbQueries();
         Book b=new Book();
        List<Category> cats = dbq.getCategories();
         List<Publisher> pubs = new DbQueries().getPublishers();
        List<Author> aut = new DbQueries().getAuthors();
        
        modelandview.addObject("addBookCommand", b);
        
        modelandview.addObject("cats", cats);
         modelandview.addObject("pubs", pubs);  
                modelandview.addObject("aut", aut);  
  
        return modelandview;
    }
  
   
    
    
    
     @RequestMapping(value="/saveBook", method = RequestMethod.POST) 
    public ModelAndView insertBook(@ModelAttribute("addBookCommand")Book book ){  
        
         dbq = null;
         dbq = new DbQueries();
         try{
            dbq.insertBook(book);
         }catch(EZException ex){
             ex.getMessage();
         }
        return new ModelAndView("redirect:/categories");
    }
    
    
    
     

}
