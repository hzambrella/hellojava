package testAndtry;

public class TestExceptionCatch {
	//ֻ�ᵽ��һ�������catch
	public static void main(String args[] ) {
		try{
			try{
				throw new TestSelfException();
			}catch(Exception e){
				System.out.println("in catch");
			}
			
		}catch(Exception e){
			System.out.println("out catch");
		}
	}
}
