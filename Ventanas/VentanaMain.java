package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;;

public class VentanaMain extends JFrame{
	private JTextField tEmail;
	private JPasswordField tPass;
	private JPasswordField tRepetirPass;
	private final ButtonGroup metodoPagoGroup = new ButtonGroup();
	private JTextField textField;
	private JPasswordField passwordField;
	
	
	public VentanaMain(){
		
		super("Le Restaurant");
		setSize(500,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//Paneles
		
		JPanel pMain = new JPanel();
		pMain.setBounds(0, 0, 484, 261);
		getContentPane().add(pMain);
		
		JPanel pIniciarSesion = new JPanel();
		pIniciarSesion.setBounds(0, 0, 484, 261);
		getContentPane().add(pIniciarSesion);
		pIniciarSesion.setLayout(null);
		
		JPanel pRegistrarse = new JPanel();
		pRegistrarse.setBounds(0, 0, 484, 261);
		getContentPane().add(pRegistrarse);
		pRegistrarse.setLayout(null);
		
		//Elementos
		
		JButton registrarse = new JButton("Registrarse");
		
		JButton Isesion = new JButton("Iniciar Sesion");

		pMain.setLayout(null);
		JPanel pBotones = new JPanel();
		pBotones.setBounds(20, 204, 454, 46);
		pMain.add(pBotones);
		//registrarse.addActionListener();
		pBotones.add(registrarse);
		pBotones.add(Isesion);
		
		JLabel label2 = new JLabel(Descripcion(),JLabel.CENTER);
		label2.setBounds(10, 74, 464, 131);
		pMain.add(label2);
		label2.setFont(new Font("TimesNewRoman",Font.PLAIN,12));
		JLabel label = new JLabel("Le Restaurant",JLabel.CENTER);
		label.setBounds(106, 11, 262, 52);
		pMain.add(label);
		label.setFont(new Font("TimesNewRoman",Font.BOLD,40));
		pMain.setVisible(true);
		

		
		JLabel lblEmail1 = new JLabel("Email");
		lblEmail1.setBounds(64, 80, 80, 25);
		pIniciarSesion.add(lblEmail1);
		
		JLabel lblContraseña1 = new JLabel("Contrase\u00F1a");
		lblContraseña1.setBounds(64, 116, 94, 25);
		pIniciarSesion.add(lblContraseña1);
		
		textField = new JTextField();
		textField.setBounds(154, 80, 180, 25);
		pIniciarSesion.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(154, 118, 180, 25);
		pIniciarSesion.add(passwordField);
		
		JButton btnVolver1 = new JButton("Volver");
		btnVolver1.setBounds(116, 215, 89, 23);
		pIniciarSesion.add(btnVolver1);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(257, 215, 89, 23);
		pIniciarSesion.add(btnIniciar);
		

		

		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(41, 24, 101, 27);
		pRegistrarse.add(lblEmail);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(41, 62, 101, 22);
		pRegistrarse.add(lblContrasea);
		
		JLabel lblRepetircontrasea = new JLabel("Repetir Contrase\u00F1a");
		lblRepetircontrasea.setBounds(41, 95, 101, 22);
		pRegistrarse.add(lblRepetircontrasea);
		
		JLabel lblMetodoDePago = new JLabel("Metodo De Pago");
		lblMetodoDePago.setBounds(41, 128, 101, 29);
		pRegistrarse.add(lblMetodoDePago);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(131, 227, 89, 23);
		pRegistrarse.add(btnVolver);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(253, 227, 89, 23);
		pRegistrarse.add(btnRegistrarse);
		
		tEmail = new JTextField();
		tEmail.setToolTipText("Email");
		tEmail.setBounds(152, 26, 225, 22);
		pRegistrarse.add(tEmail);
		tEmail.setColumns(10);
		
		tPass = new JPasswordField();
		tPass.setBounds(152, 63, 225, 21);
		pRegistrarse.add(tPass);
		
		tRepetirPass = new JPasswordField();
		tRepetirPass.setBounds(152, 96, 225, 21);
		pRegistrarse.add(tRepetirPass);
		
		JRadioButton rdbtnTarjeta = new JRadioButton("Tarjeta");
		metodoPagoGroup.add(rdbtnTarjeta);
		rdbtnTarjeta.setBounds(148, 131, 109, 23);
		pRegistrarse.add(rdbtnTarjeta);
		
		JRadioButton rdbtnMetalico = new JRadioButton("Metalico");
		metodoPagoGroup.add(rdbtnMetalico);
		rdbtnMetalico.setBounds(268, 131, 109, 23);
		pRegistrarse.add(rdbtnMetalico);
		
		JRadioButton rdbtnPaypal = new JRadioButton("Paypal");
		metodoPagoGroup.add(rdbtnPaypal);
		rdbtnPaypal.setBounds(379, 131, 99, 23);
		pRegistrarse.add(rdbtnPaypal);
		pRegistrarse.setVisible(false);
		pIniciarSesion.setVisible(false);
		
		
		//ActionListener
		
		registrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pMain.setVisible(false);
				pRegistrarse.setVisible(true);
			}
		});
		
		Isesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pMain.setVisible(false);
				pIniciarSesion.setVisible(true);
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pMain.setVisible(true);
				pRegistrarse.setVisible(false);
			}
		});
		
		btnVolver1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pMain.setVisible(true);
				pIniciarSesion.setVisible(false);
			}
		});
	}

	private String Descripcion() {
		String text="<html><body>";
		text+="Bienvenido al restaurante LE RESTAURANT<br>";
		text+="Este restaurante se caracteriza en poder personalizar tu comida tal y como quiera el cliente,<br> agregando y quitando ingredientes a placer.";
		text+="</body></html>";
		
		return text;
	}
}
