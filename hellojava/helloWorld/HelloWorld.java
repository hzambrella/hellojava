// hello world
package hellojava.helloWorld;
// package heloworld
import hellojava.arrayUtils.*;
public class HelloWorld {

	public static void main(String []args){
		//public static void main(string []args)
		int[] array={1,5,6,7,1,6,8,2,3,9,2};
		Arrayutils.printArray(array);
		System.out.println("hello world");
		for(int i=0;i<args.length;i++){
			System.out.println(i);
		}
	}
}
