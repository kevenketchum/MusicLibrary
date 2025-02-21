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
	//For all playlist search, it repeats values if same song is in multiple playlists
	public void searchPlaylistSongByTittle(String title) {
		boolean found = true;
		for(Playlist p : allPlaylist) {
			ArrayList<Song> songs = new ArrayList<Song>(p.getSongs());
			for(Song s : songs) {
				if(s.getName().equals(title)) {
					found = false;
					printSong(s);
				}
			}
		}
		if(found) {
			System.out.println("Song: "+title+" not found on any playlist.");
		}
	}
	
	public void searchPlaylistSongByArtist(String artist) {
		boolean found = true;
		for(Playlist p : allPlaylist) {
			ArrayList<Song> songs = new ArrayList<Song>(p.getSongs());
			for(Song s : songs) {
				if(s.getAuthor().equals(artist)) {
					found = false;
					printSong(s);
				}
			}
		}
		if(found) {
			System.out.println("Artist: "+artist+" not found on any playlist.");
		}
	}
	
	public void searchPlaylistAlbumByTittle(String title) {
		boolean found = true;
		for(Playlist p : allPlaylist) {
			ArrayList<Album> album = new ArrayList<Album>(p.getAlbums());
			for(Album a : album) {
				if(a.getName().equals(title)) {
					found = false;
					printAlbum(a);
				}
			}
		}
		if(found) {
			System.out.println("Song: "+title+" not found on any playlist.");
		}
	}
	
	public void searchPlaylistAlbumByArtist(String artist) {
		boolean found = true;
		for(Playlist p : allPlaylist) {
			ArrayList<Album> album = new ArrayList<Album>(p.getAlbums());
			for(Album a : album) {
				if(a.getArtist().equals(artist)) {
					found = false;
					printAlbum(a);
				}
			}
		}
		if(found) {
			System.out.println("Song: "+artist+" not found on any playlist.");
		}
	}
	
	//Add something to the Library
	
	//
}