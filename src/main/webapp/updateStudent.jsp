<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div algn="center">
    <h3>请输入学生编号:</h3><br/>
    <form action="student/updateStudent.do">
        编号:<input type="text" name="id" /><br/>
        姓名:<input type="text" name="name"/><br/>
        年龄:<input type="text" name="age" /><br/>
        &nbsp;&nbsp;&nbsp;<input type="submit" value="提交" />
    </form>
</div>
</body>
</html>
