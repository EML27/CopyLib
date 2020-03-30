package copy_utils;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class CopyUtils {
    private static File file = new File("copy.xml");

    public static <T> T clone(T obj) {
        writeIntoXML(obj);

        return readFromXML();
    }

    private static void writeIntoXML(Object obj) {
        try {
            XMLEncoder encoder = new XMLEncoder(
                    new FileOutputStream(file));
            encoder.writeObject(obj);
            encoder.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found, bro");
        }
    }

    private static <T> T readFromXML() {
        try {

            XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));
            T res = (T) decoder.readObject();
            decoder.close();
            return res;
        } catch (FileNotFoundException e) {
            System.out.println("File not found, bro");
            throw new RuntimeException();
        }
    }
}
