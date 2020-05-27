package com.jex.elasticsearch;


import com.jex.elasticsearch.dao.DocRepository;
import com.jex.elasticsearch.entity.Doc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DocTests {

	@Autowired
	private DocRepository docRepository;

	@Test
	public void init() {
		List<Doc> list = new ArrayList<Doc>();
		list.add(new Doc(1L, "JEX0197", "JEX8064", "Code Review的主要目的是始终保证随着时间的推移，谷歌代码越来越健康", 1));
		list.add(new Doc(2L, "JEX0211", "JEX7478", "所有Code Review的工具和流程也是针对于此设计的", 1));
		list.add(new Doc(3L, "JEX0258", "JEX8098", "会对关键字分词后进行搜索:谷歌中国", 1));
		docRepository.saveAll(list);
	}

	@Test
	public void all() {

		Iterable<Doc> search = docRepository.findAll();
		Iterator<Doc> iterator = search.iterator();
		while (iterator.hasNext()) {
			Doc next = iterator.next();
			System.out.println(next);
		}
	}


	@Test
	public void findByContent() {
		Pageable pageable = PageRequest.of(0, 10);
		Page<Doc> search = docRepository.findByContent("关键字分词", pageable);
		if(search.hasContent()) {
			for (Doc doc:search.getContent()) {
				System.out.println(doc);
			}
		}
	}


	@Test
	public void findByFirstCode() {
		Pageable pageable = PageRequest.of(0, 10);
		Page<Doc> search = docRepository.findByFirstCode("JEX0258", pageable);
		if(search.hasContent()) {
			for (Doc doc:search.getContent()) {
				System.out.println(doc);
			}
		}
	}
}

