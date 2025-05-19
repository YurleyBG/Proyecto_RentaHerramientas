package com.example.jyv_tool.Infraestructure.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

@Controller
public class HtmlController {
    @GetMapping("/Home")
    public String index(Model model) {
        return "perfil"; 
    }
}
