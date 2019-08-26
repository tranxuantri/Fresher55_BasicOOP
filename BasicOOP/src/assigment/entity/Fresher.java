package assigment.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fresher extends Candidate {
	private Date graduationDate;
	private String graduationRank;
	private String education;

	public Fresher() {
		super();
	}

	public Fresher(Date graduationDate, String graduationRank, String education) {
		super();
		this.graduationDate = graduationDate;
		this.graduationRank = graduationRank;
		this.education = education;
	}

	public void showMe() {
		super.showMe();
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		String strDate = dateFormat.format(getGraduationDate());
		System.out.println("Năm tốt nghiệp: "+strDate);
		System.out.println("Xếp loại tốt nghiệp: "+getGraduationRank());
		System.out.println("Trường tốt nghiệp: "+getEducation());
	}

	public Date getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}

	public String getGraduationRank() {
		return graduationRank;
	}

	public void setGraduationRank(String graduationRank) {
		this.graduationRank = graduationRank;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public int getCandidateType() {
		return 1;
	}

}
