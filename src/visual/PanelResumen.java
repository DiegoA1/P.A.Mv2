package visual;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import utiles.ControlPrincipal;

public class PanelResumen extends JPanel {

	private JPanel graph;
	private ChartPanel graphDoc;
	private ChartPanel graphMes;

	private JLabel lIng;
	private JLabel lSaldo;
	private JLabel lEgr2;
	private JLabel lBalance;
	private JLabel select;

	private ArrayList<JLabel> mes;
	private ArrayList<JTextField> egresos;
	private ArrayList<JTextField> ingresos;
	private ArrayList<JTextField> saldos;

	private JComboBox<String> tipoGraph;

	private DefaultCategoryDataset dataSetMes;
	private DefaultCategoryDataset dataSetDoc;

	private String usuario;

	public PanelResumen(String usuario) {

		this.usuario = usuario;
		iniciar();

	}

	public void iniciar() {
		
		iniciarTextFieldYLabel();
	
		setBackground(new Color(21, 21, 21));
		setForeground(new Color(255, 255, 255));
		
		graphMes = crearGraphMes();
		graphDoc = crearGraphDoc();
		
		graph = new JPanel();
		graph.setBackground(new Color(153, 153, 153));
		graph.setLayout(new CardLayout());
		graph.add(graphMes, "Mes");
		graph.add(graphDoc, "Documento");

		lIng = new JLabel();
		lIng.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lIng.setForeground(new Color(255, 255, 255));
		lIng.setText("Ingresos");

		lSaldo = new JLabel();
		lSaldo.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lSaldo.setForeground(new Color(255, 255, 255));
		lSaldo.setText("Saldo");

		lEgr2 = new JLabel();
		lEgr2.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		lEgr2.setForeground(new Color(255, 255, 255));
		lEgr2.setText("Egresos");

		lBalance = new JLabel();
		lBalance.setFont(new Font("Eras Light ITC", 0, 36)); // NOI18N
		lBalance.setForeground(new Color(255, 255, 255));
		lBalance.setText("Balance Mensual");

		select = new JLabel();
		select.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		select.setForeground(new Color(255, 255, 255));
		select.setText("Seleccionar Grafico:");

		tipoGraph = new JComboBox<>();
		tipoGraph.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
		tipoGraph.setModel(new DefaultComboBoxModel<>(new String[] { "Mes", "Documento" }));
		tipoGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				comboActionPerformed(evt);

			}

		});

		GroupLayout panelResumenLayout = new GroupLayout(this);
		setLayout(panelResumenLayout);
		panelResumenLayout
				.setHorizontalGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								panelResumenLayout.createSequentialGroup().addContainerGap().addGroup(panelResumenLayout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(lIng, javax.swing.GroupLayout.Alignment.TRAILING).addGroup(
												javax.swing.GroupLayout.Alignment.TRAILING, panelResumenLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lSaldo).addComponent(lEgr2)))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24,
												Short.MAX_VALUE)
										.addGroup(panelResumenLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelResumenLayout
														.createSequentialGroup()
														.addComponent(lBalance, javax.swing.GroupLayout.PREFERRED_SIZE,
																310, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(116, 116, 116))
												.addGroup(panelResumenLayout.createSequentialGroup()
														.addGroup(panelResumenLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(saldos.get(0),
																		javax.swing.GroupLayout.PREFERRED_SIZE, 63,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(egresos.get(0),
																		javax.swing.GroupLayout.PREFERRED_SIZE, 63,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(ingresos.get(0),
																		javax.swing.GroupLayout.PREFERRED_SIZE, 63,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(mes.get(0)))
														.addGap(18, 18, 18)
														.addGroup(panelResumenLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(mes.get(1))
																.addComponent(saldos.get(1),
																		javax.swing.GroupLayout.PREFERRED_SIZE, 63,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(egresos.get(1),
																		javax.swing.GroupLayout.PREFERRED_SIZE, 63,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(ingresos.get(1),
																		javax.swing.GroupLayout.PREFERRED_SIZE, 63,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(18, 18, 18)
														.addGroup(panelResumenLayout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(mes.get(2))
																.addGroup(panelResumenLayout.createSequentialGroup()
																		.addGroup(panelResumenLayout
																				.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(saldos.get(2),
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						63,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(egresos.get(2),
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						63,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(ingresos.get(2),
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						63,
																						javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(18, 18, 18)
																		.addGroup(panelResumenLayout
																				.createParallelGroup(
																						javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(panelResumenLayout
																						.createSequentialGroup()
																						.addComponent(saldos.get(3),
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								63,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGap(18, 18, 18)
																						.addComponent(saldos.get(4),
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								63,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGap(18, 18, 18)
																						.addComponent(saldos.get(5),
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								63,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addGroup(panelResumenLayout
																						.createSequentialGroup()
																						.addComponent(egresos.get(3),
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								63,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGap(18, 18, 18)
																						.addComponent(egresos.get(4),
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								63,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addGap(18, 18, 18)
																						.addComponent(egresos.get(5),
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								63,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addGroup(panelResumenLayout
																						.createSequentialGroup()
																						.addGroup(panelResumenLayout
																								.createParallelGroup(
																										javax.swing.GroupLayout.Alignment.LEADING)
																								.addComponent(
																										ingresos.get(3),
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										63,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addComponent(
																										mes.get(3)))
																						.addGap(18, 18, 18)
																						.addGroup(panelResumenLayout
																								.createParallelGroup(
																										javax.swing.GroupLayout.Alignment.LEADING)
																								.addComponent(
																										ingresos.get(4),
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										63,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addComponent(
																										mes.get(4)))
																						.addGap(18, 18, 18)
																						.addGroup(panelResumenLayout
																								.createParallelGroup(
																										javax.swing.GroupLayout.Alignment.LEADING)
																								.addComponent(
																										mes.get(5))
																								.addComponent(
																										ingresos.get(5),
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										63,
																										javax.swing.GroupLayout.PREFERRED_SIZE))))))
														.addGap(35, 35, 35)))
										.addGroup(panelResumenLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(panelResumenLayout.createSequentialGroup()
														.addComponent(select).addGap(4, 4, 4)
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
																.addComponent(lBalance,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 52,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(40, 40, 40)
																.addGroup(panelResumenLayout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(mes.get(0)).addComponent(mes.get(1))
																		.addComponent(mes.get(2)).addComponent(mes.get(3))
																		.addComponent(mes.get(4)).addComponent(mes.get(5)))
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
																						.addComponent(ingresos.get(0),
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(ingresos.get(1),
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(ingresos.get(3),
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(ingresos.get(4),
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(ingresos.get(5),
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(panelResumenLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(egresos.get(0),
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(egresos.get(1),
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(egresos.get(3),
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(egresos.get(4),
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(egresos.get(5),
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(panelResumenLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(saldos.get(0),
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(saldos.get(1),
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(saldos.get(3),
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(saldos.get(4),
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(saldos.get(5),
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
																		.addGroup(panelResumenLayout
																				.createSequentialGroup()
																				.addComponent(lIng)
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(panelResumenLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(panelResumenLayout
																								.createSequentialGroup()
																								.addGap(26, 26, 26)
																								.addComponent(lSaldo))
																						.addComponent(lEgr2)))
																		.addGroup(panelResumenLayout
																				.createSequentialGroup()
																				.addComponent(ingresos.get(2),
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(egresos.get(2),
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(saldos.get(2),
																						javax.swing.GroupLayout.PREFERRED_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.PREFERRED_SIZE)))))
												.addGap(43, 43, 43)
												.addGroup(panelResumenLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(tipoGraph, javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(select))
												.addGap(0, 65, Short.MAX_VALUE)));
	}

	public void iniciarTextFieldYLabel() {
		
		ingresos = new ArrayList<JTextField>();
		egresos = new ArrayList<JTextField>();
		saldos = new ArrayList<JTextField>();
		mes = new ArrayList<JLabel>();
		
		for (int x = 0; x < 6; x++) {

			ingresos.add(new JTextField());
			egresos.add(new JTextField());
			saldos.add(new JTextField());
			ingresos.get(x).setBackground(new Color(0, 204, 204));
			ingresos.get(x).setVisible(false);
			ingresos.get(x).setEditable(false);
			egresos.get(x).setBackground(new Color(0, 204, 204));
			egresos.get(x).setVisible(false);
			egresos.get(x).setEditable(false);
			saldos.get(x).setBackground(new Color(0, 204, 204));
			saldos.get(x).setVisible(false);
			saldos.get(x).setEditable(false);
			mes.add(new JLabel());
			mes.get(x).setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
			mes.get(x).setForeground(new Color(255, 255, 255));
			mes.get(x).setText("Mes");
			mes.get(x).setVisible(false);
			
		}
		
	}

	private void comboActionPerformed(ActionEvent evt) {

		CardLayout cardLayout = (CardLayout) graph.getLayout();
		cardLayout.show(graph, (String) tipoGraph.getSelectedItem());

	}

	public void llenarResumen() {
		
		ControlPrincipal control = new ControlPrincipal(usuario);
		String[][] resumen = control.resumenMes();

		if (resumen[0][0] != null) {

			for (int x = resumen[0].length - 1, z = 0; x > resumen[0].length - 7 && x >= 0; x--, z++) {

				ingresos.get(z).setText(resumen[2][x]);
				ingresos.get(z).setVisible(true);
				egresos.get(z).setText(resumen[3][x]);
				egresos.get(z).setVisible(true);
				saldos.get(z).setText(resumen[1][x]);
				saldos.get(z).setVisible(true);

				if (resumen[0][x].matches("[0-9]{4}-01")) {

					mes.get(z).setText("Enero");
					mes.get(z).setVisible(true);

				} else if (resumen[0][x].matches("[0-9]{4}-02")) {

					mes.get(z).setText("Febrero");
					mes.get(z).setVisible(true);

				} else if (resumen[0][x].matches("[0-9]{4}-03")) {

					mes.get(z).setText("Marzo");
					mes.get(z).setVisible(true);

				} else if (resumen[0][x].matches("[0-9]{4}-04")) {

					mes.get(z).setText("Abril");
					mes.get(z).setVisible(true);

				} else if (resumen[0][x].matches("[0-9]{4}-05")) {

					mes.get(z).setText("Mayo");
					mes.get(z).setVisible(true);

				} else if (resumen[0][x].matches("[0-9]{4}-06")) {

					mes.get(z).setText("Junio");
					mes.get(z).setVisible(true);

				} else if (resumen[0][x].matches("[0-9]{4}-07")) {

					mes.get(z).setText("Julio");
					mes.get(z).setVisible(true);

				} else if (resumen[0][x].matches("[0-9]{4}-08")) {

					mes.get(z).setText("Agosto");
					mes.get(z).setVisible(true);

				} else if (resumen[0][x].matches("[0-9]{4}-09")) {

					mes.get(z).setText("Septiembre");
					mes.get(z).setVisible(true);

				} else if (resumen[0][x].matches("[0-9]{4}-10")) {

					mes.get(z).setText("Octubre");
					mes.get(z).setVisible(true);

				} else if (resumen[0][x].matches("[0-9]{4}-11")) {

					mes.get(z).setText("Noviembre");
					mes.get(z).setVisible(true);

				} else if (resumen[0][x].matches("[0-9]{4}-12")) {

					mes.get(z).setText("Diciembre");
					mes.get(z).setVisible(true);

				}

			}

		}

	}

	private ChartPanel crearGraphMes() {

		ControlPrincipal control = new ControlPrincipal(usuario);
		String[][] resumen = control.resumenMes();

		dataSetMes = new DefaultCategoryDataset();

		if (resumen[0][0] != null) {

			for (int x = 0; x < resumen[0].length; x++) {

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

	private ChartPanel crearGraphDoc() {

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

	public void actualizarGraphMes() {

		dataSetMes.clear();

		ControlPrincipal control = new ControlPrincipal(usuario);
		String[][] resumen = control.resumenMes();

		if (resumen[0][0] != null) {

			for (int x = 0; x < resumen[0].length; x++) {

				dataSetMes.setValue(Integer.parseInt(resumen[1][x]), "Saldo", resumen[0][x]);

			}

		}

	}

	public void actualizarGraphDoc() {
		ControlPrincipal control = new ControlPrincipal(usuario);

		dataSetDoc.clear();

		int[] resumen = control.resumenDoc();

		dataSetDoc.setValue(resumen[0], "Saldo", "Efectivo");
		dataSetDoc.setValue(resumen[1], "Saldo", "Transferencia");
		dataSetDoc.setValue(resumen[2], "Saldo", "Credito");
	}
}
