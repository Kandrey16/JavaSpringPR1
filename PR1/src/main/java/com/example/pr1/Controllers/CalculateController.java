package com.example.pr1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {

    @GetMapping("/calculate")
    public String showCalculator() {
        return "calculate";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam(name = "number1", defaultValue = "number1") double number1,
            @RequestParam(name = "number2", defaultValue= "number2") double number2,
            @RequestParam(name = "operator", defaultValue = "+") String operator,
            Model model
    ) {
        double result = MathOperation(number1, number2, operator);
        model.addAttribute("result", result);
        return "calculate";
    }

    private double MathOperation(double number1, double number2, String operator) {
        switch (operator) {
            case "+" -> {
                return number1 + number2;
            }
            case "-" -> {
                return number1 - number2;
            }
            case "*" -> {
                return number1 * number2;
            }
            case "/" -> {
                if (number2 != 0) {
                    return number1 / number2;
                } else {
                    throw new IllegalArgumentException("Деление на ноль недопустимо.");
                }
            }
            default -> throw new IllegalArgumentException("Неверный оператор: " + operator);
        }
    }
}
