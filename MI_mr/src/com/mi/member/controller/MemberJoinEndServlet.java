package com.mi.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mi.member.model.service.MemberService;
import com.mi.member.model.vo.Member;

/**
 * Servlet implementation class MemberJoinEnd
 */
@WebServlet(name="MemberJoinEndServlet",urlPatterns="/memberJoinEnd")
public class MemberJoinEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoinEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String memberId=request.getParameter("memberId");
		String password=request.getParameter("password");
		String memberName=request.getParameter("memberName");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");

		Member m=new Member();
		m.setMemberId(memberId);
		m.setPassword(password);
		m.setMemberName(memberName);
		m.setEmail(email);
		m.setPhone(phone);

		int result=new MemberService().insertMember(m);
		
		String msg="";
		String loc="";
		String view="/views/common/msg.jsp";
		if(result>0)
		{
			msg="회원가입을 성공하였습니다.";
			loc="/";
		}
		else 
		{
			msg="회원가입을 실패하였습니다.";
			loc="/views/member/memberJoin.jsp";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher(view).forward(request, response);	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
