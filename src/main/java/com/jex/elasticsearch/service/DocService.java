
package com.jex.elasticsearch.service;


import com.jex.elasticsearch.entity.Doc;
import org.springframework.data.domain.Page;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Jex
 * @date 2020年05月27日
 *
 */
public interface DocService {

    void save(Doc doc);

    void saveAll(List<Doc> list);

    Iterator<Doc> findAll();

    Page<Doc> findByFirstCode(String firstCode);

    Page<Doc> findBySecondCode(String secorndCode);

    Page<Doc> query(String key);

}
