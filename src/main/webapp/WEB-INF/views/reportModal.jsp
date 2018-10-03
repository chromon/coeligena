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

        <input type="hidden" id="report_answer_id" value=""/>
        <input type="hidden" id="report_category" value=""/>
        <input type="hidden" id="report_type_id" value=""/>

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
                <button type="button" onclick="textReport();" class="btn btn-primary custom-report-btn">举报</button>
            </div>
        </div><!-- end text menu -->
    </div>
</div>
<!-- end report modal -->

<!-- report type template -->
<script type="text/template" id="report-root-type-template">

    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title custom-title-center">{{reportTypeDO.reportTypeContent}}</h4>
        <div class="custom-modal-subtitle">请选择举报理由</div>
    </div>
    <div class="modal-body">
        <div class="custom-reportMenu-inner">
            {{#each this.reportTypeDOList}}
            {{#if hasIcon}}
                {{#if requireDetails}}
                <div class="custom-reportMenu-item" onclick="reportTextArea('{{reportTypeContent}}', '{{parentReportTypeId}}');">
                    <span class="custom-reportMenu-itemValue">{{reportTypeContent}}</span>
                    <i class="fa fa-angle-right custom-right" aria-hidden="true"></i>
                </div>
                {{else}}
                <div class="custom-reportMenu-item" onclick="nextReportType('{{id}}');">
                    <span class="custom-reportMenu-itemValue">{{reportTypeContent}}</span>
                    <i class="fa fa-angle-right custom-right" aria-hidden="true"></i>
                </div>
                {{/if}}
            {{else}}
            <div class="custom-reportMenu-item" onclick="reportCheck(this,'{{id}}');">
                <span class="custom-reportMenu-itemValue">{{reportTypeContent}}</span>
                <i class="fa fa-check-circle custom-right custom-reportMenu-itemCheckIcon hide" aria-hidden="true"></i>
            </div>
            {{/if}}
            {{/each}}
        </div>
    </div>
    <div class="modal-footer custom-modal-footer">
        {{#if hasReturn}}
        <button type="button" onclick="reportReturn('{{reportTypeDO.parentReportTypeId}}')" class="btn btn-default custom-report-btn">返回</button>
        <button type="button" onclick="normalReport();" class="btn btn-primary custom-report-btn">举报</button>
        {{else}}
        <button type="button" class="btn btn-primary disabled custom-report-btn">举报</button>
        {{/if}}
    </div>
</script><!-- end report type template -->

