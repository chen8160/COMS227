package lab4;

public class BibItem {
	private String authors;
	private String title;
	private String journal;
	private int year;
	private int volume;

	public BibItem(String givenAuthors, String givenTitle, String givenJournal,
			int givenYear, int givenVolume) {
		authors = givenAuthors;
		title = givenTitle;
		journal = givenJournal;
		year = givenYear;
		volume = givenVolume;
	}
	
	public String toString(){
		String output = authors + ". " + title +". "+journal+" "+volume+" ("+year+")";
		return output;
	}
	
}