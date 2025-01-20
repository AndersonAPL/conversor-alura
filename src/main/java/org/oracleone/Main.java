package org.oracleone;

import com.google.gson.Gson;
import org.oracleone.service.Connection;
import org.oracleone.service.MainMenu;

public class Main {
    public static void main(String[] args) {
        MainMenu menu = new MainMenu(new Connection(), new Gson());
        menu.mainMenu();
    }
}