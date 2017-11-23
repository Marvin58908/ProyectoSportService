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


public class frmCrearContacto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtGenero;
	private JTextField txtTelefono;
	private JTable jtlLista;
	private String TipoEdicion;
	private JTextField txtTelAux;
	private JTextField txtDireccion;
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
					frmCrearContacto frame = new frmCrearContacto();
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
	public frmCrearContacto() {
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
		lblApellidos.setBounds(10, 80, 88, 14);
		panel.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(108, 77, 267, 20);
		panel.add(txtApellidos);
		
		txtGenero = new JTextField();
		txtGenero.setColumns(10);
		txtGenero.setBounds(108, 133, 267, 20);
		panel.add(txtGenero);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(108, 164, 267, 20);
		panel.add(txtTelefono);
		
		JLabel lblTelefono = new JLabel("tel\u00E9fono:");
		lblTelefono.setBounds(10, 168, 103, 14);
		panel.add(lblTelefono);
		
		JLabel lblTelAux = new JLabel("Tel.Auxiliar");
		lblTelAux.setBounds(10, 193, 64, 14);
		panel.add(lblTelAux);
		
		txtTelAux = new JTextField();
		txtTelAux.setBounds(108, 195, 267, 20);
		panel.add(txtTelAux);
		txtTelAux.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(108, 226, 267, 20);
		panel.add(txtDireccion);
		
		JLabel lblDireccion_1 = new JLabel("Direccion");
		lblDireccion_1.setBounds(10, 229, 46, 14);
		panel.add(lblDireccion_1);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(10, 105, 88, 14);
		panel.add(lblFechaNacimiento);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(10, 136, 46, 14);
		panel.add(lblGenero);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(108, 108, 95, 20);
		panel.add(dateChooser);
		
		JLabel lblCrearContacto = new JLabel("Crear Contacto");
		lblCrearContacto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCrearContacto.setBounds(173, 25, 142, 25);
		getContentPane().add(lblCrearContacto);
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Contacto c = new Contacto();
				try {
					c.setNombre(txtNombre.getText());
					c.setApellido(txtApellidos.getText());
					Date fecha = dateChooser.getDate();
					c.setFechaNacimiento(fecha);
					c.setGenero(txtGenero.getText());
					c.setDireccion(txtGenero.getText());
					c.setTelefonoPrincipal(txtTelefono.getText());
					c.setTelefonoAuxiliar(txtTelefono.getText());
					c.setDireccion(txtDireccion.getText());
					String URL ="http://localhost:8080/rest/Contacto/Nuevo?" + 
							"Nombre=" + c.getNombre()+
							"&Apellido="  + c.getApellido()+
							"&FechaNacimiento=" + (1900+fecha.getYear())+"-"+(fecha.getMonth()+1)+"-"+fecha.getDate()+
							"&Genero=" + c.getGenero() +
							"&TelefonoPrincipal=" + c.getTelefonoPrincipal() +
							"&TelefonoAuxiliar=" + c.getTelefonoAuxiliar() +
							"&Direccion=" +c.getDireccion(); 
		            c = StringJson.Instancia().ExtraeJsonInsertarContacto(URL);
		            if(c!=null) {
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
				txtGenero.setText("");
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

