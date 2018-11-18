if (typeof (indexJs) == 'undefined') {
	var indexJs = {
		selectedRow : null,
        dialogMinWidth: null,
        dialogWidth: null
	};
}

(function(indexJs) {

	//初始化
	indexJs.init = function(jspContext) {
		$.extend(indexJs, jspContext);
		indexJs.calendar();
		indexJs.getApplyTypeList();
	};
	
	
	//上班打卡
	$("#onDuty").click(function() {
		$.ajax({
			url : "onDutyAction.action", // 存取Json的網址
			type : "POST",
			cache : false,
			dataType : 'json',
			data : {
				emp_no : $("#emp_no").val(),
			},
			success : function(data) {
				if (data.status.match('success')) {
					$('#calendar').fullCalendar('destroy');
					indexJs.calendar();
				} else {
					alert("打卡失敗!");
				}

			},

			error : function(xhr, ajaxOptions, thrownError) {
				alert("上班打卡"+xhr.status);
				alert(thrownError);
			}
		});

	});
	
	
	//下班打卡
	$("#offDuty").click(function() {
		$.ajax({
			url : "offDutyAction.action", // 存取Json的網址
			type : "POST",
			cache : false,
			dataType : 'json',
			data : {
				emp_no : $("#emp_no").val(),
			},
			success : function(data) {
				if (data.status.match('success')) {
					indexJs.calendar();
				} else {
					alert("打卡失敗!");
				}

			},

			error : function(xhr, ajaxOptions, thrownError) {
				alert("下班打卡"+xhr.status);
				alert(thrownError);
			}
		});

	});
	
	//登出
	$("#logOut").click(function() {
		$.ajax({
			url : "logOutAction.action", // 存取Json的網址
			type : "POST",
			cache : false,
			dataType : 'json',
			data : {},
			success : function(data) {
				alert("登出");
				if (data.status.match('success')) {
					window.location.reload();
				}

			},

			error : function(xhr, ajaxOptions, thrownError) {
				alert("登出"+xhr.status);
				alert(thrownError);
			}
		});

	});
	
//	//取請假資料
//	var getApplyRecordList =(function() {
//		$.ajax({
//			url : "getApplyRecordAction.action", // 存取Json的網址
//			type : "POST",
//			cache : false,
//			dataType : 'json',
//			data : {
//				emp_no : $("#emp_no").val(),
//			},
//			 success: function(data) {
//				  var doc=data.listPRs;
//				  var arr=[];
//				   $.each(doc, function(i,val){    
//					   alert(val.reason);
////					   if (val.type_no==1){
////						   //上班時間
////						   var todayTimeStr =new Date(val.pr_time).Format("yyyy-MM-dd hh:mm:ss"); 
////						   var todayTime = new Date(todayTimeStr);
////						   //遲到時間
////						   var today = new Date(val.pr_time).Format("yyyy-MM-dd"); 
////						   var late = new Date(today+" 09:40:00");
////						   
////						   	var isLate = late<todayTime;
////							var dayWrapper = moment(val.pr_time).format();
////							var sb;
////							if (isLate){
////								sb = '{"title":"",'
////						  			+'"start":"'+dayWrapper+'","color":"yellow","textColor" : "red"}';
////							}else{
////								sb = '{"title":"",'
////						  			+'"start":"'+dayWrapper+'","color":"lightbule"}';
////							}
////				        	
////				        	var sbb = JSON.parse(sb);
////				        	arr.push(sbb);
////					   }else{
////				        	var sb = '{"title":"",'
////				  			+'"start":"'+val.pr_time+'","color":"green"}';
////				        	var sbb = JSON.parse(sb);
////				        	arr.push(sbb);
////					   }
////						
////			        });  
////				   $('#calendar').fullCalendar({
////					   editable : true,
////					   events: arr 
//				   });
//			      },
//
//			error : function(xhr, ajaxOptions, thrownError) {
//				alert(xhr.status);
//				alert(thrownError);
//			}
//		});
//
//	});


	//行事曆
	indexJs.calendar = function() {
		$.ajax({
		url : "getUserRecordAction.action", // 存取Json的網址
		type : "POST",
		cache : false,
		dataType : 'json',
		data : {
			emp_no : $("#emp_no").val(),
		},
		  success: function(data) {
			  var PRs=data.listPRs;
			  var ARs=data.listARs;
			  var arr=[];
			   $.each(PRs, function(i,val){    //打卡紀錄
				   if (val.type_no==1){
					   //上班時間
					   var todayTimeStr =new Date(val.pr_time).Format("yyyy-MM-dd hh:mm:ss"); 
					   var todayTime = new Date(todayTimeStr);
					   //遲到時間
					   var today = new Date(val.pr_time).Format("yyyy-MM-dd"); 
					   var late = new Date(today+" 09:40:00");
					   
					   	var isLate = late<todayTime;
						var dayWrapper = moment(val.pr_time).format();
						var sb;
						if (isLate){
							sb = '{"title":"",'
					  			+'"start":"'+dayWrapper+'","color":"yellow","textColor" : "red"}';
						}else{
							sb = '{"title":"",'
					  			+'"start":"'+dayWrapper+'","color":"lightbule"}';
						}
			        	
			        	var sbb = JSON.parse(sb);
			        	arr.push(sbb);
				   }else{
			        	var sb = '{"title":"",'
			  			+'"start":"'+val.pr_time+'","color":"green"}';
			        	var sbb = JSON.parse(sb);
			        	arr.push(sbb);
				   }
					
		        });  
			   $.each(ARs, function(i,val){    //請假紀錄
				   var sta_time = val.sta_time;
				   var end_time = val.end_time;
				   var at_no = val.at_no;
				   var review = val.review;
				   var reason = val.reason;
//				   alert(sta_time+"...."+reason);
				   
				   var sb = '{"title":"'+val.reason+'",'
			  			+'"start":"'+sta_time+'","end":"'+end_time+'","color":"pink"}';
			        	var sbb = JSON.parse(sb);
//			        	alert(sb);
			        	arr.push(sbb);
		        });  
			   $('#calendar').fullCalendar({
				   editable : false,
				   events: arr 
			   });
		      },
		error : function(xhr, ajaxOptions, thrownError) {
//			alert("行事曆"+xhr.status);
			console.log("行事曆"+xhr.status);
			alert(thrownError);
		}
			      
		});			
	
	}
		
		var listATstr;
		
		//取得請假類別清單
		indexJs.getApplyTypeList = function() {
			$.ajax({
			url : "getApplyTypeAction.action", // 存取Json的網址
			type : "POST",
			cache : false,
			dataType : 'json',
			data : {},
			success: function(data) {
				var doc=data.listAT;
				var str ='' ;
				$.each(doc, function(i,val){
					var at_no=val.at_no;
					var at_name=val.name;
					str=str+'<option value="'+at_no+'">'+at_name+'</option>';
				 }); 
				listATstr = str;
			},
			error : function(xhr, ajaxOptions, thrownError) {
				alert("請假類別"+xhr.status);
				alert(thrownError);
			}
			      
			});			
		};
			
			
		//請假申請的dialog
		$("#applyLeaveBtn").click(function() {
		       var modal = $('#modal');
		       modal.empty();
		      
		//--------------------------------
		       var html = 
		       		'<div class="modal fade" id="applyLeaveModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">';
		       html += '<div class="modal-dialog" role="document">';
		       html += '	<div class="modal-content">';
		       html += '		<div class="modal-header">';
		       html += '			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
		       html += '			<h4 class="modal-title" id="exampleModalLabel">請假申請：</h4>';
		       html += '		</div>';
		       html += '		<div class="modal-body">';
		       html += '		<form id="applyLeaveForm">';
		       html += '			<div class="form-group">';
		       html += '				<label for="message-text" class="control-label">請假類型：</label>';
		       html += '				<select id="at_no">';
		       html += '				<option value=0>請選擇</option>';
		       html += 					listATstr;
		       html += '				</select>';
		       html += '			</div>';
		       html += '			<div class="form-group">';
		       html += '				<label for="message-text" class="control-label">開始時間：</label>';
		       html += '				<input type="text" id="sta_time" class="form-control" data-type="datetime" data-format="YYYY-MM-DD hh:mm:00">';
		       html += '			</div>';
		       html += '			<div class="form-group">';
		       html += '				<label for="message-text" class="control-label">結束時間：</label>';
		       html += '				<input type="text" id="end_time" class="form-control" data-type="datetime" data-format="YYYY-MM-DD hh:mm:00">';
		       html += '			</div>';
		       html += '			<div class="form-group">';
		       html += '				<label for="recipient-name" class="control-label">請假事由：</label>';
		       html += '				<textarea id="reason" class="form-control" id="message-text"></textarea>';
		       html += '			</div>';
		       html += '		</div>';
		       html += '		<div class="modal-footer">';
		       html += '			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>';
		       html += '			<button type="button" id="applyLeaveSubmit" class="btn btn-primary" >Send message</button>';
		       html += '		</div>';
		       html += '		</form>';

		       html += '	</div>';
		       html += '</div>';
		       html += '</div>';
		     
		       modal.append(html);
		       
		       $("#applyLeaveForm").validate({
		           rules:
		           {
		           	at_no: {
		                   required: true,
		                   rangelength: [1, 50]
		               },
		           },
					submitHandler: function () {
//		            var ser =form.serialize();
		           	var at_no=$("#at_no").val();
		           	var sta_time=$("#sta_time").val();
		           	var end_time=$("#end_time").val();
		           	var reason=$("#reason").val();
		           	
		               $.ajax({
		       			url : "addapplyRecordAction.action",
		       			type : "POST",
		       			cache : false,
		       			dataType : 'json',
		       			data : {
		       				emp_no : $("#emp_no").val(),
		       				at_no:at_no,
		       				sta_time:sta_time,
		       				end_time:end_time,
		       				reason:reason
		       				}, 
		       			success : function(data) {
		       				if (data.status.match('success')) {
		       					alert("成功!");
		       				} else {
		       					alert("失敗!");
		       				}

		       			},

		       			error : function(xhr, ajaxOptions, thrownError) {
		       				alert("請假申請"+xhr.status);
		       				alert(thrownError);
		       			}
		       		});

		               return false;
		           }

		       });
//		       if (callback) {
//		           callback();
//		       }
		       $('#sta_time').cxCalendar();		
		       $('#end_time').cxCalendar();		
//		   };
		   	$("#applyLeaveSubmit").button().click(function() {
				 $('#applyLeaveForm').submit();
			});
		   	
		   	$("#at_no").change(function(){ 
		   		//Select事件發生 
		   		$("option:selected", this).each(function(){ 
		   			alert(this.value); 
		   		}); 
		   	});
		});
			
			
			
			
		
//		editable : false,
//		events : [ {
//			title : '昨天的活動************',
//			start : moment(day).format('YYYY-MM-DD')
//		}, {
//			title : '持續一周的活動',
//			start : moment().add(7, 'days').format('YYYY-MM-DD'),
//			end : moment().add(14, 'days').format('YYYY-MM-DD'),
//			color : 'lightBlue'
//		} ],
//		dayClick : function(date, event, view) {
////			console.log('add event');
////			console.log(date);
////			console.log(event);
////			console.log(view);
//		},
//		eventClick : function(date, event, view) {
//			console.log('modify event');
//			console.log(date);
//			console.log(event);
//			console.log(view);
//		}
//	});

//	$('#calendar').fullCalendar('renderEvent', {
//		title : '明天的活動',
//		start : moment().add(1, 'days').format('YYYY-MM-DD')
//	});
//
//	$('#calendar').fullCalendar('renderEvent', {
//		id : 'eventGroup1',
//		title : '活動1',
//		start : moment().add(3, 'days').format('YYYY-MM-DD'),
//		textColor : 'black',
//		color : 'beige'
//	});
//
//	$('#calendar').fullCalendar('renderEvent', {
//		id : 'eventGroup1',
//		title : '活動2',
//		start : moment().add(5, 'days').format('YYYY-MM-DD'),
//		textColor : 'black',
//		color : 'beige'
//	});
//	
//	$('#calendar').fullCalendar('renderEvent', {
//		id : 'eventGroup1',
//		title : '活動2',
//		start : moment('2018-08-10').format('YYYY-MM-DD'),
//		textColor : 'black',
//		color : 'beige'
//	});
//	}
	

	//js 日期轉換工具
	Date.prototype.Format = function (fmt) { //author: meizz 
	    var o = {
	        "M+": this.getMonth() + 1, //月份 
	        "d+": this.getDate(), //日 
	        "h+": this.getHours(), //小时 
	        "m+": this.getMinutes(), //分 
	        "s+": this.getSeconds(), //秒 
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	        "S": this.getMilliseconds() //毫秒 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	}
	
})(indexJs)
	