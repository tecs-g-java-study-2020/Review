package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ExecuteLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ExecuteLogout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html;charaset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//HTML文書
				out.println("<html>");
				out.println("<head>");
				out.println("<title>ログアウト完了</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h1>ログアウト完了画面</h2>");
				out.println("<p>ログアウトしました。</p>");
				out.println("<br>");
				out.println("<a href='Login'>ログイン画面に戻る</a>");
				out.println("</body>");
				out.println("</html>");
				
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
