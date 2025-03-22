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
    private ArrayList<Song> song_stock;
    private PlayHistory playHistory;

    public automaticPlaylist(ArrayList<Song> song_stock) {
        this.song_stock = song_stock;
        this.playHistory = new PlayHistory(song_stock);
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

    public Playlist getMostPlayedPlayList() {
        ArrayList<Song> mostPlayed = playHistory.getMostPlayedPlayList();
        return new Playlist("Most Played", mostPlayed);
    }

    public Playlist getRecentlyPlayedList() {
        ArrayList<Song> mostPlayed = playHistory.getRecentlyPlayedList();
        return new Playlist("Recently Played", mostPlayed);
    }

    public List<Playlist> getGenrePlaylists() {
        ArrayList<Playlist> genrePlaylists = new ArrayList<>();

        ArrayList<String> genres = new ArrayList<>();
        for (Song song : song_stock) {
            String genre = song.getGenre();
            if(genre != null && !genre.isEmpty() && !genre.contains(genre)) {
                genres.add(genre);
            }
        }
        for (String genre : genres){
            ArrayList<Song> songsInGenre = new ArrayList<>();

            for (Song song : song_stock) {
                if(genre.equals(song.getGenre())) {
                    songsInGenre.add(song);
                }
            }

            if (songsInGenre.size() >= 10) {
                Playlist genrePlaylist = new Playlist("Genre Playlist", songsInGenre);
                genrePlaylists.add(genrePlaylist);
            }
        }
        return genrePlaylists;
    }

    public List<Playlist> getAllAutomaticPlaylist(){
        ArrayList<Playlist> automaticPlaylist = new ArrayList<>();

        automaticPlaylist.add(getTopRatedPlaylist());
        automaticPlaylist.add(getFavoriteSongsPlaylist());
        automaticPlaylist.add(getMostPlayedPlayList());
        automaticPlaylist.addAll(getGenrePlaylists());
        automaticPlaylist.add(getRecentlyPlayedList());




        return automaticPlaylist;

    }

}
