package assigment.main;

import java.text.ParseException;

import assigment.controller.Controller;
import assigment.utils.DateException;
import assigment.utils.EmailFormatException;

public class Main {
	public static void main(String[] args) throws ParseException, DateException, EmailFormatException {
		Controller main = new Controller();
		main.control();
	}
}
