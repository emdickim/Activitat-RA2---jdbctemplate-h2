package com.ra2.jdbctemplate_h2.model;

public class Customer {
	private long id;
	private String firstName, lastName;
	private int age, year;
	private String cicle;
	
	/*age (number)
cicle (string)
year (number)
*/
	//Costructor sense argumets per a treballar amb JPA i JDBC Template
	public Customer() {
		
	}
	
	public Customer(long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	// Getters
    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public int getAge() {
		return age;
	}
    public void setAge(int age) {
		this.age = age;
	}

	public int getYear() {
		return year;
	}
	public String getCicle() {
		return cicle;
	}

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	public void setYear(int year) {
		this.year = year;
	}

	public void setCicle(String cicle) {
		this.cicle = cicle;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Customer[id=%d, firstName='%s', lastName='%s', age='%d', year='%d', cicle='s%']",
				id, firstName, lastName, age, year, cicle);
	}

}