<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript" >
        $(function(){
            $("#btn").click(function(){
                $.ajax({
                    url:"student/queryStudents.do",
                    dataType:"json",
                    type:"get",
                    success:function(resp){
                        $("#info").html("");
                        $.each(resp,function(i,n){
                            //alert(n.id+" "+n.name+" "+n.age)

                            $("#info").append("<tr>")
                            .append("<td>"+n.id+"</td>")
                            .append("<td>"+n.name+"</td>")
                            .append("<td>"+n.age+"</td>")
                            .append("</tr>")
                        })
                    }
                })
            })
        })
    </script>
</head>
<body>
<table align="center">
    <thead>
        <tr>
            <td>编号:</td>
            <td>姓名:</td>
            <td>年龄:</td>
        </tr>
    </thead>
    <tbody id="info">

    </tbody>
</table>
<center><input type="button" value="发起Ajax请求" id="btn"/></center>
</body>
</html>
