package com.bit2016.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit2016.bookmall.vo.Order_bookVo;



public class Order_bookDao {
	private Connection getConnection() throws SQLException { // -> 회피하는 이유. 메소드를
		// 콜 하는 곳에서
		// SQLException을
		// 처리 하고 있음
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "bitdb", "bitdb");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		return conn;
	}

	public boolean update(Order_bookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = getConnection();

			String sql = "update order_book set order_no = ?, book_no = ?, amount = ? where no = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getOrder_no());
			pstmt.setLong(2, vo.getBook_no());
			pstmt.setLong(3, vo.getAmount());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}

		return result == 1;
	}

	public boolean delete(Long no) { // -> 비지니스 요구 조건에 따라 번호(primary key가 주),이름
		// 등등으로 지울 수 있다.
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = getConnection();

			String sql = "delete from Order_book where no = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, no);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}

		return result == 1;
	}

	public List<Order_bookVo> getList() {
		List<Order_bookVo> list = new ArrayList<Order_bookVo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			stmt = conn.createStatement();

			String sql = "select order_no, book_no, amount from cart order by no asc";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long order_no = rs.getLong(1);
				Long book_no = rs.getLong(2);
				Long amount = rs.getLong(3);

				Order_bookVo vo = new Order_bookVo();
				vo.setOrder_no(order_no);
				vo.setBook_no(book_no);
				vo.setAmount(amount);

				list.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println("error:" + ex);
			}
		}

		return list;
	}

	public boolean insert(Order_bookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = getConnection();

			String sql = "insert into Order_book values( ?, ?, ? )";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getOrder_no());
			pstmt.setLong(2, vo.getBook_no());
			pstmt.setLong(3, vo.getAmount());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				// 3. 자원정리
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result == 1;
	}
}
