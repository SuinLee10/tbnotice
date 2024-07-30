package com.example.tbnotice.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tbnotice")
@Controller
public class TbnoticePageController {
    @GetMapping("/{page}")
    public String page(@PathVariable String page){return "tbnotice/" + page;}

}
