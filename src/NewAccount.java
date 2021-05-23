import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewAccount extends Applet implements ActionListener {

    TextField holder_name;
    CheckboxGroup type_group;
    Checkbox savings,current;
    Button create,back;
    Label label_name;

    @Override
    public void init() {

        holder_name = new TextField();
        type_group = new CheckboxGroup();
        savings = new Checkbox("Savings",type_group,true);
        current = new Checkbox("Current",type_group,false);
        create = new Button("Create");
        back = new Button("Back");
        label_name = new Label("Name:");

        add(holder_name);
        add(savings);
        add(current);
        add(create);
        add(back);
        add(label_name);

        create.addActionListener(this);
        back.addActionListener(this);

    }

    @Override
    public void paint(Graphics g) {
        label_name.setBounds(200,100,80,20);
        label_name.setForeground(Color.WHITE);
        holder_name.setBounds(300,100,140,20);
        savings.setBounds(240,150,80,20);
        savings.setForeground(Color.WHITE);
        current.setBounds(340,150,80,20);
        current.setForeground(Color.WHITE);
        create.setBounds(320,200,80,20);
        create.setBackground(Color.getHSBColor(25,33,100));
        back.setBounds(220,200,80,20);
        back.setBackground(Color.getHSBColor(25,33,100));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==create){
            add_account();
        }
        HomeScreen h = new HomeScreen();
        h.setBounds(0,0,this.getWidth(),this.getHeight());
        removeAll();
        h.init();
        add(h);

    }

    public void add_account(){
        int no_of_acc = AccountsArray.no_of_accounts;
        if(no_of_acc<4){
            String account_number = "190004011" + no_of_acc;
            String holderName = holder_name.getText();
            String account_type;
            if(savings.getState()){
                account_type = "Savings";
            }
            else{
                account_type = "Current";
            }
            AccountsArray.accounts_arr[no_of_acc].acc_no = account_number;
            AccountsArray.accounts_arr[no_of_acc].holder_name = holderName;
            AccountsArray.accounts_arr[no_of_acc].acc_type = account_type;
            AccountsArray.accounts_arr[no_of_acc].acc_bal = 0;
            AccountsArray.no_of_accounts++;
            System.out.println("-> Account Added\n");
            System.out.println("-> Account Number: "+account_number+"\n");
        }
        else{
            System.out.println("Max number of accounts reached");
        }

    }
}
