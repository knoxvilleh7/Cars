package project.model;

/**
 * Created on 25.08.2016.
 */
public class Page {

    private Integer pageNumber;
    private Long pageCount;
    private Integer pageSize;

    public Page(Integer pageNumber, Long pageCount, Integer pageSize) {
        this.pageNumber = pageNumber;
        this.pageCount = pageCount;
        this.pageSize = pageSize;
    }

    public Page() {
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public void setPageCount(Long pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
