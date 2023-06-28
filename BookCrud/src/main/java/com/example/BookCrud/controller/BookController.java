package com.example.BookCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import com.example.BookCrud.domain.Book;
import com.example.BookCrud.service.BookService;


@Controller
public class BookController {
	
    @Autowired
    private BookService service;
    
    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Book> listbook = service.listAll();
        model.addAttribute("listbook", listbook);
        System.out.print("Get / ");    
        return "index";
    }
    
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "add";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") Book b) {
        service.save(b);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("add");
        Book b = service.get(id);
        mav.addObject("book", b);
        return mav;
        
    }
    @RequestMapping("/delete/{id}")
    public String deletebook(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
	
}
