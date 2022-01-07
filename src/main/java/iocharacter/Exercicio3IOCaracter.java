package iocharacter;
/*
Faça uma cópia do arquivo "recomendacoes.txt"
Adicione 3 recomendações de livros
 */

import java.io.*;

public class Exercicio3IOCaracter {

    public static void copiarArquivo() throws IOException {
        File file =new File("F:\\Bootcamp Amdocs Java Developer\\EntradaSaidaDadosIOJava\\recomendacoes.txt");
        String nameArquivo = file.getName();

       /* Reader reader = new FileReader(nameArquivo);
        BufferedReader br = new BufferedReader(reader);*/
        BufferedReader br = new BufferedReader(new FileReader(nameArquivo));
        String line = br.readLine();

        String nameArquivoCopy = nameArquivo.substring(0, nameArquivo.indexOf(".")).concat("-copy.txt");

        File filecopy = new File(nameArquivoCopy);
        BufferedWriter bw = new BufferedWriter(new FileWriter(filecopy.getName()));

        do {
            bw.write(line);
            bw.newLine();
            bw.flush();
            line = br.readLine();
        }while (!(line == null));
        System.out.printf("Arquivo \"%s\" copiado com sucesso! Com o tamanho '%d' bytes \n",
                file.getName(),file.length());
        System.out.printf("Arquivo \"%s\" criado com sucesso! Com o tamanho '%d' bytes \n",
                filecopy.getName(), filecopy.length());

        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Recomende 3 livros: ");
        pw.flush();

        adicionarLivros(filecopy.getName());

        pw.printf("Ok! Tudo certo. Tamanho do arquivo '%d' bytes.", filecopy.length());

        br.close();
        bw.close();
        pw.close();

    }

    public static void adicionarLivros(String arquivo) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true));

        do {
            bw.write(line);
            bw.newLine();
            bw.flush();
            line = br.readLine();
        } while(!(line.equalsIgnoreCase("fim")));

    }

    public static void main(String[] args) throws IOException {

        copiarArquivo();

    }
}
