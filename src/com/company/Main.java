package com.company;

import com.company.utils.IOController;
import com.company.model.Bank;

//TODO: разбить на пакеты (уже разбил)

public class Main {

    public static void main(String[] args) {

		Bank bank = new Bank();
		// TODO: из конструктора Bank перенести сюда - CustomGenerator.generateClients(this);
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
