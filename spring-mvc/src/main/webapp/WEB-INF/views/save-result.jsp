<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
  성공
  <ul>
      <li>id=${member.id}</li>
      <li>username=${member.username}</li>
      <li>age=${member.age}</li>
  </ul>
  <a href="/servlet-mvc/members/new-form">이전</a>
  <a href="/servlet-mvc/members">목록보기</a>
</body>
</html>