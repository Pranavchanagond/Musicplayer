package com.pranav.MusicPlayer;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        Album a1 = new Album("album1","martin");

        a1.addsong("a",3.50);
        a1.addsong("b",3.60);
        a1.addsong("c",3.60);
        albums.add(a1);
        a1 = new Album("album2","justin");

        a1.addsong("d",3.50);
        a1.addsong("e",3.60);
        a1.addsong("f",3.60);

        albums.add(a1);
        LinkedList<Song> p1 = new LinkedList<>();
        albums.get(0).addToPlaylist("a",p1);
        albums.get(0).addToPlaylist("b",p1);
        albums.get(1).addToPlaylist("d",p1);
        albums.get(1).addToPlaylist("f",p1);

        play(p1);


    }

    private static void play(LinkedList<Song> playlist) {
        Scanner in = new Scanner(System.in);

        boolean quit=false;
        boolean forward= true;
        boolean previous=true;
        ListIterator<Song> listIterator = playlist.listIterator();

        if(playlist.size()==0){
            System.out.println("Playlist is empty");
            printmenu();
        }
        else {
            System.out.println("Now playing"+listIterator.next());
            printmenu();
        }

        while (!quit){
            int choice = in.nextInt();

            switch (choice){
                case 0:
                    System.out.println("Quit");
                    quit=true;
                    break;
                case 1:
                        previous=true;
                        if(forward) {
                            if (listIterator.hasNext()) {
                                System.out.println("Now playing" + listIterator.next());
//                                forward = true;
                            }
                            else {
                                System.out.println("No next song");
                                forward=false;
                                printmenu();

                            }
                        }
                        break;
                case 2:
                        forward=true;
                        if (previous){
                            if(listIterator.hasPrevious()){
                                System.out.println("Now playing"+listIterator.previous());

                            }else {
                                System.out.println("We playing first song");
                                previous=false;
                            }
                        }

                        break;
                case 3:
                    if (previous){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing" + listIterator.previous());
                            previous=true;
                        }else {
                            System.out.println("We playing first song");
                        }
                    }else {
                            if (listIterator.hasNext()) {
                                System.out.println("Now playing" + listIterator.next());
                                forward = true;
                            }
                            else {
                                System.out.println("No next song");
                                printmenu();
                            }
                        }
                        break;
                case 4:
                        printlist(playlist);
                        break;

                case 5:
                        printmenu();
                        break;

                case 6:
                        if(playlist.size()>0){
                            listIterator.remove();
                           if(listIterator.hasNext()) {
                               System.out.println("Now playing"+listIterator.next());

                           }
                           else if(listIterator.hasPrevious()){
                               System.out.println("Now playing"+listIterator.previous());
                            }
                        }
                    }


            }
    }
    private static void printmenu(){
        System.out.println("Menu");
        System.out.println("0 - To quit\n"+
                            "1 - To play next song\n"+
                            "2 - To play Previous song\n"+
                            "3 - To replay the current song\n"+
                            "4 - list of All song\n"+
                            "5 - Print all available option\n"+
                            "6 - delete current song");
    }

    private static void printlist(LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("---------------------------");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("---------------------------");
    }
}
