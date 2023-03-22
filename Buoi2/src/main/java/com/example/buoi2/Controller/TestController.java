package com.example.buoi2.Controller;

import com.example.buoi2.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class TestController {
    @RequestMapping("/home")
    public String index(Model model) {
        model.addAttribute("string", "Hello World");
        // model.addAttribute("bien","Hello World 2");
        Student student = new Student("1", "Tuan");
        Student student1 = new Student("2", "Hai");
        // model.addAttribute("bien",student.toString());
        model.addAttribute("student", student);


        List<Student> list = new LinkedList<>();
        list.add(student);
        list.add(student1);

        model.addAttribute("list", list);

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("abc", "Spring");

        return "index";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(@RequestParam("search") String search,@RequestParam("search1") String search1, Model model) {

        model.addAttribute("search", search);
        model.addAttribute("search1", search1);
        return "about";
    }
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test(@ModelAttribute Student student,Model model){
        model.addAttribute("student",student);
        return "test";
    }
}
