package work;

//DTO（Survey）のテーブル

import java.sql.Timestamp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SurveyDto{
	
	private String name;
	private int age;
	private int sex;
	private int satisfactionLevel;
	private String message;
	private Timestamp time;
	
	
	//getter/setter
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}

	public int getSex() {return sex;}
	public void setSex(int sex) {this.sex = sex;}
	
	public int getSatisfactionLevel() {return satisfactionLevel;}
	public void setSatisfactionLevel(int satisfactionLevel) {this.satisfactionLevel = satisfactionLevel;}

	public String getMessage() {return message;}
	public void setMessage(String message) {this.message = message;}
	
	public Timestamp getTime() {return time;}
	public void setTime(Timestamp time) {this.time = time;}
}