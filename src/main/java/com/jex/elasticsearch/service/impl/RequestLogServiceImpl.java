package com.jex.elasticsearch.service.impl;

import com.jex.elasticsearch.dao.RequestLogRepository;
import com.jex.elasticsearch.entity.RequestLog;
import com.jex.elasticsearch.service.RequestLogService;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jex
 * @date 2020年05月25日
 *
 */
@Service
public class RequestLogServiceImpl implements RequestLogService {
    @Resource
    private RequestLogRepository requestLogRepository ;
    @Override
    public String esInsert(Integer num) {
        for (int i = 0 ; i < num ; i++){
            RequestLog requestLog = new RequestLog() ;
            requestLog.setId(System.currentTimeMillis());
            requestLog.setOrderNo(String.valueOf(System.currentTimeMillis()));
            requestLog.setUserId("userId"+i);
            requestLog.setUserName("张三"+i);
            requestLog.setCreateTime(new Date().toString());
            requestLogRepository.save(requestLog) ;
        }
        return "success" ;
    }
    @Override
    public Iterable<RequestLog> esFindAll (){
        return requestLogRepository.findAll() ;
    }
    @Override
    public String esUpdateById(RequestLog requestLog) {
        requestLogRepository.save(requestLog);
        return "success" ;
    }
    @Override
    public Optional<RequestLog> esSelectById(Long id) {
        return requestLogRepository.findById(String.valueOf(id)) ;
    }
    @Override
    public Iterable<RequestLog> esFindOrder() {
        // 用户名倒序
        // Sort sort = new Sort(Sort.Direction.DESC,"userName.keyword") ;
        // 创建时间正序
//        Sort sort = new Sort(Sort.Direction.ASC,"createTime.keyword") ;
//        return requestLogRepository.findAll(sort) ;
        //springBoot2.2.1（含）以上的版本Sort已经不能再实例化了，构造方法已经是私有的了！,故采用以下方法 Sort.by
        List<Sort.Order> sortList = new ArrayList<>() ;
        // 创建时间正序
        Sort.Order sort1 = new Sort.Order(Sort.Direction.ASC,"createTime.keyword") ;
        // 用户名倒序
        Sort.Order sort2 = new Sort.Order(Sort.Direction.DESC,"userName.keyword") ;
        sortList.add(sort1) ;
        sortList.add(sort2) ;
        Sort orders = Sort.by(sortList) ;
        return requestLogRepository.findAll(orders) ;
    }


    @Override
    public Iterable<RequestLog> esFindOrders() {
        List<Sort.Order> sortList = new ArrayList<>() ;
        Sort.Order sort1 = new Sort.Order(Sort.Direction.ASC,"createTime.keyword") ;
        Sort.Order sort2 = new Sort.Order(Sort.Direction.DESC,"userName.keyword") ;
        sortList.add(sort1) ;
        sortList.add(sort2) ;
        Sort orders = Sort.by(sortList) ;
        return requestLogRepository.findAll(orders) ;
    }
    @Override
    public Iterable<RequestLog> search() {
        // 全文搜索关键字
        /*
        String queryString="张三";
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(queryString);
        requestLogRepository.search(builder) ;
        */
        /*
         * 多条件查询
         */
        QueryBuilder builder = QueryBuilders.boolQuery()
                // .must(QueryBuilders.matchQuery("userName.keyword", "历张")) 搜索不到
                .must(QueryBuilders.matchQuery("userName", "张三")) // 可以搜索
                .must(QueryBuilders.matchQuery("orderNo", "20190613736278243"));
        return requestLogRepository.search(builder) ;
    }
}