package iobytes.IOData;

import java.io.*;
import java.util.Scanner;


public class ExemploIOData {
    public static void incluirProduto () throws IOException {
        File file = new File("F:\\Bootcamp Amdocs Java Developer\\EntradaSaidaDadosIOJava\\peca-de-roupa.bin");

        PrintStream ps = new PrintStream(System.out);
        ps.flush();

        /*OutputStream os= new FileOutputStream(file.getPath());
        DataOutputStream dos = new DataOutputStream(os);*/
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file.getPath()));

        Scanner scan = new Scanner(System.in);

        ps.print("Nome da peça: ");
        String nome = scan.nextLine();
        dos.writeUTF(nome);

        ps.print("Tamanho da peça (P/M/G/U): ");
        char tamanho =(char) System.in.read();
        dos.writeChar(tamanho);

        ps.print("Quantidade: ");
        int quant = scan.nextInt();
        dos.writeInt(quant);

        ps.print("Preço unitário: ");
        double preco = scan.nextDouble();
        dos.writeDouble(preco);

        ps.printf("O arquivo %s foi criado com %d bytes no diretório '%s'.\n",
                file.getName(), file.length(), file.getAbsolutePath());

        lerProduto(file.getPath());

        dos.close();
        scan.close();
        ps.close();
    }

    public  static void lerProduto (String caminhoArquivo) throws IOException {
        File f = new File(caminhoArquivo);
        /*InputStream is = new FileInputStream(f.getPath());
        DataInputStream dis =new DataInputStream(is);*/
        DataInputStream dis= new DataInputStream(new FileInputStream(f.getPath()));

        String nome = dis.readUTF();
        char tamanho = dis.readChar();
        int quant = dis.readInt();
        double preco = dis.readDouble();

        System.out.printf("\nNome..................: %s\n", nome);
        System.out.printf("Tamanho...............: %s\n", tamanho);
        System.out.printf("Quantidade............: %d\n", quant);
        System.out.printf("Preço.................: %f\n", preco);
        System.out.print("Valor total das peças: " + (quant * preco));

        dis.close();
    }

    public static void main(String[] args) throws IOException {
        incluirProduto();
    }
}
