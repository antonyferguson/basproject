/*function buttonAction(form,action){
	
	var check = true;
	if(action == 'doDelete'){
		check = haveCheckBox();
	}else if(action == 'doSearch'){
		$('input[name=ejdaAction]').val('EJDAM010');
		$('input[name=ejdaMethod]').val(action);
		$('input[name=screenName]').val('EJDAM010.jsp');
		form.submit();
	}else if(action == 'doAdd'){
		$('input[name=ejdaAction]').val('EJDAM010');
		$('input[name=ejdaMethod]').val('doSearch');
		$('input[name=screenName]').val('eJdaForm1.jsp');
		form.submit();
	}else{
		alert('No Data Select');
	}
}*/
function buttonAction(form,action,method,page){
	
	if($('select[name=DdlAddForm').val() == '1'){
//		action = 'EJDAM010';
		page = 'eJdaForm1.jsp';
	}else if($('select[name=DdlAddForm').val() == '2'){
//		action = 'EJDAM011';
		page = 'eJdaForm2.jsp';
	}else if($('select[name=DdlAddForm').val() == '3'){
//		action = 'EJDAM012';
		page = 'ejdaForm3.jsp';
	}else if($('select[name=DdlAddForm').val() == '4'){
//		action = 'EJDAM013';
		page = 'ejdaForm4.jsp';
	}
	
	
	$('input[name=ejdaAction]').val(action);
	$('input[name=ejdaMethod]').val(method);
	$('input[name=screenName]').val(page);
	form.submit();
}

function searchButtonEJDAM010(form,action,method,page){

	$('input[name=ejdaAction]').val(action);
	$('input[name=ejdaMethod]').val(method);
	$('input[name=screenName]').val(page);
	form.submit();
}

function updateEJDATable2(form,doc_id,action,page){
	//alert('fn_no : ' +fn_no);
	$('input[name=doc_id]').val(doc_id);
	$('input[name=ejdaAction]').val(action);
	$('input[name=ejdaMethod]').val('doUpdate');
	$('input[name=screenName]').val(page);
	//form.submit();
	document.ejdaformNo1.submit();
}

function changeSelectPage(form){
	$('input[name=ejdaAction]').val('EJDAM010');
	$('input[name=ejdaMethod]').val('doSearch');
	$('input[name=screenName]').val('EJDAM010.jsp');
	$('input[name=page]').val($('select[name=selectPaging]').val());
	form.submit();
}

function checkBoxAll(){
	var check = $('input[name=checkAllBox]').attr('checked');
	$('input[name=checkBox]').each(function (){
		$(this).attr('checked',(check == 'checked')?true:false);
	});
}
function haveCheckBox(){
	var check = false;
	$('input[name=checkBox]').each(function (){
		if($(this).attr('checked') == 'checked'){
			check = true;
		}
	});
	return check;
}



