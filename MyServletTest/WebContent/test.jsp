<%@ page contentType="text/html;charset=big5" %>
<jsp:useBean id="userInfo" class="com.servlet.UserInfoBean" scope="session"/>

<html>
<body>
<p>�q servlet �ǤJ�� UserInfoBean.userName �O�G
<b>
  <jsp:getProperty name="userInfo" property="userName"/>
</b>
</body>
</html>