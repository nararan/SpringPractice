package com.lee.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lee.domain.BoardVO;
import com.lee.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	@Inject
	private BoardDAO dao;
	
	@Test
	public void testCreate() throws Exception {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("�׽�Ʈ1");
		vo.setContent("�׽�Ʈ1");
		vo.setWriter("user00");
		
		dao.create(vo);
	}
}
