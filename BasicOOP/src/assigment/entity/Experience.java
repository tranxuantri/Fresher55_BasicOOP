package assigment.entity;

public class Experience extends Candidate{
	private int expInYear;
	private String proSkill;
	
	
	public Experience() {
		super();
	}

	public Experience(int expInYear, String proSkill) {
		super();
		this.expInYear = expInYear;
		this.proSkill = proSkill;
	}

	public void showMe() {
		super.showMe();
		System.out.println("Số năm kinh nghiệm: " + getExpInYear());
		System.out.println("Kỹ năng chuyên môn: " + getProSkill());
	}

	public int getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	public int getCandidateType() {
		return 0;
	}
	 
}
