package model;
import java.util.*;
import java.io.*;
import java.lang.*;


public class parser {

    // This class gathers data from given file names/directories
    private ArrayList<String> fileNames;
    private boolean statusParsed;
    private ArrayList<String> data;

    public parser() {
        this.fileNames = new ArrayList<String>();
        this.data = new ArrayList<>();
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
        ArrayList<String> data = new ArrayList<>();
        // Iterate over all file names
        for (int i = 0; i < this.fileNames.size(); i++) {
            File curr_file = new File(this.fileNames.get(i));

            // We use the try-catch block to catch errosr when file is not found
            try (BufferedReader reader = new BufferedReader(new FileReader(curr_file))) {
                String line_data;
                boolean first = true;
                while ( (line_data = reader.readLine()) != null) {
                    if (first) {
                        // need to find good format to place code within given file
                    }
                    // Debugging code
                    System.out.println(line_data);
                    data.add(line_data); // where we add the data to our temp array
                }
            } catch (IOException e) { // Handles both FileNotFoundException and IOException, based on documentation of BufferReader????
                System.err.println("Error: File not found or issue reading - " + this.fileNames.get(i));
            }
        }
        this.statusParsed = true;
        this.data = data;
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
