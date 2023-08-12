package Biblioteca;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class VentanaPrestar extends JDialog {
    private JPanel panel;
    private JTextField c1,c2;
    private JButton b1;
    DefaultComboBoxModel modelo = new DefaultComboBoxModel();   //Creo un modelo para mi lista
    private JComboBox lista1; //Creo una lista desplegable, su contenido seran de tipo modelo
    private Usuario us=null;   //Creo un objeto de la clase persona para leer el contenido del archivo que tiene objetos Persona
    private Libro libro=null;
    private String dia,mes,año,fechaA,fechaN;
    private int cuota,mes2,año2;
    
    public VentanaPrestar(VentanaPrincipal miVentanaPrincipal, boolean model){
        super(miVentanaPrincipal,model);
        setSize(400,400);//Establece las medidas de la ventana
        setTitle("PRESTAMOS");//Establece el titulo
        setLocationRelativeTo(null);      //Establece la posicion de la ventana al centro
        setResizable(false);     // Establecemos si la ventana puede o no cambiar de mamaño en ejecucion
        iniciarComponentes(); 
    }

    public void iniciarComponentes() {
        crearPanel();
        crearEtiquetas();
        crearCajas();
        crearLista();
        crearBoton();
        
    }
    
    public void crearPanel(){
        panel = new JPanel();    //Creamos un panel
        panel.setLayout(null);      //Desactivo las propiedades determinadas
        panel.setBackground(Color.white); //Establecemos un color al panel
        this.getContentPane().add(panel);   //Agregamos el panel a la ventana
    }

    public void crearEtiquetas() {
        JLabel etiqueta = new JLabel("Ingresa los siguientes datos"); //creo una etiqueta, le asigno contenido
        etiqueta.setBounds(90,10,400,50);        //Establesco la posicion de mi eqiqueta
        etiqueta.setOpaque(true);       //Quita lo predeterminado de "etiqueta"
        etiqueta.setBackground(Color.white);      //Despues de quitar lo predeterminado se puede pintar
        etiqueta.setFont(new Font("arial",Font.ITALIC,16)); //Modifica la fuente de la letra
        panel.add(etiqueta);        //Agrego mi etiqueta al panel
        
        JLabel e2 = new JLabel("Nombre de Usuario: ");
        e2.setBounds(40,100,400,20);
        e2.setOpaque(true);
        e2.setBackground(Color.white);
        e2.setFont(new Font("arial",1,14));
        panel.add(e2);
        
        JLabel e3 = new JLabel("Titulo del Libro: ");
        e3.setBounds(40,140,400,20);
        e3.setOpaque(true);
        e3.setBackground(Color.white);
        e3.setFont(new Font("arial",1,14));
        panel.add(e3);
        
        JLabel e4 = new JLabel("Tiempo del Prestamo: ");
        e4.setBounds(40,180,170,20);
        e4.setOpaque(true);
        e4.setBackground(Color.white);
        e4.setFont(new Font("arial",1,14));
        panel.add(e4);
    }
    
    public void crearCajas(){
        c1 = new JTextField("");    //Agregamos una sola linea de texto
        c1.setBounds(190,100,200,20);      //Establecemos la posicion y tamaño
        panel.add(c1);   //Añadimos la caja al panel
        
        c2 = new JTextField("");
        c2.setBounds(170,140,220,20);
        panel.add(c2);
    }
    
    public void crearLista(){
        lista1 = new JComboBox(modelo); //Creo una lista desplegable, su contenido seran de tipo modelo
        modelo.addElement("MESES");
        modelo.addElement("1");    //Agrego a mi modelo elentos
        modelo.addElement("2");
        modelo.addElement("3");
        modelo.addElement("6");
        
        lista1.setBounds(210,180,100,20);   //Le pongo posicion y tamaño
        panel.add(lista1); //La agrego
    }
    
    public void crearBoton() {
        b1 = new JButton(); //creamos un boton
        b1.setText("Realizar Prestamo");     //le añadimos texto
        b1.setBounds(120,250,200,20);       //Lo poscisionamos
        b1.setFont(new Font("arial",Font.ROMAN_BASELINE,16));
        panel.add(b1);      //agregamos el boton al panel
        eventoR();
    }
    
    public void eventoR(){
        cuota=0;
        ActionListener oyenteAccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {//si mi boton se preciona ira aqui
                    String cout=(String)lista1.getSelectedItem();
                    try{
                        leerUsuario();
                        leerLibro();
                        if (confirmarVigencia()==0)
                            cuota=10*Integer.parseInt(cout);
                       if (libro.getCopias()==0){
                            JOptionPane.showMessageDialog(null,"No se puede alquilar ya que no se cuenta con Copias de este Libro");
                            return;
                        } 
                        libro.setCopias(libro.getCopias()-1);
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(null,"Ingresaste incorrecto el campo 'MESES'");
                        return;
                    }catch(NullPointerException ex){
                        return;
                    }
                    
                if ((us==null)||(libro==null)){
                    return;
                }
                JOptionPane.showMessageDialog(null,"Se ah prestado correctamente");
                Prestamo pr =new Prestamo(libro.getTitulo(),us.getNombre(),fechaA,fechaN,cuota);
                escribirPrestamo(pr);
                b1.setEnabled(false);
            }
        };
        b1.addActionListener(oyenteAccion);  
    }
    
    public int confirmarVigencia(){
        Calendar c1 = Calendar.getInstance();
        dia = Integer.toString(c1.get(Calendar.DATE));
        if (Integer.parseInt(dia)<=9){
            dia="0"+dia;
        }
        mes = Integer.toString(c1.get(Calendar.MONTH)+1);
        if (Integer.parseInt(mes)<=9){
            mes="0"+mes;
        }
        año= Integer.toString(c1.get(Calendar.YEAR));
        fechaA=dia+"/"+mes+"/"+año;
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");//En esto comprobare si la fecha vigencia aun no vence
            Date actualDate = null;
            Date vigenciaDate = null;
            try {
                actualDate = formato.parse(dia+"-"+mes+"-"+año);
                vigenciaDate = formato.parse(us.getFechaVigencia());
            } catch (ParseException ex) {
                System.out.println("error");
            }catch (NullPointerException ex) {
            }
            try{
                if(actualDate.after(vigenciaDate)){
                JOptionPane.showMessageDialog(null,"La Vigencia esta caduca\nSe le cobrara una cuota de $10 por mes");
                nuevaFecha();
                return 0;
            }
            }catch(NullPointerException ex){
                JOptionPane.showMessageDialog(null,"Ingrese Datos Correctos");
            }
            
        nuevaFecha();
        return 1;
    }
    
    public void nuevaFecha(){
        mes2=Integer.parseInt(mes);
        año2=Integer.parseInt(año);
        String inc=(String)lista1.getSelectedItem();
        mes2=Integer.parseInt(inc)+mes2;
        if (mes2>12){
            if(mes2==13)
                mes2=1;
            if(mes2==14)
                mes2=2;
            if(mes2==15)
                mes2=3;
            if(mes2==16)
                mes2=4;
            if(mes2==17)
                mes2=5;
            if(mes2==18)
                mes2=6;
            año2++;
        }
        fechaN= dia+"/"+mes2+"/"+año2;
            
    }
    
    public void escribirPrestamo(Prestamo pr){
        try {
            FileOutputStream archivo=new FileOutputStream("Prestamos.bin",true);
            EscribirObjetoBinarioR escribir=new EscribirObjetoBinarioR(archivo);
            escribir.writeObject(pr);
            escribir.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error"+ex);
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Error"+ex);
        }catch(NullPointerException ex){
            JOptionPane.showMessageDialog(null,"Aun no hay nada"+ex);
        }
    }
    
    public void leerUsuario(){
       try {
            FileInputStream archivo = new FileInputStream("Registro_de_Usuarios.bin");
            ObjectInputStream lector=new ObjectInputStream(archivo);
            
            while(true){//Recorremos el archivoBinario
                us=(Usuario)lector.readObject();//Obtenemos el objeto del archivoBinario y cuando acabe lanzara la excepcion EOFException
                if (us.getNombre().equals(c1.getText())){
                    return;
                }
            }
        } catch (EOFException ex) {//cuando acabe de leer se mostrada la excpcion y lo que ara es sair del metodo leerBinario
            JOptionPane.showMessageDialog(null,"El Usuario no se encontro");
            us=null;
            return;
        }catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Primero tienes que registrar Libro y usuarios para prestar");
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No hay registro de nungun libro aun\nRegistro libros antes");
        } catch (ClassNotFoundException ex) {
            System.err.println("Error 3 "+ex);
        }
    }
    
     public void leerLibro(){
       try {
            FileInputStream archivo = new FileInputStream("Registro_de_Libros.bin");
            ObjectInputStream lector=new ObjectInputStream(archivo);
            while(true){ //Recorremos el archivoBinario
                libro=(Libro)lector.readObject(); //Obtenemos el objeto del archivoBinario y cuando acabe lanzara la excepcion EOFException
                if (libro.getTitulo().equals(c2.getText())){
                    return;
                }
            }
        } catch (EOFException ex) {//cuando acabe de leer se mostrada la exepcion y lo que ara es sair del metodo leerBinario
            JOptionPane.showMessageDialog(null,"El libro no se encontro");
            libro=null;
            return;
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No hay registro de nungun libro aun\nRegistro libros antes");
        } catch (ClassNotFoundException ex) {
            System.err.println("Error 3 "+ex);
        }
    }
    
}