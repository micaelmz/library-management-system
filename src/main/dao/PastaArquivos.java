package main.dao;

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

public class PastaArquivos {
    private String destinoPastaArquivos;

    public PastaArquivos() {
        this.destinoPastaArquivos = System.getProperty("user.dir") + "\\files";
    }

    /**
     * Método que verifica a existência da pasta "files" e a cria, caso não exista.
     */
    public void verificarPastaArquivos(){
        File pasta = new File(destinoPastaArquivos);
        if (!pasta.exists()){
            pasta.mkdir();
        }
    }

}
