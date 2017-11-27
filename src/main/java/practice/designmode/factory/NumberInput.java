package practice.designmode.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberInput {

	
	public static double captureNumber() {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		String number = null;
		System.out.println(":");
		while (true) {
			try {
				number = buff.readLine();

				if (!number.matches("[0-9]+")) {
					System.out.println("");
				} else
					break;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("!");
				break;
			}
		}
		return Double.parseDouble(number);
	}
	
	public static char captureOperate() {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		String number = null;
		System.out.println(":");
		while (true) {
			try {
				number = buff.readLine();
				if (!number.matches("[\\+\\-\\*/]")) {
					System.out.println("");
				} else
					break;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("!");
				break;
			}
		}
		return number.toCharArray()[0];
	}
	

}
