package model;

public class Patient {
	private String name;
	private String surname;
	public int prio;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getPrio() {
		return prio;
	}
	public void setPrio(int prio) {
		this.prio = prio;
	}
	
	public Patient() {
		setName("Unknown");
		setSurname("Unknown");
		setPrio(1);
	}
	
	public Patient(String name, String surname, int prio) {
		setName(name);
		setSurname(surname);
		setPrio(prio);
	}
	
	@Override
	public String toString() {
		return ("Patient [name= " + name + ", surname= " + surname + ", prio= " + prio); 
	}
	
}
