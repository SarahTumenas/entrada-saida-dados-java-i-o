package iobytes.IOObejct;

import java.io.*;

public class ExemploIOObject {

    public static void serealizacao () throws IOException {
        Gato gato = new Gato("Nego Vader",9, "preto");

        File file = new File("gato");
        /*OutputStream os = new FileOutputStream(file.getName());
        ObjectOutputStream oos = new ObjectOutputStream(os);*/
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file.getName()));
        oos.writeObject(gato);

        PrintStream ps = new PrintStream(System.out);
        ps.printf("Arquivo \"%s\" criado com sucesso! Tamanho '%d' bytes" , file.getName(), file.length());

        oos.close();
        ps.close();
    }

    public static void desserealizacao(String arquivo){}

    public static void main(String[] args) throws IOException {
        serealizacao();
    }
}
