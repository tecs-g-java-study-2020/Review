package work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InputSurvey")
public class InputSurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public InputSurvey() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	
//出力する文字コードを設定
	response.setContentType("text/html; charset=UTF-8");
	
	PrintWriter out = response.getWriter();
	
	//HTML文書
	out.println("<html>");
	out.println("head<>");
	out.println("<title>回答入力</title>");
	out.println("</head>");
	out.println("<body>");
	out.println("<h2>お店レビューフォーム</h2>");
	out.println("<form action=¥"SaveSurvey¥" method=¥"post¥">");
	out.println("<p>名前:");
	out.println("<input type="text" name="NAME" maxlength ="20">");
	out.println("</p>");
	out.println("<p>年齢:");
	out.println("<input type=¥"number¥" name=¥"AGE¥" maxlength =¥"3¥">");	
	out.println("</p>");
	out.println("<p>性別:");
	out.println("<input type=¥"radio¥" name=¥"SEX¥" value =¥"1" checked>オス");	
	out.println("<input type=¥"radio¥" name=¥"SEX¥" value =¥"2" >メス");	
	out.println("</p>");
	out.println("<p>満足度:");
	out.println("<select name=¥"SATISFACTION_LEVEL¥">");
	out.print("<option value=¥"5¥">とても満足</option value>");
	out.print("<option value=¥"4¥">満足</option value>");
	out.print("<option value=¥"3¥">普通</option value>");
	out.print("<option value=¥"2¥">不満</option value>");
	out.print("<option value=¥"1¥">とても不満</option value>");
	out.println("</select>");
	out.println("</p>");
	out.println("<p>店舗へのご意見・ご感想をご記入ください:<br>");
	out.println("<textarea name=¥"MESSAGE¥" rows=¥"4¥" color=¥"50¥" maxlength=¥"250¥"></textarea>");
	out.println("</p>");
	out.println("<input type=¥"submit" value=¥"回答する¥">");
	out.println("</form>");
	out.println("</body>");
	out.println("</html>");
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
