package com.coeligena.model;

import javax.persistence.*;

/**
 * 回答收藏实体类
 *
 * <p>
 * Created by Ellery on 2017/10/23.
 */
@Entity
@Table(name = "collections")
public class CollectionsDO {

    /** 收藏 id */
    private int id;

    /** 被收藏的回答 id */
    private int answerId;

    /** 所属收藏夹 id */
    private int collectionFolderId;

    /** 收藏夹所属用户 id */
    private int ownerId;

    /**
     * 获取收藏 id
     * @return 收藏 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置收藏 id
     * @param id 收藏 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取被收藏的回答 id
     * @return 被收藏的回答 id
     */
    @Column(name = "answer_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getAnswerId() {
        return answerId;
    }

    /**
     * 设置被收藏的回答 id
     * @param answerId 被收藏的回答 id
     */
    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    /**
     * 获取所属收藏夹 id
     * @return 所属收藏夹 id
     */
    @Column(name = "collection_folder_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getCollectionFolderId() {
        return collectionFolderId;
    }

    /**
     * 设置所属收藏夹 id
     * @param collectionFolderId 所属收藏夹 id
     */
    public void setCollectionFolderId(int collectionFolderId) {
        this.collectionFolderId = collectionFolderId;
    }

    /**
     * 获取收藏夹所属用户 id
     * @return 收藏夹所属用户id
     */
    @Column(name = "owner_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * 设置收藏夹所属用户 id
     * @param ownerId 收藏夹所属用户 id
     */
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
