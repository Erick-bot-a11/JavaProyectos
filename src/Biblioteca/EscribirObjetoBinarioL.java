package Biblioteca;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class EscribirObjetoBinarioL extends ObjectOutputStream {//Este sirve para escribir en un archivo binario
    
    public EscribirObjetoBinarioL(OutputStream out) throws IOException {
        super(out);
    }
    public EscribirObjetoBinarioL() throws IOException, SecurityException {
    }
    @Override
    public void writeStreamHeader() throws IOException{
        File archivo=new File("Registro_de_Libros.bin");
        if(archivo.length()==0)
            super.writeStreamHeader();
        else
            reset();
    }
}
