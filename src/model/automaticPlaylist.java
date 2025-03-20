package model;

// This class Implement the following automatic playlists (meaning that the user doesn’t create
//these, the system provides them automatically)
 //
 //Favorite Songs (all the songs the user has marked as favorite or rated as
//5)
 //
 //Any genre for which there are at least 10 songs in the library. For
//example, if the user’s library has 15 ROCK songs, 8 COUNTRY songs,
//and 20 CLASSICAL songs, there should be playlists for ROCK and
//CLASSICAL, but not COUNTRY.
 //
 //Top Rated (all the songs rated as 4 or 5)
 //

import java.util.ArrayList;
import java.util.List;

public class automaticPlaylist {
    private ArrayList<Album> album_stock;
    private ArrayList<Song> song_stock;
    private PlayHistory playHistory;

    public automaticPlaylist(ArrayList<Album> album_stock, ArrayList<Song> song_stock) {
        this.album_stock = album_stock;
        this.song_stock = song_stock;
        this.playHistory = new PlayHistory(song_stock, album_stock);
    }

    public void recordPlay(Song song) {
        if (this.song_stock.contains(song)) playHistory.addPlay(song);
    }

    public Playlist getFavoriteSongsPlaylist() {
        ArrayList<Song> favoriteSongs = new ArrayList<>();
        for (Song song : song_stock) {
            if (song.isFavorite() || song.getRating() == Rating.FIVE) {
                favoriteSongs.add(song);
            }
        }
        return new Playlist("Favorite Songs", favoriteSongs);
    }

    public Playlist getTopRatedPlaylist() {
        ArrayList<Song> topRatedSongs = new ArrayList<>();
        for (Song song : song_stock) {
            if(song.getRating() == Rating.FIVE || song.getRating() == Rating.FOUR) {
                topRatedSongs.add(song);
            }
        }
        return new Playlist("Top Rated Songs", topRatedSongs);
    }

    public List<Playlist> getAllAutomaticPlaylist(){
        ArrayList<Playlist> automaticPlaylist = new ArrayList<>();

        automaticPlaylist.add(getTopRatedPlaylist());
        automaticPlaylist.add(getFavoriteSongsPlaylist());




        return automaticPlaylist;

    }

}
