package model;
import java.util.*;

public class musicPlayer {
    // In this class, we play songs along with keeping track of that data
    ArrayList<Song> recentlyPlayedSongs;
    ArrayList<Song> mostFrequentlyPlayedSongs;
    // For simplicity, created another hash for simply using strings in frequency count
    HashMap<Song,String> songStringNames;
    HashMap<String,Integer> frequencyCount;
    HashMap<String,Song> songHistory;

    musicPlayer() {
        this.recentlyPlayedSongs = new ArrayList<>();
        this.mostFrequentlyPlayedSongs = new ArrayList<>();
        this.songHistory = new HashMap<>();
        this.songStringNames = new HashMap<>();
        this.frequencyCount = new HashMap<>();
    }

    public ArrayList<Song> getRecentlyPlayedSongs() {
        return recentlyPlayedSongs;
    }
    public ArrayList<Song> getMostFrequentlyPlayedSongs() {
        return mostFrequentlyPlayedSongs;
    }

    private void maintainSongLists() {
        // Limit recently played songs list to last 10
        while (this.recentlyPlayedSongs.size() > 10) {
            this.recentlyPlayedSongs.remove(0);
        }

        ArrayList<Song> temp = new ArrayList<>();

        if (this.frequencyCount.size() <= 10) {
            // Just add all songs if fewer than or equal to 10 entries
            for (String key : this.frequencyCount.keySet()) {
                temp.add(this.songHistory.get(key));
            }
        } else {
            // Since we have a amount greater than 10 we have to rebuild the frequency list

            // We gather all counts and get the minimum value in the list for the top 10 elements
            ArrayList<Integer> values = new ArrayList<>(this.frequencyCount.values());
            values.sort(Integer::compareTo);
            int minVal = values.get(values.size() - 10);

            // We add all the songs that have at least the min val
            for (Map.Entry<String, Integer> entry : frequencyCount.entrySet()) {
                if (entry.getValue() >= minVal) {
                    temp.add(this.songHistory.get(entry.getKey()));
                }
            }
        }
        //We then sort the songs by their frequency themselves
        // Sort the list using the helper method
        this.mostFrequentlyPlayedSongs = compareSongs(temp);
    }

    private ArrayList<Song> compareSongs(ArrayList<Song> songs) {
        // To sort the array, we use a lamda function to make everything easier
        songs.sort((a, b) -> {
            int freqA = a.getPlayCount();
            int freqB = b.getPlayCount();
            // If they aren't equal, we return the larger of the 2
            if (freqA != freqB) {
                return freqB - freqA;
            } else { // We just compare my index
                return Integer.compare(recentlyPlayedSongs.lastIndexOf(b), recentlyPlayedSongs.lastIndexOf(a));
            }
        });
        return songs;
    }


    public void playSong(Song song) {
        // We first add it into our most recently
        song.addPlayCount();
        this.recentlyPlayedSongs.add(song);
        this.songHistory.put(song.getSongName(), song);
        // We calculate its count within our hashes
        songStringNames.put(song,song.getSongName());
        if (!this.frequencyCount.containsKey(song.getSongName())) {
            this.frequencyCount.put(song.getSongName(), 1);
        } else {
            frequencyCount.put(song.getSongName(), frequencyCount.get(song.getSongName()) + 1);
        }
        // Then we change and maintain thoses lists as necessary
        maintainSongLists();
    }

    public static void main(String args[]) {
        musicPlayer mp = new musicPlayer();
        Song test = new Song("test","test","test","test");
        Song test2 = new Song("test2","test","test","test");
        Song test3 = new Song("test3","test","test","test");
        Song test4 = new Song("test4","test","test","test");
        Song test5 = new Song("test5","test","test","test");
        Song test6 = new Song("test6","test","test","test");
        Song test7 = new Song("test7","test","test","test");
        Song test8 = new Song("test8","test","test","test");
        Song test9 = new Song("test9","test","test","test");
        Song test10 = new Song("test10","test","test","test");
        Song test11 = new Song("test11","test","test","test");
        // We play the song
        mp.playSong(test);
        mp.playSong(test);
        mp.playSong(test2);
        mp.playSong(test3);
        mp.playSong(test4);
        mp.playSong(test5);
        mp.playSong(test6);
        mp.playSong(test7);
        mp.playSong(test8);
        mp.playSong(test9);
        mp.playSong(test10);
        mp.playSong(test11);
        ArrayList<Song> songs = mp.getMostFrequentlyPlayedSongs();
        for (Song song : songs) {
            System.out.println(song.getSongName());
        }
    }

}
