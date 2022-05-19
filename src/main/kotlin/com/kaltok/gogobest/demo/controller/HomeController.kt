package com.kaltok.gogobest.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    @GetMapping("/")
    fun home(): String {
        return "home"
    }

    @GetMapping("/map")
    fun map():String{
        return "map"
    }
}