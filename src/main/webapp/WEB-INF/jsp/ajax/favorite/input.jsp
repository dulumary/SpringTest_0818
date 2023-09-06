<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>


<body>

	<div class="container">
		<h1>즐겨 찾기 추가하기</h1>
		<label>제목</label>
		<input type="text" class="form-control" id="titleInput">
		<label class="mt-3">주소</label>
		<input type="text" class="form-control" id="addressInput">
		
		<button type="button" class="btn btn-success btn-block mt-3" id="addBtn">추가</button>
	</div>
	
	 <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	 
	 <script>
	 	$(document).ready(function() {
	 		
	 		$("#addBtn").on("click", function() {
	 			// 사용자가 입력한 사이트 이름, 주소를 얻어 와서
	 			// create api 호출
	 			let title = $("#titleInput").val();
	 			let address = $("#addressInput").val();
	 			
	 			// 유효성 검사 
	 			if(title == "") {
	 				alert("제목을 입력하세요");
	 				return ;
	 			}
	 			
	 			if(address == "") {
	 				alert("주소를 입력하세요");
	 				return ;
	 			}
	 			
	 			// 주소가 http://  https:// 로 시작하지 않으면
	 			// 주소가 http:// 로 시작하지 않고 https:// 로도 시작하지 안으면 
	 			if(!address.startsWith("http://") && !address.startsWith("https://")) {
	 				alert("주소형식을 확인해 주세요");
	 				return ;
	 			}
	 			
	 			
	 			$.ajax({
	 				type:"post"
	 				, url:"/ajax/favorite/create"
	 				, data:{"name":title, "url":address}
	 				, success:function(data) {
	 					// 성공 : {"result":"success"}
	 					// 실패 : {"result":"fail"}
	 					if(data.result == "success") {
	 						location.href = "/ajax/favorite/list";
	 					} else {
	 						alert("추가 실패");
	 					}
	 					
	 					
	 				}
	 				, error:function() {
	 					alert("추가 에러!!");
	 				}
	 			});
	 			
	 			
	 		});
	 		
	 	});
	 
	 </script>
	 
	 
	
</body>
</html>