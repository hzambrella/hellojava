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
	
	//��Ϣ
	static void message(){
		System.out.println("========��Ϣ======");
		String s=new String("dasasfasfdasfasdfasdfa");
		System.out.println(s.length());
		System.out.println(s.charAt(2));
		System.out.println(s.indexOf("das",4));
	}
	
	//����ת��
	static void covert(){
		System.out.println("========����ת��======");
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

	//����
	static void deal(){
		System.out.println("========����======");
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
	
	//�Ӵ�
	static void subString(){
		System.out.println("========�Ӵ�======");
		String s="hhasf���п��ĸ�����";
		System.out.println(s.substring(1));
		System.out.println(s.substring(1,5));
		System.out.println(s.subSequence(1,5));
		System.out.println(s.startsWith("hh"));
		System.out.println(s.endsWith("����"));
		
		
		String str=",";
		int n=6;
		int len=str.length();
        int m=n%len;   //0
        str+=str;   //  ,,
        System.out.println(str.substring(m,len+m));   //0  1
		
	}
	
	//�Ƚ�
	static void compare(){
		System.out.println("========�Ƚ�======");
		String s1="Abcd";
		String s2="abcd";
		System.out.println(s1.compareTo(s2));
		System.out.println(s1.compareToIgnoreCase(s2));
		System.out.println(s1.equalsIgnoreCase(s2));
	}                 
}
