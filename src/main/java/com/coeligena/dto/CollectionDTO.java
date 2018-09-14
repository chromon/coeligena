package com.coeligena.dto;

/**
 * collection dto
 * Created by Ellery on 2018/9/10.
 */
public class CollectionDTO {

    private int folderId;

    private String folderName;

    private String description;

    private byte forPublic;

    private int answerId;

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte getForPublic() {
        return forPublic;
    }

    public void setForPublic(byte forPublic) {
        this.forPublic = forPublic;
    }

    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }
}
