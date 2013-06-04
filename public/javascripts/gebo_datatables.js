/* [ ---- Gebo Admin Panel - datatables ---- ] */

// * calendar
var gebo_datatbles = {
    dt_a : function() {
        $('#dt_a').dataTable({
            "sDom" : "<'row'<'span6'<'dt_actions'>l><'span6'f>r>t<'row'<'span6'i><'span6'p>>",
            "sPaginationType" : "bootstrap_alt",
            "bSort": false,
            "bProcessing": true,
            "bServerSide": true,  // sAjaxSource为arrays.txt不用设置此选项
            ///public/javascripts/arrays2.txt
            //http://www.datatables.net/release-datatables/examples/server_side/scripts/server_processing.php
            "sAjaxSource": '/public/javascripts/arrays2.txt', 
            "oLanguage" : { 
                    "sProcessing": "<img src='/public/images/loader.gif'/>",
                    "sLengthMenu": "显示 _MENU_ 条",
                    "sZeroRecords": "没有数据",
                    "sInfo": "共 _TOTAL_条信息，显示第 _START_ 至 _END_ 条",
                    "sInfoEmpty": "共 0 条信息",
                    "sInfoFiltered": "(从 _MAX_ 条信息中过滤)",
                    "sSearch" : "查询：",
                    "oPaginate" : {
                          "sFirst": "首页",
                          "sPrevious" : "上一页",
                          "sNext" : "下一页",
                          "sLast": "尾页"
                    }
            },
            "aoColumnDefs": [
                    {
                        // `data` refers to the data for the cell (defined by `mData`, which
                        // defaults to the column being worked with, in this case is the first
                        // Using `row[0]` is equivalent.
                        "mRender": function ( data, type, row ) {
                            //return data +' '+ row[3];
                            return '<a style="cursor:hand"><img class="itempic" src="' + data + '"/></a>'
                        },
                        "aTargets": [ 0 ]   // 第几列
                    },
                    //{ "bVisible": false,  "aTargets": [ 3 ] },
                    //{ "sClass": "center", "aTargets": [ 4 ] }
                    {
                        "mRender": function ( data, type, row ) {
                            return '<a style="cursor:hand;font-size:12px">' + data + '</a>'
                        },
                        "aTargets": [ 1 ]   // 第几列
                    },
                    {
                        "mRender": function ( data, type, row ) {
                            return '<em class="amount" tabindex="0">￥' + data + '</em>'
                        },
                        "aTargets": [ 2 ]   // 第几列
                    }
            ]
            
        });
    },
    
    // horizontal scroll
    dt_b : function() {
        $('#dt_b').dataTable({
            "sDom" : "<'row'<'span6'l><'span6'f>r>t<'row'<'span6'i><'span6'p>>",
            "sScrollX" : "100%",
            "sScrollXInner" : '110%',
            "sPaginationType" : "bootstrap",
            "bScrollCollapse" : true
        });
    },
    
    // * large table
    dt_c : function() {
        var aaData = [];
        for ( var i = 1, len = 1000; i <= len; i++) {
            aaData.push([ i, i, i, i, i ]);
        }

        $('#dt_c').dataTable({
            "sDom" : "<'row'<'span6'><'span6'f>r>t<'row'<'span6'i><'span6'>S>",
            "sScrollY" : "200px",
            "aaData" : aaData,
            "bDeferRender" : true
        });

        $('#fill_table').click(function() {
            var aaData = [];
            for ( var i = 1, len = 50000; i <= len; i++) {
                aaData.push([ i, i, i, i, i ]);
            }

            $('#dt_c').dataTable({
                "sDom" : "<'row'<'span6'><'span6'f>r>t<'row'<'span6'i><'span6'>S>",
                "sScrollY" : "200px",
                "aaData" : aaData,
                "bDestroy" : true,
                "bDeferRender" : true
            });
            $(this).remove();
            $('#entries').html('50 000');
            $('.dataTables_scrollHeadInner').css({
                'height' : '34px',
                'top' : '0'
            });
        });
    },
    
    // * hideable columns
    dt_d : function() {
        function fnShowHide(iCol) {
            /* Get the DataTables object again - this is not a recreation, just a get of the object */
            var oTable = $('#dt_d').dataTable();

            var bVis = oTable.fnSettings().aoColumns[iCol].bVisible;
            oTable.fnSetColumnVis(iCol, bVis ? false : true);
        }

        var oTable = $('#dt_d').dataTable({
            "sDom" : "<'row'<'span6'l><'span6'f>r>t<'row'<'span6'i><'span6'p>>",
            "sPaginationType" : "bootstrap"
        });

        $('#dt_d_nav').on('click', 'li input', function() {
            fnShowHide($(this).val());
        });
    },
    
    // * server side proccessing with hiden row
    dt_e : function() {
        if ($('#dt_e').length) {

            var oTable;

            /* Formating function for row details */
            function fnFormatDetails(nTr) {
                var aData = oTable.fnGetData(nTr);
                var sOut = '<table cellpadding="5" cellspacing="0" border="0" class="table table-bordered" >';
                sOut += '<tr><td>Rendering engine:</td><td>' + aData[2] + ' ' + aData[5] + '</td></tr>';
                sOut += '<tr><td>Link to source:</td><td>Could provide a link here</td></tr>';
                sOut += '<tr><td>Extra info:</td><td>And any further details here (images etc)</td></tr>';
                sOut += '</table>';

                return sOut;
            }

            oTable = $('#dt_e').dataTable({
                "bProcessing" : true,
                "bServerSide" : true,
                "sPaginationType" : "bootstrap",
                "sDom" : "<'row'<'span6'l><'span6'f>r>t<'row'<'span6'i><'span6'p>>",
                "sAjaxSource" : "lib/datatables/server_side.php",
                "aoColumns" : [ {
                    "sClass" : "center",
                    "bSortable" : false
                }, null, null, null, {
                    "sClass" : "center"
                }, {
                    "sClass" : "center"
                } ],
                "aaSorting" : [ [ 1, 'asc' ] ]
            });

            $('#dt_e').on('click', 'tbody td img', function() {
                var nTr = $(this).parents('tr')[0];
                if (oTable.fnIsOpen(nTr)) {
                    /* This row is already open - close it */
                    this.src = "img/details_open.png";
                    oTable.fnClose(nTr);
                } else {
                    /* Open this row */
                    this.src = "img/details_close.png";
                    oTable.fnOpen(nTr, fnFormatDetails(nTr), 'details');
                }
            });

        }
    }
};

$(document).ready(function() {
    // * basic
    gebo_datatbles.dt_a();
    // horizontal scroll
    //gebo_datatbles.dt_b();
    // * large table
    //gebo_datatbles.dt_c();
    // * hideable columns
    //gebo_datatbles.dt_d();
    // * server side proccessing with hiden row
    //gebo_datatbles.dt_e();
    
    function updateDataTable() {   
        datatables.fnClearTable();  
        datatables.fnAddData([ ".1","2",".3","4","5"] );   
        datatables.fnAddData([ ".a","b",".c","d","e"] );   
    }
    $("#link").click(function(){  
           updateDataTable();  
    });
});