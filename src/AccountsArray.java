import accountInfo.Account;

public class AccountsArray {
    public static Account[] accounts_arr;
    public static int no_of_accounts;
    static{
         accounts_arr = new Account[]{
                new Account(),
                new Account(),
                new Account(),
                new Account(),
                new Account()
        };
         no_of_accounts = 0;
    }
}
