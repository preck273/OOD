import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FileMenu {
    private static final String FILE = "File";
    private static final String OPEN = "Open";
    private static final String NEW = "New";
    private static final String SAVE = "Save";
    private static final String EXIT = "Exit";
    protected static final String TESTFILE = "testPresentation.xml";
    protected static final String SAVEFILE = "savedPresentation.xml";

    private PresentationFrame presentationFrame;

    public FileMenu(PresentationFrame presentationFrame) {
        this.presentationFrame = presentationFrame;
    }

    public Menu makeFileMenu() {
        Menu fileMenu = new Menu(FILE);

        // Open menu item
        fileMenu.add(createMenuItem(OPEN, e -> openPresentation()));

        // New menu item
        fileMenu.add(createMenuItem(NEW, e -> newPresentation()));

        // Save menu item
        fileMenu.add(createMenuItem(SAVE, e -> savePresentation()));

        // Exit menu item
        fileMenu.add(createMenuItem(EXIT, e -> exitPresentation()));

        return fileMenu;
    }

    private MenuItem createMenuItem(String label, ActionListener listener) {
        MenuItem menuItem = MakeMenuItemHelper.makeMenuItem(label);
        menuItem.addActionListener(listener);
        return menuItem;
    }

    private void openPresentation() {
        presentationFrame.presentation.clear();
        try {
            PresentationHandler.openPresentation(presentationFrame.presentation);
            presentationFrame.presentation.setSlideNumber(0);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(presentationFrame.frame, MenuControllerException.iOException() + exc, MenuControllerException.loadErrorException(), JOptionPane.ERROR_MESSAGE);
        }
        presentationFrame.frame.repaint();
    }

    private void newPresentation() {
        PresentationHandler.newPresentation(presentationFrame);
    }

    private void savePresentation() {
        try {
            PresentationHandler.savePresentation(presentationFrame.presentation);
        } catch (IOException exc) {
            JOptionPane.showMessageDialog(presentationFrame.frame, MenuControllerException.iOException() + exc, MenuControllerException.saveErrorException(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exitPresentation() {
        presentationFrame.presentation.exit(0);
    }

}
