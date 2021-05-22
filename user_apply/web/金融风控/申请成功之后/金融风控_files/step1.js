$(function() {
    'use strict';
    loginInit.init();
});

var loginInit = {
    init: function() {
        'use strict';
        var _this = this;
        _this.Field = {
            'isLoad': 'N',
            'flowId': '',
            'uniqueId': '',
            '$cityCode': $('#address'),
            '$btnNext0': $('#btnNext0'),
            'smsSwitch': true //是否终极模式
        };
        _this.getUltimateModeSwitch()
        .done(function(smsSwitch){
            _this.Field.smsSwitch = smsSwitch;
        })
        .fail(function(err) {
                _this.alertBox("系统异常，请稍后重试")
                _this.Field.isLoad = 'N';
                $('#loading').hide();
        })
        _this.bind();
        _this.Field.flowId = getUrlParam('flowId');
        _this.Field.uniqueId = getUrlParam('uniqueId');
        _this.sessionTimeoutStart_uni(_this.Field.flowId, '', '', 'WAP');
    },
    bind: function() {
        'use strict';
        var _this = this;
        _this.Field.$btnNext0.on('click', function() {
            if (_this.Field.isLoad == 'N' && _this.valid()) {
                _this.sendData();
            }
        });
        //城市
        //showCity($('#cityCode'));
    },
    valid: function() {
        'use strict';
        var _this = this,
            cityCode = _this.Field['$cityCode'].val(),
            selectAge = $('#age dt').attr('aaa'),
            hasCreditCard = $('input[name="isCreditCard"]:checked').val(),
            liveOver = $('input[name="liveTime"]:checked').val(),
            hasMortgage = $('input[name="hasHouseLoan"]:checked').val(),
            hasAuto = $('input[name="hasCar"]:checked').val(),
            hasAutoLoan = $('input[name="payCarLoan"]:checked').val(),
            hasInsurance = $('input[name="hasLifeInsurance"]:checked').val(),
            annualOver = $('input[name="lifeInsuranceTotal"]:checked').val();
        if (!selectAge) {
            alert('请选择年龄段');
            return false;
        }
        if (!hasCreditCard) {
            alert('请选择是否有过信用卡');
            return false;
        }
        if (!cityCode || cityCode == '填写中文/拼音') {
            alert('请选择工作城市');
            return false;
        }
        if (!liveOver) {
            alert('请选择在该城市工作或居住时间');
            return false;
        }
        if (!hasMortgage) {
            alert('请选择在该城市是否有过房贷');
            return false;
        }
        if (!hasAuto) {
            alert('请选择名下是否有私家车');
            return false;
        }
        if (hasAuto == 'Y' && !hasAutoLoan) {
            alert('请选择是否目前还在还车贷');
            return false;
        }
        if (!hasInsurance) {
            alert('请选择是否购买过寿险保单');
            return false;
        }
        if (hasInsurance == 'Y' && !annualOver) {
            alert('请选择名下寿险年保费合计');
            return false;
        }
        return true;
    },
    sessionTimeoutStart_uni: function(flowid, time, notFirstTime, source) {
        'use strict';
        var _this = this;
        if (time == '60') {
            window.toTimeoutPageId = setTimeout(function() { //启动会话超时计时，并保存该计时ID, 30分钟 30*60*1000=1800000
                if (source == 'WAP') {
                    var secretUniqueId = getCookie('secretUniqueId');
                    if (null !== secretUniqueId && '' != secretUniqueId) {
                        window.location.href = '/m/Market/2017/01/01/index.html';
                    } else {
                        window.location.href = '/microWebsite/jdcx_check.html';
                    }
                } else {
                    window.location.href = '/product/oto/website/O2Opc/to-mobile-jdcx.html';
                }
            }, 3600000);
        } else {
            window.toTimeoutPageId = setTimeout(function() { //启动会话超时计时，并保存该计时ID, 60分钟 60*60*1000=3600000
                if (source == 'WAP') {
                    var secretUniqueId = getCookie('secretUniqueId');
                    //topup加密uniqueId不为空，代表未验证过手机，直接跳到topup首页
                    if (null !== secretUniqueId && '' != secretUniqueId) {
                        window.location.href = '/m/Market/2017/01/01/index.html?uniqueId=' + secretUniqueId;
                    } else {
                        window.location.href = '/microWebsite/jdcx_check.html';
                    }
                } else {
                    window.location.href = '/product/oto/website/O2Opc/to-mobile-jdcx.html';
                }
            }, 1800000);
        }
        if (!notFirstTime) {
            //启动保持流程计时器
            keepFlow(flowid, source);
            //用户点击了页面，清除两个之前的计时器，重新计时
            $('body').bind('click', function() {
                clearTimeout(toTimeoutPageId);
                //clearTimeout(tipToUserTimeout);
                if (time == '60') {
                    _this.sessionTimeoutStart_uni(flowid, '60', true, source);
                } else {
                    _this.sessionTimeoutStart_uni(flowid, '', true, source);
                }
            });
        }
        /**
         *   保持流程，每30秒发一次
         */
        function keepFlow(flowid, source) {
            if (flowid != '' && flowid !== null) {
                window.flowIntervalId = setInterval(function() {
                    $.ajax({
                        url: '/do/keep-flow-ctx.do?flowId=' + flowid,
                        dataType: 'json',
                        success: function(data) {
                            if (data.resultCode != '0') {
                                alert('抱歉，您的页面超时了。为了您的安全，请验证手机后继续申请。');
                                clearInterval(flowIntervalId);
                                var secretUniqueId = getCookie('secretUniqueId');
                                if (null !== secretUniqueId && '' != secretUniqueId) {
                                    window.location.href = '/m/Market/2017/01/01/index.html?uniqueId=' + secretUniqueId;
                                } else {
                                    if ('WAP' == source) {
                                        window.location.href = '/microWebsite/jdcx_check.html';
                                    } else {
                                        window.location.href = '/product/oto/website/O2Opc/to-mobile-jdcx.html';
                                    }
                                }
                            }
                        },
                        error: function() {
                            if ('WAP' == source) {
                                window.location.href = '/microWebsite/jdcx_check.html';
                            } else {
                                window.location.href = '/product/oto/website/O2Opc/to-mobile-jdcx.html';
                            }
                        }
                    });
                }, 30000);
            }
        }
    },
    sendData: function() {
        'use strict';
        var _this = this,
            returnUrl = '';
        var cityCode = $('#address').attr('selectedcity_countycode');
        var pram = {
            age: $('#age dt').attr('aaa'),
            hasCreditCard: $('input[name="isCreditCard"]:checked').val(),
            cityCode: cityCode,
            cityName: $('#address').val(),
            liveOver: $('input[name="liveTime"]:checked').val(),
            hasMortgage: $('input[name="hasHouseLoan"]:checked').val(),
            hasAuto: $('input[name="hasCar"]:checked').val(),
            hasAutoLoan: $('input[name="hasCar"]:checked').val() == 'Y' ? $('input[name="payCarLoan"]:checked').val() : 'N',
            hasInsurance: $('input[name="hasLifeInsurance"]:checked').val(),
            annualOver: $('input[name="hasLifeInsurance"]:checked').val() == 'Y' ? $('input[name="lifeInsuranceTotal"]:checked').val() : 'N'
        };
        _this.Field.isLoad = 'Y';
        if (_this.Field.flowId) {
            returnUrl = '/uni/moreinfo.do?flowId=' + _this.Field.flowId;
        } else {
            returnUrl = '/uniExternal/filterInfoDeal.do?uniqueId=' + _this.Field.uniqueId;
        }
        $('#loading').show();
        $.ajax({
            type: 'post',
            url: returnUrl,
            async: false,
            data: pram,
            dataType: 'json',
            success: function(res) {
                var code = res.retCode;
                var patt = new RegExp('x', 'i');
                var isError = patt.test(code);
                if (isError) {
                    alert('系统异常，请稍后再试');
                    _this.Field.isLoad = 'N';
                    $('#loading').hide();
                } else if (res.errorCode == '555') { //各产品页
                    alert(res.message);
                    _this.Field.isLoad = 'N';
                    $('#loading').hide();
                } else if (code == '001') { //各产品页
                    var indexCode = res.result.businessType;
                    var indexUni = res.result.uniqueId;
                    // var money = Math.max(res.result.preAmt1, res.result.preAmt2 ); 
                    if (indexCode == '4') { //OTO
                        if(_this.Field.smsSwitch){
                            _this.o2oInitInfo();
                        }else{
                            window.location.href = ['/daikuan/yqdai/2.0/index.html?uniqueId=', indexUni].join('');
                        }
                    }
                } else if (code == '901' || code == 'T001') { // APP 下载页
                    window.location.href = '/client/iloan/marketStep1.html';
                } else if (code == '902') { // 坐席跟进页
                    window.location.href = 'success.html';
                } else if (code == '903') { // 错误页
                    alert('您暂不符合条件，感谢关注', '/');
                    _this.Field.isLoad = 'N';
                    $('#loading').hide();
                } else if (code == '999') { // 错误页
                    alert('系统错误');
                    _this.Field.isLoad = 'N';
                    $('#loading').hide();
                } else if (code == '002') {
                    alert('已有筛选信息，请勿再次提交');
                    _this.Field.isLoad = 'N';
                    $('#loading').hide();
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                _this.Field.isLoad = 'N';
                $('#loading').hide();
                console.log(errorThrown);
            }
        });
    },
    //终极模式 O2O名单初始化接口
    o2oInitInfo: function(response) {
        var _this = this;
        $.ajax({
            url: '/do/o2o/ultimateMode/o2oInitInfo',
            data: {},
            type: 'POST',
            success: function(response) {
                response = typeof response == 'string' ? JSON.parse(response) : response;   
                $('#loading').hide();
                if (response.errorCode == '555') {
                    _this.alertBox('系统异常，请稍后重试！');
                    _this.hasSubmit = false;
                } else if (response.resultCode == '001') {
                    window.location.href = '/product/oto/2.0/O2Opc/step-3.html';
                } else {
                    _this.alertBox('系统错误，请稍后重试');
                }
            },
            error: function() {
                $('#loading').hide();
                _this.alertBox('系统错误，请稍后重试');
            }
        })
    },
        //获取终极模式开关
    getUltimateModeSwitch: function() {
        var _this = this,
            $def = $.Deferred();
        $.ajax({
            url: "/do/o2o/ultimateMode/ultimateModeSwitch",
            type: "GET",
            dataType: "json",
            success: function(res) {
                res = typeof res == "string" ? JSON.parse(res) : res;
                _this.Field.smsSwitch = res.modeSwitch == "Y";
                res.errCode == '555' ? $def.reject() : $def.resolve(_this.Field.smsSwitch);
            },
            error: function(err) {
                $def.reject(err);
            }
        })
        return $def.promise();
    }
};