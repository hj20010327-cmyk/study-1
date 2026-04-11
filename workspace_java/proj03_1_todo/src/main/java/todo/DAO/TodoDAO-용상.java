package todo.DAO;

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

import todo.DTO.TodoDTO;

// DAO : Data Access Object
public class TodoDAO {

	// todo 테이블의 모든 항목을 돌려주는 메소드
	// 메소드명: selectAll
	// 전달인자: 없음
	// 리턴타입: List

	public List<TodoDTO> selectAll() {

//		List list = new ArrayList();
		List<TodoDTO> list = new ArrayList<TodoDTO>();

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

//				Map map = new HashMap();
//				map.put("todo_id", todo_id);
//				map.put("duedate", duedate);
//				map.put("done", done);
//				map.put("content", content);
//				map.put("ctime", ctime);
//				
//				list.add(map);

				TodoDTO todoDTO = new TodoDTO();
				todoDTO.setTodo_id(todo_id);
				todoDTO.setDuedate(duedate);
				todoDTO.setDone(done);
				todoDTO.setContent(content);
				todoDTO.setCtime(ctime);

				list.add(todoDTO);

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

	// todo 테이블의 한 줄만 조회해서 돌려준다
	// 메소드명: selectOne
	// 전달인자: int todo_id
	// 리턴타입: TodoDTO

	public TodoDTO selectOne(int todo_id) {
		TodoDTO todoDTO = new TodoDTO();

		// context.xml에 있는 DB 정보로 커넥션 풀을 가져온다
		// 4. 결과 활용
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Context ctx = new InitialContext();
			// DataSource : 커넥션 풀 관리자
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			
			// 1. DB 접속
			conn = dataFactory.getConnection();
			// 2. SQL 준비
//			String query = "select * from todo where todo_id = "+ todo_id;
			String query = "select * from todo where todo_id=?"; // 변수 방식
			ps = conn.prepareStatement(query);
			ps.setInt(1, todo_id);
			
			// 3. 실행 및 결과 확보
			rs = ps.executeQuery();
			

			// 4. 결과 활용
			if( rs.next() ) {
				todoDTO.setTodo_id(rs.getInt("todo_id"));
				todoDTO.setDuedate(rs.getDate("duedate"));
				todoDTO.setDone(rs.getInt("done"));
				todoDTO.setContent(rs.getString("content"));
				todoDTO.setCtime(rs.getDate("ctime"));
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
		return todoDTO;
	}
	public int insert (TodoDTO todoDTO) {
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
			String query = "insert into todo(todo_id, duedate, done, content"
					+ ", ctime) values (seq_todo.nextval, null, 0, ?,sysdate)"
					; // 변수 방식
			ps = conn.prepareStatement(query);
			ps.setString(1, todoDTO.getContent());
			
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
	
	public int modify (TodoDTO todoDTO) {
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
			String query = "update todo set duedate=?, done=?, content=?, ctime=sysdate"
					+ " where todo_id=?";
				
			// 변수 방식
			ps = conn.prepareStatement(query);
			ps.setDate(1, todoDTO.getDuedate());
			ps.setInt(2, todoDTO.getDone());
			ps.setString(3, todoDTO.getContent());
			ps.setInt(4, todoDTO.getTodo_id());
			
			rs = ps.executeUpdate();
			
			
		} catch(Exception e) {
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
	public int todoDelete (TodoDTO todoDTO) {
		
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
			String query = "delete from todo where todo_id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, todoDTO.getTodo_id());
			
			rs = ps.executeUpdate();
			
		} catch(Exception e) {
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

}
