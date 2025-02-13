package main;

import org.junit.Test;

import static org.junit.Assert.*;

public class parserTests {
    @Test
    public void initialTest() {
        parser test_parser = new parser();
        assertFalse(test_parser.parserStatus());
    }


}
