# SuitPrintDesign
简单的套打打印设计器，主要应用在Web系统中使用

## 套打涉及到几个关键的部分
*  1.打印设计，根据底板设计答应模板；
*  2.取得打印模板，填充答应数据；
*  3.打印；

## 描述
整个过程中打印设计最为关键，现在web段做的比较好的设计工具，
有LODOP和jatoolsPrinter这两个工具，其它工具太弱，基本没有什么功能。
目前这两个工具都是收费的。费用不低。

我使用java开发了一个设计器，通过设计器吧步骤1 完成，把设计模板保存到后台。

前台想要打印，发送Ajax请求到后台，后台调用模板，补充数据，然后结果给前台。
前台直接打印。

没有使用web的端设计器直接打印。
问题
1. 设计程序和打印程序，相互独立。
2. 最终效果不是很完美，最终打印的网页毕竟是通过模板的位置和像素计算结果，总是差一点点
3. 前台可以采用iframe方式，这样看不到弹出的网页可以直接答应。

```java

发送请求的打印代码 使用jquery 的ajax
function printHtml() {
         var url = getRootPath()+"/census/test/manage.action";
        var formData = $("#censusAuthPrintForm").serializeArray();        
        jQuery.ajax({
            url : url,
            type : 'POST',
            cache: false,
            data : formData,
            success : function(data) {
                alert(data);
                $(document.body).append(iframe);
                var iframe = $("<iframe style='position:absolute;width:0px;height:0px;left:-500px;top:-500px;'></iframe>");
                var doc = null;
                $(body).append(iframe);
                doc = iframe[0].contentWindow.document;
                doc.write(data);
                doc.close();
                iframe[0].contentWindow.focus();
                iframe[0].contentWindow.print();
                iframe.remove();            
            },
            error : function() {
                alert('error')
            }
        });
     }

