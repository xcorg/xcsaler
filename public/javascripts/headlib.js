function addfavorite() {
    var e = "http://localhost:8000/";
    var c = "天狗网上商城，领先的综合网上购物商城，正品行货，全国联保，货到付款，让您尽享购物乐趣！";
    if (document.all) {
        window.external.AddFavorite(e, c)
    } else {
        if (window.sidebar) {
            window.sidebar.addPanel(c, e, "")
        } else {
            alert("对不起，您的浏览器不支持此操作!\n请您使用菜单栏或Ctrl+D收藏本站。")
        }
    }
}
