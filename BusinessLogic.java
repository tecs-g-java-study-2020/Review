package work;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 public class BusinessLogic{
       
        
    public UserInfoDto executeSelectUserInfo(String inputUserId, String inputPassWord) {
    
    UserInfoDto dto = new UserInfoDto();
    
    UserInfoDao dao =new UserInfoDao();
    dto = dao.doSelect(inputUserId,inputPassWord);
  //抽出されたデータを戻す
    return dto;   
    }

}


