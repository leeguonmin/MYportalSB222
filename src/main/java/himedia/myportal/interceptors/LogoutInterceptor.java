package himedia.myportal.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogoutInterceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(LogoutInterceptor.class);

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("LogoutInterceptor.preHandle calls");
		
		// 세션 무효화
		request.getSession().invalidate();
		
		// 무효화 시켰으니까, 홈페이지 쪽으로 돌려줘(리다이렉트)
		response.sendRedirect(request.getContextPath());
		
		return false;
		// false면 뒤로 넘어가지 않지!
	}
	
	

}
