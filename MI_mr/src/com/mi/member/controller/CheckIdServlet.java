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
 * Servlet implementation class CheckIdServlet
 */
@WebServlet("/chekIdDuplicate")
public class CheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Member m=new Member();
		String memberId=request.getParameter("memberId");
		m.setMemberId(memberId);
		Member result=new MemberService().selectOne(m);
		boolean isAble=(result==null?true:false);
		
		//응답화면 선택
		request.setAttribute("memberId", memberId);
		request.setAttribute("isAble",isAble);
		
		request.getRequestDispatcher("/views/member/checkDuplicate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
