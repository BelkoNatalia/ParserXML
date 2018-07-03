package by.htp.xml.parser.dom;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.htp.xml.entity.Child;
import by.htp.xml.entity.Families;
import by.htp.xml.entity.Family;
import by.htp.xml.entity.Father;
import by.htp.xml.entity.Mother;

public class FamilyDomParser {
	private Families currentFamilies;
	private Family currentFamily;
	private Mother currentMother;
	private Father currentFather;
	private Child currentChild;
	private ArrayList<Child> currrentChilds;

	public Families parseFamilyDoc(String path) throws ParserConfigurationException, SAXException, IOException {
		currentFamilies = new Families();
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(path);

		Element routElement = document.getDocumentElement();
		// System.out.println("1: " + routElement.getTagName());

		// Перечень(лист) семей.
		NodeList nodeList = routElement.getElementsByTagName("family");
		for (int i = 0; i < nodeList.getLength(); i++) {
			currentFamily = new Family();
			// i-я семья
			Element el = ((Element) nodeList.item(i));
			String id = el.getAttribute("id");
			currentFamily.setId(Integer.parseInt(id));
			// System.out.println("2: " + id);

			// Список членов семьи.
			NodeList nodeListMemberFamily = el.getChildNodes();
			for (int j = 0; j < nodeListMemberFamily.getLength(); j++) {
				if (nodeListMemberFamily.item(j) instanceof Element) {
					// Член семьи
					Element elMember = (Element) nodeListMemberFamily.item(j);
					String nameAtribute = elMember.getNodeName();
					// System.out.println("3: " + nameAtribute);

					switch (nameAtribute) {
					case "mother":
						currentMother = new Mother();
						String maidenName = elMember.getAttribute("maiden-name");
						currentMother.setMaidenName(maidenName);

						// System.out.println("4:" + " maiden-name " + maidenName);

						NodeList infoMother = elMember.getChildNodes();

						for (int k = 0; k < infoMother.getLength(); k++) {
							if (infoMother.item(k) instanceof Element) {
								Element elMotherItem = (Element) infoMother.item(k);
								String tegNameMotherChildNode = elMotherItem.getNodeName();
								String textContentMothersChildNodeTeg = elMotherItem.getTextContent();
								if (tegNameMotherChildNode.equals("name")) {
									currentMother.setName(textContentMothersChildNodeTeg);
								} else if (tegNameMotherChildNode.equals("surname")) {
									currentMother.setSurname(textContentMothersChildNodeTeg);
								} else if (tegNameMotherChildNode.equals("age")) {
									currentMother.setAge(Integer.parseInt(textContentMothersChildNodeTeg));
								}
								// System.out.println("5:" + tegNameMotherChildNode + " - " +
								// textContentMothersChildNodeTeg);
							}
						}
						currentFamily.setMother(currentMother);
						break;

					case "father":
						currentFather = new Father();
						NodeList infoFather = elMember.getChildNodes();

						for (int k = 0; k < infoFather.getLength(); k++) {
							if (infoFather.item(k) instanceof Element) {
								Element elFatherItem = (Element) infoFather.item(k);
								String tegNameFatherChildNode = elFatherItem.getNodeName();
								String textContentFathersChildNodeTeg = elFatherItem.getTextContent();
								if (tegNameFatherChildNode.equals("name")) {
									currentFather.setName(textContentFathersChildNodeTeg);
								} else if (tegNameFatherChildNode.equals("surname")) {
									currentFather.setSurname(textContentFathersChildNodeTeg);
								} else if (tegNameFatherChildNode.equals("age")) {
									currentFather.setAge(Integer.parseInt(textContentFathersChildNodeTeg));
								} else if (tegNameFatherChildNode.equals("military")) {
									currentFather.setMilitary(textContentFathersChildNodeTeg);
								}

								// System.out.println("6:" + tegNameFatherChildNode + " - " +
								// textContentFathersChildNodeTeg);

							}
						}
						currentFamily.setFather(currentFather);
						break;
					case "childs":
						currrentChilds = new ArrayList<>();
						NodeList nodeListChilds = elMember.getChildNodes();
						for (int c = 0; c < nodeListChilds.getLength(); c++) {
							if (nodeListChilds.item(c) instanceof Element) {
								currentChild = new Child();
								Element elChilds = (Element) nodeListChilds.item(c);
								String tegNameChilds = elChilds.getNodeName();
								// System.out.println("7:" + tegNameChilds);

								NodeList infoChild = elChilds.getChildNodes();

								for (int k = 0; k < infoChild.getLength(); k++) {
									if (infoChild.item(k) instanceof Element) {
										Element elChildItem = (Element) infoChild.item(k);
										String tegNameChildChildNode = elChildItem.getNodeName();
										String textContentChildsChildNodeTeg = elChildItem.getTextContent();
										if (tegNameChildChildNode.equals("name")) {
											currentChild.setName(textContentChildsChildNodeTeg);
										} else if (tegNameChildChildNode.equals("surname")) {
											currentChild.setSurname(textContentChildsChildNodeTeg);
										} else if (tegNameChildChildNode.equals("age")) {
											currentChild.setAge(Integer.parseInt(textContentChildsChildNodeTeg));
										}

										// System.out.println("8:" + tegNameChildChildNode + " - " +
										// textContentChildsChildNodeTeg);
									}
								}
								currrentChilds.add(currentChild);
							}

						}
						currentFamily.setChilds(currrentChilds);
						break;
					}

				}
			}
			currentFamilies.addFamily(currentFamily);

		}
		return currentFamilies;

	}

}
