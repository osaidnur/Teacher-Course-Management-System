/**
 * Name    : Osaid Hasan Nur
 * ID      : 1210733
 * Lecture : 6
 * Lab     : 11L
 */
package ass2;
public class Course {
	// private variables to force user to use setters and getters or the constructor
	private String name;
	private int id;
	// default constructor 
    public Course() {
	}
    // args constructor
    public Course(String name, int id) {
    	// any name with length != 4 will not be defined in the constructor
    	if(name.length() == 4) this.name = name;
		this.id = id;
	}
    // getters and setters : 
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name.length() == 4) 
			this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	// print the information of the object 
	public void printInfo() {
		System.out.println("  Name = " + name);
		System.out.println("  Id = " + id);
	}
}
