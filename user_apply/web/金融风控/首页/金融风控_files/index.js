//登录
var loginInit = {
    Global: {
        'userName': '',
        'mobile': '',
        'isLoad': 'N',
        'hasSendCode': false,
        '$btnNext0': $('#btnNext0'),
        '$mobile': $('#phoneNum'),
        '$yzmBtn': $('#yzm_btn'),
        '$userName': $('#userName'),
        '$yzmNum': $('#yzmnum'),
        'smsSwitch': true //是否终极模式
    },
    init: function() {
        'use strict';
        var _this = this;
        _this.saveUrl();
        _this.getUltimateModeSwitch()
            .done(function(smsSwitch) {
                _this.flowControl(smsSwitch);
            })
            .fail(function(err) {
                alert("系统异常，请稍后重试");
                _this.Global.isLoad = 'N';
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
                _this.Global.smsSwitch = res.modeSwitch == "Y";
                res.errCode == '555' ? $def.reject() : $def.resolve(_this.Global.smsSwitch);
            },
            error: function(err) {
                $.reject(err);
            }
        })
        return $def.promise();
    },
    flowControl: function(smsSwitch) {
        var _this = this;
        _this.Global.smsSwitch && _this.initSmsFeature();
        _this.bind();
    },
    //初始化短信验证码
    initSmsFeature: function() {
        $("#judgCode").css("display", "block");
        yzmProcess.init();
    },
    saveUrl: function() {
        var param = location.href;
        $.ajax({
            url: '/smsurlparam/add.do',
            type: 'post',
            dataType: 'json',
            data: {
                param: param,
                type: 2
            },
            success: function(response) {

            }
        });
    },
    saveUniCustomerInfo: function(){
        var _this = this;
        var encrypt = new JSEncrypt();
        encrypt.setPublicKey('MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCJ9s1qlOyv9qpuaTqauW6fUftzE50rVk3yVPZwv1aO1Ch/XSEz76xCwkyvqpaqceRXrPpdBmO5+ruJ+I8osOHo7L5GWEOcMOO+8izp9hXKBBrmRMD4Egpn00k9DhVIEKp/vyddZPS/doxB8onhN6poTJDLdFLFVEicMf52caN9GQIDAQAB');
        var verName = encrypt.encrypt(_this.Global['userName']);
        var verMobile = encrypt.encrypt(_this.Global['mobile']);
        //终极模式 存量加密publicKey SS系统用
        encrypt.setPublicKey('MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCcTK/1zIsiZQxNgjlxLyWTMuZNjXxZZOH8HLEJiRiFjJklU83MeeeALicIPEvG8CWw5ylcssQHbSfrMsHnVkOva3dMP1ialvP/JOLsbaDOLGWx8LbGmN3RwmiT52Om8N/75dR+MXTbh9aRwxO/aH55GOUEmjXFVrCqtPg7HUxA/wIDAQAB')
        $.ajax({
            url: '/o2o/ultimateMode/saveUniCustomerInfo.do',
            type: 'post',
            dataType: 'json',
            data: {
                name: verName, //姓名
                mobile: verMobile, //手机号
                // mediaSourceCode: 'PA-07-01',
                mediaSourceCode: getMediaSouce(),
                campaignCode: 'XX_CAMP_CSJYQDA',
                custSrc: '09', 
                openId: getUrlParam('openId'),
                innerMedia: _this.getInnerMedia(), 
                lpPag: getLpPage(),
                formCode: '001',
                pageType: '3', 
                cityCode: getUrlParam('cityCode')
            },
            success: function(response) {

            }
        });
    },
    bind: function() {
        'use strict';
        var _this = this;
        $('#btnNext0').on('click', _this.clickSendData.bind(_this));
        _this.Global.smsSwitch && _this.Global.$yzmBtn.on('click', function() {
            !_this.Global.hasSendCode && _this.getCode();
        })
    },
    clickSendData: function() {
        var _this = this;
        if (_this.Global.isLoad == 'N' && _this.valid()) {
            _this.Global.isLoad = 'Y';
            if (_this.Global.smsSwitch) {
                if(!_this.verifyCode()){// 验证码校验
                    _this.Global.isLoad = 'N';
                    return
                }
                _this.checkSmsCommon()
                    .done(function() {
                        _this.sendData();
                    })
                    .fail(function(errMsg) {
                        alert(errMsg);
                        _this.Global.isLoad = 'N';
                    })
            } else {
                _this.sendData();
            }
        }
    },
    checkSmsCommon: function() {
        var _this = this,
            $def = $.Deferred(),
            params = {
            mobile: _this.Global.$mobile.val(),
            validCode: _this.Global.$yzmNum.val(),
        };
        $.ajax({
            url: '/do/common/checkSmsCommon',
            type: 'post',
            dataType: 'json',
            data: params,
            success: function(response) {
                var retCode = response.resultCode,
                    retMsg = response.resultMsg;
                if (retCode == '608' || retCode == '609' || retCode == '501' || retCode == '611') { // 验证失败
                    $def.reject(retMsg);
                } else if (retCode == '000') { // 短信验证成功
                    $def.resolve();
                } else {
                    $def.reject("系统异常");
                }
            }
        });
        return $def.promise();
    },
    valid: function() {
        'use strict';
        var _this = this;
        _this.Global['userName'] = $.trim(_this.Global['$userName'].val()); //姓名
        _this.Global['mobile'] = $.trim(_this.Global['$mobile'].val()); //手机号
        if (!_this.Global['userName']) { // 姓名校验
            alert('请输入姓名');
            return false;
        } else if (!_this.Global['userName'].match(/^[\u4e00-\u9fa5]{2,8}$/g)) {
            alert('姓名为2-8个汉字');
            return false;
        }
        // 手机号码校验   
        if (!_this.Global['mobile']) {
            alert('请输入手机号码');
            return false;
        } else if (!_this.Global['mobile'].match(/^1(3|4|5|7|8)\d{9}$/)) {
            alert('请正确填写手机号码');
            return false;
        } else {
            var value = _this.Global['mobile'],
                repeat = 0,
                seque = 0;
            for (var i = 1; i < value.length; i++) {
                if (value.charAt(i) == value.charAt(i - 1)) {
                    repeat++;
                    if (repeat >= 5) {
                        alert('请正确填写手机号码');
                        return false;
                    }
                } else {
                    repeat = 1;
                }
                if (value.charAt(i) - value.charAt(i - 1) == '1') {
                    seque++;
                    if (seque >= 6) {
                        alert('请正确填写手机号码');
                        return false;
                    }
                } else {
                    seque = 1;
                }
            }
        }
        // if(_this.Global.isyzm == 'Y'){ // 验证码校验
        //     _this.verifyCode();
        // }
        return true;
    },
    // 验证码校验
    verifyCode: function() {
        'use strict';
        var _this = this;
        var verifyCode = $.trim(_this.Global['$yzmNum'].val()); //验证码
        if (verifyCode === null || verifyCode == '' || verifyCode == '请输入验证码') {
            alert('请输入验证码');
            return false;
        } else if (verifyCode && !verifyCode.match(/^[A-Za-z0-9]{6}$/)) {
            alert('验证码输入不正确');
            return false;
        }
        return true;
    },
    /** 获取验证码 */
    getCode: function() {
        'use strict';
        var _this = this,
            countTime = 60,
            countDown;
        if (!_this.valid()) {
            return;
        }
        _this.Global.hasSendCode = true;
        _this.saveUniCustomerInfo();
        var options = {
            url: '/do/common/sendSmsCommon',
            params: {
                mobile: $('#phoneNum').val(),
                businessFlag: '4'
            },
            succFun: function(response) {
                _this.Global['$yzmBtn'].prop('disabled', false).removeClass('yzm_btn_orange');
                if (response.sendCode == '000') {
                    _this.Global.hasSendCode = true;
                    countDown = setInterval(function() {
                        setTimeout(function() {
                            countTime--;
                        }, 0)
                        _this.Global['$yzmBtn'].text(countTime + 's')
                        if (countTime == 0) {
                            clearInterval(countDown);
                            _this.Global['$yzmBtn'].addClass('yzm_btn_orange').text('重新获取').prop('disabled', false);
                            _this.Global.hasSendCode = false;
                        }
                    }, 1000)
                }else if(response.retCode == '0000'){
                    alert(response.errMsg);
                    _this.Global.hasSendCode = false;
                }else if(response.errorCode == '555'){
                    alert('系统错误，请稍候再试');
                    _this.Global.hasSendCode = false;
                }else{
                    alert(response.resultMsg);
                    _this.Global.hasSendCode = false;
                }
            },
            closeFun: function() {
                _this.Global['$yzmBtn'].addClass('yzm_btn_orange').prop('disabled', false);
                _this.Global.hasSendCode = false;
            },
            errFun: function() {

            }

        }
        yzmProcess.getCode(options);
    },
    //获取innerMedia
    getInnerMedia: function() {
        'use strict';
        var innerMedia = getCookie('inner_media');
        if (innerMedia) {
            innerMedia = decodeURI(innerMedia);
        }
        // 若cookie中为空，则默认为 'pingan'
        if (!innerMedia) {
            innerMedia = 'pingan';
        }
        return innerMedia;
    },
    sendData: function(){
        'use strict';
        var _this = this,
            commitKey;
        var RANDOMSTR = new GUID().newGUIDSimple().slice(0, 16);
        var encrypt = new JSEncrypt();
        encrypt.setPublicKey('MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCJ9s1qlOyv9qpuaTqauW6fUftzE50rVk3yVPZwv1aO1Ch/XSEz76xCwkyvqpaqceRXrPpdBmO5+ruJ+I8osOHo7L5GWEOcMOO+8izp9hXKBBrmRMD4Egpn00k9DhVIEKp/vyddZPS/doxB8onhN6poTJDLdFLFVEicMf52caN9GQIDAQAB');
        var verName = encrypt.encrypt(_this.Global['userName']);
        var verMobile = encrypt.encrypt(_this.Global['mobile']);
        //终极模式 存量加密publicKey SS系统用
        encrypt.setPublicKey('MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC+PZ6Fjf8FDxXbNtZ3IPtyEPMFcFxXE34BN4FIq+YOiYdq+S6WC+XT+h+RRc5z6ZXyAzEyOmtKR8raD64bNfBS3vUL0wi0T+ykq0+13pGntapfLA9FSiikPqvZQZVJ4omi2xeBbuFiYyz0XYt1kEZD+NdF1TJUV+8EhcyiOM2W3QIDAQAB')
        var pram = {
            name: verName, //姓名
            mobile: verMobile, //手机号
            // mediaSourceCode: 'PA-07-01',
            mediaSourceCode: getMediaSouce(),
            campaignCode: 'XX_CAMP_CSJYQDA',
            custSrc: '09', 
            openId: getUrlParam('openId'),
            innerMedia: _this.getInnerMedia(), 
            lpPag: getLpPage(),
            formCode: '001',
            pageType: '3', 
            cityCode: getUrlParam('cityCode'),
            commitKey: encrypt.encrypt(RANDOMSTR)
        };
        // var $judgCode = $('#judgCode');
        // if($judgCode.is(':visible')){
        //     pram.attack_check_code = self.Global['imgCode'];
        // }
        $.ajax({
            type: 'post',
            url: '/uni/initApply.do',
            data: pram,
            dataType: 'json',
            success: function(res){
                if(res.errorCode == '555'){
                    alert(res.message);
                    _this.Global.isLoad = 'N';
                } else if (res.retCode == 'P001') {
                    window.location.href = '/product/oto/website/O2Opc/result1.html';
                } else{
                    var code = res.retCode;
                    var patt = new RegExp('x', 'i');
                    var isError = patt.test(code);
                    if(isError){
                        if (code == 'X013') {
                            alert('名单已申请，请勿重复提交');  
                        }else{
                            alert('系统异常，请稍后再试');
                        }
                        _this.Global.isLoad ='N';
                    }else{
                        if(code == '001') {//各产品页
                            var indexCode = res.result.businessType;
                            var indexUni = res.result.uniqueId;
                            var money = parseInt(res.result.preAmt); 
                            if(indexCode == '1' || indexCode == '2' || indexCode === 'UNI-1' || indexCode === 'UNI-2' || indexCode === 'STP' || indexCode === '1,2'){//CHESHOU
                                var gbdType = res.result.gbdType;
                                window.location.href = ['/product/oto/website/O2Opc/result3_uni.html', '?uniqueId=', indexUni, '&money=', money, '&gbdType=', gbdType].join('');
                            }else if(['4', '10'].indexOf(indexCode) > -1){
                                if(_this.Global.smsSwitch){
                                    _this.o2oInitInfo();
                                }else{
                                    window.location.href = ['/daikuan/yqdai/2.0/index.html?uniqueId=', indexUni].join('');
                                }   
                            } else if (indexCode == '7') {
                                window.location.href = '/product/oto/website/O2Opc/result1.html';
                            }
                        }else if(code == '002' || code == '003'){// 筛选页
                            if (res.flowId) {
                                window.location.href = ['step1.html', '?flowId=', res.flowId].join('');
                            }else{
                                window.location.href = 'step1.html';
                            }
                        }else if(code == '101'){// 流程查询页
                            window.location.href = '/product/oto/website/O2Opc/to-mobile-jdcx.html';
                        }else if(code == '901'){// APP 下载页
                            window.location.href = '/client/iloan/marketStep1.html?utm_source=phmk-ZHPP&utm_medium=mkt&utm_campaign=mkt&utm_content=puhui&WT.mc_id=wap-cxx-zhpp-puhui-ilone-153';
                        }else if(code == '902' || code == '004'){// 坐席跟进页
                            window.location.href = 'success.html';
                        }else if(code == '903'){// 错误页
                            alert('您暂不符合条件，感谢关注', '/');
                            _this.Global.isLoad = 'N';
                        }else if(code == '999'){// 错误页
                            alert('系统错误');
                            _this.Global.isLoad = 'N';
                        }
                    }
                }
            },
            
            error: function(jqXHR, textStatus, errorThrown){
                _this.Global.isLoad = 'N';
                console.log(textStatus);
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
    //获取url的传过来的参数
    getUrlId: function(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg); //匹配目标参数
        if (r != null) return decodeURI(r[2]);
        return null; //返回参数值
    }
};
loginInit.init();
