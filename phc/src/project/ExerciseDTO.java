package project;

public class ExerciseDTO {
	int eid;
	String ename;
	char kind;
	String contents;
	String img;
	int eCal;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public char getKind() {
		return kind;
	}
	public void setKind(char kind) {
		this.kind = kind;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int geteCal() {
		return eCal;
	}
	public void seteCal(int eCal) {
		this.eCal = eCal;
	}
	@Override
	public String toString() {
		return "ExerciseDTO [eid=" + eid + ", ename=" + ename + ", kind=" + kind + ", contents=" + contents + ", img="
				+ img + ", eCal=" + eCal + "]";
	}
	
	
}
