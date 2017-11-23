package com.presentacion.escritorio;

import pojo.StringJson;
import pojo.Usuario;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 293, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(107, 87, 121, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(107, 118, 121, 20);
		contentPane.add(txtpassword);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String _Usuario = txtUsuario.getText();
				String _Pass = txtpassword.getText();
				String URL ="http://localhost:8080/rest/Usuario/VerificarAcceso" + "?USuario="+_Usuario+"&Password="+_Pass;
	            Usuario u = StringJson.Instancia().ExtraeJsonVerificarAcceso(URL);
				if(u!=null) {
					frmListar frm = new frmListar();
					frm.show();
					dispose();
				}
				else {
					System.out.println("ERROR");
				}
			}
		});
		btnIniciarSesion.setBounds(44, 149, 184, 23);
		contentPane.add(btnIniciarSesion);
		
		JButton btnRegistrarNuevoUsuario = new JButton("Registrar Nuevo Usuario");
		btnRegistrarNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCrearUsuario p = new frmCrearUsuario();
				p.show();
			}
		});
		btnRegistrarNuevoUsuario.setBounds(44, 183, 184, 23);
		contentPane.add(btnRegistrarNuevoUsuario);
		
		JLabel lblBienvenido = new JLabel("Bienvenido al sistema");
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBienvenido.setBackground(Color.DARK_GRAY);
		lblBienvenido.setBounds(37, 32, 203, 20);
		contentPane.add(lblBienvenido);
		
		JLabel lblLogin = new JLabel("Usuario");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLogin.setBounds(44, 89, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContrasea.setBounds(44, 121, 67, 14);
		contentPane.add(lblContrasea);
	}
}
