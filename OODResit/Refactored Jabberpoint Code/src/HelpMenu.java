import java.awt.*;

public class HelpMenu extends MenuBar {
    private static final String ABOUT = "About";
    private static final String HELP = "Help";
    private PresentationFrame presentationFrame;
    private MenuItem menuItem;

    public HelpMenu(PresentationFrame presentationFrame) {
        this.presentationFrame = presentationFrame;
    }
    public Menu makeAboutMenu() {
        Menu helpMenu = new Menu(HELP);
        helpMenu.add(menuItem = MakeMenuItemHelper.makeMenuItem(ABOUT));
        menuItem.addActionListener(actionEvent -> AboutBox.show(presentationFrame.frame));
        setHelpMenu(helpMenu);
        return helpMenu;
    }
}
