<%@page import="common.vo.EmployeeVO"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height: 100%;width:100%;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><tiles:insertAttribute name="title" ignore="true" />
</title>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- 行事曆 -->
<link rel=stylesheet type="text/css" href="<%=request.getContextPath()%>/atd/common/css/FullCalendar.css">
<!-- cxcalendar -->
<link rel=stylesheet type="text/css" href="<%=request.getContextPath()%>/atd/common/css/jquery.cxcalendar.css">
<!-- 基本的bootcss套件 -->
<link rel="stylesheet"	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
  #messagesArea 
  {
    position: absolute;
  top: 10px;
  right: 10px;
  width: 60%;
  height: 80px; 
  }
  
  #emp_name1 
  {
  position: absolute;
  top: 100px;
  right: 47%;
  width: 200px;
  height: 30px; 
  }
  
   #message  
   { 
   position: absolute; 
   top: 100px; 
   right: 10%; 
   width: 40%; 
   height: 30px;  
   } 
   
   #sendMessage
  { 
   position: absolute; 
   top: 100px; 
   right: 10px; 
   width: 100px; 
   height: 30px;  
   } 
  </style>

</head>
<%

EmployeeVO userVO = (EmployeeVO) session.getAttribute("userVO");
pageContext.setAttribute("userVO",userVO);

%>
<body style="height: 100%; width: 100%;">

	<div style="height: 100%; width: 100%;">
		<div
			style="height: 150px; width: 100%; background-color: rgb(200, 200, 200); float: left;">
			<lable id="emp_name"> ${userVO.name} </lable>
			<button type="button" id="onDuty" class="btn btn-primary">上班打卡</button>
			<button type="button" id="offDuty" class="btn btn-primary">下班打卡</button>
			<button type="button" id="applyLeaveBtn" class="btn btn-primary" data-toggle="modal" data-target="#applyLeaveModal" data-whatever="@mdo">請假申請</button>
			<button type="button" id="logOut" class="btn btn-primary">登出</button>
			<input type="button" id="commentBtn" class="btn btn-primary" onClick="location.href='<%=request.getContextPath()%>/atd/userss/Comment/init.do'" value="留言板">
			<textarea id="messagesArea" style="" readonly ></textarea>
			<lable id="emp_name1" >發言者：${userVO.name}</lable>
			<input type="hidden" id="emp_no" value="${userVO.emp_no}"/>
			<input type="text" id="message">
			<input type="submit" id="sendMessage" value="送出" onclick="sendMessage();"/>
		</div>
		<div style="height: 100%; width: 100%; float: left;">
			<div
				style="height: 110%; width: 20%; background-color: rgb(150, 150, 150); float: left;">
				本月累計遲到：<label id="lateTime"></label></br>
				本月請假時數：<label id="leaveTotalTime"></label>
			</div>
				
			<div
				style="height: 100%; width: 60%; text-align: center; float: left; margin-left: 10%; margin-top: 10px;"
				id="calendar">
			</div>
		</div>

	<tiles:insertAttribute name="body" />
	</div>
	<form id="psuedoForm"></form>
</body>
</html>
<script type='text/javascript'	src='http://code.jquery.com/jquery-1.9.1.min.js'></script>
<script	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- validate-CDN -->
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.js"></script>
<!-- cxcalendar -->
<script src="<%=request.getContextPath()%>/atd/common/js/jquery.cxcalendar.js"></script>
<script src="<%=request.getContextPath()%>/atd/common/js/jquery.cxcalendar.languages.js"></script>
<!-- 行事曆 -->
<script src="<%=request.getContextPath()%>/atd/common/js/moment.js"></script>
<script src="<%=request.getContextPath()%>/atd/common/js/FullCalendar.js"></script>
<script src="<%=request.getContextPath()%>/atd/common/js/index.js"></script>
<script src="<%=request.getContextPath()%>/atd/common/js/socketTest.js"></script>
<tiles:insertAttribute name="js" />
<script>
console.log('in~~~~~~layout.jsp!!!!!!!!!!!!!!!!!!!!!!!!!!!!!');

$(function() {
	var context = {
		    dialogMinWidth: 500,
		    dialogWidth: ($(window).width()) * 0.5
		};
		
		indexJs.init(context); 
// 		$('#element_id').cxCalendar();		
});  

</script>
