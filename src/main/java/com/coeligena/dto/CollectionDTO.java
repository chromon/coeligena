package com.coeligena.dto;

/**
 * collection dto
 * Created by Ellery on 2018/9/10.
 */
public class CollectionDTO {

    private String folderName;

    private String description;

    private byte forPublic;

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
}
