import javax.xml.bind.ParseConversionEvent;

import config.Configurations;


public class encryption {
	public String decrypt(byte[] b)
	{
		Configurations CF = new Configurations();

		System.out.println(CF.getFfcryptkey());
		System.out.println("test");
		String crypKey = CF.getFfcryptkey();
		System.out.println(crypKey);
		double gladKo = Double.parseDouble(crypKey);
		byte ff = (byte) gladKo;
		for(int i = 0 ; i<b.length ; i++)
		{
			b[i] = (byte)(b[i]^ff);
		}
		String encrypted = new String(b).trim();
		return encrypted;
	}
}






//public class encryption {
//	public String decrypt(byte[] b)
//	{
//		Configurations CF = new Configurations();
//
//		System.out.println(CF.getFfcryptkey());
//		System.out.println("test");
//		String crypKey = CF.getFfcryptkey();
//		System.out.println(crypKey);
//		double gladKo = Double.parseDouble(crypKey);
//		byte ff = (byte) gladKo;
//		for(int i = 0 ; i<b.length ; i++)
//		{
//			b[i] = (byte)(b[i]^ff);
//		}
////		Generates new String without any white spaces following or leading
//		String encrypted = new String(b).trim();
////		Returns decrypted String
//		return encrypted;
//	}
//}
