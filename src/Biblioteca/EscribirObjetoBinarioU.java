package Biblioteca;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class EscribirObjetoBinarioU extends ObjectOutputStream {
    
    public EscribirObjetoBinarioU(OutputStream out) throws IOException {
        super(out);
    }
    public EscribirObjetoBinarioU() throws IOException, SecurityException {
    }
    
    @Override
    public void writeStreamHeader() throws IOException{
        File archivo=new File("Registro_de_Usuarios.bin");
        if(archivo.length()==0)
            super.writeStreamHeader();
        else
            reset();
    }
}
