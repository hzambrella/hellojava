package testAndtry;

import java.io.File;
import java.io.UnsupportedEncodingException;

public class Test
{	
	
	private static Test t1=new Test();
	private static Test t2=new Test();
	public Test(){
		System.out.println("¹þ¹þ1");
		Integer i01=59;
		int i02=59;
		Integer i03=Integer.valueOf(59);
		Integer i04=new Integer(59);
		System.out.println("====");
		System.out.println(i01==i02);
		System.out.println(i01==i03);
		System.out.println(i01==i04);//
		System.out.println(i02==i03);
		System.out.println(i02==i04);  //??ÎªÊ²Ã´ÊÇtrue
		System.out.println(i03==i04);//
		System.out.println("====");
		Boolean i=false;
		if (i=true){
			System.out.println("==true==");
		}
		System.out.println("====");
		short a = 128; byte b = (byte) a;
		System.out.println(b);
		
		
		String a2="a\\webapps\\netDisk\\testUser.yellow\\canglaoshi.avi";
		String a3=a2.replace("a", File.separator);
		System.out.println(a3);
		System.out.println(File.separator);
	}
	
	public static void  m1(){

	}
	
	public void  m2(){
		m1();
	}
	
	static{
		System.out.println("¹þ¹þ2");
	}
	
	{
		System.out.println("¹þ¹þ");
	}
	{
		System.out.println("¹þ¹þha");
	}
    public static void main(String[] args)
    {
    	Test t=new Test();
    	Test t1=t;
    	System.out.println(t1==t);
        int x = 0;
        int y = 0;
        int k = 0;
        for (int z = 0; z < 5; z++) {
            if ((++x > 2) && (++y > 2) && (k++ > 2))
            {
                x++;
                ++y;
                k++;
            }
        }
        System.out.println(x + "" +y + "" +k);
    }
}


