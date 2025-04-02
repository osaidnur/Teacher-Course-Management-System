/**
 * Name    : Osaid Hasan Nur
 * ID      : 1210733
 * Lecture : 6
 * Lab     : 11L
 */
package ass2 ;
import java.util.*;
public class Driver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("*********** Welcome ***********");
		System.out.println("Enter the number of teachers :");
		int size = input.nextInt();
		// define an array of objects of type Teacher
		Teacher[] teachers = new Teacher[size];
		for (int j = 0; j < size; j++) {
			System.out.println("Enter teacher #" + (j + 1) + " name , id , basic salary , and extra payment rate : ");
			// get the name , id , basic salary , and extra payment rate respectivly
			String name = input.next();
			int id = input.nextInt();
			double basicsalary = input.nextDouble();
			double extrapaymentrate = input.nextDouble();
			// get the courses informations 
			System.out.println("Enter the number of courses that teacher #" + (j + 1) + " taught >>> ");
			int num_courses = input.nextInt();
			// define an array of Courses
			Course[] courses = new Course[num_courses];
			for (int k = 0; k < num_courses; k++) {
				System.out.print("-> Enter Name and id for course " + (k + 1) + " : ");
				String namec = input.next();
				int idc = input.nextInt();
				// make new object and pass the values by the constructor , and store it in the array
				courses[k] = new Course(namec, idc);
			}
			// pass all attributes using the constructor and store it in the array of teachers
			teachers[j] = new Teacher(name, id, basicsalary, extrapaymentrate, courses);
			System.out.println("_________________________________________________________");
		}
		
		while (true) {
			// display the main menu
			System.out.println("<<<<< Enter your choice of tasks(1-5) : >>>>>");
			System.out.println("1- Print Teacher Information :");
			System.out.println("2- Display teachers’ total salaries :");
			System.out.println("3- Change basicSalary for a teacher :");
			System.out.println("4- Display sum of Total Salaries :");
			System.out.println("5- Exit");
			int selection = input.nextInt();
			if (selection == 1) {
				// show informations for any teacher using the id entered by the user
				System.out.println("Enter the id of the teacher to show his information :");
				int idd = input.nextInt();
				// boolean flag to check if the id exists or not 
				boolean found= false ;
				for (int l = 0; l < teachers.length; l++) {
					if (teachers[l].getId() == idd) {
						teachers[l].printInfo();
						found=true ;
					}
				}
			if (!found) System.out.println("ID does not exist ! try again");
			}
			
			else if (selection == 2) {
				// calculate the total salary for each teacher 
				// total salary = basic salary + extra payment 
				for (int a = 0; a < teachers.length; a++) {
					System.out.print("The teacher \"" + teachers[a].getName()+"\"");
					double total = teachers[a].getBasicSalary() + teachers[a].calculateExtraPaymen();
					System.out.println(" has a Total Salary"+" : " + total+" $");
				}

			}
			
			else if (selection == 3) {
				// change the value of basic salary for a teacher using id entered by the user 
				System.out.print("Enter the id of the teacher you want to change his basic salary >>> ");
				int id = input.nextInt();
				// boolean flag to check if the id exists or not 
				boolean found = false ;
				for (int u = 0; u < teachers.length; u++) {
					if (teachers[u].getId() == id) {
						System.out.print("Enter the new value of basic salary >>> ");
						teachers[u].setBasicSalary(input.nextDouble());
						found = true ;
					}
				}
				if (!found) System.out.println("ID does not exist ! try again");
			}
			
			else if (selection == 4) {
				// calculate the sum of all teachers salaries (including extra payment) 
				double sum = 0;
				for (int y = 0; y < teachers.length; y++) {
					double total = teachers[y].getBasicSalary() + teachers[y].calculateExtraPaymen();
					sum += (total);
				}
				System.out.println("The total salaries for all teachers : " + sum+" $");
			}
			
			else if (selection == 5) {
				// exit the programme
				System.out.println("Thank you for using my programme , Good buy :( ");
				break;
			} 
			else
				System.out.println("Invalid input !"); // if the selection is not between (1-5) 
		}
	}
}
