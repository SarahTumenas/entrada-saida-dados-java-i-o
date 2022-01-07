package iocharacter;

import java.io.*;
import java.util.Scanner;

/*
Abra o teclado para escrever 3 tipos de filmes que você recomendaria
Armazene em recomendações: "recomendacoes.txt"
 */
public class Exercicio2IOCaracter {

    public static void lerTecladoEscreverDocumento() throws IOException {

        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Digite 3 recomendações de filmes: ");
        pw.flush();

        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();

        File file = new File("recomendacoes.txt");

        BufferedWriter bw = new BufferedWriter(new FileWriter(file.getName()));

        do {
            bw.write(line);
            bw.newLine();
            bw.flush();
            line = scan.nextLine();
        } while (!(line.equalsIgnoreCase("fim")));

        pw.printf("Arquivo \"%s\" foi criado com sucesso!", file.getName());

        pw.close();
        scan.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        lerTecladoEscreverDocumento();

    }
}
