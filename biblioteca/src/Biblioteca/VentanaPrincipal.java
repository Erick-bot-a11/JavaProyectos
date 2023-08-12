package Biblioteca;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaPrincipal extends JFrame {
    private JPanel panel;
    private JButton bIngLibro,bIngUsuario,bPrestar,bLibros,bUsuarios,bSalir, bPrestamos;
    private VentanaPrincipal miVentanaPrincipal;
    
    
     public VentanaPrincipal(){
        setSize(900,700);//Establece las medidas de la ventana
        setTitle("B I B L I O T E C A");//Establece el titulo
        setLocationRelativeTo(null);      //Establece la posicion de la ventana al centro
        setResizable(false);     // Establecemos si la ventana puede o no cambiar de mamaño en ejecucion
        iniciarComponentes();   //Llamamos al menodo para crear componentes
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);//Para el programa despues de cerrar la ventana
    }
     
    public void setVentanaPrincipal(VentanaPrincipal miVentana) {
        miVentanaPrincipal=miVentana;
    }

    public void iniciarComponentes() {
        crearPanel();
        crearEtiquetas();
        crearBotones();
    }
    
    public void crearPanel(){
        panel = new JPanel();    //Creamos un panel
        panel.setLayout(null);      //Desactivo las propiedades determinadas
        panel.setBackground(Color.ORANGE); //Establecemos un color al panel
        this.getContentPane().add(panel);   //Agregamos el panel a la ventana
    }

    public void crearEtiquetas(){
        JLabel etiqueta1 = new JLabel();    //creo otra etiqueta para pegar la imagen
        etiqueta1.setBounds(50,20,300,146);   //Establesco la posicion y medidas
        etiqueta1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/logobuap.png")));
        panel.add(etiqueta1);   //agrego la etiqueta a mi panel
        
        JLabel etiqueta2 = new JLabel();    //creo otra etiqueta para pegar la imagen
        etiqueta2.setBounds(600,20,300,146);   //Establesco la posicion y medidas
        etiqueta2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/logo_FCC.png")));
        panel.add(etiqueta2);   //agrego la etiqueta a mi panel
        
        JLabel etiqueta3 = new JLabel("BIBLIOTECA DE LA FACULTAD"); 
        etiqueta3.setBounds(200,90,600,146);
        etiqueta3.setFont(new Font("castellar",Font.ITALIC,30));//aGREGO FUENTE A LA LETRA  
        panel.add(etiqueta3);
    }
    
    public void crearBotones() {
        bIngLibro = new JButton(); //creamos un boton
        bIngLibro.setText("REGISTRAR LIBRO");     //le añadimos texto
        bIngLibro.setBounds(370,250,150,30);       //Lo poscisionamos
        panel.add(bIngLibro);      //agregamos el boton al panel
        eventoIngresarLibro(); //Llamo a este metodo que sea un oyente de Accion
        
        bIngUsuario = new JButton(); //creamos un boton
        bIngUsuario.setText("REGISTRAR USUARIO");     //le añadimos texto
        bIngUsuario.setBounds(360,300,180,30);       //Lo poscisionamos
        panel.add(bIngUsuario);      //agregamos el boton al panel
        eventoIngresarUsuario();
        
        bPrestar = new JButton();
        bPrestar.setText("PRESTAR LIBRO");
        bPrestar.setBounds(372,350,150,30);
        panel.add(bPrestar);
        eventoPrestar();
        
        bLibros = new JButton();
        bLibros.setText("VER TODOS LOS LIBROS");
        bLibros.setBounds(360,400,180,30);
        panel.add(bLibros);
        eventoLibros();
        
        bUsuarios = new JButton();
        bUsuarios.setText("VER TODOS LOS USUARIOS");
        bUsuarios.setBounds(350,450,200,30);
        panel.add(bUsuarios);
        eventoUsuarios();
        
        bSalir = new JButton();
        bSalir.setText("SALIR");
        bSalir.setBounds(395,550,100,30);
        panel.add(bSalir);
        eventoSalir();
        
        bPrestamos = new JButton();
        bPrestamos.setText("VER PRESTAMOS");
        bPrestamos.setBounds(600,550,150,30);
        bSalir.setBackground(Color.red);
        panel.add(bPrestamos);
        eventoPrestamos();
    }
    
    public void eventoIngresarLibro(){
        
        ActionListener oyenteAccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {//si mi boton se preciona ira aqui
                VentanaRegistrarLibro subVentana1=new VentanaRegistrarLibro(miVentanaPrincipal,true);
                subVentana1.setVisible(true);
            }
        };
        bIngLibro.addActionListener(oyenteAccion);  
    }
    
    public void eventoIngresarUsuario(){
        ActionListener oyenteAccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {//si mi boton se preciona ira aqui
                VentanaRegistrarUsuario subVentana1=new VentanaRegistrarUsuario(miVentanaPrincipal,true);
                subVentana1.setVisible(true);
            }
        };
        bIngUsuario.addActionListener(oyenteAccion);  
    }
    
    public void eventoPrestar(){
        ActionListener oyenteAccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {//si mi boton se preciona ira aqui
                VentanaPrestar subVentana1=new VentanaPrestar(miVentanaPrincipal,true);
                subVentana1.setVisible(true);
            }
        };
        bPrestar.addActionListener(oyenteAccion);  
    }
    
    public void eventoLibros(){
        ActionListener oyenteAccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {//si mi boton se preciona ira aqui
                VentanaLibros subVentana1=new VentanaLibros(miVentanaPrincipal,true);
                subVentana1.setVisible(true);
            }
        };
        bLibros.addActionListener(oyenteAccion);  
    }
    
    public void eventoUsuarios(){
        ActionListener oyenteAccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {//si mi boton se preciona ira aqui
                VentanaUsuarios subVentana1=new VentanaUsuarios(miVentanaPrincipal,true);
                subVentana1.setVisible(true);
            }
        };
        bUsuarios.addActionListener(oyenteAccion);  
    }
    
    public void eventoSalir(){
        ActionListener oyenteAccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {//si mi boton se preciona ira aqui
                JOptionPane.showMessageDialog(null,"Gracias por usar esta biblioteca\nVuelva pronto");//Mensaje de despdida
                System.exit(0); 
            }
        };
        bSalir.addActionListener(oyenteAccion);  
    }
    
    public void eventoPrestamos(){
        ActionListener oyenteAccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {//si mi boton se preciona ira aqui
                VentanaPrestamos subVentana1=new VentanaPrestamos(miVentanaPrincipal,true);
                subVentana1.setVisible(true);
            }
        };
        bPrestamos.addActionListener(oyenteAccion);  
    }
}