package com.company.controllers;

import com.company.models.Account;
import com.company.models.Client;
import com.company.utils.IO;

import java.util.List;
import java.util.Map;

public class ClientController {

    static public void showAccounts(Client client) {

        Map<Long, Account> accounts = client.getAccounts();
        accounts.forEach((k, v) -> IO.println(v.toString(), IO.FontColor.ANSI_GREEN));

    }
}
