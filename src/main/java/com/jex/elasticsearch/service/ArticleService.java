package com.jex.elasticsearch.service;

import com.jex.elasticsearch.dao.ArticleRepository;
import com.jex.elasticsearch.entity.Article;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;

/**
 * @author jex
 * @date 2020/5/21 23:07
 */

public interface ArticleService {



    /**
     * 存储文章到es中
     */
     void saveArticle() ;


       Article createArticle(String title, String content) ;


    /**
     * 根据Id查询
     */
    void findArticleById() ;


    /**
     * 根据关键字在文章title中进行搜索
     * 分词
     */
    void findArticleByTitle() ;


    /**
     * 根据关键字在文章title中进行搜索
     * 全匹配
     */
    void findArticleByTitle2() ;


    /**
     * 根据关键字在文章title中进行搜索
     * 分页+排序
     * es应尽量避免深层分页
     */
    void findArticleByTitlePage() ;

    /**
     * 删除所有
     */
    void deleteAllArticle();


}
