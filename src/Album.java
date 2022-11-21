import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Album {
    private String name;

    private String artist;
    private ArrayList<Song> songs;

    Album(String name , String artist){
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<>();
    }

    public boolean findSong(String title){
        Iterator<Song> song  = songs.iterator();
        while(true){
            if(!song.hasNext()) return false;
            if(song.next().equals(title)){
                System.out.println("Song Found");
                return true;
            }
        }
    }

    public boolean addSong(String song , double duration){
        if(findSong(song)==true){
            System.out.println("Song already present");
            return false;
        }
        this.songs.add(new Song(song , duration));
        return true;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playlist){
        Song checkedSong;
        Iterator<Song> itr = this.songs.iterator();

        do{
            if(!itr.hasNext()){
                return false;
            }

            checkedSong = itr.next();
        }
        while (!checkedSong.getTitle().equals(title));

        playlist.add(checkedSong);
        return true;
    }

    public boolean addToPlaylist(int trackNumber , LinkedList<Song> playlist){
        int index = trackNumber-1;

        if(index>=0 && index<=this.songs.size()-1){
            playlist.add(this.songs.get(index));
            return true;
        }
        return false;
    }


}
