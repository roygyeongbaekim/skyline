package skyline;

import java.util.ArrayList;
import java.util.Scanner;

public class Skyline {
	// skyline�� Ž���Ѵ�.
	public static ArrayList<Node> findSkyLine(ArrayList<Node> B, int s,int e){	// ���� ��ġ 
		if(s == e){	// ���� ��ġ�� ������ ��ġ�� ������ ���� ����
			ArrayList<Node> skyline = new ArrayList<Node>(); // ���� ������ ���� ����
			skyline.add(new Node(B.get(s).getLx(),B.get(s).getHx())); // ������ ���� x���� h���� ����
			skyline.add(new Node(B.get(e).getRx(),0));					// ������ �� ��ġ ����
			return skyline;												// �ش� ����Ʈ ��ȯ
		}
		int mid = (s + e)/2;										// �߾Ӱ��� ã�´�.
		
		ArrayList<Node> sky1 = findSkyLine(B,s,mid);				// divide ���ش�.
		ArrayList<Node> sky2 = findSkyLine(B,mid+1,e);				// divide ���ش�.
			
		return mergeSkyLine(sky1,sky2);								// �ΰ��� list�� merge ���� skyline���� ��ȯ
	}
	public static ArrayList<Node> mergeSkyLine(ArrayList<Node> sky1,ArrayList<Node> sky2){
		int ch1 = 0;		// ���� ���̰�
		int ch2 = 0;		// ������ ���̰�
		int cx = 0;			// ���� x�� ��ġ ����
		int maxH = 0;		// �ߺ��� ���Ÿ� ���� ����
		
		ArrayList<Node> result = new ArrayList<Node>();	// ����� ����
		
		while(sky1.size() > 0 && sky2.size() > 0){	// ���� ������ list �� �� ������ �����������
			if (sky1.get(0).getX() < sky2.get(0).getX()) { // ���� x���� �� ������ ���� 
				cx = sky1.get(0).getX();					// x�� ��������
				ch1 = sky1.get(0).getH();					// h�� �����´�.
				if(maxH != Math.max(ch1, ch2)){				// ���� ������ h�� max�� ���� h�� �ߺ��Ǵ��� check
					maxH = Math.max(ch1, ch2);				// �ƴ϶�� maxH�� ��ȯ ���ְ�
					result.add(new Node(cx,maxH));			// ��� ����
				}
				sky1.remove(0);								// ���ʰ����� ù��°�� ����
				
			}
			else{											// ������ x���� �� ������ ����
				cx = sky2.get(0).getX();					// x�� ��������
				ch2 = sky2.get(0).getH();					// h�� �����´�.
				if(maxH != Math.max(ch1, ch2)){				// �̰� ���� �ߺ� ���Ÿ� ���� check
					maxH = Math.max(ch1, ch2);				// �Էµ� ���̸� maxH�� ���� 
					result.add(new Node(cx,maxH));			// ��� ����
				}
				sky2.remove(0);								// ������ list���� ù��° �ε��� ����
			}
		}
		while(sky1.size() > 0){								// ���� list�� ���Ҵٸ�
			result.add(sky1.get(0));						// ���� list���� ���� node �߰�
			sky1.remove(0);									// �ش� node ����
		}
		while(sky2.size() > 0){								// ������ list�� ���Ҵٸ�
			result.add(sky2.get(0));						// ������ list���� ���� ���� �߰�
			sky2.remove(0);									// �ش� node ����
		}
		return result;										// mergesort ����� ��ȯ
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ArrayList<Node> data = new ArrayList<Node>();		// ���� �ǹ� ���� �޾ƿ��� ���� ����
		ArrayList<Node> sky_result = new ArrayList<Node>();	// skyline�� ���� ����� ����
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);	
		System.out.print("�ǹ� �� : ");
		
		int n = sc.nextInt();
		int l = 0;										// ���� x��
		int h = 0;										// ���� h��
		int r = 0;										// ������ x��
		for (int i = 0; i < n; i++) {						// ���� ��ŭ
			int num = i+1;
			System.out.println(num + "��° �ǹ� : ");
			l = sc.nextInt();
			h = sc.nextInt();
			r = sc.nextInt();
			Node tmp = new Node(l,h,r);					// Node���·� ����
			data.add(tmp);								// ��� �߰�
		}
		sky_result = findSkyLine(data,0,data.size()-1);	// skyline�� ã�´�.
		
		for (int i = 0; i < sky_result.size(); i++) {	// ����� ���
			System.out.println(sky_result.get(i).getX()+ "," + sky_result.get(i).getH());
		}
	}
 
}