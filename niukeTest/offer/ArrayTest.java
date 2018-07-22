package niukeTest.offer;


public class ArrayTest {
	public static void main(String[] args) {
		int [][] array={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		
		System.out.println(Find(7,array));
	}
    public static boolean Find(int target, int [][] array) {
 
            int len=array.length-1;
            int i=0;
            while(len>=0&&i<array[len].length){
                if (array[len][i]==target){
                    return true;
                }else if(array[len][i]<target){
                    i++;
                }else{
                    len--;
                }
            }
            return false;
        
    }
}
