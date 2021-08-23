package com.company;

import com.company.controllers.BankController;
import com.company.utils.DataGenerator;
import com.company.utils.IO;
import com.company.models.Bank;

//TODO: разбить на пакеты (уже разбил)

public class Main {

    public static void main(String[] args) {

		Bank bank = new Bank();
		// TODO: из конструктора Bank перенести сюда - CustomGenerator.generateClients(this);
		BankController.generateClients(bank);
		BankController.showPartOfAccounts(bank, 10);
		do {
			BankController.searchClientByAccount(bank);
		}while(needToRepeat());

	}

	private static boolean needToRepeat() {
		IO.println("Повторить поиск? (напишите \"да\" для подтверждения)");
		String userInput = IO.getInputString();
		return userInput.trim().equalsIgnoreCase("да");
	}


}
