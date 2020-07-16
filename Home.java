package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Home() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charaset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("user_name");
		
		//HTML文書
		out.println("<html>");
		out.println("<head>");
		out.println("<title>ホーム画面</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>ホーム画面</h2>");
		out.println("<p>ログインしました。</p>");
		out.println("<p>ようこそ<b>" + userName + "</b> さん</p>");
		out.println("<br>");
		out.println("<a href=¥'ExcuteLogout¥'>ログアウトする</a>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
