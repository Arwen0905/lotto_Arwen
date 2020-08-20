<%@ page contentType="text/html;charset=big5" %>
<jsp:useBean id="userInfo" class="com.servlet.UserInfoBean" scope="session"/>

<html>
<body>
<p>從 servlet 傳入的 UserInfoBean.userName 是：
<b>
  <jsp:getProperty name="userInfo" property="userName"/>
</b>
</body>
</html>