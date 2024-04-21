import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewMenu {
    protected static final String VIEW = "View";
    protected static final String NEXT = "Next";
    protected static final String PREV = "Prev";
    protected static final String GOTO = "Go to";
    protected static final String PAGENR = "Page number?";
    private final PresentationFrame presentationFrame;

    public ViewMenu(PresentationFrame presentationFrame) {
        this.presentationFrame = presentationFrame;

    }

    public Menu makeViewMenu() {
        Menu viewMenu = new Menu(VIEW);

        viewMenu.add(createMenuItem(NEXT, e -> nextSlide()));
        viewMenu.add(createMenuItem(PREV, e -> prevSlide()));
        viewMenu.add(createMenuItem(GOTO, e -> goToPage()));


        return viewMenu;
    }

    private void nextSlide() {
        presentationFrame.presentation.nextSlide();
        presentationFrame.frame.repaint();
    }

    private void prevSlide() {
        presentationFrame.presentation.prevSlide();
        presentationFrame.frame.repaint();
    }

    private void goToPage() {
        String pageNumberStr = JOptionPane.showInputDialog(PAGENR); // Enter page number
        try {
            int pageNumber = Integer.parseInt(pageNumberStr);
            if (pageNumber >= 1 && pageNumber <= presentationFrame.presentation.getSize()) {
                presentationFrame.presentation.setSlideNumber(pageNumber - 1);
                presentationFrame.frame.repaint();
            } else {
                showErrorMessage("Invalid page number!");
            }
        } catch (NumberFormatException e) {
            showErrorMessage("Please enter a valid page number!");
        }
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private MenuItem createMenuItem(String label, ActionListener listener) {
        MenuItem menuItem = MakeMenuItemHelper.makeMenuItem(label);
        menuItem.addActionListener(listener);
        return menuItem;
    }


}
