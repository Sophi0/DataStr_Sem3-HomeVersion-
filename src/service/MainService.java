package service;

import dataStr.MyHeap;
import model.Patient;

public class MainService {

	public static void main(String[] args) {
		try {
		MyHeap intHeap = new MyHeap<>();
		intHeap.add(3);		//P: 3
		intHeap.add(7);		//P: 7, L: 3
		intHeap.add(10);	//P: 10, L: 3, R: 7
		intHeap.add(11);	//P: 11, L: 10, R: 7, P: 10, L: 3
		
		System.out.println("\n-------print--------");
		
		intHeap.print();
		
		System.out.println("\n-------printByPrefix--------");
		
		intHeap.printByPrefix();
		
		System.out.println("\n------remove---------");
		
		System.out.println(intHeap.remove());	//11
		
		System.out.println("\n-------printByPrefix--------");
		
		intHeap.printByPrefix(); //P: 10
		
		System.out.println("\n--------Patient--------");
		
		MyHeap<Patient> hospital = new MyHeap<>();
		hospital.add(new Patient("Janis", "Berzins", 1));
		hospital.add(new Patient("Sofja", "Berzina", 6));
		hospital.add(new Patient("Karina", "Egle", 4));
		hospital.add(new Patient("Jana", "Bera", 10));
		
		System.out.println(hospital.remove());
		System.out.println(hospital.remove());
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
