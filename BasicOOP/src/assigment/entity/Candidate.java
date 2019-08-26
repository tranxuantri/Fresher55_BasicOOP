package assigment.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Candidate {
	private String candidateID;
	private String fullName;
	private Date birthDay;
	private String phone;
	protected String email;
	private int candidateType;
	private static int candidateCount;
	private ArrayList<Certificate> certificate;

	public void showMe() {
		System.out.println("------------------------------");
		System.out.println("Mã ứng viên: " + getCandidateID());
		System.out.println("Tên ứng viên: " + getFullName());
		System.out.println("Số điện thoại: " + getPhone());
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		String strDate = dateFormat.format(getBirthDay());
		System.out.println("Ngày sinh: " + strDate);
		System.out.println("Email: " + getEmail());
		System.out.print("Loai ung vien: ");
		switch (getCandidateType()) {
		case 0:	
			System.out.println("Experience");
			break;
		case 1:
			System.out.println("Fresher");
			break;
		case 2:
			System.out.println("Intern");
			break;
		}
	}

	public Candidate() {
		super();
		candidateCount++;
	}

	public Candidate(String candidateID, String fullName, Date birthDay, String phone, String email, byte candidateType,
			ArrayList<Certificate> certificate) {
		super();
		this.candidateID = candidateID;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.phone = phone;
		this.email = email;
		this.candidateType = candidateType;
		this.certificate = certificate;
		candidateCount++;
	}

	public String getCandidateID() {
		return candidateID;
	}

	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public abstract int getCandidateType();

	public int getCandidateCount() {
		return candidateCount;
	}

	public void setCertificate(ArrayList certificate) {
		this.certificate = certificate;
	}

	public ArrayList<Certificate> getCertificate() {
		return certificate;
	}
	public static void resetCount () {
		candidateCount = 0;
	}
}
