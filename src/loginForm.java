import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class loginForm extends JFrame{
    final private Font mainFont= new Font("Segoe print", Font.BOLD, 18);

    public void initialize(){
        JLabel loginformLabel = new JLabel("Login Form", SwingConstants.CENTER);
        loginformLabel.setFont(mainFont);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(mainFont);

        JTextField emailText = new JTextField();
        emailText.setFont(mainFont);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(mainFont);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.add(loginformLabel);
        formPanel.add(emailLabel);
        formPanel.add(emailText);
        formPanel.add(passwordLabel);
        formPanel.add(passwordText);

        //buttons and panel
        JButton loginBtn = new JButton("Login");
        loginBtn.setFont(mainFont);
        loginBtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String email = emailText.getText();
                String password = String.valueOf(passwordText.getPassword());
                
                User user = getAuthenticatedUser(email, password);

                if(user != null){
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.initialize(user);
                    dispose();
                }
                else{
                    JOptionPane.showMessageDialog(loginForm.this,
                         "Email or Password Invalid",
                          "Try Again",
                          JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });
        
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setFont(mainFont);
        cancelBtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                dispose(); 
            }
            
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 0, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(loginBtn);
        buttonsPanel.add(cancelBtn);

        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);

        setSize(400, 500);
        setTitle("Login Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new Dimension(350, 450));
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private User getAuthenticatedUser(String email, String password){
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost/formlogin?serverTimezone=UTC";
        final String USERNAME="root";
        final String PASSWORD ="";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                user = new User();
                user.name = resultSet.getString("name");
                user.email = resultSet.getString("email");
                user.phone = resultSet.getString("phone");
                user.address = resultSet.getString("address");
                user.password = resultSet.getString("password");

            }

            preparedStatement.close();
            conn.close();

        }catch(Exception e){
            System.out.println("Database Connection Failed");
        }

        return user;
    }

    public static void main(String[] args) {
        loginForm loginform = new loginForm();
        loginform.initialize();
    }
    
}
