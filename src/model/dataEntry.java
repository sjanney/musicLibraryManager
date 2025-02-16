package model;

import java.util.ArrayList;

public class dataEntry {
    // This class manipulates the parsed data, making it easier to input into database
    // Convert possibly to files? May or may not use
    private ArrayList<ArrayList<String>> file_data;

    public dataEntry(ArrayList<ArrayList<String>> data, String conversionType) {
        this.file_data = data;
    }
}
