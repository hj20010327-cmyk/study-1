package coupang.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import coupang.DTO.CoupangDTO;

public class CoupangDAO {

	public List<CoupangDTO> selectAll() {

		List<CoupangDTO> list = new ArrayList();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// JNDI 방식
			// context.xml에 있는 DB 정보로 커넥션 풀을 가져온다
			Context ctx = new InitialContext();
			// DataSource : 커넥션 풀 관리자
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			// DB 접속(그런데 이제 커넥션 풀로)
			conn = dataFactory.getConnection();

			// SQL 준비
			String query = "select * from product";
			ps = conn.prepareStatement(query);

			// SQL 실행 및 결과 확보
			rs = ps.executeQuery();

			while (rs.next()) {

				int product_id = rs.getInt("product_id");
				String product_name = rs.getString("product_name");
				int product_price = rs.getInt("product_price");

				CoupangDTO coupangDTO = new CoupangDTO();

				coupangDTO.setProduct_id(product_id);
				coupangDTO.setProduct_name(product_name);
				coupangDTO.setProduct_price(product_price);

				list.add(coupangDTO);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return list;
	}

	public int coupangInsert(CoupangDTO coupangDTO) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = -1;

		try {
			Context ctx = new InitialContext();
			// DataSource : 커넥션 풀 관리자
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			// 1. DB 접속
			conn = dataFactory.getConnection();
			// 2. SQL 준비
			String query = "insert into product" + " values (seq_todo.nextval, ?, ?)"; // 변수 방식
			ps = conn.prepareStatement(query);
			ps.setString(1, coupangDTO.getProduct_name());
			ps.setInt(2, coupangDTO.getProduct_price());

			// 3. 실행 및 결과 확보
			rs = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}

		return rs;
	}

	public int coupangModify(CoupangDTO coupangDTO) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = -1;

		try {
			Context ctx = new InitialContext();
			// DataSource : 커넥션 풀 관리자
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			// 1. DB 접속
			conn = dataFactory.getConnection();
			// 2. SQL 준비
			String query = "update product set product_name=?," + " product_price=? where product_id=?"; // 변수 방식
			ps = conn.prepareStatement(query);
			ps.setString(1, coupangDTO.getProduct_name());
			ps.setInt(2, coupangDTO.getProduct_price());
			ps.setInt(3, coupangDTO.getProduct_id());

			// 3. 실행 및 결과 확보
			rs = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}

		return rs;
	}

	public CoupangDTO selectOne(int product_id) {
		CoupangDTO coupangDTO = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			conn = dataFactory.getConnection();

			String query = "select * from product where product_id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, product_id);

			rs = ps.executeQuery();

			if (rs.next()) {
				coupangDTO = new CoupangDTO();
				coupangDTO.setProduct_id(rs.getInt("product_id"));
				coupangDTO.setProduct_name(rs.getString("product_name"));
				coupangDTO.setProduct_price(rs.getInt("product_price"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return coupangDTO;
	}

	public int coupangDelete(int product_id) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = -1;

		try {
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			conn = dataFactory.getConnection();

			String query = "delete from product where product_id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, product_id);

			rs = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return rs;
	}
}
