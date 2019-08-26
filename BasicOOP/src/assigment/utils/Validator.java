package assigment.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import assigment.dao.CandidateDao;

public class Validator {
	private static final String VALID_EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]" + "+\\.[a-zA-Z]{2,6}$";
	private static final String VALID_PHONE_REGEX = "^[0-9] {10|11}$";
	private static final String VALID_DATE_REGEX = "^([1-9]|0[1-9]|[12][0-9]|3[01])[- /.]([1-9]|0[1-9]|1[012])[- /.](19|20)\\d\\d$";

	/**
	 * Check email is valid
	 * 
	 * @param emailAddress
	 * @return true, if valid, otherwise return false
	 */
	public boolean isEmail(String emailAddress) throws EmailFormatException {
		Pattern pattern = Pattern.compile(VALID_EMAIL_REGEX);
		Matcher matcher = pattern.matcher(emailAddress);
		if (!matcher.matches()) {
			throw new EmailFormatException("Sai định dạng email");
		}
		return matcher.matches();
	}

	/**
	 * check phone is valid
	 * 
	 * @param phone
	 * @return true, if valid, otherwise return false
	 */
	public static boolean isPhone(String phone) {
		Pattern pattern = Pattern.compile(VALID_PHONE_REGEX);
		Matcher matcher = pattern.matcher(phone);
		return matcher.matches();
	}

	/**
	 * Check gender value is valid.
	 * 
	 * @param gender
	 * @return true, if valid, otherwise return false
	 */
	public static boolean isGender(char gender) {
		if ((gender == 'm') || (gender == 'f')) {
			return true;
		}
		return false;
	}

	/**
	 * check date is valid
	 * 
	 * @param date
	 * @return true, if valid, otherwise return false
	 */
	public boolean isDate(String date) throws DateException {
		Pattern pattern = Pattern.compile(VALID_DATE_REGEX);
		Matcher matcher = pattern.matcher(date);
		if (!matcher.matches()) {
			throw new DateException("Sai định dạng ngày");
		}
		return matcher.matches();
	}

	public boolean isID(String id) throws IDException {
		CandidateDao dao = new CandidateDao();
		ArrayList<String> listID = dao.getAllID();
		if (listID.contains(id)) {
			throw new IDException("Trùng ID vui lòng nhập lại");
		}
		return true;
	}
}
