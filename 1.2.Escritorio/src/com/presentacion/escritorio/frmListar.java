package com.presentacion.escritorio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;


public class frmListar extends JFrame {

	private JPanel contentPane;
	private JLabel lblNombres;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmListar frame = new frmListar();
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
	public frmListar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		InternalListar r = new InternalListar();
		r.setBounds(5, 99, 511, 332);
		contentPane.add(r);
		
		JButton btnNuevoContacto = new JButton("A\u00F1adir Contacto");
		btnNuevoContacto.setBounds(351, 65, 142, 23);
		btnNuevoContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCrearContacto c = new frmCrearContacto();
				c.show();
				dispose();
			}
		});
		contentPane.add(btnNuevoContacto);
		
		JLabel lblBienvenidoASu = new JLabel("Bienvenido a su Agenda Virtual");
		lblBienvenidoASu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBienvenidoASu.setBounds(169, 11, 221, 23);
		contentPane.add(lblBienvenidoASu);
		
		JLabel lblNombre = new JLabel("Sr.");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(119, 67, 21, 23);
		contentPane.add(lblNombre);
		
		lblNombres = new JLabel("Usuario");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombres.setBounds(143, 69, 151, 19);
		contentPane.add(lblNombres);
		r.setVisible(true);
	}
}
