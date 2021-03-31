package com.kaltok.gogobest.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class HelloController {

    @GetMapping("hello")
    fun Hello(model: Model): String {
        model.addAttribute("data", "kaltok84")
        return "hello";
    }

    @GetMapping("hello-mvc")
    fun helloMvc(@RequestParam(value="name") name: String, model: Model): String {
        model.addAttribute("name", name)
        return "hello-template";
    }

}