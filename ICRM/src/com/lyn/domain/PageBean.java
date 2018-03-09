package com.lyn.domain;

import java.util.List;

public class PageBean<T> {
	//当前页数
	private Integer currentPage;
	//当前页的List
	private List<T> list;
	//总的页数
	private Integer totalPage;
	//总的条数
	private Integer count;
	//每页的个数
	private Integer pageSize;
	public Integer getCurrentPage() {
		if (currentPage==null) {
			currentPage = 1;
		}
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getPageSize() {
		if (pageSize==null) {
			pageSize = 3;
		}
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", list=" + list + ", totalPage=" + totalPage + ", count="
				+ count + ", pageSize=" + pageSize + "]";
	}
	
	
	

}
