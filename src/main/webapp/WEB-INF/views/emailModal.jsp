<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2018/5/7
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!-- set email modal -->
<div class="modal fade" id="setEmailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog custom-modal-size" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel2">验证身份</h4>
            </div>
            <div class="modal-body">
                <form class="form">
                    <div class="custom-email-modal">
                        <div class="form-group">
                            <label class="control-label">为了保证帐号安全，请验证身份</label>
                        </div>
                        <div class="form-group">
                            <select class="form-control input-sm" id="select">
                                <option>使用邮箱 a***y@msn.com 验证</option>
                                <option>使用手机 138****1234 验证</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <input class="form-control input-sm" type="text" placeholder="输入6位数验证码">
                        </div>

                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default">发送验证码</button>
                <button type="button" class="btn btn-primary">发布</button>
            </div>
        </div>
    </div>
</div>
<!-- end set email modal -->
