package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*") // 전체 주소
public class LoginFilter implements Filter {

	/**
	 * Default constructor. 생성자
	 */
	public LoginFilter() {
		System.out.println("LoginFilter 생성자 실행");
	}

	/**
	 * @see Filter#destroy() 소멸자
	 */
	public void destroy() {
		System.out.println("LoginFilter destroy 소멸자 실행");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("doFilter 실행 전");
		
		long before = System.currentTimeMillis();

		// 요청 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");

		// 응답 한글 깨짐 방지 + 응답의 형식이 html이다
		// 브라우저에게 모든걸 html로 처리하라고 하기 때문에
		// json이나 파일 다운로드를 인식하지 못한다
		// jsp 같은 경우 상단에 자동완성 되므로 filter에서 처리하지 않는다
//		response.setContentType("text/html; charset=utf-8;");

		// Http만 사용하는게 아니라서 부모형태로 전달 받았다
		// 그래서 자식 형태로 강제 형변환
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String path = req.getServletPath();
		System.out.println("ServletPath : " + path);

		if (isExclude(path)) {
			// 세션 없이 진행시켜
			System.out.println("세션 없이 진행");
			// 원래 목적지로
			chain.doFilter(request, response);
		} else {
			HttpSession session = req.getSession();
			String login = (String) session.getAttribute("login");

			if ("Y".equals(login)) {
				// 로그인 된 상태
				System.out.println("로그인 [OK]");
				// 원래 목적지로
				chain.doFilter(request, response);
			} else {
				// 로그인 안된 상태
				System.out.println("로그인 [FAIL] : [" + path + "]");
				resp.sendRedirect(req.getContextPath() + "/login.jsp");

			}
		}

		// pass the request along the filter chain
//		chain.doFilter(request, response);

		System.out.println("doFilter 실행 후");
		long after = System.currentTimeMillis();
		System.out.println("걸린 시간: " + (after - before) );
	}

	/**
	 * @see Filter#init(FilterConfig) 생성자 실행 후 바로 실행
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("LoginFilter init실행 ......");
	}

	private boolean isExclude (String path) {
		boolean result = false;
		
		if( path.equals("/login.jsp")
			|| path.indexOf("/assets") != -1 	// 포함?
			|| path.startsWith("/assets")		// 시작?
			|| path.endsWith(".css")			// 끝?
			|| path.equals("/login")
			|| path.equals("/delay")
		) {
			result = true;
		}
		return result;
	}

}
