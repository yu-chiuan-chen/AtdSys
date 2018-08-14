<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<script type="text/javascript">

$(function() {
	console.log('demo_head in!!');
});

function testJson() {
	$.ajax({
		url: 'testJson.do',
		method: 'post',
		dataType: 'json',
		data: {
			name: 'Hans',
			psw: 'abc123'
		},
		error: function(jqXHR, textStatus, errorThrown) {
	      alert('textStatus='+ textStatus);
	   	},
		success: function(data) {
	      $('#msg').text('json data='+ JSON.stringify(data));
		},
	});
}

</script>
