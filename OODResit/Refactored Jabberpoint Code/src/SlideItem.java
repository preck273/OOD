import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

public abstract class SlideItem {
	private int level; //The level of the SlideItem

	public SlideItem(int lev) {
		level = lev;
	}

//Returns the level
	public int getLevel() {
		return level;
	}

//Returns the bounding box
	public abstract Rectangle getBoundingBox(Graphics g,
			ImageObserver observer, float scale, Style style);

//Draws the item
	public abstract void draw(int x, int y, float scale,
			Graphics g, Style style, ImageObserver observer);
}
