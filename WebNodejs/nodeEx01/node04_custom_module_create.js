/**
 * 모듈파일 생성하기
 * 
 * 모듈파일을 생성하기 위해서 필요한 모듈 exports
 */

//1. 변수를 선언하는 방법
exports.num = 12345;
exports.userid="goguma";
exports.addr = "서울시 마포구 백범로";

//2.함수를 선언하는 방법
exports.msg =  function(){
	return "노드모듈에서 전달받은 문자열..";
}

exports.hap= function(n1, n2){
	return n1+n2;
}

exports.gugudan = function(dan){
	var result="";
	for(i=2; i<=9; i++){
		var data = dan*i;
		result += dan + "*" + i + " = "+ data + "<br/>";
	}
	return result;
}
