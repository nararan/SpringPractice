package com.lee.controller;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lee.domain.BoardVO;
import com.lee.domain.Criteria;
import com.lee.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	@Inject
	private BoardDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
//	@Test
//	public void testCreate() throws Exception {
//		BoardVO vo = new BoardVO();
//		
//		vo.setTitle("�׽�Ʈ1");
//		vo.setContent("�׽�Ʈ1");
//		vo.setWriter("user00");
//		
//		dao.create(vo);
//	}
	
//	@Test
//	public void testPaging() throws Exception {
//		int page = 3;
//		
//		List<BoardVO> list = dao.listPage(page);
//		
//		for(BoardVO boardVO : list) {
//			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
//		}
//	}
	@Test
	public void testListCriteria() throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);
		
		List<BoardVO> list = dao.listCriteria(cri);
		
		for(BoardVO boardVO : list)
			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
	}
}