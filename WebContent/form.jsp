<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>form.jsp</title>
<s:head theme="xhtml" /> <!--預設為 xhtml --> <!--theme 可為 xhtml 或 simple 或 css_xhtml --> 
</head>
<body><br>
<OL>

        <LI><font color="blue"><b>傳統的Html標籤</b></font>
        
        <form action="<%=request.getContextPath()%>/myNamespace/myAction.action"	method="post">
			     編號: 
			    <input type="text" name="ename" value="1" /><p>
			      密碼: 
			    <input type="text" name="ename" value="111" /><p>
				<input type="submit" />
		</form><BR>	</LI>
		
		
<!-- 		<LI><font color="blue"><b>Struts2的表單UI標籤</b></font> -->
		
<%-- 		<s:form action="myAction" namespace="/myNamespace" > --%>
<%-- 			<s:textfield name="ename" label="員工姓名"  value="peter1吳永志" /> --%>
<%-- 			<s:submit value="送出" /> --%>
<%-- 		</s:form></LI> --%>
        
</OL>
</body>
</html>