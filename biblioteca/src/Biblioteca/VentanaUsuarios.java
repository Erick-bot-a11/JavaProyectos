package Biblioteca;

import java.awt.Color;
import java.awt.Font;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class VentanaUsuarios extends JDialog {
    private JPanel panel;
    DefaultTableModel modelo = new DefaultTableModel(); //Creo un modelo de tabla
    private JTable tabla;
    
    public VentanaUsuarios(VentanaPrincipal miVentanaPrincipal, boolean model){
        super(miVentanaPrincipal,model);
        setSize(900,400);//Establece las medidas de la ventana
        setTitle("USUARIOS");//Establece el titulo
        setLocationRelativeTo(null);      //Establece la posicion de la ventana al centro
        setResizable(false);     // Establecemos si la ventana puede o no cambiar de mamaño en ejecucion
        modeloTabla();
        iniciarComponentes(); 
    }

    public void iniciarComponentes() {
        crearPanel();
        crearEtiquetas();
        crearTabla();
    }
    
    public void crearPanel(){
        panel = new JPanel();    //Creamos un panel
        panel.setLayout(null);      //Desactivo las propiedades determinadas
        panel.setBackground(Color.white); //Establecemos un color al panel
        this.getContentPane().add(panel);   //Agregamos el panel a la ventana
    }

    public void crearEtiquetas() {
        JLabel etiqueta = new JLabel("Libros Registrados:"); //creo una etiqueta, le asigno contenido
        etiqueta.setBounds(90,10,400,18);        //Establesco la posicion de mi eqiqueta
        etiqueta.setOpaque(true);       //Quita lo predeterminado de "etiqueta"
        etiqueta.setBackground(Color.white);      //Despues de quitar lo predeterminado se puede pintar
        etiqueta.setFont(new Font("arial",Font.ITALIC,16)); //Modifica la fuente de la letra
        panel.add(etiqueta);        //Agrego mi etiqueta al panel
    }
    
    public void modeloTabla() {
        modelo.addColumn("Nombre"); //Le agrego columnas a mi modelo
        modelo.addColumn("Dirección");
        modelo.addColumn("Telefono");
        modelo.addColumn("Fecha de Nacimiento");
        modelo.addColumn("Fecha de Inscripción");
        modelo.addColumn("Fecha de vigencia");
        leerBinario();
    }
    
    public void crearTabla(){
        tabla = new JTable(modelo);    //CReo mi tabla con el modelo
        tabla.setBounds(50,50,800,300); //Establesco la posicion y el tamaño
        tabla.setEnabled(false);//Le digo queno van a poder editarla los usuarios
        panel.add(tabla);
        
        JScrollPane barras = new JScrollPane(tabla,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //Creo mi barras de dezplazamiento para que se aprecien las columnas y filas
        barras.setBounds(50,50,800,300);
        panel.add(barras);
    }
    
    public void leerBinario() {
        Usuario us;
        String nombre,direccion,telefono,fechaNacimiento,fechaInscripcion,fechaVigencia;
        try {
            FileInputStream archivo=new FileInputStream("Registro_de_Usuarios.bin");
            ObjectInputStream lector= new ObjectInputStream(archivo);
            while(true){//Seguira hasta llegar al fin del archivo
                 us=(Usuario) lector.readObject();
                 nombre=us.getNombre();
                 direccion=us.getDireccion();
                 telefono=us.getTelefono();
                 fechaNacimiento=us.getFechaNacimiento();
                 fechaInscripcion=us.getFechaInscripcion();
                 fechaVigencia=us.getFechaVigencia();
                 
                 String [] fila={nombre,direccion,telefono,fechaNacimiento,fechaInscripcion,fechaVigencia};
                 modelo.addRow(fila);
            }
        }catch (EOFException ex){
            return;//Se llego al final, y paro el buble infinito
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"No hay registro de ningun Usuario aun\nRegistre Usuarios antes");
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No hay registro de ningun libro aun\nRegistre libros antes");
        }catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error 3"+ex);
        }
    }
}