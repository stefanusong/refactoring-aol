package before.models;

public class Student extends User {
	private String faculty;
	private String studyProgram;
	private int entryYear;
	
	public Student(int id, UserInfo userInfo, String faculty, String studyProgram, int entryYear) {
		super(id, userInfo);
		this.faculty = faculty;
		this.studyProgram = studyProgram;
		this.entryYear = entryYear;
	}

	// Getters and setters
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getStudyProgram() {
		return studyProgram;
	}
	public void setStudyProgram(String studyProgram) {
		this.studyProgram = studyProgram;
	}
	public int getEntryYear() {
		return entryYear;
	}
	public void setEntryYear(int entryYear) {
		this.entryYear = entryYear;
	}

	@Override
	public String getGreetingMessage() {
		return "Welcome, " + getUserInfo().getName() + " what book do you wanna read today ?"; 
	}
	
}
