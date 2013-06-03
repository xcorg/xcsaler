$(document).ready(function() {
    $('.select_rows').click(function() {
        var tableid = $(this).data('tableid');
        $('#' + tableid).find('input[name=row_sel]').attr('checked', this.checked);
        
        $('.select_rows').attr('checked', this.checked);
    });
    
    $('input[type=checkbox]').click(function(){
        var sum = 0.00;
        $('#dt_gal tbody').find('.row_sel').each(function(){
            if($(this).attr('checked')){
                sum += Number($(this).parents('tr').find('.classAmount').html());
            }
        });
        
        $('#J_Total').html($.amountFormat(sum,2));
    });

    $('input.text-amount').keyup(function() {
        var datamax = $(this).attr('data-max');
        var amount = $(this).val();
        if (isNaN(amount)) { // amount为数字isNaN返回false
            $(this).val('1');
        } else if (parseInt(amount) <= 0) {
            $(this).val('1');
        } else if (parseInt(amount) > parseInt(datamax)) {
            $(this).val(datamax);
            $(this).parent().find('em.error-msg').html('最多只可购买' + datamax + '件');
            $(this).parent().find('em.error-msg').slideDown();
            $(this).siblings('a.no-minus').removeClass('no-minus').addClass('minus');
        }

        // 更新小计
        classAmount($(this).parents('tr'));
        totalAmount();

        // TODO 更新数据库
    });

    $('.minus').die().live('click', function() {
        var thisinput = $(this).parent().find('input');
        var thisval = thisinput.val();
        var datamax = thisinput.attr('data-max');

        $(this).parent().find('em.error-msg').html('');
        $(this).parent().find('em.error-msg').hide();

        if (thisval == 1) {
            return;
        }

        var newval = parseInt(thisval) - 1;

        if (newval == 1) {
            // -号不可用
            $(this).removeClass('minus').addClass('no-minus');
        }
        thisinput.val(newval);

        // 更新小计
        classAmount($(this).parents('tr'));
        totalAmount();

        // TODO 更新数据库
    });

    $('.plus').die().live('click', function() {
        var thisinput = $(this).parent().find('input');
        var thisval = thisinput.val();
        var datamax = thisinput.attr('data-max');
        if (datamax == 0) {
            $(this).parent().find('em.error-msg').html('暂无库存');
            $(this).parent().find('em.error-msg').slideDown();
            return;
        }
        if (thisval == datamax) {
            $(this).parent().find('em.error-msg').html('最多只可购买' + datamax + '件');
            $(this).parent().find('em.error-msg').slideDown();
            return;
        }

        var newval = parseInt(thisval) + 1;
        thisinput.val(newval);

        // -号可使用
        $(this).siblings('a.no-minus').removeClass('no-minus').addClass('minus');

        // 更新小计
        classAmount($(this).parents('tr'));
        totalAmount();

        // TODO 更新数据库
    });

    /**
     * 计算小计
     */
    function classAmount(tr) {
        try {
            var amount = $(tr).find('.amount').html();
            var count = $(tr).find('.text-amount').val();
            $(tr).find('.classAmount').html($.amountFormat(accMul(amount, count), 2));
        } catch (e) {
            $(tr).find('.classAmount').html('');
        }
    }
    
    /**
     * 计算总价
     */
    function totalAmount(){
        var sum = 0.00;
        $('#dt_gal tbody').find('.row_sel').each(function(){
            if($(this).attr('checked')){
                sum += Number($(this).parents('tr').find('.classAmount').html());
            }
        });
        
        $('#J_Total').html($.amountFormat(sum,2));
    }
});