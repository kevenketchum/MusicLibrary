import java.util.ArrayList;

public class MusicLibrary{
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
			songs.setName(albumData.get(i - 1).get(0));
			songs.setArtist(albumDate.get(i - 1).get(1));
			//Might not even need setDate
			songs.setDate(albumDate.get(i - 1).get(3));
			String albumInfo = extractingInfo(i - 1);
			songs.setAlbumInfo(albumInfo);
			albumList.add(songs);
			
			
		}
	}
	
	private String extractingInfo(int index) {
		String extracted = "";
		for(int i = 0; i < albumData.get(index); i += 1) {
			extracted += albumData.get(index).get(i);
			extracted+= ",";
		}
		return extracted;
	}
	
	private void printSong(Song s) {
		System.out.println(s.getName(), ", "+s.getArtist()+ ", "+s.getAlbum()+".");
	}
	
	private void printAlbum(Album a) {
		System.out.println(a.getAlbumInfo());
		for(int i = 0; i < a.getSize(); i++) {
			System.out.println(a.getSongAt(i));
		}
	}
	//Required operations
	
	public void searchSongByTittle(String title) {
		for(Song s : musicLibrary) {
			if(s.getName().equals(title)) {
				printSong(s);
			}
		}

	}
	
	public void searchSongByArtist(String artist) {
		for(Song s : musicLibrary) {
			if(s.getArtist().equals(artist)) {
				printSong(s);
			}
		}
	}
	
	public void searchAlbumbyTittle(String tittle) {
		
	}
}