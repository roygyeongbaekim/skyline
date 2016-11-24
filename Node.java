package skyline;
 
public class Node {
	private int lx;
	private int rx;
	private int hx;
	private int x;
	private int h;
	
	public Node(int x, int h){	// skyline을 위한 생성자
		this.h = h;
		this.x = x;
	}
 
	public int getH() {			// skyline의 높이 값 반환
		return h;
	}

	public void setH(int h) {	// skyline의 높이 값 설정
		this.h = h;
	}

	public int getX() {			// skyline의 x 값 반환
		return x;
	}
 
	public void setX(int x) {	// skyline의 x 값 설정
		this.x = x;
	}
	
	public Node(int lx, int hx, int rx){	// 건물노드를 위한 생성자
		this.hx = hx;
		this.rx = rx;
		this.lx = lx;
	}
	
	public int getLx() {			// 건물노드의 왼쪽x값 반환
		return lx;
	}
	
	public void setLx(int lx) {		// 건물노드의 왼쪽x값 설정
		this.lx = lx;
	}
	
	public int getRx() {			// 건물노드의 오른쪽 x값 반환
		return rx;
	}
	
	public void setRx(int rx) { 	// 건물노드의 오른쪽 x값 설정
		this.rx = rx;
	}
	
	public int getHx() {	// 건물노드의 높이 값 반환
		return hx;
	}
	
	public void setHx(int hx) {	// 건물노드의 높이 값 설정
		this.hx = hx;
	}
}