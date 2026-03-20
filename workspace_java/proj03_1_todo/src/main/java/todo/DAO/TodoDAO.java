package todo.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// DAO : Data Access Object
public class TodoDAO {

	// todo 테이블의 모든 항목을 돌려주는 메소드
	// 메소드명: selectAll
	// 전달인자: 없음
	// 리턴타입: List
	
	public List selectAll() {
		
		List list = new ArrayList();
		
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
			String query = "select * from todo";
			ps = conn.prepareStatement(query);

			// SQL 실행 및 결과 확보
			rs = ps.executeQuery();
			

			// 결과 활용
			while (rs.next()) {
				
				int todo_id = rs.getInt("todo_id");
				Date duedate = rs.getDate("duedate");
				int done = rs.getInt("done");
				String content = rs.getString("content");
				Date ctime = rs.getDate("ctime");
				
				Map map = new HashMap();
				map.put("todo_id", todo_id);
				map.put("duedate", duedate);
				map.put("done", done);
				map.put("content", content);
				map.put("ctime", ctime);
				
				list.add(map);
			
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
	
}
