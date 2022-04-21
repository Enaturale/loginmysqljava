import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainFrame extends JFrame implements ActionListener{

    ImageIcon images[];
    JButton next, prev;
    JLabel imageLabel;
    int i,l1;

    public void initialize(User user){
       

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(0, 2, 2, 2));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 20));

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
        images = new ImageIcon[4];
        images[0] = new ImageIcon("C:/Users/User/Documents/portfolio/java/loginmysql/src/saisho.jpg");
        images[1] = new ImageIcon("C:/Users/User/Documents/portfolio/java/loginmysql/src/blender.jpg");
        images[2] = new ImageIcon("C:/Users/User/Documents/portfolio/java/loginmysql/src/t55.jpg");
        images[3] = new ImageIcon("C:/Users/User/Documents/portfolio/java/loginmysql/src/watch.jpg");

        imageLabel = new JLabel(" ", JLabel.CENTER);
        imageLabel.setIcon(images[0]);

        add(sliderPanel, BorderLayout.CENTER);
        sliderPanel.add(imageLabel);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        next = new JButton("<<");
        prev = new JButton(">>");
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

        if(e.getSource() == next){
            if(i == 0){
                
            }else{
                i = i - 1;
                imageLabel.setIcon(images[i]);
            }
        }

        if(e.getSource() == prev){
            if(i==images.length-1)
        {
            //JOptionPane.showMessageDialog(null,"This is LastImage");
        }
        else
            {
            i=i+1;
            imageLabel.setIcon(images[i]);
            }
        }
        }
        
    }


