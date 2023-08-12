package Biblioteca;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaRegistrarLibro extends JDialog {
    private JPanel panel;
    private JButton b1;
    private JTextField c1,c2,c3,c4,c5,c6,c7,c8,c9;
    
    public VentanaRegistrarLibro(VentanaPrincipal miVentanaPrincipal, boolean model){
        super(miVentanaPrincipal,model);
        setSize(400,500);//Establece las medidas de la ventana
        setTitle("REGISTRO DE LIBROS");//Establece el titulo
        setLocationRelativeTo(null);      //Establece la posicion de la ventana al centro
        setResizable(false);     // Establecemos si la ventana puede o no cambiar de mamaño en ejecucion
        iniciarComponentes(); 
    }

    public void iniciarComponentes() {
        crearPanel();
        crearEtiquetas();
        crearCajas();
        crearBoton();
    }
    
    public void crearPanel(){
        panel = new JPanel();    //Creamos un panel
        panel.setLayout(null);      //Desactivo las propiedades determinadas
        panel.setBackground(Color.white); //Establecemos un color al panel
        this.getContentPane().add(panel);   //Agregamos el panel a la ventana
    }

    public void crearEtiquetas() {
        JLabel e1 = new JLabel("Ingresa los siguientes datos"); //creo una etiqueta, le asigno contenido
        e1.setBounds(90,10,400,50);        //Establesco la posicion de mi eqiqueta
        e1.setOpaque(true);       //Quita lo predeterminado de "etiqueta"
        e1.setBackground(Color.white);      //Despues de quitar lo predeterminado se puede pintar
        e1.setFont(new Font("arial",Font.ITALIC,16)); //Modifica la fuente de la letra
        panel.add(e1);        //Agrego mi etiqueta al panel
        
        JLabel e2 = new JLabel("Titulo: ");
        e2.setBounds(40,98,400,20);
        e2.setOpaque(true);
        e2.setBackground(Color.white);
        e2.setFont(new Font("arial",3,14));
        panel.add(e2);
        
        JLabel e3 = new JLabel("ISBN: ");
        e3.setBounds(40,128,400,20);
        e3.setOpaque(true);
        e3.setBackground(Color.white);
        e3.setFont(new Font("arial",3,14));
        panel.add(e3);
        
        JLabel e4 = new JLabel("Editorial: ");
        e4.setBounds(40,158,400,20);
        e4.setOpaque(true);
        e4.setBackground(Color.white);
        e4.setFont(new Font("arial",3,14));
        panel.add(e4);
        
        JLabel e5 = new JLabel("Año: ");
        e5.setBounds(40,188,400,20);
        e5.setOpaque(true);
        e5.setBackground(Color.white);
        e5.setFont(new Font("arial",3,14));
        panel.add(e5);
        
        JLabel e6 = new JLabel("Codigo: ");
        e6.setBounds(40,218,400,20);
        e6.setOpaque(true);
        e6.setBackground(Color.white);
        e6.setFont(new Font("arial",3,14));
        panel.add(e6);
        
        JLabel e7 = new JLabel("Copias: ");
        e7.setBounds(40,248,400,20);
        e7.setOpaque(true);
        e7.setBackground(Color.white);
        e7.setFont(new Font("arial",3,14));
        panel.add(e7);
        
        JLabel e8 = new JLabel("Autores: ");
        e8.setBounds(40,278,400,20);
        e8.setOpaque(true);
        e8.setBackground(Color.white);
        e8.setFont(new Font("arial",3,14));
        panel.add(e8);
        
        JLabel e9 = new JLabel("(Hasta 3 autores) ");
        e9.setBounds(25,295,400,20);
        e9.setOpaque(true);
        e9.setBackground(Color.white);
        e9.setFont(new Font("arial",1,10));
        panel.add(e9);
    }

    public void crearCajas() {
        c1 = new JTextField(null);    //Agregamos una sola linea de texto
        c1.setBounds(110,98,250,20);      //Establecemos la posicion y tamaño
        panel.add(c1);   //Añadimos la caja al panel
        
        c2 = new JTextField("");
        c2.setBounds(110,128,250,20);
        panel.add(c2);
        
        c3 = new JTextField("");
        c3.setBounds(110,158,250,20);
        panel.add(c3);
        
        c4 = new JTextField("");
        c4.setBounds(110,188,250,20);
        panel.add(c4);
        
        c5 = new JTextField("");
        c5.setBounds(110,218,250,20);
        panel.add(c5);
        
        c6 = new JTextField("");
        c6.setBounds(110,248,250,20);
        panel.add(c6);
        
        c7 = new JTextField("");
        c7.setBounds(110,278,250,20);
        panel.add(c7);
        
        c8 = new JTextField("");
        c8.setBounds(110,300,250,20);
        panel.add(c8);
        
        c9 = new JTextField("");
        c9.setBounds(110,322,250,20);
        panel.add(c9);
    }

    public void crearBoton() {
        b1 = new JButton(); //creamos un boton
        b1.setText("Agregar");     //le añadimos texto
        b1.setBounds(150,385,100,20);       //Lo poscisionamos
        b1.setFont(new Font("arial",Font.ROMAN_BASELINE,16));
        panel.add(b1);      //agregamos el boton al panel
        eventoR();
    }
    
    public void eventoR(){
        ActionListener oyenteAccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {//si mi boton se preciona ira aqui
                
                String codigo,titulo,autores,isbn,editorial,año;
                int copias;
                titulo=c1.getText();
                isbn=c2.getText();
                editorial=c3.getText();
                año=c4.getText();
                codigo=c5.getText();
                autores=c7.getText()+" & "+c8.getText()+" & " +c9.getText(); 
                try{
                    copias=Integer.parseInt(c6.getText());
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Ingresa bien los campos");
                    return;
                }
                if ((titulo.length()==0)||(isbn.length()==0)||(editorial.length()==0)||(año.length()==0)||(c6.getText().length()==0)||(codigo.length()==0)||(autores.length()==0))
                {
                    JOptionPane.showMessageDialog(null,"Te falto llenar algun campo");
                    System.out.println("aqui");
                    return;
                }
                Libro ln=new Libro(codigo,titulo,autores,isbn,editorial,año,copias);
                
                escribirBinario(ln);
                JOptionPane.showMessageDialog(null,"Se ah registrado correctamente");
                c1.setText("");
                c2.setText("");
                c3.setText("");
                c4.setText("");
                c5.setText("");
                c6.setText("");
                c7.setText("");
                c8.setText("");
                c9.setText("");
            }
        };
        b1.addActionListener(oyenteAccion);  
    }
    
    public void escribirBinario(Libro ln){
        try {
            FileOutputStream archivo=new FileOutputStream("Registro_de_Libros.bin",true);
            EscribirObjetoBinarioL escribir=new EscribirObjetoBinarioL(archivo);
            escribir.writeObject(ln);
            escribir.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error"+ex);
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Error"+ex);
        }catch(NullPointerException ex){
            JOptionPane.showMessageDialog(null,"Aun no hay nada"+ex);
        }
    }
}
