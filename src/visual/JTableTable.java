package visual;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import utiles.ControlPrincipal;

public class JTableTable extends JTable{
	
	String usuario;
	public JTableTable(String usuario){
		
		this.usuario = usuario;
		iniciar();
		
	}
	public void iniciar(){
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setBackground(new Color(0, 204, 204));
		setModel(new DefaultTableModel(new Object[][] {}, new String[] { "N°", "Fecha", "Documento",
				"Fuente/Destino", "Descripcion", "Ingreso", "Egreso", "Saldo" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		setGridColor(new Color(255, 255, 255));
		setSelectionForeground(new Color(0, 120, 215));
		
	}
	
	public void actTabla() {

		ControlPrincipal control = new ControlPrincipal(usuario);
		DefaultTableModel modelo = (DefaultTableModel) getModel();
		
		setModel(modelo);
		modelo.setRowCount(0);
		
		if (control.isFiled()) {
			
			for (int x = 0; x < control.getRowCount(); x++) {
				
				Object[] fila = control.getRow(x);
				modelo.addRow(fila);

			}
			
		}

	}
	
}
