package com.example.jyv_tool.Demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DemoController {

    @PostMapping(value="demo")
    public String Welcome() {
        return "Welcome";
    }
    

}
