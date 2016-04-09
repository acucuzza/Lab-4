package base;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import exceptions.DeckException;
import exceptions.HandException;
import pokerBase.Card;
import pokerBase.Deck;
import pokerBase.Hand;


public class TestPlay {

	public static void main(String[] args) throws DeckException, HandException {
	
		
		
		
		
		
		Deck d = new Deck();
		Hand h = new Hand();

		for (int a = 0; a < 5; a++) {
			h.Draw(d);
		}

		String strHand = SerializeHand(h);

		System.out.println(strHand);

		/*
		h = Hand.EvaluateHand(h);

		strHand = SerializeHand(h);

		System.out.println(strHand);
		
		Hand h2 = DeSerializeHand(strHand);
		
		strHand = SerializeHand(h2);
		System.out.println(strHand);
*/
	}

	public static String SerializeHand(Hand h) {
		StringWriter sw = new StringWriter();

		try {
			// Write it
			JAXBContext ctx = JAXBContext.newInstance(Hand.class);
			Marshaller m = ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(h, sw);
			sw.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return sw.toString();
	}

	public static Hand DeSerializeHand(String xml) {

		Hand h = null;
		try {
			JAXBContext ctx = JAXBContext.newInstance(Hand.class);
			javax.xml.bind.Unmarshaller um = ctx.createUnmarshaller();
			h = (Hand) um.unmarshal(new StringReader(xml));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return h;
	}
	
	
	
	public void TestMe() throws Exception
	{
		int a = 1;
		try
		{
			a--;
			int b = 9/a;	
		}
		catch (Exception e)
		{
			throw e;
		}
		
		
	}
}
