package com.coeligena.dto;

import com.coeligena.function.paging.Page;

import java.util.List;

/**
 * list with paging
 * Created by Ellery on 2018/7/14.
 */
public class PagingListDTO<T> {

    private List<T> list;

    private Page page;

    public PagingListDTO(List<T> list, Page page) {
        this.list = list;
        this.page = page;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
