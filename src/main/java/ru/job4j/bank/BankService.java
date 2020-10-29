package ru.job4j.bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        Set<User> userSet = users.keySet();
        if (!userSet.contains(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {


                accounts.add(account);
            }
        }

    }

    public User findByPassport(String passport) {
        Set<User> userSet = users.keySet();
        for (User user : userSet) {
            if (Objects.equals(user.getPassport(), passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (Objects.equals(account.getRequisite(), requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport,srcRequisite);
        Account destAccount = findByRequisite(destPassport,destRequisite);
        if(srcAccount != null && destAccount!= null){
            if(srcAccount.getBalance()>=amount){
                srcAccount.setBalance(srcAccount.getBalance()-amount);
                destAccount.setBalance(destAccount.getBalance()+amount);
              rsl = true;
            }
        }

        return rsl;
    }
}