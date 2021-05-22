var cacheMcidObj = {
		init: function(expiredays,holddays,domain,nameArray){
			//记录本次访问前的媒体来源代码,供后面统计会话时间用
			var old_mcid = this.getCookie("WT.mc_id");
			//开始全站缓存逻辑
			var mc_id = this.getUrlParam("WT.mc_id");
			var wtObj;
			if(!mc_id){
				mc_id = this.getLastPageUrlParam("WT.mc_id");
				if(!mc_id){
					mc_id = this.getCookie("WT.mc_id");
					var pastdays = holddays;
					var update_time = this.getCookie("update_time");
					if(update_time){
						var nowtime = new Date().valueOf();
						pastdays = (nowtime-update_time)/1000/3600/24;
					}
					if(mc_id && (pastdays<holddays)){
						wtObj = this.createWTObj(this.getCookie,["WT.mc_id"]);
					}
				}else{
					wtObj = this.createWTObj(this.getLastPageUrlParam,nameArray);
				}
				if(!this.isLessThanIE8() && wtObj){
					var title = document.title;
					History.replaceState(null, null, this.mkParamStr2(wtObj,nameArray));
					document.title = title;
				}
			}else{
				wtObj = this.createWTObj(this.getUrlParam,nameArray);
			}
			if(mc_id && wtObj){
				if(this.getUrlParam("utm_source") || this.getUrlParam("utm_medium") || this.getUrlParam("utm_campaign")){
					this.setCookie("utm_source", "", -1, domain);
					this.setCookie("utm_medium", "", -1, domain);
					this.setCookie("utm_campaign", "", -1, domain);
					this.setCookie("utm_content", "", -1, domain);
					this.setCookie("utm_term", "", -1, domain);
				}
				for(var param in wtObj){
					this.setCookie(param,wtObj[param], expiredays, domain);
				}
				this.setCookie("update_time",new Date().valueOf(),expiredays, domain);	
			}else{
				for(var i=0;i<nameArray.length;i++){
					this.setCookie(nameArray[i], "", -1, domain);
				}
				this.setCookie("update_time", "", -1, domain);
			}
			//记录/更新会话开始时间，会话域名
			var pasttime;	//本次会话已经经历的时间间隔
			var session_time = this.getCookie("session_time");	//读取cookie中保存的会话开始时间
			var now_time = new Date().valueOf();	//获取当前时间
			if(session_time){
				pasttime = (now_time-session_time)/1000/60;	//计算本次会话已经经历的时间间隔
			}
			var new_mcid = 	this.getCookie("WT.mc_id");		//获取最新的媒体来源代码
			//如果媒体来源发生变化，或者会话持续时间大于30分钟，或者是第一次访问，则重新记录会话域名和会话时间
			if(!session_time || new_mcid!=old_mcid || pasttime>30){
				this.setCookie("session_domain",document.domain,expiredays, domain);	//更新域名
				this.setCookie("session_time",now_time,expiredays, domain);		//更新时间
				//WT.mc_hd也要清空，重置
				var pageflag = $("#pageflag").val();
				if(pageflag){
					this.setCookie("WT.mc_hd",pageflag,expiredays, domain);
				}else{
					this.setCookie("WT.mc_hd", "", -1, domain);
				}
			}else{	//否则视为上一次会话的延续，域名不更新，时间更新
				this.setCookie("session_time",now_time,expiredays, domain);		//更新时间
				//在原有基础上计算WT.mc_hd的新值
				var pageflag = $("#pageflag").val();
				if(pageflag){
					this.setMchd(pageflag,expiredays, domain);
				}
			}
			//获取跨域传递cookie的对象，用此对象向后台发送本域名下WT.mc_id等媒体来源信息
			var cookieNames = ["WT.mc_hd","update_time","session_domain","session_time"];
			cookieNames = cookieNames.concat(nameArray);
			var cookieObj = this.getCookieObj(cookieNames);
			cookieObj["domain"] = "ph.com.cn";
			this.sendCookieObj(cookieObj);
		},
		createWTObj:function(exeFun,nameArray){
			var wtObj = {};
			for(var i=0;i<nameArray.length;i++){
				var name = nameArray[i];
				var value = exeFun(name);
				if(value){
					wtObj[name] = value;
				}
			}
			return wtObj;
		},
		getCookieObj:function(nameArray){
			var cookieObj = {};
			if (document.cookie.length>0){
				var cookieArr = document.cookie.split("; ");
				for(var i=0;i<cookieArr.length;i++){
					var str = cookieArr[i];
					for(var j=0;j<nameArray.length;j++){
						var name = nameArray[j];
						if(str.indexOf(name+"=")==0){
							cookieObj[name] = unescape(str.split("=")[1]);
							break;
						}
					}
				}
			 }
			return cookieObj;
		},
		sendCookieObj:function(cookieObj){
			$.ajax({  
			    type: "get",  
			    async: false,  
			    url: "https://www.ph.com.cn/api/w/cookie/setcookie",  
			    data:cookieObj,
			    dataType: "jsonp",  
			    jsonp: "callback",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(一般默认为:callback)  
			    crossDomain:true,  
			    success: function(json){
			    	console.log("success");
			    },  
			    error: function(){  
			        console.log('fail');  
			    }  
			}); 
		},
		mkParamStr1:function(wtObj){
			var result = "";
			for(var param in wtObj){
				result = result + param.substring(0,1).toUpperCase() + param.substring(1) + " " + wtObj[param] + "&";
			}
			return result;
		},
		mkParamStr2:function(wtObj,nameArray){
			var result = "?";
			for(var param in wtObj){
				result = result +  param + "=" + wtObj[param] + "&";
			}
			var sub = window.location.search.substr(1);
			var arrsub = sub.split("&");
			for(var i=0;i<arrsub.length;i++ ){
				var key = arrsub[i].split("=")[0];
				if(key && $.inArray(key,nameArray)==-1){
					result = result + arrsub[i] + "&";
				}
			}
			if(result.lastIndexOf("&")==result.length-1){
				result = result.substring(0,result.length-1);
			}
			return result;
		},
		getUrlParam: function(name){
			var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); 
			var r = window.location.search.substr(1).match(reg);  
			if (r!=null) return unescape(r[2]); return null; 
		},
		getLastPageUrlParam: function(name){
			var referStr = document.referrer;
			var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
			var paramStart = referStr.indexOf("?");
			var matchStr = paramStart==-1?"":referStr.substr(paramStart+1);
			var r = matchStr.match(reg);  
			if (r!=null) return unescape(r[2]); return null; 
		},
		getCookie:function(c_name){
			if (document.cookie.length>0){
				var cookieArr = document.cookie.split("; ");
				for(var i=0;i<cookieArr.length;i++){
					var str = cookieArr[i];
					if(str.indexOf(c_name + "=")==0){
						return unescape(str.split("=")[1]);
					}
				}
			 }
			return "";
		},
		setCookie:function(c_name,value,expiredays,domain){
			var exdate=new Date();
			exdate.setDate(exdate.getDate()+expiredays);
			document.cookie = c_name+ "=" +escape(value)+
				((expiredays==null) ? "" : ";expires="+exdate.toGMTString()) 
				+ ";domain=" + domain + ";path=/";
		},
		endWith:function(str,sub){
			return (str.length>=sub.length) && 
			str.substring(str.length-sub.length)==sub
		},
		isLessThanIE8:function(){
			var flag = false;
			var theUA = window.navigator.userAgent.toLowerCase();
			if ((theUA.match(/msie\s\d+/) && theUA.match(/msie\s\d+/)[0]) || (theUA.match(/trident\s?\d+/) && theUA.match(/trident\s?\d+/)[0])) {
			    var ieVersion = theUA.match(/msie\s\d+/)[0].match(/\d+/)[0] || theUA.match(/trident\s?\d+/)[0];
			 	if(ieVersion && ieVersion<=8){
			 		flag = true;
			 	}  
			}
			return flag;
		},
		setMchd:function(pageflag,expiredays, domain){
			var mc_hd = this.getCookie("WT.mc_hd");
			if(!mc_hd){
				this.setCookie("WT.mc_hd",pageflag,expiredays, domain);
			}
			var arr = mc_hd.split("_");
			if(arr[arr.length-1]!=pageflag){
				if(arr.length<5){
					this.setCookie("WT.mc_hd",mc_hd+"_"+pageflag,expiredays, domain);
				}else{
					mc_hd = mc_hd.substring(mc_hd.indexOf("_")+1);
					this.setCookie("WT.mc_hd",mc_hd+"_"+pageflag,expiredays, domain);
				}
			}
		}
};
var cachDoainArr = document.domain.split(".");
var cachDoainStr = "";
for(var i=1;i<cachDoainArr.length;i++){
	cachDoainStr = (i==1?cachDoainArr[i]:cachDoainStr + "." + cachDoainArr[i]);
}
if(parseInt(cachDoainArr[0])){
	cachDoainStr = cachDoainArr[0]+ "." + cachDoainStr;
}
cacheMcidObj.init(180, 30,cachDoainStr,["utm_source","utm_medium","utm_campaign","utm_content","utm_term","WT.mc_id"]);