import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

// PAGE 2
public class AppPro2 extends AppPro4 implements ActionListener {
    JFrame jf;
    JTextField t1, t2;
    JLabel l1, l2, l3, l4, l5, l6;
    JButton b1, b2;
    JRadioButton r1, r2;

    String[] boardingoptions = { "Ahmedabad", "Rajkot", "Surat", "Vadodara", "Dwarka" };
    JComboBox<String> c1 = new JComboBox<>(boardingoptions);

    String[] destinationoptions = { "Rajkot", "Surat", "Vadodara", "Dwarka", "Ahmedabad" };
    JComboBox<String> c2 = new JComboBox<>(destinationoptions);

    public AppPro2() {
        jf = new JFrame("Travel Information");
        jf.setSize(550, 500);
        jf.setLayout(null);
        jf.setVisible(true);

        Color myaqua = new Color(0, 225, 125);
        Color myaquamarine = new Color(0, 225, 225);
        Color mynavy = new Color(0, 68, 69);
        jf.getContentPane().setBackground(myaqua);
        jf.setLocationRelativeTo(null);

        t1 = new JTextField("2022-06-");
        t2 = new JTextField();

        b1 = new JButton("BUY TICKET");
        b2 = new JButton("HOME PAGE");
        b1.setBackground(myaquamarine);
        b2.setBackground(myaquamarine);

        l1 = new JLabel("Boarding City");
        l2 = new JLabel("Destination");
        l3 = new JLabel("Date of Travel");
        l4 = new JLabel("GCMT TRAVELS");
        l5 = new JLabel("ID");
        l6 = new JLabel("_________________________________________________________________________");

        r1 = new JRadioButton("A.C. Coach");
        r2 = new JRadioButton("Non - A.C. Coach");
        r1.setBackground(mynavy);
        r2.setBackground(mynavy);
        r1.setForeground(Color.WHITE);
        r2.setForeground(Color.WHITE);

        l4.setFont(new Font("Algerian", Font.BOLD, 40));

        l1.setFont(new Font("Modern No. 20", Font.BOLD, 23));
        l2.setFont(new Font("Modern No. 20", Font.BOLD, 23));
        l3.setFont(new Font("Modern No. 20", Font.BOLD, 23));
        l5.setFont(new Font("Modern No. 20", Font.BOLD, 23));

        b1.setFont(new Font("Dubai", Font.ITALIC, 22));
        b2.setFont(new Font("Dubai", Font.ITALIC, 22));

        t1.setFont(new Font("Copperplate Gothic", Font.BOLD, 18));
        t2.setFont(new Font("Copperplate Gothic", Font.BOLD, 18));

        c1.setFont(new Font("Copperplate Gothic", Font.BOLD, 20));
        c2.setFont(new Font("Copperplate Gothic", Font.BOLD, 20));

        r1.setFont(new Font("Copperplate Gothic", Font.PLAIN, 18));
        r2.setFont(new Font("Copperplate Gothic", Font.PLAIN, 18));

        jf.add(t1);
        jf.add(t2);

        jf.add(b1);
        jf.add(b2);

        jf.add(l1);
        jf.add(l2);
        jf.add(l3);
        jf.add(l4);
        jf.add(l5);
        jf.add(l6);

        jf.add(r1);
        jf.add(r2);

        jf.add(c1);
        jf.add(c2);

        l4.setBounds(100, 25, 300, 50);
        l6.setBounds(100, 45, 300, 50);

        l5.setBounds(50, 125, 175, 30);
        t2.setBounds(250, 125, 175, 30);

        l1.setBounds(50, 175, 175, 30);
        c1.setBounds(250, 175, 175, 30);

        l2.setBounds(50, 225, 175, 30);
        c2.setBounds(250, 225, 175, 30);

        l3.setBounds(50, 275, 175, 30);
        t1.setBounds(250, 275, 175, 30);

        r1.setBounds(50, 325, 175, 30);
        r2.setBounds(250, 325, 175, 30);

        b1.setBounds(15, 375, 210, 35);
        b2.setBounds(260, 375, 210, 35);

        b1.addActionListener(this);
        b2.addActionListener(this);

    }

    public static void main(String[] args) {
        new AppPro2();
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
            System.out.println("Buy Ticket Button Pressed");
            Object bcity = c1.getSelectedItem();
            Object dcity = c2.getSelectedItem();
            String bc, dc, ac = "";
            int addAC = 0;
            bc = (String) bcity;
            dc = (String) dcity;

            if (r1.isSelected()) {
                ac = "YES";
                addAC = 100;
            }
            if (r2.isSelected()) {
                ac = "NO";
            }

            AppPro4 ap = new AppPro4();
            int finalprice = ap.billcalculation(bc, dc, addAC);
            int distance = ap.distancecalculation(bc, dc);
            String busstation = ap.pickupplace(bc);

            String date = t1.getText();
            int id = Integer.parseInt(t2.getText());

            System.out.println("Route : " + bcity + " to " + dcity);

            try {
                Connection conn = AppPro2.createConnection();
                String sql = "UPDATE travels SET origin=?,destination=?,dateofboard=?,fairprice=?,AC=?,distance=?,pickuppoint=? WHERE id=?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setObject(1, bcity);
                pst.setObject(2, dcity);
                pst.setString(3, date);
                pst.setInt(4, finalprice);
                pst.setString(5, ac);
                pst.setInt(6, distance);
                pst.setString(7, busstation);
                pst.setInt(8, id);
                pst.executeUpdate();
                System.out.println("Journey Route Selected");
            } catch (Exception e2) {
                System.out.println(" Exception  caught : " + e2);
            }
            new AppPro3();
        }
        if (e.getSource() == b2) {
            new AppPro1();
        }
    }

}
