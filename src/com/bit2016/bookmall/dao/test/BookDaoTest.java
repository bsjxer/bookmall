package com.bit2016.bookmall.dao.test;

import com.bit2016.bookmall.dao.BookDao;
import com.bit2016.bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		insertTest();
	}
	
	public static void insertTest() {
		BookDao dao = new BookDao();
		
		BookVo vo1 = new BookVo();
		vo1.setTitle("종이여자");
		vo1.setPrice(18000L);
		vo1.setCategory_no(1L);
		dao.insert(vo1);
		
		BookVo vo2 = new BookVo();
		vo2.setTitle("자바의신");
		vo2.setPrice(30000L);
		vo2.setCategory_no(2L);
		dao.insert(vo2);
		
		BookVo vo3 = new BookVo();
		vo3.setTitle("미비포유");
		vo3.setPrice(16500L);
		vo3.setCategory_no(1L);
		dao.insert(vo3);
	}
}
