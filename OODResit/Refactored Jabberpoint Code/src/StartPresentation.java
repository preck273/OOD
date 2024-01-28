import java.io.IOException;

public class StartPresentation {
    public static void openPresentation(Presentation presentation) throws IOException {

        Accessor loadXmlFile = new LoadXmlFile();
        loadXmlFile.loadFile(presentation, FileMenu.TESTFILE);
    }

    public static void newPresentation(PresentationFrame presentationFrame) {
        presentationFrame.presentation.clear();
        presentationFrame.frame.repaint();
    }

    public static void savePresentation(Presentation presentation) throws IOException {
        Accessor saveXmlFile = new SaveXmlFile();
        saveXmlFile.saveFile(presentation, FileMenu.SAVEFILE);
    }
}
