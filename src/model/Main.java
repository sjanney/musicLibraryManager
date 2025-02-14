package model;

import java.io.FileNotFoundException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        parser test_parser = new parser();
        test_parser.loadFile("test.txt");
        test_parser.parseFiles();
        System.out.println("Printed File");
    }
}