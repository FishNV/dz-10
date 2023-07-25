package cc.robotdreams;

import cc.robotdreams.exceptions.WrongAccountException;
import cc.robotdreams.exceptions.WrongCurrencyException;
import cc.robotdreams.exceptions.WrongOperationException;

public class Main {
    static BankApplication bankApplication = new BankApplication();

    static public void main(String[] args){

        processWrapper("accountId000", 50, "USD");
        processWrapper("accountId003", 250, "HRV");
        processWrapper("accountId001", 50, "EUR");
        processWrapper("accountId001", 50, "USD");
        processWrapper("accountId001", 2000, "USD");
    }

    public static void processWrapper(String accountId, int amount, String currency) {
        try {
            bankApplication.process(accountId, amount, currency);
        } catch (WrongAccountException e) {
            System.err.println("Такого акаунту не існує");
        } catch (WrongCurrencyException e) {
            System.err.println("Акаунт має рахунок в іншій валюті");
        } catch (WrongOperationException e) {
            System.err.println("Акаунт не має достатньо коштів");
        } catch (Exception e) {
            System.err.println("Сталася помилка при процесінгу, спробуйте ще раз");
        }
    }
}

