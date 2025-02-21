import java.util.ArrayList;

public class Playlist {
	//Instance variables
	final private String name;
	private ArrayList<Album> albumList;
	private ArrayList<Song> songList;
	
	public Playlist(String name) {
		this.name = name;
	}
	
	public void addSongtoPlaylist(Song music) {
		songList.add(music);
	}
	
	public void addAlbumtoPlaylist(Album music) {
		albumList.add(music);
	}
	
	public ArrayList<Album> getAlbums(){
		return new ArrayList<Album>(albumList);
	}
	
	public ArrayList<Song> getSongs(){
		return new ArrayList<Song>(songList);
	}
	
	public String getName() {
		return name;
	}
	
	public boolean containSong(String name) {
		for(Song s : songList) {
			if(s.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
