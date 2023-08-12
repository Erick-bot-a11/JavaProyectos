package Biblioteca;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class EscribirObjetoBinarioR extends ObjectOutputStream {
    
    public EscribirObjetoBinarioR(OutputStream out) throws IOException {
        super(out);
    }
    public EscribirObjetoBinarioR() throws IOException, SecurityException {
    }
    @Override
    public void writeStreamHeader() throws IOException{
        File archivo=new File("Prestamos.bin");
        if(archivo.length()==0)
            super.writeStreamHeader();
        else
            reset();
    }
}