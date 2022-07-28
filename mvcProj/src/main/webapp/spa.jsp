<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spa.jsp</title>
</head>
<body>
	<table>
		<thead>
			<tr><th>아이디</th><th>이름</th><th>이메일</th><th>비밀번호</th></tr>
		</thead>
		<tobody id="list"></tobody>
	</table>

	<!-- Ajax 비동기 실행 -->
	<script>
		/* 비동기 처리방식 */
/* 		setTimeout(function() {
			console.log("A")
		}, 2000); //2초 지연된 후에 fucntion 실행
		
		setTimeout(function() {
			console.log("B")
		}, 3000);
		
		setTimeout(function() {
			console.log("C")
		}, 1000); */
//-----------------------------------------------
		/* 동기방식 */
/* 		setTimeout(function() {
			console.log("a");
			setTimeout(function() {
				console.log("b");
				setTimeout(function() {
					console.log("c");
				}, 1000);
			}, 3000);
		}, 2000);
 */
/* 		console.log("A");
		console.log("B");
		console.log("C"); */
		
//-------------------------------------------------

	let xhtp = new XMLHttpRequest(); //비동기방식 처리
	xhtp.open('get', 'memberJson.do'); //1.서버에 요청
	xhtp.send(); //2.결과 받아옴
	xhtp.onreadystatechange = callBackThree; //3.이벤트 처리
	
	let fields = ['id', 'name', 'mail', 'pwd'];
	
	function callBackOne() { //3-1.처리할 이벤트 함수
	if(xhtp.readyState == 4 && xhtp.status == 200) {
		let data = JSON.parse(this.responseText);
		console.log(data); 
		
		let name = document.createElement('p');
		name.innerText = data.name;
		let age = document.createElement('p');
		age.innerText = data.age;
	
		document.querySelector('body').append(name, age);
		}
	}
	
	function callBackTwo() { //3-1.처리할 이벤트 함수
		if(this.readyState == 4 && this.status == 200) {
			let data = JSON.parse(this.responseText);
			console.log(data);
			
			let ul = document.createElement('ul');//= <ul></ul>
			for (let obj of data) {
				let li = document.createElement('li');
				li.innerHTML = obj.name + obj.age;//<li>hong, 15</li>
				ul.append(li);
			}
			console.log(ul);
			document.querySelector('body').append(ul);
			
		}
	}
	function callBackThree() { //3-1.처리할 이벤트 함수
		if(this.readyState == 4 && this.status == 200) {
			let data = JSON.parse(this.responseText);
			console.log(data);
			let tbody = document.getElementById('list');
			
			for(let obj of data) {
				// tr td, td, td, td
				let tr = document.createElement('tr');
				
				for(let field of fields) {
					let td1 = document.createElement('td');
					td1.innerText = obj[field];
					tr.append(td1);
				}
				tbody.append(tr);
			}
		}
	}
	</script>
</body>
</html>