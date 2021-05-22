/*
 * 该JS包含了pingan常规格式校验方法（欢迎拓展），验证通过返回true，不通过为false
 * 姓名（2-8个汉字）---check_name(nameValue)
 * 手机号码                       ---check_phone(phoneVal)
 * 手机验证码                  ---check_code(seCode)
 * 身份证                            ---check_identity(sfz)
 * -------------------另付几个常用取参方法-------------------------------------------------
 * 获取媒体来源                        ---getMediaSouce()
 * 获取离开页面信息              ---getLpPage()
 * 获取内媒                                  ---getInnerMedia()
 * 以上三个方法在js初始化加载时执行。
 * 截取URL参数            ---getUrlParam(name)(从URL截取参数，如想获取open_Id参数，直接getUrlParam("open_Id"))
 * 截取字符串参数     ---getStr(str,name)(从任意字符串截取参数，str:待处理字符串,name:要获取参数的参数名)   
 */
//姓名校验
function check_name(nameValue){
	if(nameValue=="" || nameValue == null){
		return false;
	}else if (nameValue == '不详' 
				|| nameValue == '未知'
				|| nameValue == '测试'
				|| nameValue == '不知道'
				|| nameValue == '姓名'){
			return false;
	}else if(!nameValue.match(/^[\u4e00-\u9fa5]{2,8}$/g)){
		return false;
	}else {
		return true;
	}
}
//手机号校验
function check_phone(phoneVal){
	if(phoneVal == null || phoneVal ==""){
		return false;
	}else if(phoneVal && !/^1[34578]\d{9}$/.test(phoneVal)){
	  	return false;
	}else{
	  	return true;
	}
}
//姓名校验
function nameValidate(nameValue){
	var Errors = [ true,"*请输入姓名","*请正确填写姓名","姓名为2到8个汉字"];
	if(nameValue=="" || nameValue == null){
		return Errors[1];
	}else if (nameValue == '不详' 
				|| nameValue == '未知'
				|| nameValue == '测试'
				|| nameValue == '不知道'
				|| nameValue == '姓名'){
			return Errors[2];
	}else if(!nameValue.match(/^[\u4e00-\u9fa5]{2,8}$/g)){
		return Errors[3];
	}else {
		return true;
	}
}
// 手机端手机号校验
function phoneValidate(inpVal){
	var Errors = [ true,"*请输入手机号码","*请正确填写手机号码"];
	var phoneNum = inpVal;
	if(phoneNum == null || phoneNum == ""){
		return Errors[1];
	}else if(!phoneNum.match(/^1[34578]\d{9}$/)){
		return Errors[2];
	}
	return true;
}
function checkCodeValidate(seCode){
	var Errors = [ true,"*请输入动态验证码","*请正确输入验证码"];
	if(seCode == null || seCode ==""){
		return Errors[1];
    }else if(seCode && !/^\d{6}$/.test(seCode)){
    	return Errors[2];
    }else{
    	return true;
    };
}
/*验证验证码*/
function check_code(seCode){
	if(seCode == null || seCode ==""){
		return false;
    }else if(seCode && !/^\d{6}$/.test(seCode)){
    	return false;
    }else{
    	return true;
    };
}
//身份证校验----  if(!ID || !/^\d{3}(\d|X|x)$/.test(ID)){//身份证//$('#IDError').html('请输入身份证后4位');
function check_identity(sfz){
    var reg = /^(?:\d{8}(?:0[1-9]|1[0-2])[0123]\d{4}|\d{6}(?:18|19|20)\d{2}(?:0[1-9]|1[0-2])[0123]\d{4}[0-9Xx])?$/;
    if(sfz == null || sfz ==""){
		return false;
	}else if(sfz && !reg.test(sfz)){
        return false;
    }else {
		return true;
	}
}

	/**
     *      严格的身份证号码校验
     */
    function idCard(idcard) {
            var Errors = [
                   true,
                   "*身份证号码位数不对","*身份证号码校验错误",
                   "*身份证号码校验错误","*身份证地区非法","请输入身份证号码"];
            var area = {
                   11: "\u5317\u4eac",       12: "\u5929\u6d25",      13: "\u6cb3\u5317",       14: "\u5c71\u897f", 15: "\u5185\u8499\u53e4",  21: "\u8fbd\u5b81",       22: "\u5409\u6797",       23: "\u9ed1\u9f99\u6c5f",
                   31: "\u4e0a\u6d77",      32: "\u6c5f\u82cf",  33: "\u6d59\u6c5f",       34: "\u5b89\u5fbd",       35: "\u798f\u5efa", 36: "\u6c5f\u897f",       37: "\u5c71\u4e1c",       41: "\u6cb3\u5357",       42: "\u6e56\u5317",
                   43: "\u6e56\u5357",       44: "\u5e7f\u4e1c", 45: "\u5e7f\u897f", 46: "\u6d77\u5357",      50: "\u91cd\u5e86",       51: "\u56db\u5ddd",    52: "\u8d35\u5dde",      53: "\u4e91\u5357",       54: "\u897f\u85cf", 
                   61: "\u9655\u897f",       62: "\u7518\u8083",       63: "\u9752\u6d77",      64: "\u5b81\u590f",       65: "\u65b0\u7586",     71: "\u53f0\u6e7e",       81: "\u9999\u6e2f",       82: "\u6fb3\u95e8",       91: "\u56fd\u5916"
            };
            var Y, JYM;
            var S, M;
            var idcard_array = new Array();
            idcard_array = idcard.split("");
            if(idcard == ""){//为空
                   return Errors[5];
            }
            if (area[parseInt(idcard.substr(0, 2))] == null) {
                   return Errors[4]
            }
            switch (idcard.length) {
            case 15://15_DIGITS_ID_TOKEN
                   if ((parseInt(idcard.substr(6, 2)) + 1900) % 4 == 0 || ((parseInt(idcard.substr(6, 2)) + 1900) % 100 == 0 && (parseInt(idcard.substr(6, 2)) + 1900) % 4 == 0)) {
                          ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/
                   } else {
                          ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/
                   }
                   if (ereg.test(idcard)) {
                          return Errors[0]
                   } else {
                          return Errors[2]
                   }
                   break;
            case 18:
                   if (parseInt(idcard.substr(6, 4)) % 4 == 0 || (parseInt(idcard.substr(6, 4)) % 100 == 0 && parseInt(idcard.substr(6, 4)) % 4 == 0)) {
                          ereg = /^[1-9][0-9]{5}(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/
                   } else {
                          ereg = /^[1-9][0-9]{5}(19|20)[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/
                   }
                   if (ereg.test(idcard)) {
                          S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7 + (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9 + (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10 + (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5 + (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8 + (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4 + (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2 + parseInt(idcard_array[7]) * 1 + parseInt(idcard_array[8]) * 6 + parseInt(idcard_array[9]) * 3;
                          Y = S % 11;
                          M = "F";
                          JYM = "10X98765432";
                          M = JYM.substr(Y, 1);
                          if(idcard_array[17] == "x"){
                          	idcard_array[17] = "X";
                          }
                          if (M == idcard_array[17]) {
                                 return Errors[0]
                          } else {
                                 return Errors[3]
                          }
                   } else {
                          return Errors[2]
                   }
                   break;
            default:
                   return Errors[1];
                   break;
            }
            return true;
     }

/**
 * PC端获取媒体来源
 * @return
 */
function getMediaSouce() {
    // 先从mc_id中取
    var theUrl = window.location.href;
    var paramIndex = theUrl.indexOf("WT.mc_id=");
    var mediaSource;
    if (paramIndex != -1) {
        mediaSource = theUrl.substring(paramIndex);
        var pIndex = mediaSource.indexOf("&");
        if (pIndex != -1) {
            mediaSource = mediaSource.substring(0, pIndex);
        }
        mediaSource = mediaSource.substring(9);
        //mediaSource = rspLoanCommon.unhtml(mediaSource,null);
    } else {
        mediaSource = "";
    }

    // 若cookie中为空，则默认为 'CXX-ZHITONGSEO-'
    if (!mediaSource || mediaSource == 'direct' || mediaSource == 'null') {
        mediaSource = 'CXX-ZHITONGSEO-';
    }
    //mediaSource = mediaSource.substring(0,32);
    $('#mediaSource').val(mediaSource);
    return mediaSource;
};

/**
 * WAP端获取媒体来源
 * @return
 */
function getMediaSouceWap() {
    // 先从mc_id中取
    var theUrl = window.location.href;
    var paramIndex = theUrl.indexOf("WT.mc_id=");
    var mediaSource;
    if (paramIndex != -1) {
        mediaSource = theUrl.substring(paramIndex);
        var pIndex = mediaSource.indexOf("&");
        if (pIndex != -1) {
            mediaSource = mediaSource.substring(0, pIndex);
        }
        mediaSource = mediaSource.substring(9);
        //mediaSource = rspLoanCommon.unhtml(mediaSource,null);
    } else {
        mediaSource = "";
    }

    // 若cookie中为空，则默认为 'CXX-ZHITONGSEO-'
    if (!mediaSource || mediaSource == 'direct' || mediaSource == 'null') {
        mediaSource = 'CXX-FUWUWX';
    }
    //mediaSource = mediaSource.substring(0,32);
    $('#mediaSource').val(mediaSource);
    return mediaSource;
};
//获取lpPage
function getLpPage() {
    var localurl = top.document.referrer;
    if(localurl){
	    if (localurl.indexOf("?") > 0) {
	        localurl = localurl.substring(0, localurl.indexOf("?"))
	    }
	    if (localurl.length > 150) {
	        localurl = localurl.substring(0, 150);
	    }
    }
    $('#lpPage').val(localurl);
    return localurl;
};
//获取innerMedia
function getInnerMedia() {
    var innerMedia = getCookie('inner_media');
    if(innerMedia)
    innerMedia = decodeURI(innerMedia);

    // 若cookie中为空，则默认为 'pingan'
    if (!innerMedia) {
        innerMedia = 'pingan';
    }

    $('#innerMedia').val(innerMedia);
};
//获取cookie数据
function getCookie(name) {
    var strCookie = document.cookie;
    var arrCookie = strCookie.split(";");

    for (var i = 0; i < arrCookie.length; i++) {
        var arr = arrCookie[i].split("=");
        if ($.trim(arr[0]) == name) return $.trim(arr[1]);
    }

    return null;
};
function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
};
function clearCookie(name) {  
    setCookie(name, "", -1);  
};
function clearTime(){
	clearTimeout(window.toTimeoutPageId);
	clearInterval(window.flowIntervalId);
}
		
function sessionTimeoutStart(flowid,time,notFirstTime,source){
	if(time=='60'){
		window.toTimeoutPageId = setTimeout(function(){//启动会话超时计时，并保存该计时ID,30分钟 30*60*1000=1800000
			if(source == "WAP"){
				var secretUniqueId = getCookie("secretUniqueId");
				if(null != secretUniqueId && "" != secretUniqueId){
					window.location.href = '/m/daikuan/zhuijia/1.0/index.html?uniqueId='+secretUniqueId;
				}else{
					window.location.href = '/microWebsite/jdcx_check.html';
				}
			} else {
				window.location.href = '/loan/jdcx.jsp';
			}
		},3600000);
	} else {
		window.toTimeoutPageId = setTimeout(function(){//启动会话超时计时，并保存该计时ID,60分钟 60*60*1000=3600000
			if(source == "WAP"){
				var secretUniqueId = getCookie("secretUniqueId");
				//topup加密uniqueId不为空，代表未验证过手机，直接跳到topup首页
				if(null != secretUniqueId && "" != secretUniqueId){
					window.location.href = '/m/daikuan/zhuijia/1.0/index.html?uniqueId='+secretUniqueId;
				}else{
					window.location.href = '/microWebsite/jdcx_check.html';
				}
			} else {
				window.location.href = '/loan/jdcx.jsp';
			}
		},1800000);
	}
	if(!notFirstTime){
		//启动保持流程计时器
		keepFlow(flowid,source);
		//用户点击了页面，清除两个之前的计时器，重新计时
		$("body").bind("click",function(){
			clearTimeout(toTimeoutPageId);
			//clearTimeout(tipToUserTimeout);
			if(time=='60')
				sessionTimeoutStart(flowid,'60',true,source);
			else
				sessionTimeoutStart(flowid,'',true,source);
		});
	}
}
		/**
		*	保持流程，每30秒发一次
		*/
function keepFlow(flowid,source){
	if(flowid!=''&&flowid!=null){
		window.flowIntervalId = setInterval(function(){
			$.ajax({
				url : "/do/keep-flow-ctx.do?flowId="+flowid,
				dataType:"json",
				success:function(data){
					if(data.resultCode!='0'){
						alert("抱歉，您的页面超时了。为了您的安全，请验证手机后继续申请。");
						clearInterval(flowIntervalId);
						var secretUniqueId = getCookie("secretUniqueId");
						if(null != secretUniqueId && "" != secretUniqueId){
							window.location.href = '/m/daikuan/zhuijia/1.0/index.html?uniqueId='+secretUniqueId;
						}else{
							if("WAP" == source){
								window.location.href = '/microWebsite/jdcx_check.html';
							}else{
								window.location.href = '/loan/jdcx.jsp';
							}
						}
					}
				},
				error:function(){
					if("WAP" == source){
						window.location.href = '/microWebsite/jdcx_check.html';
					}else{
						window.location.href = '/loan/jdcx.jsp';
					}
				}
			});
		},30000);
	}
}
//截取URL相关参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = top.location.search.substr(1).match(reg);
	if (r != null) return unescape(r[2]);
	return "";
}
//截取字符串相关参数
function getStr(str,name){
    var str1 = str.indexOf(name+"=");
    var len = name.length;
    var get_str = "";
    if (str1 != -1) {
		get_str = str.substring(str1);
	    var str2 = get_str.indexOf("&");
	    if (str2 != -1) {
	    	get_str = get_str.substring(len+1, str2);
	    }else{
	     	get_str = get_str.substring(len+1);
	   	}
    }
    return get_str;//不转码
    //return decodeURIComponent(get_str);//转码
}

//记录seo相关信息
function setSEOMsg(){
	//检查cookie中是否存在首次访问url、域名、时间，如无则插入，有则不处理
	
	var url = top.location.href;
	if(!getCookie("firstLandingURL")){//首次访问url
		setCookie("firstLandingURL",url);
	}
	var domian = url.split('://')[1].split('/')[0];
	if(!getCookie('firstLandingDomain')){//首次访问域名
		setCookie("firstLandingDomain",domian);
	}
	if(!getCookie('firstLandingTime')){//首次访问时间
		setCookie("firstLandingTime",formatDate(new Date()));
	}
	var lpPage="";
    lpPage=getLpPage();
	if(null==getCookie('langdingURL')){//来源页URL
		setCookie("langdingURL",lpPage);
	}
	var lpDomain= "";
	if(lpPage.split('://')[1]){
		lpDomain=lpPage.split('://')[1].split('/')[0];
	}
	if(null==getCookie('landingDomain')){//来源页域名
		setCookie("landingDomain",lpDomain);
	}
	var media="";
	var mediaCurrent = getUrlParam("WT.mc_id");
	if((lpPage==""||lpPage==null)&&mediaCurrent==""){
		media="SEO-direct";
	}else if(lpPage && mediaCurrent==""){
		media="SEO-host";
	}else {
		media = mediaCurrent;
	}
	var mediaSourceMark = getCookie('mediaSourceMark');
	if(!mediaSourceMark||mediaSourceMark=="SEO-direct"){
		setCookie("mediaSourceMark",media);
	}
	var expiresTime=new Date(new Date(getCookie("freshTime")).valueOf() + 1*24*60*60*1000);
	if(expiresTime < new Date()){
		setCookie("firstLandingURL",url);
		setCookie("firstLandingDomain",domian);
		setCookie("firstLandingTime",formatDate(new Date()));
		setCookie("langdingURL",lpPage);
		setCookie("landingDomain",lpDomain);
		setCookie("mediaSourceMark",media);
	}
	setCookie("freshTime",formatDate(new Date()));
	setCookie("freshReferer",url);
}
function getSEOMsg(){
	return {
		firstLandingURL:getCookie("firstLandingURL").substring(0, 150),
		firstLandingDomain:getCookie("firstLandingDomain"),
		firstLandingTime:getCookie("firstLandingTime"),
		langdingURL:getCookie("langdingURL").substring(0, 150),
		landingDomain:getCookie("landingDomain"),
		freshReferer:getCookie("freshReferer").substring(0, 150),
		freshTime:getCookie("freshTime"),
		formSubmitURL:top.location.href.substring(0, 150)
	};
}
function getMediaSourceMark(){
	var mediaSourceMark=getCookie("mediaSourceMark");
	if(mediaSourceMark=="SEO-direct"){
		mediaSourceMark+="-"+getCookie("firstLandingDomain");
	}else if(mediaSourceMark=="SEO-host"){
		mediaSourceMark+="-"+getCookie("landingDomain");
	}
	return mediaSourceMark.substring(0, 150);
}
function formatDate(dates){
	var years = dates.getFullYear();
    var months = dates.getMonth()+1;
    var days = dates.getDate();
    var hours = dates.getHours();
    var mins =dates.getMinutes(); 
    var secs = dates.getSeconds();
    var formatD = years+"-"+months+"-"+days+" "+hours+":"+mins+":"+secs;
    return formatD;
}
