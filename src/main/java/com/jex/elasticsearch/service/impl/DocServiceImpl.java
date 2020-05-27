package com.jex.elasticsearch.service.impl;


import com.jex.elasticsearch.dao.DocRepository;
import com.jex.elasticsearch.entity.Doc;
import com.jex.elasticsearch.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;


/**
 *
 * @author Jex
 * @date 2020年05月27日
 *
 */
@Service("docService")
public class DocServiceImpl implements DocService {


    @Autowired
    private DocRepository docRepository;

    private Pageable pageable = PageRequest.of(0, 10);



    @Override
    public void save(Doc doc)
    {
        docRepository.save(doc);
    }

    @Override
    public void saveAll(List<Doc> list)
    {
        docRepository.saveAll(list);
    }

    @Override
    public Iterator<Doc> findAll()
    {
        return docRepository.findAll().iterator();
    }


    @Override
    public Page<Doc> findByFirstCode(String firstCode)
    {

         return docRepository.findByContent(firstCode,pageable);
    }

    @Override
    public Page<Doc> findBySecondCode(String secondCode)
    {

        return docRepository.findBySecondCode(secondCode, pageable);
    }

    @Override
    public Page<Doc> query(String key)
    {
        return docRepository.findByContent(key, pageable);
    }

   

}
