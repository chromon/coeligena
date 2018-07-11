package com.coeligena.function.paging;

/**
 * paging
 * Created by Ellery on 2018/7/10.
 */
public class Page {

    // 当前页
    private int pageNum;
    // 每页的数量
    private int pageSize;

    // 总页数
    private int pages;
    // 总记录数
    private int size;

    // 可以在页面中"显示startRow到endRow 共size条数据"
    // 当前页面第一个元素在数据库中的行号
    private int startRow;
    // 当前页面最后一个元素在数据库中的行号
    private int endRow;

    // 前一页
    private int prePage;
    // 下一页
    private int nextPage;

    // 是否为第一页
    private boolean isFirstPage = false;
    // 是否为最后一页
    private boolean isLastPage = false;
    // 是否有前一页
    private boolean hasPreviousPage = false;
    // 是否有下一页
    private boolean hasNextPage = false;

    // 导航页码数
    private int navigatePages;
    // 所有导航页号
    private int[] navigatePageNums;
    // 导航条上的第一页
    private int navigateFirstPage;
    // 导航条上的最后一页
    private int navigateLastPage;

    public Page() {
    }

    public Page(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;

        calcPages();
        calcPreNextPage();
        calcPageBoundary();

        this.startRow = (this.pageNum - 1) * this.pageSize;
    }

    /**
     * 计算总页数
     */
    private void calcPages() {
        // 总页数
        if (this.size < 0) {
            this.pages = 1;
        } else {
            if (this.pageSize > 0) {
                this.pages = this.size % this.pageSize == 0?
                        this.size / this.pageSize : this.size / this.pageSize + 1;
            } else {
                this.pages = 0;
            }
        }
    }

    /**
     * 计算前后页
     */
    private void calcPreNextPage() {
        if (this.pageNum > 1) {
            this.prePage = this.pageNum - 1;
        }
        if (this.pageNum < this.pages) {
            this.nextPage = this.pageNum + 1;
        }
    }

    /**
     * 计算页边界
     */
    private void calcPageBoundary() {
        this.isFirstPage = (this.pageNum == 1);
        this.isLastPage = (this.pageNum == this.pages) || (this.pages == 0);
        this.hasPreviousPage = (this.pageNum > 1);
        this.hasNextPage = (this.pageNum < this.pages);
    }

    /**
     * 计算导航页码
     */
    private void calcNavigatePageNums() {

        if (this.pages <= this.navigatePages) {
            //当总页数小于或等于导航页码数时
            this.navigatePageNums = new int[this.pages];
            for (int i = 0; i < this.pages; i++) {
                this.navigatePageNums[i] = i + 1;
            }
        } else {
            //当总页数大于导航页码数时
            this.navigatePageNums = new int[this.navigatePages];
            int startNum = this.pageNum - this.navigatePages / 2;
            int endNum = this.pageNum + this.navigatePages / 2;

            if (startNum < 1) {
                startNum = 1;
                //(最前navigatePages页
                for (int i = 0; i < navigatePages; i++) {
                    navigatePageNums[i] = startNum++;
                }
            } else if (endNum > pages) {
                endNum = pages;
                //最后navigatePages页
                for (int i = navigatePages - 1; i >= 0; i--) {
                    navigatePageNums[i] = endNum--;
                }
            } else {
                //所有中间页
                for (int i = 0; i < navigatePages; i++) {
                    navigatePageNums[i] = startNum++;
                }
            }
        }
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSize() {
        return size;
    }

    /**
     * 设置总的记录数
     * @param size 总的记录数
     */
    public void setSize(int size) {
        this.size = size;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    public int[] getNavigatePageNums() {
        return navigatePageNums;
    }

    public void setNavigatePageNums(int[] navigatePageNums) {
        this.navigatePageNums = navigatePageNums;
    }

    public int getNavigateFirstPage() {
        return navigateFirstPage;
    }

    public void setNavigateFirstPage(int navigateFirstPage) {
        this.navigateFirstPage = navigateFirstPage;
    }

    public int getNavigateLastPage() {
        return navigateLastPage;
    }

    public void setNavigateLastPage(int navigateLastPage) {
        this.navigateLastPage = navigateLastPage;
    }
}
