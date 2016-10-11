package com.bit2016.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit2016.bookmall.vo.CustomerVo;
import com.bit2016.bookmall.vo.OrderVo;


public class OrderDao {
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

	public boolean update(OrderVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = getConnection();

			String sql = "update book set orderer_name_email = ?, price = ?, destination = ?, customer_no = ? where no = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getOrderer_name_email());
			pstmt.setLong(2, vo.getPrice());
			pstmt.setString(3, vo.getDestination());
			pstmt.setLong(4, vo.getCustomer_no());
			pstmt.setLong(5, vo.getNo());

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

			String sql = "delete from order where no = ?";
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

	public List<OrderVo> getList() {
		List<OrderVo> list = new ArrayList<OrderVo>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			stmt = conn.createStatement();

			String sql = "select no, orderer_name_email, price, destination, customer_no from order order by no asc";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Long no = rs.getLong(1);
				String orderer_name_email = rs.getString(2);
				Long price = rs.getLong(3);
				String destination = rs.getString(4);
				Long customer_no = rs.getLong(5);

				OrderVo vo = new OrderVo();
				vo.setNo(no);
				vo.setOrderer_name_email(orderer_name_email);
				vo.setPrice(price);
				vo.setDestination(destination);
				vo.setCustomer_no(customer_no);

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

	public boolean insert(OrderVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = getConnection();

			String sql = "insert into Book values( Order_seq.nextval, ?, ?, ?, ? )";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getOrderer_name_email());
			pstmt.setLong(2, vo.getPrice());
			pstmt.setString(3, vo.getDestination());
			pstmt.setLong(4, vo.getCustomer_no());

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
