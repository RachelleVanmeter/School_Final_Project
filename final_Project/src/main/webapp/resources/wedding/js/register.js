/**
 * for join 2018-08-29
 */

/**
 * 정규식 sample
 * var regexTitle = /^[\uac00-\ud7a3a-zA-Z]{2,12}$/;
 * var regexTitle = /^[\uac00-\ud7a3a-zA-Z\s0-9]{2,16}$/;
 * var regexTitle = /^[*]{2,20}$/;
 * var regexEmail =/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
 * var regexID = /^[0-9a-zA-Z]{4,12}$/;
 * var regexPhone = /^[0-9]{3,4}[0-9]{4}$/;
 * var regexMobile = /^[0-9]{2,3}?[0-9]{3,4}?[0-9]{4}$/;
 * var regexBirth = /^[0-9]{2}[0-9]{2}[0-9]{2}$/;
 * var regexKey = /^[0-9]{5,6}$/;
 * var regexPass = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
 * var regexName = /^[\uac00-\ud7a3]{2,6}$/;
 * var regexDate = /^[0-9]{4}-[0-9]{2}-[0-9]{2}$/;
 * var regexDateTime = /^[0-9]{2}:[0-9]{2}~[0-9]{2}:[0-9]{2}$/;
 * var regexPass = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;
*/

$(document).ready(function() {
	// 페이리 로드후 바로 아이디 입력창으로 포커스를 준다
	$('#mwid').focus();
	
	// 영어 대소문자, 숫자포함 4자리 ~ 12자리
	var regexID = /^[0-9a-zA-Z]{4,12}$/;
	
	// 영어 대소문자, 숫자, 특수문자(!, @, #, $, %, ^, *, +, =, -)포함 8자리 ~ 16자리
	var regexPass = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;
	
	// 한글 2자 ~ 6자
	var regexName = /^[\uac00-\ud7a3]{2,6}$/;
	
	// 하이픈 없이 0 ~ 9까지 3자리 ~ 4자, 0 ~ 9까지 4자
	var regexPhone = /^[0-9]{3,4}[0-9]{4}$/;
	
	// 하이픈 없이 0 ~ 9까지 2자리 ~ 3자, 0 ~ 9까지 3자리 ~ 4자, 0 ~ 9까지 4자
	var regexMobile = /^[0-9]{2,3}?[0-9]{3,4}?[0-9]{4}$/;
	
	// 하이픈 없이 0 ~ 9까지 2자, 0 ~ 9까지 2자, 0 ~ 9까지 2자
	var regexBirth = /^[0-9]{2}[0-9]{2}[0-9]{2}$/;

	var boolAdmID = false;
	var boolAdmPass = false;
	var boolAdmName = false;
	var boolAdmPhone = false;
	var boolAdmMobile = false;
	var boolAdmBirth = false;
	var boolAdmAddress1 = false;
	var boolAdmAddress2 = false;
	var boolAdmAddress3 = false;
	var boolAdmAccept = false;
	
	function checkReg(el, tempVal, reg, message) {
		if (reg.test(tempVal) === false) { showErroMessage(el, message); return false; }
		else { showSuccessMessage(el, "사용가능합니다."); return true; }
	}

	function showErroMessage(el, message) {
		var html = "<span style='color:red'>";
		html += message;
		html += "</span>";
		$("#" + el).html(html);
	}

	function showSuccessMessage(el, message) {
		var html = "<span style='color:green'>";
		html += message;
		html += "</span>";
		$("#" + el).html(html);
	}
	
	// ---------------------------------------------------------
	
	$("#dbCheck").on("click", function() {
		var userID = $("#mwid").val();
		
		console.log(userID);
		
		if (userID != '' && userID != null) {
			$.ajax({
				type : 'POST',
				url : '/member/registerCheck',
				dataType : "text",
				data : { mwid : userID },
				success : function(result) {
					if (result == "SUCCESS") { showSuccessMessage('mwid_result', "사용 가능한 아이디 입니다"); $('#mwid').attr('readonly', ''); boolAdmID = true; }
					else { showErroMessage('mwid_result', "사용 불가능한 아이디 입니다"); $("#mwid").val(""); $('#mwid').focus(); }
					boolAdmID = true;
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert("에러 발생 \n" + textStatus + " : " + errorThrown);
				}
			});
		} else {
			alert("아이디는 공백이 될수 없습니다."); $('#mwid').focus();
			return;
		}
	});
	
	$("#mwpw").on("input", function() {
		var mwpw = $("#mwpw").val();

		var message = "올바른 비밀번호 형식이 아닙니다.";
		var booleanGet = checkReg('mwpw_result', mwpw, regexPass, message);
		boolAdmPass = booleanGet;
	});

	$("#mwpw2").on("input", function() {
		var mwpw = $("#mwpw").val();
		var mwpw2 = $("#mwpw2").val();

		if(boolAdmPass && (mwpw === mwpw2)) { showSuccessMessage('mwpw2_result', "비밀번호가 일치합니다."); }
		else { showErroMessage('mwpw2_result', "비밀번호가 일치하지 않습니다."); }
	});
	
	$('#mwname').on('input', function() {
		var mwname = $('#mwname').val();
		var message = "6자이내 한글만 가능합니다.";
		
		var booleanGet = checkReg('mwname_result', mwname, regexName, message);
		boolAdmName = booleanGet;
	});

	$('#mwmobile').on('input', function() {
		var mwmobile = $('#mwmobile').val();
		var message = "올바른형식이 아닙니다.";

		var booleanGet = checkReg('mwmobile_result', mwmobile, regexMobile, message);
		boolAdmMobile = booleanGet;
	});

	$('#mwbirth').on('input', function() {
		var mwbirth = $('#mwbirth').val();
		var message = "올바른형식이 아닙니다.";

		var booleanGet = checkReg('mwbirth_result', mwbirth, regexBirth, message);
		boolAdmBirth = booleanGet;
	});

	$('#adm_accept').click(function() {
		if ($('#adm_accept').is(':checked') == true) { boolAdmAccept = true; }
		else { boolAdmAccept = false; }
	});
	
	$('#CLICK').click(function() {
		if (!boolAdmID) { alert('아이디(e-mail) 을 확인해주세요'); $('#mwid').focus(); }
		else if (!boolAdmPass) { alert('비밀번호를 확인해주세요'); $('#mwpw').focus(); }
		else if (!boolAdmName) { alert('성명을 확인해주세요'); $('#mwname').focus(); }
		else if (!boolAdmMobile) { alert('연락처를 확인해주세요'); $('#mwmobile').focus(); }
		else if (!boolAdmBirth) { alert('생년월일을 확인해주세요'); $('#mwbirth').focus(); }
		else if (!boolAdmAccept) { alert('개인정보 수집 및 이용에 동의 해 주세요.'); $('#adm_accept').focus(); }
		else { $('#registerFROM').submit(); }
	});
});
