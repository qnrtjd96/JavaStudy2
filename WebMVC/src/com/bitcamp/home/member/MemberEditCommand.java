package com.bitcamp.home.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bitcamp.home.CommandService;

public class MemberEditCommand implements CommandService {

	@Override
	public String pocessStart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberVO vo = new MemberVO();
		vo.setUserid((String)session.getAttribute("userid"));
		
		MemberDAO dao = MemberDAO.getInstance();
		dao.memberSelect(vo);
		
		System.out.println("vo.tel2 = " + vo.getTel2());
		System.out.println("vo.tel3 = " + vo.getTel3());
		req.setAttribute("vo", vo);
		return "/member/memberEdit.jsp";
	}

}
