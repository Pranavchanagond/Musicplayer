package com.pranav.MusicPlayer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public Album() {
    }
    public Song findsong(String title) {
//        Song checkedSong = new Song();
//        for (int i = 0; i < songs.size(); i++) {
          for ( Song checkedSong : songs){
            if(checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
//            else return null;
        }
        return null;
    }
    public boolean addsong(String title,double duration){
        if(findsong(title)==null){
            songs.add(new Song(title,duration));
//            System.out.println("Successfully added");
            return true;
        }
        else {
            System.out.println(title + "Song already exist");
            return false;
        }
    }

    public boolean addToPlaylist(int tracknumber, LinkedList<Song> Playlist){
        int index = tracknumber-1;
        if(index > 0 && index < this.songs.size()){
            Playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("Tracknumber does not exist");
        return false;
    }

    public boolean addToPlaylist(String title,LinkedList<Song> Playlist){
        Song checkedSong = findsong(title);
        if(checkedSong == null){
            System.out.println(title+ "Song does not exist in Album");
            return false;
        }
        else Playlist.add(checkedSong); return true;
    }


}
