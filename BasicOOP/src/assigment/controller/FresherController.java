package assigment.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import assigment.dao.CandidateDao;
import assigment.entity.Candidate;
import assigment.entity.Fresher;
import assigment.utils.DateException;
import assigment.utils.Validator;

public class FresherController {
	void addFresher(Candidate candidate) {
		Validator validation = new Validator();
		Scanner sc = new Scanner(System.in);
		if (candidate instanceof Fresher) {
			Fresher fresher = (Fresher) candidate;
			System.out.println("Nhập ngày tốt nghiệp: ");
			while (true) {
				try {
					String date = sc.nextLine();
					if (validation.isDate(date)) {
						fresher.setGraduationDate(new SimpleDateFormat("dd/mm/yyyy").parse(date));
					}
					break;
				} catch (DateException e) {
					System.out.println("Mời nhập lại ngày ");
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Nhập xếp loại tốt nghiệp ");
			fresher.setGraduationRank(sc.nextLine());
			System.out.println("Nhập tên trường: ");
			fresher.setEducation(sc.nextLine());
			CandidateDao dao = new CandidateDao();
			dao.insertFresher(fresher);
		}
	}

	void updateFresher(String id, Candidate candidate) {
		Validator validation = new Validator();
		Scanner sc = new Scanner(System.in);
		if (candidate instanceof Fresher) {
			Fresher fresher = (Fresher) candidate;
			System.out.println("Nhập ngày tốt nghiệp: ");
			while (true) {
				try {
					String date = sc.nextLine();
					if (validation.isDate(date)) {
						fresher.setGraduationDate(new SimpleDateFormat("dd/mm/yyyy").parse(date));
					}
					break;
				} catch (DateException e) {
					System.out.println("Mời nhập lại ngày ");
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Nhập xếp loại tốt nghiệp ");
			fresher.setGraduationRank(sc.nextLine());
			System.out.println("Nhập tên trường: ");
			fresher.setEducation(sc.nextLine());
			CandidateDao dao = new CandidateDao();
			dao.updateFresher(id, fresher);
		}
	}
}
