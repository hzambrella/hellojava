package zhaogongzuo2018.practice.util;

import java.util.Comparator;
import java.util.TreeSet;

public class PraComparator {
	Integer i;
	PraComparator(Integer i){
		this.i=i;
	}
	
	public boolean equals(PraComparator p){
		System.out.println("compare");
		if (p.i==this.i){
			return true;
		}
		return false;
	}
	
	public int hashCode(){
		System.out.println("compareh");
		return this.hashCode();
	}
	
	public static class PraComparatorCmp  implements Comparator<PraComparator>{
		@Override
		public int compare(PraComparator o1, PraComparator o2) {
			System.out.println("comparator");
			if (o1.i==o2.i){
				return 0;
			}
			return o1.i>o2.i?1:-1;
		}
	}
	
	public String toString(){
		return String.valueOf(this.i);
	}
	
	public static void main(String[] args) {
		PraComparatorCmp pm=new PraComparatorCmp();
		TreeSet<PraComparator> tree=new TreeSet<PraComparator>(pm);
		PraComparator p1=new PraComparator(1);
		PraComparator p2=new PraComparator(1);
		PraComparator p3=new PraComparator(-1);
		tree.add(p1);
		System.out.println(tree.add(p2));
		tree.add(p3);
		System.out.println(tree);
	}
	
}
