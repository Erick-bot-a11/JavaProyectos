package Biblioteca;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class VentanaLibros extends JDialog {
    private JPanel panel;
    DefaultTableModel modelo = new DefaultTableModel(); //Creo un modelo de tabla
    private JTable tabla;
    
    public VentanaLibros(VentanaPrincipal miVentanaPrincipal, boolean model){
        super(miVentanaPrincipal,model);
        setSize(700,400);//Establece las medidas de la ventana
        setTitle("LIBROS");//Establece el titulo
        setLocationRelativeTo(null);      //Establece la posicion de la ventana al centro
        setResizable(false);     // Establecemos si la ventana puede o no cambiar de mamaño en ejecucion
        
        modeloTabla1();
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
        panel.setBackground(Color.orange); //Establecemos un color al panel
        this.getContentPane().add(panel);   //Agregamos el panel a la ventana
    }

    public void crearEtiquetas() {
        JLabel etiqueta = new JLabel("Libros Registrados:"); //creo una etiqueta, le asigno contenido
        etiqueta.setBounds(90,10,300,18);        //Establesco la posicion de mi eqiqueta
        etiqueta.setOpaque(true);       //Quita lo predeterminado de "etiqueta"
        etiqueta.setBackground(Color.orange);      //Despues de quitar lo predeterminado se puede pintar
        etiqueta.setFont(new Font("arial",Font.ITALIC,16)); //Modifica la fuente de la letra
        panel.add(etiqueta);        //Agrego mi etiqueta al panel
    }

    public void modeloTabla1() {
        modelo.addColumn("Titulo"); //Le agrego columnas a mi modelo
        modelo.addColumn("codigo");
        modelo.addColumn("Autores");
        modelo.addColumn("ISBN");
        modelo.addColumn("Editorial");
        modelo.addColumn("Año");
        modelo.addColumn("Copias");
        leerBinario();
    }
    
    public void crearTabla(){
        tabla = new JTable(modelo);    //CReo mi tabla con el modelo
        tabla.setBounds(50,50,550,300); //Establesco la posicion y el tamaño
        tabla.setEnabled(false);//Le digo queno van a poder editarla los usuarios
        panel.add(tabla);
        JScrollPane barras = new JScrollPane(tabla,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //Creo mi barras de dezplazamiento para que se aprecien las columnas y filas
        barras.setBounds(50,50,600,300);
        panel.add(barras);
    }

    public void leerBinario() {
        Libro libro;
        try {
            String codigo,titulo,autores,isbn,editorial,año;
            FileInputStream archivo=new FileInputStream("Registro_de_Libros.bin");
            ObjectInputStream lector= new ObjectInputStream(archivo);
            while(true){//Seguira hasta llegar al fin del archivo
                 libro=(Libro) lector.readObject();
                 codigo=libro.getCodigo();
                 titulo=libro.getTitulo();
                 autores=libro.getAutores();
                 isbn=libro.getIsbn();
                 editorial=libro.getEditorial();
                 año=libro.getAño();
                 String [] fila={titulo,codigo,autores,isbn,editorial,año,String.valueOf(libro.getCopias())};
                 modelo.addRow(fila);
            }
        }catch (EOFException ex){
            return;//Se llego al final, y paro el buble infinito
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"No hay registro de nungun libro aun\nRegistre libros antes");
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Error 2"+ex);
        }catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error 3"+ex);
        }
    }
}