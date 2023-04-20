package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MunicipioController;
import controller.ProvinciaController;
import model.Municipio;
import model.Provincia;

import java.awt.GridBagLayout;
import javax.swing.JTextField;

import java.awt.GridBagConstraints;

import javax.swing.JButton;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField jtfFilter;
	private JTextField jtfMunicipio;
	private JButton btnFilter;
	private JButton btnSelect;
	private JButton btnSave;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JComboBox<Municipio> jcbMunicipio;
	private JComboBox<Provincia> jcbProvincia;

	/**
	 * Carga la aplicación
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea el frame
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 0.0};
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 0.0};
//		gbl_contentPane.columnWidths = new int[]{0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0};
//		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		jtfFilter = new JTextField();
		GridBagConstraints gbc_jtfFilter = new GridBagConstraints();
		gbc_jtfFilter.weightx = 1.0;
		gbc_jtfFilter.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFilter.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFilter.gridx = 0;
		gbc_jtfFilter.gridy = 0;
		contentPane.add(jtfFilter, gbc_jtfFilter);
		jtfFilter.setColumns(10);
		
		btnFilter = new JButton("Filtrar");
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMunicipios();
			}
		});
		GridBagConstraints gbc_btnFilter = new GridBagConstraints();
		gbc_btnFilter.insets = new Insets(0, 0, 5, 0);
		gbc_btnFilter.gridx = 1;
		gbc_btnFilter.gridy = 0;
		contentPane.add(btnFilter, gbc_btnFilter);
		
		jcbMunicipio = new JComboBox<Municipio>();
		GridBagConstraints gbc_jcbMunicipio = new GridBagConstraints();
		gbc_jcbMunicipio.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMunicipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMunicipio.gridx = 0;
		gbc_jcbMunicipio.gridy = 1;
		contentPane.add(jcbMunicipio, gbc_jcbMunicipio);
		
		btnSelect = new JButton("Seleccionar");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMunicipio();
			}
		});
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.insets = new Insets(0, 0, 5, 0);
		gbc_btnSelect.gridx = 1;
		gbc_btnSelect.gridy = 1;
		contentPane.add(btnSelect, gbc_btnSelect);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblNewLabel = new JLabel("Municipio Seleccionado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nombre del municipio:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfMunicipio = new JTextField();
		GridBagConstraints gbc_jtfMunicipio = new GridBagConstraints();
		gbc_jtfMunicipio.insets = new Insets(0, 0, 5, 0);
		gbc_jtfMunicipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfMunicipio.gridx = 1;
		gbc_jtfMunicipio.gridy = 1;
		panel.add(jtfMunicipio, gbc_jtfMunicipio);
		jtfMunicipio.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Provincia del municipio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbProvincia = new JComboBox<Provincia>();
		GridBagConstraints gbc_jcbProvincia = new GridBagConstraints();
		gbc_jcbProvincia.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProvincia.gridx = 1;
		gbc_jcbProvincia.gridy = 2;
		panel.add(jcbProvincia, gbc_jcbProvincia);
		
		btnSave = new JButton("Guardar");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.anchor = GridBagConstraints.EAST;
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 3;
		panel.add(btnSave, gbc_btnSave);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.weighty = 1.0;
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		contentPane.add(panel_1, gbc_panel_1);
		
		getProvincias();
	}
	
	/**
	 * Método para obtener las provincias
	 */
	private void getProvincias() {
		jcbProvincia.removeAllItems();
		List<Provincia> l = ProvinciaController.findAll();
		for (Provincia o : l) {
			jcbProvincia.addItem(o);
		}
	}
	
	/**
	 * Método para obtener los municipios
	 */
	private void getMunicipios() {
		jcbMunicipio.removeAllItems();
		List<Municipio> l = MunicipioController.findByLikeName(jtfFilter.getText());
		for (Municipio o : l) {
			jcbMunicipio.addItem(o);
		}
	}
	
	/**
	 * Método para obtener los datos de un municipio
	 */
	private void getMunicipio() {
		Municipio o = (Municipio) jcbMunicipio.getSelectedItem();
		jtfMunicipio.setText(o.getNombre());
		for (int i = 0; i < jcbProvincia.getItemCount(); i++) {
			Provincia p = jcbProvincia.getItemAt(i);
			if (o.getProvincia().getProvincia() == p.getProvincia()) {
				jcbProvincia.setSelectedIndex(i);
			}
		}
	}
	
	/**
	 * Método para guardar los datos
	 */
	private void save() {
		Municipio o = (Municipio) jcbMunicipio.getSelectedItem();
		o.setNombre(jtfMunicipio.getText());
		o.setProvincia((Provincia) jcbProvincia.getSelectedItem());
		MunicipioController.update(o);
	}

}
