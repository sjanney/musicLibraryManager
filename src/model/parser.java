package model;
import java.util.*;
import java.io.*;
import java.lang.*;


public class parser {  // Keeping lowercase name as per your request

    // This class gathers data from given file names/directories
    private ArrayList<String> fileNames;
    private boolean statusParsed;

    public parser() {
        this.fileNames = new ArrayList<String>();
        ArrayList<String> data = new ArrayList<>();
        this.statusParsed = false;
    }

    public void loadFile(String fileName) {
        // Loads new file into parser
        this.fileNames.add(fileName);
    }

    public ArrayList<String> getFileNames() {
        // Getter method for fileNames
        return new ArrayList<>(this.fileNames);
    }

    public boolean parserStatus() {
        // Getter method for current parser status
        return this.statusParsed;
    }

    public void parseFiles() {
        // Implement code here
    }

    public void printFiles() {
        // Implment printing all given files
    }

    public void resetParser(boolean fullReset) {
        if (fullReset) {
            this.fileNames = new ArrayList<String>();
        }
        this.statusParsed = false;
    }
}
