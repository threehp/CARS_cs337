package classes;

public class classes {

	
	int id;
	String section_ID;
	String className;
	String teacher;
	
	public classes(int id, String section_ID, String className, String teacher) {
		super();
		this.id = id;
		this.section_ID = section_ID;
		this.className = className;
		this.teacher = teacher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSection_ID() {
		return section_ID;
	}

	public void setSection_ID(String section_ID) {
		this.section_ID = section_ID;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	
	
}
