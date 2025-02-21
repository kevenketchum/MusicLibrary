import java.util.ArrayList;

public class Album {
	private ArrayList<Song> songs;
	//private  String date;
	private String albumInfo;
	private final String name;
	private final String artist;
	public Album(String name, String artist) {
		songs = new ArrayList<Song>();
		//date = new String();
		albumInfo = new String();
		this.name = name;
		this.artist = artist;
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
	
	public String getArtist() {
		return artist;
	}
	
	public void addSong(Song music) {
		songs.add(music);
	}
	/*
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	*/
	
	public void setAlbumInfo(String info) {
		albumInfo = info;
	}
	
	public String getAlbumInfo() {
		return albumInfo;
	}
	
	public String getName() {
		return name;
	}
	
	public void printAlbum() {
		System.out.println(albumInfo);
		for(int i = 0; i < songs.size(); i += 1) {
			System.out.println(songs.get(i));
		}
	}

	
}
