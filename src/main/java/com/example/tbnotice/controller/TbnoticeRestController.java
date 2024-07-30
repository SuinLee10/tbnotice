package com.example.tbnotice.controller;

import com.example.tbnotice.service.TbnoticeService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/tbnotice")
@RestController
public class TbnoticeRestController {
    TbnoticeService tbnoticeService;

    public TbnoticeRestController(
            TbnoticeService tbnoticeService
    ){
        this.tbnoticeService = tbnoticeService;
    }
    @RequestMapping("/create")
    public Map<String, Object> create(@RequestParam String title, @RequestParam String cate, @RequestParam String content){
        Map<String, Object> tbnotice = new HashMap<>();
        tbnotice.put("title", title);
        tbnotice.put("cate", cate);
        tbnotice.put("content", content);

        return tbnoticeService.create(tbnotice);
    }

    @GetMapping("/list")
    public Map<String, Object> list() {
        return tbnoticeService.list();
    }

    @GetMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable String id) {
        return tbnoticeService.detail(id);
    }
    @GetMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> params) {
        return tbnoticeService.update(params);
    }
    @GetMapping("/delete")
    public Map<String, Object> delete(@RequestParam Map<String, Object> params) {
        return tbnoticeService.delete(params.get("id") + "");
    }

}
