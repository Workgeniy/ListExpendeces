<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Введите новую затрату!" %>
</h1>
<br/>
<form method="post" action="hello-servlet">
    <label>
    Название покупки:
    <input name="textField"/>
</label>
    <br/>
    <label>
    Цена: <input name="price" type="number"/>
    </label>
    <br/>
    <input type="submit" value="Сохранить">
</form>
<a href="hello-servlet">Показать список покупок</a>
</body>
</html>