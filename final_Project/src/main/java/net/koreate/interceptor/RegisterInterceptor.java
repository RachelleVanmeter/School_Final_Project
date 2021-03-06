package net.koreate.interceptor;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import net.koreate.service.MemberService;
import net.koreate.vo.MemberVo;

public class RegisterInterceptor extends HandlerInterceptorAdapter {
	
	@Inject
	MemberService service;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String mwid = request.getParameter("mwid"); System.out.println("mwid : " + mwid);
		
		MemberVo vo = service.getUserByID(mwid);
		
		if(vo != null) {
			System.out.println("RegisterInterceptor VO : " + vo);
			
			RequestDispatcher rd = request.getRequestDispatcher("/member/register");
			request.setAttribute("result", "FAIL");
			rd.forward(request, response);
			return false;
		}
		request.setAttribute("result", "SUCCESS");
		return true;
	}
	
}
