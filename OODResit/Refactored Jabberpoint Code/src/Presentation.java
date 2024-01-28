import java.util.ArrayList;

public class Presentation implements PresentationSlideProps {
	private String showTitle;
	private ArrayList<Slide> showList;
	private int currentSlideNumber = 0;
	private SlideViewerComponent slideViewComponent;

	public Presentation() {
		this.showList = new ArrayList<>();
		slideViewComponent = null;
		clear();
	}

	public int getSize() {
		return showList.size();
	}

	public String getTitle() {
		return showTitle;
	}

	public void setTitle(String nt) {
		showTitle = nt;
	}

	public void setShowView(SlideViewerComponent slideViewerComponent) {
		this.slideViewComponent = slideViewerComponent;
	}

	public int getSlideNumber() {
		return currentSlideNumber;
	}

	public void setSlideNumber(int number) {
		currentSlideNumber = number;
		if (slideViewComponent != null) {
			slideViewComponent.update(this, getCurrentSlide());
		}
	}

	public void prevSlide() {
		if (currentSlideNumber > 0) {
			setSlideNumber(currentSlideNumber - 1);
		}
	}

	public void nextSlide() {
		if (currentSlideNumber < (showList.size()-1)) {
			setSlideNumber(currentSlideNumber + 1);
		}
	}

	void clear() {
		showList = new ArrayList<>();
		setSlideNumber(-1);
	}

	public void append(Slide slide) {
		showList.add(slide);
	}

	public Slide getSlide(int number) {
		if (number < 0 || number >= getSize()){
			return null;
		}
		return showList.get(number);
	}

	public Slide getCurrentSlide() {
		return getSlide(currentSlideNumber);
	}

	public void exit(int n) {
		System.exit(n);
	}
}
