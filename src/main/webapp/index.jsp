<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<body>
<h2>Угадай число</h2>
<p><a href="${pageContext.request.contextPath}/jsp/guessnumber.jsp">guess number</a></p>

<h2>Сервлеты</h2>
<p><a href="${pageContext.request.contextPath}/dao">dao</a></p>
<p><a href="${pageContext.request.contextPath}/employees">employees</a></p>
<p><a href="${pageContext.request.contextPath}/file">file</a></p>
<p><a href="${pageContext.request.contextPath}/news">news</a></p>
<p>
    <form method="GET" action="${pageContext.request.contextPath}/provider">
        <input type="text" name="url" placeholder="URL">
        <button>get text by this url</button>
    </form>
</p>
<p><a href="${pageContext.request.contextPath}/salary">salary</a></p>

<h2>Другие возможности удалённого доступа к бинам</h2>
<p><a href="${pageContext.request.contextPath}/search">additional</a></p>
</body>
</html>
