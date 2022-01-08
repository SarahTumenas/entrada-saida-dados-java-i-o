package iobytes.IOData;

import java.io.*;
import java.util.Scanner;

/*
Crie um arquivo “peca-de-roupa.bin” e armazene:
1. Nome do produto, tamanho (P/M/G/U),quantidade e preço.
2. Leia este arquivo e imprima no console.
*/
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

        dos.close();
        scan.close();


    }

    public  static void lerProduto (String arquivo){}

    public static void main(String[] args) throws IOException {
        incluirProduto();
    }
}
