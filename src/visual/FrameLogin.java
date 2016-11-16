package visual;

import java.awt.event.*;
import javax.swing.*;
import utiles.ControlLogin;

public class FrameLogin extends JFrame {

	private JButton bIngresar;
	private JButton bRegistrar;
	private JButton bSalir;
	private JPanel bar;
	private JLabel bienvenido;
	private JPasswordField fContraseña1;
	private JTextField fUsuario;
	private JLabel lContraseña;
	private JLabel lUsuario;
	private JLabel pam;

	public FrameLogin() {
		initComponents();
	}

	private void initComponents() {

		bienvenido = new JLabel();
		bIngresar = new JButton();
		bSalir = new JButton();
		fUsuario = new JTextField();
		lUsuario = new JLabel();
		lContraseña = new JLabel();
		fContraseña1 = new JPasswordField();
		bar = new JPanel();
		pam = new JLabel();
		bRegistrar = new JButton();
		
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setBackground(new java.awt.Color(21, 21, 21));

		bienvenido.setFont(new java.awt.Font("Eras Light ITC", 0, 18)); // NOI18N
		bienvenido.setForeground(new java.awt.Color(255, 255, 255));
		bienvenido.setText("          Bienvenido de nuevo ");

		bIngresar.setText("Ingresar");
		bIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bIngresarActionPerformed(evt);
			}
		});

		bSalir.setText("Salir");
		bSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bSalirActionPerformed(evt);
			}
		});

		lUsuario.setFont(new java.awt.Font("Eras Light ITC", 0, 18)); // NOI18N
		lUsuario.setForeground(new java.awt.Color(0, 204, 204));
		lUsuario.setText("          Usuario");

		lContraseña.setFont(new java.awt.Font("Eras Light ITC", 0, 18)); // NOI18N
		lContraseña.setForeground(new java.awt.Color(0, 204, 204));
		lContraseña.setText("        Contraseña");

		bar.setBackground(new java.awt.Color(0, 204, 204));
		bar.setPreferredSize(new java.awt.Dimension(215, 2));

		GroupLayout barLayout = new GroupLayout(bar);
		bar.setLayout(barLayout);
		barLayout.setHorizontalGroup(
				barLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 251, Short.MAX_VALUE));
		barLayout.setVerticalGroup(
				barLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 9, Short.MAX_VALUE));

		pam.setFont(new java.awt.Font("Eras Light ITC", 2, 60)); // NOI18N
		pam.setForeground(new java.awt.Color(0, 204, 204));
		pam.setText("   P.A.M");

		bRegistrar.setText("Registrarse");
		bRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				bRegistrarActionPerformed(evt);
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(147, 147, 147)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(bar, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 251,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(bienvenido, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 251,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(pam, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 251,
								GroupLayout.PREFERRED_SIZE)
						.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup().addComponent(bRegistrar).addGap(40, 40, 40))
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addComponent(fUsuario, GroupLayout.Alignment.LEADING)
										.addComponent(fContraseña1, GroupLayout.Alignment.LEADING)
										.addComponent(lContraseña, GroupLayout.Alignment.LEADING,
												GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lUsuario, GroupLayout.Alignment.LEADING,
												GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createSequentialGroup()
												.addComponent(bIngresar, GroupLayout.PREFERRED_SIZE, 90,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(bSalir, GroupLayout.PREFERRED_SIZE, 65,
														GroupLayout.PREFERRED_SIZE))))
								.addGap(47, 47, 47)))
				.addContainerGap(150, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap(16, Short.MAX_VALUE).addComponent(pam)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(bienvenido, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(bar, GroupLayout.PREFERRED_SIZE, 9, GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18)
						.addComponent(lUsuario).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(fUsuario, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(lContraseña)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(fContraseña1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,20,20)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(bIngresar)
								.addComponent(bSalir))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(bRegistrar)
						.addGap(69, 69, 69)));
		setTitle("Login - P.A.M");
		pack();
		getRootPane().setDefaultButton(bIngresar);
		setVisible(true);
	}

	private void bIngresarActionPerformed(ActionEvent evt) {
		ControlLogin control = new ControlLogin();
		if (control.isUserPass(fUsuario.getText(), String.valueOf(fContraseña1.getPassword()))) {

			FramePrincipal principal = new FramePrincipal(fUsuario.getText());
			dispose();

		} else {

			JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectas", null, JOptionPane.ERROR_MESSAGE);

		}
	}

	private void bSalirActionPerformed(ActionEvent evt) {

		System.exit(0);

	}
	
	private void bRegistrarActionPerformed(ActionEvent evt) {
		FrameRegistro registro = new FrameRegistro();
		dispose();
	}

	

}
