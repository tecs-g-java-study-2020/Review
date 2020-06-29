package work;

//アンケートデータの登録

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BusinessLogic{
	
	public boolean executeInsertSurvey(SurveyDto dto) {
	
	boolean succesInsert = false; //DB操作成功フラグ
	
	//データベースの接続を実施
	//DAOクラスをインスタンス化＆対象ユーザーデータを登録するよう依頼
	SurveyDao dao = new SurveyDao();
	succesInsert = dao.doInsert(dto);
	
	return succesInsert;	
	}	
}