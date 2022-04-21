import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainFrame extends JFrame implements ActionListener{

    ImageIcon images[];
    JButton next, prev;

    public void initialize(User user){
       

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(0, 2, 5, 5));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        infoPanel.add(new JLabel("Name"));
        infoPanel.add(new JLabel(user.name));
        infoPanel.add(new JLabel("Email"));
        infoPanel.add(new JLabel(user.email));

        infoPanel.add(new JLabel("Phone"));
        infoPanel.add(new JLabel(user.phone));

        infoPanel.add(new JLabel("Address"));
        infoPanel.add(new JLabel(user.address));

        Component[] labels = infoPanel.getComponents();
        for(int i = 0; i < labels.length; i++){
            labels[1].setFont(new Font("Segoe print", Font.BOLD, 18));
        }

        add(infoPanel, BorderLayout.NORTH);

        JPanel sliderPanel = new JPanel();


        add(sliderPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        next = new JButton(">>");
        prev = new JButton("<<");
        buttonPanel.add(next);
        buttonPanel.add(prev);
        next.addActionListener(this);
        prev.addActionListener(this);

        add(buttonPanel, BorderLayout.SOUTH);



        setTitle("Dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

}
