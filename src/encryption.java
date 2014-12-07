import javax.xml.bind.ParseConversionEvent;

import config.Configurations;


public class encryption {
	public String decrypt(byte[] b)
	{
		Configurations CF = new Configurations();

		String crypKey = CF.getFfcryptkey();
		System.out.println("cryptkey er: " + crypKey);
		double gladKo = Double.parseDouble(crypKey);
		System.out.println("b er: " + b);
		System.out.println("gladKo er: " + gladKo);
		
		byte ff = (byte) gladKo;
		System.out.println("ff er: " + ff);
		for(int i = 0 ; i<b.length ; i++)
		{
			b[i] = (byte)(b[i]^ff);
		}
		String encrypted = new String(b).trim();
		System.out.println("encrypted: " + encrypted);
		return encrypted;
	}
}