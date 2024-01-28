import java.awt.*;

public final class StyleHelperClass {
    private static Style[] styles;

    public static void createStyles() {
        styles = new Style[5];
        styles[0] = new Style(0, Color.red,   48, 20);	// style voor item-level 0
        styles[1] = new Style(20, Color.blue,  40, 10);	// style voor item-level 1
        styles[2] = new Style(50, Color.black, 36, 10);	// style voor item-level 2
        styles[3] = new Style(70, Color.black, 30, 10);	// style voor item-level 3
        styles[4] = new Style(90, Color.black, 24, 10);	// style voor item-level 4

    }

    public static Style getStyle(int level) {
        if (level >= styles.length) {
            level = styles.length - 1;
        }
        return styles[level];
    }
}
