package finance.ideal.util;


import java.util.List;

/**
 * 分页用的基类，抽取了通用的分页参数
 *
 */
public class PageUtil<T> {
    private int pageIndex=1;// 当前页数
    private int pageSize=8 ;// 每页显示的行数
    private int totalCount;// 总记录数
    private int totalPageCount;// 总页数
    private List<T> dataList ;// 分页结果的泛型集合

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        // 判断当前页码，如果页码大于零，则显示为当前的pageIndex页面，否则pageIndex为1，即第一页
        if (pageIndex > 0) {
            this.pageIndex = pageIndex;
        } else {
            this.pageIndex = 1;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        // 设置每页显示数据的条数
        if (pageSize > 0) {
            this.pageSize = pageSize;
        } else {
            this.pageSize = 5;
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount > 0) {
            //总记录数
            this.totalCount = totalCount;
            //计算总页数
            this.totalPageCount = (this.totalCount % this.pageSize == 0) ? (this.totalCount / this.pageSize)
                    : (this.totalCount / this.pageSize + 1);
        }
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}