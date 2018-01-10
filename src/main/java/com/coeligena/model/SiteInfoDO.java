package com.coeligena.model;

import javax.persistence.*;

/**
 *<P>
 *     站点信息实体类
 *</P>
 *
 * Created by Ellery on 2018/1/9.
 */
@Entity
@Table(name = "site_info")
public class SiteInfoDO {

    /** 站点 id */
    private int id;

    /** 站点名称 */
    private String siteName;

    /** 站点首页 logo 路径 */
    private String logoLarge;

    /** 站点导航菜单 logo 路径 */
    private String logoNavbar;

    /** 站点版权信息 */
    private String copyRight;

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "site_name", nullable = false, length = 32)
    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    @Column(name = "logo_large", nullable = false, length = 256)
    public String getLogoLarge() {
        return logoLarge;
    }

    public void setLogoLarge(String logoLarge) {
        this.logoLarge = logoLarge;
    }

    @Column(name = "logo_navbar", nullable = false, length = 256)
    public String getLogoNavbar() {
        return logoNavbar;
    }

    public void setLogoNavbar(String logoNavbar) {
        this.logoNavbar = logoNavbar;
    }

    @Column(name = "copyright", nullable = false, length = 32)
    public String getCopyRight() {
        return copyRight;
    }

    public void setCopyRight(String copyRight) {
        this.copyRight = copyRight;
    }
}
