package view;

import java.io.IOException;

import model.Entiteti;

/**
 * This class implements a main method, deserialization and make instance of
 * main frame
 * 
 * @author Aleksa Papovic
 *
 */
public class test {

	/**
	 * Default constructor which initializes the columns.
	 */
	public test() {
	}

	/**
	 * This is main method in the application
	 * 
	 * @param args arguments of the application
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test");
		try {
			Entiteti.getInstance().deserializeToXML();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainFrame.getInstance();
	}
}
