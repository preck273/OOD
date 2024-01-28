import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

public class Slide implements PresentationSlideProps {
	protected String title; //The title is kept separately
	protected Vector<SlideItem> items; //The SlideItems are kept in a vector

	public Slide() {
		items = new Vector<>();
	}

	public void append(SlideItem anItem) {
		items.addElement(anItem);
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String newTitle) {
		title = newTitle;
	}

	public void append(int level, String message) {
		append(new TextItem(level, message));
	}

	public SlideItem getSlideItem(int number) {
		return (SlideItem)items.elementAt(number);
	}

	public Vector<SlideItem> getSlideItems() {
		return items;
	}

	@Override
	public int getSize() {
		return items.size();
	}

	public void draw(Graphics g, Rectangle area, ImageObserver view) {
		float scale = getScale(area);
	    int y = area.y;
	    SlideItem slideItem = new TextItem(0, getTitle());
	    Style style = StyleHelperClass.getStyle(slideItem.getLevel());
	    slideItem.draw(area.x, y, scale, g, style, view);
	    y += slideItem.getBoundingBox(g, view, scale, style).height;
	    for (int number=0; number < getSize(); number++) {
	      slideItem = getSlideItems().elementAt(number);
	      style = StyleHelperClass.getStyle(slideItem.getLevel());
	      slideItem.draw(area.x, y, scale, g, style, view);
	      y += slideItem.getBoundingBox(g, view, scale, style).height;
	    }
	  }

	private float getScale(Rectangle area) {
		return Math.min(((float)area.width) / ((float) Measurement.WIDTH.getSize()), ((float)area.height) / ((float) Measurement.HEIGHT.getSize()));
	}
}
