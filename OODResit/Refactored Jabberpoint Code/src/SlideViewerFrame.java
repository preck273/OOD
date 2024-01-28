import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import javax.swing.JFrame;

public class SlideViewerFrame extends JFrame {
	private static final String JABTITLE = "Jabberpoint 1.6 - OU";

	public SlideViewerFrame(String title, Presentation presentation) {
		super(title);
		SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, this);
		presentation.setShowView(slideViewerComponent);
		setupWindow(slideViewerComponent, presentation);
	}

	public void setupWindow(SlideViewerComponent slideViewerComponent, Presentation presentation) {
		setTitle(JABTITLE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
		getContentPane().add(slideViewerComponent);
		addKeyListener(new KeyController(new PresentationFrame(this, presentation))); //Add a controller
		setMenuBar(new MenuController(new PresentationFrame(this, presentation)));	//Add another controller
		setSize(new Dimension(Measurement.WIDTH.getSize(), Measurement.HEIGHT.getSize())); //Same sizes a slide has
		setVisible(true);
	}
}
