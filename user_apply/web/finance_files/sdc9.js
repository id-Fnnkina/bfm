// Modify: 2017-12-04
// Js Version: pingan.all.3.16

function WebTrends(){
	// begin: user modifiable
	var a=this;
	a.url=dcsGetUrlInfo(location.href);
	a.dcsid="dcs82b9ujitigdu3gaykxw0hn_5p6b";
	a.domain="sdc.pingan.com";
	a.timezone=8;
	a.enabled=true;
	a.i18n=true;
	a.paidsearchparams="gclid";
	a.splitvalue="";
	a.preserve=false;
	a.cookieTypes = "all";
	a.FPCConfig = {
		enabled: (a.cookieTypes === "all" || a.cookieTypes == "firstPartyOnly"),
		name: "WT-FPC",
		domain: a.url?(a.url.hostname.match(/^((25[0-5]|2[0-4]\d|[01]?\d\d?)($|(?!\.$)\.)){4}$/)?a.url.hostname:a.url.hostname.replace(/^[A-z0-9\-]+\./g,".")):location.hostname,
		expires: 315360000000
	};
	a.TPCConfig = {
		enabled: (a.cookieTypes === "all"),
		cfgType: (a.cookieTypes === "all") ? "":"1"
	};
	// end: user modifiable
	a.DCS={};
	a.WT={};
	a.DCSext={};
	a.images=[];
	a.index=0;
	a.exre=(function(){return(window.RegExp?new RegExp("dcs(uri)|(ref)|(aut)|(met)|(sta)|(sip)|(pro)|(byt)|(dat)|(p3p)|(cfg)|(redirect)|(cip)","i"):"");})();
	a.re = (function () {
        return (window.RegExp ? (a.i18n ? {
            "%25": /\%/g,
            "%09": /\t/g,
            "%20": / /g,
            "%23": /\#/g,
            "%26": /\&/g,
            "%2B": /\+/g,
            "%3F": /\?/g,
            "%5C": /\\/g,
            "%22": /\"/g,
            "%7F": /\x7F/g,
            "%A0": /\xA0/g
        } : {
            "%09": /\t/g,
            "%20": / /g,
            "%23": /\#/g,
            "%26": /\&/g,
            "%2B": /\+/g,
            "%3F": /\?/g,
            "%5C": /\\/g,
            "%22": /\"/g,
            "%7F": /\x7F/g,
            "%A0": /\xA0/g
        }) : "")
    })()
  	//add by zhengzy
	a.url=dcsGetUrlInfo(location.href);
	a.qry = {};
	a.max=800;
	a.c=0;
	//a.le;
	a.s;
}
WebTrends.prototype.dcsGetId=function(){
	if ((document.cookie.indexOf(this.FPCConfig.name+"=")==-1)&&this.TPCConfig.enabled&&typeof(gWtId)=="undefined"&&typeof(gTempWtId)=="undefined"){
		document.write("<scr"+"ipt type='text/javascript' src='"+"http"+(window.location.protocol.indexOf('https:')==0?'s':'')+"://"+this.domain+"/"+this.dcsid+"/wtid.js"+"'><\/scr"+"ipt>");
	}
};
WebTrends.prototype.dcsGetIdAsync=function(){
	if ((document.cookie.indexOf(this.FPCConfig.name+"=")==-1)&&this.TPCConfig.enabled&&typeof(gWtId)=="undefined"&&typeof(gTempWtId)=="undefined"){		
		this.s = document.createElement("script");
			//arguments[1]&&console&&console.log(arguments[1]);
			_tag.s.type = "text/javascript"; 
			_tag.s.async = true; 
			_tag.s.src = "http"+(window.location.protocol.indexOf('https:')==0?'s':'')+"://"+_tag.domain+"/"+_tag.dcsid+"/wtid.js";
			var S = document.getElementsByTagName("script")[0]; 
			S.parentNode.insertBefore(_tag.s, S);
		return this.s;
	}
	else return null;
};
WebTrends.prototype.dcsGetCookie=function(name){
	var cookies=document.cookie.split("; ");
	var cmatch=[];
	var idx=0;
	var i=0;
	var namelen=name.length;
	var clen=cookies.length;
	for (i=0;i<clen;i++){
		var c=cookies[i];
		if ((c.substring(0,namelen+1))==(name+"=")){
			cmatch[idx++]=c;
		}
	}
	var cmatchCount=cmatch.length;
	if (cmatchCount>0){
		idx=0;
		if ((cmatchCount>1)&&(name==this.FPCConfig.name)){
			var dLatest=new Date(0);
			for (i=0;i<cmatchCount;i++){
				var lv=parseInt(this.dcsGetCrumb(cmatch[i],"lv"));
				var dLst=new Date(lv);
				if (dLst>dLatest){
					dLatest.setTime(dLst.getTime());
					idx=i;
				}
			}
		}
		return unescape(cmatch[idx].substring(namelen+1));
	}
	else{
		return null;
	}
};
WebTrends.prototype.dcsGetCrumb=function(cval,crumb,sep){
	var aCookie=cval.split(sep||":");
	for (var i=0;i<aCookie.length;i++){
		var aCrumb=aCookie[i].split("=");
		if (crumb==aCrumb[0]){
			return aCrumb[1];
		}
	}
	return null;
};
WebTrends.prototype.dcsGetIdCrumb=function(cval,crumb){
	var id=cval.substring(0,cval.indexOf(":lv="));
	var aCrumb=id.split("=");
	for (var i=0;i<aCrumb.length;i++){
		if (crumb==aCrumb[0]){
			return aCrumb[1];
		}
	}
	return null;
};
WebTrends.prototype.dcsIsFpcSet=function(name,id,lv,ss){
	var c=this.dcsGetCookie(name);
	if (c){
		return ((id==this.dcsGetIdCrumb(c,"id"))&&(lv==this.dcsGetCrumb(c,"lv"))&&(ss==this.dcsGetCrumb(c,"ss")))?0:3;
	}
	return 2;
};
WebTrends.prototype.dcsDeleteCookie=function(name, path, domain) {	
	var cDelete = name + "=";
	cDelete += "; expires=expires=Thu, 01 Jan 1970 00:00:01 GMT";
	cDelete += "; path=" + path;
	cDelete += (domain) ? ";domain="+domain : "";		
	document.cookie = cDelete;
};
WebTrends.prototype.dcsFPC=function(){


	var WT=this.WT;
	var name=this.FPCConfig.name;
	var dCur=new Date();
	var adj=(dCur.getTimezoneOffset()*60000)+(this.timezone*3600000);
	dCur.setTime(dCur.getTime()+adj);
	var dSes=new Date(dCur.getTime());
	var fs,pn,vn;
	WT.co_f=WT.vtid=WT.vtvs=WT.vt_f=WT.vt_f_a=WT.vt_f_s=WT.vt_f_d=WT.vt_f_tlh=WT.vt_f_tlv="";
	if (document.cookie.indexOf(name+"=")==-1){
		var v;
			if ((typeof(gWtId)!="undefined")&&(gWtId!="")){
			WT.co_f=gWtId;
			}
			else if ((typeof(gTempWtId)!="undefined")&&(gTempWtId!="")){
				WT.co_f=gTempWtId;
				WT.vt_f="1";
			}
			else{
				WT.co_f="2";
				var curt=dCur.getTime().toString();
				for (var i=2;i<=(32-curt.length);i++){
					WT.co_f+=Math.floor(Math.random()*16.0).toString(16);
				}
				WT.co_f+=curt;
				WT.vt_f="1";
			}
			if (typeof(gWtAccountRollup)=="undefined"){
				WT.vt_f_a="1";
			}
			WT.vt_f_s=WT.vt_f_d="1";
			WT.vt_f_tlh=WT.vt_f_tlv="0";
			pn=vn=1;
	}
	else{
		var c=this.dcsGetCookie(name);
		var id=this.dcsGetIdCrumb(c,"id");
		var lv=parseInt(this.dcsGetCrumb(c,"lv"));
		var ss=parseInt(this.dcsGetCrumb(c,"ss"));
	    fs=this.dcsGetCrumb(c,"fs");pn = parseInt(this.dcsGetCrumb(c,"pn"));vn = parseInt(this.dcsGetCrumb(c,"vn"));pn=pn?(WT.dl!="0"?pn:pn+1):1;vn=vn?vn:1;
		if ((id==null)||(id=="null")){
			return;
		}
		WT.co_f=id;
		var dLst=lv?new Date(lv):dCur;
		WT.vt_f_tlh=Math.floor((dLst.getTime()-adj)/1000);
		ss&&dSes.setTime(ss);
		if ((dCur.getTime()>(dLst.getTime()+1800000))||(dCur.getTime()>(dSes.getTime()+28800000))){
			WT.vt_f_tlv=Math.floor((dSes.getTime()-adj)/1000);
			dSes.setTime(dCur.getTime());
			WT.vt_f_s="1";
			vn++;pn=(WT.dl!="0")?0:1;
		}
		if ((dCur.getDay()!=dLst.getDay())||(dCur.getMonth()!=dLst.getMonth())||(dCur.getYear()!=dLst.getYear())){
			WT.vt_f_d="1";
		}
	}
	WT.co_f=escape(WT.co_f);
	WT.vtid=(typeof(this.vtid)=="undefined")?WT.co_f:(this.vtid||"");
	WT.vtvs=(dSes.getTime()-adj).toString();
	var expiry= (this.FPCConfig.expires) ? "; expires="+ new Date(new Date().getTime() + (this.FPCConfig.expires)).toGMTString():"";
	var cur=dCur.getTime().toString();
	var ses=dSes.getTime().toString();
	fs=fs?fs:cur;WT.pv_num=pn;WT.vt_num=vn;
	document.cookie=name+"="+"id="+WT.co_f+":lv="+cur+":ss="+ses+":fs="+fs+":pn="+pn.toString()+":vn="+vn.toString()+expiry+"; path=/"+(((this.FPCConfig.domain!=""))?("; domain="+this.FPCConfig.domain):(""));
	if(id!=this.dcsGetCookie("WEBTRENDS_ID")&&/((?:(?:25[0-5]|2[0-4]\d|((1\d{2})|([1-9]?\d)))\.){3}(?:25[0-5]|2[0-4]\d|((1\d{2})|([1-9]?\d))))-[0-9]{1,}.[0-9]{1,}/.test(id))
		document.cookie="WEBTRENDS_ID="+WT.co_f+expiry+"; path=/; domain=.pingan.com";
	var rc=this.dcsIsFpcSet(name,WT.co_f,cur,ses);
	if (rc!=0){
		/*WT.co_f=WT.vtvs=WT.vt_f_s=WT.vt_f_d=WT.vt_f_tlh=WT.vt_f_tlv="";
		if (typeof(this.vtid)=="undefined"){
			WT.vtid="";
		}*/
		WT.vt_f=WT.vt_f_a=rc;
    }
};
WebTrends.prototype.dcsMultiTrack=function(){
	var args=dcsMultiTrack.arguments?dcsMultiTrack.arguments:arguments;
	if (args.length%2==0){
		this.dcsSetProps(args);
		var dCurrent=new Date();
		this.DCS.dcsdat=dCurrent.getTime();
		this.dcsFPC();
		this.dcsTag();
	}
};
WebTrends.prototype.dcsSetProps=function(args){
	for (var i=0;i<args.length;i+=2){
		if (args[i].indexOf('WT.')==0){
			this.WT[args[i].substring(3)]=args[i+1];
		}
		else if (args[i].indexOf('DCS.')==0){
			this.DCS[args[i].substring(4)]=args[i+1];
		}
		else if (args[i].indexOf('DCSext.')==0){
			this.DCSext[args[i].substring(7)]=args[i+1];
		}
	}
};
WebTrends.prototype.dcsAdv=function(){
	this.dcsFPC();
};
WebTrends.prototype.dcsVar=function(){
	var dCurrent=new Date();
	var WT=this.WT;
	var DCS=this.DCS;
	this.url=dcsGetUrlInfo(location.href);
	WT.tz=parseInt(dCurrent.getTimezoneOffset()/60*-1)||"0";
	WT.bh=dCurrent.getHours()||"0";
	WT.ul=navigator.appName=="Netscape"?navigator.language:navigator.userLanguage;
	if (typeof(screen)=="object"){
		WT.cd=navigator.appName=="Netscape"?screen.pixelDepth:screen.colorDepth;
		WT.sr=screen.width+"x"+screen.height;
	}
	if (typeof(navigator.javaEnabled())=="boolean"){
		WT.jo=navigator.javaEnabled()?"Yes":"No";
	}
	if (document.title){
		if (window.RegExp){
			var tire=new RegExp("^"+window.location.protocol+"//"+window.location.hostname+"\\s-\\s");
			WT.ti=document.title.replace(tire,"");
			tire=new RegExp("^weixin://private/setresult/(.*)");
			WT.ti=WT.ti.replace(tire,"微信页面"); 
		}
		else{
			WT.ti=document.title;
		}
	}
	WT.js="Yes";
	WT.jv=(function(){
		var agt=navigator.userAgent.toLowerCase();
		var major=parseInt(navigator.appVersion);
		var mac=(agt.indexOf("mac")!=-1);
		var ff=(agt.indexOf("firefox")!=-1);
		var ff0=(agt.indexOf("firefox/0.")!=-1);
		var ff10=(agt.indexOf("firefox/1.0")!=-1);
		var ff15=(agt.indexOf("firefox/1.5")!=-1);
		var ff20=(agt.indexOf("firefox/2.0")!=-1);
		var ff3up=(ff&&!ff0&&!ff10&!ff15&!ff20);
		var nn=(!ff&&(agt.indexOf("mozilla")!=-1)&&(agt.indexOf("compatible")==-1));
		var nn4=(nn&&(major==4));
		var nn6up=(nn&&(major>=5));
		var ie=((agt.indexOf("msie")!=-1)&&(agt.indexOf("opera")==-1));
		var ie4=(ie&&(major==4)&&(agt.indexOf("msie 4")!=-1));
		var ie5up=(ie&&!ie4);
		var op=(agt.indexOf("opera")!=-1);
		var op5=(agt.indexOf("opera 5")!=-1||agt.indexOf("opera/5")!=-1);
		var op6=(agt.indexOf("opera 6")!=-1||agt.indexOf("opera/6")!=-1);
		var op7up=(op&&!op5&&!op6);
		var jv="1.1";
		if (ff3up){
			jv="1.8";
		}
		else if (ff20){
			jv="1.7";
		}
		else if (ff15){
			jv="1.6";
		}
		else if (ff0||ff10||nn6up||op7up){
			jv="1.5";
		}
		else if ((mac&&ie5up)||op6){
			jv="1.4";
		}
		else if (ie5up||nn4||op5){
			jv="1.3";
		}
		else if (ie4){
			jv="1.2";
		}
		return jv;
	})();
	WT.ct="unknown";
	if (document.body&&document.body.addBehavior){
		try{
			document.body.addBehavior("#default#clientCaps");
			WT.ct=document.body.connectionType||"unknown";
			document.body.addBehavior("#default#homePage");
			WT.hp=document.body.isHomePage(location.href)?"1":"0";
		}
		catch(e){
		}
	}
	if (document.all){
		WT.bs=document.body?document.body.offsetWidth+"x"+document.body.offsetHeight:"unknown";
	}
	else{
		WT.bs=window.innerWidth+"x"+window.innerHeight;
	}
	WT.fv=(function(){
		var i,flash;
		if (window.ActiveXObject){
			for(i=15;i>0;i--){
				try{
					flash=new ActiveXObject("ShockwaveFlash.ShockwaveFlash."+i);
					return i+".0";
				}
				catch(e){
				}
			}
		}
		else if (navigator.plugins&&navigator.plugins.length){
			for (i=0;i<navigator.plugins.length;i++){
				if (navigator.plugins[i].name.indexOf('Shockwave Flash')!=-1){
					return navigator.plugins[i].description.split(" ")[2];
				}
			}
		}
		return "Not enabled";
	})();
	WT.slv=(function(){
		var slv="Not enabled";
		try{     
			if (navigator.userAgent.indexOf('MSIE')!=-1){
				var sli = new ActiveXObject('AgControl.AgControl');
				if (sli){
					slv="Unknown";
				}
			}
			else if (navigator.plugins["Silverlight Plug-In"]){
				slv="Unknown";
			}
		}
		catch(e){
		}
		if (slv!="Not enabled"){
			var i,m,M,F;
			if ((typeof(Silverlight)=="object")&&(typeof(Silverlight.isInstalled)=="function")){
				for(i=9;i>0;i--){
					M=i;
					if (Silverlight.isInstalled(M+".0")){
							break;
					}
					if (slv==M){
						break;
					}
				}
				for (m=9;m>=0;m--){
					F=M+"."+m;
					if (Silverlight.isInstalled(F)){
						slv=F;
						break;
					}
					if (slv==F){
						break;
					}
				}
			}
		}
		return slv;
	})();
	if (this.i18n){
		if (typeof(document.defaultCharset)=="string"){
			WT.le=document.defaultCharset;
		} 
		else if (typeof(document.characterSet)=="string"){
			WT.le=document.characterSet;
		}
		else{
			WT.le="unknown";
		}
	}
	WT.sp=this.splitvalue;
	WT.dl="0";
	WT.ssl=(window.location.protocol.indexOf('https:')==0)?"1":"0";
	DCS.dcsdat=dCurrent.getTime();
	DCS.dcssip=window.location.hostname;
	DCS.dcsuri=this.Getdcsuri();
	WT.es=DCS.dcssip+DCS.dcsuri;
	if(this.url)
	{
		DCS.dcsqry=dcsStr(this.url.search+this.url.hashSearch,this.max);
	}
	else if (window.location.search){
		DCS.dcsqry=dcsStr(window.location.search,this.max);
	}
	if (DCS.dcsqry){
		var dcsqry=DCS.dcsqry.toLowerCase();
		var params=this.paidsearchparams.length?this.paidsearchparams.toLowerCase().split(","):[];
		for (var i=0;i<params.length;i++){
			if (dcsqry.indexOf(params[i]+"=")!=-1){
				WT.srch="1";
				break;
			}
		}
	}
	if(this.qry["referer"]){
		DCS.dcsref=dcsSubRef(dcsTrim(this.qry["referer"].replace("https","http")));
	}
	else if ((window.document.referrer!="")&&(window.document.referrer!="-")){
		if (!(navigator.appName=="Microsoft Internet Explorer"&&parseInt(navigator.appVersion)<4)){
			DCS.dcsref=dcsSubRef(dcsTrim(window.document.referrer.replace("https","http")));
		}
	}
	WT.hash = window.location.hash.substring(1).split('?')[0];
	DCS["dcscfg"] = this.TPCConfig.cfgType;
	
	var p=window.performance;
	if(p&&p.timing)
	{
	    WT.dat = dCurrent-p.timing.connectStart
	}
};
WebTrends.prototype.dcsEscape=function(S, REL){
	if (REL!=""){
		S=S.toString();
		for (var R in REL){
 			if (REL[R] instanceof RegExp){
				S=S.replace(REL[R],R);
 			}
		}
		S = dcsStr(S,this.max);	
		return S;
	}
	else{
		var t=dcsStr(escape(S),this.max);
		return t;
	}
};
WebTrends.prototype.dcsA=function(N,V){
	if (this.i18n&&(this.exre!="")&&!this.exre.test(N)){
		if (N=="dcsqry"){
			var newV="";
			var params=V.substring(1).split("&");
			for (var i=0;i<params.length;i++){
				var pair=params[i];
				var pos=pair.indexOf("=");
				if (pos!=-1){
					var key=pair.substring(0,pos);
					var val=pair.substring(pos+1);
					if (i!=0){
						newV+="&";
					}
					newV+=key+"="+this.dcsEncode(val);
				}
			}
			V=V.substring(0,1)+newV;
		}
		V=this.dcsEncode(dcsTrim(V));
	}
	else V=this.dcsEscape(V, this.re);
	return "&"+N+"="+V;
};
WebTrends.prototype.dcsEncode=function(S){
	return dcsStr((typeof(encodeURIComponent)=="function")?encodeURIComponent(S):escape(S),this.max);
};
WebTrends.prototype.dcsCreateImage=function(dcsSrc){
	if (document.images){
		this.images[this.index]=new Image();
		this.images[this.index].src=dcsSrc;
		this.index++;
	}
};
WebTrends.prototype.dcsPostUrl=function(dcsSrc){
  var s;
  if(window.XMLHttpRequest) s = new XMLHttpRequest();
  else if(window.ActiveXObject)  s = new ActiveXObject("Microsoft.XMLHTTP");
  s.open("POST",dcsSrc, true);
  s.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  s.send();
};
WebTrends.prototype.dcsSendBeacon=function(dcsSrc){
	if(typeof(navigator.sendBeacon)=="function"){
		var b = new Blob([],{type : 'application/x-www-form-urlencoded'});
		navigator.sendBeacon(dcsSrc, b);
	}
};
WebTrends.prototype.dcsMeta=function(){
	var elems;
	if (document.documentElement){
		elems=document.getElementsByTagName("meta");
	}
	else if (document.all){
		elems=document.all.tags("meta");
	}
	if (typeof(elems)!="undefined"){
		var length=elems.length;
		for (var i=0;i<length;i++){
			var name=elems.item(i).name;
			var content=elems.item(i).content;
			var equiv=elems.item(i).httpEquiv;
			if (name.length>0){
				if (name.toUpperCase().indexOf("WT.")==0){
					this.WT[name.substring(3)]=content;
				}
				else if (name.toUpperCase().indexOf("DCSEXT.")==0){
					this.DCSext[name.substring(7)]=content;
				}
				else if (name.toUpperCase().indexOf("DCS.")==0){
					this.DCS[name.substring(4)]=content;
				}
			}
		}
	}
};
WebTrends.prototype.dcsJson=function(){
	if (typeof(WTjson)!="undefined"){
		for (var key in WTjson){
			if (key.length&&key.length>0){
				if (key.toUpperCase().indexOf("WT.")==0){
					this.WT[key.substring(3)]=WTjson[key];
				}
				else if (key.toUpperCase().indexOf("DCSEXT.")==0){
					this.DCSext[key.substring(7)]=WTjson[key];
				}
				else if (key.toUpperCase().indexOf("DCS.")==0){
					this.DCS[key.substring(4)]=WTjson[key];
				}
			}
		}
	}
};
WebTrends.prototype.dcsCookie=function(){
	if (document.cookie.indexOf("WT-Data=")>-1){
		var c=this.dcsGetCookie("WT-Data")||''		
		var d=c.split(":");
		for (var i=0;i<d.length;i++){
			var a=d[i].split("=");
			if (a[0]&&a[1]){
				this.DCSext[a[0]]=a[1];
			}
		}
	}
};
WebTrends.prototype.dcsTag=function(d){
	var WT=this.WT;
	var DCS=this.DCS;
	var DCSext=this.DCSext;
	
	var P="http"+(window.location.protocol.indexOf('https:')==0?'s':'')+"://"+this.domain+(d?'/'+d:'/'+this.dcsid)+"/dcs.gif?";
	for (var N in DCS){
 		if (DCS[N]&&(typeof DCS[N]!="function")){
			P+=this.dcsA(N,DCS[N]);
		}
	}
	for (N in WT){
		if (WT[N]&&(typeof WT[N]!="function")){
			P+=this.dcsA("WT."+N,WT[N]);
		}
	}
	for (N in DCSext){
		if (DCSext[N]&&(typeof DCSext[N]!="function")){
			P+=this.dcsA(N,DCSext[N]);
		}
	}
	
	if (P.length>2048&&navigator.userAgent.indexOf('MSIE')>=0){
		this.max=this.max/2;
		WT.tu=1;
		this.dcsTag();return;
	}
	this.dcsCreateImage(P);
	WT.ad=WT.vt_f_p=WT.vt_f_p_m=WT.vt_f_cgn=WT.vt_f_cgn_m=WT.vt_f_cgs=WT.vt_f_cgs_m=WT.vt_f_mc=WT.vt_f_mc_m=WT.vt_f_sin=WT.vt_f_sin_m=WT.vt_f_si=WT.vt_f_si_m="";
};
WebTrends.prototype.dcsApi=function(t){
	if (typeof (navigator.sendBeacon) == "undefined") { return this.dcsTag(); }
	var WT=this.WT;
	var DCS=this.DCS;
	var DCSext=this.DCSext;
	
	var P="http"+(window.location.protocol.indexOf('https:')==0?'s':'')+"://"+this.domain+"/v1"+(this.dcsid==""?'':'/'+this.dcsid)+"/events.svc?";
	for (var N in DCS){
 		if (DCS[N]&&(typeof DCS[N]!="function")){
			P+=this.dcsA(N,DCS[N]);
		}
	}
	for (N in WT){
		if (WT[N]&&(typeof WT[N]!="function")){
			P+=this.dcsA("WT."+N,WT[N]);
		}
	}
	for (N in DCSext){
		if (DCSext[N]&&(typeof DCSext[N]!="function")){
			P+=this.dcsA(N,DCSext[N]);
		}
	}
	
	if(t=="beacon") this.dcsSendBeacon(P);
	else this.dcsPostUrl(P);
	WT.ad=WT.vt_f_p=WT.vt_f_p_m=WT.vt_f_cgn=WT.vt_f_cgn_m=WT.vt_f_cgs=WT.vt_f_cgs_m=WT.vt_f_mc=WT.vt_f_mc_m="";
};
WebTrends.prototype.dcsCollect=function(){
	this.dcsGetqry();
	this.dcsVar();
	this.dcsCookie();
	this.dcsMeta();
	this.dcsJson();
	this.dcsAdv();
	this.dcsLoad();
	if (typeof(this.dcsCustom)=="function"){
		this.dcsCustom();
	}
	this.dcsHistory();
	this.dcsTag();
};

//Add by Zhengzy
WebTrends.prototype.dcsGetqry = function(){
	this.url=dcsGetUrlInfo(location.href);
    var s = this.url?(this.url.search+this.url.hashSearch):window.location.search;
    if(s.length>1)
    {
        var o = s.substring(1).split('&');
        var item;
        for(var i=0;i<o.length;i++)
        {
            item = o[i].split('=');
            this.qry[item[0].toLowerCase()] = item[1];  
            }
    }
};
WebTrends.prototype.dcsv = function (o,n){
    var l=n.toLowerCase();var a=o.attributes;
    if(a&&a[n]) 
        return a[n].nodeValue||a[n].value;
    else if(a&&a[l]) 
        return a[l].nodeValue||a[l].value;
    else
        return null
};
WebTrends.prototype.pa_sdcajax = function (){
    this.WT = {}; 
    this.WT.pa_ajax=1;
    this.WT.dat_response=new Date().getTime() - this.DCS.dcsdat;
    this.dcsGetqry();
    this.dcsVar();
    this.WT.dl=21;
    this.dcsCookie();
    this.dcsMeta();
    this.dcsJson();
    this.dcsAdv();
    this.dcsLoad();
    if (typeof(this.dcsCustom)=="function"){
		this.dcsCustom();
    }
    var l = 2;
    var b = pa_sdcajax.arguments ? pa_sdcajax.arguments : arguments;
    if(b[2]!=null&&typeof(b[2])=="boolean") l = 3;
    
    if ((b.length%2==0&&l==2) || (b.length%3==0&&l==3)){
			for (var i=0;i<b.length;i+=l){
				if (b[i].indexOf('WT.')==0){
					this.WT[b[i].substring(3)]=b[i+1];
				}
				else if (b[i].indexOf('DCS.')==0){
					this.DCS[b[i].substring(4)]=b[i+1];
				}
				else if (b[i].indexOf('DCSext.')==0){
					this.DCSext[b[i].substring(7)]=b[i+1]
				}
			}
    }
    this.dcsHistory();
    this.dcsTag();
    this.WT.pa_ajax=this.WT.dl=null;
    if (l==3){
        for (var i=0;i<b.length;i+=3){
            if (b[i].indexOf('WT.')==0){
                if(!b[i+2]) this.WT[b[i].substring(3)]=null;
            }
            else if (b[i].indexOf('DCS.')==0){
                if(!b[i+2]) this.DCS[b[i].substring(4)]=null;
            }
            else if (b[i].indexOf('DCSext.')==0){
                if(!b[i+2]) this.DCSext[b[i].substring(7)]=null;
            }
        }
    }
    this.dcsComplete();
};
WebTrends.prototype.dcsTrack = function (d,c){ 
    this.WT.dat_response=new Date().getTime() - this.DCS.dcsdat;
    this.dcsVar();
    this.WT.dl=21;
    this.dcsJson();
	for (var key in d) {
		if (key.indexOf('WT.')==0){
			this.WT[key.substring(3)]=d[key];
		}
		else if (key.indexOf('DCS.')==0){
			this.DCS[key.substring(4)]=d[key];
		}
		else if (key.indexOf('DCSext.')==0){
			this.DCSext[key.substring(7)]=d[key]
		}
	}
    this.dcsHistory();
    var t=c&&c.trackType?c.trackType:"";
    if(t=="beacon") this.dcsApi("beacon");
    else if(t=="post") this.dcsApi();
    else this.dcsTag();
    var k=c&&c.paramsKeep?c.paramsKeep:"";
    for (var key in d){
    	if(k.indexOf(key)<0){
        if (key.indexOf('WT.')==0){
            this.WT[key.substring(3)]=null;
        }
        else if (key.indexOf('DCS.')==0){
            this.DCS[key.substring(4)]=null;
        }
        else if (key.indexOf('DCSext.')==0){
            this.DCSext[key.substring(7)]=null;
        }
      }
    }
    this.dcsComplete();
};
WebTrends.prototype.autoclick = function () {
    var o = new Array();
    var d = document;
    
    if (d.all) {
        o = d.getElementsByTagName("INPUT");
        var i = 0;
        for (i = 0; i < o.length; i++) {
            if (o[i].type == "text") {
                o[i].detachEvent('onfocus', this.dcse);
                o[i].attachEvent('onfocus', this.dcse);
                o[i].detachEvent('onchange', this.dcse);
                o[i].attachEvent('onchange', this.dcse)
            }
            else if (o[i].type == "password") {
                o[i].detachEvent('onfocus', this.dcse);
                o[i].attachEvent('onfocus', this.dcse)
            }
        }
        o = d.getElementsByTagName("TEXTAREA");
        for (var i = 0; i < o.length; i++) {
            o[i].detachEvent('onfocus', this.dcse);
            o[i].attachEvent('onfocus', this.dcse);
            o[i].detachEvent('onchange', this.dcse);
            o[i].attachEvent('onchange', this.dcse)
        }
        o = d.getElementsByTagName("SELECT");
        for (var i=0;i<o.length;i++){
            o[i].detachEvent('onchange', this.dcse);
            o[i].attachEvent('onchange', this.dcse)
        }

        //d.detachEvent&&d.detachEvent('ontouchstart', this.dcse);
        //d.attachEvent&&d.attachEvent('ontouchstart', this.dcse)
        d.detachEvent&&d.detachEvent('onclick', this.dcse);
        d.attachEvent&&d.attachEvent('onclick', this.dcse)
    }
    else{
        o = d.getElementsByTagName("INPUT");
        var i = 0;
        for (i = 0; i < o.length; i++) {
            if (o[i].type == "text") {
                o[i].addEventListener('focus', this.dcse, false);
                o[i].addEventListener('change', this.dcse, false)
            }
            else if (o[i].type == "password") {
                o[i].addEventListener('focus', this.dcse, false);
            }
        }
        o = d.getElementsByTagName("TEXTAREA");
        for (var i = 0; i < o.length; i++){
            o[i].addEventListener('focus', this.dcse, false);
            o[i].addEventListener('change', this.dcse, false) 
            }
        o=d.getElementsByTagName("SELECT");
        for (var i=0;i<o.length;i++)
            o[i].addEventListener('change', this.dcse,false);
        
        //d.addEventListener('touchstart', this.dcse, false);
        d.addEventListener('click', this.dcse, false);
        
        window.addEventListener('load', function () {
               window.FastClick&&FastClick.attach(document.body);
           }, false);
    }
};
WebTrends.prototype.dcse = function(evt) {
if(typeof(_tag.dcsE)=="function") {_tag.dcsE(evt);return;}
var t=document.all?window.event.srcElement:evt.target;
//if(_tag.le=="touchstart"&&evt.type=="click") {_tag.le=evt.type;return;}
if(evt.type == "click"||evt.type == "touchstart") (_tag.c)++;
		
var a=_tag.WT;
//_tag.le=evt.type;
a.tsp=a.ttp=a.obj=a.inputval=a.area=a.obj=a.texturl=a.textarea=a.textSerial=a.si_entry=a.pn_entry=null;
if(!_tag.dcsv(t, "otitle"))
{
    var p=t;
    for(var i=0;i<4;i++)
    {
        if(p.parentNode)
        {
            p = p.parentNode;
            if (p && _tag.dcsv(p, "otitle")) {
                t = p;
                break;
            }
        }
        else break;
    }
}

var tn = t.tagName.toLowerCase();
if(tn=="select"&&evt.type!="change") return;
if (!_tag.dcsv(t, "otitle")) return;

a.ti = _tag.dcsv(t, "otitle");
a.obj = _tag.dcsv(t, "otype");
a.area = _tag.dcsv(t, "oarea");

if(a.obj=="entry")
{
    a.si_entry=a.ti;
}
else if(a.obj=="nav")
{
    a.pn_entry=a.ti;
}
else if(tn=="a"&&a.obj&&a.obj.indexOf("adtext")>-1)
{
    a.texturl = t.href;
    a.textarea = _tag.dcsv(t,"adtextArea");   
    a.ti = t.innerText||t.textContent||a.ti;
    var o = document.getElementsByTagName("A");    
    var i,j;
    for(i=0,j=0;i<o.length;i++)
    {
        if(_tag.dcsv(o[i],"adtextArea")==a.textarea) 
        {
            j++;
            if(o[i] == t)
            {   
                a.textSerial = j;break;
            }
        }
    }
}
else if(t.type=="text"||t.type=="password"||tn=="textarea") {
  if(evt.type == "click"||evt.type == "touchstart") return; 
    else if(evt.type == "change")
    {
        a.inputval = t.value;
        a.obj = "input"
    }
}
else
if(t.type=="radio"){
    a.inputval=t.value
}
else
if(t.type=="checkbox"){
    a.inputval=t.checked?"1":"0"
}
else
if(tn=="select"){
    a.inputval=t.options[t.selectedIndex].text
}
_tag.url=dcsGetUrlInfo(location.href); 
var url=_tag.Getdcsuri()+"\/"+evt.type+".event";
a.pageurl = "http://" + window.location.hostname+_tag.Getdcsuri();
a.pagetitle = document.title||'';
var tire=new RegExp("^weixin://private/setresult/(.*)");
a.pagetitle=a.pagetitle.replace(tire,"微信页面"); 
_tag.dcsTrack({'DCS.dcsuri':url,'WT.ti': a.ti,'WT.dl':25,'DCSext.wt_click':'page'},{'trackType':'beacon','paramsKeep':'DCS.dcsuri|WT.ti'});
a.tsp=a.ttp=a.obj=a.inputval=a.area=a.obj=a.texturl=a.textarea=a.textSerial=a.si_entry=a.pn_entry=a.pageurl=a.pagetitle=null;
};

WebTrends.prototype.dcsisS = function()
{
    if ((this.DCS.dcsref) == null) return false;
    var u = this.DCS.dcsref.toLowerCase();
    if (/.baidu.com|.google.|.360.cn|.so.com|.haosou.com|.sm.cn|.yahoo.|.soso.com|.114search.|.aol.com|.bing.com|.sogou.com|.live.com/.test(u) && /.baidu.com\/|[?&]keyword=|[?&]key_word=|[?&]word=|[?&]wd=|[?&]q=|[?&]p=|[?&]w=|[?&]query=/.test(u)) return true;
    else return false;
};
WebTrends.prototype.dcsGetRef = function()
{
    var d = this.WT;
    var m = this.qry["wt.mc_id"]||d.mc_id;
    d.pa_dom = this.DCS.dcssip;
    var r = this.DCS.dcsref;
    if(r){
        var a = r.split("/");
        if(a.length>2) r = a[2];
    }
    
    if((r==null||r==""||r.indexOf(this.FPCConfig.domain)!=-1||r.indexOf(".pingan.com")!=-1||r.indexOf(".4008000000.com")!=-1)&&(m==null||m==""))
    {
        d.pa_ref="direct";
    }
    else if(this.dcsisS())
    {
        if(m&&m!="")
            d.pa_ref="sem";
        else
            d.pa_ref="seo";
    }
    else if(m&&m!=""){
        var a=new Array("sms","edm");
        for(var i=0;i<a.length;i++)
        {
            if(m.indexOf(a[i])>-1) {d.pa_ref = a[i];break}
        }
        if(!d.pa_ref) d.pa_ref="other_campaign";
    }
    else
        d.pa_ref="freelink";

};
WebTrends.prototype.dcsTP = function () {
    var name = "WT_DC";

    if (this.dcsGetCookie(name)) {
        this.WT.ttp = "1";
    }
    if (this.dcsGetMeta("SmartView_Page") == "1") {
        this.WT.tsp = "1";
        document.cookie = name + "=tsp=1; path=/; domain="+this.FPCConfig.domain;
    } else {
        this.dcsDeleteCookie(name,"/",this.FPCConfig.domain);
    }
};
WebTrends.prototype.dcsGetMeta = function (n) {
    var s;
    if (document.all) {
        s = document.all.tags("meta");
    } else if (document.documentElement) {
        s = document.getElementsByTagName("meta");
    }
    if (typeof (s) != "undefined") {
        for (var i = 0; i < s.length; i++) {
            var m = s.item(i);
            if (m.name && (m.name.indexOf(n) == 0)) {
                return m.content;
            }
        }
    }
    return null;
};
WebTrends.prototype.dcssmac = function () {
    if (this.dcsGetMeta("SmartView_Page") == "1") {
        var o = new Array();
        if (window.attachEvent) {
            o = document.getElementsByTagName("A");
            for (var i = 0; i < o.length; i++) {
                if (o[i].href.indexOf("http") == 0) {
                    o[i].detachEvent('onclick', this.dcssme);
                    o[i].attachEvent('onclick', this.dcssme);
                }
            }
        }
        if (window.addEventListener) {
            o = document.getElementsByTagName("A");
            for (var i = 0; i < o.length; i++) {
                if (o[i].href.indexOf("http") == 0) o[i].addEventListener('click', this.dcssme, false);
            }
        }
    }
};
WebTrends.prototype.dcssme = function () {
    var t = _tag.dcsid;
    _tag.dcsid="dcssxwu8kj0ujdxxt6w5gxvjy_3j8z";
    _tag.dcsTrack({'WT.dl':22,'WT.pa_smlink':1},{"trackType":"beacon"});
    _tag.dcsid=t
};
WebTrends.prototype.dcspaAutoContent = function(){
	var a = this.WT;
	var r = this.DCS.dcsref;
    var c = window.location.pathname.split("/");
    if(c[2]&&!a.pa_cgn) a.pa_cgn = c[1];
    if(c[3]&&!a.pa_cgs) a.pa_cgs = c[2];
    
    if(r&&r.indexOf(this.FPCConfig.domain)>0)
    {
	    c = r.split("?")[0].split("/");
	    if(c[4]) a.re_cgn = c[3];
	    if(c[5]) a.re_cgs = c[4];
    }
};
WebTrends.prototype.Getdcsuri = function(){
	if (_tag.dcsGetMeta("UriWithHash") == "1") 
		return dcsStr(_tag.url?(_tag.url.pathname+_tag.url.hashPathname):window.location.pathname,250);
	else return dcsStr(window.location.pathname,250);
}
WebTrends.prototype.dcsHistory = function(){
	try{
		if(window.localStorage){
			var n,k,v={},s={},d,nm,vn,u,i,t,d,m,w,cn,cs,mc,cnm,csm,mcm
			w=this.WT
			n="WT-History";
			try{s=JSON.parse(window.localStorage.getItem(n))||{};}catch(e){s={};}
			if(!(typeof(s) == "object" && Object.prototype.toString.call(s).toLowerCase() == "[object object]" && !s.length))
			s={};
			u=this.dcsEncode(this.DCS.dcsuri+'#'+this.WT.ti)+'|';
			t=new Date();
			d = t.getFullYear()+'-'+(t.getMonth()+1)+'-'+t.getDate();
			m = t.getFullYear()+'-'+(t.getMonth()+1);
			
			k='pv'+d;v[k]=s[k]||'|';
			if(v[k].indexOf('|'+u)<0){
				this.WT.vt_f_p=1;
				v[k]+=u;
			}

			k='pv'+m;v[k]=s[k]||'|';
			if(v[k].indexOf('|'+u)<0){
				this.WT.vt_f_p_m=1;
				v[k]+=u;
			}



			k='cn'+d;v[k]=s[k]||'|';
			k='cn'+m;v[k]=s[k]||'|';
			if(w.cg_n){
				u=this.dcsEncode(w.cg_n)+'|';
				k='cn'+d;
				if(v[k].indexOf('|'+u)<0){
					this.WT.vt_f_cgn=1;
					v[k]+=u;
				}
				k='cn'+m;
				if(v[k].indexOf('|'+u)<0){
					this.WT.vt_f_cgn_m=1;  
					v[k]+=u;
				}
			}
			
			k='cs'+d;v[k]=s[k]||'|';
			k='cs'+m;v[k]=s[k]||'|';
			if(w.cg_s){
			u=this.dcsEncode(w.cg_s)+'|';
			k='cs'+d;
			if(v[k].indexOf('|'+u)<0){
					this.WT.vt_f_cgs=1;
					v[k]+=u;
				}
			k='cs'+m;
			if(v[k].indexOf('|'+u)<0){
					this.WT.vt_f_cgs_m=1;  
					v[k]+=u;
				}
			}

			var cm=this.qry["wt.mc_id"]||w.mc_id;
			k='mc'+d;v[k]=s[k]||'|';
			k='mc'+m;v[k]=s[k]||'|';
			if(cm){
			u=this.dcsEncode(cm)+'|';
			k='mc'+d;
			if(v[k].indexOf('|'+u)<0){
					this.WT.vt_f_mc=1;
					v[k]+=u;
				}
			k='mc'+m;
			if(v[k].indexOf('|'+u)<0){
					this.WT.vt_f_mc_m=1;  
					v[k]+=u;
				}
			}

			var l=w.si_n||w.pn_sku;
			k='sin'+d;v[k]=s[k]||'|';
			k='sin'+m;v[k]=s[k]||'|';
			k='si'+d;v[k]=s[k]||'|';
			k='si'+m;v[k]=s[k]||'|';
			if(l){
			u=this.dcsEncode(l)+'|';
			k='sin'+d;
			if(v[k].indexOf('|'+u)<0){
					this.WT.vt_f_sin=1;
					v[k]+=u;
				}
			k='sin'+m;
			if(v[k].indexOf('|'+u)<0){
					this.WT.vt_f_sin_m=1;
					v[k]+=u;
				}
				var b=w.si_p||w.si_x||w.page_name;
				if(b){
					u=this.dcsEncode(l+'-'+b)+'|';
					k='si'+d;
					if(v[k].indexOf('|'+u)<0){
							this.WT.vt_f_si=1;
							v[k]+=u;
						}
					k='si'+m;
					if(v[k].indexOf('|'+u)<0){
						this.WT.vt_f_si_m=1;
						v[k]+=u;
					}
				}
			}
			window.localStorage.setItem(n,JSON.stringify(v));}
	}
	catch(e){}
};
WebTrends.prototype.dcsLoad = function(){
this.dcspaAutoContent();
this.dcsGetRef();
this.WT.hash = window.location.hash.substring(1).split('?')[0];
this.dcsTP();
};
WebTrends.prototype.dcsComplete = function(){
this.autoclick();
this.dcssmac();
};
function dcsMultiTrack(){
	if (typeof(_tag)!="undefined"){
		return(_tag.dcsMultiTrack());
	}
};
function pa_sdcajax() {
    if (typeof(_tag) != "undefined") {
        return (_tag.pa_sdcajax())
    }
};
function dcsTrack(d,c) {
	    if (typeof(_tag) != "undefined") {
	        return (_tag.dcsTrack(d,c))
	    }
};
var _tag = new WebTrends();
try{_tag.autoclick()}catch(e){};
document.onreadystatechange=function(){"complete"==document.readyState&&_tag.dcsComplete()};
var WT = _tag.WT;
var DCS = _tag.DCS;
var DCSext = _tag.DCSext;

function dcsTrim(s)
{
    var str = new String(s);
    return str.replace(/(^\s*)|(\s*$)|(\#$)/g, '');
}
function dcsStr(a,b,c){return a.length<=b?a:c?a.substring(a.length-b):a.substring(0,b)}
function dcsSubRef(a) {
    var b, c, d, e, f, g, h;
    for (a = a.toLowerCase(), /baidu.com|google.com|so.com|haosou.com|sogou.com/.test(a) && (a = a.replace("wd=&", "wd=Search%20phrase%20not%20provided&").replace("word=&", "word=Search%20phrase%20not%20provided&"), 
    /so.com/.test(a) && !/[?&]q=.*&/.test(a) && (a += "&q=Search%20phrase%20not%20provided")); a.length > 600 && (b = a.split("?"), 
    f = 0, g = "", b.length > 1) && (c = b[1], d = c.split("&"), d.length > 1); ) {
        for (h = 0; h < d.length; h++) e = d[h].split("=")[0], val = d[h].split("=")[1], 
        "undefined" != typeof val && val.length > f && (f = val.length, g = -1 != a.indexOf("?" + e) ? e.toString() + "=" + val.toString() :"&" + e.toString() + "=" + val.toString());
        a = a.replace(g, "");
    }
    return a;
}
function dcsGetUrlInfo (url) {
	var o = document.createElement('href'), result;
	o.href = url;
	url = o.href;
	var regex = /((?:https?|ftp|mms):)\/\/([A-z0-9_\-\.]+)+(?:\:(\d+))?((?:\/[\u4e00-\u9fa5A-z0-9_\-\.=&,+%:/@$;]*)*)(\?[\u4e00-\u9fa5A-z0-9_\-\.=&,+%:/@$;]*)?(#[\u4e00-\u9fa5A-z0-9_\-\.=&,+%:/?@$;#]*)?/i;
	if (regex.test(url)) {
		result = url.match(regex);
		!result[6] && (result[6] = '');
		result = {
			href: result[0] || '',
			protocol: result[1] || '',
			host: result[2] + (result[3] ? ':' + result[3] : ''),
			hostname: result[2] || '',//www.pingna.com
			port: result[3] || '',
			pathname: result[4] || '',///index.html
			search: result[5] || '',//?a=xx
			hash: result[6] || '', //#xx?a=1&b=2
			hashPathname: (result[6].split('?')[0] || ''), //#xx
			hashSearch: (result[6].split('?')[1]?'&'+result[6].split('?')[1]:'') //&a=1&b=2
		};
	}
	return result;
}
if (_tag.dcsGetMeta("Exit_Page") == "1") {
	"function" == typeof navigator.sendBeacon && (window.onbeforeunload = function() {
	    ("visible" != document.visibilityState) && dcsTrack({
	        "WT.dl":99,
	        "WT.hitonpage":_tag.c.toString(),
	        "WT.page_readyState":document.readyState,
	        "WT.document_visibilityState":document.visibilityState
	    }, {
	        trackType:"beacon"
	    });
	}, window.onvisibilitychange = function() {
	    ("hidden" == document.visibilityState || "unloaded" == document.visibilityState) && dcsTrack({
	        "WT.dl":98,
	        "WT.hitonpage":_tag.c.toString(),
	        "WT.page_readyState":document.readyState,
	        "WT.document_visibilityState":document.visibilityState
	    }, {
	        trackType:"beacon"
	    });
	});
}