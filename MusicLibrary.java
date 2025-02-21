import java.util.ArrayList;

public class MusicLibrary{
	//Instance variables
	private ArrayList<Song> musicLibrary;
	private ArrayList<Album> albumList;
	private ArrayList<Playlist> allPlaylist;
	
	//Initializer
	public MusicLibrary() {
		//Creates arrayList where all Songs will be stored
		musicLibrary = new ArrayList<Song>();
		allPlaylist = new ArrayList<Playlist>();
		albumList = new ArrayList<Album>();
		for(int i = 1; i < albumData.size(); i += 2) {
			String albumName = albumData.get(i - 1).get(0);
			String albumArtist = albumDate.get(i - 1).get(1);
			//String albumDate = albumData.get(i - 1).get(1);
			Album songs = new Album(albumName, albumArtist);
			for(int j = 0; j < albumData.get(i).size(); j+= 1) {
				Song music = new Song(albumData.get(i).get(j), albumData.get(i - 1).get(0), albumData.get(i - 1).get(1));
				musicLibrary.add(music);
				songs.addSong(music);
			}
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
		s.printSong();
	}
	
	private void printAlbum(Album a) {
		a.printAlbum();
	}
	//Search and print info for an Album or a Song
	
	public void searchSongByTittle(String title) {
		boolean found= true;
		for(Song s : musicLibrary) {
			if(s.getName().equals(title)) {
				found = false;
				printSong(s);
			}
		}
		if(found) {
			System.out.println("Song: "+title+" not found on music Library.");
		}
		

	}
	
	public void searchSongByArtist(String artist) {
		boolean found = true;
		for(Song s : musicLibrary) {
			if(s.getAuthor().equals(artist)) {
				found = false;
				printSong(s);
			}
		}
		if(found) {
			System.out.println("Artist: "+artist+" not found on music Library.");		}
	}
	
	public void searchAlbumbyTittle(String title) {
		boolean found = true;
		for(Album a : albumList) {
			if(a.getName().equals(title)) {
				found = false;
				printAlbum(a);
			}
		}
		if(found) {
			System.out.println("Album: "+title+" not found on music Library.");		}
	}
	
	public void searchAlbumByArtist(String artist) {
		boolean found = true;
		for(Album a : albumList) {
			if(a.getArtist().equals(artist)) {
				found = false;
				printAlbum(a);
			}
		}
		if(found) {
			System.out.println("Artist: "+artist+" not found on music Library.");
		}
	}
	
	//Add songs or albums into library
	public void addSongToLibrary(String title) {
		boolean found = true;
		for(Song a : musicLibrary) {
			if(a.getName().equals(title)) {
				found = false;
				a.addToLibrary();
			}
		}
		System.out.println("Song "+title+" not found on Music Store");
	}
	
	public void addAlbumToLibrary(String title) {
		boolean found = true;
		for(Album a : albumList) {
			if(a.getName().equals(title)) {
				a.addToLibrary();
			}
		}
		if(found) {
			System.out.println("Album "+title+" not found on Music Store");
		}
	}

	//Print information on user Library
	public void searchLibrarySongByTittle(String title) {
		boolean found= true;
		for(Song s : musicLibrary) {
			if(s.getName().equals(title) && s.inLibrary()) {
				found = false;
				printSong(s);
			}
		}
		if(found) {
			System.out.println("Song: "+title+" not found on personal Library.");
		}
		

	}
	
	public void searchLibrarySongByArtist(String artist) {
		boolean found = true;
		for(Song s : musicLibrary) {
			if(s.getAuthor().equals(artist) && s.inLibrary()) {
				found = false;
				printSong(s);
			}
		}
		if(found) {
			System.out.println("Artist: "+artist+" not found on personal Library.");		}
	}
	
	public void searchLibraryAlbumbyTittle(String title) {
		boolean found = true;
		for(Album a : albumList) {
			if(a.getName().equals(title) && a.inLibrary()) {
				found = false;
				printAlbum(a);
			}
		}
		if(found) {
			System.out.println("Album: "+title+" not found on personal Library.");		}
	}
	
	public void searchLibraryAlbumByArtist(String artist) {
		boolean found = true;
		for(Album a : albumList) {
			if(a.getArtist().equals(artist) && a.inLibrary()) {
				found = false;
				printAlbum(a);
			}
		}
		if(found) {
			System.out.println("Artist: "+artist+" not found on personal Library.");
		}
	}
	
	//Playlist management
	public void createPlaylist(String name) {
		allPlaylist.add(new Playlist(name));
	}
	
	//Check if correct, or if a diff way to store Song obj to Playlist obj
	//If song in playlist then in user library?
	public void addSongToPlaylist(String song, String name) {
		for(Playlist p : allPlaylist) {
			if(p.getName().equals(name)) {
				if(!p.containSong(song)) {
					for(Song s : musicLibrary) {
						if(s.getName().equals(song)) {
							p.addSongtoPlaylist(s);
						}
					}
				}
			}
		}
	}
	
	
	//Song rating
	
	//What happens if a song was rate 5 and the  it switches to rate 1?
	public void rateSong(String name, int rating) {
		if(rating < 1 || rating > 6) {
			System.out.println("rating: "+rating+" invalid.");
			return;
		}
		boolean found = true;
		for(Song s : musicLibrary) {
			if(s.getName().equals(name)) {
				s.setRating(rating);
				found = false;
			}
		}
		if(found) {
			System.out.println("Song: "+"name"+" not found on music library.");
		}
		
	}
	
}