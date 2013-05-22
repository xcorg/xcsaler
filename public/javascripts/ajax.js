//   ajax切换器
//   用途：ajax切换某个/某些元素的内容
//   使用方法：
//       1.给切换触发器（如<a />或<button />)加上ajax的css class
//       2.设置target参数,为触发器的目的元素的jQuery选择器。如#testDiv
//       3.设置href参数，为要切换至的url
//       4.如有需要，可以设置callback为要回调的函数名。
//         回调函数中：
//             this代表触发器的DOM元素。（用户点击的<a/>、<button/>等）
//             第一个参数代表target的DOM对象对应的jQuery对象。如$('#testDiv')
//   使用示例：
//   <a href="/topic/docDetail?id=5" class="ajax" target="#testDiv" callback="whenReady">view Article 5</a>
var HelperDate = {
    AddDays : function(date, days) { // 时间差
        var nn = Date.parse(new Date());
        nn = nn - days * 24 * 60 * 60 * 1000;
        nn = new Date(nn);

        var yy = nn.getFullYear();
        var mm = nn.getMonth() + 1;
        var dd = nn.getDate();
        if (mm <= 9)
            mm = "0" + mm;
        if (dd <= 9)
            dd = "0" + dd;
        var cdate = yy + "-" + mm + "-" + dd;
        // var nd = new Date(date);
        // nd = nd.valueOf();
        // nd = nd - days * 24 * 60 * 60 * 1000;
        // nd = new Date(nd);
        // //alert(nd.getFullYear() + "年" + (nd.getMonth() + 1) + "月" + nd.getDate() + "日");
        // var y = nd.getFullYear();
        // var m = nd.getMonth()+1;
        // var d = nd.getDate();
        // if(m <= 9) m = "0"+m;
        // if(d <= 9) d = "0"+d;
        // var cdate = y+"-"+m+"-"+d;
        return cdate + " ";
    },

    CurentTime : function(dateTime) {
        var now = new Date();
        var year = now.getFullYear(); // 年
        var month = now.getMonth() + 1; // 月
        var day = now.getDate(); // 日

        var hh = now.getHours(); // 时
        var mm = now.getMinutes(); // 分
        var sec = now.getSeconds();
        var clock = year + "-";
        if (month < 10) {
            clock += "0";
        }
        clock += month + "-";

        if (day < 10) {
            clock += "0";
        }
        clock += day + " ";

        var info = Math.floor(dateTime / 24);
        var vl = dateTime % 24;
        if (vl > hh)
            info = info + 1;

        var starttime = this.AddDays(clock, info);

        var starthh = (vl - hh) <= 0 ? (hh - vl) : (24 - vl + hh);
        if (hh < 10) {
            clock += "0";
        }
        if (starthh < 10) {
            starttime += "0";
        }
        clock += hh + ":";
        starttime += starthh + ":";
        if (mm < 10) {
            clock += '0';
            starttime += "0";
        }
        clock += mm + ":";
        starttime += mm + ":";
        if (sec < 10) {
            clock += '0';
            starttime += '0';
        }
        clock += sec;
        starttime += sec;

        return {
            end : clock,
            start : starttime
        };
    }
};

$('.ajax').live('click', function() {
    var a = this;
    $(".tipT_arrow").parent().hide();
    try {
        // 取得handler元素
        var url = $(this).attr('href');
        var target = $(this).attr('target');
        var callback = $(this).attr('callback');
        if ($(a).data('lock') != 'locked') {
            $(a).data('lock', 'locked');
            load(target, url, function() {
                $(a).data('lock', '');
                if (/.+/.test(callback) && callback != undefined) {
                    var funcs = callback.split(',');
                    for ( var i = 0; i < funcs.length; i++) {
                        eval(funcs[i]).call(a, $(target));
                    }
                }
            });
        }
    } catch (e) {
        alert('ajax error:' + e);
        throw e;
    } finally {
        $(a).removeData('lock');
        return false;
    }
});

$('.ajaxd').live('click', function() {
    var a = this;
    $(".tipT_arrow").parent().hide();
    try {
        // 取得handler元素
        var url = $(this).attr('url');
        var target = $(this).attr('totarget');
        var callback = $(this).attr('callback');
        if ($(a).data('lock') != 'locked') {
            $(a).data('lock', 'locked');
            load(target, url, function() {
                $(a).data('lock', '');
                if (/.+/.test(callback) && callback != undefined) {
                    var funcs = callback.split(',');
                    for ( var i = 0; i < funcs.length; i++) {
                        eval(funcs[i]).call(a, $(target));
                    }
                }
            });
        }
    } catch (e) {
        alert('ajax error:' + e);
        throw e;
    } finally {
        $(a).removeData('lock');
        //return false;
    }
});

function loadbox(target, type, data, callback, async) {
    var url = parseURL(type, data);
    load(target, url, callback, async);
}

function parseURL(type, data) {
    var url = eval('Routes.' + type).url(data);
    return url;
}

function load(target, url, callback, async, isPost) {
    if (url == "" || url == null) {
        return; // 解决ie浏览器url为空也进来
    }
    try {
        $(target).html('<img src="/public/images/ajax-loader.gif"/>');
    } catch (e) {
        alert('change ajax-loader.gif error.Target:' + target + ',$Target:' + $(target) + ',HTML:' + $(target).html() + ',e:' + e);
        throw e;
    }
    if (typeof async == 'undefined') {
        async = true;
    }
    $.ajax({
        url : url,
        async : async,
        type : isPost ? "post" : "get",
        success : function(responseText) {
            $(target).html(responseText);
            if (callback) {
                callback();
            }
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            console.log("_--------------------------------_");
            throw new Error("ajax callback error");
            console.log("_--------------------------------_");
        }
    });
}