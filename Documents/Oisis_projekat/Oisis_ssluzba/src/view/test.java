package view;

import java.io.IOException;

import model.Entiteti;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test");
		try {
			Entiteti.getInstance().desrializeToXML();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainFrame.getInstance();
	}
}
