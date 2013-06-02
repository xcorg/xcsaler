$(document).ready(function() {
    $(".nav-list li").click(function() {
        $(this).siblings().removeClass("active");
        $(this).addClass("active");
    });
});

(function($) {
    $.extend({
        format : function(str, step, splitor) {
            str = str.toString();
            var len = str.length;

            if (len > step) {
                var l1 = len % step, l2 = parseInt(len / step), arr = [], first = str.substr(0, l1);
                if (first != '') {
                    arr.push(first);
                }
                ;
                for ( var i = 0; i < l2; i++) {
                    arr.push(str.substr(l1 + i * step, step));
                }
                ;
                str = arr.join(splitor);
            }
            ;
            return str;
        },
        numFormat : function(str, step, splitor) {
            str = str.toString();
            var len = str.length;

            if (len > step) {
                var l1 = len % step, l2 = parseInt(len / step), arr = [], first = str.substr(0, l1);
                if (first != '') {
                    arr.push(first);
                }
                ;
                for ( var i = 0; i < l2; i++) {
                    arr.push(str.substr(l1 + i * step, step));
                }
                ;
                str = arr.join(splitor);
            }
            ;
            return str;
        },
        amountFormat : function(amount, step) {
            return Number(amount).toFixed(step)
        }
    });
})(jQuery);

function accMul(arg1, arg2) {
    var m = 0, s1 = arg1.toString(), s2 = arg2.toString();
    try {
        m += s1.split(".")[1].length
    } catch (e) {
    }
    try {
        m += s2.split(".")[1].length
    } catch (e) {
    }
    return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m)
}
