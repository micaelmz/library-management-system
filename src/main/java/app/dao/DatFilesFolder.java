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

public class DatFilesFolder {
    private String filePath;

    public DatFilesFolder() {
        this.filePath = System.getProperty("user.dir") + "\\files";
    }

    /**
     * Método que verifica a existência da pasta "files" e a cria, caso não exista.
     */
    public void ensureDestinationFolderExists(){
        File folder = new File(filePath);
        if (!folder.exists()){
            folder.mkdir();
        }
    }

}
