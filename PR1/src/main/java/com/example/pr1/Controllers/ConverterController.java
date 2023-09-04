package com.example.pr1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {

    @GetMapping("/converter")
    public String showConverter() {
        return "converter";
    }

    @GetMapping
    public String goToConverter() {
        return "converter";
    }

    @PostMapping("/converter")
    public String convert(
            @RequestParam(name = "currency1", defaultValue = "currency1") double currency1,
            @RequestParam(name = "currency2", defaultValue = "currency2") double currency2,
            @RequestParam(name = "number", defaultValue = "number") double number,
            Model model
    ) {
        double result = number * (currency2 / currency1);
        model.addAttribute("result", result);
        return "converter";
    }
}
