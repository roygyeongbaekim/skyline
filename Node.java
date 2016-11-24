package skyline;
 
public class Node {
	private int lx;
	private int rx;
	private int hx;
	private int x;
	private int h;
	
	public Node(int x, int h){	// skyline�� ���� ������
		this.h = h;
		this.x = x;
	}
 
	public int getH() {			// skyline�� ���� �� ��ȯ
		return h;
	}

	public void setH(int h) {	// skyline�� ���� �� ����
		this.h = h;
	}

	public int getX() {			// skyline�� x �� ��ȯ
		return x;
	}
 
	public void setX(int x) {	// skyline�� x �� ����
		this.x = x;
	}
	
	public Node(int lx, int hx, int rx){	// �ǹ���带 ���� ������
		this.hx = hx;
		this.rx = rx;
		this.lx = lx;
	}
	
	public int getLx() {			// �ǹ������ ����x�� ��ȯ
		return lx;
	}
	
	public void setLx(int lx) {		// �ǹ������ ����x�� ����
		this.lx = lx;
	}
	
	public int getRx() {			// �ǹ������ ������ x�� ��ȯ
		return rx;
	}
	
	public void setRx(int rx) { 	// �ǹ������ ������ x�� ����
		this.rx = rx;
	}
	
	public int getHx() {	// �ǹ������ ���� �� ��ȯ
		return hx;
	}
	
	public void setHx(int hx) {	// �ǹ������ ���� �� ����
		this.hx = hx;
	}
}