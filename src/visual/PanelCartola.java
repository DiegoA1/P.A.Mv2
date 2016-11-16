package visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import org.jdesktop.swingx.JXDatePicker;

import utiles.ControlPrincipal;
import utiles.Validador;

public class PanelCartola extends JPanel {

	private JButton añadir;
	private JButton eliminar;
	private JButton modificar;

	private JScrollPane jScrollPane1;
	private JTableTable tabla;

	private String usuario;

	private JLabel lFD;
	private JLabel lFD1;
	private JLabel lEgr;
	private JLabel lEgr1;
	private JLabel lIng;
	private JLabel lIng1;
	private JLabel lDesc;
	private JLabel lDesc1;
	private JLabel lDocumento;
	private JLabel lDocumento1;
	private JLabel lFecha2;
	private JLabel lFecha3;
	private JLabel lFecha4;

	private JComboBox<String> documento;
	private JComboBox<String> documento1;

	private JTextField fFD;
	private JTextField fFD1;
	private JTextField fDesc;
	private JTextField fDesc1;
	private JTextField fIng;
	private JTextField fIng1;
	private JTextField fEgr;
	private JTextField fEgr1;
	private JTextField fNumber;

	private JXDatePicker jXDatePicker1;
	private JXDatePicker jXDatePicker2;

	public PanelCartola(String usuario) {

		this.usuario = usuario;
		init();
		tabla.actTabla();

	}

	private void init() {

		tabla = new JTableTable(usuario);
		jScrollPane1 = new JScrollPane();
		jScrollPane1.getViewport().setBackground(new Color(128, 203, 196));
		jScrollPane1.setViewportView(tabla);

		if (tabla.getColumnModel().getColumnCount() > 0) {

			tabla.getColumnModel().getColumn(0).setResizable(false);

		}

		lFD = new JLabel();
		lFD.setBackground(new Color(0, 204, 204));
		lFD.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lFD.setForeground(new Color(0, 204, 204));
		lFD.setText("Fuente/Destino:");

		lFD1 = new JLabel();
		lFD1.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lFD1.setForeground(new Color(0, 204, 204));
		lFD1.setText("Fuente/Destino:");

		lEgr = new JLabel();
		lEgr.setBackground(new Color(0, 204, 204));
		lEgr.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lEgr.setForeground(new Color(0, 204, 204));
		lEgr.setText("Egreso:");

		lEgr1 = new JLabel();
		lEgr1.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lEgr1.setForeground(new Color(0, 204, 204));
		lEgr1.setText("Egreso:");

		lIng = new JLabel();
		lIng.setBackground(new Color(0, 204, 204));
		lIng.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lIng.setForeground(new Color(0, 204, 204));
		lIng.setText("Ingreso:");

		lIng1 = new JLabel();
		lIng1.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lIng1.setForeground(new Color(0, 204, 204));
		lIng1.setText("Ingreso:");

		lDesc = new JLabel();
		lDesc.setBackground(new Color(0, 204, 204));
		lDesc.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lDesc.setForeground(new Color(0, 204, 204));
		lDesc.setText("Descripcion:");

		lDesc1 = new JLabel();
		lDesc1.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lDesc1.setForeground(new Color(0, 204, 204));
		lDesc1.setText("Descripcion:");

		lDocumento = new JLabel();
		lDocumento.setBackground(new Color(0, 204, 204));
		lDocumento.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lDocumento.setForeground(new Color(0, 204, 204));
		lDocumento.setText("Documento:");

		lDocumento1 = new JLabel();
		lDocumento1.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lDocumento1.setForeground(new Color(0, 204, 204));
		lDocumento1.setText("Documento:");

		lFecha2 = new JLabel();
		lFecha2.setBackground(new Color(0, 204, 204));
		lFecha2.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lFecha2.setForeground(new Color(0, 204, 204));
		lFecha2.setText("Fecha:");

		lFecha3 = new JLabel();
		lFecha3.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lFecha3.setForeground(new Color(0, 204, 204));
		lFecha3.setText("Fecha:");

		lFecha4 = new JLabel();
		lFecha4.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lFecha4.setForeground(new Color(0, 204, 204));
		lFecha4.setText("N°:");

		documento = new JComboBox<>();
		documento.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		documento.setModel(new DefaultComboBoxModel<>(new String[] { "Efectivo", "Credito", "Transferencia" }));

		documento1 = new JComboBox<>();
		documento1.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		documento1.setModel(new DefaultComboBoxModel<>(new String[] { "Efectivo", "Credito", "Transferencia" }));

		fFD = new JTextField();
		fFD1 = new JTextField();

		fDesc = new JTextField();
		fDesc1 = new JTextField();

		fIng = new JTextField();
		fIng.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();

				if (!Character.isDigit(c)) {
					e.consume();
				}

			}

		});
		fIng.setText("0");
		fIng1 = new JTextField();
		fIng1.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();

				if (!Character.isDigit(c)) {
					e.consume();
				}

			}

		});
		fIng1.setText("0");

		fEgr = new JTextField();
		fEgr.setText("0");
		fEgr1 = new JTextField();
		fEgr1.setText("0");

		fNumber = new JTextField();

		Calendar today = Calendar.getInstance();

		jXDatePicker1 = new JXDatePicker();
		jXDatePicker1.setDate(today.getTime());
		jXDatePicker2 = new JXDatePicker();
		jXDatePicker2.setDate(today.getTime());

		eliminar = new JButton();
		eliminar.setText("Eliminar Fila Seleccionada");
		eliminar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				eliminarActionPerformed(evt);

			}

		});

		añadir = new JButton();
		añadir.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		añadir.setText("añadir");
		añadir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				añadirActionPerformed(evt);

			}

		});

		modificar = new JButton();
		modificar.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		modificar.setText("Modificar");
		modificar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				modificarActionPerformed(evt);

			}

		});

		setBackground(new Color(21, 21, 21));
		GroupLayout panelCartolaLayout = new GroupLayout(this);
		setLayout(panelCartolaLayout);
		panelCartolaLayout.setHorizontalGroup(panelCartolaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelCartolaLayout.createSequentialGroup()
						.addGroup(panelCartolaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
								panelCartolaLayout.createSequentialGroup().addGap(747, 747, 747).addComponent(eliminar))
								.addGroup(panelCartolaLayout.createSequentialGroup().addContainerGap()
										.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)))
						.addGap(30, 30,
								30)
						.addGroup(panelCartolaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addGroup(panelCartolaLayout.createSequentialGroup()
										.addGroup(panelCartolaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(lFD).addComponent(lEgr, GroupLayout.Alignment.TRAILING)
												.addComponent(lIng, GroupLayout.Alignment.TRAILING)
												.addComponent(lDesc, GroupLayout.Alignment.TRAILING)
												.addComponent(lDocumento, GroupLayout.Alignment.TRAILING)
												.addComponent(lFecha2, GroupLayout.Alignment.TRAILING))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(panelCartolaLayout
												.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addComponent(documento, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(fFD).addComponent(fDesc).addComponent(fIng)
												.addComponent(fEgr, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
												.addComponent(jXDatePicker1, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(panelCartolaLayout.createSequentialGroup()
										.addGroup(panelCartolaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(lFD1).addComponent(lEgr1, GroupLayout.Alignment.TRAILING)
												.addComponent(lIng1, GroupLayout.Alignment.TRAILING)
												.addComponent(lDesc1, GroupLayout.Alignment.TRAILING)
												.addComponent(lDocumento1, GroupLayout.Alignment.TRAILING)
												.addComponent(lFecha3, GroupLayout.Alignment.TRAILING)
												.addComponent(lFecha4, GroupLayout.Alignment.TRAILING))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(panelCartolaLayout
												.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addComponent(documento1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(fFD1).addComponent(fDesc1).addComponent(fIng1)
												.addComponent(fEgr1, GroupLayout.PREFERRED_SIZE, 170,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(fNumber).addComponent(jXDatePicker2,
														GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)))
								.addGroup(panelCartolaLayout.createSequentialGroup().addComponent(añadir).addGap(125,
										125, 125))
								.addGroup(panelCartolaLayout.createSequentialGroup().addComponent(modificar).addGap(105,
										105, 105)))
						.addGap(62, 62, 62)));
		panelCartolaLayout.setVerticalGroup(panelCartolaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelCartolaLayout.createSequentialGroup().addGroup(panelCartolaLayout
						.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addGroup(panelCartolaLayout.createSequentialGroup().addGap(40, 40, 40)
								.addGroup(panelCartolaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lFecha2).addComponent(jXDatePicker1, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panelCartolaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lDocumento).addComponent(documento, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panelCartolaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lFD).addComponent(fFD, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panelCartolaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lDesc).addComponent(fDesc, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panelCartolaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lIng).addComponent(fIng, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panelCartolaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(fEgr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lEgr))
								.addGap(18, 18, 18).addComponent(añadir)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
								.addGroup(panelCartolaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lFecha4).addComponent(fNumber, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panelCartolaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lFecha3).addComponent(jXDatePicker2, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panelCartolaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lDocumento1).addComponent(documento1, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panelCartolaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lFD1).addComponent(fFD1, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panelCartolaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lDesc1).addComponent(fDesc1, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panelCartolaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(lIng1).addComponent(fIng1, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(panelCartolaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(fEgr1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lEgr1))
								.addGap(18, 18, 18).addComponent(modificar))
						.addGroup(GroupLayout.Alignment.LEADING,
								panelCartolaLayout.createSequentialGroup().addGap(20, 20, 20)
										.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(eliminar)))
						.addGap(29, 29, 29)));

	}

	private void añadirActionPerformed(ActionEvent evt) {

		ControlPrincipal control = new ControlPrincipal(usuario);
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = formateador.format(jXDatePicker1.getDate());
		String documento = this.documento.getSelectedItem().toString();

		String fD = fFD.getText();
		fFD.setText("");
		
		String desc = fDesc.getText();
		fDesc.setText("");
		
		String ing = fIng.getText();
		if (ing.equals("")) {
			ing = "0";
		} else if (!Validador.isNumber(ing)) {
			JOptionPane.showMessageDialog(null, "Dato ingresado incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		fIng.setText("0");
		String egr = fEgr.getText();
		if (egr.equals("")) {
			egr = "0";
		} else if (!Validador.isNumber(egr)) {
			JOptionPane.showMessageDialog(null, "Dato ingresado incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
		}

		fEgr.setText("0");

		control.añadir(fecha, documento, fD, desc, ing, egr);
		
		tabla.actTabla();

	}

	private void eliminarActionPerformed(ActionEvent evt) {
		ControlPrincipal control = new ControlPrincipal(usuario);
		if (tabla.getSelectedRow() != -1) {
			control.eliminarFila((String) tabla.getValueAt(tabla.getSelectedRow(), 0));
			tabla.actTabla();
		}
	}

	private void modificarActionPerformed(ActionEvent evt) {
		
		if(!fNumber.getText().equals("")){
			
			System.out.println("Entro");
			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");

			String number = fNumber.getText();
			String fecha = formateador.format(jXDatePicker2.getDate());
			String documento = this.documento1.getSelectedItem().toString();
			String fD = fFD1.getText();
			String desc = fDesc1.getText();
			String ing = fIng1.getText();
			
			if (ing.equals("")) {
				ing = "0";
			} else if (!Validador.isNumber(ing)) {
				JOptionPane.showMessageDialog(null, "Dato ingresado incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			String egr = fEgr1.getText();
			if (egr.equals("")) {
				egr = "0";
			} else if (!Validador.isNumber(egr)) {
				JOptionPane.showMessageDialog(null, "Dato ingresado incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
			}

			ControlPrincipal control = new ControlPrincipal(usuario);
			
			control.modificarFila(number, fecha, documento, fD, desc, ing, egr);

			tabla.actTabla();
			
		}else{
			JOptionPane.showMessageDialog(null, "No se ingreso el Nº");
		}

	}

}
