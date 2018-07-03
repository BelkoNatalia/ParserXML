package by.htp.xml.parser.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FamilySaxHandler extends DefaultHandler {

	@Override
	public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
		// System.out.println("characters:" + newStringBuilder());
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("endDocument");
	}

	@Override
	public void endElement(String arg0, String arg1, String arg2) throws SAXException {
		System.out.println("endElement");
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("startDocument");

	}

	@Override
	public void startElement(String arg0, String arg1, String arg2, Attributes arg3) throws SAXException {
		System.out.println("startElement");
		switch (localName) {
		case "mother":
			System.out.println("*******M" + localname);
			break;
		case "father":
			System.out.println("-------F" + localname);
			break;
		}
	}

}
