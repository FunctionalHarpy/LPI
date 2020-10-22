package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import mantenimientos.GestionUsuarios;
import model.Usuario;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmMantenimientoUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private JDateChooser txtFecha;
	private JTextField txtCodigo;
	private JComboBox cboTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantenimientoUsuario frame = new FrmMantenimientoUsuario();
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
	public FrmMantenimientoUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeUsuario = new JLabel("Mantenimiento de Usuario");
		lblRegistroDeUsuario.setBounds(28, 11, 224, 32);
		contentPane.add(lblRegistroDeUsuario);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(28, 65, 71, 14);
		contentPane.add(lblCdigo);
		
		JLabel lblAutogenerado = new JLabel("Autogenerado");
		lblAutogenerado.setBounds(200, 65, 92, 14);
		contentPane.add(lblAutogenerado);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(28, 94, 71, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(28, 121, 71, 14);
		contentPane.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(28, 146, 71, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave:");
		lblClave.setBounds(28, 176, 71, 14);
		contentPane.add(lblClave);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(28, 206, 71, 14);
		contentPane.add(lblFecha);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(87, 91, 130, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(87, 118, 130, 20);
		contentPane.add(txtApellido);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(87, 146, 68, 20);
		contentPane.add(txtUsuario);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(87, 173, 71, 20);
		contentPane.add(txtClave);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrarDatos();
			}
		});
		btnRegistrar.setBounds(302, 46, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(302, 202, 89, 23);
		contentPane.add(btnLimpiar);
		
		txtFecha = new JDateChooser();
		txtFecha.setDateFormatString("dd-MM-yyyy");
		txtFecha.setBounds(87, 200, 95, 20);
		contentPane.add(txtFecha);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(302, 80, 89, 23);
		contentPane.add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(302, 112, 89, 23);
		contentPane.add(btnEliminar);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(87, 62, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblStado = new JLabel("Tipo :");
		lblStado.setBounds(28, 236, 71, 14);
		contentPane.add(lblStado);
		
		cboTipo = new JComboBox();
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "1-Administrador", "2-Cliente", "3-Cajero"}));
		cboTipo.setBounds(87, 233, 130, 20);
		contentPane.add(cboTipo);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(302, 142, 89, 23);
		contentPane.add(btnBuscar);
	}
	

	private int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}

	private int leerTipo() {
		return cboTipo.getSelectedIndex();
	}

	void registrarDatos(){
		// variables
		String nombre, apellido, usuario, clave, fnacim;
		// entradas
		nombre   = leerNombre();
		apellido = leerApellido();
		usuario  = leerUsuario();
		clave    = leerClave();
		fnacim   = leerFecha();
		
		// procesos
		Usuario u = new Usuario(99, nombre, apellido, usuario, clave, fnacim, 99, 99);
		
//		Usuario u = new Usuario();
//		u.setNombre(nombre);
//		u.setApellido(apellido);
//		u.setUsuario(usuario);
//		u.setClave(clave);
//		u.setFnacim(fnacim);
		
		// Para poder grabar en la BD -> se llama a la clase de Gestiòn
		GestionUsuarios gu = new GestionUsuarios();
		int ok = gu.registrar(u);		
		// salidas
		if (ok == 0){
			JOptionPane.showMessageDialog(this, "Error al registrar");
		} else {
			JOptionPane.showMessageDialog(this, "usuario " + u.getNombre() + " registrado");
		}
	}

	private String leerFecha() {   // revisar 1ra sesión
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(txtFecha.getDate());
	}

	private String leerClave() {
		// TODO Auto-generated method stub
		return txtClave.getText();
	}

	private String leerUsuario() {
		// TODO Auto-generated method stub
		return txtUsuario.getText();
	}

	private String leerApellido() {
		// TODO Auto-generated method stub
		return txtApellido.getText();
	}

	private String leerNombre() {
		// TODO Auto-generated method stub
		return txtNombre.getText();
	}
}
