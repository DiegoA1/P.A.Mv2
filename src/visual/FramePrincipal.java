package visual;

import java.awt.*;
import javax.swing.*;

public class FramePrincipal extends JFrame{

	private JPanel panel;
	
	private PanelPrincipal panelPrincipal;
	private PanelCartola panelCartola;
	private PanelResumen panelResumen;
	
	private String usuario;

	public FramePrincipal(String usuario) {

		this.usuario = usuario;
		initComponents();

	}

	private void initComponents() {
		panel = new JPanel();
		panelResumen = new PanelResumen(usuario);
		panelPrincipal = new PanelPrincipal(usuario);
		panelCartola = new PanelCartola(usuario);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		panel.setBackground(new Color(204, 204, 204));
		panel.setRequestFocusEnabled(false);
		panel.setLayout(new CardLayout());
		panel.add(panelCartola, "card2");
		panel.add(panelResumen, "card3");
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
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
		
		setTitle("P.A.M - (Personal Account Managger)");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void openResumen(){
		CardLayout cardLayout = (CardLayout) panel.getLayout();
		cardLayout.show(panel, "card3");
	}

	public void openCartola(){
		CardLayout cardLayout = (CardLayout) panel.getLayout();
		cardLayout.show(panel, "card2");
	}
	
	public void actResumen(){
		panelResumen.actualizarGraphDoc();
		panelResumen.actualizarGraphMes();
		panelResumen.llenarResumen();
	}
	

	

	

	
}
