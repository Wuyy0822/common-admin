<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/common-tag.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
  <title>系统登入</title>
  <link href="${pageContext.request.contextPath}/resources/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header"></div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form:form class="form form-horizontal" modelAttribute="user">
      <div class="row cl">
        <form:label class="form-label col-xs-3" path="username">
          <i class="Hui-iconfont">&#xe60d;</i>
        </form:label>
        <div class="formControls col-xs-8">
          <form:input  path="username" placeholder="账户" class="input-text size-L"/>
        </div>
      </div>
      <div class="row cl">
        <form:label path="password" class="form-label col-xs-3">
          <i class="Hui-iconfont">&#xe60e;</i>
        </form:label>
        <div class="formControls col-xs-8">
          <form:password path="password" placeholder="密码" class="input-text size-L"/>
        </div>
      </div>

      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input class="input-text size-L" type="text" placeholder="验证码" onblur="if(this.value==''){this.value='验证码:'}" onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:" style="width:150px;">
            <%--<img src="images/VerifyCode.aspx.png">--%> <a id="kanbuq" href="javascript:;">看不清，换一张</a> </div>
      </div>

      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <label for="online">
            <input type="checkbox" name="online" id="online" value="">
            使我保持登录状态</label>
        </div>
      </div>

      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input name="" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
        </div>
      </div>
    </form:form>
  </div>
</div>
<div class="footer">Copyright 你的公司名称 by H-ui.admin.v2.3</div>
<script>
  //var _hmt = _hmt || [];
  //(function() {
  //  var hm = document.createElement("script");
  //  hm.src = "//hm.baidu.com/hm.js?080836300300be57b7f34f4b3e97d911";
  //  var s = document.getElementsByTagName("script")[0];
  //  s.parentNode.insertBefore(hm, s);
  //})();
  //var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
  //document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F080836300300be57b7f34f4b3e97d911' type='text/javascript'%3E%3C/script%3E"));
</script>
</body>
</html>