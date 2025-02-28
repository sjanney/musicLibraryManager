package model;

import java.io.FileNotFoundException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Parser test_parser = new Parser();
        test_parser.loadFile("albums/19_adele");
        test_parser.parseFiles();
        DataConverter converter = new DataConverter(test_parser);
        converter.convertData();
    }
}