import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

// PAGE 1 
public class AppPro1 implements ActionListener {
    JFrame jf;
    JTextField t1, t2, t3;
    JLabel l1, l2, l3, l4, l5, l6;
    JButton b1, b2, b3, b4;
    int newid;

    public AppPro1() {
        jf = new JFrame("Bus Transport Service");
        jf.setSize(575, 500);
        jf.setLayout(null);
        jf.setVisible(true);

        Color myaqua = new Color(0, 225, 125);
        Color myaquamarine = new Color(0, 225, 225);

        jf.getContentPane().setBackground(myaqua);
        jf.setLocationRelativeTo(null);

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();

        b1 = new JButton("Insert");
        b2 = new JButton("Search ID");
        b3 = new JButton("Delete");
        b4 = new JButton("Reset");

        b1.setBackground(myaquamarine);
        b2.setBackground(myaquamarine);
        b3.setBackground(myaquamarine);
        b4.setBackground(myaquamarine);

        l1 = new JLabel("ID");
        l2 = new JLabel("NAME");
        l3 = new JLabel("AGE");
        l4 = new JLabel("GCMT TRAVELS");
        l5 = new JLabel("Login PAGE");
        l6 = new JLabel("_________________________________________________________________________");

        l4.setFont(new Font("Algerian", Font.BOLD, 40));
        l5.setFont(new Font("Lucida Calligraphy", Font.BOLD, 30));
        l1.setFont(new Font("Modern No. 20", Font.BOLD, 25));
        l2.setFont(new Font("Modern No. 20", Font.BOLD, 25));
        l3.setFont(new Font("Modern No. 20", Font.BOLD, 25));

        b1.setFont(new Font("Dubai", Font.ITALIC, 20));
        b2.setFont(new Font("Dubai", Font.ITALIC, 20));
        b3.setFont(new Font("Dubai", Font.ITALIC, 20));
        b4.setFont(new Font("Dubai", Font.ITALIC, 20));

        t1.setFont(new Font("Copperplate Gothic", Font.BOLD, 22));
        t2.setFont(new Font("Copperplate Gothic", Font.BOLD, 22));
        t3.setFont(new Font("Copperplate Gothic", Font.BOLD, 22));

        jf.add(t1);
        jf.add(t2);
        jf.add(t3);

        jf.add(b1);
        jf.add(b2);
        jf.add(b3);
        jf.add(b4);

        jf.add(l1);
        jf.add(l2);
        jf.add(l3);
        jf.add(l4);
        jf.add(l5);
        jf.add(l6);

        l4.setBounds(130, 25, 300, 50);
        l6.setBounds(130, 45, 300, 50);
        l5.setBounds(155, 90, 300, 50);

        l1.setBounds(120, 175, 120, 30);
        t1.setBounds(255, 175, 200, 30);

        l2.setBounds(120, 220, 120, 30);
        t2.setBounds(255, 220, 200, 30);

        l3.setBounds(120, 265, 120, 30);
        t3.setBounds(255, 265, 200, 30);

        b1.setBounds(130, 335, 125, 35);
        b2.setBounds(280, 335, 125, 35);
        b3.setBounds(130, 385, 125, 35);
        b4.setBounds(280, 385, 125, 35);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }

    public static void main(String[] args) {
        new AppPro1();
    }

    public static Connection createConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/capstone", "root", "");
        } catch (Exception e) {
            System.out.println("Exception Caught : " + e);
        }
        return conn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            System.out.println("Insert Button Pressed");
            String nm = t2.getText();
            int age = Integer.parseInt(t3.getText());

            try {
                Connection conn = AppPro1.createConnection();
                String sql = "insert into travels(name,age)values(?,?)";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, nm);
                pst.setInt(2, age);
                pst.executeUpdate();
                System.out.println("Data Inserted");
                t2.setText("");
                t3.setText("");
            } catch (Exception e2) {
                System.out.println("Insert Exception : " + e2);
            }
            new AppPro2();
        }

        else if (e.getSource() == b2) {
            System.out.println("Search ID button Pressed");
            int id = Integer.parseInt(t1.getText());

            try {
                Connection conn = AppPro1.createConnection();
                String sql = "select name,age from travels where id=?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("age"));
                    System.out.println("Data Entry Displayed");
                } else {
                    System.out.println("ID not Found");
                }

            } catch (Exception e2) {
                System.out.println("Select Exception : " + e2);
            }
        }

        else if (e.getSource() == b3) {
            System.out.println("Delete Button Pressed");
            int id = Integer.parseInt(t1.getText());
            try {
                Connection conn = AppPro1.createConnection();
                String sql = "delete from travels where id=?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, id);
                pst.executeUpdate();
                t1.setText("");
                t2.setText("");
                t3.setText("");
            } catch (Exception e2) {
                System.out.println("Delete Exception : " + e2);
            }

        } else if (e.getSource() == b4) {
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }

    }
}
