<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2018/5/7
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!-- ask modal -->
<div class="modal fade" id="askModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">提问</h4>
            </div>

            <form class="form" action="${pageContext.request.contextPath}/ask-question" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <input name="questionContent" class="form-control input-sm" type="text" placeholder="写下你的问题">
                    </div>
                    <div class="form-group">
                        <label class="control-label">问题说明（可选）：</label>
                        <%--<div id="ask_note"></div>--%>
                        <textarea id="ask_note" name="questionDetail"></textarea>
                    </div>
                    <div class="form-group">
                        <label class="control-label">选择话题</label>
                        <select name="topics" class="form-control js-example-basic-multiple" multiple="multiple">

                        </select>
                        <span class="help-block custom-right">话题越精准，越容易让相关领域专业人士看到你的问题</span>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="checkbox custom-left">
                        <label>
                            <input name="anonymous" type="checkbox" value="1"> 匿名提问
                        </label>
                    </div>
                    <button type="submit" class="btn btn-primary">提交问题</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- end ask modal -->
