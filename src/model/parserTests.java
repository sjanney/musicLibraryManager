package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class parserTests {
    @Test
    public void testParserStatus() {
        parser test_parser = new parser();
        assertFalse(test_parser.parserStatus());
    }


}
