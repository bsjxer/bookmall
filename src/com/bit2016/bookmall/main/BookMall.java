package com.bit2016.bookmall.main;

public class BookMall {

	public static void main(String[] args) {
			
		CategoryDao dao = new CategoryDao();
		List<CategoryVo> list = dao.getList();
		for(CategoryVo vo : list){
			System.out.println(vo);
		}
	}

}
