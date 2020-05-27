package com.jex.elasticsearch;


import com.jex.elasticsearch.dao.BlogRepository;
import com.jex.elasticsearch.entity.Blog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;


/**
 * 
 * @author Jex
 * @date 2020年05月25日
 * 
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogTests {

    @Resource
    private BlogRepository blogRepository;


    @Test
    public void testInsert() {
        int num = 100;
        for (int i = 0; i < num; i++) {
            Blog blog = new Blog();
            blog.setId(System.currentTimeMillis());
            blog.setUid("uuid" + String.valueOf(System.currentTimeMillis()));
            blog.setTitle("标题" + i);
            blog.setContent("内容" + i);
            blog.setCreateDate(new Date());
            blog.setUpdateDate(new Date());
            System.out.println(blog.getId());
            blogRepository.save(blog);
        }
    }


    @Test
    public void testSearchByTitleAndContent() {
        String title = "标题";
        String content = "内容";
        PageRequest pageRequest = PageRequest.of(1, 5);
        Page<Blog> search = blogRepository.findByTitleLikeOrContentLike(title,content,pageRequest);
        if(search.hasContent()) {
            for (Blog blog:search.getContent()) {
                System.out.println("数据" + blog);
            }
        }
    }


    @Test
    public void testSearchByContent() {

        String content = "内容";
        PageRequest pageRequest = PageRequest.of(1, 5);
        Page<Blog> search = blogRepository.findByContentLike(content,pageRequest);
        if(search.hasContent()) {
            for (Blog blog:search.getContent()) {
                System.out.println("数据" + blog);
            }
        }
    }


    @Test
    public void findAll() {
        PageRequest pageRequest = PageRequest.of(1, 20);
        Page<Blog> search = blogRepository.findAll(pageRequest);
        if(search.hasContent()) {
            for (Blog blog:search.getContent()) {
                System.out.println("数据" + blog);
            }
        }
    }
}