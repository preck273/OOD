import java.io.IOException;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public class XMLAccessor extends Accessor {

    protected String getTitle(Element element, String tagName) {
    	NodeList titles = element.getElementsByTagName(tagName);
    	return titles.item(0).getTextContent();

    }

	protected void loadSlideItem(Slide slide, Element item) {
		int level = getAttributeValueAsInt(item, XmlTag.LEVEL.getValue(), 1);
		String type = item.getAttribute(XmlTag.KIND.getValue());
		if (XmlTag.TEXT.getValue().equals(type)) {
			slide.append(new TextItem(level, item.getTextContent()));
		} else if (XmlTag.IMAGE.getValue().equals(type)) {
			slide.append(new BitmapItem(level, item.getTextContent()));
		} else {
			System.err.println(XmlException.unknownTypeError());
		}
	}

	private int getAttributeValueAsInt(Element element, String attributeName, int defaultValue) {
		NamedNodeMap attributes = element.getAttributes();
		String attributeValue = attributes.getNamedItem(attributeName).getTextContent();
		try {
			return Integer.parseInt(attributeValue);
		} catch (NumberFormatException | NullPointerException e) {
			System.err.println(XmlException.numberFormatError());
			return defaultValue;
		} 

	}
	@Override
	public void loadFile(Presentation p, String fn) throws IOException {
	}

	public void saveFile(Presentation presentation, String filename) throws IOException {
	}
}
