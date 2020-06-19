<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel ="stylesheet" type="text/css" href="css/style.css">
<title>タピオカレビューサイト</title>
</head>
<body>

 <div class="main-content">
    <div class="content">
    <div>ログイン</div>
      <form action="LoginServlet" method="post">
        <div>ログインID：<input type="text" name="login-id" /></div>
        <div>パスワード：<input type="password" name="password" /></div>
      <div><input type="submit" value="ログイン"></div>
       <div class="error-msg"><c:if test="${errorFlg}"><%=request.getAttribute("loginErrorMsg") %></c:if></div>
      </form>
    </div>
  </div>