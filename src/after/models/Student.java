package after.models;

public class Student extends User {
	private String faculty;
	private String studyProgram;
	private int entryYear;
	
	public Student(int id, String name, String gender, String username, String password, String faculty, String studyProgram, int entryYear) {
		super(id, name, gender, username, password);
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
		return "Welcome, " + getName() + " what book do you wanna read today ?"; 
	}
	
}
