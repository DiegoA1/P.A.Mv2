package visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.*;

public class PanelPrincipal extends JPanel {

	private JLabel pam;

	private JButton cartola;
	private JButton resumen;

	private JLabel lUsuario;
	private JLabel lFecha1;

	private JTextField fUsuario;
	private JTextField fFecha;

	private String usuario;

	public PanelPrincipal(String usuario) {

		this.usuario = usuario;
		iniciar();

	}

	public void iniciar() {

		pam = new JLabel();
		pam.setFont(new Font("LM Roman Caps 10", 1, 60)); // NOI18N
		pam.setIcon(new ImageIcon(getClass().getResource("P.A.M.v2/logo.png"))); // NOI18N

		cartola = new JButton();
		cartola.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		cartola.setIcon(new ImageIcon(getClass().getResource("P.A.M.v2/catola.png"))); // NOI18N
		cartola.setText("Cartola");
		cartola.setMaximumSize(new Dimension(50, 17));
		cartola.setMinimumSize(new Dimension(50, 17));
		cartola.setPreferredSize(new Dimension(50, 17));
		cartola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cartolaActionPerformed(evt);
			}
		});

		resumen = new JButton();
		resumen.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		resumen.setIcon(new ImageIcon(getClass().getResource("P.A.M.v2/resumen.png"))); // NOI18N
		resumen.setText("Resumen");
		resumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				resumenActionPerformed(evt);
			}
		});

		lUsuario = new JLabel();
		lUsuario.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lUsuario.setForeground(new Color(0, 204, 204));
		lUsuario.setText("Usuario");

		lFecha1 = new JLabel();
		lFecha1.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lFecha1.setForeground(new Color(0, 204, 204));
		lFecha1.setText("Fecha");

		fUsuario = new JTextField();
		fUsuario.setText(usuario);
		fUsuario.setEditable(false);
		fUsuario.setFocusable(false);

		fFecha = new JTextField();
		fFecha.setEditable(false);
		fFecha.setFocusable(false);

		Calendar c = Calendar.getInstance();
		fFecha.setText(String.valueOf(c.get(Calendar.DATE)) + "/" + String.valueOf(c.get(Calendar.MONTH)) + "/"
				+ String.valueOf(c.get(Calendar.YEAR)));

		setBackground(new Color(21, 21, 21));

		GroupLayout panelPrincipalLayout = new GroupLayout(this);
		setLayout(panelPrincipalLayout);
		panelPrincipalLayout.setHorizontalGroup(panelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelPrincipalLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(pam)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(cartola, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(resumen, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addGroup(panelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
								.addComponent(lUsuario).addComponent(lFecha1))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(panelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(fFecha).addComponent(fUsuario, GroupLayout.PREFERRED_SIZE, 123,
										GroupLayout.PREFERRED_SIZE))
						.addGap(23, 23, 23)));
		panelPrincipalLayout.setVerticalGroup(panelPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(panelPrincipalLayout
								.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(
										pam)
								.addGroup(panelPrincipalLayout.createSequentialGroup().addGap(7, 7, 7)
										.addGroup(panelPrincipalLayout
												.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addGroup(panelPrincipalLayout.createSequentialGroup()
														.addGroup(panelPrincipalLayout
																.createParallelGroup(GroupLayout.Alignment.BASELINE)
																.addComponent(lUsuario).addComponent(fUsuario,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
														.addGap(6, 6, 6)
														.addGroup(panelPrincipalLayout
																.createParallelGroup(GroupLayout.Alignment.BASELINE)
																.addComponent(lFecha1).addComponent(fFecha,
																		GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)))
												.addGroup(panelPrincipalLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(cartola, GroupLayout.PREFERRED_SIZE, 27,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(resumen, GroupLayout.PREFERRED_SIZE, 27,
																GroupLayout.PREFERRED_SIZE)))))));
	}

	protected void resumenActionPerformed(ActionEvent evt) {
		
		FramePrincipal parent = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
		parent.actResumen();
		parent.openResumen();
		
	}

	protected void cartolaActionPerformed(ActionEvent evt) {
		
		FramePrincipal parent = (FramePrincipal) SwingUtilities.getWindowAncestor(this);
		parent.openCartola();

	}
}
