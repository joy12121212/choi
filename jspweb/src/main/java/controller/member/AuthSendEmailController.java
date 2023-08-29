package controller.member;


import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmailService;


@WebServlet("/AuthSendEmailController")
public class AuthSendEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AuthSendEmailController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 자료 가져오기
		
		String memail = request.getParameter("memail"); System.out.println(memail);

		//인증번호 생성		
		String Auth = "";
		for (int i = 0; i < 6; i++) {
			Random random = new Random();
			Auth += random.nextInt(10);		//0부터 9 까지	
		}System.out.println(Auth);

		//이메일보내기
		EmailService emailService = new EmailService();
		emailService.send(memail,Auth);
		
		// 인증번호 반환
		response.getWriter().print(Auth);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}


















