function isDigit(c) {
    var d = /^([0-9]+)$/;
    if (d.test(c)) {
        return true
    } else {
        return false
    }
}
function checkEmailOfNormal(d, f) {
    var e = /^[\w-]+[-.\w]*@[-\w]+\.[-.\w]*[\w-]+$/;
    if (f.length == 0) {
        $("#" + d).addClass("iptTip txtFalse").html('<em class="tipFalse"></em>邮箱格式不正确！');
        return false
    } else {
        if (f.length > 50 || !e.test(f)) {
            if (f.match(/(\s+)/) && f.match(/@/) && f.match(/\./)) {
                $("#" + d).addClass("iptTip txtFalse").html('<em class="tipFalse"></em>邮件地址不能包含空格！');
                return false
            } else {
                $("#" + d).addClass("iptTip txtFalse").html('<em class="tipFalse"></em>邮箱格式不正确！');
                return false
            }
        } else {
            $("#" + d).removeClass("iptTip txtFalse").addClass("iptTip").html('<em class="tipOk"></em>')
        }
    }
    return true
}
function checkEmailOfNormalOnBlur(d, f) {
    var e = /^[\w-]+[-.\w]*@[-\w]+\.[-.\w]*[\w-]+$/;
    if (f.length == 0) {
        $("#" + d).removeClass("iptTip txtFalse").addClass("iptTip").html("");
        return false
    } else {
        if (f.length > 50 || !e.test(f)) {
            if (f.match(/(\s+)/) && f.match(/@/) && f.match(/\./)) {
                $("#" + d).addClass("iptTip txtFalse").html('<em class="tipFalse"></em>邮件地址不能包含空格！');
                return false
            } else {
                $("#" + d).addClass("iptTip txtFalse").html('<em class="tipFalse"></em>邮箱格式不正确！');
                return false
            }
        } else {
            $("#" + d).removeClass("iptTip txtFalse").addClass("iptTip").html('<em class="tipOk"></em>')
        }
    }
    return true
}
function ajaxCheckEmail(g, f) {
    var h = true;
    var e = f.replace(/(^\s*)/, "").replace(/(\s*$)/, "");
    $.ajax({
        url : "AjaxRegisterView?email=" + e,
        async : false,
        dataType : "html",
        success : function(a) {
            a = a.replace(/(^\s*)/, "");
            if (a.indexOf("已被注册") != -1) {
                h = false;
                $("#" + g).addClass("iptTip txtFalse").html($.trim(a))
            } else {
                h = true;
                $("#" + g).removeClass("iptTip txtFalse").addClass("iptTip").html($.trim(a))
            }
        }
    });
    return h
}
function checkPwd(d, e) {
    var f = checkPassword(e);
    if (!f.success) {
        $("#" + d).addClass("iptTip txtFalse").html('<em class="tipFalse"></em>' + f.msg);
        return false
    } else {
        $("#" + d).removeClass("iptTip txtFalse").addClass("iptTip").html('<em class="tipOk"></em>')
    }
    return true
}
function checkConfirmPwd(g, e, h) {
    var f = isEmptyPassword(h);
    if (f) {
        $("#" + g).addClass("iptTip txtFalse").html('<em class="tipFalse"></em>请再次输入密码！');
        return false
    } else {
        if (h != e) {
            $("#" + g).addClass("iptTip txtFalse").html('<em class="tipFalse"></em>您两次输入的密码不一致，请重新输入！');
            return false
        } else {
            $("#" + g).removeClass("iptTip txtFalse").addClass("iptTip").html('<em class="tipOk"></em>')
        }
    }
    return true
}
function checkEgoValidate(c, d) {
    if (d.length == 0) {
        $("#" + c).addClass("iptTip txtFalse").html('<em class="tipFalse"></em>请输入验证码！');
        return false
    } else {
        if ($.trim(d).length != 4) {
            $("#" + c).addClass("iptTip txtFalse").html('<em class="tipFalse"></em>输入的验证码错误，请重新输入！');
            return false
        } else {
            $("#" + c).removeClass("iptTip txtFalse").addClass("iptTip").html("")
        }
    }
    return true
}
function checkRegisterAgreement(c, d) {
    if (!document.getElementById(d).checked) {
        $("#" + c).addClass("iptTip txtFalse").html('<em class="tipFalse"></em>请确认此协议！');
        return false
    } else {
        $("#" + c).removeClass("iptTip txtFalse").addClass("iptTip").html("")
    }
    return true
}
function checkPwdSafeLevel(d, e) {
    $("#" + d + " li").removeClass("on1").removeClass("on2").removeClass("on3");
    var f = checkPasswordStrength(e);
    switch (f) {
        case "A":
            $("#" + d + " li:eq(0)").addClass("on1");
            break;
        case "B":
            $("#" + d + " li:eq(0)").removeClass("on1");
            $("#" + d + " li:eq(1)").addClass("on2");
            break;
        case "C":
            $("#" + d + " li:eq(0)").removeClass("on1");
            $("#" + d + " li:eq(1)").removeClass("on2");
            $("#" + d + " li:eq(2)").addClass("on3");
            break;
        default:
            break
    }
}
function checkInputEvnt() {
    $("#accountReg input").add("#accountReg select").add("#telCheck input").add(".stepCont input").add("#stepContId input").focus(function() {
        switch ($(this).attr("id")) {
        case "egoAccountOfEmail":
            $("#p_egoAccountOfEmail_info").removeClass("iptTip txtFalse").addClass("iptTip").html('<em class="tipTip"></em>此邮箱将是您登录天狗的账号，并将用来接收验证邮件！');
            break;
        case "emailLogonPassword":
            $(this).keyup(function() {
                checkPwdSafeLevel("emailSafeRank", this.value)
            });
            $("#p_egoAcctEmailPwd_info").removeClass("iptTip txtFalse").addClass("iptTip").html("<em class='tipTip'></em>密码为6-20个字符，请使用字母加数字或符号的组合密码，注意区分大小写。<a href='javascript:void(0);' id='emailPswSuggestion' >密码设置技巧</a>");
            $("#emailPswSuggestion").mouseover(function() {
                $("#emailPswSuggestion").data("canntBlur", true)
            }).mouseout(function() {
                $("#emailPswSuggestion").data("canntBlur", false)
            }).click(function() {
                openWin({
                    id: "tipBox"
                })
            });
            break;
        case "emailLogonPasswordVerify":
            $("#p_egoAcctEmailConfirmPwd_info").removeClass("iptTip txtFalse").addClass("iptTip").html('<em class="tipTip"></em>请再次输入密码！');
            break;
        case "emailValCode":
            $("#p_emailValCode_info").removeClass("iptTip txtFalse").addClass("iptTip").html('<em class="tipTip"></em>请输入验证码！');
            break;
        case "egoAccountOfCellPhone":
            $("#p_egoAcctOfMobile_info").removeClass("iptTip txtFalse").addClass("iptTip").html('<em class="tipTip"></em>请输入您的正确手机号码，此号码可用于找回密码！');
            break;
        case "mobileLogonPassword":
            $(this).keyup(function() {
                checkPwdSafeLevel("mobileSafeRank", this.value)
            });
            $("#p_egoAcctMobilePwd_info").removeClass("iptTip txtFalse").addClass("iptTip").html("<em class='tipTip'></em>密码为6-20个字符，请使用字母加数字或符号的组合密码，注意区分大小写。<a href='javascript:void(0);' id='mobilePswSuggestion'>密码设置技巧</a>");
            $("#mobilePswSuggestion").mouseover(function() {
                $("#mobilePswSuggestion").data("canntBlur", true)
            }).mouseout(function() {
                $("#mobilePswSuggestion").data("canntBlur", false)
            }).click(function() {
                openWin({
                    id: "tipBox"
                })
            });
            break;
        case "mobileLogonPasswordVerify":
            $("#p_egoAcctMobileConfirmPwd_info").removeClass("iptTip txtFalse").addClass("iptTip").html('<em class="tipTip"></em>请再次输入密码！');
            break;
        case "mobileValCode":
            $("#otherMobileRegServerErrorInfo").html("");
            $("#p_mobileValCode_info").removeClass("iptTip txtFalse").addClass("iptTip").html('<em class="tipTip"></em>请输入验证码！');
            break;
        case "cellPhoneOfValidateCode":
            $("#p_cellPhoneOfValidateCode_info").removeClass("iptTip txtFalse").addClass("iptTip").html('<em class="tipTip"></em>请输入6位数字或字母的手机验证码，不区分大小写！');
            break;
        case "memberCardNoId":
            $("#p_memberCardNo_info").removeClass("iptTip txtFalse").addClass("iptTip").html('<em class="tipTip"></em>请输入实体会员卡卡面上12位数字卡号！');
            break;
        case "memberCardPwdId":
            $("#p_memberCardPwd_info").removeClass("iptTip txtFalse").addClass("iptTip").html('<em class="tipTip"></em>请输入6位数字会员卡密码！');
            break;
        case "cellPhoneOfValidateCodeId":
            $("#p_cellPhoneOfValidateCode_info").removeClass("iptTip txtFalse").addClass("iptTip").html('<em class="tipTip"></em>请输入6位数字或字母的手机验证码，不区分大小写！');
            break;
        case "entityCardLogonPassword":
            $(this).keyup(function() {
                checkPwdSafeLevel("entityCardSafeRank", this.value)
            });
            $("#p_entityCardLogonPassword_info").removeClass("iptTip txtFalse").addClass("iptTip").html("<em class='tipTip'></em>密码为6-20个字符，请使用字母加数字或符号的组合密码，注意区分大小写。<a href='javascript:void(0);' id='entityCardPswSuggestion'>密码设置技巧</a>");
            $("#entityCardPswSuggestion").mouseover(function() {
                $("#entityCardPswSuggestion").data("canntBlur", true)
            }).mouseout(function() {
                $("#entityCardPswSuggestion").data("canntBlur", false)
            }).click(function() {
                openWin({
                    id: "tipBox"
                })
            });
            break;
        case "entityCardLogonPasswordVerify":
            $("#p_entityCardLogonPasswordVerify_info").removeClass("iptTip txtFalse").addClass("iptTip").html('<em class="tipTip"></em>请再次输入密码！');
            break;
        default:
            break
        }
    }).blur(function() {
        if ($(this).attr("id") == "emailLogonPassword" && $("#emailPswSuggestion").data("canntBlur")) {
            return
        }
        if ($(this).attr("id") == "mobileLogonPassword" && $("#mobilePswSuggestion").data("canntBlur")) {
            return
        }
        if ($(this).attr("id") == "entityCardLogonPassword" && $("#entityCardPswSuggestion").data("canntBlur")) {
            return
        }
        switch ($(this).attr("id")) {
        case "egoAccountOfEmail":
            var d = checkEmailOfNormalOnBlur("p_egoAccountOfEmail_info", this.value);
            if (d) {
                ajaxCheckEmail("p_egoAccountOfEmail_info", this.value)
            }
            break;
        case "emailLogonPassword":
            checkPwd("p_egoAcctEmailPwd_info", this.value);
            break;
        case "emailLogonPasswordVerify":
            checkConfirmPwd("p_egoAcctEmailConfirmPwd_info", $("#emailLogonPassword").val(), this.value);
            break;
        case "emailValCode":
            checkEgoValidate("p_emailValCode_info", this.value);
            break;
        case "mobileLogonPassword":
            checkPwd("p_egoAcctMobilePwd_info", this.value);
            break;
        case "mobileLogonPasswordVerify":
            checkConfirmPwd("p_egoAcctMobileConfirmPwd_info", $("#mobileLogonPassword").val(), this.value);
            break;
        case "mobileValCode":
            checkEgoValidate("p_mobileValCode_info", this.value);
            break;
        case "entityCardLogonPassword":
            checkPwd("p_entityCardLogonPassword_info", this.value);
            break;
        case "entityCardLogonPasswordVerify":
            checkConfirmPwd("p_entityCardLogonPasswordVerify_info", $("#entityCardLogonPassword").val(), this.value);
            break;
        default:
            break
        }
        $("#emailct").find("li").each(function() {
            var a = $(this).parent().attr("style");
            if ($(this).attr("class") != "hover" && a.indexOf("display: block") != -1) {
                $("#p_egoAccountOfEmail_info").removeClass("iptTip txtFalse").addClass("iptTip").html('<em class="tipTip"></em>此邮箱将是您登录苏宁易购的账号，并将用来接收验证邮件！')
            }
        })
    }).keypress(function(b) {
        if (b.keyCode == 13) {
            switch ($(this).attr("id")) {
            case "egoAccountOfEmail":
                break;
            case "emailLogonPassword":
                emailRegisterSubmit();
                break;
            case "emailLogonPasswordVerify":
                emailRegisterSubmit();
                break;
            case "emailValCode":
                emailRegisterSubmit();
                break;
            case "memberCardNoId":
                entityCardCheckSubmit();
                break;
            default:
                break
            }
            return false
        }
    })
}
function emailRegisterSubmit() {
    showEmailRegProgress();
    var b = setInterval(function() {
        clearInterval(b);
        doEmailRegisterSubmit()
    },
    10)
}
function doEmailRegisterSubmit() {
    var f = $("#egoAccountOfEmail").val();
    var g = $("#emailLogonPassword").val();
    var h = $("#emailLogonPasswordVerify").val();
    var e = $("#emailValCode").val();
    if (!ajaxCheckEmail("p_egoAccountOfEmail_info", f) || !checkEmailOfNormal("p_egoAccountOfEmail_info", f) || !checkPwd("p_egoAcctEmailPwd_info", g) || !checkConfirmPwd("p_egoAcctEmailConfirmPwd_info", g, h) || !checkEgoValidate("p_emailValCode_info", e) || !checkRegisterAgreement("epp_email_checked_error", "epp_email_checked")) {
        hideEmailRegProgress();
        return
    }
    $("#logonId").val(f.toLowerCase());
    $("#emailRegisterForm").submit()
}
$(function() {
    checkInputEvnt()
});
function showEmailRegProgress() {
    $("#emailRegLoadingArea").show();
    $("#emailRegButtonArea").hide();
    return false
}
function hideEmailRegProgress() {
    $("#emailRegLoadingArea").hide();
    $("#emailRegButtonArea").show();
    return false
}
function showMobileRegProgress() {
    $("#mobileRegLoadingArea").show();
    $("#mobileRegButtonArea").hide();
    return false
}
function hideMobileRegProgress() {
    $("#mobileRegLoadingArea").hide();
    $("#mobileRegButtonArea").show();
    return false
}
function showMobileRegValidateProgress() {
    $("#mobileRegValidateLoadingArea").show();
    $("#mobileRegValidateButtonArea").hide();
    return false
}
function hideMobileRegValidateProgress() {
    $("#mobileRegValidateLoadingArea").hide();
    $("#mobileRegValidateButtonArea").show();
    return false
}
function showMbrCardRegProgress() {
    $("#mbrCardRegLoadingArea").show();
    $("#mbrCardRegButtonArea").hide();
    return false
}
function hideMbrCardRegProgress() {
    $("#mbrCardRegLoadingArea").hide();
    $("#mbrCardRegButtonArea").show();
    return false
}
function showMbrCardMobileValidateProgress() {
    $("#mbrCardValidateLoadingArea").show();
    $("#mbrCardValidateButtonArea").hide();
    return false
}
function hideMbrCardMobileValidateProgress() {
    $("#mbrCardValidateLoadingArea").hide();
    $("#mbrCardValidateButtonArea").show();
    return false
}
$(function() {
    $("#resetPhoneLink").click(closeAndResetPhone)
});
function closeAndResetPhone() {
    closeWin({
        id: "telCheck"
    });
    $("#cellPhoneOfValidateCode").val("");
    resetPhone("#tabBox_2", "#egoAccountOfCellPhone");
    fun_getVcode();
    return false
};