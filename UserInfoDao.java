package work;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserInfoDao")

    public class UserInfoDao{
    	//データベースの接続情報
    	
    	//JDBCの相対パス
    	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    	//接続先のデータベース
    	String JDBC_URL = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&serverTimezone=JST&useSSLfalse";
    	//接続するユーザー名
    	String USER_ID = "test_user";
    	//接続するユーザーのパスワード
    	String USER_PASS = "test_pass";

    	public UserInfoDto doSelect(String inputUserId,String inputPassWord) {
    	//JDBCドライバロード
    	try {
    		Class.forName(DRIVER_NAME);
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	
    	//SQL発行
    	Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		
		UserInfoDto dto= new UserInfoDto();
		
		try {
			//接続の確立
			con = DriverManager.getConnection(JDBC_URL,USER_ID,USER_PASS);
    	
    	StringBuffer buf = new StringBuffer();
    	buf.append("SELECT");
		buf.append("USER_ID,");
		buf.append("USER_NAME,");
		buf.append("PASSWORD");
		buf.append("FROM");
		buf.append("USER_INFO");
		buf.append("WHERE");
		buf.append("USER_ID = ? AND");
		buf.append("PASSWORD = ?");
		
		//PreparedStatementオブジェクトを生成、発行するSQL
		ps = con.prepareStatement(buf.toString());
		
		//パラメータをセット
		ps.setString(1,inputUserId());
		ps.setString(2,inputPassWord());
		//SQL文の送信＆戻り値としてResultSetを取得
		rs = ps.executeQuery();
		
		//ResultSetオブジェクトからユーザーデータを抽出4
		if(rs.next()) {
		dto.setUserId(rs.getString("USER_ID"));
		dto.setUserName(rs.getString("USER_NAME"));
		dto.setPassWord(rs.getString("PASSWORD"));
		}
		
    }catch(SQLException e) {
    	e.printStackTrace();
    	
    }finally{
    	
    	//ResultSetオブジェクトの接続の解除
    	if(rs != null);
    	try {
    		rs.close();
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    }
		return dto;
    	}

		private String inputPassWord() {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}

		private String inputUserId() {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}
}
    	
    
		



