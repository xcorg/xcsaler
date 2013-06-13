function checkPassword(c) {
    var d = new Object();
    if (isEmptyPassword(c)) {
        d.success = false;
        d.msg = "请输入6-20位密码！";
        return d
    }
    if (isTooShort(c)) {
        d.success = false;
        d.msg = "请输入6-20位密码！";
        return d
    }
    if (isAllSameChars(c)) {
        d.success = false;
        d.msg = "不能为同一字符！";
        return d
    }
    if (hasAllIncreaseChars(c) || hasAllDecreaseChars(c)) {
        d.success = false;
        d.msg = "不能输入连续字符！";
        return d
    }
    if (isAllNum(c) || isAllLetter(c) || isAllSymbol(c)) {
        d.success = false;
        d.msg = "不能为纯粹的数字,字母或者符号！";
        return d
    }
    if (hasIllegalSymbol(c)) {
        d.success = false;
        d.msg = "密码只能由英文、数字及符号组成！";
        return d
    }
    d.success = true;
    d.msg = "OK.";
    return d
}
function isEmptyPassword(b) {
    return b == null || b.length == 0
}
function isTooShort(b) {
    return b.length < 6
}
function hasNum(c) {
    var d = /\d/;
    return d.test(c)
}
function isAllNum(c) {
    var d = /^\d+$/;
    return d.test(c)
}
function hasLetter(c) {
    var d = /[a-zA-Z]/;
    return d.test(c)
}
function isAllLetter(c) {
    var d = /^[a-zA-Z]+$/;
    return d.test(c)
}
function hasSymbol(c) {
    var d = /[^0-9a-zA-Z\s<>;'\\]/;
    return d.test(c)
}
function isAllSymbol(c) {
    var d = /^[^0-9a-zA-Z\s<>;'\\]+$/;
    return d.test(c)
}
function hasSpace(c) {
    var d = /\s/g;
    return d.test(c)
}
function hasIllegalSymbol(c) {
    var d = /[\s<>;'\\]/;
    return d.test(c)
}
function isAllSameChars(g) {
    if (g == null || g.length < 2) {
        return false
    }
    var h = g.charCodeAt(0);
    var e = 1;
    for (e = 1; e < g.length; e++) {
        var f = g.charCodeAt(e);
        if (f != h) {
            return false
        }
    }
    return true
}
function hasRepeat6Chars(c) {
    var d = /(.)\1\1\1\1\1/;
    return d.test(c)
}
function hasIncrease6Chars(g) {
    if (g == null || g.length < 6) {
        return false
    }
    var h = g.charCodeAt(0);
    var i = 1;
    var j = 1;
    for (j = 1; j < g.length; j++) {
        var f = g.charCodeAt(j);
        if (f == h + 1) {
            i++;
            if (i >= 6) {
                return true
            }
        } else {
            i = 1
        }
        h = f
    }
    return false
}
function hasDecrease6Chars(g) {
    if (g == null || g.length < 6) {
        return false
    }
    var h = g.charCodeAt(0);
    var i = 1;
    var j = 1;
    for (j = 1; j < g.length; j++) {
        var f = g.charCodeAt(j);
        if (f == h - 1) {
            i++;
            if (i >= 6) {
                return true
            }
        } else {
            i = 1
        }
        h = f
    }
    return false
}
function hasAllIncreaseChars(g) {
    if (g == null) {
        return false
    }
    var i = g.length;
    var h = g.charCodeAt(0);
    var j = 1;
    var k = 1;
    for (k = 1; k < g.length; k++) {
        var l = g.charCodeAt(k);
        if (l == h + 1) {
            j++;
            if (j >= i) {
                return true
            }
        } else {
            j = 1
        }
        h = l
    }
    return false
}
function hasAllDecreaseChars(g) {
    if (g == null) {
        return false
    }
    var i = g.length;
    var h = g.charCodeAt(0);
    var j = 1;
    var k = 1;
    for (k = 1; k < i; k++) {
        var l = g.charCodeAt(k);
        if (l == h - 1) {
            j++;
            if (j >= i) {
                return true
            }
        } else {
            j = 1
        }
        h = l
    }
    return false
}
function checkPasswordStrength(c) {
    var d = "A";
    if (isTooShort(c)) {
        d = "A"
    } else {
        if (hasNum(c) && hasLetter(c) && hasSymbol(c)) {
            d = "C"
        } else {
            if (hasNum(c) && hasLetter(c)) {
                d = "B"
            } else {
                if (hasNum(c) && hasSymbol(c)) {
                    d = "B"
                } else {
                    if (hasSymbol(c) && hasLetter(c)) {
                        d = "B"
                    } else {
                        if (isAllNum(c) || isAllLetter(c) || isAllSymbol(c)) {
                            d = "A"
                        }
                    }
                }
            }
        }
    }
    return d
};