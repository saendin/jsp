package co.edu.vo;
//몇 페이지, 그 페이지에 글은 몇개
public class Criteria {
	private int pageNum;
	private int postNum;
	
//	public Criteria() {
//		pageNum = 1; //첫페이지는 1로
//		postNum = 10; //페이지당 10개씩 보여주도록 하겠다
//	}
	
	//생성자
	public Criteria(int pageNum, int postNum) {
		this.pageNum = pageNum;
		this.postNum = postNum;
	}
	
	//자기자신 호출해서 값 넣어주기
	public Criteria() {
		this(1, 10); //첫페이지는 1로 페이지당 10개씩 보여주도록 하겠다
	}

	//게터세터
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	//문자열
	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", postNum=" + postNum + "]";
	}
	
	
	
	
}
