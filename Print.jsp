<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>計算結果</title>
</head>
<body>
    <h1>計算結果</h1><br>
    <h2>【計算方法】<%=request.getAttribute("how") %></h2><br>
    <h2>【結果】<%=request.getAttribute("answer") %></h2><br>
    <br><a href="math.html">計算フォームへ</a>
</body>
</html>
</body>
</html>