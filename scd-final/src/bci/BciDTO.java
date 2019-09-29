package bci;

public class BciDTO {
	int bciid;
	int year;
	int quarter;
	int sigungucode;
	String sigungucodename;
	String ci;
	String ciname;
	int obma;
	int cbma;
	int sosma;
	int scsma;
	public int getBciid() {
		return bciid;
	}
	public int getObma() {
		return obma;
	}
	public void setObma(int obma) {
		this.obma = obma;
	}
	public int getCbma() {
		return cbma;
	}
	public void setCbma(int cbma) {
		this.cbma = cbma;
	}
	public int getSosma() {
		return sosma;
	}
	public void setSosma(int sosma) {
		this.sosma = sosma;
	}
	public int getScsma() {
		return scsma;
	}
	public void setScsma(int scsma) {
		this.scsma = scsma;
	}
	public void setBciid(int bciid) {
		this.bciid = bciid;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getQuarter() {
		return quarter;
	}
	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}
	public int getSigungucode() {
		return sigungucode;
	}
	public void setSigungucode(int sigungucode) {
		this.sigungucode = sigungucode;
	}
	public String getSigungucodename() {
		return sigungucodename;
	}
	public void setSigungucodename(String sigungucodename) {
		this.sigungucodename = sigungucodename;
	}
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getCiname() {
		return ciname;
	}
	public void setCiname(String ciname) {
		this.ciname = ciname;
	}
	
}
