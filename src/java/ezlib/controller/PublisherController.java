/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.controller;

import ezlib.beans.Author;
import ezlib.beans.Publisher;
import ezlib.data.CategoryDAO;
import ezlib.data.DB;
import ezlib.data.DbQueries;
import ezlib.data.PublisherDAO;
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
public class PublisherController {
    DbQueries dbq ;
    
     PublisherDAO pdao;
    
    
    @RequestMapping("/publishers") 
    public ModelAndView index() throws EZException{ 
            pdao = new PublisherDAO(DB.getConnection());
      
        List<Publisher> pubs = pdao.getPublishers();
         
        return (new ModelAndView("publishers")).addObject("pubs", pubs);
    }
    @RequestMapping("/publisher/add")
    public ModelAndView add(){
         
        Publisher pub = new Publisher();
        return (new ModelAndView("addPublisher")).addObject("publisherForm",pub);
    }
    @RequestMapping("/publisher/{id}")
    public ModelAndView detail(@PathVariable int id){
         Publisher pub = pdao.getPublisher(id);
         return (new ModelAndView("publisher")).addObject("publisherForm",pub);
         
    } 
    @RequestMapping(value="/publisher/update", method=RequestMethod.POST)
    public ModelAndView update(@ModelAttribute("pub")Publisher pub){
          try{
            pdao.updatePublisher(pub);
         }catch(EZException ex){
             
         }
        return new ModelAndView("redirect:/publishers");
    }
    @RequestMapping(value="/publisher/save", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("publisherForm")Publisher pub){
        
         try{
            pdao.savePublisher(pub);
         }catch(EZException ex){
             
         }
        return new ModelAndView("redirect:/publishers");
    }
}
