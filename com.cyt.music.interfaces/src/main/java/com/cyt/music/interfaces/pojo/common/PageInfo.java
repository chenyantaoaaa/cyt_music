package com.cyt.music.interfaces.pojo.common;


/**
 * 分页查询参数类
 * @author chenyantao
 *
 */
public class PageInfo {

	public static final int PageInfo_pageSize_common = 30;
	
	// 当前页码
	private int PageInfo_currPage;

	// 总页数
	private int PageInfo_Psize;

	// 总记录数
	private int PageInfo_infoCount;

	// 每页显示个数
	private int PageInfo_pageSize = PageInfo_pageSize_common;
	
	// 开始坐标
	private int PageInfo_start = 0;
	
	// 结束坐标
    private int PageInfo_end = 30;

	
	public static final String PageInfo_classname = "pageinfo";
	

	/**
	 * 将分布参数传入处理，最终计算出当前页码PageInfo_currPage，开始坐标PageInfo_star，结束坐标PageInfo_end，总页数PageInfo_Psize
	 * @param infoCount 记录总数
	 * @param pageSize 每页显示个数
	 * @param currPage 当前页码
	 */
	public void setPageParams(int infoCount, int pageSize, int currPage) {
		this.PageInfo_infoCount = infoCount;
		this.PageInfo_pageSize = pageSize;
		this.PageInfo_currPage = currPage;
		
		//Psize_l 为 总数除以每页个数  得到的为非整形页数
		float Psize_l = infoCount / (float) (this.PageInfo_pageSize);
		if (PageInfo_currPage < 2) {
			//如果当前页小于2  则当前页为第一页 从第0条数据开始查找
			PageInfo_currPage = 1;
			PageInfo_start = 0;
		} else if (PageInfo_currPage > Psize_l) {
			//如果当前页面大于 页数
			if(Psize_l==0){
				//如果只有一页  那么当前页面为第一页
				PageInfo_currPage=1;
			}else{
				//如果不只一页 那么当前页面为页面数+1  
				//math.ceil(x)返回大于参数x的最小整数,即对浮点数向上取整
				PageInfo_currPage = (int) Math.ceil(Psize_l);
			}
			//查询起始位置为（当前页-1）*每页数量
			PageInfo_start = (PageInfo_currPage - 1) * this.PageInfo_pageSize;
		} else {
			PageInfo_start = (PageInfo_currPage - 1) * this.PageInfo_pageSize;
		}
		//总页数为Psize_l向上取整
		PageInfo_Psize = (int) Math.ceil(Psize_l);
		//结束位置 为当前页*每页个数
		this.PageInfo_end = PageInfo_currPage*this.PageInfo_pageSize;
	}


	public int getPageInfo_currPage() {
		return PageInfo_currPage;
	}


	public void setPageInfo_currPage(int pageInfo_currPage) {
		PageInfo_currPage = pageInfo_currPage;
	}


	public int getPageInfo_Psize() {
		return PageInfo_Psize;
	}


	public void setPageInfo_Psize(int pageInfo_Psize) {
		PageInfo_Psize = pageInfo_Psize;
	}


	public int getPageInfo_infoCount() {
		return PageInfo_infoCount;
	}


	public void setPageInfo_infoCount(int pageInfo_infoCount) {
		PageInfo_infoCount = pageInfo_infoCount;
	}


	public int getPageInfo_pageSize() {
		return PageInfo_pageSize;
	}


	public void setPageInfo_pageSize(int pageInfo_pageSize) {
		PageInfo_pageSize = pageInfo_pageSize;
	}


	public int getPageInfo_start() {
		return PageInfo_start;
	}


	public void setPageInfo_start(int pageInfo_start) {
		PageInfo_start = pageInfo_start;
	}


	public int getPageInfo_end() {
		return PageInfo_end;
	}


	public void setPageInfo_end(int pageInfo_end) {
		PageInfo_end = pageInfo_end;
	}


	public static int getPageInfoPagesizeCommon() {
		return PageInfo_pageSize_common;
	}


	public static String getPageInfoClassname() {
		return PageInfo_classname;
	}
}

