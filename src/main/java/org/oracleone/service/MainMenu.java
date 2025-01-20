package org.oracleone.service;

import com.google.gson.Gson;
import org.oracleone.model.ExchangeRecord;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {

    private final Connection connection;
    private final Gson gson;

    private ExchangeRecord exchangeRecord;

    public void mainMenu(){
        Scanner scn = new Scanner(System.in);
        int input = 0;
        double amount = 0;
        boolean validInput;
        do {
            System.out.println("========================");
            System.out.println("Welcome to the exchange");
            System.out.println("1. ARS to USD");
            System.out.println("2. USD to ARS");
            System.out.println("3. BRL to USD");
            System.out.println("4. USD to BRL");
            System.out.println("5. COP to USD");
            System.out.println("6. USD to COP");
            System.out.println("7. Exit.");
            System.out.println("=======================");
            validInput=false;
            while (!validInput) {
                System.out.print("Please enter a number: \n");
                try {
                    input = scn.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scn.next();
                }
            }

            switch (input){
                case 1:
                    this.exchangeRecord = getExchangeRecordEntity("USD","ARS");
                    System.out.println("=================== INFO =====================");
                    System.out.println("The current exchange rate is " + this.exchangeRecord.exchangeRateToString()+"||");
                    System.out.println("=================== INFO =====================");
                    System.out.println("Please provide the amount you want to exchange (ARS -> USD)");
                    try{
                        amount = scn.nextDouble();
                    }
                    catch (InputMismatchException e){
                        System.out.println("Invalid amount");
                    }
                    System.out.println("==============================================================");
                    System.out.println("You will receive approximately "
                            + this.exchangeRecord.baseCurrency() + String.format("%.5f",calculator(amount))
                            + " from " + this.exchangeRecord.targetCurrency() + amount);
                    System.out.println("==============================================================");
                    break;
                case 2:
                    this.exchangeRecord = getExchangeRecordEntity("ARS","USD");
                    System.out.println("=================== INFO =====================");
                    System.out.println("The current exchange rate is " + this.exchangeRecord.exchangeRateToString()+"||");
                    System.out.println("=================== INFO =====================");
                    System.out.println("Please provide the amount you want to exchange (USD -> ARS)");
                    try{
                        amount = scn.nextDouble();
                    }
                    catch (InputMismatchException e){
                        System.out.println("Invalid amount");
                    }
                    System.out.println("==============================================================");
                    System.out.println("You will receive approximately "
                            + this.exchangeRecord.baseCurrency() + String.format("%.5f",calculator(amount))
                            + " from " + this.exchangeRecord.targetCurrency() + amount);
                    System.out.println("==============================================================");
                    break;
                case 3:
                    this.exchangeRecord = getExchangeRecordEntity("USD","BRL");
                    System.out.println("=================== INFO =====================");
                    System.out.println("The current exchange rate is " + this.exchangeRecord.exchangeRateToString()+"||");
                    System.out.println("=================== INFO =====================");
                    System.out.println("Please provide the amount you want to exchange (Brazilian Real -> USD)");
                    try{
                        amount = scn.nextDouble();
                    }
                    catch (InputMismatchException e){
                        System.out.println("Invalid amount");
                    }
                    System.out.println("==============================================================");
                    System.out.println("You will receive approximately "
                            + this.exchangeRecord.baseCurrency() + String.format("%.5f",calculator(amount))
                            + " from " + this.exchangeRecord.targetCurrency() + amount);
                    System.out.println("==============================================================");
                    break;
                case 4:
                    this.exchangeRecord = getExchangeRecordEntity("BRL","USD");
                    System.out.println("=================== INFO =====================");
                    System.out.println("The current exchange rate is " + this.exchangeRecord.exchangeRateToString()+"||");
                    System.out.println("=================== INFO =====================");
                    System.out.println("Please provide the amount you want to exchange (USD -> Brazilian Real)");
                    try{
                        amount = scn.nextDouble();
                    }
                    catch (InputMismatchException e){
                        System.out.println("Invalid amount");
                    }
                    System.out.println("==============================================================");
                    System.out.println("You will receive approximately "
                            + this.exchangeRecord.baseCurrency() + String.format("%.5f",calculator(amount))
                            + " from " + this.exchangeRecord.targetCurrency() + amount);
                    System.out.println("==============================================================");
                    break;
                case 5:
                    this.exchangeRecord = getExchangeRecordEntity("USD","COP");
                    System.out.println("=================== INFO =====================");
                    System.out.println("The current exchange rate is " + this.exchangeRecord.exchangeRateToString()+"||");
                    System.out.println("=================== INFO =====================");
                    System.out.println("Please provide the amount you want to exchange (Colombian peso (COP) -> USD)");
                    try{
                        amount = scn.nextDouble();
                    }
                    catch (InputMismatchException e){
                        System.out.println("Invalid amount");
                    }
                    System.out.println("==============================================================");
                    System.out.println("You will receive approximately "
                            + this.exchangeRecord.baseCurrency() + String.format("%.5f",calculator(amount))
                            + " from " + this.exchangeRecord.targetCurrency() + amount);
                    System.out.println("==============================================================");
                    break;
                case 6:
                    System.out.println("=================== INFO =====================");
                    System.out.println("The current exchange rate is " + this.exchangeRecord.exchangeRateToString()+"||");
                    System.out.println("=================== INFO =====================");
                    this.exchangeRecord = getExchangeRecordEntity("COP","USD");
                    System.out.println("Please provide the amount you want to exchange (USD -> Colombia peso (COP))");
                    try{
                        amount = scn.nextDouble();
                    }
                    catch (InputMismatchException e){
                        System.out.println("Invalid amount");
                    }
                    System.out.println("==============================================================");
                    System.out.println("You will receive approximately "
                            + this.exchangeRecord.baseCurrency() + String.format("%.5f",calculator(amount))
                            + " from " + this.exchangeRecord.targetCurrency() + amount);
                    System.out.println("==============================================================");
                    break;
            }

        }while (input != 7);

    }

    public MainMenu(Connection connection, Gson gson) {
        this.connection = connection;
        this.gson = gson;
    }

    private ExchangeRecord getExchangeRecordEntity(String baseCurrency, String targetCurrency){
        String json = connection.
                getConnection("https://v6.exchangerate-api.com/v6/708e1b0c5966ca20f3d86ddd/pair/"+baseCurrency+"/"+targetCurrency);
        return gson.fromJson(json, ExchangeRecord.class);
    }

    //This method calculates the exchange from Currency 1 to Currency 2
    private double calculator(double amount){
        return amount/this.exchangeRecord.exchangeRate();
    }

}
