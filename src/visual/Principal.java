package visual;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import org.jdesktop.swingx.JXDatePicker;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import utiles.ControlPrincipal;

public class Principal
{
	private JFrame principal;
	private JButton añadir;
	private JToggleButton cartola;
	private JComboBox<String> documento;
	private JComboBox<String> documento1;
	private JTextField eM1;
	private JTextField eM2;
	private JTextField eM3;
	private JTextField eM4;
	private JTextField eM5;
	private JTextField eM6;
	private JButton eliminar;
	private JTextField fDesc;
	private JTextField fDesc1;
	private JTextField fEgr;
	private JTextField fEgr1;
	private JTextField fFD;
	private JTextField fFD1;
	private JTextField fFecha1;
	private JTextField fIng;
	private JTextField fIng1;
	private JTextField fNumber;
	private JTextField fUsuario;
	private JPanel graph;
	private ChartPanel graphDoc;
	private ChartPanel graphMes;
	private JTextField iM1;
	private JTextField iM2;
	private JTextField iM3;
	private JTextField iM4;
	private JTextField iM5;
	private JTextField iM6;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JScrollPane jScrollPane1;
	private JLabel lDesc;
	private JLabel lDesc1;
	private JLabel lDocumento;
	private JLabel lDocumento1;
	private JLabel lEgr;
	private JLabel lEgr1;
	private JLabel lEgr2;
	private JLabel lFD;
	private JLabel lFD1;
	private JLabel lFecha1;
	private JLabel lFecha2;
	private JLabel lFecha3;
	private JLabel lFecha4;
	private JLabel lIng;
	private JLabel lIng1;
	private JLabel lIng2;
	private JLabel lMes1;
	private JLabel lMes2;
	private JLabel lMes3;
	private JLabel lMes4;
	private JLabel lMes5;
	private JLabel lMes6;
	private JLabel lSaldo2;
	private JLabel lUsuario;
	private JButton modificar;
	private JLabel pam;
	private JPanel panel;
	private JPanel panelCartola;
	private JPanel panelPrincipal;
	private JPanel panelResumen;
	private JToggleButton resumen;
	private JTextField sM1;
	private JTextField sM2;
	private JTextField sM3;
	private JTextField sM4;
	private JTextField sM5;
	private JTextField sM6;
	private JTable tabla;
	private JComboBox<String> tipoGraph;
	private JXDatePicker jXDatePicker1;
	private JXDatePicker jXDatePicker2;
	private String usuario;
	private DefaultCategoryDataset dataSetMes;
	private DefaultCategoryDataset dataSetDoc;

	public Principal(String usuario)
	{
		this.usuario = usuario;
		initComponents();
		iniciarTabla();
	}
	private void initComponents()
	{
		principal = new JFrame();
		panel = new JPanel();
		panelCartola = new JPanel();
		eliminar = new JButton();
		jScrollPane1 = new JScrollPane();
		tabla = new JTable();
		lFecha2 = new JLabel();
		lDocumento = new JLabel();
		lFD = new JLabel();
		lDesc = new JLabel();
		lIng = new JLabel();
		lEgr = new JLabel();
		documento = new JComboBox<>();
		fFD = new JTextField();
		fDesc = new JTextField();
		fIng = new JTextField();
		fEgr = new JTextField();
		añadir = new JButton();
		lFecha3 = new JLabel();
		lDocumento1 = new JLabel();
		lFD1 = new JLabel();
		lDesc1 = new JLabel();
		lIng1 = new JLabel();
		lEgr1 = new JLabel();
		fEgr1 = new JTextField();
		fIng1 = new JTextField();
		fDesc1 = new JTextField();
		fFD1 = new JTextField();
		documento1 = new JComboBox<>();
		modificar = new JButton();
		lFecha4 = new JLabel();
		fNumber = new JTextField();
		panelResumen = new JPanel();
		graph = new JPanel();
		tipoGraph = new JComboBox<>();
		jLabel1 = new JLabel();
		lMes1 = new JLabel();
		lMes2 = new JLabel();
		lMes3 = new JLabel();
		lMes4 = new JLabel();
		lMes5 = new JLabel();
		lMes6 = new JLabel();
		iM1 = new JTextField();
		iM2 = new JTextField();
		iM3 = new JTextField();
		iM4 = new JTextField();
		iM5 = new JTextField();
		iM6 = new JTextField();
		lIng2 = new JLabel();
		lEgr2 = new JLabel();
		eM2 = new JTextField();
		eM3 = new JTextField();
		eM4 = new JTextField();
		eM5 = new JTextField();
		eM6 = new JTextField();
		eM1 = new JTextField();
		sM2 = new JTextField();
		sM4 = new JTextField();
		sM3 = new JTextField();
		lSaldo2 = new JLabel();
		sM6 = new JTextField();
		sM5 = new JTextField();
		sM1 = new JTextField();
		jLabel2 = new JLabel();
		panelPrincipal = new JPanel();
		pam = new JLabel();
		cartola = new JToggleButton();
		resumen = new JToggleButton();
		lUsuario = new JLabel();
		fUsuario = new JTextField();
		fFecha1 = new JTextField();
		lFecha1 = new JLabel();
		jXDatePicker1 = new JXDatePicker();
		Calendar today = Calendar.getInstance();
		jXDatePicker1.setDate(today.getTime());
		jXDatePicker2 = new JXDatePicker();
		jXDatePicker2.setDate(today.getTime());
		fIng.setText("0");
		fEgr.setText("0");
		fIng1.setText("0");
		fEgr1.setText("0");
		principal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		panel.setBackground(new Color(204, 204, 204));
		panel.setRequestFocusEnabled(false);
		panel.setLayout(new CardLayout());
		panelCartola.setBackground(new Color(21, 21, 21));
		eliminar.setText("Eliminar Fila Seleccionada");
		eliminar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				eliminarActionPerformed(evt);
			}
		});
		jScrollPane1.getViewport().setBackground(new Color(128, 203, 196));
		tabla.setBackground(new Color(0, 204, 204));
		tabla.setForeground(SystemColor.textHighlight);
		tabla.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "N°", "Fecha", "Documento",
				"Fuente/Destino", "Descripcion", "Ingreso", "Egreso", "Saldo" })
		{
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex)
			{
				return canEdit[columnIndex];
			}
		});
		tabla.setGridColor(new Color(255, 255, 255));
		tabla.setSelectionForeground(new Color(0, 120, 215));
		jScrollPane1.setViewportView(tabla);
		if (tabla.getColumnModel().getColumnCount() > 0)
		{
			tabla.getColumnModel().getColumn(0).setResizable(false);
		}
		lFecha2.setBackground(new Color(0, 204, 204));
		lFecha2.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lFecha2.setForeground(new Color(0, 204, 204));
		lFecha2.setText("Fecha:");
		lDocumento.setBackground(new Color(0, 204, 204));
		lDocumento.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lDocumento.setForeground(new Color(0, 204, 204));
		lDocumento.setText("Documento:");
		lFD.setBackground(new Color(0, 204, 204));
		lFD.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lFD.setForeground(new Color(0, 204, 204));
		lFD.setText("Fuente/Destino:");
		lDesc.setBackground(new Color(0, 204, 204));
		lDesc.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lDesc.setForeground(new Color(0, 204, 204));
		lDesc.setText("Descripcion:");
		lIng.setBackground(new Color(0, 204, 204));
		lIng.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lIng.setForeground(new Color(0, 204, 204));
		lIng.setText("Ingreso:");
		lEgr.setBackground(new Color(0, 204, 204));
		lEgr.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lEgr.setForeground(new Color(0, 204, 204));
		lEgr.setText("Egreso:");
		documento.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		documento.setModel(new DefaultComboBoxModel<>(new String[] { "Efectivo", "Credito", "Transferencia" }));
		fFD.setToolTipText("");
		añadir.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		añadir.setText("Añadir");
		añadir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				añadirActionPerformed(evt);
			}
		});
		lFecha3.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lFecha3.setForeground(new Color(0, 204, 204));
		lFecha3.setText("Fecha:");
		lDocumento1.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lDocumento1.setForeground(new Color(0, 204, 204));
		lDocumento1.setText("Documento:");
		lFD1.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lFD1.setForeground(new Color(0, 204, 204));
		lFD1.setText("Fuente/Destino:");
		lDesc1.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lDesc1.setForeground(new Color(0, 204, 204));
		lDesc1.setText("Descripcion:");
		lIng1.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lIng1.setForeground(new Color(0, 204, 204));
		lIng1.setText("Ingreso:");
		lEgr1.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lEgr1.setForeground(new Color(0, 204, 204));
		lEgr1.setText("Egreso:");
		fFD1.setToolTipText("");
		documento1.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		documento1.setModel(new DefaultComboBoxModel<>(new String[] { "Efectivo", "Credito", "Transferencia" }));
		modificar.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		modificar.setText("Modificar");
		modificar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				modificarActionPerformed(evt);
			}
		});
		lFecha4.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lFecha4.setForeground(new Color(0, 204, 204));
		lFecha4.setText("N°:");
		fNumber.setToolTipText("");
		GroupLayout panelCartolaLayout = new GroupLayout(panelCartola);
		panelCartola.setLayout(panelCartolaLayout);
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
		panel.add(panelCartola, "card2");
		graphMes = crearGraphMes();
		graphDoc = crearGraphDoc();
		panelResumen.setBackground(new Color(21, 21, 21));
		panelResumen.setForeground(new Color(255, 255, 255));
		graph.setBackground(new Color(153, 153, 153));
		graph.setLayout(new CardLayout());
		graph.add(graphMes, "Mes");
		graphDoc.setBackground(new Color(255, 255, 255));
		graphDoc.setLayout(new BorderLayout());
		graph.add(graphDoc, "Documento");
		tipoGraph.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		tipoGraph.setModel(new DefaultComboBoxModel<>(new String[] { "Mes", "Documento" }));
		tipoGraph.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				comboActionPerformed(evt);
			}
		});
		jLabel1.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		jLabel1.setForeground(new Color(255, 255, 255));
		jLabel1.setText("Seleccionar Grafico:");
		lMes1.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lMes1.setForeground(new Color(255, 255, 255));
		lMes1.setText("Mes 1");
		lMes2.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lMes2.setForeground(new Color(255, 255, 255));
		lMes2.setText("Mes 2");
		lMes3.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lMes3.setForeground(new Color(255, 255, 255));
		lMes3.setText("Mes 3");
		lMes4.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lMes4.setForeground(new Color(255, 255, 255));
		lMes4.setText("Mes 4");
		lMes5.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lMes5.setForeground(new Color(255, 255, 255));
		lMes5.setText("Mes 5");
		lMes6.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lMes6.setForeground(new Color(255, 255, 255));
		lMes6.setText("Mes 6");
		iM1.setBackground(new Color(0, 204, 204));
		iM2.setBackground(new Color(0, 204, 204));
		iM3.setBackground(new Color(0, 204, 204));
		iM4.setBackground(new Color(0, 204, 204));
		iM5.setBackground(new Color(0, 204, 204));
		iM6.setBackground(new Color(0, 204, 204));
		lIng2.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lIng2.setForeground(new Color(255, 255, 255));
		lIng2.setText("Ingresos");
		lEgr2.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lEgr2.setForeground(new Color(255, 255, 255));
		lEgr2.setText("Egresos");
		eM2.setBackground(new Color(0, 204, 204));
		eM3.setBackground(new Color(0, 204, 204));
		eM4.setBackground(new Color(0, 204, 204));
		eM5.setBackground(new Color(0, 204, 204));
		eM6.setBackground(new Color(0, 204, 204));
		eM1.setBackground(new Color(0, 204, 204));
		sM2.setBackground(new Color(0, 204, 204));
		sM4.setBackground(new Color(0, 204, 204));
		sM3.setBackground(new Color(0, 204, 204));
		lSaldo2.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lSaldo2.setForeground(new Color(255, 255, 255));
		lSaldo2.setText("Saldo");
		sM6.setBackground(new Color(0, 204, 204));
		sM5.setBackground(new Color(0, 204, 204));
		sM1.setBackground(new Color(0, 204, 204));
		jLabel2.setFont(new Font("Eras Light ITC", 0, 36)); // NOI18N
		jLabel2.setForeground(new Color(255, 255, 255));
		jLabel2.setText("Balance Mensual");
		GroupLayout panelResumenLayout = new GroupLayout(panelResumen);
		panelResumen.setLayout(panelResumenLayout);
		panelResumenLayout
				.setHorizontalGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelResumenLayout.createSequentialGroup()
								.addContainerGap().addGroup(panelResumenLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
												lIng2, javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												panelResumenLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lSaldo2).addComponent(lEgr2)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24,
										Short.MAX_VALUE)
								.addGroup(panelResumenLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												panelResumenLayout.createSequentialGroup()
														.addComponent(
																jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 310,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(116, 116, 116))
										.addGroup(panelResumenLayout.createSequentialGroup()
												.addGroup(panelResumenLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(sM1, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(eM1, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(iM1, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(lMes1))
												.addGap(18, 18, 18)
												.addGroup(panelResumenLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lMes2)
														.addComponent(sM2, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(eM2, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(iM2, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
																javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(18, 18, 18)
												.addGroup(panelResumenLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lMes3)
														.addGroup(panelResumenLayout.createSequentialGroup()
																.addGroup(panelResumenLayout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(sM3,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				63,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(eM3,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				63,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(iM3,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				63,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(18, 18, 18)
																.addGroup(panelResumenLayout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(panelResumenLayout
																				.createSequentialGroup()
																				.addComponent(sM4,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						63,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGap(18, 18, 18)
																				.addComponent(sM5,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						63,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGap(18, 18, 18).addComponent(sM6,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						63,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGroup(panelResumenLayout
																				.createSequentialGroup()
																				.addComponent(eM4,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						63,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGap(18, 18, 18)
																				.addComponent(eM5,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						63,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addGap(18, 18, 18).addComponent(eM6,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						63,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGroup(panelResumenLayout
																				.createSequentialGroup()
																				.addGroup(panelResumenLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(iM4,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								63,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(lMes4))
																				.addGap(18, 18, 18)
																				.addGroup(panelResumenLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(iM5,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								63,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(lMes5))
																				.addGap(18, 18, 18)
																				.addGroup(panelResumenLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(lMes6)
																						.addComponent(iM6,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								63,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))))
												.addGap(35, 35, 35)))
								.addGroup(panelResumenLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(panelResumenLayout.createSequentialGroup().addComponent(jLabel1)
												.addGap(4, 4, 4)
												.addComponent(tipoGraph, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(graph, javax.swing.GroupLayout.PREFERRED_SIZE, 719,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(6, 6, 6)));
		panelResumenLayout
				.setVerticalGroup(
						panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(
										panelResumenLayout
												.createSequentialGroup().addGroup(panelResumenLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(graph, javax.swing.GroupLayout.PREFERRED_SIZE,
																449, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(panelResumenLayout.createSequentialGroup().addGap(50,
																50, 50)
																.addComponent(jLabel2,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 52,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(40, 40, 40)
																.addGroup(panelResumenLayout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(lMes1).addComponent(lMes2)
																		.addComponent(lMes3).addComponent(lMes4)
																		.addComponent(lMes5).addComponent(lMes6))
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(panelResumenLayout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(panelResumenLayout
																				.createSequentialGroup()
																				.addGroup(panelResumenLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(iM1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(iM2,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(iM4,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(iM5,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(iM6,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(panelResumenLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(eM1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(eM2,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(eM4,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(eM5,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(eM6,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(panelResumenLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(sM1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(sM2,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(sM4,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(sM5,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(sM6,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addGroup(panelResumenLayout
																				.createSequentialGroup()
																				.addComponent(lIng2)
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(panelResumenLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(panelResumenLayout
																								.createSequentialGroup()
																								.addGap(26, 26, 26)
																								.addComponent(lSaldo2))
																						.addComponent(lEgr2)))
																		.addGroup(panelResumenLayout
																				.createSequentialGroup()
																				.addComponent(iM3,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(eM3,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(sM3,
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)))))
												.addGap(43, 43, 43)
												.addGroup(panelResumenLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(tipoGraph, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel1))
												.addGap(0, 65, Short.MAX_VALUE)));
		panel.add(panelResumen, "card3");
		panelPrincipal.setBackground(new Color(21, 21, 21));
		pam.setFont(new Font("LM Roman Caps 10", 1, 60)); // NOI18N
		pam.setIcon(new ImageIcon(getClass().getResource("P.A.M.v2/logo.png"))); // NOI18N
		cartola.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		cartola.setIcon(new ImageIcon(getClass().getResource("P.A.M.v2/catola.png"))); // NOI18N
		cartola.setText("Cartola");
		cartola.setMaximumSize(new Dimension(50, 17));
		cartola.setMinimumSize(new Dimension(50, 17));
		cartola.setPreferredSize(new Dimension(50, 17));
		cartola.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				cartolaActionPerformed(evt);
			}
		});
		resumen.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		resumen.setIcon(new ImageIcon(getClass().getResource("P.A.M.v2/resumen.png"))); // NOI18N
		resumen.setText("Resumen");
		resumen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				resumenActionPerformed(evt);
			}
		});
		lUsuario.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lUsuario.setForeground(new Color(0, 204, 204));
		lUsuario.setText("Usuario");
		fUsuario.setEditable(false);
		fUsuario.setFocusable(false);
		fUsuario.setText(usuario);
		fFecha1.setEditable(false);
		fFecha1.setFocusable(false);
		Calendar c = Calendar.getInstance();
		fFecha1.setText(String.valueOf(c.get(Calendar.DATE)) + "/" + String.valueOf(c.get(Calendar.MONTH)) + "/"
				+ String.valueOf(c.get(Calendar.YEAR)));
		lFecha1.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lFecha1.setForeground(new Color(0, 204, 204));
		lFecha1.setText("Fecha");
		GroupLayout panelPrincipalLayout = new GroupLayout(panelPrincipal);
		panelPrincipal.setLayout(panelPrincipalLayout);
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
								.addComponent(fFecha1).addComponent(fUsuario, GroupLayout.PREFERRED_SIZE, 123,
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
																.addComponent(lFecha1).addComponent(fFecha1,
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
		GroupLayout layout = new GroupLayout(principal.getContentPane());
		principal.getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(0, 0, 0)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(panelPrincipal, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))));
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addComponent(panelPrincipal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0).addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
		principal.pack();
		principal.setLocationRelativeTo(null);
		principal.setVisible(true);
	}
	private void resumenActionPerformed(ActionEvent evt)
	{
		actualizarGraphMes();
		actualizarGraphDoc();
		llenarResumen();
		CardLayout cardLayout = (CardLayout) panel.getLayout();
		cardLayout.show(panel, "card3");
	}
	private void cartolaActionPerformed(ActionEvent evt)
	{
		CardLayout cardLayout = (CardLayout) panel.getLayout();
		cardLayout.show(panel, "card2");
	}
	private void modificarActionPerformed(ActionEvent evt)
	{
		modificarFila();
	}
	private void añadirActionPerformed(ActionEvent evt)
	{
		añadirFila();
	}
	private void eliminarActionPerformed(ActionEvent evt)
	{
		ControlPrincipal control = new ControlPrincipal(usuario);
		control.eliminarFila((String) tabla.getValueAt(tabla.getSelectedRow(), 0));
		iniciarTabla();
	}
	private void comboActionPerformed(ActionEvent evt)
	{
		CardLayout cardLayout = (CardLayout) graph.getLayout();
		cardLayout.show(graph, (String) tipoGraph.getSelectedItem());
	}
	private void añadirFila()
	{
		ControlPrincipal control = new ControlPrincipal(usuario);
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = formateador.format(jXDatePicker1.getDate());
		String documento = this.documento.getSelectedItem().toString();
		String fD = fFD.getText();
		fFD.setText("");
		String desc = fDesc.getText();
		fDesc.setText("");
		String ing = fIng.getText();
		fIng.setText("0");
		String egr = fEgr.getText();
		fEgr.setText("0");
		control.añadir(fecha, documento, fD, desc, ing, egr);
		Object[] fila = control.getLastRow();
		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
		modelo.addRow(fila);
		tabla.setModel(modelo);
	}
	private void iniciarTabla()
	{
		ControlPrincipal control = new ControlPrincipal(usuario);
		if (control.isFiled())
		{
			control.actSaldos();
			DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
			modelo.setRowCount(0);
			tabla.setModel(modelo);
			for (int x = 0; x < control.getRowCount(); x++)
			{
				Object[] fila = control.getRow(x);
				modelo.addRow(fila);
			}
			tabla.setModel(modelo);
		}
	}
	private void modificarFila()
	{
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		String number = fNumber.getText();
		String fecha = formateador.format(jXDatePicker2.getDate());
		String documento = this.documento1.getSelectedItem().toString();
		String fD = fFD1.getText();
		String desc = fDesc1.getText();
		String ing = fIng1.getText();
		String egr = fEgr1.getText();
		ControlPrincipal control = new ControlPrincipal(usuario);
		control.modificarFila(number, fecha, documento, fD, desc, ing, egr);
		iniciarTabla();
	}
	private void llenarResumen()
	{
		ControlPrincipal control = new ControlPrincipal(usuario);
		String[][] resumen = control.resumenMes();
		ArrayList<JLabel> lMeses = new ArrayList<JLabel>();
		ArrayList<JTextField> fIngresos = new ArrayList<JTextField>();
		ArrayList<JTextField> fEgresos = new ArrayList<JTextField>();
		ArrayList<JTextField> fSaldo = new ArrayList<JTextField>();
		lMeses.add(lMes1);
		lMeses.add(lMes2);
		lMeses.add(lMes3);
		lMeses.add(lMes4);
		lMeses.add(lMes5);
		lMeses.add(lMes6);
		fIngresos.add(iM1);
		fIngresos.add(iM2);
		fIngresos.add(iM3);
		fIngresos.add(iM4);
		fIngresos.add(iM5);
		fIngresos.add(iM6);
		fEgresos.add(eM1);
		fEgresos.add(eM2);
		fEgresos.add(eM3);
		fEgresos.add(eM4);
		fEgresos.add(eM5);
		fEgresos.add(eM6);
		fSaldo.add(sM1);
		fSaldo.add(sM2);
		fSaldo.add(sM3);
		fSaldo.add(sM4);
		fSaldo.add(sM5);
		fSaldo.add(sM6);
		if (resumen[0][0] != null)
		{
			for (int x = resumen[0].length - 1, z = lMeses.size() - 1; x > resumen[0].length - 7; x--, z--)
			{
				fIngresos.get(z).setText(resumen[2][x]);
				fEgresos.get(z).setText(resumen[3][x]);
				fSaldo.get(z).setText(resumen[1][x]);
				if (resumen[0][x].matches("[0-9]{4}-01"))
				{
					lMeses.get(z).setText("Enero");
				} else if (resumen[0][x].matches("[0-9]{4}-02"))
				{
					lMeses.get(z).setText("Febrero");
				} else if (resumen[0][x].matches("[0-9]{4}-03"))
				{
					lMeses.get(z).setText("Marzo");
				} else if (resumen[0][x].matches("[0-9]{4}-04"))
				{
					lMeses.get(z).setText("Abril");
				} else if (resumen[0][x].matches("[0-9]{4}-05"))
				{
					lMeses.get(z).setText("Mayo");
				} else if (resumen[0][x].matches("[0-9]{4}-06"))
				{
					lMeses.get(z).setText("Junio");
				} else if (resumen[0][x].matches("[0-9]{4}-07"))
				{
					lMeses.get(z).setText("Julio");
				} else if (resumen[0][x].matches("[0-9]{4}-08"))
				{
					lMeses.get(z).setText("Agosto");
				} else if (resumen[0][x].matches("[0-9]{4}-09"))
				{
					lMeses.get(z).setText("Septiembre");
				} else if (resumen[0][x].matches("[0-9]{4}-10"))
				{
					lMeses.get(z).setText("Octubre");
				} else if (resumen[0][x].matches("[0-9]{4}-11"))
				{
					lMeses.get(z).setText("Noviembre");
				} else if (resumen[0][x].matches("[0-9]{4}-12"))
				{
					lMeses.get(z).setText("Diciembre");
				}
			}
		}
	}
	private ChartPanel crearGraphMes()
	{
		ControlPrincipal control = new ControlPrincipal(usuario);
		String[][] resumen = control.resumenMes();
		dataSetMes = new DefaultCategoryDataset();
		if (resumen[0][0] != null)
		{
			for (int x = 0; x < resumen[0].length; x++)
			{
				dataSetMes.setValue(Integer.parseInt(resumen[1][x]), "Saldo", resumen[0][x]);
			}
		}
		JFreeChart chart = ChartFactory.createBarChart("Resumen Mensual", "Mes", "Saldo", dataSetMes,
				PlotOrientation.VERTICAL, false, true, false);
		chart.getPlot().setBackgroundPaint(new Color(0, 204, 204));
		chart.getCategoryPlot().getRenderer().setSeriesPaint(0, new Color(21, 21, 21));
		chart.setBackgroundPaint(new Color(0, 204, 204));
		ChartPanel graph = new ChartPanel(chart);
		return graph;
	}
	private ChartPanel crearGraphDoc()
	{
		ControlPrincipal control = new ControlPrincipal(usuario);
		int[] resumen = control.resumenDoc();
		dataSetDoc = new DefaultCategoryDataset();
		dataSetDoc.setValue(resumen[0], "Saldo", "Efectivo");
		dataSetDoc.setValue(resumen[1], "Saldo", "Transferencia");
		dataSetDoc.setValue(resumen[2], "Saldo", "Credito");
		JFreeChart chart = ChartFactory.createBarChart("Resumen por Documentos", "Documento", "Saldo", dataSetDoc,
				PlotOrientation.VERTICAL, false, true, false);
		chart.getPlot().setBackgroundPaint(new Color(0, 204, 204));
		chart.getCategoryPlot().getRenderer().setSeriesPaint(0, new Color(21, 21, 21));
		chart.setBackgroundPaint(new Color(0, 204, 204));
		ChartPanel graph = new ChartPanel(chart);
		return graph;
	}
	private void actualizarGraphMes()
	{
		dataSetMes.clear();
		ControlPrincipal control = new ControlPrincipal(usuario);
		String[][] resumen = control.resumenMes();
		if (resumen[0][0] != null)
		{
			for (int x = 0; x < resumen[0].length; x++)
			{
				dataSetMes.setValue(Integer.parseInt(resumen[1][x]), "Saldo", resumen[0][x]);
			}
		}
	}
	private void actualizarGraphDoc()
	{
		ControlPrincipal control = new ControlPrincipal(usuario);
		dataSetDoc.clear();
		int[] resumen = control.resumenDoc();
		dataSetDoc.setValue(resumen[0], "Saldo", "Efectivo");
		dataSetDoc.setValue(resumen[1], "Saldo", "Transferencia");
		dataSetDoc.setValue(resumen[2], "Saldo", "Credito");
	}
}
