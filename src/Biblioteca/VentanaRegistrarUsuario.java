package Biblioteca;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaRegistrarUsuario extends JDialog {
    private JPanel panel;
    private JButton b1;
    private JTextField c1,c2,c3,c4;
    private JLabel e8;
    DefaultComboBoxModel modeloDia = new DefaultComboBoxModel();//Creo modelos para las listas desplegables
    DefaultComboBoxModel modeloMes = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloAño = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloAño1 = new DefaultComboBoxModel();
    private JComboBox lista1,lista2,lista3,lista4,lista5,lista6;
    
    public VentanaRegistrarUsuario(VentanaPrincipal miVentanaPrincipal, boolean model){
        super(miVentanaPrincipal,model);
        setSize(450,400);//Establece las medidas de la ventana
        setTitle("REGISTRO DE USUARIOS");//Establece el titulo
        setLocationRelativeTo(null);      //Establece la posicion de la ventana al centro
        setResizable(false);     // Establecemos si la ventana puede o no cambiar de mamaño en ejecucion
        iniciarComponentes(); 
    }

    public void iniciarComponentes() {
        crearPanel();
        crearEtiquetas();
        crearCajas();
        crearBoton();
        crearListas();
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
    
        JLabel e2 = new JLabel("Nombres: ");
        e2.setBounds(40,98,400,20);
        e2.setOpaque(true);
        e2.setBackground(Color.white);
        e2.setFont(new Font("arial",3,14));
        panel.add(e2);
        
        JLabel e3 = new JLabel("Dirección: ");
        e3.setBounds(40,128,400,20);
        e3.setOpaque(true);
        e3.setBackground(Color.white);
        e3.setFont(new Font("arial",3,14));
        panel.add(e3);
        
        JLabel e4 = new JLabel("Telefono: ");
        e4.setBounds(40,158,400,20);
        e4.setOpaque(true);
        e4.setBackground(Color.white);
        e4.setFont(new Font("arial",3,14));
        panel.add(e4);
        
        JLabel e5 = new JLabel("Fecha de Nacimiento: ");
        e5.setBounds(40,188,400,20);
        e5.setOpaque(true);
        e5.setBackground(Color.white);
        e5.setFont(new Font("arial",3,14));
        panel.add(e5);
        
        JLabel e6 = new JLabel("Fecha de Inscripcion: ");
        e6.setBounds(40,218,170,20);
        e6.setOpaque(true);
        e6.setBackground(Color.white);
        e6.setFont(new Font("arial",3,14));
        panel.add(e6);
        
        JLabel e7 = new JLabel("Vigencia: ");
        e7.setBounds(40,248,170,20);
        e7.setOpaque(true);
        e7.setBackground(Color.white);
        e7.setFont(new Font("arial",3,14));
        panel.add(e7);
        
        e8 = new JLabel("Vigencia");
        e8.setBounds(250,248,100,20);
        e8.setOpaque(true);
        e8.setEnabled(false);
        e8.setFont(new Font("arial",3,14));
        panel.add(e8);
    }
    
    public void crearCajas() {
        c1 = new JTextField();    //Agregamos una sola linea de texto
        c1.setBounds(120,98,250,20);      //Establecemos la posicion y tamaño
        panel.add(c1);   //Añadimos la caja al panel
        
        c2 = new JTextField();
        c2.setBounds(120,128,250,20);
        panel.add(c2);
        
        c3 = new JTextField();
        c3.setBounds(120,158,250,20);
        panel.add(c3);
        
        c4 = new JTextField();
        c4.setBounds(190,188,180,20);
        panel.add(c4);
    }
    
    public void crearListas(){
        lista1 = new JComboBox(modeloDia); //Creo una lista desplegable, su contenido seran de tipo modelo1
        lista2=new JComboBox(modeloMes);
        lista3=new JComboBox(modeloAño);
        
        modeloDia.addElement("DIA");
        for (int i=1;i<=31;i++){
            if (i<=9)
                modeloDia.addElement("0"+i);
            else
                modeloDia.addElement(""+i);//Agrego a mi modelo elementos
        }
        
        modeloMes.addElement("MES");
        for (int i=1;i<=12;i++){
            if (i<=9)
                modeloMes.addElement("0"+i);
            else
                modeloMes.addElement(""+i);//Agrego a mi modelo elementos
        }
        
        modeloAño.addElement("AÑO");
        for (int i=2010;i<=2030;i++){
            modeloAño.addElement(""+i);//Agrego a mi modelo elementos
        }
        
        lista1.setBounds(210,220,50,20);   //Le pongo posicion y tamaño
        panel.add(lista1); //La agrego
        
        lista2.setBounds(270,220,50,20); 
        panel.add(lista2);
        
        lista3.setBounds(330,220,90,20); 
        panel.add(lista3);
    }
    

    public void crearBoton() {
        b1 = new JButton(); //creamos un boton
        b1.setText("Agregar");     //le añadimos texto
        b1.setBounds(150,335,100,20);       //Lo poscisionamos
        b1.setFont(new Font("arial",Font.ROMAN_BASELINE,16));
        panel.add(b1);      //agregamos el boton al panel
        eventoR();
    }
    
    public void eventoR(){
        ActionListener oyenteAccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {//si mi boton se preciona ira aqui
                String nombre,direccion,telefono,fechaNacimiento,fechaInscripcion,fechaVigencia;
                nombre=c1.getText();
                direccion=c2.getText();
                telefono=c3.getText();
                fechaNacimiento=c4.getText();
                
                String seleccion1=(String)lista1.getSelectedItem();//Saco lo que se escogio del las listas desplegables
                String seleccion2=(String)lista2.getSelectedItem();
                String seleccion3=(String)lista3.getSelectedItem();
                int seleccion4=Integer.parseInt(seleccion3)+1;
                fechaInscripcion=seleccion1+"-"+seleccion2+"-"+seleccion3;
                fechaVigencia=seleccion1+"-"+seleccion2+"-"+seleccion4;  
                e8.setText(fechaVigencia);
                
                if ((nombre.length()==0)||(direccion.length()==0)||(telefono.length()==0)||(seleccion1=="DIA")||(seleccion2=="MES")||(seleccion3=="AÑO"))
                {
                    JOptionPane.showMessageDialog(null,"Te falto llenar algun campo");
                    return;
                }
                
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");//En esto comprobare si la fecha es aceptada
                Date inicioDate = null;
                Date finDate = null;
                try {
                    inicioDate = formato.parse(fechaInscripcion);
                    finDate = formato.parse(fechaVigencia);
                } catch (ParseException ex) {
                    System.out.println("error");
                }
                if(inicioDate.after(finDate)){
                    JOptionPane.showMessageDialog(null,"La fecha de Inscripcion no corresponde a la de Vigencia");
                    return;
                }
                    
                Usuario us=new Usuario(nombre,direccion,telefono,fechaNacimiento,fechaInscripcion,fechaVigencia);
                escribirBinario(us);
                JOptionPane.showMessageDialog(null,"Se ah registrado correctamente");
                c1.setText("");
                c2.setText("");
                c3.setText("");
                c4.setText("");
            }
        };
        b1.addActionListener(oyenteAccion);  
    }
    
    public void escribirBinario(Usuario us){
        try {
            FileOutputStream archivo=new FileOutputStream("Registro_de_Usuario.bin",true);
            EscribirObjetoBinarioU escribir=new EscribirObjetoBinarioU(archivo);
            escribir.writeObject(us);
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