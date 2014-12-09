package model.QOTD;

public class QOTDTest {
	
	public static void main (String [] args){
		QOTDModel qotd = new QOTDModel();
		
		qotd.updateQuote();
		
		try {
			qotd.getQuote();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}