package TestJavaLang;

public class TestString {
	static String str=new String("dasdfasfgwerqgadasfas sdafasdfa:1!DFas123");
	public static void main(String[] args) {
		System.out.println(str.codePointAt(0));
		System.out.println(new String("fdas").concat(new String("!")));
		System.out.println(new String("fdas").contains("fd"));
		System.out.println(new String("fdas").indexOf('a'));
		System.out.println(str.substring(1, 4));
		System.out.println(new String(" 312- 123 123   ").trim());
	}
}
