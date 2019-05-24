package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

public class HomeController {
    @Controller
    public class HomeController {
        @Autowired
        carRepository carRepository;

        @RequestMapping("/")
        public String listCourse(Model model){
            model.addAttribute("cars", carRepository.findAll());
            return "list";
        }
        @GetMapping("/add")
        public String courseForm(Model model){
            model.addAttribute("cars", new Cars());
            return "carform";
        }
        @PostMapping("/process")
        public String processForm(@Valid Cars car,
                                  BindingResult result) {
            if (result.hasErrors()) {
                return "carform";
            }
            carRepository.save(car);
            return "redirect:/";
        }
        @RequestMapping("/detail/{year}")
        public String showCourse (@PathVariable("year") long year, Model model) {
            model.addAttribute("car", carRepository.findByYear(year).get());
            return "show";
        }
        @RequestMapping("/update/{year}")
        public String updateCourse(@PathVariable("year") long year, Model model){
            model.addAttribute("car", carRepository.findBYear(year).get());
            return "courseform";
        }
        @RequestMapping("/delete/{year}")
        public String delCourse(@PathVariable("year") long year){
            carRepository.deleteByYear(year);
            return "redirect:/";
        }
    }
}
