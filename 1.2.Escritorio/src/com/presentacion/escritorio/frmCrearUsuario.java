package com.presentacion.escritorio;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import pojo.Contacto;
import pojo.StringJson;
import pojo.Usuario;

import com.sun.jna.platform.win32.OaIdl;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;


public class frmCrearUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTable jtlLista;
	private String TipoEdicion;
	private JTextField txtContrasenia;
	/**
	 * @wbp.nonvisual location=157,219
	 */
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCrearUsuario frame = new frmCrearUsuario();
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
	public frmCrearUsuario() {
		setBounds(100, 100, 490, 473);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, " Datos del Nuevo Contacto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 72, 454, 250);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(10, 52, 64, 14);
		panel.add(lblNombres);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(108, 49, 267, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 114, 88, 14);
		panel.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(108, 111, 267, 20);
		panel.add(txtApellidos);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(108, 142, 267, 20);
		panel.add(txtTelefono);
		
		JLabel lblTelefono = new JLabel("tel\u00E9fono:");
		lblTelefono.setBounds(10, 139, 103, 14);
		panel.add(lblTelefono);
		
		txtContrasenia = new JTextField();
		txtContrasenia.setBounds(108, 80, 267, 20);
		panel.add(txtContrasenia);
		txtContrasenia.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contrasenia:");
		lblContrasenia.setBounds(10, 77, 74, 14);
		panel.add(lblContrasenia);
		
		JLabel lblCrearContacto = new JLabel("Crear Contacto");
		lblCrearContacto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCrearContacto.setBounds(173, 25, 142, 25);
		getContentPane().add(lblCrearContacto);
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Usuario u = new Usuario();
				try {
					u.setName(txtNombre.getText());
					u.setContrasenia(txtContrasenia.getText());
					u.setTelefono(txtTelefono.getText());
					u.setApellido(txtApellidos.getText());
					
					
					
					String URL = 
							"http://localhost:8080/rest/Usuario/Nuevo?" + 
									"&Name=" + u.getName()+
									"&Contrasenia="  + u.getContrasenia()+
									"&Telefono=" + u.getTelefono()+
									"&Apellido=" + u.getApellido();
		            u = StringJson.Instancia().ExtraeJsonInsertarUsuario(URL);
		            if(u!=null) {
						frmListar frm = new frmListar();
						frm.show();
						dispose();
					}
					else {
						System.out.println("ERROR");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), 
							"Contacto", JOptionPane.WARNING_MESSAGE);
				}
				JOptionPane.showMessageDialog(null, "Se inserto correctamente", 
						"Contacto", JOptionPane.WARNING_MESSAGE);
				frmListar p = new frmListar();
				p.show();
				dispose();
			}
		});
		btnCrear.setBounds(105, 368, 89, 23);
		getContentPane().add(btnCrear);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				txtApellidos.setText("");
				//txtFechaNacimiento.setText(dateChooser.getDate());
			
				txtTelefono.setText("");
			}
		});
		btnLimpiar.setBounds(204, 368, 89, 23);
		getContentPane().add(btnLimpiar);
		
		JButton btnCancelar_1 = new JButton("Cancelar");
		btnCancelar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar_1.setBounds(303, 368, 89, 23);
		getContentPane().add(btnCancelar_1);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}
}

