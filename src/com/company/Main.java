package com.company;

import java.sql.Time;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

		Bank bank = new Bank();
		bank.showPartOfAccounts(10);
		do {
			bank.searchClientByAccount();
		}while(needToRepeat());

	}

	private static boolean needToRepeat() {
		IOController.println("Повторить поиск? (напишите \"да\" для подтверждения)");
		String userInput = IOController.getInputString();
		return userInput.trim().equalsIgnoreCase("да");
	}


}
