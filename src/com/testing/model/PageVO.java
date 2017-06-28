package com.testing.model;

import java.io.Serializable;
import java.util.List;

public class PageVO implements Serializable {
	private int page = 1;
	private int pageSize = 10;

	private int count;
	private int lastPage;

	private List list;

	private int start;
	private int end;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "PageVO [page=" + page + ", pageSize=" + pageSize + ", count="
				+ count + ", lastPage=" + lastPage + ", list=" + list
				+ ", start=" + start + ", end=" + end + "]\n";
	}

}
