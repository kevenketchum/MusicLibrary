import java.util.ArrayList;

public class Album {
	private ArrayList<Song> songs;
	private  String date;
	private String albumInfo;
	private String name;
	private String artist;
	public Album() {
		songs = new ArrayList<Song>();
		date = new String();
		albumInfo = new String();
		name = new String();
		artist = new String();
	}
	
	public Song getSongAt(int index) {
		if(index < 0 || index >= songs.size()) {
			return null;
		}
		else {
			return songs.get(index);
		}
	}
	
	public int getSize() {
		return songs.size();
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void addSong(Song music) {
		songs.add(music);
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setAlbumInfo(String info) {
		albumInfo = info;
	}
	
	public String getAlbumInfo() {
		return albumInfo;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		
	}
	
}
