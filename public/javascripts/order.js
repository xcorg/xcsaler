/*(function($) {
    $.fn.dataTableExt.oApi.fnGetColumnData = function(oSettings, iColumn, bUnique, bFiltered, bIgnoreEmpty) {
        // check that we have a column id
        if (typeof iColumn == "undefined")
            return new Array();

        // by default we only want unique data
        if (typeof bUnique == "undefined")
            bUnique = true;

        // by default we do want to only look at filtered data
        if (typeof bFiltered == "undefined")
            bFiltered = true;

        // by default we do not want to include empty values
        if (typeof bIgnoreEmpty == "undefined")
            bIgnoreEmpty = true;

        // list of rows which we're going to loop through
        var aiRows;

        // use only filtered rows
        if (bFiltered == true)
            aiRows = oSettings.aiDisplay;
        // use all rows
        else
            aiRows = oSettings.aiDisplayMaster; // all row numbers

        // set up data array
        var asResultData = new Array();

        for ( var i = 0, c = aiRows.length; i < c; i++) {
            iRow = aiRows[i];
            var aData = this.fnGetData(iRow);
            var sValue = aData[iColumn];

            // ignore empty values?
            if (bIgnoreEmpty == true && sValue.length == 0)
                continue;

            // ignore unique values?
            else if (bUnique == true && jQuery.inArray(sValue, asResultData) > -1)
                continue;

            // else push the value onto the result data array
            else
                asResultData.push(sValue);
        }

        return asResultData;
    }
}(jQuery));

function fnCreateSelect(aData) {
    var r = '<select><option value=""></option>', i, iLen = aData.length;
    for (i = 0; i < iLen; i++) {
        r += '<option value="' + aData[i] + '">' + aData[i] + '</option>';
    }
    return r + '</select>';
}*/

$(document).ready(function() {
    /*var oTable = $('#myorder').dataTable({
        "sDom" : "<'row'<'span6'<'dt_actions'>l><'span6'f>r>t<'row'<'span6'i><'span6'p>>",
        "sPaginationType" : "bootstrap_alt",
        "bSort" : false,
        "bProcessing" : true,
        "bServerSide" : true, // sAjaxSource为arrays.txt不用设置此选项
        // /public/javascripts/arrays2.txt
        // http://www.datatables.net/release-datatables/examples/server_side/scripts/server_processing.php
        "sAjaxSource" : '/public/javascripts/arrays2.txt',
        "oLanguage" : {
            "sProcessing" : "<img src='/public/images/loader.gif'/>",
            "sLengthMenu" : "显示 _MENU_ 条",
            "sZeroRecords" : "没有数据",
            "sInfo" : "共 _TOTAL_条信息，显示第 _START_ 至 _END_ 条",
            "sInfoEmpty" : "共 0 条信息",
            "sInfoFiltered" : "(从 _MAX_ 条信息中过滤)",
            "sSearch" : "查询：",
            "oPaginate" : {
                "sFirst" : "首页",
                "sPrevious" : "上一页",
                "sNext" : "下一页",
                "sLast" : "尾页"
            }
        },
        "aoColumnDefs" : [ 
            {
                // `data` refers to the data for the cell (defined by `mData`, which
                // defaults to the column being worked with, in this case is the first
                // Using `row[0]` is equivalent.
                "mRender" : function(data, type, row) {
                    // return data +' '+ row[3];
                    return '<a style="cursor:hand"><img class="itempic" src="' + data + '"/></a>'
                },
                "aTargets" : [ 0 ]
            },
            // { "bVisible": false, "aTargets": [ 3 ] },
            // { "sClass": "center", "aTargets": [ 4 ] }
            {
                "mRender" : function(data, type, row) {
                    return '<a>' + data + '</a>'
                },
                "aTargets" : [ 1 ] // 第几列
            }, {
                "mRender" : function(data, type, row) {
                    return '<em class="amount" tabindex="0">￥' + data + '</em>'
                },
                "aTargets" : [ 2 ]
            }, {
                "mRender" : function(data, type, row) {
                    return '<a>' + data + '</a>'
                },
                "aTargets" : [ 4 ],
                "sClass": "center"
            }, {
                "mRender" : function(data, type, row) {
                    return '<a>' + data + '</a>'
                },
                "aTargets" : [ 5 ],
                "sClass": "center"
            }
        ],
        
        // 附加参数
        "fnServerParams": function( aoData ){  
            aoData.push( 
                {"name":"searchType","value":$('#searchType').val()},
                {"name":"submitDate","value":$('#submitDate').val()},  
                {"name":"orderState","value":$('#orderState').val()}
            )  
         }

    });

    $("thead th").each(function(i) {
        // this.innerHTML = fnCreateSelect(oTable.fnGetColumnData(i));
        $('select', this).change(function() {
            $('#searchType').val($(this).attr('searchType'));
            oTable.fnFilter($(this).val(), i);
            $('#searchType').val('sSearch');
            // oTable.fnAddData([ "a", "b", "c", "d", "e","f" ]);
            // oTable.fnDestroy();
            // generate_table();
        });
    });
    
    $("#myorder_filter input").keyup(function(){
        $('#searchType').val('stext');
        oTable.fnFilter($(this).val());
    });*/
    
    $("#submitDate").change(function(){
        var date = $(this).val();
        load("#myorderbody","/UserHomeViews/orderView?p=1&date=" + date);
    });
    
    $("#orderState").change(function(){
        var state = $(this).val();
        load("#myorderbody","/UserHomeViews/orderView?p=1&state=" + state);
    });
});

function searchOrder(){
    var orderKey = $("#orderKey").val();
    if(orderKey == ""){
        return;
    }
    
    load("#myorderbody","/UserHomeViews/orderView?p=1&orderKey=" + orderKey);
}