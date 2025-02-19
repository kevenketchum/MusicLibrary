import java.util.ArrayList;

public class MusicLibrary<Song>{
	//Instance variables
	private ArrayList<Song> musicLibrary;
	private ArrayList<Album> albumList;
	private ArrayList<Song> playlist;
	
	//Initializer
	public MusicLibrary() {
		//Creates arrayList where all Songs will be stored
		musicLibrary = new ArrayList<Song>();
		playlist = new ArrayList<Song>();
		albumList = new ArrayList<Album>();
		for(int i = 1; i < albumData.size(); i += 2) {
			Album songs = new Album();
			for(int j = 0; j < albumData.get(i).size(); j+= 1) {
				Song music = new Song(albumData.get(i).get(j), albumData.get(i - 1).get(0), albumData.get(i - 1).get(1));
				musicLibrary.add(music);
				songs.addSong(music);
			}
			songs.setDate(albumDate.get(i - 1).get(3));
			albumList.add(songs);
		}
	}
	
	
	//Required operations
	
	public void searchSongByTittle(String title) {

	}
	
	public void searchSongByArtist(String artist) {
		
	}
	
	public void searchAlbumbyTittle(String tittle) {
		
	}
}