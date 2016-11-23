package com.gsdp.entity;

/**
 * 完成分页功能的实体类
 * @author yizijun
 *
 */
public class Page {

	private int totalNums;

	private int perPageDisplay = 5;

	private int startNums;

	private int totalPages;

	private int currentPage;

	public int getTotalNums() {
		return totalNums;
	}

	public void setTotalNums(int totalNums) {
		this.totalNums = totalNums;
	}

	public int getPerPageDisplay() {
		return perPageDisplay;
	}

	public void setPerPageDisplay(int perPageDisplay) {
		this.perPageDisplay = perPageDisplay;
	}

	public int getStartNums() {
		return startNums;
	}

	public void setStartNums(int startNums) {
		this.startNums = startNums;
	}

	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * 设置总共的页数
	 * @param totalNotes
	 */
	private void setTotalPages(int totalNotes) {

		if(0 == totalNotes) {
			totalPages = 1;
		} else {
			totalPages = (int)Math.ceil(totalNotes / (perPageDisplay * 1.0));
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * 设置当前的页码
	 *
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {

		if(currentPage < 1) {
			this.currentPage = 1;
		} else {
			this.currentPage = currentPage;
		}

	}

	/**
	 * 初始化分页的一些参数
	 * @param totalNotes
	 * @param page
	 */
	public void initPage(int totalNotes, String page) {

		int realPage = 0;

		/*
		 * 判断传入的数据的正确性
		 */
		if(page != null && page.matches("[0-9]{1,9}")) {
			realPage = Integer.parseInt(page);
		}
		setTotalNums(totalNotes);
		setTotalPages(totalNotes);

		if (realPage > totalPages) {
			this.currentPage = totalPages;
		} else {
			setCurrentPage(realPage);
		}

		setStartNums((currentPage - 1) * perPageDisplay);
	}

}
