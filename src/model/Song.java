// a class that saves song information such as saong name, rating, year , album, album place- so we can make sure the albums are in order,ect...

package model;
public class Song {
    private String songName;
    private String rating;
    private String year;
    private String album;
    private String songPlaceInAlbum;

    public Song(String songName, String rating, String year, String album, String songPlaceInAlbum) {
        this.songName = songName;
        this.rating = rating;
        this.year = year;
        this.album = album;
        this.songPlaceInAlbum = songPlaceInAlbum;
    }


    public String getSongName() {
        return songName;
    }
}