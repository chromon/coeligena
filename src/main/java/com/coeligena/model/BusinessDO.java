package com.coeligena.model;

import javax.persistence.*;

/**
 * 所属行业实体类
 *
 * <p>
 * Created by Ellery on 2017/10/30.
 */
@Entity
@Table(name = "business")
public class BusinessDO {

    /** 行业 id */
    private int id;

    /** 行业名称 */
    private String jobName;

    /**
     * 获取行业 id
     * @return 行业 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置行业 id
     * @param id 行业 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取行业名称
     * @return 行业名称
     */
    @Column(name = "job_name", nullable = false, length = 64)
    public String getJobName() {
        return jobName;
    }

    /**
     * 设置行业名称
     * @param jobName 行业名称
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
}
