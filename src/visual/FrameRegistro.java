package visual;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import utiles.ControlLogin;

public class FrameRegistro extends JFrame{
	private JButton bRegister;
	private JButton bSalir;
	private JLabel bienvenido;
	private JPasswordField fPass;
	private JPasswordField fPass2;
	private JTextField fUser;
	private JLabel lPass;
	private JLabel lPass2;
	private JLabel lUser;
	private JPanel panel;
	private JLabel registrarse;
	private JPanel registro;

	public FrameRegistro() {
		initComponents();
	}

	private void initComponents() {
		panel = new JPanel();
		registro = new JPanel();
		registrarse = new JLabel();
		bienvenido = new JLabel();
		bRegister = new JButton();
		bSalir = new JButton();
		fUser = new JTextField();
		lUser = new JLabel();
		lPass = new JLabel();
		lPass2 = new JLabel();
		fPass = new JPasswordField();
		fPass2 = new JPasswordField();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		panel.setBackground(new Color(204, 204, 204));
		panel.setRequestFocusEnabled(false);
		panel.setLayout(new CardLayout());
		registro.setBackground(new Color(21, 21, 21));
		registrarse.setBackground(new Color(0, 204, 204));
		registrarse.setFont(new Font("Eras Light ITC", 2, 48)); // NOI18N
		registrarse.setForeground(new Color(0, 204, 204));
		registrarse.setText("Registrarse!");
		bienvenido.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		bienvenido.setForeground(new Color(255, 255, 255));
		bienvenido.setText("Bienvenido a P.A.M!");
		bRegister.setText("Registrarse");
		bRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bRegisterActionPerformed(evt);
			}
		});
		bSalir.setText("Salir");
		bSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bSalirActionPerformed(evt);
			}
		});
		lUser.setFont(new Font("Eras Light ITC", 0, 18)); // NOI18N
		lUser.setForeground(new Color(0, 204, 204));
		lUser.setText("Usuario");
		lPass.setBackground(new Color(0, 204, 204));
		lPass.setFont(new Font("Eras Light ITC", 0, 18)); // NOI18N
		lPass.setForeground(new Color(0, 204, 204));
		lPass.setText("Contraseña");
		lPass2.setFont(new Font("Eras Light ITC", 0, 18)); // NOI18N
		lPass2.setForeground(new Color(0, 204, 204));
		lPass2.setText("Verificar Contraseña");
		GroupLayout registroLayout = new GroupLayout(registro);
		registro.setLayout(registroLayout);
		registroLayout.setHorizontalGroup(registroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				registroLayout.createSequentialGroup().addContainerGap(272, Short.MAX_VALUE).addGroup(registroLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
								registroLayout.createSequentialGroup().addGap(33, 33, 33).addGroup(registroLayout
										.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(registroLayout.createSequentialGroup().addGap(52, 52, 52)
												.addComponent(lUser))
										.addGroup(registroLayout.createSequentialGroup().addGap(34, 34, 34)
												.addComponent(lPass))
										.addGroup(registroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addComponent(fUser, GroupLayout.PREFERRED_SIZE, 161,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(fPass, GroupLayout.PREFERRED_SIZE, 161,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(registroLayout
												.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
												.addGroup(GroupLayout.Alignment.LEADING,
														registroLayout.createSequentialGroup().addComponent(bRegister)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(bSalir))
												.addComponent(fPass2, GroupLayout.Alignment.LEADING,
														GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
										.addComponent(lPass2)))
						.addComponent(registrarse)).addGap(266, 266, 266))
				.addGroup(registroLayout.createSequentialGroup().addGap(323, 323, 323)
						.addComponent(bienvenido, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		registroLayout
				.setVerticalGroup(registroLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(registroLayout.createSequentialGroup().addContainerGap()
								.addComponent(registrarse, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(bienvenido, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addGap(32, 32, 32).addComponent(lUser)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(fUser, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(lPass)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(fPass, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(lPass2)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(fPass2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addGroup(registroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(bRegister).addComponent(bSalir))
								.addContainerGap(76, Short.MAX_VALUE)));
		panel.add(registro, "card2");
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(0, 0, 0).addComponent(panel, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pack();
		getRootPane().setDefaultButton(bRegister);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private void bRegisterActionPerformed(ActionEvent evt) {
		ControlLogin control = new ControlLogin();
		if (control.añadirUsuario(fUser.getText(), String.valueOf(fPass.getPassword()),
				String.valueOf(fPass2.getPassword()))) {
			FrameLogin login = new FrameLogin();
			dispose();
		}
	}

	private void bSalirActionPerformed(ActionEvent evt) {
		FrameLogin login = new FrameLogin();
		dispose();
	}
}
