package jdbcPratice;

public class Student {
	private int rollNo;
	private String Name;
	private String City;
	public Student(int rollNo, String name, String city) {
		super();
		this.rollNo = rollNo;
		Name = name;
		City = city;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", Name=" + Name + ", City=" + City + "]";
	}

}
