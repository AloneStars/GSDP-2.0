package com.gsdp.entity;

/**
 * 完成分页功能的实体类
 * @author yizijun
 *
 */
public class Page {

	private int totalNumbers;

	private int perPageDisplay;

	private int startNumbers;

	private int totalPages;

	private int currentPage;

	public int getTotalNumbers() {
		return totalNumbers;
	}

	public void setTotalNumbers(int totalNumbers) {
		this.totalNumbers = totalNumbers;
	}

	public int getPerPageDisplay() {
		return perPageDisplay;
	}

	public void setPerPageDisplay(int perPageDisplay) {
		this.perPageDisplay = perPageDisplay;
	}

	public int getStartNumbers() {
		return startNumbers;
	}

	public void setStartNumbers(int startNumbers) {
		this.startNumbers = startNumbers;
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
	 * @param totalNotes
	 * @param page
	 * @param perPageDisplay
	 */
	public void initPage(int totalNotes, int page, int perPageDisplay) {

		//当前显示的页数
		int realPage = 1;

//		if(page != null && !page.equals("0") && page.matches("[0-9]{1,9}")) {
//			realPage = Integer.parseInt(page);
//		}

		if(0 < page) {
			realPage = page;
		}

		//设置每页显示的数
		setPerPageDisplay(perPageDisplay);
		//设置总共的数目
		setTotalNumbers(totalNotes);
		//设置总共的页数
		setTotalPages(totalNotes);

		if (realPage > totalPages) {
			this.currentPage = totalPages;
		} else {
			setCurrentPage(realPage);
		}

		setStartNumbers((currentPage - 1) * perPageDisplay);
	}

	@Override
	public String toString() {
		return "Page{" +
				"totalNumbers=" + totalNumbers +
				", perPageDisplay=" + perPageDisplay +
				", startNumbers=" + startNumbers +
				", totalPages=" + totalPages +
				", currentPage=" + currentPage +
				'}';
	}
}
