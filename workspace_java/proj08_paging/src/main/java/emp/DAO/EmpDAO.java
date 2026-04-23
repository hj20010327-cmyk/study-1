package emp.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import emp.DTO.EmpDTO;

public class EmpDAO {

	public List<EmpDTO> selectAll(EmpDTO empDTO) {

		List<EmpDTO> list = new ArrayList<EmpDTO>();

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
			String query = "SELECT * from("
					+ "	SELECT rownum rnum, e.* FROM ("
					+ "		SELECT emp.* FROM emp"
					+ "		ORDER BY hiredate"
					+ "		) e"
					+ ")"
					+ "WHERE rnum >= ? and rnum <= ?";
//			ps = conn.prepareStatement(query);
			ps = new LoggableStatement(conn,query);
			ps.setInt(1, empDTO.getStart());
			ps.setInt(2, empDTO.getEnd());
			
			System.out.println(  ((LoggableStatement)ps).getQueryString() );

			// SQL 실행 및 결과 확보
			rs = ps.executeQuery();

			// 결과 활용
			while (rs.next()) {
				EmpDTO empDTO1 = new EmpDTO();
				
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				Integer mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				Integer comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");

				
				empDTO1.setEmpno(empno);
				empDTO1.setEname(ename);
				empDTO1.setJob(job);
				empDTO1.setMgr(mgr);
				empDTO1.setHiredate(hiredate);
				empDTO1.setSal(sal);
				empDTO1.setComm(comm);
				empDTO1.setDeptno(deptno);

				list.add(empDTO1);

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

	public List<EmpDTO> orderByempno() {
		List<EmpDTO> list = new ArrayList<EmpDTO>();

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
			String query = "select * from emp order by sal";
			ps = conn.prepareStatement(query);

			// SQL 실행 및 결과 확보
			rs = ps.executeQuery();

			// 결과 활용
			while (rs.next()) {

				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				Integer mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				Integer comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");

				EmpDTO empDTO = new EmpDTO();
				empDTO.setEmpno(empno);
				empDTO.setEname(ename);
				empDTO.setJob(job);
				empDTO.setMgr(mgr);
				empDTO.setHiredate(hiredate);
				empDTO.setSal(sal);
				empDTO.setComm(comm);
				empDTO.setDeptno(deptno);

				list.add(empDTO);

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
	
	public int selectEmpTotal() {
		int totalCount = 0;
		
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
			String query = "SELECT count(*) cnt FROM emp";
			ps = conn.prepareStatement(query);


			// SQL 실행 및 결과 확보
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				EmpDTO dto = new EmpDTO();
				
				totalCount = rs.getInt("cnt");
				
				
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
		
		return totalCount;
	}

}
