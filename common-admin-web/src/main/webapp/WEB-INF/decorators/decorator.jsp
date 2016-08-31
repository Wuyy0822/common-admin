<%--
  Created by IntelliJ IDEA.
  User: panlingxiao
  Date: 2016/8/30
  Time: 2:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/common/common-tag.jsp"%>

<html>
<head>
  <!--加载通用的样式文件和CSS文件-->
  <jsp:include page="/WEB-INF/common/header.jsp"/>
    <title>
        <decorator:title/>
    </title>
</head>
<body>
    <!--加载通用的JS文件-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/layer/2.1/layer.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/laypage/1.2/laypage.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/h-ui/js/H-ui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/static/h-ui.admin/js/H-ui.admin.js"></script>
    <script src="${pageContext.request.contextPath}/resources/lib/spin-2.1.0/jquery.spin.merge.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/constant.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/datatable-plugin.js"></script>
    <decorator:body/>

</body>
</html>
