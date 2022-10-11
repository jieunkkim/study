<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- c:forEach를 사용하려면 이 부분 입력되어야 함 -->
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
  <table>
    <thead>
        <th>id</th>
        <th>username</th>
        <th>age</th>
    </thead>
    <tbody>
      <c:forEach var="item" items="${members}">
         <tr>
            <td>${item.id}</td>
             <td>${item.username}</td>
             <td>${item.age}</td>
         </tr>
     </c:forEach>
     </tbody>
  </table>
  <a href="/servlet-mvc/members/new-form">입력화면으로</a>
</body>
</html>