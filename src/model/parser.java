package model;
import java.util.*;
import java.io.*;
import java.lang.*;


public class parser {

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


    public boolean parserStatus() {
        // Getter method for current parser status
        return this.statusParsed;
    }

    public void parseFiles() throws FileNotFoundException {
        // Implement code here
        for (int i = 0; i < this.fileNames.size(); i++) {
            File curr_file = new File(this.fileNames.get(i));
            Scanner reader = new Scanner(curr_file);
            // Here, we iterate through the first line, gathering the information

        }
        this.statusParsed = true;
    }

    public void printPendingFiles() {
        // Implement printing all given files
        String begining = "Current files: ";
        for (int i = 0; i < this.fileNames.size(); i++) {
            System.out.print(begining + this.fileNames.get(i));
        }
        System.out.println();
    }

    public void resetParser() {
            this.fileNames = new ArrayList<String>();
            this.statusParsed = false;
    }

    public void removeFile(String fileName) {
        this.fileNames.remove(fileName);
    }

    public ArrayList<String> getFiles() {
        return new ArrayList<>(this.fileNames);
    }
}
