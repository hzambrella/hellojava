// �ַ����Ƚ�
package practice;

public class StringEmp {
	public void stringcmp() {
		String str = "Hello World";
		String str2 = "hello world";
		Object ostr = str;
		// �ַ����Ƚ�,�����ַ����е�һ����һ������ĸASCII�Ĳ�ֵ
		System.out.println(str.compareTo(str2));
		System.out.println(str.compareTo(ostr.toString()));
		System.out.println(str.compareToIgnoreCase(str2));
	}

	public void stringLastIndex() {
		String str3 = "hello world,hello java";

		// �����ַ������һ�γ��ֵ�λ��
		int lastIndex = str3.lastIndexOf("hello");
		if (lastIndex == -1) {
			System.out.println("not found");
		} else {
			System.out.println("last string index is :" + lastIndex);
		}
	}

	// ɾ���ַ����е���ĸ
	public void stringdelete() {
		String str = "www.baidu.com";
		System.out.println(removeString(str, 3));
	}

	// substring() ���������ַ��������ַ�����
	public static String removeString(String str, int pos) {
		// ������pos
		return str.substring(0, pos) + str.substring(pos + 1);
	}
	// �ַ�����Ϊ�ַ����飺str.toCharArray(),������
	// �����ַ�����ΪСд�� Str.toLowerCase()��������
	// toUpperCase() �������ַ���Сд�ַ�ת��Ϊ��д��
	// toString() �������ش˶��������Ѿ���һ���ַ�������
	
	public static void strTrim(){
		String str="  www.baidu.com   ";
		System.out.println("ɾ��ǰ��"+str+"ɾ����");
	}
	public static void main(String[] args) {
		// test
		StringEmp ss = new StringEmp();
		ss.stringcmp();
		ss.stringLastIndex();
	}
}
