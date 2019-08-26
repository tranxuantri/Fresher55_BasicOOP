package assigment.controller;

import java.util.Scanner;

import assigment.dao.CandidateDao;
import assigment.entity.Candidate;
import assigment.entity.Experience;

public class ExperienceController {
	public void adddExperience(Candidate candidate) {
		Scanner sc = new Scanner(System.in);
		if (candidate instanceof Experience) {
			Experience experience = (Experience) candidate;
			System.out.println("Nhập số năm kinh nghiệm: ");
			experience.setExpInYear(sc.nextInt());
			sc.nextLine();
			System.out.println("Nhập kỹ năng chuyên môn: ");
			experience.setProSkill(sc.nextLine());
			CandidateDao dao = new CandidateDao();
			dao.insertExperience(experience);
		}
	}
	public void updateExperience (String id, Candidate candidate) {
		Scanner sc = new Scanner(System.in);
		if (candidate instanceof Experience) {
			Experience experience = (Experience) candidate;
			System.out.println("Nhập số năm kinh nghiệm: ");
			experience.setExpInYear(sc.nextInt());
			sc.nextLine();
			System.out.println("Nhập kỹ năng chuyên môn: ");
			experience.setProSkill(sc.nextLine());
			CandidateDao dao = new CandidateDao();
			dao.updateExperience(id, experience);
		}
	}
}
