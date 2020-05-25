package com.jex.elasticsearch;


import com.jex.elasticsearch.dao.RequestLogRepository;
import com.jex.elasticsearch.entity.RequestLog;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;
import java.util.*;

/**
 * 
 * @author Jex
 * @date 2020年05月25日
 * 
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestLogTests {

    @Resource
    private RequestLogRepository requestLogRepository ;


    @Test
    public void esInsert() {
        int num = 100;
        for (int i = 0 ; i < num ; i++){
            RequestLog requestLog = new RequestLog() ;
            requestLog.setId(System.currentTimeMillis());
            requestLog.setOrderNo(String.valueOf(System.currentTimeMillis()));
            requestLog.setUserId("userId"+i);
            requestLog.setUserName("张三"+i);
            requestLog.setCreateTime(new Date().toString());
            requestLogRepository.save(requestLog) ;
            System.out.println(requestLog.getId());
        }

    }


    @Test
    public void esFindAll (){

        Iterable<RequestLog> search = requestLogRepository.findAll();
        Iterator<RequestLog> iterator = search.iterator();
        while (iterator.hasNext()) {
            System.out.println("--> 数据：" + iterator.next());
        }
    }


    @Test
    public void esUpdateById() {

        RequestLog requestLog = new RequestLog();
        requestLog.setId(System.currentTimeMillis());
        requestLog.setOrderNo(String.valueOf(System.currentTimeMillis()));
        requestLog.setUserId("userId11");
        requestLog.setUserName("李四");
        requestLog.setCreateTime(new Date().toString());
        requestLogRepository.save(requestLog);
        System.out.println(requestLog.getId());
    }



    @Test
    public void esSelectById() {
        Long id = Long.valueOf(11);
        System.out.println(requestLogRepository.findById(String.valueOf(id))) ;
    }


    @Test
    public void esFindOrder() {
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

        Iterable<RequestLog> search = requestLogRepository.findAll(orders);
        Iterator<RequestLog> iterator = search.iterator();
        while (iterator.hasNext()) {
            System.out.println("--> 数据：" + iterator.next());
        }
    }


    @Test
    public void esFindOrders() {
        List<Sort.Order> sortList = new ArrayList<>() ;
        Sort.Order sort1 = new Sort.Order(Sort.Direction.ASC,"createTime.keyword") ;
        Sort.Order sort2 = new Sort.Order(Sort.Direction.DESC,"userName.keyword") ;
        sortList.add(sort1) ;
        sortList.add(sort2) ;
        Sort orders = Sort.by(sortList) ;


        Iterable<RequestLog> search = requestLogRepository.findAll(orders);
        Iterator<RequestLog> iterator = search.iterator();
        while (iterator.hasNext()) {
            System.out.println("--> 数据：" + iterator.next());
        }
    }


    @Test
    public void search() {
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

        Iterable<RequestLog> search = requestLogRepository.search(builder);
        Iterator<RequestLog> iterator = search.iterator();
        while (iterator.hasNext()) {
            System.out.println("--> 数据：" + iterator.next());
        }
    }
}