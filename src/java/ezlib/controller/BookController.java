/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.controller;

import ezlib.beans.Book;
import ezlib.beans.*;
import ezlib.data.AuthorDAO;
import ezlib.data.BookDAO;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SAUMIL
 */
@Controller
public class BookController {

    DbQueries dbq;
    BookDAO bdao;
    CategoryDAO cdao;
    PublisherDAO pdao;
    AuthorDAO adao;
    
    @RequestMapping("/books") 
    public ModelAndView getBooks() throws EZException{        
         bdao = new BookDAO(DB.getConnection());
        List<Book> book = bdao.getBooks();
        bdao=null;
        return (new ModelAndView("books")).addObject("books", book);

    }

    @RequestMapping("/addBook")
    public ModelAndView index() throws EZException {
        bdao = new BookDAO(DB.getConnection());
        pdao = new PublisherDAO(DB.getConnection());
        adao = new AuthorDAO(DB.getConnection());
        cdao = new CategoryDAO(DB.getConnection());
        ModelAndView modelandview = new ModelAndView("addBook");

        dbq = null;
        dbq = new DbQueries();
        Book b = new Book();
        List<Category> cats = cdao.getCategories();
        List<Publisher> pubs = pdao.getPublishers();
        List<Author> aut = adao.getAuthors();

        modelandview.addObject("addBookCommand", b);

        modelandview.addObject("cats", cats);
        modelandview.addObject("pubs", pubs);
        modelandview.addObject("aut", aut);

        return modelandview;
    }
    
     
    
    @RequestMapping("/book/{isbn}")
    public ModelAndView detail(@PathVariable String isbn) throws EZException{
         
        
         
         bdao = new BookDAO(DB.getConnection());
        pdao = new PublisherDAO(DB.getConnection());
        adao = new AuthorDAO(DB.getConnection());
        cdao = new CategoryDAO(DB.getConnection());
        ModelAndView modelandview = new ModelAndView("book");

       
       Book book = bdao.getBook(isbn);
        List<Category> cats = cdao.getCategories();
        List<Publisher> pubs = pdao.getPublishers();
        List<Author> aut = adao.getAuthors();

        modelandview.addObject("updateBookCommand", book);

        modelandview.addObject("cats", cats);
        modelandview.addObject("pubs", pubs);
        modelandview.addObject("aut", aut);
        
        System.out.println("in book deyails");
         
        return modelandview; 
    } 
    
    @RequestMapping(value="/book/updateBook", method=RequestMethod.POST)
    public ModelAndView update(@ModelAttribute("updateBookCommand")Book book) throws EZException{
       System.out.println("in   )))))update book");
        bdao = new BookDAO(DB.getConnection());
 
        try{
            bdao.updateBook(book);
         }catch(EZException ex){
             
         }
        return new ModelAndView("redirect:/books");
    }
    
    

    @RequestMapping(value = "/saveBook", method = RequestMethod.POST)
    public ModelAndView insertBook(@ModelAttribute("addBookCommand") Book book) throws EZException {
        bdao = new BookDAO(DB.getConnection());

        try {
            bdao.insertBook(book);
        } catch (EZException ex) {
            ex.getMessage();
        }
        return new ModelAndView("redirect:/books");
    }

}
