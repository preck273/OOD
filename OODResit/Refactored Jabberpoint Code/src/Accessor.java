
public abstract class Accessor implements LoadSaveXml {

	public static Accessor getDemoAccessor() {
		return new DemoPresentation();
	}

	public Accessor() {
	}


}
