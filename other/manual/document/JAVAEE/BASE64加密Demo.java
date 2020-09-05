import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Encoder;
class Demo
{
	public static void main(String args[])throws Exception
	{
		test();
	}
	public static void test() throws UnsupportedEncodingException
	{
		BASE64Encoder en = new BASE64Encoder();
		String s = en.encode(new String("余文朋").getBytes("utf-8"));
		System.out.println(s);
	}
}