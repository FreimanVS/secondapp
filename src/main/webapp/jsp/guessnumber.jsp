<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div>
    <form action="${pageContext.request.contextPath}/guessnumber" method="POST">
        <input type="text" name="name" placeholder="name" minlength="2" maxlength="100" required />
        <input type="number" name="number" placeholder="number" min="0" max="9" required />
        <button>submit</button>
    </form>
</div>