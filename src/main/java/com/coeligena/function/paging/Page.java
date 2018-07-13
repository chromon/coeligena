package com.coeligena.function.paging;

import java.util.Arrays;

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
    private int totalPages;
    // 总记录数
    private int size;

    // 当前页面第一个元素在数据库中的行号
    private int startPos;

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

    // 是否额外显示首页省略号
    private boolean isShowFirstEllipsis = false;
    // 是否额外显示尾页省略号
    private boolean isShowLastEllipsis = false;

    public Page() {
    }

    public Page(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    /**
     * 初始方法
     */
    public void init() {
        // 计算起始位置
        calcStartPos();
        // 计算总页数
        calcPages();
        // 计算导航页
        calcNavigatePageNums();
        // 计算前后页
        calcPreNextPage();
        // 计算页边界
        calcPageBoundary();
        // 计算是否额外显示首尾页省略号
        calcFirstLastEllipsis();
    }

    /**
     * 计算起始位置
     */
    private void calcStartPos() {
        this.startPos = (this.pageNum - 1) * this.pageSize;
    }

    /**
     * 计算总页数
     */
    private void calcPages() {
        // 总页数
        if (this.size < 0) {
            this.totalPages = 1;
        } else {
            if (this.pageSize > 0) {
                this.totalPages = this.size % this.pageSize == 0?
                        this.size / this.pageSize : this.size / this.pageSize + 1;
            } else {
                this.totalPages = 0;
            }
        }
    }

    /**
     * 计算前后页
     */
    private void calcPreNextPage() {
        if (this.navigatePageNums != null && this.navigatePageNums.length > 0) {
            this.navigateFirstPage = this.navigatePageNums[0];
            this.navigateLastPage = this.navigatePageNums[this.navigatePageNums.length - 1];

            if (this.pageNum > 1) {
                this.prePage = this.pageNum - 1;
            }
            if (this.pageNum < this.totalPages) {
                this.nextPage = this.pageNum + 1;
            }
        }
    }

    /**
     * 计算页边界
     */
    private void calcPageBoundary() {
        this.isFirstPage = (this.pageNum == 1);
        this.isLastPage = (this.pageNum == this.totalPages) || (this.totalPages == 0);
        this.hasPreviousPage = (this.pageNum > 1);
        this.hasNextPage = (this.pageNum < this.totalPages);
    }

    /**
     * 计算导航页码
     */
    private void calcNavigatePageNums() {

        if (this.totalPages <= this.navigatePages) {
            //当总页数小于或等于导航页码数时
            this.navigatePageNums = new int[this.totalPages];
            for (int i = 0; i < this.totalPages; i++) {
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
            } else if (endNum > this.totalPages) {
                endNum = this.totalPages;
                //最后navigatePages页
                for (int i = this.navigatePages - 1; i >= 0; i--) {
                    this.navigatePageNums[i] = endNum--;
                }
            } else {
                //所有中间页
                for (int i = 0; i < this.navigatePages; i++) {
                    this.navigatePageNums[i] = startNum++;
                }
            }
        }
    }

    /**
     * 计算是否显示首页尾页
     */
    private void calcFirstLastEllipsis() {
        if (this.navigateFirstPage > 2) {
            this.isShowFirstEllipsis = true;
        }
        if (this.totalPages - this.navigateLastPage >= 2) {
            this.isShowLastEllipsis = true;
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

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
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

    public boolean isShowFirstEllipsis() {
        return isShowFirstEllipsis;
    }

    public void setShowFirstEllipsis(boolean showFirstEllipsis) {
        isShowFirstEllipsis = showFirstEllipsis;
    }

    public boolean isShowLastEllipsis() {
        return isShowLastEllipsis;
    }

    public void setShowLastEllipsis(boolean showLastEllipsis) {
        isShowLastEllipsis = showLastEllipsis;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalPages=" + totalPages +
                ", size=" + size +
                ", startPos=" + startPos +
                ", prePage=" + prePage +
                ", nextPage=" + nextPage +
                ", isFirstPage=" + isFirstPage +
                ", isLastPage=" + isLastPage +
                ", hasPreviousPage=" + hasPreviousPage +
                ", hasNextPage=" + hasNextPage +
                ", navigatePages=" + navigatePages +
                ", navigatePageNums=" + Arrays.toString(navigatePageNums) +
                ", navigateFirstPage=" + navigateFirstPage +
                ", navigateLastPage=" + navigateLastPage +
                ", isShowFirstEllipsis=" + isShowFirstEllipsis +
                ", isShowLastEllipsis=" + isShowLastEllipsis +
                '}';
    }

    public static void main(String[] args) {
        Page page = new Page(1, 2);
        page.setSize(11);
        page.setNavigatePages(3);
        page.init();
        System.out.println(page.toString());

        page = new Page(3, 2);
        page.setSize(11);
        page.setNavigatePages(3);
        page.init();
        System.out.println(page.toString());

        page = new Page(4, 2);
        page.setSize(11);
        page.setNavigatePages(3);
        page.init();
        System.out.println(page.toString());

    }
}
