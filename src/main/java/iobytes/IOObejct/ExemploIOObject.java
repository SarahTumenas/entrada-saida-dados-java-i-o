package iobytes.IOObejct;

import java.io.*;

public class ExemploIOObject {

    public static void serealizacao () throws IOException {
        Gato gato = new Gato("Nego Vader",9, "preto", true, true);

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

    public static void desserealizacao(String arquivo) throws IOException, ClassNotFoundException {
        /*InputStream is = new FileInputStream(arquivo);
        ObjectInputStream ois = new ObjectInputStream(is);*/
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
        Gato objetoGato = (Gato) ois.readObject();
        System.out.printf("\nNome..................: %s\n", objetoGato.getNome());
        System.out.printf("Idade............: %d\n", objetoGato.getIdade());
        System.out.printf("Cor...............: %s\n",objetoGato.getCor());
        System.out.printf("Castrado...............: %s\n",objetoGato.isCastrado());
        System.out.printf("Ronrona...............: %s\n",objetoGato.isRonrona());
        System.out.println(objetoGato);

        ois.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //serealizacao();
        desserealizacao("F:\\Bootcamp Amdocs Java Developer\\EntradaSaidaDadosIOJava\\gato");
    }
}
