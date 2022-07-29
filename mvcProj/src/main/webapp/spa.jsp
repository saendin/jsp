<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spa.jsp</title>
</head>
<body>
	<h3>회원등록</h3>
	<form name="addForm" action="addMemberAjax.do" method="post">
		아이디:<input type="text" name="id"><br>
		이름:<input type="text" name="name"><br>
		이메일:<input type="text" name="mail"><br>
		비밀번호:<input type="password" name="pwd"><br>
		<input type="submit" value="저장">
	</form>

	<table style="border:'1'; border-collapse:'border';">
		<thead>
			<tr bgcolor="pink">
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>비밀번호</th>
			</tr>
		</thead>
		<tbody id="list"></tbody>
	</table>

	<!-- 페이지 로딩될 때 값을 가져오게하는 것 -->
	<!-- Ajax(비동기방식처리) -->
	<script>
   
   let i =0;
   
   let xhtp = new XMLHttpRequest();   //비동기방식 처리
   xhtp.open('get', 'memberJson.do');
   xhtp.send();//위의 페이지로 이동하고자 할 때 호출돼서 send해줌
   xhtp.onreadystatechange= callBackThree;
   
   
   let fields = ['id', 'name', 'mail', 'pwd'];
   function callBackThree(){
      if(this.readyState == 4 && this.status == 200){
         let data = JSON.parse(this.responseText); //json->object         
         console.log(data);
         let tbody = document.getElementById('list');

   		    //data 건수 반복
            for(let obj of data){
			tr = makeTr(obj);
            tbody.append(tr);
         }
      }
    }//end of callBackThree
   
   //행 만들어주는 함수 위의 callBackThree에서 써줄거임
   function makeTr(obj) {
	   //tr,td,td,td,td
	   let tr = document.createElement('tr');
	   
	   //field 갯수 반복
	   for(let field of fields) {
		   let td1 = document.createElement('td');
		   td1.innerText = obj[field];
		   tr.append(td1);
	   }
	   //삭제버튼
	   let td1 = document.createElement('td');
	   let btn = document.createElement('button');
	   btn.innerText = '삭제';
	   //클릭이벤트
	   btn.addEventListener('click', deleteCallBack);
	   td1.append(btn);
	   tr.append(td1);
	   
	   return tr;
   }
    
    function deleteCallBack(e){ /* //event에 만들어지는 함수들은 기본적으로 매개값(e)이 들어감 */
    	//event의 call함수(이벤트 받는 대상)
    	console.log(this);	//this = 버튼태그
    	
    	let delId = this.parentElement.parentElement.firstElementChild.innerText;
    	//버튼태그.td.tr.tr의 첫번째 자식 userId.의 텍스트 값만 출력하라
    	console.log(this.parentElement.parentElement.firstElementChild.innerText);
    	console.log(this.parentElement.parentElement.lastElementChild.innerText);//MTH로 원하는 자식 순번 지목 가능(first랑 last만 먹힘)
   
    	let delAjax = new XMLHttpRequest();
   	   	delAjax.open('post','removeMemberAjax.do')
   	   	delAjax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
   	   	delAjax.send('id='+delId); //아이디값으로 처리해서 넘겨줌
   	   	delAjax.onload = function() { //여기서의 this=delAjax의 object
   	   		let result = JSON.parse(delAjax.responseText)//넘겨받을 값 제이슨으로 : delAjax.responseText 값을 파싱해서 담을것
   	   		if(result.retCode == 'Success') //석세스면 화면에서 지워주고 아니면 에러발생 출력
   	   			e.target.parentElement.parentElement.remove(); //this=delAjax의 object
   	   		else
   	   			alert('처리 중 에러 발생!');
   	   	}
    }
   
/*    function callBackTwo(){
      if(this.readyState == 4 && this.status == 200){
         let data = JSON.parse(this.responseText); //json->object         
         console.log(data);
         
         let ul = document.createElement('ul'); //<ul></ul>같이 만들기
         for(let obj of data){
            let li = document.createElement('li');   //<li></li>같이 만들기
            li.innerHTML = obj.name + ', ' +obj.age; //<li>hong, 15</li>
            ul.append(li);//ul의 아이 요소로 어펜드하겠다
         }
         console.log(ul);
         document.querySelector('body').append(ul);
   }
   } */
   
   function callBackOne(){
      if(this.readyState == 4 && this.status == 200){
         //json을 자바 형태의 object타입으로 파싱해주는 역할
      let data = JSON.parse(this.responseText);         
      console.log(data);
      
      let name = document.createElement('p');
      name.innerText = data.name;
      let age = document.createElement('p');
      age.innerText = data.age;
      
      document.querySelector('body').append(name, age);
   	}
   }
   
   //form 전송이벤트 실행
   document.forms.addForm.onsubmit = function(e) {
	    //기본기능 차단 : e(위 펑션의 매개변수)가 가지고 있는 기본 이벤트를 차단하겠다
	   e.preventDefault();
	   let url = document.forms.addForm.getAttribute('action'); //document.forms.addForm.의 속성을 action이라는 변수에 담아 그것을 또 url에 담겠다
	 	//addform안의 속성(name값)들을 읽어오기 위한 값
	   let id = document.forms.addForm.id.value;
	   let name = document.forms.addForm.name.value;
	   let pwd = document.forms.addForm.pwd.value;
	   let mail = document.forms.addForm.mail.value;
	   let param = 'id='+id + '&name='+name + '&pwd='+pwd + '&mail='+mail;
	   
	   let addAjax = new XMLHttpRequest();
	   addAjax.open('post',url)
	   addAjax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	   addAjax.send(param); //id=user1&pass=1234%name=Hong&mail=email@com
   	   addAjax.onload = function() {
		   console.log(addAjax.responseText); //addAjax의 리턴되는 text값을 보려고
		   let data = JSON.parse(addAjax.responseText); // json -> object
		   document.getElementById('list').append(makeTr(data));
	   }
   }
   </script>
</body>
</html>