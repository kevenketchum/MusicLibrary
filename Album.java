import java.util.ArrayList;

public class Album<Song> {
	private ArrayList<Song> songs;
	private  String date;
	public Album() {
		songs = new ArrayList<Song>();
		date = new String();
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
}
