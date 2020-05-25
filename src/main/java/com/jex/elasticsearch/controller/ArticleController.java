package com.jex.elasticsearch.controller;

import com.jex.elasticsearch.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jex
 * @date 2020/5/21 23:11
 */
@RestController(value = "/search/article")
public class ArticleController {
    @Autowired
    private ArticleService testService;
    @GetMapping("/save")
    public void save(){
        testService.saveArticle();
    }
}
