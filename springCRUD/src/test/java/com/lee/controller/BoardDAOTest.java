package com.lee.controller;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.lee.domain.BoardVO;
import com.lee.domain.Criteria;
import com.lee.domain.SearchCriteria;
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
//		vo.setTitle("테스트1");
//		vo.setContent("테스트1");
//		vo.setWriter("user00");
//		
//		dao.create(vo);
//	}
	
//	@Test
//	public void testListAll() throws Exception {
//		List<BoardVO> list = dao.listAll();
//		
//		for(BoardVO boardVO : list) {
//			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
//		}
//	}
//	@Test
//	public void testListCriteria() throws Exception {
//		Criteria cri = new Criteria();
//		cri.setPage(2);
//		cri.setPerPageNum(20);
//		
//		List<BoardVO> list = dao.listCriteria(cri);
//		
//		for(BoardVO boardVO : list)
//			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
//	}
	
//	@Test
//	public void testURI() throws Exception {
//		UriComponents uriComponents =
//				UriComponentsBuilder.newInstance()
//				.path("/{module}/{page}")
//				.queryParam("bno", 12)
//				.queryParam("perPageNum", 20)
//				.build()
//				.expand("board", "read")
//				.encode();
//		
//		logger.info("/board/read?bno=12&perPageNum=20");
//		logger.info(uriComponents.toString());
//	}
	
	@Test
	public void testDynamic1() throws Exception {
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setKeyword("제목");
		cri.setSearchType("t");
		
		logger.info("===============================");
		
		List<BoardVO> list = dao.listSearch(cri);
		
		for(BoardVO board : list) {
			logger.info(board.getBno() + ": " + board.getTitle());
		}
		
		logger.info("================================");
		logger.info("COUNT: " + dao.listSearchCount(cri));
	}
}
