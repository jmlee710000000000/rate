package rate;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import db.rateDB;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("로그인");
		label.setBounds(180, 0, 59, 18);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(88, 73, 114, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(88, 124, 114, 27);
		contentPane.add(passwordField);
		
		JButton button = new JButton("로그인");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String loginID= textField.getText();
				String loginPW = passwordField.getText();
					System.out.println("로그인아이디:"+loginID);
					System.out.println("로그인비밀번호:"+loginPW);
					
					rateDB db = new rateDB();
					int loginResult = db.login(loginID,loginPW);
					if(loginResult == 1000) {
						MainFrame lf = new MainFrame();
                   lf.setVisible(true);
						setVisible(false);
						System.out.println("로그인성공");
					}else {
						JOptionPane.showMessageDialog(contentPane, "아이디나 비밀번호가 틀립니다", "경고", JOptionPane.WARNING_MESSAGE);
						System.out.println("로그인실패");
					}
			}
		});
		button.setBounds(229, 39, 137, 68);
		contentPane.add(button);
		
		JButton button_1 = new JButton("회원가입");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main2 rf= new Main2();
				rf.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setBounds(224, 119, 142, 37);
		contentPane.add(button_1);
	}
}
