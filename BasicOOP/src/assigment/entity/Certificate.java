package assigment.entity;

import java.util.Date;

public class Certificate {
	private String CertificatedID;
	private String CertificateName;
	private String CertificateRank;
	private Date CertificateDate;

	public Certificate() {
		super();
	}

	public Certificate(String certificatedID, String certificateName,
			String certificateRank, Date certificateDate) {
		super();
		CertificatedID = certificatedID;
		CertificateName = certificateName;
		CertificateRank = certificateRank;
		CertificateDate = certificateDate;
	}

	public String getCertificatedID() {
		return CertificatedID;
	}

	public void setCertificatedID(String certificatedID) {
		CertificatedID = certificatedID;
	}

	public String getCertificateName() {
		return CertificateName;
	}

	public void setCertificateName(String certificateName) {
		CertificateName = certificateName;
	}

	public String getCertificateRank() {
		return CertificateRank;
	}

	public void setCertificateRank(String certificateRank) {
		CertificateRank = certificateRank;
	}

	public Date getCertificateDate() {
		return CertificateDate;
	}

	public void setCertificateDate(Date certificateDate) {
		CertificateDate = certificateDate;
	}

}
