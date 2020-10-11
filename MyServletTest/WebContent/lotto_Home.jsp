<%@ page language="java" import="java.util.*" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lotto649</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<style type="text/css">
*{
font-family: "�L�n������";
font-family: Arial, Helvetica, sans-serif,'�L�n������';
font-size: 24px;
position: relative;
}
#wrapper{
	display: flex;
}
.lotto649{
width: 400px;
border: 5px solid #ff2244;
padding: 20px;
background: #eee;
}
#wen{
height: 40px;
color: #ff2244;
font-size: 28px;
user-select: none;
}
#wen:hover{
	color: #ffaacc;
	transition: 0.5s;
}
.btn{
color:#ffc408;
font-size: 24px;
background: #2d3a3a;
margin: 5px;
}
#pred_btn,.predict_Go{
	display: none;
	background: #aaeecc;
}
#pred_btn,.predict_Go:hover{
	background: #2d3a3a;
	color: #aaeecc;
}
.predict_Num{
	width: 210px;
	height: 40px;
	text-align: center;
	line-height: 20px;
}
.ansText{
	margin: 5px 0;
	padding: 10px;
	/* background: #ffaacc; */
}
#viewRight{
	width: 400px;
	border: 5px solid #2244ff;
	margin: 0px;
	padding: 20px;
	background: #eee;
}
.other{
	width: 400px;
	font-size: 18px;
	margin: 5px;
}
</style>
</head>
<body>
<div id="wrapper">
	<div class="lotto649">
		<h1 id="wen" onclick="javascript:window.location.reload()" title="���s��z">Hello World</h1>
		<input class="btn" value="�x�����" type="button" onclick="window.open('https://www.taiwanlottery.com.tw/lotto/lotto649/history.aspx','_blank')" />
		<a id="url_lotto" href="https://www.taiwanlottery.com.tw/lotto649/index.asp" target="_blank">�C���W�h</a>

		<h2>�ǳƦn�F�� ?</h2>
		
	<button class="lucky" onmousedown="luckyDow()" onmouseup="luckyUp()">�q���︹</button>
<!-- 	<button class="lucky">�q���︹</button> -->
	
	<button id="pred_btn">���B��J</button>
	
	<p class="up">���z�n�B</p>

		<form id="formNum_main">
				<select class="selectYear" name="Year"></select> �~��
				<br><br>
				<select onchange="handler_form(this)" name="n1" class="selectNum1"> </select>
				<select onchange="handler_form(this)" name="n2" class="selectNum2"> </select>
				<select onchange="handler_form(this)" name="n3" class="selectNum3"> </select>
				<select onchange="handler_form(this)" name="n4" class="selectNum4"> </select>
				<select onchange="handler_form(this)" name="n5" class="selectNum5"> </select>
				<select onchange="handler_form(this)" name="n6" class="selectNum6"> </select>
				 ����
				<br><br>
				<!-- �}����� -->
				<select onchange="handler_option(this)" name="random_seed" class="random_seed"> </select>
				<!-- �e�X��� -->
				<input class="btn" id="submit_btn" onclick="submitLotto()" name="submit" type="button" value="�}��">
		</form>
		<br>
		<!-- �w���X�\��: �L�������� -->
		<button name="predict_Num" class="predict_Num">�M�ݹw�����X!</button>
		<button name="predict_Go" class="predict_Go">�K�W</button>

		<div class="ansText"></div>
		<% Object QQ = session.getAttribute("QQ"); %>
	</div>

	<div id="viewRight">
		<pre id="viewAjax" style="word-break:break-all"></pre>
	</div>
	<div class="other"></div>
	<div class="other2"></div>
</div>


	<script type="text/javascript">
	let wen = document.querySelector('#wen')
	let selectNum1 = document.querySelector('.selectNum1')
	let selectNum2 = document.querySelector('.selectNum2')
	let selectNum3 = document.querySelector('.selectNum3')
	let selectNum4 = document.querySelector('.selectNum4')
	let selectNum5 = document.querySelector('.selectNum5')
	let selectNum6 = document.querySelector('.selectNum6')
	
	let selectYear = document.querySelector('.selectYear')
	
	year = Math.round(Math.random()*5)+2014 //�H���~��
	console.log(year)
	for(i=2014; i<=2019; i++){
			 if(i==year){ //�w�]�~��
			 	selectYear.innerHTML += "<option selected>"+ i +"</option>"
			 }else{
				 selectYear.innerHTML += "<option>"+ i +"</option>"
			 }
		 }
	
	let random_seed = document.querySelector('.random_seed')
	let pred_btn = document.querySelector('#pred_btn')
	let formNum_main = document.querySelector('#formNum_main')
	let submit_btn = document.querySelector('#submit_btn')
	let ansText = document.querySelector('.ansText')
	let viewRight = document.querySelector('#viewRight')
	let viewAjax = document.querySelector('#viewAjax')
	let other = document.querySelector('.other')
	
	// �w���X�\��(��s��) todo.. ======================================================
	
	let lucky = document.querySelector('.lucky')
	let predict_Num = document.querySelector('.predict_Num')
	let predict_Go = document.querySelector('.predict_Go')
	let up = document.querySelector('.up')
	let count = 0
	
	// ��10�������@���˥�
	let ans1 = ["19","45","44","9","6","40","1"]
	let ans2 = ["31","1","11","33","5","19","6"]
	let ans3 = ["45","19","18","16","33","17","25"]
	let ans4 = ["35","8","23","22","29","10","2"]
	let ans5 = ["37","21","35","20","2","24","9"]
	let ans6 = ["25","36","3","33","16","31","14"]
	let ans7 = ["30","25","15","5","41","6","29"]
	let ans8 = ["49","29","32","10","4","24","43"]
	let ans9 = ["5","4","22","49","27","46","41"]
	let ans10 = ["46","4","44","34","22","17","13"]
	let ansAll = [ans1,ans2,ans3,ans4,ans5,ans6,ans7,ans8,ans9,ans10]
	
	// ���a - �}�����X
	s = Math.round(Math.random()*9)+1
	ansLotto = ansAll[s]
	ansLotto.pop() // �����S�O��

	// �w�����X
		push_bool = false
	predict_Num.onclick = function(){
// 		lucky.onclick() //�S��\��A�j�q��`���|�X�̦h����������
		count += 1
		if(push_bool == true){ //��w���X �X�{��..
			if(confirm("�K�W �w���X")){ //�߰ݬO�_�n�K�W
				predict_Go.onclick() //�K�W
				this.innerHTML=(this.innerHTML=="�W���W��!"?"�W�a�F":"�W���W��!") //�����������w���X���
			}else{ //�����Y�������X���
				this.innerHTML=(this.innerHTML=="�W���W��!"?"�W�a�F":"�W���W��!") //�����������w���X���
				}
		}else{
			this.innerHTML=(this.innerHTML=="�W���W��!"?"�W�a�F":"�W���W��!")		
		}
		
		if(count%5==0){ // ��ŦXN���I�� ����w���X��..
			predict_Go.style.display = "inline" //�K�W���s ���
// 			this.innerHTML = ansLotto //��ܸ��X
			this.innerHTML = bigLotto //����̦h���X
			push_bool = true //������
		}else{
			predict_Go.style.display = "none" //�K�W���s �����
			push_bool = false
		}
	}
	// �N�w�����X �]�w�� �}�����X
	predict_Go.onclick = function(){
		random_seed.innerHTML += '<option selected>'+ bigLotto +'</option>'
		arFun(bigLotto)
	}

// Ajax ======================================================================================================================
	jsonObj = {}
	let big_win = [];
	let bigWin_old = 0
	function lottoAjax(checkNum){
		$('#viewAjax').text("��`�����G" + checkNum)
		//viewAjax.innerHTML += "<br>"
		$.ajax({
			type:"post",
			url:"./MyServlet",
			data:$('#formNum_main').serialize(),
			datatype:"json",
			success:function(message){
				jsonObj = JSON.parse(message) //�ѪR�^JSON�榡
				current_win = jsonL(jsonObj)
				$('#viewAjax').append("<br>�����`�ơG"+ current_win +"<br>")
				if(current_win > bigWin_old){
					bigWin_old = current_win
					bigLotto = checkNum
					$('.other2').text(bigLotto) //���X�̮e������������
				}
			}
		}) 
	}
	
// ===========================================================================================================================
		// JSON���e��X
	function jsonL(jsonEl){
		$('.other').text("")//�M�Ť��e
		jsonLength = 0 //�p����סA�N���G�����`��
		for(i in jsonEl){
			jsonLength++ //���ƪ���++
			$('#viewAjax').append("<br>"+ jsonEl[i])//��ܨC�ժ��������X * �w���� [ ] �~��
			tem_el = jsonEl[i].split(',') // ���� " , " �r���A�¼ƭ����
			count = 0
			red = false
			
			for(i=0; i<6; i++){				
				for(j=0; j<tem_el.length; j++){		
					if(checkNum[i]==tem_el[j]){
						count++
						red = true
					}
				}
				if(red){
					$('.other').append('<spen style="color:#ff2244;">'+checkNum[i]+" </spen>")
				}else{
					$('.other').append('<spen style="color:#000000;">'+checkNum[i]+' </spen>')
				}
				red = false
			}
			
			if(count==3){
			$('.other').append("<br>�����I "+ count +" �ӲŦX���� <br><br> ")
			}else if(count==4){
			$('.other').append("<br><spen style='color:#ff4444;font-size:40px';>���ߤT���I</spen>"+ count +" �ӲŦX���� <br><br> ")				
			}else if(count==5){
			$('.other').append("<br><spen style='color:#ff2222;font-size:50px';>���ߤG���I</spen>"+ count +" �ӲŦX���� <br><br> ")								
			}else if(count==6){
			$('.other').append("<br><spen style='color:#ffffff;font-size:60px';>�o�j�] ���Y���I�I�I</spen>"+ count +" �ӲŦX���� <br><br> ")								
			}else{
			$('.other').append("<br>�i���I�S�������A�U�h��500<br><br> ")				
			}
			
		}//�H�W�j��w��X���e
		return jsonLength //�u��^�`�ƧY�i
	}
// ===========================================================================================================================
	// �}�����s: �˴����Ƹ��X
	function submitLotto(){
		c = currentNum() // ���o��e��(�q�Ψ禡)
		checkNum = c.toString().split(',')
		ticket = true // �������
		for(i=0; i<6; i++){
			for(j=0; j<i; j++){
				if(checkNum[i]==checkNum[j]){
					wen.innerHTML = "���X���ơA�Э��s�]�w"
					other.innerHTML += "<br>" + "���ˬd���ƭ� " +"<span style='color:#ff2244'>"+ checkNum[i] +"</span>" + "<br>"
					ticket = false // �����ƭȴN�S������
					break // �פ���
				}
			}
		}

		if(ticket){ // ������ true �Y�ŦX������
			wen.innerHTML = "�g�O�����A�L�����ШD����"
			lottoAns(checkNum) // �I�s���a����禡
			lottoAjax(checkNum) // Ajax��Ʈw���
		}

	}

	// ���a���˪�����禡: 	
	function lottoAns(checkNum){
		ansCurrent = ansAll[s] // �������
		let checkCount = 0
		for(i=0; i<7; i++){
			for(j=0; j<6; j++){
				if(checkNum[j]==ansCurrent[i]){
					checkCount+=1
					//other.innerHTML += checkNum[j] + " ���X�ŦX! �ثe�ֿn " + checkCount + " �Ӹ��X����" + "<br>"
				}
			}
		}
		if(checkCount>=3){
			//other.innerHTML += "���ߤ���!����[ " + checkNum + " ]�����@�ŦX" + checkCount + "�Ӹ��X" + "<br><br>"
		}else{
			//other.innerHTML += "�i���I�S�������A�U�h��500" + "<br>"
		}

	}

	// ���o��e��(�q�Ψ禡)
	function currentNum(){
		let lst = []
		lst += formNum_main.n1.value +","+ formNum_main.n2.value +","+
				formNum_main.n3.value +","+ formNum_main.n4.value +","+
				formNum_main.n5.value +","+ formNum_main.n6.value
		return lst
	}
	
	// ��ܫ��s(�H���︹�\��)
	lucky.onclick = function(){
//		pred_btn.style.display = "inline"
//		lucky.style.display = "none"
		up.innerHTML = "�o�j�]�I"
	// �q���︹ �����e�X���
		ar = [] //�M��
		roll() //���o�s��ar�ƭ�
		random_seed.innerHTML += '<option selected>'+ ar +'</option>'
		arFun(ar) //�]�w����
		submitLotto() //�}���e�X
	}
//=====================================================================================
	function timeNow(){ //�������ɶ�
        now = new Date()
        return now.getTime()}
	//����
	   function luckyDow()
      {
          startTime = timeNow()//�ƹ����U�ɶ�
       	Time = setInterval(function(){ //�C100�@�����@��
          endTime = timeNow()//�ҥH�C100�@�����@���ɶ�

          if(endTime-startTime>1000)//����ɶ��P���U�ɶ��t��1000�@��Ĳ�o
          {
        	  lucky.onclick()
          }
        },50)//�]�w�C * �@��
      }
     //��������
     function luckyUp(){
     	clearInterval(Time)
     }
//=====================================================================================
	// �üƤ�����(�q�Ψ禡)
	let ar = []
	function roll(){
		for(i=0; i<6; i++){
			let k = Math.round(Math.random()*48)+1
			//if(k<10){k = "0"+k}
			ar.push(k)
			for(j=0; j<i; j++){
				if(ar[j]==k){
					i--
					ar.pop()
				}
			}
		}
	}
	// �C���}�l Load
	roll() // �����o�@�նü�
	constructor() // �غc���ճ�����
	random_seed.innerHTML += '<option selected>'+ ar +'</option>' // �Ĥ@�����o���ü� ��@�w�]���X
	
	// ���B��J:�üƲ��ͼֳz���X(������)
	pred_btn.onclick = function(){
		ar = []
		roll()
		random_seed.innerHTML += '<option selected>'+ ar +'</option>'
		arFun(ar)
	}
	// ================================================================================	
	 // �ƥ�: java���Ҫ� js�]�w �æ������\�Y�ɧ�s��حȡA�G�ϥέ��g�覡�@�]�p�\��
	 function roll_col(arc,v){ // ( �Q�ק� , ���ק� )
		 arc.innerHTML = ''
		 for(i=1; i<50; i++){
		    	//if(i<10){i = "0"+i}
		    	if(v == i){arc.innerHTML += "<option selected>"+i+"</option>"
		    		}else{arc.innerHTML += "<option>"+i+"</option>"}
		    	}
	 }
	// �ҥ~: ����θӭȧ@�ק�Y�i�A�]�W�z�ҥ~�ϥέ��g���覡
	function arFun(ar){
		roll_col(selectNum1,ar[0])
		roll_col(selectNum2,ar[1])
		roll_col(selectNum3,ar[2])
		roll_col(selectNum4,ar[3])
		roll_col(selectNum5,ar[4])
		roll_col(selectNum6,ar[5])
	}
	// ================================================================================

	// ��@���: �N��e��(�U���) ��s�� �}�����X
	function handler_form(fs){
		let lst = [] // �Ű}�C
		let arf = fs.options[fs.selectedIndex].innerText // ���o���(�U���)�ק�L����
		this.value = arf // fs���� option���(�U���)�A�N��ȴ����� �ק�L����

		// �W�z�ק粒���A�i�� ���o��e��(�q�Ψ禡)
		n = currentNum()
		// �H��e�� n �إ߶}�����X���
		random_seed.innerHTML += '<option selected>'+ n +'</option>'
	}

	
	// �}�����X���: �����C�ո��X�ñN������զX �]�w�� ��e��(�U���)
	function handler_option(ar){
		let ars = ar.options[ar.selectedIndex].innerText;
		ars = ars.split(',')
		arFun(ars)
	}

	// �غc:�إ� 6�դU������(49�Ӹ��X)
	function constructor(){
		for(var i=1; i<=49; i++){
			//if(i<10){i = "0"+i}
			if(ar[0] == i){
				selectNum1.innerHTML += '<option selected>'+ i +'</option>'
			}else{selectNum1.innerHTML += '<option>'+ i +'</option>'}
			
			if(ar[1] == i){
				selectNum2.innerHTML += '<option selected>'+ i +'</option>'
			}else{selectNum2.innerHTML += '<option>'+ i +'</option>'}
			
			if(ar[2] == i){
				selectNum3.innerHTML += '<option selected>'+ i +'</option>'
			}else{selectNum3.innerHTML += '<option>'+ i +'</option>'}
			
			if(ar[3] == i){
				selectNum4.innerHTML += '<option selected>'+ i +'</option>'
			}else{selectNum4.innerHTML += '<option>'+ i +'</option>'}
			
			if(ar[4] == i){
				selectNum5.innerHTML += '<option selected>'+ i +'</option>'
			}else{selectNum5.innerHTML += '<option>'+ i +'</option>'}
			
			if(ar[5] == i){
				selectNum6.innerHTML += '<option selected>'+ i +'</option>'
			}else{selectNum6.innerHTML += '<option>'+ i +'</option>'}		
		 };
	 
	}
	 
    </script>
	


</body>
</html>

