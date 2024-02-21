package app.dao;

import java.io.File;

/**
 * <b>Esta classe verifica a existência da pasta de arquivos, "files", na raiz do programa.</b>
 * Caso a pasta "files" não exista, a classe irá criá-la.
 *
 * Exemplo de Uso:
 * PastaArquivos existePastaArquivos = new PastaArquivos();
 * existePastaArquivos.verificarPastaArquivos();
 *
 * @author José Victor Oliveira
 *
 */

public class UtilityDatFilesFolder {
    private static String filePath = System.getProperty("user.dir") + "\\files";

    /**
     * Método que verifica a existência da pasta "files" e a cria, caso não exista.
     */
    public static void createIfNotExists(){
        File folder = new File(filePath);
        if (!folder.exists()){
            folder.mkdir();
        }
    }

    public static void enableTestMode(){
        filePath = System.getProperty("user.dir") + "\\testFiles";
    }

    public static void disableTestMode(){
        filePath = System.getProperty("user.dir") + "\\files";
    }

    public static boolean deleteIfExists() {
        File folder = new File(filePath);
        if (folder.exists()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
            return folder.delete();
        }
        return false;
    }

    public static String getFolderPath() {
        return filePath;
    }

}
