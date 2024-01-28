import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class LoadXmlFile extends XMLAccessor {

    public void loadFile(Presentation presentation, String filename) {
        int slideNumber, itemNumber, max, maxItems;
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.parse(new File(filename)); //Create a JDOM document
            Element doc = document.getDocumentElement();
            presentation.setTitle(getTitle(doc, XmlTag.SHOWTITLE.getValue()));

            NodeList slides = doc.getElementsByTagName(XmlTag.SLIDE.getValue());
            max = slides.getLength();
            for (slideNumber = 0; slideNumber < max; slideNumber++) {
                Element xmlSlide = (Element) slides.item(slideNumber);
                Slide slide = new Slide();
                slide.setTitle(getTitle(xmlSlide, XmlTag.SLIDETITLE.getValue()));
                presentation.append(slide);

                NodeList slideItems = xmlSlide.getElementsByTagName(XmlTag.ITEM.getValue());
                maxItems = slideItems.getLength();
                for (itemNumber = 0; itemNumber < maxItems; itemNumber++) {
                    Element item = (Element) slideItems.item(itemNumber);
                    loadSlideItem(slide, item);
                }
            }
        }
        catch (IOException iox) {
            System.err.println(iox.toString());
        }
        catch (SAXException sax) {
            System.err.println(sax.getMessage());
        }
        catch (ParserConfigurationException pcx) {
            System.err.println(XmlException.parseError());
        }
    }
}
