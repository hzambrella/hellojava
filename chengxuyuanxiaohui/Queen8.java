package chengxuyuanxiaohui;

//8�ʺ�����  ���͵Ļ��ݷ����������������
//�ʺ��ܹ��У�����򻯣�ÿ��һ���ʺ���Ϊ�ݹ����
public class Queen8 {
	private int max_queen = 8;
	private int[][] chess = new int[8][8];
	
	private boolean check(int x, int y) {
		for (int i = 0; i < x; i++) {
			//����������ŵ�
			if (chess[i][y] == 1) {
				return false;
			}
			
			//�������б�ŵ�
			if (x - 1 - i >= 0 && y - 1 - i >= 0) {
				if (chess[x - 1 - i][y - 1 - i] == 1) {
					return false;
				}
			}
			
			//�������б�ŵġ��������ʱû�����ӣ����п�����ȥ���
			if (y + 1 + i < 8 && x - 1 - i >= 0) {
				if (chess[x - 1 - i][y + 1 + i] == 1) {
					return false;
				}
			}
		}
		return true;
	}

/*	private boolean checkResult(int x,int y){
		for (int i=0;i<8;i++){
			
		}
		
		return true;
	}*/
	
	private boolean search(int x) {
		if (x>=max_queen){
			return true;
		}
				
		for (int i = 0; i < 8; i++) {
			
			for (int j=0;j<8;j++){
				chess[x][j]=0;
			}
						
			if (check(x,i)){
				chess[x][i]=1;
				if (search(x + 1)) {
					return true;
				}
			}	
		}
		return false;
	}

	public void printResult() {
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess.length; j++) {
				System.out.print(chess[i][j]);
			}
			System.out.print("\n");
		}

	}

	public static void main(String[] args) {
		Queen8 q = new Queen8();
		q.search(0);
		q.printResult();

	}
}
