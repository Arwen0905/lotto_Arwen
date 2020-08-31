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
width: 600px;
border: 5px solid #ff2244;
padding: 20px;
background: #eeeeee;
}
#wen{
color:#ff2244;
font-size: 36px;
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
	margin: 10px 0;
	padding: 10px;
	/* background: #ffaacc; */
}
#viewRight{
	width: 600px;
	border: 5px solid #2244ff;
	padding: 20px;
	background: #999;
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
	<button class="lucky">���ɩ��B��</button>
	<button id="pred_btn">���B��J</button>
	<p class="up">���z�n�B</p>

		<form id="formNum_main" action="MyServlet" method=post>
				<select onchange="handler_form(this)" name="n1" class="selectNum1"> </select>
				<select onchange="handler_form(this)" name="n2" class="selectNum2"> </select>
				<select onchange="handler_form(this)" name="n3" class="selectNum3"> </select>
				<select onchange="handler_form(this)" name="n4" class="selectNum4"> </select>
				<select onchange="handler_form(this)" name="n5" class="selectNum5"> </select>
				<select onchange="handler_form(this)" name="n6" class="selectNum6"> </select>
				<br><br>
				<!-- �}����� -->
				<select onchange="handler_option(this)" name="random_seed" class="random_seed"> </select>
				<!-- �e�X��� -->
				<input onClick="sendInfo()" class="btn" id="submit_btn" name="submit" type=submit value="�}��">
		</form>
		<br>
		<!-- �w���X�\��: �L�������פ� -->
		<button name="predict_Num" class="predict_Num">�M�ݹw�����X!</button>
		<button name="predict_Go" class="predict_Go">�T�w</button>

		<div class="ansText"></div>
	</div>
	<div id="viewRight">

	</div>
</div>
	<script type="text/javascript">
	let wen = document.querySelector('#wen')
	let selectNum1 = document.querySelector('.selectNum1')
	let selectNum2 = document.querySelector('.selectNum2')
	let selectNum3 = document.querySelector('.selectNum3')
	let selectNum4 = document.querySelector('.selectNum4')
	let selectNum5 = document.querySelector('.selectNum5')
	let selectNum6 = document.querySelector('.selectNum6')

	let random_seed = document.querySelector('.random_seed')
	let pred_btn = document.querySelector('#pred_btn')
	let formNum_main = document.querySelector('#formNum_main')
	let submit_btn = document.querySelector('#submit_btn')
	let ansText = document.querySelector('.ansText')
	let viewRight = document.querySelector('#viewRight')
	
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
	
	// �}�����X
	s = Math.round(Math.random()*9)+1
	ansLotto = ansAll[s]
	ansLotto.pop()

	// �M�ݹw�����X: 100%����
	predict_Num.onclick = function(){
		count += 1
		this.innerHTML=(this.innerHTML=="�W���W��!"?"�W�a�F":"�W���W��!")
		predict_Go.style.display = "none"

		if(count%5==0){
			predict_Go.style.display = "inline"
			ar =  ansLotto
			this.innerHTML = ar
		}
	}
	// �N�w�����X �]�w�� �}�����X
	predict_Go.onclick = function(){
		random_seed.innerHTML += '<option selected>'+ ar +'</option>'
		arFun(ar)
		predict_Num.onclick()
	}

// Ajax ===========================================================================================================================
	function getData(){
		let req = new XMLHttpRequest()
		req.open("get","MyServlet")
		req.onload = function(){
			viewRight.innerHTML = this.responseText
		}
		req.send()
	}
// ===========================================================================================================================

	// �}�����s: �˴����Ƹ��X
	submit_btn.onclick = function(){
		c = currentNum() // ���o��e��(�q�Ψ禡)
		checkNum = c.toString().split(',')
		//getData() // Ajax����
		ticket = true // �������
		for(i=0; i<6; i++){
			for(j=0; j<i; j++){
				if(checkNum[i]==checkNum[j]){
					wen.innerHTML = "���X���ơA�Э��s�]�w"
					viewRight.innerHTML += "<br>" + "���ˬd���ƭ� " +"<span style='color:#ff2244'>"+ checkNum[i] +"</span>" + "<br>"
					ticket = false // �����ƭȴN�S������
					break // �פ���
				}
			}
		}

		if(ticket){ // ������ true �Y�ŦX������
			wen.innerHTML = "�g�O�����A�L�����ШD����"
			lottoAns(checkNum) // �I�s����禡
		}

	}

	// ����禡: 	
	function lottoAns(checkNum){
		ansCurrent = ansAll[s] // �������
		let checkCount = 0
		for(i=0; i<7; i++){
			for(j=0; j<6; j++){
				if(checkNum[j]==ansCurrent[i]){
					checkCount+=1
					viewRight.innerHTML += checkNum[j] + " ���X�ŦX! �ثe�ֿn " + checkCount + " �Ӹ��X����" + "<br>"
				}
			}
		}
		if(checkCount>=3){
			viewRight.innerHTML += "���ߤ���!����[ " + checkNum + " ]�����@�ŦX" + checkCount + "�Ӹ��X" + "<br><br>"
		}else{
			viewRight.innerHTML += "�i���I�S�������A�U�h��500" + "<br>"
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
	
	// ��ܫ��s(���B��J)
	lucky.onclick = function(){
		pred_btn.style.display = "inline"
		lucky.style.display = "none"
		up.innerHTML = "�o�j�]�I"
	}

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
	 // �ƬG: java���Ҫ� js�]�w �æ������\�Y�ɧ�s��حȡA�G�ϥέ��g�覡�@�]�p�\��
	 function roll_col(arc,v){ // ( �Q�ק� , ���ק� )
		 arc.innerHTML = ''
		 for(i=1; i<50; i++){
		    	//if(i<10){i = "0"+i}
		    	if(v == i){arc.innerHTML += "<option selected>"+i+"</option>"
		    		}else{arc.innerHTML += "<option>"+i+"</option>"}
		    	}
	 }
	// �ƬG: ����θӭȧ@�ק�Y�i�A�]�W�z�ƬG�ϥέ��g���覡
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

