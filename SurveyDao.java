package work;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SurveyDao{

	//データベースの接続情報
	
	//JDBCの相対パス
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	//接続先のデータベース
	String JDBC_URL = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&serverTimezone=JST&useSSLfalse";
	//接続するユーザー名
	String JDBC_ID = "test_user";
	//接続するユーザーのパスワード
	String JDBC_PASS = "test_pass";
	
	//doInsertメソッド
	
	public boolean doInsert(SurveyDto dto ) {
	
		//JDBCドライバのロード
		
		try {
			Class.forName(DRIVER_NAME); //JDBCドライバをロード＆接続先として指定
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//SQL発行
			
		Connection con = null;
		PreparedStatement ps = null;
		
		
		//実行結果格納用変数
		
		boolean isSucces = true;
		
		try {
			//接続の確立
			con = DriverManager.getConnection(JDBC_URL,JDBC_ID,JDBC_PASS);
			//オートコミットをオフにする　トランザクションの開始
			con.setAutoCommit(false);
			
			//パラメーターセット
			StringBuffer buf = new StringBuffer();
			buf.append("INSERT INFO SURVEY{");
			buf.append("NAME,");
			buf.append("AGE,");
			buf.append("SEX,");
			buf.append("SATISFACTION_LEVEL,");
			buf.append("MESSAGE,");
			buf.append("TIME");
			buf.append(")VALUES(");
			buf.append("?,");
			buf.append("?,");
			buf.append("?,");
			buf.append("?,");
			buf.append("?,");
			buf.append("?");
			buf.append(")");
			
			//PreparedStatementオブジェクトを生成、発行するSQL
			ps = con.prepareStatement(buf.toString());
			
			//パラメータをセット
			ps.setString(1,dto.getName());
			ps.setInt(2,dto.getAge());
			ps.setInt(3,dto.getSex());
			ps.setInt(4,dto.getSatisfactionLevel());
			ps.setString(5,dto.getMessage());
			ps.setTimestamp(6,dto.getTime());
			
			//SQL文の実行
			ps.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			
			//実行結果を例外発生として更新
			
			isSucces = false;
			
		} finally {
			
			//トランザクションの終了
			if(isSucces) {
			try {
				con.rollback();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		  }
				
			
			//接続の解除
			
			//Connectionオブジェクトの接続解除
			
			if(con != null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	//実行結果を返す
	return isSucces;
	}
}