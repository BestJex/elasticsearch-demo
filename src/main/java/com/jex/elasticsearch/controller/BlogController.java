package com.jex.elasticsearch.controller;

import com.jex.elasticsearch.entity.Blog;
import com.jex.elasticsearch.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/search/blog")
@RestController
public class BlogController {


    @Autowired
    private BlogService blogService;

    @GetMapping(value = "search/q")
    public Map<String,Object> add(String q, Pageable pageable){
        //使用queryStringQuery完成单字符串查询
        Page<Blog> search = blogService.search(q, q, pageable);
        Map<String, Object> map = new HashMap<>();
        map.put("data",search);
        return map;
    }
}