package zhaogongzuo2018.practice.lang;

import java.util.Arrays;

public class TestString {
	public static void main(String[] args) {
		message();
		covert();
		deal();
		subString();
		compare();
	}
	
	//信息
	static void message(){
		System.out.println("========信息======");
		String s=new String("dasasfasfdasfasdfasdfa");
		System.out.println(s.length());
		System.out.println(s.charAt(2));
		System.out.println(s.indexOf("das",4));
	}
	
	//类型转换
	static void covert(){
		System.out.println("========类型转换======");
		String str=String.valueOf(111111);
		System.out.println(str);
		System.out.println(str.getBytes());
		System.out.println(str.toCharArray());
		
		char[]c={'a','b','c','d','e','f'};
		String s1=String.copyValueOf(c, 1, 2);
		System.out.println(s1);
		
		String str2="dasfasdfsafsa";
		char[] cc=str2.toCharArray();
		cc[2]='b';
		System.out.println(str2);
	}

	//处理
	static void deal(){
		System.out.println("========处理======");
		String s=" AbasdfCD ";
		System.out.println(s.toLowerCase());
		System.out.println(s.trim());
		System.out.println(s.replace('a','H'));
		System.out.println(s.concat("dasawdas"));
		System.out.println(s.intern()==s);
		System.out.println(String.format("%dXXXXX", 1));
		
		String s2="a,c,v,e,a";
		System.out.println(Arrays.toString(s2.split(",")));
		
	}
	
	//子串
	static void subString(){
		System.out.println("========子串======");
		String s="hhasf工行卡的付款啦";
		System.out.println(s.substring(1));
		System.out.println(s.substring(1,5));
		System.out.println(s.subSequence(1,5));
		System.out.println(s.startsWith("hh"));
		System.out.println(s.endsWith("款啦"));
		
		
		String str=",";
		int n=6;
		int len=str.length();
        int m=n%len;   //0
        str+=str;   //  ,,
        System.out.println(str.substring(m,len+m));   //0  1
		
	}
	
	//比较
	static void compare(){
		System.out.println("========比较======");
		String s1="Abcd";
		String s2="abcd";
		System.out.println(s1.compareTo(s2));
		System.out.println(s1.compareToIgnoreCase(s2));
		System.out.println(s1.equalsIgnoreCase(s2));
	}                 
}
