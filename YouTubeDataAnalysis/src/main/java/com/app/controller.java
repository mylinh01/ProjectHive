package com.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {
    @GetMapping("/ratings")
    public String index(){
        return "ratings";
    }

    @GetMapping("/categories")
    public String count(){
        return "noOfCategories";
    }

    @GetMapping("/top10")
    public String sale(){
        return "top10engaging";
    }
}
