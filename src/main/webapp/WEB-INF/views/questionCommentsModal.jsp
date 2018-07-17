<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2018/6/7
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!-- question comment modal -->
<div class="modal fade" id="questionCommentsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <div class="custom-comments-container">
                    <div class="custom-comments" style="padding: 0">
                        <!-- comment top bar -->
                        <div class="custom-comments-topbar">
                            <div class="custom-comments-topbar-title">
                                <h2>1 条评论</h2>
                            </div>
                            <div class="custom-comments-topbar-option">
                                <button class="custom-btn-plain custom-contentItem-right" type="button">
                                    <span style="display: inline-flex;align-items: center;">
                                        <i class="fa fa-exchange custom-margin-right5"></i>
                                        <span>切换为时间排序</span>
                                    </span>
                                </button>
                            </div>
                        </div><!-- end comment top bar -->

                        <!-- question comments template -->
                        <script type="text/x-handlebars-template" id="question_comment_template">
                            {{#if isPost}}
                            <!-- comment item (post comment) -->
                            <div class="custom-comment-item">
                                <div onmouseover="showElement(this);" onmouseout="hideElement(this);">
                                    <div class="custom-commentItem-meta">
                                        <span>
                                            <a href="#">
                                                <img class="custom-commentItem-avatar custom-avatar24" src="<%=request.getContextPath()%>{{user.avatarPath}}" alt="{{user.fullname}}">
                                            </a>
                                        </span>
                                        <span>
                                            <a class="custom-comment-userLink" href="#">{{user.fullname}}</a>
                                        </span>
                                        {{#if reviewer}}
                                        <span>
                                            <span class="custom-commentItem-reply">回复</span>
                                            <a class="custom-comment-userLink" href="#">{{reviewer.fullname}}</a>
                                        </span>
                                        {{/if}}
                                        <span class="custom-commentItem-time">{{questionCommentsDO.commentTime}}</span>
                                    </div>
                                    <div class="custom-commentItem-content">
                                        {{questionCommentsDO.commentContent}}
                                    </div>
                                    <div class="custom-commentItem-footer">
                                        <button class="custom-btn-plain custom-margin-right20" type="button">
                                            <span style="display: inline-flex;align-items: center;">
                                                <i class="fa fa-thumbs-up custom-margin-right5"></i>
                                                <span>赞</span>
                                            </span>
                                        </button>
                                        {{#if reviewer}}
                                        <button class="custom-btn-plain custom-margin-right20" type="button">
                                            <span style="display: inline-flex;align-items: center;">
                                                <i class="fa fa-comment custom-margin-right5"></i>
                                                <span>查看对话</span>
                                            </span>
                                        </button>
                                        {{/if}}
                                        <span class="hide comment-hide">
                                            <button class="custom-btn-plain custom-margin-right20" type="button">
                                                <span style="display: inline-flex;align-items: center;">
                                                    <i class="fa fa-share custom-margin-right5"></i>
                                                    <span>回复</span>
                                                </span>
                                            </button>
                                            <button class="custom-btn-plain custom-margin-right20" type="button">
                                                <span style="display: inline-flex;align-items: center;">
                                                    <i class="fa fa-thumbs-down custom-margin-right5"></i>
                                                    <span>踩</span>
                                                </span>
                                            </button>
                                            <button class="custom-btn-plain custom-margin-right20" type="button">
                                                <span style="display: inline-flex;align-items: center;">
                                                    <i class="fa fa-flag custom-margin-right5"></i>
                                                    <span>举报</span>
                                                </span>
                                            </button>
                                        </span>
                                    </div>
                                </div>
                            </div><!-- end comment item -->
                            {{else}}
                            {{#each this.list}}
                            <!-- comment item (list comment) -->
                            <div class="custom-comment-item">

                                <input type="hidden" id="question_comment_id" value="{{questionCommentsDO.id}}">

                                <div class="question_comment_item" id="question_comment_item_{{questionCommentsDO.id}}" onmouseover="showElement(this);" onmouseout="hideElement(this);">
                                    <div class="custom-commentItem-meta">
                                        <span>
                                            <a href="#">
                                                <img class="custom-commentItem-avatar custom-avatar24" src="<%=request.getContextPath()%>{{user.avatarPath}}" alt="{{user.fullname}}">
                                            </a>
                                        </span>
                                        <span>
                                            <a class="custom-comment-userLink" href="#">{{user.fullname}}</a>
                                        </span>
                                        {{#if reviewer}}
                                        <span>
                                            <span class="custom-commentItem-reply">回复</span>
                                            <a class="custom-comment-userLink" href="#">{{reviewer.fullname}}</a>
                                        </span>
                                        {{/if}}
                                        <span class="custom-commentItem-time">{{questionCommentsDO.commentTime}}</span>
                                    </div>
                                    <div class="custom-commentItem-content">
                                        {{questionCommentsDO.commentContent}}
                                    </div>
                                    <!-- reply comment -->
                                    <div id="reply-content-{{questionCommentsDO.id}}" class="hide" style="padding-bottom: 30px;">
                                        <div class="form-group">
                                            <input type="hidden" id="parent-comment-id-r-{{questionCommentsDO.id}}" value="{{questionCommentsDO.id}}">
                                            <input type="hidden" id="reviewer-id-r-{{questionCommentsDO.id}}" value="{{user.id}}">
                                            <textarea id="question-comment-r-{{questionCommentsDO.id}}" class="form-control" rows="1" placeholder="回复：{{user.fullname}}" style="font-size: 14px;"></textarea>
                                            <div class="custom-right" style="padding-top: 15px;">
                                                <button id="cancel-reply-{{questionCommentsDO.id}}" onclick="hideReplyContent('{{questionCommentsDO.id}}');" class="btn btn-default btn-sm">取消</button>
                                                <button id="question-comment-btn-{{questionCommentsDO.id}}" onclick="postReply('{{questionCommentsDO.id}}');" type="button" class="btn btn-primary btn-sm">评论</button>
                                            </div>
                                        </div>
                                    </div><!-- end reply comment -->
                                    <div class="custom-commentItem-footer" id="commentItem-footer-{{questionCommentsDO.id}}">
                                        <button class="custom-btn-plain custom-margin-right20" type="button">
                                            <span style="display: inline-flex;align-items: center;">
                                                <i class="fa fa-thumbs-up custom-margin-right5"></i>
                                                <span>赞</span>
                                            </span>
                                        </button>
                                        {{#if reviewer}}
                                        <button class="custom-btn-plain custom-margin-right20" type="button">
                                            <span style="display: inline-flex;align-items: center;">
                                                <i class="fa fa-comment custom-margin-right5"></i>
                                                <span>查看对话</span>
                                            </span>
                                        </button>
                                        {{/if}}
                                        <span class="hide comment-hide">
                                            <button onclick="replyContent('{{questionCommentsDO.id}}')" class="custom-btn-plain custom-margin-right20" type="button">
                                                <span style="display: inline-flex;align-items: center;">
                                                    <i class="fa fa-share custom-margin-right5"></i>
                                                    <span>回复</span>
                                                </span>
                                            </button>
                                            <button class="custom-btn-plain custom-margin-right20" type="button">
                                                <span style="display: inline-flex;align-items: center;">
                                                    <i class="fa fa-thumbs-down custom-margin-right5"></i>
                                                    <span>踩</span>
                                                </span>
                                            </button>
                                            <button class="custom-btn-plain custom-margin-right20" type="button">
                                                <span style="display: inline-flex;align-items: center;">
                                                    <i class="fa fa-flag custom-margin-right5"></i>
                                                    <span>举报</span>
                                                </span>
                                            </button>
                                        </span>
                                    </div>
                                </div>
                            </div><!-- end comment item -->
                            {{/each}}
                            {{/if}}
                        </script><!-- end question comments template -->

                        <!-- comment list -->
                        <div class="custom-comment-list" id="question_comment_wrapper">

                            <%--<div class="skeleton">--%>
                                <%--<div class="skeleton-head"></div>--%>
                                <%--<div class="skeleton-body">--%>
                                    <%--<div class="skeleton-title"></div>--%>
                                    <%--<div class="skeleton-content"></div>--%>
                                <%--</div>--%>
                                <%--<div class="skeleton-detail"></div>--%>
                            <%--</div>--%>

                            <%--<!-- comment item divider -->--%>
                            <%--<div class="custom-comment-list-divider">--%>
                            <%--<div class="custom-comment-list-dividerLine"></div>--%>
                            <%--<div class="custom-comment-list-dividerText">--%>
                            <%--以上为精选评论--%>
                            <%--<i class="fa fa-question-circle"></i>--%>
                            <%--</div>--%>
                            <%--</div><!-- end comment item divider -->--%>

                        </div><!-- end comment list -->
                        <script type="text/x-handlebars-template" id="question-comments-paging-template">

                            <!-- comment pagination -->
                            <div class="custom-pagination">
                                <!-- previous page -->
                                {{#if hasPreviousPage}}
                                <button onclick="questionCommentsWithPage('{{prePage}}');" class="custom-pagination-btn custom-btn-plain" type="button">上一页</button>
                                {{else}}
                                <button onclick="questionCommentsWithPage('{{prePage}}');" class="custom-pagination-btn custom-btn-plain custom-pagination-btn-current" type="button">上一页</button>
                                {{/if}}<!-- end previous page -->

                                <!-- first page -->
                                {{#compare pageNum 1}}
                                <button onclick="questionCommentsWithPage(1);" class="custom-pagination-btn custom-btn-plain custom-pagination-btn-current" type="button">1</button>
                                {{else}}
                                <button onclick="questionCommentsWithPage(1);" class="custom-pagination-btn custom-btn-plain" type="button">1</button>
                                {{/compare}}<!-- end first page -->

                                <!-- navigate page -->
                                {{#if showFirstEllipsis}}
                                <span class="custom-pagination-btn">•••</span>
                                {{/if}}
                                {{#each navigatePageNums}}
                                {{#compare ../pageNum this}}
                                <button onclick="questionCommentsWithPage('{{this}}');" class="custom-pagination-btn custom-btn-plain custom-pagination-btn-current" type="button">{{this}}</button>
                                {{else}}
                                <button onclick="questionCommentsWithPage('{{this}}');" class="custom-pagination-btn custom-btn-plain" type="button">{{this}}</button>
                                {{/compare}}
                                {{/each}}
                                {{#if showLastEllipsis}}
                                <span class="custom-pagination-btn">•••</span>
                                {{/if}}<!-- end navigate page -->

                                <!-- last page -->
                                {{#compare pageNum totalPages}}
                                <button onclick="questionCommentsWithPage('{{totalPages}}');" class="custom-pagination-btn custom-btn-plain custom-pagination-btn-current" type="button">{{totalPages}}</button>
                                {{else}}
                                <button onclick="questionCommentsWithPage('{{totalPages}}');" class="custom-pagination-btn custom-btn-plain" type="button">{{totalPages}}</button>
                                {{/compare}}
                                <!-- end last page -->

                                <!-- next page -->
                                {{#if hasNextPage}}
                                <button onclick="questionCommentsWithPage('{{nextPage}}');" class="custom-pagination-btn custom-btn-plain" type="button">下一页</button>
                                {{else}}
                                <button onclick="questionCommentsWithPage('{{nextPage}}');" class="custom-pagination-btn custom-btn-plain custom-pagination-btn-current" type="button">下一页</button>
                                {{/if}}<!-- end next page -->
                            </div><!-- end comment pagination -->
                        </script>
                        <div id="question-comments-paging-wrapper">

                        </div>
                        <!-- collapse comment -->
                        <div class="custom-comment-list-action">
                            <div class="custom-comment-list-collapse">
                                <span>1 条评论被折叠</span>
                                （<a href="">为什么？</a>）
                            </div>
                        </div><!-- end collapse comment -->
                        <!-- comment footer -->
                        <div class="custom-comments-footer custom-comments-editor">
                            <div class="form-group" style="margin-bottom: 0px;">
                                <input type="hidden" id="parent-comment-id" value="0">
                                <input type="hidden" id="reviewer-id" value="0">
                                <textarea id="question-comment" class="form-control custom-question-comment" rows="1"></textarea>
                                <button id="comment-question-btn" class="btn btn-primary btn-sm" style="float:right;" type="button">评论</button>
                            </div>
                        </div><!-- end comment footer -->
                    </div>
                </div><!-- feed comment -->
            </div>
        </div>
    </div>
</div>
<!-- end question comment modal -->
