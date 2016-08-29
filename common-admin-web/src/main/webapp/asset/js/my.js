(function ($) {


    $.fn.ajaxTable = function(opts){
        var $wrapper = $('#div-table-container'); //获取Table的外部容器
        var $table = $('#table-user'); //获取Table

        console.log($.fn.dataTable.defaults);


        var settings = $.extend(true,$.fn.dataTable.defaults,CONSTANT.DATA_TABLES.DEFAULT_OPTION,{
            ajax:function(data, callback, settings){ //ajax配置为function,手动调用异步查询
                //手动控制遮罩
                $wrapper.spinModal();
                $.ajax({
                    type: "GET",
                    url: opts.url,
                    data:{fuzzy:true,startIndex:1,pageSize:10},
                    dataType: "json",
                    success:function(result){
                        setTimeout(function(){
                            //封装返回数据，这里仅演示了修改属性名
                            var returnData = {};
                            returnData.draw = data.draw;//这里直接自行返回了draw计数器,应该由后台返回
                            returnData.recordsTotal = result.total;
                            returnData.recordsFiltered = result.total;//后台不实现过滤功能，每次查询均视作全部结果
                            returnData.data = result.pageData;
                            //关闭遮罩
                            $wrapper.spinModal(false);
                            //调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
                            //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
                            callback(returnData);

                        },300);
                    },error: function(XMLHttpRequest, textStatus, errorThrown) {
                        $.dialog.alert("查询失败");
                        $wrapper.spinModal(false);
                    }
                })
            },
            columns: opts.columns,
            serverSide: true
        });

        var _table = $table.dataTable(settings).api();

        //行点击事件
        $("tbody",$table).on("click","tr",function(event) {
            $(this).addClass("active").siblings().removeClass("active");
        });

        return _table;
    };





})(jQuery);