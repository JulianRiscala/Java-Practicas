package GUI;

import java.awt.*;

public class Chat extends Frame {

	private TextField tfNick;
	private TextField tfMensaje;
	private Button bLogin;
	private Button bLogout;
	private Button bEnviar;
	private List lstLog;
	
	public Chat() {
		super("Chat");
		setLayout (new BorderLayout());
		
		//Panel norte
		Panel pNorth = _crearPNorte();
		add(pNorth, BorderLayout.NORTH);
		
		Panel pCenter = _crearPCenter();
		add(pCenter, BorderLayout.CENTER);
		
		Panel pSouth = _crearPSouth();
		add(pSouth, BorderLayout.SOUTH);
		
		setSize(500,500);
		setVisible(true);
	}
	
	private Panel _crearPNorte(){
		Panel p = new Panel (new FlowLayout(FlowLayout.LEFT));
		
		p.add(new Label("Nick:"));
		tfNick = new TextField(15);
		p.add(tfNick);
		
		bLogin = new Button("Login");
		p.add(bLogin);
		
		bLogout = new Button("Logout");
		p.add(bLogout);
		
		return p;
	}
	
	private Panel _crearPCenter(){
		Panel p = new Panel (new BorderLayout());
		
		//Norte
		p.add(new Label("Conversacion: "), BorderLayout.NORTH);
		
		//Centro
		lstLog = new List();
		p.add(lstLog, BorderLayout.CENTER);
		
		return p;
	}
	
	private Panel _crearPSouth() {
		Panel p = new Panel(new BorderLayout());
		
		//Oeste
		p.add(new Label("Mensaje: "), BorderLayout.WEST);
		
		//Centro
		tfMensaje = new TextField();
		p.add(tfMensaje, BorderLayout.CENTER);
		
		//Este
		bEnviar = new Button("Enviar");
		p.add(bEnviar, BorderLayout.EAST);
		
		return p;
	}
	
	public static void main(String[] args) {
		Chat c = new Chat();
	}

}
