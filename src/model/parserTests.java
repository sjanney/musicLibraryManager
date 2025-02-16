package model;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.util.*;

import static org.junit.Assert.*;

public class parserTests {
    @Test
    public void testParserStatus() {
        parser test_parser = new parser();
        assertFalse(test_parser.parserStatus());
    }

    @Test(expected = FileNotFoundException.class)
    public void noFileFound() throws FileNotFoundException {
        parser test_parser = new parser();
        test_parser.loadFile("noFileFound.txt");
        test_parser.parseFiles();
    }

    @Test
    public void testParserFileEntry() {
        // Testing if files are correctly loaded into the parser
        parser test_parser = new parser();
        assertFalse(test_parser.parserStatus());
        test_parser.loadFile("test1.txt");
        test_parser.loadFile("test2.txt");
        test_parser.loadFile("test3.txt");
        // Check if files are within parser
        ArrayList<String> check1 = new ArrayList<String>();
        check1.add("test1.txt");
        check1.add("test2.txt");
        check1.add("test3.txt");
        // Checking removal of files
        assertEquals(test_parser.getFiles(), check1);
        test_parser.removeFile("test1.txt");
        assertNotEquals(test_parser.getFiles(),check1);
        test_parser.removeFile("test2.txt");
        check1.remove("test2.txt");
        check1.remove("test1.txt");
        assertEquals(test_parser.getFiles(), check1);
    }
    @Test
    public void testParserFileReading() throws FileNotFoundException {
        parser test_parser = new parser();
        assertFalse(test_parser.parserStatus()); // parser not ran yet, should be false
        test_parser.loadFile("test.txt");
        test_parser.parseFiles();
        assertTrue(test_parser.parserStatus());
        test_parser.parseFiles(); // Should not run, since all files have already been ran

    }

    @Test
    public void testParserReset() throws FileNotFoundException {
        parser test_parser = new parser();
        assertFalse(test_parser.parserStatus());
        test_parser.loadFile("test.txt");
        test_parser.parseFiles();
        test_parser.resetParser();
        assertFalse(test_parser.parserStatus());
    }

    @Test
    public void loadMultipleFiles() throws FileNotFoundException {
        parser test_parser = new parser();
        assertFalse(test_parser.parserStatus());
        test_parser.loadFile("test.txt");
        test_parser.loadFile("albums/19_Adele.txt");
        test_parser.loadFile("albums/21_Adele.txt");
        test_parser.parseFiles();
        test_parser.showData();
    }

}
