package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class ChatSwing extends JFrame {

	private JTextField tfNick;
	private JTextField tfMensaje;
	private JButton bLogin;
	private JButton bLogout;
	private JButton bEnviar;
	private JList lstLog;
	private Border border;
	
	public ChatSwing() {
	    super("Chat");
		
		//Le pedimos el panel de contencion al JFrame
		Container content = getContentPane();
		
		//Seteamos el layout
		content.setLayout(new BorderLayout());
		
		//Este sera el tipo de borde que utilizamos en todos los paneles
		border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		JPanel pNorth = _crearPNorte();
		content.add(pNorth, BorderLayout.NORTH);
		
		JPanel pCenter = _crearPCentro();
		content.add(pCenter,BorderLayout.CENTER);
		
		JPanel pSouth = _crearPSur();
		content.add(pSouth,BorderLayout.SOUTH);
		
		setSize(500,500);
		setVisible(true);
	}

	private JPanel _crearPNorte() {
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		
		//Instancio un TitledBorder con el titulo y el objeto border que creé en el constructor
		TitledBorder titleBorder = BorderFactory.createTitledBorder(border, "Nick");
		
		//Asigno el titled border al panel
		p.setBorder(titleBorder);
		
		tfNick = new JTextField(10);
		p.add(tfNick);
		
		bLogin = new JButton("Login");
		p.add(bLogin);
		
		bLogout = new JButton("Logout");
		p.add(bLogout);
		
		return p;
	}
	
	private JPanel _crearPCentro() {
		JPanel p = new JPanel(new BorderLayout());
		TitledBorder titleBorder = BorderFactory.createTitledBorder(border,"Conversacion");
		
		p.setBorder(titleBorder);
		
		lstLog = new JList();
		JScrollPane scroll = new JScrollPane(lstLog);
		p.add(scroll,BorderLayout.CENTER);
		
		return p;
	}
	
	private JPanel _crearPSur() {
		JPanel p = new JPanel(new BorderLayout());
		TitledBorder titleBorder = BorderFactory.createTitledBorder(border,"Mensaje");
		
		p.setBorder(titleBorder);
		
		tfMensaje = new JTextField();
		p.add(tfMensaje,BorderLayout.CENTER);
		
		bEnviar = new JButton("Enviar");
		p.add(bEnviar,BorderLayout.EAST);
		
		return p;
	}
	
	public static void main(String[] args) throws Exception {

		UIManager.setLookAndFeel(new MetalLookAndFeel());
		ChatSwing c = new ChatSwing();
	}

}
