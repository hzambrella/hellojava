package zhaogongzuo2018.practice.util;

import java.util.BitSet;

public class TestBItSet {
	public static void main(String[] args) {
		BitSet bit=new BitSet();
		bit.set(1,true);
		bit.set(10,true);
		bit.get(1);
		bit.toString();
		System.out.println(bit);
		System.out.println(Math.sin(Math.PI/6));
		
		char[] s1=new char[]{'a'};
		char[] s2=new char[]{'.','*'};
		System.out.println(match(s1,s2));
	}
	
    public static boolean match(char[] str, char[] pattern){
        return ma(str,0,pattern,0);
    }
	
   static boolean ma(char[] str,int p1, char[] pattern,int p2){
        //两个都结束了，就返回true
        if (p1>str.length-1&&p2>pattern.length-1){
            return true;
        }
        
        //匹配串还没结束，但是模式串已经没了
        //if (p1<=str.length-1&&p2>pattern.length-1){

        if (p1!=str.length-1&&p2>pattern.length-1){
            return false;
        }
        
        //注意是p2+1
        if(p2<pattern.length-1&&pattern[p2+1]=='*'){
            //匹配串已经结束了。但是模式串还没结束，且为"X*XX"。
            if (p1>str.length-1){
                //return true; 直接return true 是不对的 ，比如""和.*a"
                return ma(str,p1,pattern,p2+2);//+2是因为直接抛弃".*"两个字符
            }else{
                if(str[p1]==pattern[p2]||pattern[p2]=='.'){
                    return ma(str,p1,pattern,p2+2)||ma(str,p1+1,pattern,p2+2)||ma(str,p1+1,pattern,p2);
                }else{
                    return ma(str,p1,pattern,p2+2);
                }
            }
        }
        

        //匹配串已经结束了。但是模式串还没结束，且不为"X*XX"。
        if (p2<=pattern.length-1){
            if (p1>str.length-1){
                return false;
            }else if(str[p1]==pattern[p2]||pattern[p2]=='.'){
                return ma(str,p1++,pattern,p2++);
            }
        }

        
        return false;
    }
}	
