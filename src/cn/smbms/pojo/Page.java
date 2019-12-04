package cn.smbms.pojo;

public class Page {
	private int currPageNo; // 当前页码
	private int totalPageCount; // 总页数
	private int totalCount; // 总记录数
	private int pageSize; // 页大小

	public int getCurrPageNo() {
		return currPageNo;
	}

	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;
			this.totalPageCount = this.totalCount % this.pageSize == 0  ? this.totalCount
					/ this.pageSize 
					: this.totalCount / this.pageSize + 1;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
