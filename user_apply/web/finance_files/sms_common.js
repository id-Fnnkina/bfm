
;
(function() {
    var yzmHtml =
        '<section class="leayer graphic-code" style="display: none">' +
        '<div class="graphic-code-popup por">' +
        '<div class="close"></div>' +
        '<div class="pop-stit">请输入图形验证码</div>' +
        '<ul class="test">' +
        '<li class="dl yzm-clear">' +
        '<div class="dt fl"><input type="text" id="veryCode" class="ipt" maxlength="4" placeholder="请输入右边的图形码"></div>' +
        '<div class="dd dd-txt-img fl"><img id="validateImg" src="" alt="图像码"></div>' +
        '<div class="change fr" id="userimgcode"><span class="icon"></span><span>换一换</span></div>' +
        '</li>' +
        '</ul>' +
        '<div class="sure-btn" id="yzm-confirm">确定</div>' +
        '</div>' +
        '</section>' +
        '<section class="graphic-code" id="yzm-error" style="display: none">' +
        '<div class="graphic-code-popup-error">图形码输入错误</div>' +
        '</section>';

    var yzmProcess = {
        init: function() {
            var _this = this;
            _this.addCSS();
            $('body').append(_this.yzmHtml);
            _this.events();
        },
        events: function() {
            var _this = this;
            $('#userimgcode').on('click', _this.changeImg.bind(_this));
            $('#yzm-confirm').on('click', _this.submit.bind(_this));
            $('div.close').on('click', _this.hideYzm.bind(_this));
        },
        yzmHtml: yzmHtml,
        data: {
            vc: '',
            s: '',
            businessFlag: '',
            mobile: ''
        },
        succFun: $.noop,
        closeFun: $.noop,
        errFun: $.noop,
        showYzm: function() {
            $('section.leayer, div.popup.por').css('display', 'block');
        },
        hideYzm: function() {
            $('section.leayer, div.popup.por').css('display', 'none');
            this.closeFun();
        },
        addCSS: function() {
            var link = document.createElement('link');
            link.type = 'text/css';
            link.rel = 'stylesheet';
            link.href = '/Market/yzmCommon/css/graphic-code.css';
            document.getElementsByTagName("head")[0].appendChild(link);
        },
        changeImg: function() {
            $('#veryCode').val('');
            $("#validateImg").removeAttr("src");
            $("#validateImg").attr("src", "/do/loan/verifyCode?" + Math.random());
        },
        yzmError: function(flag) {
            var errText = flag == 'empty' ? '请输入图形码' : '图形码输入错误';
            $('#yzm-error').fadeIn('2000');
            $('.graphic-code-popup-error').html(errText);
            var timeout = setTimeout(function() {
                $('#yzm-error').fadeOut('1500');
                $('.graphic-code-popup-error').html('');
                clearTimeout(timeout);
            }, 1500);
        },
        submit: function() {
            var _this = this,
                yzmVal = $('#veryCode').val(),
                isYzmNull = yzmVal === null || yzmVal == '' || yzmVal == undefined,
                isYzmErr = !yzmVal.match(/^[A-Za-z0-9]{4}$/);

            if (isYzmNull || isYzmErr) {
                isYzmErr && yzmVal.length == 4 && _this.changeImg();
                _this.yzmError(isYzmNull ? 'empty' : 'err');
            } else {
                var options = {
                    params: $.extend(_this.data, { vc: yzmVal }),
                    succFun: _this.succFun,
                    closeFun: _this.closeFun,
                    errFun: _this.errFun,
                    url: _this.url
                };
                _this.getCode(options);
            }
        },
        getCode: function(options) {
            var _this = this;

            $.extend(_this.data, options.params);
            _this.succFun = options.succFun;
            _this.closeFun = options.closeFun || _this.closeFun;
            _this.errFun = options.errFun;
            _this.url = options.url;
            $.ajax({
                type: 'POST', //发送---发送验证码/do/common/sendSmsCommon
                url: options.url || '/do/common/sendSmsCommon',
                data: options.params,
                dataType: 'json',
                success: function(response) {
                    if ('9001' === response.resultCode) {
                        //需要输入图形验证码 
                        _this.changeImg();
                        _this.showYzm();
                    } else if ('9002' === response.resultCode) {
                        //验证码错误
                        _this.changeImg();
                        _this.yzmError();
                    } else {
                        _this.hideYzm();
                        _this.succFun = options.succFun;
                        _this.closeFun = options.closeFun || _this.closeFun;
                        options.succFun(response);
                    }
                },
                error: function(err) {
                    console.error(err);
                    options.errFun && options.errFun(err);
                }
            });
        }
    }
    if (typeof module !== 'undefined' && typeof exports === 'object' && define.cmd) {
        module.exports = yzmProcess;
    } else if (typeof define === 'function' && define.amd) {
        define(function() { return yzmProcess; });
    } else {
        window.yzmProcess = this.yzmProcess = yzmProcess;
    }
}())