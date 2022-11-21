import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


// This is the first OOPs based project of mine in Java language...
public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("Album 1" , "Alan Walker");
        album1.addSong("Song 1" , 4.5);
        album1.addSong("Song 2" , 3.6);
        album1.addSong("Song 3" , 5.6);
        album1.addSong("Song 4" , 2.6);
        album1.addSong("Song 5" , 5.0);
        album1.addSong("Song 6" , 6.6);

        LinkedList<Song> playlist = new LinkedList<>();
        album1.addToPlaylist("Song 1" , playlist);
        album1.addToPlaylist("Song 2" , playlist);
        album1.addToPlaylist("Song 3" , playlist);
        album1.addToPlaylist("Song 4" , playlist);
        album1.addToPlaylist("Song 5" , playlist);

        play(playlist);

    }


    public static void play(LinkedList<Song> playlist){
        Scanner sc = new Scanner(System.in);
        ListIterator<Song> itr = playlist.listIterator();

        if(!itr.hasNext()){
            System.out.println("The playlist is empty !!");
            return;
        }

        System.out.println("You are now listening "+itr.next());

        showMenu();

        boolean forward = true;

        while(true){
            int option = sc.nextInt();

            switch(option){
                case 1:
                    System.out.println("Thanks for listening to this album !!");
                    return;
                case 2:
                    showMenu();
                    break;
                case 3:
                    showList(playlist);
                    break;
                case 4:
                    if(!forward){
                        if(itr.hasNext())
                            itr.next();
                    }
                    if(!itr.hasNext()){
                        System.out.println("You have reached the end of the list !!");
                    }
                    else{
                        System.out.println("You are currently listening to "+itr.next());
                    }
                    forward = true;
                    break;
                case 5:
                    if(forward){
                        if(itr.hasPrevious()){
                            itr.previous();
                        }
                    }

                    if(!itr.hasPrevious()){
                        System.out.println("You have reached the start of the list");
                    }
                    else{
                        System.out.println("You are now currently listening to "+itr.previous());
                    }

                    forward = false;
                    break;

                case 6:
                    if(forward){
                        if(itr.hasPrevious()){
                            System.out.println("We are currently listening to "+itr.previous().getTitle());
                            forward = false;
                        }
                        else{
                            System.out.println("We are at the start of the list");
                        }
                    }
                    else{
                        if(itr.hasNext()){
                            System.out.println("We are currently listening to "+itr.next().getTitle());
                            forward = true;
                        }
                        else{
                            System.out.println("We are at the end of the list");
                        }
                    }
                    break;
                case 7:
                    if(playlist.size()>0){
                        itr.remove();
                        if(itr.hasNext()){
                            System.out.println("We are currently listening to "+itr.next().getTitle());
                        }
                        else{
                            if(itr.hasPrevious()){
                                System.out.println("We are currently listening to "+itr.previous().getTitle());
                            }
                        }
                    }
                    break;
            }
        }
    }


    public static void showList(LinkedList<Song> playList){
        ListIterator<Song> itr = playList.listIterator();

        while(itr.hasNext()){
            System.out.println(itr.next().getTitle());
        }
        return;
    }

    public static void showMenu(){
        System.out.println("1. Exit");
        System.out.println("2. Show the menu");
        System.out.println("3. Show list of songs");
        System.out.println("4. Next");
        System.out.println("5. Previous");
        System.out.println("6. Repeat the song");
        System.out.println("7. Delete the song  ");
    }
}