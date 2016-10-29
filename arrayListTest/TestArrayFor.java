package arrayListTest;

public class TestArrayFor {

	public static void main(String []args){
		double[] list={1.1,1.2, 3.3};
		//不是;，是：
		for (double x:list){
			System.out.println(x);
		}
		System.out.println("数组长度："+list.length);
	}
}
