/**
 * 
 */

function check(){
	if(document.frm.name.value.length==0){
		alert("상품명 입력")
		frm.name.focus();
		return false;
	}
	if(document.frm.price.value.length==0){
		alert("상품가격 입력")
		frm.price.focus();
		return false;
	}
	if(isNaN(document.frm.price.value)){
		alert("상품가격 숫자를 입력")
		frm.price.focus();
		return false;
	}
	return true;
}