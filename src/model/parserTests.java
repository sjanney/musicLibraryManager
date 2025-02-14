package model;
import org.junit.Test;
import org.junit.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class parserTests {
    @Test
    public void testParserStatus() {
        parser test_parser = new parser();
        assertFalse(test_parser.parserStatus());
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


}
