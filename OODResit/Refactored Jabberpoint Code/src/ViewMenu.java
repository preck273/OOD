import javax.swing.*;
import java.awt.*;

public class ViewMenu {
    protected static final String VIEW = "View";
    protected static final String NEXT = "Next";
    protected static final String PREV = "Prev";
    protected static final String GOTO = "Prev";
    protected static final String PAGENR = "Page number?";
    private PresentationFrame presentationFrame;
    private MenuItem menuItem;

    public ViewMenu(PresentationFrame presentationFrame) {
        this.presentationFrame = presentationFrame;

    }

    public Menu makeViewMenu() {
        Menu viewMenu = new Menu(VIEW);

        viewMenu.add(menuItem = MakeMenuItemHelper.makeMenuItem(NEXT));
        menuItem.addActionListener(actionEvent -> presentationFrame.presentation.nextSlide()); //Next Slide

        viewMenu.add(menuItem = MakeMenuItemHelper.makeMenuItem(PREV));
        menuItem.addActionListener(actionEvent -> presentationFrame.presentation.prevSlide()); //Prev Slide

        viewMenu.add(menuItem = MakeMenuItemHelper.makeMenuItem(GOTO)); //Goto
        menuItem.addActionListener(actionEvent -> {
            String pageNumberStr = JOptionPane.showInputDialog(PAGENR);//Enter page no
            int pageNumber = Integer.parseInt(pageNumberStr);
            presentationFrame.presentation.setSlideNumber(pageNumber - 1);
        });
         return viewMenu;
    }

}
