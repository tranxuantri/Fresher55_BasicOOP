package assigment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import assigment.entity.Candidate;
import assigment.entity.Certificate;
import assigment.entity.Experience;
import assigment.entity.Fresher;
import assigment.entity.Intern;

public class CandidateDao {
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=BasicOOP";
	private static String USER_NAME = "sa";
	private static String PASSWORD = "TriTX123456789";
	private static Statement stmt = null;
	private static Connection conn = null;

	public static Connection getConnection(String dbUrl, String userName, String password) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(dbUrl, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public ArrayList<Candidate> getAll() {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "select * from candidate";
			ResultSet rs = stmt.executeQuery(sql);
			
			ArrayList<Candidate> listCandidate = new ArrayList<Candidate>();

			while (rs.next()) {
				switch (rs.getInt(6)) {
				case 0:
					Experience experience = getExperience(rs.getString(1));
					experience.setFullName(rs.getString(2));
					experience.setBirthDay(rs.getDate(3));
					experience.setPhone(rs.getString(4));
					experience.setEmail(rs.getString(5));
					listCandidate.add(experience);
					break;
				case 1:
					Fresher fresher = getFresher(rs.getString(1));
					fresher.setFullName(rs.getString(2));
					fresher.setBirthDay(rs.getDate(3));
					fresher.setPhone(rs.getString(4));
					fresher.setEmail(rs.getString(5));
					listCandidate.add(fresher);
					break;
				case 2:
					Intern intern = getIntern(rs.getString(1));
					intern.setFullName(rs.getString(2));
					intern.setBirthDay(rs.getDate(3));
					intern.setPhone(rs.getString(4));
					intern.setEmail(rs.getString(5));
					listCandidate.add(intern);
					break;
				}
			}
			rs.close();
			conn.close();
			return listCandidate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<String> getAllID() {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "select * from candidate";
			ResultSet rs = stmt.executeQuery(sql);

			ArrayList<String> listID = new ArrayList<String>();
			while (rs.next()) {
				listID.add(rs.getString(1));
			}
			return listID;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Candidate getCandidate(String id) {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			String sql = "SELECT * FROM candidate WHERE candidateID = ?";
			PreparedStatement prstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			prstmt.setString(1, id);
			ResultSet rs = prstmt.executeQuery();
			while (rs.next()) {
				switch (rs.getInt(6)) {
				case 0:
					Experience experience = getExperience(rs.getString(1));
					experience.setFullName(rs.getString(2));
					experience.setBirthDay(rs.getDate(3));
					experience.setPhone(rs.getString(4));
					experience.setEmail(rs.getString(5));
					return experience;
				case 1:
					Fresher fresher = getFresher(rs.getString(1));
					fresher.setFullName(rs.getString(2));
					fresher.setBirthDay(rs.getDate(3));
					fresher.setPhone(rs.getString(4));
					fresher.setEmail(rs.getString(5));
					return fresher;
				case 2:
					Intern intern = getIntern(rs.getString(1));
					intern.setFullName(rs.getString(2));
					intern.setBirthDay(rs.getDate(3));
					intern.setPhone(rs.getString(4));
					intern.setEmail(rs.getString(5));
					return intern;
				}
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Intern getIntern(String id) {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			String sql = "select * from intern where candidateID = ?";
			PreparedStatement prstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			prstmt.setString(1, id);
			ResultSet rs = prstmt.executeQuery();
			Intern intern = new Intern();
			System.out.println(rs);
			while (rs.next()) {
				intern.setCandidateID(rs.getString(1));
				intern.setMajors(rs.getString(2));
				intern.setSemester(rs.getInt(3));
				intern.setUniversityName(rs.getString(4));
				return intern;
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Experience getExperience(String id) {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			String sql = "select * from experience where candidateID = ?";
			PreparedStatement prstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			prstmt.setString(1, id);
			ResultSet rs = prstmt.executeQuery();
			Experience experience = new Experience();
			while (rs.next()) {
				experience.setCandidateID(rs.getString(1));
				experience.setExpInYear(rs.getInt(2));
				experience.setProSkill(rs.getString(3));
				return experience;
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Fresher getFresher(String id) {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			String sql = "select * from fresher where candidateID = ?";
			PreparedStatement prstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			prstmt.setString(1, id);
			ResultSet rs = prstmt.executeQuery();
			Fresher fresher = new Fresher();
			while (rs.next()) {
				fresher.setCandidateID(rs.getString(1));
				fresher.setGraduationDate(rs.getDate(2));
				fresher.setGraduationRank(rs.getString(3));
				fresher.setEducation(rs.getString(4));
				return fresher;
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Certificate> getCertificate(String id) {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			String sql = "select * from certificate where candidateID = ?";
			PreparedStatement prstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			prstmt.setString(1, id);
			ResultSet rs = prstmt.executeQuery();
			ArrayList<Certificate> list = new ArrayList<>();
			while (rs.next()) {
				Certificate certificate = new Certificate();
				certificate.setCertificatedID(rs.getString(2));
				certificate.setCertificateName(rs.getString(3));
				certificate.setCertificateRank(rs.getString(4));
				certificate.setCertificateDate(rs.getDate(5));
				list.add(certificate);
			}

			rs.close();
			conn.close();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insertCandidate(Candidate candidate) {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "select * from candidate";
			ResultSet rs = stmt.executeQuery(sql);

			rs.beforeFirst();
			rs.moveToInsertRow();
			rs.updateString(1, candidate.getCandidateID());
			rs.updateString(2, candidate.getFullName());
			rs.updateDate(3, new java.sql.Date(candidate.getBirthDay().getTime()));
			rs.updateString(4, candidate.getPhone());
			rs.updateString(5, candidate.getEmail());
			rs.updateInt(6, candidate.getCandidateType());
			rs.insertRow();
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertExperience(Experience experience) {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "select * from Experience";
			ResultSet rs = stmt.executeQuery(sql);

			rs.beforeFirst();
			rs.moveToInsertRow();
			insertCandidate(experience);
			insertCertificate(experience);
			rs.updateString(1, experience.getCandidateID());
			rs.updateInt(2, experience.getExpInYear());
			rs.updateString(3, experience.getProSkill());
			rs.insertRow();
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertFresher(Fresher fresher) {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "select * from Fresher";
			ResultSet rs = stmt.executeQuery(sql);

			rs.beforeFirst();
			rs.moveToInsertRow();
			insertCandidate(fresher);
			insertCertificate(fresher);
			rs.updateString(1, fresher.getCandidateID());
			rs.updateDate(2, new java.sql.Date(fresher.getGraduationDate().getTime()));
			rs.updateString(3, fresher.getGraduationRank());
			rs.updateString(4, fresher.getEducation());
			rs.insertRow();
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertIntern(Intern intern) {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "SELECT * FROM intern";
			ResultSet rs = stmt.executeQuery(sql);

			rs.beforeFirst();
			rs.moveToInsertRow();
			insertCandidate(intern);
			insertCertificate(intern);
			rs.updateString(1, intern.getCandidateID());
			rs.updateString(2, intern.getMajors());
			rs.updateInt(3, intern.getSemester());
			rs.updateString(4, intern.getUniversityName());
			rs.insertRow();
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertCertificate(Candidate candidate) {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String sql = "SELECT * FROM certificate";
			ResultSet rs = stmt.executeQuery(sql);

			rs.beforeFirst();
			rs.moveToInsertRow();
			rs.updateString(1, candidate.getCandidateID());
			ArrayList<Certificate> list = candidate.getCertificate();
			if (!list.isEmpty()) {
				for (int i = 0; i < list.size(); i++) {
					Certificate certificate = list.get(i);
					rs.updateString(1, candidate.getCandidateID());
					rs.updateString(2, certificate.getCertificatedID());
					rs.updateString(3, certificate.getCertificateName());
					rs.updateString(4, certificate.getCertificateRank());
					rs.updateDate(5, new java.sql.Date(certificate.getCertificateDate().getTime()));
					rs.insertRow();
				}
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateCandidate(String id, Candidate candidate) {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			String sql = "SELECT * FROM candidate WHERE candidateID = ?";
			PreparedStatement prstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			prstmt.setString(1, candidate.getCandidateID());
			ResultSet rs = prstmt.executeQuery();

			while (rs.next()) {
				rs.updateString(2, candidate.getFullName());
				rs.updateDate(3, new java.sql.Date(candidate.getBirthDay().getTime()));
				rs.updateString(4, candidate.getPhone());
				rs.updateString(5, candidate.getEmail());
				rs.updateInt(6, candidate.getCandidateType());
				rs.updateRow();
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateFresher(String id, Fresher fresher) {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			String sql = "select * from Fresher where candidateID = ?";
			PreparedStatement prstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			prstmt.setString(1, fresher.getCandidateID());
			ResultSet rs = prstmt.executeQuery();

			while (rs.next()) {
				if (rs.getString(1).equals(id)) {
					updateCandidate(id, fresher);
					updateCertificate(id, fresher);
					rs.updateDate(2, new java.sql.Date(fresher.getGraduationDate().getTime()));
					rs.updateString(3, fresher.getGraduationRank());
					rs.updateString(4, fresher.getEducation());
					rs.updateRow();
				}
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateExperience(String id, Experience experience) {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			String sql = "select * from Experience where candidateID = ?";
			PreparedStatement prstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			prstmt.setString(1, experience.getCandidateID());
			ResultSet rs = prstmt.executeQuery();

			while (rs.next()) {
				if (rs.getString(1).equals(id)) {
					updateCandidate(id, experience);
					updateCertificate(id, experience);
					rs.updateInt(2, experience.getExpInYear());
					rs.updateString(3, experience.getProSkill());
					rs.updateRow();
				}
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateIntern(String id, Intern intern) {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			String sql = "select * from intern where candidateID = ?";
			PreparedStatement prstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			prstmt.setString(1, intern.getCandidateID());
			ResultSet rs = prstmt.executeQuery();

			while (rs.next()) {
				if (rs.getString(1).equals(id)) {
					updateCandidate(id, intern);
					updateCertificate(id, intern);
					rs.updateString(2, intern.getMajors());
					rs.updateInt(3, intern.getSemester());
					rs.updateString(4, intern.getUniversityName());
					rs.updateRow();
				}
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateCertificate(String id, Candidate candidate) {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			String sql = "select * from certificate where candidateID = ?";
			PreparedStatement prstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			prstmt.setString(1, id);
			ResultSet rs = prstmt.executeQuery();

			while (rs.next()) {
				ArrayList<Certificate> list = candidate.getCertificate();
				for (int i = 0; i < list.size(); i++) {
					Certificate certificate = list.get(i);
					rs.updateString(2, certificate.getCertificatedID());
					rs.updateString(3, certificate.getCertificateName());
					rs.updateString(4, certificate.getCertificateRank());
					rs.updateDate(5, new java.sql.Date(certificate.getCertificateDate().getTime()));
					rs.updateRow();
				}
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCandidate(String id) {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			String sql = "Select * from candidate where candidateID=?";
			PreparedStatement prstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			prstmt.setString(1, id);
			ResultSet rs = prstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(6) == 0) {
					deleteExperience(id);
				} else if (rs.getInt(6) == 1) {
					deleteFresher(id);
				} else if (rs.getInt(6) == 2) {
					deleteIntern(id);
				}
				rs.deleteRow();
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteFresher(String id) {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			String sql = "Select * from fresher where candidateID=?";
			PreparedStatement prstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			prstmt.setString(1, id);
			ResultSet rs = prstmt.executeQuery();
			while (rs.next()) {
				rs.deleteRow();
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteIntern(String id) {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			String sql = "Select * from intern where candidateID=?";
			PreparedStatement prstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			prstmt.setString(1, id);
			ResultSet rs = prstmt.executeQuery();
			while (rs.next()) {
				rs.deleteRow();
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteExperience(String id) {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			String sql = "Select * from experience where candidateID=?";
			PreparedStatement prstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			prstmt.setString(1, id);
			ResultSet rs = prstmt.executeQuery();
			while (rs.next()) {
				rs.deleteRow();
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCertificate(String id) {
		try {
			conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			String sql = "Select * from certificate where candidateID=?";
			PreparedStatement prstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			prstmt.setString(1, id);
			ResultSet rs = prstmt.executeQuery();
			while (rs.next()) {
				rs.deleteRow();
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
