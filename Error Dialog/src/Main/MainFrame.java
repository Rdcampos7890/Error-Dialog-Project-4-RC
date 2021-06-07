package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * MainFrame class, responsible for all the visuals of the program and for reading the user's input.
 */
public class MainFrame implements ActionListener{

    public static JFrame mainFrame;
    private JButton add;
    private JButton remove;
    private JButton random;
    private JButton display;
    private JButton count;
    private JButton search;
    private JLabel mainPic;
    private ImageIcon mainIcon;
    private ImageIcon PokeBall;

    /*
     * Initializes all the visual components which allow the user to interact with the program. 
     */
    public MainFrame() {

        add = new JButton();
        add.setBounds(400, 500, 400, 150);
        add.addActionListener(this);
        add.setText("Add MSG");
        add.setFocusable(false);
        add.setHorizontalTextPosition(JButton.CENTER);
        add.setFont(new Font("Calibre", Font.BOLD, 25));
        add.setForeground(Color.CYAN);
        add.setBackground(Color.BLACK);
        remove = new JButton();
        remove.setBounds(800, 500, 400, 150);
        remove.addActionListener(this);
        remove.setText("Remove MSG");
        remove.setFocusable(false);
        remove.setHorizontalTextPosition(JButton.CENTER);
        remove.setFont(new Font("Calibre", Font.BOLD, 25));
        remove.setForeground(Color.CYAN);
        remove.setBackground(Color.BLACK);
        random = new JButton();
        random.setBounds(800, 650, 400, 150);
        random.addActionListener(this);
        random.setText("Random Des");
        random.setFocusable(false);
        random.setHorizontalTextPosition(JButton.CENTER);
        random.setFont(new Font("Calibre", Font.BOLD, 25));
        random.setForeground(Color.CYAN);
        random.setBackground(Color.BLACK);
        display = new JButton();
        display.setBounds(0, 500, 400, 150);
        display.addActionListener(this);
        display.setText("Display MSGs");
        display.setFocusable(false);
        display.setHorizontalTextPosition(JButton.CENTER);
        display.setFont(new Font("Calibre", Font.BOLD, 25));
        display.setForeground(Color.CYAN);
        display.setBackground(Color.BLACK);
        count = new JButton();
        count.setBounds(400, 650, 400, 150);
        count.addActionListener(this);
        count.setText("Get Count");
        count.setFocusable(false);
        count.setHorizontalTextPosition(JButton.CENTER);
        count.setFont(new Font("Calibre", Font.BOLD, 25));
        count.setForeground(Color.CYAN);
        count.setBackground(Color.BLACK);
        search = new JButton();
        search.setBounds(0, 650, 400, 150);
        search.addActionListener(this);
        search.setText("Search MSG");
        search.setFocusable(false);
        search.setHorizontalTextPosition(JButton.CENTER);
        search.setFont(new Font("Calibre", Font.BOLD, 25));
        search.setForeground(Color.CYAN);
        search.setBackground(Color.BLACK);


        mainIcon = new ImageIcon(getClass().getResource("Hacker.png"));
        Image imageSizeMainIcon = mainIcon.getImage();

        Image modifiedMainIcon = imageSizeMainIcon.getScaledInstance(1200, 500, java.awt.Image.SCALE_SMOOTH);
        mainIcon = new ImageIcon(modifiedMainIcon);

        mainPic = new JLabel();
        mainPic.setText("WELCOME TO THE MATRIX");
        mainPic.setBounds(0, 0, 1200, 500);
        mainPic.setIcon(mainIcon);
        mainPic.setHorizontalTextPosition(JLabel.CENTER);
        mainPic.setVerticalTextPosition(JLabel.CENTER);
        mainPic.setFont(new Font("Calibre", Font.BOLD, 50));
        mainPic.setForeground(Color.WHITE);

        mainFrame = new JFrame();
        mainFrame.setTitle("Welcome to the Matrix");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setLayout(null);
        mainFrame.setSize(1200, 825);
        PokeBall = new ImageIcon(getClass().getResource("Skull.jpg"));
        mainFrame.setIconImage(PokeBall.getImage());
        mainFrame.getContentPane().setBackground(Color.BLACK);
        mainFrame.setBackground(Color.BLACK);
        mainFrame.add(mainPic);
        mainFrame.setBackground(Color.BLACK);
        mainFrame.add(add);
        mainFrame.add(remove);
        mainFrame.add(search);
        mainFrame.add(count);
        mainFrame.add(random);
        mainFrame.add(display);
        mainFrame.setLocationRelativeTo(null);

        mainFrame.setVisible(true);
    }

    @Override
    /*
     * Reads which button the user presses and calls upon the corresponding\
     * method for the action the user wants to take.
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() ==  display) {
            FullMessages.showMessages();
        }
        else if(e.getSource() ==  count) {
            FullMessages.showCount();
        }
        else if(e.getSource() ==  search) {
            FullMessages.search();
        }
        else if(e.getSource() ==  random) {
            FullMessages.addRandomDes();
        }
        else if(e.getSource() ==  remove) {
            FullMessages.remove();
        }
        else if(e.getSource() ==  add) {
            FullMessages.addMessage();
        }
    }
}