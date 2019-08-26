package assigment.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import assigment.dao.CandidateDao;
import assigment.entity.Certificate;
import assigment.log.Log4jTest;
import assigment.utils.DateException;
import assigment.utils.Validator;

public class CertificateController {
	ArrayList<Certificate> addCertificate() {
		ArrayList<Certificate> listCertificate = new ArrayList<Certificate>();
		Scanner sc = new Scanner(System.in);
		int opt = 0;
		Validator validation = new Validator();

		while (true) {
			System.out.println("1. Nhập bằng cấp");
			System.out.println("0. Kết thúc");
			opt = sc.nextInt();
			sc.nextLine();
			switch (opt) {
			case 1:
				Certificate certificate = new Certificate();
				System.out.println("Nhập mã bằng cấp");
				certificate.setCertificatedID(sc.nextLine());
				System.out.println("Nhập tên bằng cấp: ");
				certificate.setCertificateName(sc.nextLine());
				System.out.println("Nhập xếp loại của bằng cấp: ");
				certificate.setCertificateRank(sc.nextLine());
				System.out.println("Nhập ngày cấp: ");
				while (true) {
					try {
						String date = sc.nextLine();
						if (validation.isDate(date)) {
							certificate.setCertificateDate(new SimpleDateFormat("dd/mm/yyyy").parse(date));
							break;
						}
					} catch (DateException e) {
						System.out.println("Mời nhập lại ngày ");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				listCertificate.add(certificate);
				return listCertificate;
			case 0:
				return listCertificate;
			}
		}
	}

	public ArrayList<Certificate> updateCertificate(String id) {
		ArrayList<Certificate> listCertificate = new ArrayList<Certificate>();
		Scanner sc = new Scanner(System.in);
		int opt = 0;
		Validator validation = new Validator();
		while (true) {
			System.out.println("1. Cập nhật bằng cấp");
			System.out.println("0. Kết thúc");
			opt = sc.nextInt();
			sc.nextLine();
			switch (opt) {
			case 1:
				Certificate certificate = new Certificate();
				System.out.print("Nhập mã bằng cấp: ");
				certificate.setCertificatedID(sc.nextLine());
				System.out.print("Nhập tên bằng cấp: ");
				certificate.setCertificateName(sc.nextLine());
				System.out.print("Nhập xếp loại của bằng cấp: ");
				certificate.setCertificateRank(sc.nextLine());
				System.out.print("Nhập ngày cấp: ");
				while (true) {
					try {
						String date = sc.nextLine();
						if (validation.isDate(date)) {
							certificate.setCertificateDate(new SimpleDateFormat("dd/mm/yyyy").parse(date));
							break;
						}
					} catch (DateException e) {
						System.out.println("Mời nhập lại ngày ");
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				listCertificate.add(certificate);
				return listCertificate;
			case 0:
				CandidateDao dao = new CandidateDao();
				return dao.getCertificate(id);
			}
		}
	}
}
