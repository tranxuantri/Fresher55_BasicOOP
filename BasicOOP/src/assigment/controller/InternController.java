package assigment.controller;

import java.util.Scanner;

import assigment.dao.CandidateDao;
import assigment.entity.Candidate;
import assigment.entity.Intern;

public class InternController {
	public void addIntern(Candidate candidate) {
		Scanner sc = new Scanner(System.in);
		if (candidate instanceof Intern) {
			Intern intern = (Intern) candidate;
			System.out.println("Nhập chuyên ngành đang học: ");
			intern.setMajors(sc.nextLine());
			System.out.println("Nhập học kì đang học: ");
			intern.setSemester(sc.nextInt());
			sc.nextLine();
			System.out.println("Nhập tên trường đang học: ");
			intern.setUniversityName(sc.nextLine());
			CandidateDao dao = new CandidateDao();
			dao.insertIntern(intern);
		}
	}

	public void updateIntern(String id, Candidate candidate) {
		Scanner sc = new Scanner(System.in);
		if (candidate instanceof Intern) {
			Intern intern = (Intern) candidate;
			System.out.println("Nhập chuyên ngành đang học: ");
			intern.setMajors(sc.nextLine());
			System.out.println("Nhập học kì đang học: ");
			intern.setSemester(sc.nextInt());
			sc.nextLine();
			System.out.println("Nhập tên trường đang học: ");
			intern.setUniversityName(sc.nextLine());
			CandidateDao dao = new CandidateDao();
			dao.updateIntern(id,intern);
		}
	}
}
