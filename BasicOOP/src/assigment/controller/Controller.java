package assigment.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import assigment.dao.CandidateDao;
import assigment.entity.Candidate;
import assigment.utils.DateException;
import assigment.utils.EmailFormatException;

public class Controller {
	CandidateDao dao;
	CandidateController controller;

	public void control() throws ParseException, DateException, EmailFormatException {
		controller = new CandidateController();
		System.out.println("*******CANDIDATE MANAGEMENT******");
		Scanner sc = new Scanner(System.in);
		int op1 = 1;
		while (op1 != 0) {
			System.out.println("1. Xem thông tin ứng viên");
			System.out.println("2. Nhập ứng viên mới");
			System.out.println("3. Cập nhật thông tin ứng viên");
			System.out.println("4. Xóa ứng viên");
			System.out.println("5. Sắp xếp ứng viên theo loại");
			System.out.println("0. Thoát chương trình");
			op1 = sc.nextInt();
			switch (op1) {
			case 1:
				controller.showAllCandidate();
				break;
			case 2:
				int op2 = 1;
				int count = 0;
				Candidate.resetCount();
				while (op2 != 0) {
					System.out.println("Chọn loại ứng viên cần nhập");
					System.out.println("1. Có kinh nghiệm(Experience)");
					System.out.println("2. Fresher");
					System.out.println("3. Thực tập sinh(Intern)");
					System.out.println("0. Dừng nhập");
					op2 = sc.nextInt();
					switch (op2) {
					case 1:
						count = controller.addCandidate(op2);
						break;
					case 2:
						count = controller.addCandidate(op2);
						break;
					case 3:
						count = controller.addCandidate(op2);
						break;
					case 0:
						dao = new CandidateDao();
						ArrayList<Candidate> list = dao.getAll();
						if (count != 0) {
							for (int i = list.size(); i < 0; i--) {
								list.get(i).showMe();
							}
						} else {
							System.out.println("Bạn chưa nhập ứng viên nào!!");
						}
						break;
					}
				}
				break;
			case 3:
				controller.updateCandidate();
				break;
			case 4:
				controller.deleteCandidate();
				break;
			case 5: 
				controller.sortCandidate();
				break;
			case 0:
				break;
			}
		}
	}
}
