/**
 * Name    : Osaid Hasan Nur
 * ID      : 1210733
 * Lecture : 6
 * Lab     : 11L
 */
package ass2;
public class Teacher {
	// private variables for data protection
	private String name ; 
	private int id ;
	private double basicSalary ;
	private double extraPaymentRate ;
	private Course []coursesTaught ;
	// default constructor
	public Teacher() {
	}
	// args constructor
	public Teacher(String name , int id , double basicSalary  , double extraPaymentRate , Course[]coursesTaught) {
		this.name = name ;
		this.id = id ;
		this.basicSalary = basicSalary ;
		this.extraPaymentRate = extraPaymentRate ;
		this.coursesTaught = coursesTaught ;
	}
	// Setters and getters : 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public double getExtraPaymentRate() {
		return extraPaymentRate;
	}
	public void setExtraPaymentRate(double extraPaymentRate) {
		this.extraPaymentRate = extraPaymentRate;
	}
	public Course[] getCoursesTaught() {
		return coursesTaught;
	}
	public void setCoursesTaught(Course[] coursesTaught) {
		this.coursesTaught = coursesTaught;
	}
	// print all informations about the teacher
	public void printInfo() {
		System.out.println("-Name = " + name);
		System.out.println("-Id = " + id);
		System.out.println("-Basic Salary = " + basicSalary+" $");
		System.out.println("-Extra Payment Rate = " + extraPaymentRate);
		for (int i =0 ; i< coursesTaught.length ; i++) {
			System.out.println("-Course #"+(i+1)+" :");
			coursesTaught[i].printInfo();
		}
		System.out.print("\n");
	}
	/** calculate the number of courses with specific level in the courses array
	 * 	in this method i used the following way to get the left-most digit of an integer :
	 * 	I found that the number of digits for any integer is log10(number)+1 
	 *  but to find the left-most digit we divide the number by (number of digits - 1) 
	 *  Math.log10() and Math.pow() methods return doubles , so i used casting to get the integer values 
	 *  ###Important Note : if the left most digit of the id is greater than 4 , the level is not calculated 
	 *  and the count will be zero , but i will not make the whole id invalid , because we just calculate 
	`*  the extra payment , if the left most digit of the id is out of range(1-4) we just not calculate extra 
	 *  payment for this level 
	*/ 
	public int countCourseLevel(int level) {
		int count=0 ;
		for (int i=0 ; i< coursesTaught.length ; i++) {
			int id = coursesTaught[i].getId();
			int num_digits_minus1 = (int)Math.log10(id) ;
			int digit = id/(int)Math.pow(10,num_digits_minus1);
			if (digit == level) count++ ;			
		}
		return count ;		
	}
	// Calculate the extra payment money depending on the levels that teachers give
	public double calculateExtraPaymen() {
		double sum = 0 ;
		for (int i = 1 ; i <= 4 ; i++) {
			sum+=(i*extraPaymentRate*countCourseLevel(i));
		}
		return sum ;
		}
	}