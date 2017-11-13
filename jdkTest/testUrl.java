package jdkTest;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

public class testUrl {
	public static void main(String[] args) {
		try {
			URL urll = new URL("http", "www.baidu.com", "/nihao?name=我是谁&id=1");

			System.out.println(urll.toURI()+"\n"+urll.getPath()+"\n"+urll.getQuery());
			String str = java.net.URLEncoder.encode("中文", "UTF-8");
			System.out.println(java.net.URLDecoder.decode(str,"UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
