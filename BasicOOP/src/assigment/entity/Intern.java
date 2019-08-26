package assigment.entity;

public class Intern extends Candidate {
	private String majors;
	private int semester;
	private String universityName;

	public Intern() {
		super();
	}

	public Intern(String majors, int semester, String universityName) {
		super();
		this.majors = majors;
		this.semester = semester;
		this.universityName = universityName;
	}

	public void showMe() {
		super.showMe();
		System.out.println("Chuyên ngành học: "+ getMajors());
		System.out.println("Học kì đang học: "+ getSemester());
		System.out.println("Tên trường đang học: "+ getUniversityName());
	}

	public String getMajors() {
		return majors;
	}

	public void setMajors(String majors) {
		this.majors = majors;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public int getCandidateType() {
		return 2;
	}

}
