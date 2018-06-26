package TestCollection;

import java.util.*;

public class TestBitSet {
	public static void main(String[] args) {
		int[] l1=new int[]{1,2,4,6};//bitset第几位是1.
		int[] l2=new int[]{3,4,5,6};
		BitSet bitset1=new BitSet();
		BitSet bitset2=new BitSet();
		//101011
		for (int i=0;i<l1.length;i++){
			bitset1.set(l1[i]);
		}
		//111100
		for (int i=0;i<l2.length;i++){
			bitset2.set(l2[i]);
		}
		
		System.out.println(bitset1+"--"+bitset2);
		bitset1.xor(bitset2);//010111
		System.out.println(bitset1+"--"+bitset2);
	}
}
