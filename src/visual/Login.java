package visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

import utiles.ControlLogin;

public class Login{

	private JFrame frame;
    private JLabel Ingresar;
    private JButton bIngresar;
    private JButton bRegistrar;
    private JButton bSalir;
    private JLabel bienvenido;
    private JPasswordField fPass;
    private JTextField fUser;
    private JLabel lPass;
    private JLabel lUser;
    private JPanel panel;          
    
    public Login() {
        initComponents();
    }
                    
    private void initComponents() {
    	
    	frame = new JFrame();
        panel = new JPanel();
        Ingresar = new JLabel();
        bienvenido = new JLabel();
        bIngresar = new JButton();
        bSalir = new JButton();
        fUser = new JTextField();
        lUser = new JLabel();
        lPass = new JLabel();
        fPass = new JPasswordField();
        bRegistrar = new JButton();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new Color(21, 21, 21));

        Ingresar.setBackground(new Color(0, 204, 204));
        Ingresar.setFont(new Font("Eras Light ITC", 2, 48)); // NOI18N
        Ingresar.setForeground(new Color(0, 204, 204));
        Ingresar.setText("Ingresar!");

        bienvenido.setFont(new Font("Eras Light ITC", 0, 14)); // NOI18N
        bienvenido.setForeground(new Color(255, 255, 255));
        bienvenido.setText("Bienvenido de nuevo a P.A.M!");

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
        lUser.setFont(new Font("Eras Light ITC", 0, 18)); // NOI18N
        lUser.setForeground(new Color(0, 204, 204));
        lUser.setText("Usuario");

        lPass.setBackground(new Color(0, 204, 204));
        lPass.setFont(new Font("Eras Light ITC", 0, 18)); // NOI18N
        lPass.setForeground(new Color(0, 204, 204));
        lPass.setText("Contraseña");

        bRegistrar.setText("Registrarse");
        bRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                bRegistrarActionPerformed(evt);
            }
        });

        GroupLayout panelCartola1Layout = new GroupLayout(panel);
        panel.setLayout(panelCartola1Layout);
        panelCartola1Layout.setHorizontalGroup(
            panelCartola1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelCartola1Layout.createSequentialGroup()
                .addContainerGap(267, Short.MAX_VALUE)
                .addGroup(panelCartola1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(bienvenido)
                    .addGroup(panelCartola1Layout.createSequentialGroup()
                        .addGroup(panelCartola1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(Ingresar, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCartola1Layout.createSequentialGroup()
                                .addGroup(panelCartola1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelCartola1Layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(lUser))
                                    .addGroup(panelCartola1Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(lPass))
                                    .addComponent(fUser)
                                    .addGroup(panelCartola1Layout.createSequentialGroup()
                                        .addComponent(bIngresar, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bSalir, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                                    .addComponent(fPass))
                                .addGap(38, 38, 38)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addComponent(bRegistrar, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelCartola1Layout.setVerticalGroup(
            panelCartola1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelCartola1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(Ingresar, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bienvenido, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lUser)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fUser, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lPass)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fPass, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(panelCartola1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(bSalir)
                    .addComponent(bIngresar))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(bRegistrar)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        frame.getRootPane().setDefaultButton(bIngresar);
        frame.pack();
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }            


    private void bIngresarActionPerformed(ActionEvent evt) {                              
    	ControlLogin control = new ControlLogin();
        if(control.isUserPass(fUser.getText(), String.valueOf(fPass.getPassword())))
        {
        	Principal principal = new Principal(fUser.getText());
        	frame.dispose();
        }else
        {
			javax.swing.JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectas", null,
					javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }          
    private void bSalirActionPerformed(ActionEvent evt) {                                          
        System.exit(0);
    } 
    private void bRegistrarActionPerformed(ActionEvent evt) {                                          
        Registro registro = new Registro();
        frame.dispose();
    }               
                 
}
