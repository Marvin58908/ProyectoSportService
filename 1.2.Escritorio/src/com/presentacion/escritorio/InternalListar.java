package com.presentacion.escritorio;
import java.awt.EventQueue;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import pojo.Contacto;
import pojo.StringJson;


public class InternalListar extends JInternalFrame {
	private JTable jtlLista;
	private String TipoEdicion;
	private JScrollPane scrollPane;
	

	private void LimpiarFormulario(){
	}
	
	
	private void HabilitarControles(Boolean Edicion){
		
		jtlLista.enable(!Edicion);
	}
	
	private void ListarContactos(){
		try {
			String URL = "http://localhost:8080/rest/Contacto/ListarContacto";
			((DefaultTableModel)jtlLista.getModel()).setRowCount(0);
			ArrayList<Contacto> lista = StringJson.Instancia().ExtraeJsonListarContacto(URL);
			for(int i=0;i<lista.size();i++){
				String Nombre = lista.get(i).getNombre();
				String FechaNacimiento = lista.get(i).getFechaNacimiento().toString();				
				String TelefonoPrincipal = lista.get(i).getTelefonoPrincipal();
				Object[] xyz = new Object[]{Nombre, FechaNacimiento ,TelefonoPrincipal};
				((DefaultTableModel)jtlLista.getModel()).addRow(xyz);
			}			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					e.getMessage(), 
					"Sistema Mantenedor", 
					JOptionPane.ERROR_MESSAGE);
		}		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InternalListar frame = new InternalListar();
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
	public InternalListar() {
		setBounds(100, 100, 490, 242);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 454, 191);
		getContentPane().add(scrollPane);
		
		jtlLista = new JTable();
		scrollPane.setViewportView(jtlLista);
		jtlLista.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "FechaDeNacimiento", "Telefono Principal"
			}
		));

		ListarContactos();
		HabilitarControles(false);
	}


}
