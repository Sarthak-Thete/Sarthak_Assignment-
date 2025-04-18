package jdbcPratice;

import java.util.Collection;
import java.util.Scanner;



public class studMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean exit=true;
		while(true) {
		System.out.println("Enter Choice"+"\n1.Get All Students"+"\n2.Get One Student"+"\n3.Add One Student"+"\n0.Exit");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			StudentDao student = new StudentDao();
			Collection<Student> collection = student.getAll();
			
			collection.stream().forEach(stud->System.out.println(stud));
			
			break;
		case 2:
		{
			StudDao <Student,Integer> dao= new StudentDao();
			Student stud = dao.getOne(1);
			if(stud!=null)
				System.out.println(stud);
				else
					System.out.println("Department with given Id does Not Exist.");
			
			break;
		}
		case 3:
		{
			StudentDao  dao= new StudentDao();
			Student stud = new Student(5, "Nita", "Nashik");
			dao.add(stud);
		}
			break;
		case 4:
			if(choice==0)
				exit=false;
			break;
		}

	}
	}
}
