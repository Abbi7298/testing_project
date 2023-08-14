package com.nagarro.main;
import com.nagarro.util.CSVtoDB;
import java.util.*;


import com.nagarro.util.Tshirtinforeader;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ch = null;
		boolean flag = true;
		String color;
		String gender;
		String size;
		String preference;
		String fileName = "";

		do {
			System.out.println("Project Started");
			CSVtoDB obj = new CSVtoDB();
			try {
			obj.pushToDatabase();
			}catch(Exception e) {
				System.out.print("");
			}


			System.out.print("\nEnter Color :  ");
			color = sc.nextLine();
			System.out.println("Enter Gender: (M/F/U)");
			gender = sc.nextLine();
			System.out.println("Enter Size : (S/M/L/XL/XXL)");
			size = sc.nextLine();
			System.out.println("Enter Preference : rating / price");
			preference = sc.nextLine();

			try {
				Tshirtinforeader threadObj = new Tshirtinforeader();
				threadObj.input(color, gender, size, preference, fileName);
//				threadObj.run();
				
				threadObj.start();
			} catch (Exception e) {

				e.printStackTrace();
			}

			System.err.println("Continue : y/n ");
			ch = sc.nextLine();

			if (ch.equalsIgnoreCase("y")) {
				flag = true;
			} else {
				System.out.print("Exit");
				flag = false;
			}

		} while (flag);
		sc.close();
	}
}
