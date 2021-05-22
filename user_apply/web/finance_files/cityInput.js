var allCity=[];

//热门城市{"cityCode":"","cityName":"热门城市"},
//var hotCityList = [{"cityCode":"110100","cityName":"北京市"},{"cityCode":"310100","cityName":"上海市"},{"cityCode":"440100","cityName":"广州市"},{"cityCode":"440300","cityName":"深圳市"},{"cityCode":"320100","cityName":"南京市"},{"cityCode":"320500","cityName":"苏州市"},{"cityCode":"330100","cityName":"杭州市"},{"cityCode":"370100","cityName":"济南市"},{"cityCode":"370200","cityName":"青岛市"},{"cityCode":"420100","cityName":"武汉市"},{"cityCode":"430100","cityName":"长沙市"},{"cityCode":"210100","cityName":"沈阳市"},{"cityCode":"510100","cityName":"成都市"},{"cityCode":"500100","cityName":"重庆市"},{"cityCode":"610100","cityName":"西安市"},{"cityCode":"340100","cityName":"合肥市"},{"cityCode":"350100","cityName":"福州市"},{"cityCode":"220100","cityName":"长春市"},{"cityCode":"130100","cityName":"石家庄"},{"cityCode":"410100","cityName":"郑州市"},{"cityCode":"120100","cityName":"天津市"}];
var hotCityList = [{"cityCode":"110000","cityName":"北京"},{"cityCode":"310000","cityName":"上海"},
                   {"cityCode":"440100","cityName":"广州"},{"cityCode":"440300","cityName":"深圳"},
                   {"cityCode":"510100","cityName":"成都"},{"cityCode":"330100","cityName":"杭州"},
                   {"cityCode":"500000","cityName":"重庆"},{"cityCode":"410100","cityName":"郑州"},
                   {"cityCode":"350200","cityName":"厦门"},{"cityCode":"320500","cityName":"苏州"},
                   {"cityCode":"370100","cityName":"济南"},{"cityCode":"610100","cityName":"西安"},
                   {"cityCode":"420100","cityName":"武汉"},{"cityCode":"430100","cityName":"长沙"},
                   {"cityCode":"350500","cityName":"泉州"},{"cityCode":"520100","cityName":"贵阳"}];
$(function(){
	$.ajax({
		type:"get",
		url:"/queryCityList.do",
		dataType:"json",
		success:function (response){
			if(response.isSuccess=='T'){
                allCity=response.activity;
        	}
			displayItems("");
		}
	});
	$("#address").click(function(){
		$("#city_divId").removeClass("city_div").addClass("city_div1");
	});
	$(".city_li").live("click",function(e){
		var selectedCity_name = $(e.target).text();
		var selectedCity_countyCode =  $(e.target).attr("city_code");
		$("#address").val(selectedCity_name);
		$("#address").attr("selectedCity_countyCode",selectedCity_countyCode);
		$("#city_divId").removeClass("city_div1").addClass("city_div");
		});
	$("#address").on("input keyup",function(){
		$("#city_ul_id").empty();
		displayItems($("#address").val());
		});
	$("#address").blur(function(){
	$(document).click(function(e){
		var v_class=$(e.target).attr("class");
		if(v_class!="address_class"&&v_class!="city_div"&&v_class!="city_ul_class"&&v_class!="city_li"){
			$("#city_divId").removeClass("city_div1").addClass("city_div");
			}
		});
	});
});
function displayItems(items) {
	var strHtml = '';
	if (items=='') {//热门所在城市遍历
		for (var i = 0; i <hotCityList.length; i++) {//国内所在城市匹配
			if(allCity[i]['cityCode']!="370200"){
				strHtml += "<li  class='city_li' city_code='"+hotCityList[i]['cityCode']+"'>"+hotCityList[i]['cityName']+"</li>"
			}
		}
	}
	else {
		
		for (var i = 0; i < allCity.length; i++) {//国内所在城市匹配
			var reg = new RegExp('^' + items + '.*$', 'im');
			// console.log(reg);
				
			if (reg.test(allCity[i]['countyName']) || reg.test(allCity[i]['spellfullName']) || reg.test(allCity[i]['spellforshort'])) {
					strHtml +="<li class='city_li' city_code='"+allCity[i].cityCode+"' county_spell_full='"+allCity[i].spellfullName+"' county_spell_short='"+allCity[i].spellforshort+"'>"+allCity[i].countyName+"</li>"
			}
		}
		if (strHtml == '') {
			strHtml="  <li class='city_li'  value='null'>未发现城市</li>"
			}
	}
	$("#city_ul_id").html(strHtml);
}