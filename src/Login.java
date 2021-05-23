import java.awt.*;
import java.applet.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends Applet implements ActionListener {

    TextField name,pass;
    Button submit, exit;
    Label label_name, label_pass;

    public void init() {
        setSize(640,360);
        setBackground(Color.darkGray);
        label_name =new Label("Name:");
        label_pass =new Label("Password:");
        name=new TextField();
        pass=new TextField();
        pass.setEchoChar('*');
        submit =new Button("Submit");
        exit =new Button("Exit");

        add(label_name);
        add(name);
        add(label_pass);
        add(pass);
        add(submit);
        add(exit);

        submit.addActionListener(this);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            if(name.getText().equals("admin") && pass.getText().equals("admin")){
                homeScreenPaint();
            }
            else{
                System.out.println("->Invalid credentials\n");
            }
        }
        else{
            System.exit(0);
        }
    }

    public void paint(Graphics g) {
        label_name.setBounds(150,100,90,20);
        label_name.setForeground(Color.white);
        label_pass.setBounds(150,140,90,20);
        label_pass.setForeground(Color.white);
        name.setBounds(250,100,150,20);
        pass.setBounds(250,140,150,20);
        submit.setBounds(300,200,90,30);
        submit.setBackground(Color.getHSBColor(25,33,100));
        exit.setBounds(200,200,90,30);
        exit.setBackground(Color.getHSBColor(25,33,100));
    }

    public void homeScreenPaint(){

        HomeScreen h = new HomeScreen();
        h.setBounds(new Rectangle(0,0,this.getWidth(),this.getHeight()));
        removeAll();
        h.init();
        add(h);

    }

}