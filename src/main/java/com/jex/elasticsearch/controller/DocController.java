package com.jex.elasticsearch.controller;


import com.jex.elasticsearch.entity.Doc;
import com.jex.elasticsearch.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Jex
 * @date 2020年05月27日
 *
 */
@RestController
@RequestMapping("/search/doc")
public class DocController {

    @Autowired
    private DocService docService;

    @GetMapping("/init")
    public void init(){

        List<Doc> list =new ArrayList<Doc>();
        list.add(new Doc(1L,"XX0193","XX8064","xxxxxx",1));
        list.add(new Doc(2L,"XX0210","XX7475","xxxxxxxxxx",1));
        list.add(new Doc(3L,"XX0257","XX8097","xxxxxxxxxxxxxxxxxx",1));
        docService.saveAll(list);

    }

    @GetMapping("/all")
    public Iterator<Doc> all(){
        return docService.findAll();
    }

}
