package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
	//HTML文書作成
		out.println("<html>");
		out.println("<head>");
		out.println("<title>ログイン画面</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>ログイン画面</h2>");
		out.println("<form action=¥'ExecuteLogin¥' method=¥'post¥'>");
		out.println("<p>ユーザーID:<br>");
		out.println("<input type='text' name='USER_ID' maxlength ='20'>");
		out.println("</p>");
		out.println("<p>パスワード:<br>");
		out.println("<input type='password' name='PASSWORD' maxlength ='20'>");	
		out.println("</p>");
		out.println("<input type='submit' value ='ログイン'");	
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
