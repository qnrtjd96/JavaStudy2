package com.bitcamp.home.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitcamp.home.CommandService;

public class IdCheckCommand implements CommandService {

	@Override
	public String pocessStart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//DB조회 : id가 있는지 없는지 결과를 가지로 뷰로간다.
		String userid = req.getParameter("userid");
		
		MemberDAO dao = new MemberDAO();
		boolean result = dao.idCheck(userid);
		
		//request 객체에 필요한 데이터를 저장후 뷰페이지로 이동
		req.setAttribute("userid", userid);
		req.setAttribute("checkResult", result);
		
		return "/member/idCheck.jsp";
	}

}
