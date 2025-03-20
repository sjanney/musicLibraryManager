package model.tests;
import model.DataConverter;
import model.Parser;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;
public class DataConverterTest {

    @Test
    public void intialTest() {
        Parser parser = new Parser();
        DataConverter data = new DataConverter(parser);
        assertNotNull(data);
    }

    @Test
    public void convertDataTest() throws FileNotFoundException {
        Parser parser = new Parser();
        parser.loadFile("src/albums/19_Adele.txt");
        parser.loadFile("src/albums/21_Adele.txt");
        parser.parseFiles();
        DataConverter data = new DataConverter(parser);
        data.convertData();
        assertNotNull(data.sendData());
        assertEquals(data.sendData().size(), 2);

    }

    @Test
    public void showAlbum() throws FileNotFoundException {
        Parser parser = new Parser();
        parser.loadFile("src/albums/19_Adele.txt");
        parser.loadFile("src/albums/21_Adele.txt");
        parser.parseFiles();
        DataConverter data = new DataConverter(parser);
        data.convertData();
        assertNotNull(data.sendData());
        data.showAlbums();

    }
}
