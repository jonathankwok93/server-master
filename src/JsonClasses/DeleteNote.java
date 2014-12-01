package JsonClasses;

public class DeleteNote implements java.io.Serializable{
	
	private final Long serialVersionUID = 1L;
	private String overallID = "deleteNote";
	private String noteId;
	private int publicOrPrivate;
	
	
	/* Getters and setters
	 * 
	 */
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	public String getNoteId() {
		return noteId;
	}
	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}
	public int getPublicOrPrivate() {
		return publicOrPrivate;
	}
	public void setPublicOrPrivate(int publicOrPrivate) {
		this.publicOrPrivate = publicOrPrivate;
	}
	public Long getSerialVersionUID() {
		return serialVersionUID;
	}
	
	

}
