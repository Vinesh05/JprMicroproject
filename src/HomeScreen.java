import accountInfo.Account;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class HomeScreen extends Applet implements ItemListener, ActionListener {

    public Account[] accounts_arr = AccountsArray.accounts_arr;
    CheckboxGroup group;
    Checkbox deposit, withdraw, show_details;
    TextField acc_no, amount;
    Label label_no,label_amount;
    Button proceed, create_acc, exit;

    @Override
    public void init() {

        group = new CheckboxGroup();
        deposit = new Checkbox("Deposit",group,true);
        withdraw = new Checkbox("Withdraw",group,false);
        show_details = new Checkbox("Show Details",group,false);
        acc_no = new TextField();
        amount = new TextField();
        label_no = new Label("Account No:");
        label_amount = new Label("Amount:");
        proceed = new Button("Proceed");
        create_acc = new Button("Create New Account");
        exit = new Button("Exit");

        add(deposit);
        add(withdraw);
        add(show_details);
        add(acc_no);
        add(amount);
        add(label_no);
        add(label_amount);
        add(proceed);
        add(create_acc);
        add(exit);

        show_details.addItemListener(this);
        deposit.addItemListener(this);
        withdraw.addItemListener(this);

        proceed.addActionListener(this);
        create_acc.addActionListener(this);
        exit.addActionListener(this);

    }

    @Override
    public void paint(Graphics g) {
        deposit.setBounds(200,100,80,20);
        deposit.setForeground(Color.WHITE);
        withdraw.setBounds(300,100,80,20);
        withdraw.setForeground(Color.WHITE);
        show_details.setBounds(400,100,100,20);
        show_details.setForeground(Color.WHITE);
        acc_no.setBounds(280,150,160,20);
        amount.setBounds(280,200,160,20);
        label_no.setBounds(200,150,80,20);
        label_no.setForeground(Color.WHITE);
        label_amount.setBounds(200,200,80,20);
        label_amount.setForeground(Color.WHITE);
        proceed.setBounds(340,250,80,20);
        proceed.setBackground(Color.getHSBColor(25,33,100));
        create_acc.setBounds(260,50,120,20);
        create_acc.setBackground(Color.getHSBColor(25,33,100));
        exit.setBounds(240,250,80,20);
        exit.setBackground(Color.getHSBColor(25,33,100));
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (show_details.getState()){
            remove(amount);
            remove(label_amount);
        }
        else{
            add(amount);
            add(label_amount);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == proceed){
            if(group.getSelectedCheckbox() == deposit){

                String number = acc_no.getText();
                Account current_acc = search_acc(number);
                if(current_acc!=null){
                    int amount = Integer.parseInt(this.amount.getText());
                    current_acc.deposit(amount);
                    System.out.println("-> Money Deposited: Rs."+amount+"\n");
                }
                else{
                    System.out.println("XX Account not found\n");
                }

            }
            else if(group.getSelectedCheckbox() == withdraw){

                String number = acc_no.getText();
                Account current_acc = search_acc(number);
                if(current_acc!=null){
                    int amount = Integer.parseInt(this.amount.getText());
                    current_acc.withdraw(amount);
                }
                else{
                    System.out.println("XX Account not found\n");
                }

            }
            else{
                String account_number = acc_no.getText();
                Account acc = search_acc(account_number);
                if(acc!=null){
                    acc.displayData();
                }
                else{
                    System.out.println("XX Account not found\n");
                }
            }
        }
        else if(e.getSource() == create_acc){
            NewAccount new_acc = new NewAccount();
            new_acc.setBounds(0,0,this.getWidth(),this.getHeight());
            removeAll();
            new_acc.init();
            add(new_acc);
        }
        else{
            System.exit(0);
        }
    }

    public Account search_acc(String number){
        for (Account acc:accounts_arr) {
            if(acc.acc_no.equals(number)){
                return acc;
            }
        }
        return null;
    }

}
