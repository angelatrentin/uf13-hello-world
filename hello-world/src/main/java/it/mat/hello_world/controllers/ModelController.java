package it.mat.hello_world.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("other") //tutte le richieste che iniziano con model vengono gestite da questo controller
public class ModelController {

    @GetMapping("fixed")
    public ModelAndView handlerFixed(){
        return new ModelAndView("hello-world-model").addObject("maker", "A. Trentini");
    }
    
    @GetMapping("query")
    public ModelAndView handlerQuery(@RequestParam (defaultValue = "none") String param){
        return new ModelAndView("hello-world-model").addObject("maker", param);

    }

    @GetMapping("path/{username}")
    public ModelAndView handlerPath (@PathVariable String username) {
        return new ModelAndView("hello-world-model").addObject("maker", username);

    }

    //HANDLER PARTICOLARI CHE NON SI POSSONO FARE DA BROWSER
    //per le seguenti richeiste non è possibile usare un browser, serve un software di terze parti come postman o curl

    @GetMapping(path = "header", headers = "myHeader") //path nelle altre richieste è opzionale, qui è obbligatorio
    public ModelAndView handlerHeader(@RequestHeader (defaultValue = "none") String myHeader) {
        return new ModelAndView("hello-world-header").addObject("header", myHeader);

    }

    @PostMapping ("body")
    public ModelAndView handlerBody (@RequestBody String body) {
        return new ModelAndView("hello-world-body");
    }
}
