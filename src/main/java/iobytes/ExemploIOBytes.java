package iobytes;

/*Fazer cópia do arquivo “recomendacoes-copy.txt”*/
import java.io.*;

public class ExemploIOBytes {
    public static void copiarArquivo () throws IOException {
        File file = new File("F:\\Bootcamp Amdocs Java Developer\\EntradaSaidaDadosIOJava\\recomendacoes-copy.txt");
        String fileName = file.getName();
        /*InputStream is = new FileInputStream(file.getName());
        BufferedInputStream bis = new BufferedInputStream(is);*/
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file.getName()));
        String fileNameCopy = fileName.substring(0, fileName.indexOf("-")).concat("-copy2.txt");
        File fileCopy = new File(fileNameCopy);
        /*OutputStream os = new FileOutputStream(fileNameCopy);
        BufferedOutputStream bos = new BufferedOutputStream(os);*/
        BufferedOutputStream bos =new BufferedOutputStream( new FileOutputStream(fileNameCopy));

        int line = 0;
        while ((line = bis.read()) != -1){
            bos.write((char)line);
            bos.flush();
        }
        bis.close();
        bos.close();
    }

    public static void main(String[] args) throws IOException {
        copiarArquivo();
    }
}
