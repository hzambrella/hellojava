// 字符串比较
package practice;

public class StringEmp {
	public void stringcmp() {
		String str = "Hello World";
		String str2 = "hello world";
		Object ostr = str;
		// 字符串比较,返回字符串中第一个不一样的字母ASCII的差值
		System.out.println(str.compareTo(str2));
		System.out.println(str.compareTo(ostr.toString()));
		System.out.println(str.compareToIgnoreCase(str2));
	}

	public void stringLastIndex() {
		String str3 = "hello world,hello java";

		// 查找字符串最后一次出现的位置
		int lastIndex = str3.lastIndexOf("hello");
		if (lastIndex == -1) {
			System.out.println("not found");
		} else {
			System.out.println("last string index is :" + lastIndex);
		}
	}

	// 删除字符串中的字母
	public void stringdelete() {
		String str = "www.baidu.com";
		System.out.println(removeString(str, 3));
	}

	// substring() 方法返回字符串的子字符串。
	public static String removeString(String str, int pos) {
		// 不包括pos
		return str.substring(0, pos) + str.substring(pos + 1);
	}
	// 字符串变为字符数组：str.toCharArray(),程序略
	// 整个字符串改为小写： Str.toLowerCase()，程序略
	// toUpperCase() 方法将字符串小写字符转换为大写。
	// toString() 方法返回此对象本身（它已经是一个字符串）。
	
	public static void strTrim(){
		String str="  www.baidu.com   ";
		System.out.println("删除前："+str+"删除后");
	}
	public static void main(String[] args) {
		// test
		StringEmp ss = new StringEmp();
		ss.stringcmp();
		ss.stringLastIndex();
	}
}
