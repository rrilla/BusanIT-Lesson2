package vo;

public class PageMaker {	//페이징을 위해 필요한 클래스
	private int pageSize = 10;	//페이지당 레코드수
	private int startPage;		//블록의 시작 페이지
	private int endPage;		//블록의 마지막 페이지
	private int currentPage = 1;//현재 페이지
	private int start;  		//페이지의 시작 레코드
	private int end;			//페이지의 끝 레코드
	private int totalCount;		//전체 레코드 수
	private boolean prev;		//이전 블록
	private boolean next;		//다음 블록
	
	public PageMaker(int currentPage, int totalCount) {
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		
		start=(currentPage-1)*pageSize;
		end = start+(pageSize-1);	//-1지우면 
		endPage = (int)(Math.ceil(currentPage/(double)pageSize))*pageSize;
		startPage = (endPage-pageSize) + 1;
		int totalPage=(int)(Math.ceil(totalCount/(double)pageSize));
		if(endPage > totalPage) endPage = totalPage;
		
		prev = startPage == 1?false:true;
		next = endPage == totalPage?false:true;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}
	
	
}
