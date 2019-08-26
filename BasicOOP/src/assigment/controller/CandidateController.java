package assigment.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import assigment.dao.CandidateDao;
import assigment.entity.Candidate;
import assigment.entity.Experience;
import assigment.entity.Fresher;
import assigment.entity.Intern;
import assigment.log.Log4jTest;
import assigment.utils.DateException;
import assigment.utils.EmailFormatException;
import assigment.utils.IDException;
import assigment.utils.Validator;

public class CandidateController {

	public int addCandidate(int type) {
		Scanner sc = new Scanner(System.in);
		Candidate candidate = null;
		Validator validation = new Validator();
		switch (type) {
		case 1:
			candidate = new Experience();
			break;
		case 2:
			candidate = new Fresher();
			break;
		case 3:
			candidate = new Intern();
			break;
		}
		System.out.println("Nhập id ứng viên: ");
		while (true) {
			try {
				String id = sc.nextLine();
				if (validation.isID(id)) {
					candidate.setCandidateID(id);
					break;
				}
			} catch (IDException e) {
				System.out.println(e);
			}
		}
		System.out.println("Nhập tên ứng viên: ");
		candidate.setFullName(sc.nextLine());
		System.out.println("Nhập ngày sinh ứng viên: ");
		// boolean test = true;
		while (true) {
			try {
				String date = sc.nextLine();
				if (validation.isDate(date))
					candidate.setBirthDay(new SimpleDateFormat("dd/mm/yyyy").parse(date));
				break;
			} catch (DateException | ParseException e) {
//				Logger logger = Logger.getLogger(Log4jTest.class);
//				DOMConfigurator.configure("log4j.xml");
//				logger.info(e);
				System.out.println(e);
			}
		}
		// test = true;
		System.out.println("Nhập số điện thoại: ");
		candidate.setPhone(sc.nextLine());

		System.out.println("Nhập email");
		while (true) {
			try {
				String email = sc.nextLine();
				validation.isEmail(email);
				candidate.setEmail(email);
				break;
			} catch (EmailFormatException e) {
				System.out.println(e);
				System.out.println("Mời nhập lại email");

			}
		}
		CertificateController certificate = new CertificateController();
		candidate.setCertificate(certificate.addCertificate());
		switch (type) {
		case 1:
			ExperienceController experience = new ExperienceController();
			experience.adddExperience(candidate);
			break;
		case 2:
			FresherController fresher = new FresherController();
			fresher.addFresher(candidate);
			break;
		case 3:
			InternController intern = new InternController();
			intern.addIntern(candidate);
			break;
		}
		
		return  candidate.getCandidateCount();
	}

	public void showAllCandidate() {
		CandidateDao dao = new CandidateDao();
		ArrayList<Candidate> listCandidate = dao.getAll();
		for (Candidate candidate : listCandidate) {
			candidate.showMe();
			System.out.println("                   ");
		}
	}

	public void updateCandidate() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập id ứng viên cần cập nhật: ");
		CandidateDao dao = new CandidateDao();
		Candidate candidate = null;
		while (true) {
			String idCan = sc.nextLine();
			if (dao.getCandidate(idCan) != null) {
				dao.getCandidate(idCan).showMe();
				candidate = dao.getCandidate(idCan);
				break;
			}
			System.out.println("Mời nhập lại id: ");
		}
		System.out.println("Nhập tên ứng viên: ");
		candidate.setFullName(sc.nextLine());
		System.out.println("Nhập ngày sinh ứng viên: ");
		Validator validation = new Validator();
		while (true) {
			try {
				String date = sc.nextLine();
				if (validation.isDate(date))
					candidate.setBirthDay(new SimpleDateFormat("dd/mm/yyyy").parse(date));
				break;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		System.out.println("Nhập số điện thoại: ");
		candidate.setPhone(sc.nextLine());

		System.out.println("Nhập email");
		while (true) {
			try {
				String email = sc.nextLine();
				validation.isEmail(email);
				candidate.setEmail(email);
				break;
			} catch (EmailFormatException e) {
				System.out.println(e);
			}
		}
		CertificateController certificate = new CertificateController();
		candidate.setCertificate(certificate.updateCertificate(candidate.getCandidateID()));
		switch (candidate.getCandidateType()) {
		case 0:
			ExperienceController experience = new ExperienceController();
			experience.updateExperience(candidate.getCandidateID(), candidate);
			break;
		case 1:
			FresherController fresher = new FresherController();
			fresher.updateFresher(candidate.getCandidateID(), candidate);
			break;
		case 2:
			InternController intern = new InternController();
			intern.updateIntern(candidate.getCandidateID(), candidate);
			break;
		}
	}

	public void deleteCandidate() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập id ứng viên cần cập nhật: ");
		CandidateDao dao = new CandidateDao();
		Candidate candidate = null;
		while (true) {
			String idCan = sc.nextLine();
			if (dao.getCandidate(idCan) != null) {
				candidate = dao.getCandidate(idCan);
				break;
			}
			System.out.println("Mời nhập lại id: ");
		}
		candidate.showMe();
		System.out.println("Có muốn xóa hay không? 1. Xóa       2. Không");
		int confirm = sc.nextInt();
		if (confirm == 1) {
			dao.deleteCandidate(candidate.getCandidateID());
		}
	}
	public void sortByTypeAndBirthday(ArrayList<Candidate> candidates){
        Collections.sort(candidates, new Comparator<Candidate>() {
            @Override
            public int compare(Candidate candidate1, Candidate candidate2) {
                if (candidate1.getCandidateType() == candidate2.getCandidateType()){
                    if ((candidate1.getBirthDay().getTime() - candidate2.getBirthDay().getTime()) > 0)
                    return 1;
                }
                return candidate1.getCandidateType() - candidate2.getCandidateType();
            }
        });
	}
	public void sortCandidate() {
		CandidateDao dao = new CandidateDao();
		sortByTypeAndBirthday(dao.getAll());
	}
}
