package model;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class parserTests {
    @Test
    public void testParserStatus() {
        Parser test_parser = new Parser();
        assertFalse(test_parser.parserStatus());
    }

    @Test(expected = FileNotFoundException.class)
    public void noFileFound() throws FileNotFoundException {
        Parser test_parser = new Parser();
        test_parser.loadFile("noFileFound.txt");
        test_parser.parseFiles();
    }

    @Test
    public void testParserFileEntry() {
        // Testing if files are correctly loaded into the Parser
        Parser test_parser = new Parser();
        assertFalse(test_parser.parserStatus());
        test_parser.loadFile("albums/19_Adele.txt");
        test_parser.loadFile("albums/19_Adele.txt");
        test_parser.loadFile("albums/19_Adele.txt");
        // Check if files are within Parser
        ArrayList<String> check1 = new ArrayList<String>();
        check1.add("albums/19_Adele.txt");
        check1.add("albums/19_Adele.txt");
        check1.add("albums/19_Adele.txt");
        // Checking removal of files
        assertEquals(test_parser.getFiles(), check1);
        test_parser.removeFile("albums/19_Adele.txt");
        assertNotEquals(test_parser.getFiles(),check1);
        test_parser.removeFile("albums/19_Adele.txt");
        check1.remove("albums/19_Adele.txt");
        check1.remove("albums/19_Adele.txt");
        assertEquals(test_parser.getFiles(), check1);
    }
    @Test
    public void testParserFileReading() throws FileNotFoundException {
        Parser test_parser = new Parser();
        assertFalse(test_parser.parserStatus()); // Parser not ran yet, should be false
        test_parser.loadFile("albums/19_Adele.txt");
        test_parser.parseFiles();
        assertTrue(test_parser.parserStatus());
        test_parser.parseFiles(); // Should not run, since all files have already been ran

    }

    @Test
    public void testParserReset() throws FileNotFoundException {
        Parser test_parser = new Parser();
        assertFalse(test_parser.parserStatus());
        test_parser.loadFile("albums/19_Adele.txt");
        test_parser.parseFiles();
        test_parser.resetParser();
        assertFalse(test_parser.parserStatus());
    }

    @Test
    public void loadMultipleFiles() throws FileNotFoundException {
        Parser test_parser = new Parser();
        assertFalse(test_parser.parserStatus());
        test_parser.loadFile("albums/19_Adele.txt");
        test_parser.loadFile("albums/21_Adele.txt");
        test_parser.parseFiles();
        test_parser.showData();
    }

}
