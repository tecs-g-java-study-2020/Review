import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private final String loginId = "sample";
    private final String password = "sampleps";
	
	private static final long serialVersionUID = 1L;
       
	public LoginServlet() {
        
		super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
	        rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 String sentId = request.getParameter("login-id");
	        String sentPw = request.getParameter("password");

	        if (sentId.equals(loginId) && sentPw.equals(password)) {
	            HttpSession session = request.getSession();
	            session.setAttribute("loginUser", true);
	            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/home.jsp");
	            rd.forward(request, response);
	        } else {
	            request.setAttribute("loginErrorMsg", "ログイン情報が不正です。");
	            request.setAttribute("errorFlg", true);
	            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/login.jsp");
	            rd.forward(request, response);
	        }
	    }
	}


