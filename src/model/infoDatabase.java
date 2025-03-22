package model;
import java.io.FileNotFoundException;
import java.util.*;

public class infoDatabase extends musicStore {
    /*
    This class hold all necessary information that the user needs when entering songs
     */
    HashMap<String, String[]> albumInformation;
    HashMap<String, Boolean> inUserLibrary;


    public infoDatabase() {
        this.albumInformation = new HashMap<>();
        this.inUserLibrary = new HashMap<>();
    }

    public void loadDatabase() throws FileNotFoundException {
        // First we initalize our infodatabase
        this.loadInventory();
        // After this, we add to pairs to our database
        for (int i = 0; i < this.album_stock.size(); i++) {
            Album curr_album = this.album_stock.get(i);
            String key = curr_album.getTitle();
            String[] songs = this.albumInformation.get(key);
            // Place values in hashes
            this.albumInformation.put(key, songs);
            this.inUserLibrary.put(key, false);
        }
    }

    public String[] getRelatedAlbum(Song song) {
        // Get album name
        String relatedAlbum = song.getAlbumTitle();
        String[] songs = this.albumInformation.get(relatedAlbum);
        return songs;
    }

    public String[] getAlbumSongs(String albumName) {
        return albumInformation.get(albumName);
    }


    public void markAlbumInLibrary(String albumName) {
        this.inUserLibrary.put(albumName, true);
    }

    public boolean isAlbumInLibrary(String albumName) {
        return this.inUserLibrary.get(albumName);
    }

}
