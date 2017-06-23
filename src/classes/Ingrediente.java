
package classes;

/**
 *
 * @author Thulio
 */
public class Ingrediente {
    //Atributos
    private String nome;
    private String quantidade;
    private String unidade;

    //Construtor
    public Ingrediente(String nome, String quantidade, String unidade) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.unidade = unidade;
    }
    
    //Get e Set

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        if (quantidade.equals("+")){
            this.quantidade = "";
        }else{
            this.quantidade = quantidade;
        }
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        if (unidade.equals("+")){
            this.unidade = "";
        }else{
            this.unidade = unidade;
        }
    }
    
    
    
}
