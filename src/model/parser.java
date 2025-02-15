package model;
import java.util.*;
import java.io.*;
import java.lang.*;


public class parser {

    // This class gathers data from given file names/directories
    private ArrayList<String> fileNames;
    private boolean statusParsed;
    private ArrayList<ArrayList<ArrayList<String>>> data;

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
        // We clear all the previous data that we had, so we can parse the new data
        this.data.clear();

        // Iterate over all file names
        for (int i = 0; i < this.fileNames.size(); i++) {
            File curr_file = new File(this.fileNames.get(i));

            // We use BufferedReader to gahter all elements from the given file
            BufferedReader reader = new BufferedReader(new FileReader(curr_file));
            try (reader) {
                // We define all the arrays that we need to hold all of our data

                // Stores [header, songs]
                ArrayList<ArrayList<String>> curr_file_lines = new ArrayList<>();
                ArrayList<String> header = new ArrayList<>();
                ArrayList<String> songs = new ArrayList<>();

                // Holds current line data
                String line_data;
                // Reset for each file, since we use it to hold the header of the file
                boolean first_line = true;
                line_data = reader.readLine();
                while (line_data != null) {
                    // we handoe the data differently if we come in contact with list
                    if (first_line) {
                        // First line is the header
                        String[] headerArray = line_data.split(",");  // Split the line into an array
                        for (int j = 0; j < headerArray.length; j++) {
                            header.add(headerArray[j]);  // Add each element to the header list
                        }
                        first_line = false;
                    } else {
                        songs.add(line_data);
                    }
                    // just chekcing statement, will remove
                    System.out.println(line_data);
                    line_data = reader.readLine();
                }

                // Store this file’s data as [header, songs]
                curr_file_lines.add(header);
                curr_file_lines.add(songs);
                this.data.add(curr_file_lines);

            } catch (IOException e) {
                System.err.println("Error: File not found or issue reading files");
            }
        }
        this.statusParsed = true;
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

    public void showData() {
        System.out.println(this.data.toString());
    }
}
