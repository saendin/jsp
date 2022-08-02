package co.edu.vo;

//페이지를 넘길 수 있도록 구현하기 위한 페이지VO클래스
public class Page {
	private int startPage; // 첫번째
	private int endPage;
	private boolean prev;
	private boolean next;
	// 전체 건수를 알아야 하므로
	private int total;
	private Criteria cri;

	//생성자의 매개값으로 들어온 넘들을 가지고 계산하려고 ㅋㅋ
	public Page(Criteria cri, int total) { //페이지정보와 total페이지를 넘겨주면 계산해서 보여주게끔 하는,,
		this.cri = cri;
		this.total = total;
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))* 10;//게시물이 175건일 때:최대값이 11 ~ 17 ~ 20
		this.startPage = this.endPage - 9;
		int realEnd = (int)(Math.ceil(total*1.0/cri.getPostNum()));//175/10=>18 page
		
		if(this.endPage > realEnd)
			this.endPage = realEnd;
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
}
