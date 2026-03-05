package it.mat.hello_world.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("other") //tutte le richieste che iniziano con model vengono gestite da questo controller
public class ModelController {

    @GetMapping("fixed")
    public ModelAndView handlerFixed(){
        return new ModelAndView("hello-world-model").addObject("maker", "A. Trentini");
    }
    
}
