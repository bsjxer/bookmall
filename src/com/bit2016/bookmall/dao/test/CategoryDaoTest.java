package com.bit2016.bookmall.dao.test;

import java.util.List;

import com.bit2016.bookmall.dao.CategoryDao;
import com.bit2016.bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		// insert test
//		insertTest();

//		deleteTest();

		getListTest();

	}

	public static void getListTest() {
		CategoryDao dao = new CategoryDao();
		List<CategoryVo> list = dao.getList();

		System.out.println("========================");
		for (CategoryVo vo : list) {
			// System.out.println( vo.getNo() + ":" + vo.getName() );
			System.out.println(vo);
		}
		System.out.println("========================");
	}

	public static void insertTest() {
		CategoryDao dao = new CategoryDao();

		CategoryVo vo1 = new CategoryVo();
		vo1.setName("소설");
		dao.insert(vo1);

		CategoryVo vo2 = new CategoryVo();
		vo2.setName("컴퓨터/IT");
		dao.insert(vo2);
	}

	public static void updateTest() {

	}

	public static void deleteTest() {
//		CategoryDao dao = new CategoryDao();
//
//		dao.delete(21L);
//		dao.delete(22L);
	}
}
