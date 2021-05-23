package accountInfo;

public class Account extends Bank{
    public String holder_name, acc_type,acc_no = "-1541";
    public int acc_bal;

    public void displayData(){
        System.out.println("***********");
        System.out.println("Bank name: "+bank_name);
        System.out.println("Account Number: "+acc_no);
        System.out.println("Holder Name: "+holder_name);
        System.out.println("Account type: "+acc_type);
        System.out.println("Balance: Rs."+acc_bal);
        System.out.println("***********");
    }
    public void deposit(int amount){
        acc_bal += amount;
    }
    public void withdraw(int amount){
        if(amount<acc_bal){
            acc_bal -= amount;
            System.out.println("-> Money Withdrawn: Rs."+amount+"\n");
        }
        else{
            System.out.println("-> Insufficient Balance.");
        }

    }
}
