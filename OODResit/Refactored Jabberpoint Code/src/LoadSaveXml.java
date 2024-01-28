import java.io.IOException;

public interface LoadSaveXml {
   void loadFile(Presentation p, String fn) throws IOException;
   void saveFile(Presentation p, String fn) throws IOException;
}
