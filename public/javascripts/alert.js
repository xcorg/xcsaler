//<div style="display:none">
//	<div id="alertId">
//		<h4 class="sepH_a">内容</h4>
//		<p class="tac sepH_b">
//			<a href="javascript:void(0)" class="btn btn_c" >确定</a>
//			<a href="javascript:void(0)" class="btn btn_a" >取消</a>
//		</p>
//	</div>
//</div>
window.alert = function(txt) {
    if ($("#alertWindow").html() != '') {
        $("#alertWindow").remove();
    }
    var alertForm = document.createElement("div");
    alertForm.setAttribute("id", "alertWindow");
    alertForm.style.display = "none";

    var strHtml = "<div id='alertId' style='max-width:500px;max-height:150px;min-width:180px;min-height:50px'>";
    strHtml += "<h4 class='sepH_a' >" + txt + "</h4><br />";
    strHtml += "<p class='tac sepH_b'>";
    strHtml += " <a href='javascript:void(0)' class='btn btn_c alertok' >确定</a>";
    strHtml += "</p>";
    strHtml += "</div>";
    alertForm.innerHTML = strHtml;
    document.body.appendChild(alertForm);

    $.fancybox({
        'transitionIn' : 'elastic',
        'showCloseButton' : true,
        'showNavArrows' : false,
        'overlayOpacity' : '0',
        'content' : '#alertId',
        'type' : 'inline',
        'autoDimensions' : true,
        'hideOnOverlayClick' : false
    });

    $(".alertok").die().live("click", function() {
        $.fancybox.close();
    });
    // console.log($("#alertId").html());
}