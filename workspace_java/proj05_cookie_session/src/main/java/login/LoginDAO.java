package login;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import emp.EmpDTO;

public class LoginDAO {

	public EmpDTO selectMember (EmpDTO dto) {
		EmpDTO resultDTO = null;
		
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
			String query = "select * from emp"
					+ " where empno=? and ename=?";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, dto.getEmpno());
			ps.setString(2, dto.getEname());

			// SQL 실행 및 결과 확보
			rs = ps.executeQuery();

			// 결과 활용
			if (rs.next()) {
				resultDTO = new EmpDTO();
				String ename = rs.getString("ename");
				int sal = rs.getInt("sal");
				
				resultDTO.setJob(rs.getString("job"));
				resultDTO.setEmpno(rs.getInt("empno"));
				
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
		
		return resultDTO;
	}
	
}
