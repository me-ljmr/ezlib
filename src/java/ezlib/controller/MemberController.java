/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ezlib.controller;

import ezlib.beans.Author;
import ezlib.beans.Book;
import ezlib.beans.Category;
import ezlib.beans.Member;
import ezlib.beans.Publisher;
import ezlib.data.AuthorDAO;
import ezlib.data.BookDAO;
import ezlib.data.CategoryDAO;
import ezlib.data.DB;
import ezlib.data.DbQueries;
import ezlib.data.MemberDAO;
import ezlib.data.PublisherDAO;
import ezlib.exception.EZException;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SAUMIL
 */
@Controller
public class MemberController {

    MemberDAO mdao;

    public MemberController() throws EZException {
        mdao = new MemberDAO(DB.getConnection());

    }

    @RequestMapping("/members")
    public ModelAndView index() throws EZException {

        mdao = new MemberDAO(DB.getConnection());

        List<Member> members = mdao.getMembers();
        mdao = null;
        return (new ModelAndView("members")).addObject("members", members);
    }

    @RequestMapping("/member/add")
    public ModelAndView memberAdd() {
        Member m = new Member();
        return (new ModelAndView("addMember")).addObject("addMemberCommand", m);

    }

    @RequestMapping(value = "/member/save", method = RequestMethod.POST)
    public ModelAndView insertMember(@ModelAttribute("addMemberCommand") Member member) throws EZException {
        System.out.println("nsdkjfbsjdbfjs%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        mdao = new MemberDAO(DB.getConnection());

        try {
            mdao.insertMember(member);
        } catch (EZException ex) {
            ex.getMessage();
        }
        return new ModelAndView("redirect:/members");
    }

}
