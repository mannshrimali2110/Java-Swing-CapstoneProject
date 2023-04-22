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

// PAGE 3
public class AppPro3 implements ActionListener {
    JFrame jf;
    JTextField t1, t2, t3, t6, t7, t8, t9, t10, t11, t12, t13;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14;
    JButton b1, b2, b3;

    public AppPro3() {
        jf = new JFrame("Bus Transport Service");

        jf.setSize(600, 800);
        jf.setLayout(null);
        jf.setVisible(true);
        Color myaqua = new Color(0, 225, 125);
        Color myaquamarine = new Color(0, 225, 225);
        jf.getContentPane().setBackground(myaqua);
        jf.setLocationRelativeTo(null);

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();
        t9 = new JTextField();
        t10 = new JTextField();
        t11 = new JTextField();
        t12 = new JTextField();
        t13 = new JTextField();

        b1 = new JButton("Display Details");
        b1.setBackground(myaquamarine);

        b2 = new JButton("Cancel Reservation");
        b2.setBackground(myaquamarine);
        b3 = new JButton("HOME Page");
        b3.setBackground(myaquamarine);

        l1 = new JLabel("ID");
        l2 = new JLabel("NAME");
        l3 = new JLabel("AGE");
        l4 = new JLabel("GCMT TRAVELS");
        l5 = new JLabel("Passenger Details : ");
        l6 = new JLabel("Boarding City");
        l7 = new JLabel("Destination");
        l8 = new JLabel("Date");
        l9 = new JLabel("Time");
        l10 = new JLabel("Pick - Up Point");
        l11 = new JLabel("Distance");
        l12 = new JLabel("Price");
        l13 = new JLabel("AC Coach");
        l14 = new JLabel("_________________________________________________________________________");

        l4.setFont(new Font("Algerian", Font.BOLD, 40));
        l5.setFont(new Font("Lucida Calligraphy", Font.BOLD, 30));

        l1.setFont(new Font("Modern No. 20", Font.BOLD, 25));
        l2.setFont(new Font("Modern No. 20", Font.BOLD, 25));
        l3.setFont(new Font("Modern No. 20", Font.BOLD, 25));
        l6.setFont(new Font("Modern No. 20", Font.BOLD, 25));
        l7.setFont(new Font("Modern No. 20", Font.BOLD, 25));
        l8.setFont(new Font("Modern No. 20", Font.BOLD, 25));
        l9.setFont(new Font("Modern No. 20", Font.BOLD, 25));
        l10.setFont(new Font("Modern No. 20", Font.BOLD, 25));
        l11.setFont(new Font("Modern No. 20", Font.BOLD, 25));
        l12.setFont(new Font("Modern No. 20", Font.BOLD, 25));
        l13.setFont(new Font("Modern No. 20", Font.BOLD, 25));

        t1.setFont(new Font("Copperplate Gothic", Font.BOLD, 22));
        t2.setFont(new Font("Copperplate Gothic", Font.BOLD, 22));
        t3.setFont(new Font("Copperplate Gothic", Font.BOLD, 22));
        t6.setFont(new Font("Copperplate Gothic", Font.BOLD, 22));
        t7.setFont(new Font("Copperplate Gothic", Font.BOLD, 22));
        t8.setFont(new Font("Copperplate Gothic", Font.BOLD, 22));
        t9.setFont(new Font("Copperplate Gothic", Font.BOLD, 22));
        t10.setFont(new Font("Copperplate Gothic", Font.BOLD, 22));
        t11.setFont(new Font("Copperplate Gothic", Font.BOLD, 22));
        t12.setFont(new Font("Copperplate Gothic", Font.BOLD, 22));
        t13.setFont(new Font("Copperplate Gothic", Font.BOLD, 22));

        b1.setFont(new Font("Lucida Calligraphy", Font.ITALIC, 25));
        b2.setFont(new Font("Lucida Calligraphy", Font.ITALIC, 25));
        b3.setFont(new Font("Lucida Calligraphy", Font.ITALIC, 25));

        jf.add(t1);
        jf.add(t2);
        jf.add(t3);
        jf.add(t6);
        jf.add(t7);
        jf.add(t8);
        jf.add(t9);
        jf.add(t10);
        jf.add(t11);
        jf.add(t12);
        jf.add(t13);

        jf.add(b1);
        jf.add(b2);
        jf.add(b3);

        jf.add(l1);
        jf.add(l2);
        jf.add(l3);
        jf.add(l4);
        jf.add(l5);
        jf.add(l6);
        jf.add(l7);
        jf.add(l8);
        jf.add(l9);
        jf.add(l10);
        jf.add(l11);
        jf.add(l12);
        jf.add(l13);
        jf.add(l14);

        l4.setBounds(120, 25, 300, 50);
        l14.setBounds(120, 45, 300, 50);
        l5.setBounds(100, 100, 500, 50);

        l1.setBounds(45, 175, 175, 30);
        t1.setBounds(245, 175, 275, 30);

        l2.setBounds(45, 210, 175, 30);
        t2.setBounds(245, 210, 275, 30);
        l3.setBounds(45, 245, 175, 30);
        t3.setBounds(245, 245, 275, 30);
        l6.setBounds(45, 280, 175, 30);
        t6.setBounds(245, 280, 275, 30);
        l7.setBounds(45, 315, 175, 30);
        t7.setBounds(245, 315, 275, 30);
        l8.setBounds(45, 350, 175, 30);
        t8.setBounds(245, 350, 275, 30);
        l9.setBounds(45, 385, 175, 30);
        t9.setBounds(245, 385, 275, 30);
        l10.setBounds(45, 420, 175, 30);
        t10.setBounds(245, 420, 275, 30);
        l11.setBounds(45, 455, 175, 30);
        t11.setBounds(245, 455, 275, 30);
        l12.setBounds(45, 515, 175, 30);
        t12.setBounds(245, 515, 150, 30);

        b1.setBounds(95, 600, 350, 35);
        b2.setBounds(95, 650, 350, 35);
        b3.setBounds(95, 700, 350, 35);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

    }

    public static void main(String[] args) {
        new AppPro3();

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

            System.out.println("Search ID button Pressed");
            int id = Integer.parseInt(t1.getText());
            try {
                Connection conn = AppPro1.createConnection();
                String sql = "select * from travels where id=?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("age"));
                    t6.setText(rs.getString("origin"));
                    t7.setText(rs.getString("destination"));
                    t8.setText(rs.getString("dateofboard"));
                    t9.setText("12:00 AM ");
                    t10.setText(rs.getString("pickuppoint"));
                    t11.setText(rs.getString("distance"));
                    t12.setText(rs.getString("fairprice"));
                    t13.setText(rs.getString("AC"));
                    System.out.println("Data Entry Displayed");
                } else {
                    System.out.println("ID not Found");
                }

            } catch (Exception e2) {
                System.out.println("Select Exception : " + e2);
            }

        } else if (e.getSource() == b2) {
            System.out.println("Reservation Cancelled!");
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
                t6.setText("");
                t7.setText("");
                t8.setText("");
                t9.setText("");
                t10.setText("");
                t11.setText("");
                t12.setText("");
                t13.setText("");
            } catch (Exception e2) {
                System.out.println("Delete Exception : " + e2);
            }
        } else if (e.getSource() == b3) {
            new AppPro1();
        }
    }
}
