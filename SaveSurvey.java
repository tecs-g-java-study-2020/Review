package work;

//アンケートデータをsurveyテーブルに登録し、画面移行する

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

@WebServlet("/SaveSurvey")
public class SaveSurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SaveSurvey() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
		//文字コード設定
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//rikueasutoparame-ta取得
		String name = request.getParameter("NAME");
		int age = Integer.parseInt(request.getParameter("AGE"));
		int sex = Integer.parseInt(request.getParameter("SEX"));
		int satisfactionLevel = Integer.parseInt(request.getParameter("SATISFACTION_LEVEL"));
		String message = request.getParameter("MESSAGE");
		
		//anke-todata（SurveyDto型）
		SurveyDto dto = new SurveyDto();
		dto.setName(name);
		dto.setAge(age);
		dto.setSex(sex);
		dto.setSatisfactionLevel(satisfactionLevel);
		dto.setMessage(message);
		dto.setTime(new Timestamp(System.currentTimeMillis()));//現在時刻を更新時刻として設定
		
		//アンケートデータをDBに登録
		BusinessLogic logic = new BusinessLogic();
		boolean succesInsert = logic.executeInsertSurvey(dto);//DB操作成功フラグ
		
		//DB操作に応じて表示する画面
		if(succesInsert) {
		
		//DB登録に成功した場合、finish.htmlを表示する(true)
		response.sendRedirect("htmls/finish.html");
		
		}else {
		
		//DBに登録失敗した場合error.htmlを表示する(false)
		response.sendRedirect("htmls/error.html");
		}
		
	}

}
