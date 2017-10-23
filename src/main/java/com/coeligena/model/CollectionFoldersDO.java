package com.coeligena.model;

import javax.persistence.*;

/**
 * 回答收藏夹实体类
 *
 * <p>
 * Created by Ellery on 2017/10/23.
 */
@Entity
@Table(name = "collection_folders")
public class CollectionFoldersDO {

    /** 收藏夹 id */
    private int id;

    /** 收藏夹名称 */
    private String folderName;

    /** 收藏夹描述 */
    private String description;

    /** 收藏夹包含回答数量 */
    private int answersCount;

    /** 收藏夹关注者数量 */
    private int followersCount;

    /** 是否是公开收藏夹 */
    private byte isPublic;

    /** 收藏夹创建者 id */
    private int ownerId;

    /**
     * 获取收藏夹 id
     * @return 收藏夹 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置收藏夹 id
     * @param id 收藏夹 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取收藏夹名称
     * @return 收藏夹名称
     */
    @Column(name = "folder_name", nullable = false, length = 256)
    public String getFolderName() {
        return folderName;
    }

    /**
     * 设置收藏夹名称
     * @param folderName 收藏夹名称
     */
    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    /**
     * 获取收藏夹描述
     * @return 收藏夹描述
     */
    @Column(name = "description", nullable = false, length = 256)
    public String getDescription() {
        return description;
    }

    /**
     * 设置收藏夹描述
     * @param description 收藏夹描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取收藏夹创建者 id
     * @return 收藏夹创建者 id
     */
    @Column(name = "owner_id", nullable = false)
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * 设置收藏夹创建者 id
     * @param ownerId 收藏夹创建者 id
     */
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * 获取收藏夹包含回答数量
     * @return 收藏夹包含回答数量
     */
    @Column(name = "answers_count", nullable = false)
    public int getAnswersCount() {
        return answersCount;
    }

    /**
     * 设置收藏夹包含回答数量
     * @param answersCount 收藏夹包含回答数量
     */
    public void setAnswersCount(int answersCount) {
        this.answersCount = answersCount;
    }

    /**
     * 获取收藏夹包含关注者数量
     * @return 收藏夹包含关注者数量
     */
    @Column(name = "followers_count", nullable = false)
    public int getFollowersCount() {
        return followersCount;
    }

    /**
     * 设置收藏夹包含关注者数量
     * @param followersCount 收藏夹包含关注者数量
     */
    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    /**
     * 判断是否公开
     * @return 是否公开
     */
    @Column(name = "is_public", nullable = false, columnDefinition = "tinyint")
    public byte getIsPublic() {
        return isPublic;
    }

    /**
     * 设置是否公开
     * @param isPublic 是否公开
     */
    public void setIsPublic(byte isPublic) {
        this.isPublic = isPublic;
    }
}
