<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2018/5/7
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!-- report modal -->
<div class="modal fade" id="reportModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog custom-modal-size" role="document">
        <div id="reportMenu-index" class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title custom-title-center">举报</h4>
                <div class="custom-modal-subtitle">请选择举报理由</div>
            </div>
            <div class="modal-body">
                <div class="custom-reportMenu-inner">
                    <div class="custom-reportMenu-item" onclick="reportFunc('垃圾广告信息', 'index', 'textarea');">
                        <span class="custom-reportMenu-itemValue">垃圾广告信息</span>
                        <i class="fa fa-angle-right custom-right" aria-hidden="true"></i>
                    </div>
                    <div class="custom-reportMenu-item">
                        <span class="custom-reportMenu-itemValue">不友善行为</span>
                        <i class="fa fa-angle-right custom-right" aria-hidden="true"></i>
                    </div>
                    <div class="custom-reportMenu-item">
                        <span class="custom-reportMenu-itemValue">有害信息</span>
                        <i class="fa fa-angle-right custom-right" aria-hidden="true"></i>
                    </div>
                    <div class="custom-reportMenu-item">
                        <span class="custom-reportMenu-itemValue">涉嫌侵权</span>
                        <i class="fa fa-angle-right custom-right" aria-hidden="true"></i>
                    </div>
                    <div class="custom-reportMenu-item">
                        <span class="custom-reportMenu-itemValue">诱导投票</span>
                        <i class="fa fa-angle-right custom-right" aria-hidden="true"></i>
                    </div>
                    <div class="custom-reportMenu-item">
                        <span class="custom-reportMenu-itemValue">其他</span>
                        <i class="fa fa-angle-right custom-right" aria-hidden="true"></i>
                    </div>
                </div>
            </div>
            <div class="modal-footer custom-modal-footer">
                <button type="button" class="btn btn-primary custom-report-btn">举报</button>
            </div>
        </div>
        <div id="reportMenu-textarea" class="modal-content hide">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title custom-title-center">举报</h4>
                <div class="custom-modal-subtitle">举报说明</div>
            </div>
            <div class="modal-body">
                <div class="custom-reportMenu-inner" style="margin-bottom: 0">
                    <textarea class="form-control custom-textarea" rows="5" id="textArea" placeholder="举报详细说明（选填）"></textarea>
                </div>
            </div>
            <div class="modal-footer custom-modal-footer">
                <button type="button" class="btn btn-default custom-report-btn">返回</button>
                <button type="button" class="btn btn-primary custom-report-btn">举报</button>
            </div>
        </div>
    </div>
</div>
<!-- end report modal -->


