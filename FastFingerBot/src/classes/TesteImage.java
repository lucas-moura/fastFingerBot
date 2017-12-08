package classes;

import java.io.File;
import net.sourceforge.tess4j.*;
public class TesteImage {

	public static void main(String[] args) {
		File imageFile = new File("images/palavras.jpg");
        Tesseract instance = Tesseract.getInstance();
        instance.setLanguage("eng");
         
        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
	}

}
