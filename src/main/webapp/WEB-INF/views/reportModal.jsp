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
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">举报</h4>
            </div>
            <div class="modal-body">
                <div id="reportTree"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">举报</button>
            </div>
        </div>
    </div>
</div>
<!-- end report modal -->


