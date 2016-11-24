package skyline;

import java.util.ArrayList;
import java.util.Scanner;

public class Skyline {
	// skyline을 탐색한다.
	public static ArrayList<Node> findSkyLine(ArrayList<Node> B, int s,int e){	// 시작 위치 
		if(s == e){	// 시작 위치와 마지막 위치가 같으면 정보 저장
			ArrayList<Node> skyline = new ArrayList<Node>(); // 정보 저장을 위한 선언
			skyline.add(new Node(B.get(s).getLx(),B.get(s).getHx())); // 시작점 왼쪽 x값과 h값을 저장
			skyline.add(new Node(B.get(e).getRx(),0));					// 마지막 끝 위치 저장
			return skyline;												// 해당 리스트 반환
		}
		int mid = (s + e)/2;										// 중앙값을 찾는다.
		
		ArrayList<Node> sky1 = findSkyLine(B,s,mid);				// divide 해준다.
		ArrayList<Node> sky2 = findSkyLine(B,mid+1,e);				// divide 해준다.
			
		return mergeSkyLine(sky1,sky2);								// 두개의 list를 merge 해준 skyline정보 반환
	}
	public static ArrayList<Node> mergeSkyLine(ArrayList<Node> sky1,ArrayList<Node> sky2){
		int ch1 = 0;		// 왼쪽 높이값
		int ch2 = 0;		// 오른쪽 높이값
		int cx = 0;			// 현재 x값 위치 지정
		int maxH = 0;		// 중복값 제거를 위한 변수
		
		ArrayList<Node> result = new ArrayList<Node>();	// 결과값 저장
		
		while(sky1.size() > 0 && sky2.size() > 0){	// 왼쪽 오른쪽 list 둘 중 한쪽이 사라질때까지
			if (sky1.get(0).getX() < sky2.get(0).getX()) { // 왼쪽 x값이 더 작으면 먼저 
				cx = sky1.get(0).getX();					// x값 가져오고
				ch1 = sky1.get(0).getH();					// h값 가져온다.
				if(maxH != Math.max(ch1, ch2)){				// 왼쪽 오른쪽 h의 max가 이전 h와 중복되는지 check
					maxH = Math.max(ch1, ch2);				// 아니라면 maxH를 변환 해주고
					result.add(new Node(cx,maxH));			// 결과 저장
				}
				sky1.remove(0);								// 왼쪽값에서 첫번째꺼 삭제
				
			}
			else{											// 오른쪽 x값이 더 작으면 먼저
				cx = sky2.get(0).getX();					// x값 가져오고
				ch2 = sky2.get(0).getH();					// h값 가져온다.
				if(maxH != Math.max(ch1, ch2)){				// 이것 또한 중복 제거를 위한 check
					maxH = Math.max(ch1, ch2);				// 입력된 높이를 maxH로 지정 
					result.add(new Node(cx,maxH));			// 결과 저장
				}
				sky2.remove(0);								// 오른쪽 list에서 첫번째 인덱스 삭제
			}
		}
		while(sky1.size() > 0){								// 왼쪽 list가 남았다면
			result.add(sky1.get(0));						// 왼쪽 list에서 남은 node 추가
			sky1.remove(0);									// 해당 node 삭제
		}
		while(sky2.size() > 0){								// 오른쪽 list가 남았다면
			result.add(sky2.get(0));						// 오른쪽 list에서 남은 정보 추가
			sky2.remove(0);									// 해당 node 삭제
		}
		return result;										// mergesort 결과값 반환
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ArrayList<Node> data = new ArrayList<Node>();		// 최초 건물 정보 받아오기 위한 변수
		ArrayList<Node> sky_result = new ArrayList<Node>();	// skyline을 구한 결과값 저장
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);	
		System.out.print("건물 수 : ");
		
		int n = sc.nextInt();
		int l = 0;										// 왼쪽 x값
		int h = 0;										// 높이 h값
		int r = 0;										// 오른쪽 x값
		for (int i = 0; i < n; i++) {						// 갯수 만큼
			int num = i+1;
			System.out.println(num + "번째 건물 : ");
			l = sc.nextInt();
			h = sc.nextInt();
			r = sc.nextInt();
			Node tmp = new Node(l,h,r);					// Node형태로 저장
			data.add(tmp);								// 노드 추가
		}
		sky_result = findSkyLine(data,0,data.size()-1);	// skyline을 찾는다.
		
		for (int i = 0; i < sky_result.size(); i++) {	// 결과값 출력
			System.out.println(sky_result.get(i).getX()+ "," + sky_result.get(i).getH());
		}
	}
 
}