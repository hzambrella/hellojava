package chengxuyuanxiaohui;

//8皇后问题  典型的回溯法（深度优先搜索）
//皇后不能共行，问题简化，每行一个皇后。行为递归深度
public class Queen8 {
	private int max_queen = 8;
	private int[][] chess = new int[8][8];
	
	private boolean check(int x, int y) {
		for (int i = 0; i < x; i++) {
			//检查上面竖着的
			if (chess[i][y] == 1) {
				return false;
			}
			
			//检查左上斜着的
			if (x - 1 - i >= 0 && y - 1 - i >= 0) {
				if (chess[x - 1 - i][y - 1 - i] == 1) {
					return false;
				}
			}
			
			//检查右上斜着的。下面的暂时没放棋子，所有可以略去检查
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
