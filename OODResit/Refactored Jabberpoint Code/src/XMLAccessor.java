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
		int level = 1; // default
		NamedNodeMap attributes = item.getAttributes();
		String leveltext = attributes.getNamedItem(XmlTag.LEVEL.getValue()).getTextContent();
		if (leveltext != null) {
			try {
				level = Integer.parseInt(leveltext);
			}
			catch(NumberFormatException x) {
				System.err.println(XmlException.numberFormatError());
			}
		}
		String type = attributes.getNamedItem(XmlTag.KIND.getValue()).getTextContent();
		if (XmlTag.TEXT.getValue().equals(type)) {
			slide.append(new TextItem(level, item.getTextContent()));
		}
		else {
			if (XmlTag.IMAGE.getValue().equals(type)) {
				slide.append(new BitmapItem(level, item.getTextContent()));
			}
			else {
				System.err.println(XmlException.unknownTypeError());
			}
		}
	}

	@Override
	public void loadFile(Presentation p, String fn) throws IOException {
	}

	public void saveFile(Presentation presentation, String filename) throws IOException {
	}
}
