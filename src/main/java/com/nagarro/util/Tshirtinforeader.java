package com.nagarro.util;

import java.util.*;

import com.nagarro.dao.ConnectDB;

public class Tshirtinforeader extends Thread {
	Scanner sn = new Scanner(System.in);

	String preference = "";
	String color;
	String gender;
	String size;
	String fileName;

	public void input(String color, String gender, String size, String preference, String fileName) {
		this.preference = preference;
		this.color = color;
		this.gender = gender;
		this.size = size;
		this.fileName = fileName;
	}

	@Override
	public void run() {
		{
			System.out.println("filtering Started");
			ConnectDB object = new ConnectDB();
			try {
				object.filterOfAllTable(preference, color, size, gender);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {

				Thread.sleep(5000);
			} catch (Exception e) {

			}

		}
	}
}
