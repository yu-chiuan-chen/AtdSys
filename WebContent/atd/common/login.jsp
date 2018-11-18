<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type='text/javascript' src='http://code.jquery.com/jquery-1.9.1.min.js'></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="<%=request.getContextPath() %>/atd/common/js/login.js"></script>
<title>登入</title>
<s:head theme="xhtml" /> <!--預設為 xhtml --> <!--theme 可為 xhtml 或 simple 或 css_xhtml --> 
<style type="text/css">
			body{
				margin:0px;
				padding:0px;
				background:#fff url("images/login.jpg") center center fixed no-repeat;
				background-size: cover;　

			}    
</style>  
</head>
<body >
<OL>

<!--         <form action=""	method="post"> -->
<!-- 			 員工姓名:  -->
<!-- 			    <input type="text" name="emp_no" value="1" /><p> -->
<!-- 			 密碼： -->
<!-- 			  <input type="text" name="psw" value="111" /><p> -->
<!-- 				<input type="submit" /> -->
<!-- 		</form><BR>	</LI> -->
		
  
  <!-- 登入首頁開始 -->
<%-- 			<form METHOD="post" ACTION="<%=request.getContextPath()%>/atd/users/jsp/index.jsp" id="form1" namespace="/aaa">	 --%>
<%-- 			<form METHOD="post" ACTION="<%=request.getContextPath()%>/atd/Index/aaa.jsp" id="form1">	 --%>
			<form METHOD="post" ACTION="<%=request.getContextPath()%>/atd/Index/init.jsp" id="form1">	
				<div class="container" style="width:500px;margin-top:100px; ">
						
					    <div class="panel" id="login" >
					    <div class="panel-heading" style="text-align: center;font-size: 24px;background-color:#99FF99;">員工登入</div>
					    	<div class="panel-body" style="color: black;text-align: left;font-size: 16px">
					   
							  <div class="form-group" id="form-group1">
							    <label for="exampleInputEmail1">會員編號</label>
							    <input type="text" name="emp_no" id="emp_no" class="form-control" placeholder="會員編號" value="1">
							  </div>
							  <div class="form-group" id="form-group1">
							    <label for="exampleInputPassword1">密碼</label>
							    <input type="password" name="psw" id="psw" class="form-control" placeholder="密碼" value="111">
							  </div>

							  <div class="modal-footer" style="text-align: left;">
							  <b id="loginError" style="color:red;">文字</b>
							  <div class="form-group" id="form-group1" id="btlogin" style="text-align: center;">
							  		<button type="button" id="btnLogin" class="btn btn-default" style="background-color:#FDF5E6;">登入</button>
<!-- 							  		<button type="submit" id="btnLogin" class="btn btn-default" style="background-color:#FDF5E6;">登入</button> -->
							  </div>
							  </div>
					    	</div>
						</div>
				</div> 
			</form>
			<!-- 登入頁面結束 -->
		
		

</OL>
</body>
</html>

