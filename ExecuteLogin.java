package work;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExecuteLogin")
public class ExecuteLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ExecuteLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		//文字コード設定
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//リクエストパラメーターからユーザー入力値を取得
		String userId = request.getParameter("USER_ID");
		String passWord = request.getParameter("PASSWORD");
		
		BusinessLogic logic = new BusinessLogic();
		UserInfoDto dto = logic.executeSelectUserInfo(userId,passWord);
		
		if(dto.getUserID() !=null){
			
			String encodeUserName = URLEncoder.encode(dto.getUserName(),"UTF-8");
			response.sendRedirect("Home?user_name="+ encodeUserName);
			
		}else {
			
		response.sendRedirect("Login");
		}
	}
}
