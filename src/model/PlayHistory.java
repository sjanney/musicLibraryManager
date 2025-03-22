package model;

import java.util.ArrayList;

public class PlayHistory {
    private ArrayList<Song> song_stock;
    private ArrayList<Album> album_stock;
    private ArrayList<Song> recentlyPlayedList = new ArrayList<>();

    public PlayHistory(ArrayList<Song> song_stock) {
        this.recentlyPlayedList = new ArrayList<>();
    }

    public PlayHistory(ArrayList<Song> song_stock, ArrayList<Album> album_stock) {
        this.song_stock = song_stock;
        this.album_stock = album_stock;
        this.recentlyPlayedList = new ArrayList<>();
    }

    public void addPlay(Song song) {
        //keeps track of the song plays and the most recently played list
        recentlyPlayedList.remove(song);
        recentlyPlayedList.add(0, song);

        if( recentlyPlayedList.size() > 15 ) {
            recentlyPlayedList = new ArrayList<>(recentlyPlayedList.subList(0, 15));
        }
        song.incrementPlayCount();
    }

    public ArrayList<Song> getRecentlyPlayedList() {
        int resultSize = Math.min(10, recentlyPlayedList.size());
        return new ArrayList<>(recentlyPlayedList.subList(0, resultSize));
    }

    public ArrayList<Song> getMostPlayedPlayList() {
        // returns an empty list if noting has played recently
        if(song_stock == null || song_stock.isEmpty()) {
            return new ArrayList<>();
        }

        ArrayList<Song> sortedSongs = new ArrayList<>(song_stock);

        sortedSongs.sort((s1,s2) -> Integer.compare(s2.getPlayCount(), s1.getPlayCount()));

        int resultSize = Math.min(10, sortedSongs.size());
        return new ArrayList<>(sortedSongs.subList(0, resultSize));
    }

}
