package com.coeligena.model;

import javax.persistence.*;

/**
 * 收藏夹关注实体类
 *
 * <p>
 * Created by Ellery on 2017/10/23.
 */
@Entity
@Table(name = "collection_folder_follow")
public class CollectionFolderFollowDO {

    /** 收藏夹关注 id */
    private int id;

    /** 收藏夹 id */
    private int collectionFolderId;

    /** 收藏夹关注者 id */
    private int followerId;

    /**
     * 获取收藏关注 id
     * @return 收藏关注 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置收藏关注 id
     * @param id 收藏关注 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取收藏夹 id
     * @return 收藏夹 id
     */
    @Column(name = "collection_folder_id", nullable = false)
    public int getCollectionFolderId() {
        return collectionFolderId;
    }

    /**
     * 设置收藏夹 id
     * @param collectionFolderId 收藏夹 id
     */
    public void setCollectionFolderId(int collectionFolderId) {
        this.collectionFolderId = collectionFolderId;
    }

    /**
     * 获取收藏夹关注者 id
     * @return 收藏夹关注者 id
     */
    @Column(name = "follower_id", nullable = false)
    public int getFollowerId() {
        return followerId;
    }

    /**
     * 设置收藏夹关注者 id
     * @param followerId 收藏夹关注者 id
     */
    public void setFollowerId(int followerId) {
        this.followerId = followerId;
    }
}
