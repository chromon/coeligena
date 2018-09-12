<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2018/5/7
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!-- collection modal -->
<div class="modal fade" id="collectModal">
    <div class="modal-dialog" role="document">
        <div id="add_favorite" class="modal-content custom-modal-padding">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 id="modalAddLabel" class="modal-title">添加到收藏夹</h4>
                <h4 id="modalCreateLabel" class="modal-title hidden">创建新收藏夹</h4>
            </div>
            <div class="modal-body">
                <div id="favorite_list" class="custom-favor-list">
                </div>
                <div id="create_favorite" class="hidden">
                    <div class="custom-create-collection">
                        <input id="collection_folder_name" type="text" class="custom-collection-text form-control custom-margin-bottom10" placeholder="收藏标题">
                        <textarea id="collection_description" class="custom-collection-text form-control custom-margin-bottom10" rows="3" placeholder="收藏描述（可选）"></textarea>
                        <div class="custom-margin-bottom10">
                            <input name="folder_privacy" type="radio" value="1" checked="">
                            公开 <span class="custom-collection-text">有其他人关注此收藏夹时不可设置为私密</span>
                        </div>
                        <div class="custom-margin-bottom10">
                            <input name="folder_privacy" type="radio" value="0">
                            私密 <span class="custom-collection-text">只有你自己可以查看这个收藏夹</span>
                        </div>
                    </div>
                </div>
            </div>
            <div id="modalAddFooter" class="modal-footer">
                <button type="button" class="btn btn-default custom-left" id="create_favorite_btn">
                    <i class="fa fa-plus-circle" aria-hidden="true"></i> 创建收藏夹
                </button>
                <button type="button" class="btn btn-primary">完成</button>
            </div>
            <div id="modalCreateFooter" class="modal-footer hidden">
                <button type="button" class="btn btn-default" id="return_add_favorite">返回</button>
                <button type="button" class="btn btn-primary" id="create_collection_folder">确认创建</button>
            </div>
        </div>
    </div>
</div>
<!-- end collection modal -->

<script type="text/template" id="collection-folder-items-template">
    {{#if this}}
    <div id="collection-folder-items" class="custom-favlists-items">
        {{#each this}}
        <div class="custom-favlists-item">
            <div class="custom-favlists-itemInner">
                <div class="custom-favlists-itemName">
                    <span class="custom-favlists-itemName-text">{{folderName}}</span>
                    {{#if forPublic}}
                    {{else}}
                    <span class="custom-collection-lock"><i class="fa fa-lock" aria-hidden="true"></i></span>
                    {{/if}}
                </div>
                <div class="custom-favlists-itemContent">
                    {{answersCount}} 条内容
                </div>
            </div>
            <button type="button" class="custom-favlists-btn custom-btn btn-outline-primary">
                收藏
            </button>
        </div>
        {{/each}}
    </div>
    {{else}}
    <span>你可以创建多个收藏夹，将答案分类收藏</span>
    {{/if}}
</script>

<script type="text/template" id="collection-folder-item-template">
    <div class="custom-favlists-item">
        <div class="custom-favlists-itemInner">
            <div class="custom-favlists-itemName">
                <span class="custom-favlists-itemName-text">{{folderName}}</span>
                {{#if forPublic}}
                {{else}}
                <span class="custom-collection-lock"><i class="fa fa-lock" aria-hidden="true"></i></span>
                {{/if}}
            </div>
            <div class="custom-favlists-itemContent">
                {{answersCount}} 条内容
            </div>
        </div>
        <button type="button" class="custom-favlists-btn custom-btn btn-outline-primary">
            收藏
        </button>
    </div>
</script>