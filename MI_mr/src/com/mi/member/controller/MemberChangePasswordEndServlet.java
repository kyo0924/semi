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
 * Servlet implementation class MemberChangePasswordEndServlet
 */
@WebServlet(name="ChangePasswordEndServlet", urlPatterns="/changePasswordEnd")
public class MemberChangePasswordEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberChangePasswordEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String currentPw=request.getParameter("password");
		String newPw=request.getParameter("password_new");
		String memberId=request.getParameter("memberId");
		Member m=new Member();
		m.setMemberId(memberId);
		Member result=new MemberService().selectOne(m);
		int insertResult=0;
		String msg="";
		String loc="";
		String view="/views/common/msg.jsp";
		if(result!=null)
		{
			
			if(result.getPassword().equals(currentPw))
			{
				m.setPassword(newPw);
				insertResult=new MemberService().updatePassword(m);
				if(insertResult>0)
				{
					msg="패스워드 수정 완료(잘 기억 하기!!)";
					loc="/updateMember?userId="+memberId;
					String script="self.close();";
					request.setAttribute("script", script);
				}
				else
				{
					msg="패스워드 수정을 실패하였습니다.";
					loc="/views/member/changePassword.jsp?memberId="+memberId;
				}
			}
			else
			{
				msg="현재비밀번호가 일치하지 않습니다.";
				loc="/views/member/changePassword.jsp?memberId="+memberId;
			}
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
