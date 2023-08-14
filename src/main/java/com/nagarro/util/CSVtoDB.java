package com.nagarro.util;

import java.io.*;


import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.nagarro.model.Tshirt;

public class CSVtoDB {

	public void pushToDatabase() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		File SourceFolder = new File("D:\\workspace\\CSV");
		for (File sourceFile : SourceFolder.listFiles()) {
			
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			
			String fileName = sourceFile.getName();
			System.out.println(fileName);

			fileName = SourceFolder + "\\" + fileName;

			BufferedReader reader = null;
			String line = "";

			try {
				reader = new BufferedReader(new FileReader(fileName));
				int i = 0;
				while ((line = reader.readLine()) != null) {
					if (i == 0) {
						i++;
						continue;
					}
					String[] row = line.split("\\|");
					double price = Double.parseDouble(row[5]);
					double rating = Double.parseDouble(row[6]);

					Tshirt ts = new Tshirt(row[0], row[1], row[2], row[3], row[4], price, rating, row[7]);

					try {
						session.save(ts);

					} catch (Exception e) {
						System.out.println("");
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				try {
					tx.commit();
					reader.close();
					session.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}
}
