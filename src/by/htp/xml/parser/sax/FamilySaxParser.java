package by.htp.xml.parser.sax;

import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.htp.xml.entity.Families;

public class FamilySaxParser {
	public Families parseFamilyDoc(String path) {

		try {
			XMLReader reader = new XMLReaderFactory.createXMLReader();
			reader.parse(path);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
