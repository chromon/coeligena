<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2018/6/4
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!-- anonymous modal -->
<div class="modal fade" id="anonymousModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog custom-modal-size" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">确认使用匿名身份？</h4>
            </div>
            <div class="modal-body">
                <div class="Anonymous-confirm">
                    <p>使用匿名身份后</p>
                    <ul>
                        <li>提问、回答、赞同、关注会显示为匿名</li>
                        <li>除提问者本人，不能匿名编辑问题</li>
                        <li>不能邀请别人回答问题</li>
                        <li>不能使用视频功能</li>
                    </ul>
                </div>
            </div>
            <div class="modal-footer">
                <button data-dismiss="modal" type="button" class="btn btn-default">取消</button>
                <button id="anonymous_confirm" type="button" class="btn btn-primary">确认</button>
            </div>
        </div>
    </div>
</div>
<!-- end anonymous modal -->
