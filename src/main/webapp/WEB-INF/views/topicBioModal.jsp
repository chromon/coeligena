<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2018/6/7
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!-- anonymous modal -->
<div class="modal fade" id="topicBioModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title custom-topicBio-title">编辑话题经验</h4>
                <p class="custom-topicBio-subtitle">可以填写你从事的职业、取得的资格或过往经历，<br/>
                    让你在这个问题下的回答更具说服力。</p>
            </div>
            <div class="modal-body">
                <div class="custom-topicBio-items">
                    <div class="custom-topicBio-item">
                        <div class="custom-topicBioItems-title">
                            一句话介绍
                        </div>
                        <div class="custom-checkItem-box">
                            <div class="custom-checkItem-inner">
                                <div class="custom-author-info">
                                    <a href="#" id="user-avatar">
                                        <img class="custom-avatar38" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="Ellery">
                                    </a>
                                    <div class="custom-author-info-content2">
                                        <div class="custom-author-info-head">
                                            <span class="custom-author-name">Bone</span>
                                        </div>
                                        <div class="custom-author-info-detail2">
                                            <div class="custom-authorInfo-badge">
                                                <span class="custom-topicBio-itemText">。</span>
                                                <a href="" class="custom-topic-bios">
                                                    <i class="fa fa-pencil"></i>
                                                    修改
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <i class="fa fa-check-circle custom-check-icon" aria-hidden="true"></i>
                        </div>
                    </div>
                    <div class="custom-topicBio-item">
                        <button type="button" class="btn custom-topicBio-addBtn custom-btn-plain custom-btn-spread custom-topicBio-btn">
                            <i class="fa fa-plus" aria-hidden="true"></i>
                            添加在 XXX 话题下的话题经验
                        </button>
                    </div>
                </div>
            </div>
            <div class="modal-footer custom-align-center">
                <button type="button" class="btn btn-primary custom-center-btn">完成</button>
            </div>
        </div>
    </div>
</div>
<!-- end anonymous modal -->

<!-- real name modal -->
<div class="modal fade" id="realNameModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog custom-modal-size" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">确认取消匿名身份？</h4>
            </div>
            <div class="modal-body">
                <div class="Anonymous-confirm">
                    <p>取消匿名身份后， 提问、回答、赞同和关注将以实名显示。</p>
                </div>
            </div>
            <div class="modal-footer">
                <button data-dismiss="modal" type="button" class="btn btn-default">取消</button>
                <button id="realname_confirm" type="button" class="btn btn-primary">确认</button>
            </div>
        </div>
    </div>
</div>
<!-- end real name modal -->
