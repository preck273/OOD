import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

public class SaveXmlFile extends XMLAccessor {

    public void saveFile(Presentation presentation, String filename) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            writeXmlHeader(out);
            writePresentationContent(out, presentation);
        }
    }

    private void writeXmlHeader(PrintWriter out) {
        out.println("<?xml version=\"1.0\"?>");
        out.println("<!DOCTYPE presentation SYSTEM \"jabberpoint.dtd\">");
        out.println("<presentation>");
    }

    private void writePresentationContent(PrintWriter out, Presentation presentation) {
        out.print("<showtitle>");
        out.print(presentation.getTitle());
        out.println("</showtitle>");

        for (int slideNumber = 0; slideNumber < presentation.getSize(); slideNumber++) {
            Slide slide = presentation.getSlide(slideNumber);
            writeSlide(out, slide);
        }

        out.println("</presentation>");
    }

    private void writeSlide(PrintWriter out, Slide slide) {
        out.println("<slide>");
        out.println("<title>" + slide.getTitle() + "</title>");
        Vector<SlideItem> slideItems = slide.getSlideItems();

        for (SlideItem slideItem : slideItems) {
            writeSlideItem(out, slideItem);
        }

        out.println("</slide>");
    }

    private void writeSlideItem(PrintWriter out, SlideItem slideItem) {
        out.print("<item kind=\"");

        if (slideItem instanceof TextItem) {
            out.print("text\" level=\"" + slideItem.getLevel() + "\">");
            out.print(((TextItem) slideItem).getText());
        } else if (slideItem instanceof BitmapItem) {
            out.print("image\" level=\"" + slideItem.getLevel() + "\">");
            out.print(((BitmapItem) slideItem).getName());
        } else {
            System.out.println("Ignoring " + slideItem);
            return;
        }

        out.println("</item>");
    }

}