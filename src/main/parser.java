package main;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.lang.String;


public class parser {  // Keeping lowercase name as per your request

    // This class gathers data from given file names/directories
    private ArrayList<String> fileNames;
    private ArrayList<String> data;
    private boolean statusParsed;

    public parser() {
        this.fileNames = new ArrayList<>();
        this.data = new ArrayList<>();
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

    public void resetParser(boolean fullReset) {
        if (fullReset) {
            this.fileNames.clear(); // Reset file names list
            this.data.clear(); // Reset data list
        }
        this.statusParsed = false;
    }
}
