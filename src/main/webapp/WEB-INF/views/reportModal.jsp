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
        <!-- index menu -->
        <div id="reportMenu-index" class="modal-content">
        </div><!-- end index menu -->

        <!-- text menu -->
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
                <button type="button" class="btn btn-default custom-report-btn return-btn">返回</button>
                <button type="button" class="btn btn-primary custom-report-btn">举报</button>
            </div>
        </div><!-- end text menu -->

        <!-- unfriendly menu -->
        <div id="reportMenu-unfriendly" class="modal-content hide">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title custom-title-center">举报</h4>
                <div class="custom-modal-subtitle">举报说明</div>
            </div>
            <div class="modal-body">
                <div class="custom-reportMenu-inner" style="margin-bottom: 0">
                    <div class="custom-reportMenu-item">
                        <span class="custom-reportMenu-itemValue">骚扰、辱骂、歧视等</span>
                        <i class="fa fa-check-circle custom-right custom-reportMenu-itemCheckIcon" aria-hidden="true"></i>
                    </div>
                    <div class="custom-reportMenu-item" onclick="reportFunc('其他不友善行为', 'unfriendly', 'textarea');">
                        <span class="custom-reportMenu-itemValue">其他不友善行为</span>
                        <i class="fa fa-angle-right custom-right" aria-hidden="true"></i>
                    </div>
                </div>
            </div>
            <div class="modal-footer custom-modal-footer">
                <button type="button" class="btn btn-default custom-report-btn return-btn">返回</button>
                <button type="button" class="btn btn-primary custom-report-btn">举报</button>
            </div>
        </div><!-- unfriendly menu -->

        <!-- harmful info menu -->
        <div id="reportMenu-harmful-info" class="modal-content hide">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title custom-title-center">举报</h4>
                <div class="custom-modal-subtitle">举报说明</div>
            </div>
            <div class="modal-body">
                <div class="custom-reportMenu-inner" style="margin-bottom: 0">
                    <div class="custom-reportMenu-item">
                        <span class="custom-reportMenu-itemValue">政治敏感</span>
                        <i class="fa fa-check-circle custom-right custom-reportMenu-itemCheckIcon" aria-hidden="true"></i>
                    </div>
                    <div class="custom-reportMenu-item">
                        <span class="custom-reportMenu-itemValue">色情低俗</span>
                        <i class="fa fa-check-circle custom-right custom-reportMenu-itemCheckIcon" aria-hidden="true"></i>
                    </div>
                    <div class="custom-reportMenu-item" onclick="reportFunc('不实信息', 'harmful-info', 'textarea');">
                        <span class="custom-reportMenu-itemValue">不实信息</span>
                        <i class="fa fa-angle-right custom-right" aria-hidden="true"></i>
                    </div>
                    <div class="custom-reportMenu-item">
                        <span class="custom-reportMenu-itemValue">有人意图自杀或自残</span>
                        <i class="fa fa-check-circle custom-right custom-reportMenu-itemCheckIcon" aria-hidden="true"></i>
                    </div>
                    <div class="custom-reportMenu-item" onclick="reportFunc('违法违规', 'harmful-info', 'textarea');">
                        <span class="custom-reportMenu-itemValue">违法违规</span>
                        <i class="fa fa-angle-right custom-right" aria-hidden="true"></i>
                    </div>
                    <div class="custom-reportMenu-item">
                        <span class="custom-reportMenu-itemValue">看相、算命、星盘等迷信活动</span>
                        <i class="fa fa-check-circle custom-right custom-reportMenu-itemCheckIcon" aria-hidden="true"></i>
                    </div>
                </div>
            </div>
            <div class="modal-footer custom-modal-footer">
                <button type="button" class="btn btn-default custom-report-btn return-btn">返回</button>
                <button type="button" class="btn btn-primary custom-report-btn">举报</button>
            </div>
        </div><!-- harmful info menu -->

        <!-- infringement menu -->
        <div id="reportMenu-infringement" class="modal-content hide">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title custom-title-center">举报</h4>
                <div class="custom-modal-subtitle">举报说明</div>
            </div>
            <div class="modal-body">
                <div class="custom-reportMenu-inner" style="margin-bottom: 0">
                    <div class="custom-reportMenu-item" onclick="reportFunc('不规范转载', 'infringement', 'textarea');">
                        <span class="custom-reportMenu-itemValue">不规范转载</span>
                        <i class="fa fa-angle-right custom-right" aria-hidden="true"></i>
                    </div>
                    <div class="custom-reportMenu-item" onclick="reportFunc('个人侵权', 'infringement', 'textarea');">
                        <span class="custom-reportMenu-itemValue">个人侵权</span>
                        <i class="fa fa-angle-right custom-right" aria-hidden="true"></i>
                    </div>
                    <div class="custom-reportMenu-item" onclick="reportFunc('企业侵权', 'infringement', 'textarea');">
                        <span class="custom-reportMenu-itemValue">企业侵权</span>
                        <i class="fa fa-angle-right custom-right" aria-hidden="true"></i>
                    </div>
                </div>
            </div>
            <div class="modal-footer custom-modal-footer">
                <button type="button" class="btn btn-default custom-report-btn return-btn">返回</button>
                <button type="button" class="btn btn-primary custom-report-btn">举报</button>
            </div>
        </div><!-- unfriendly menu -->
    </div>
</div>
<!-- end report modal -->

<!-- report type template -->
<script type="text/template" id="report-root-type-template">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title custom-title-center">举报</h4>
        <div class="custom-modal-subtitle">请选择举报理由</div>
    </div>
    <div class="modal-body">
        <div class="custom-reportMenu-inner">
            {{#each this}}
            <div class="custom-reportMenu-item" onclick="reportFunc('垃圾广告信息', 'index', 'textarea');">
                <span class="custom-reportMenu-itemValue">{{reportTypeContent}}</span>
                <i class="fa fa-angle-right custom-right" aria-hidden="true"></i>
            </div>
            {{/each}}
        </div>
    </div>
    <div class="modal-footer custom-modal-footer">
        <button type="button" class="btn btn-primary custom-report-btn">举报</button>
    </div>
</script><!-- end report type template -->

