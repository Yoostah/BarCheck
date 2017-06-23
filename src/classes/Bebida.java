package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thulio
 */
public class Bebida {

    //Atributos
    private String nome;
    private String informacoes;
    private boolean semAlcool;
    private List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
    private String preparo;
    //TODO
    //private List tecnicas;

    //GET e SET
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    public boolean isSemAlcool() {
        return semAlcool;
    }

    public void setSemAlcool(boolean semAlcool) {
        this.semAlcool = semAlcool;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPreparo() {
        return preparo;
    }

    public void setPreparo(String preparo) {
        this.preparo = preparo;
    }

    @Override
    public String toString() {
        return "Bebida{" + "nome=" + nome + ", informacoes=" + informacoes + ", semAlcool=" + semAlcool + ", ingredientes=" + ingredientes + ", preparo=" + preparo + '}';
    }

    public void cadastrarBebida(Bebida b) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/bebidas/bebida.txt", true))) {
            StringBuffer sb = new StringBuffer();
            sb.append(b.getNome());
            sb.append("-");
            sb.append(b.getInformacoes());
            sb.append("-");
            sb.append(b.isSemAlcool());
            sb.append("-");
            sb.append(b.getPreparo());
            sb.append("-");
            for (Ingrediente i : b.ingredientes) {
                sb.append(i.getQuantidade() + "," + i.getUnidade() + "," + i.getNome() + ";");
            }
            bw.append(sb, 0, sb.length());
            bw.newLine();
        } catch (IOException ex) {
            Logger.getLogger(Bebida.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Bebida> lerBebidas() {

        List<Bebida> bebidas = new ArrayList<>();
        

        try (Scanner in = new Scanner(new FileReader("src/bebidas/bebida.txt"))) {

            

            while (in.hasNextLine()) {
                String nome = null;
                String informacao = null;
                String s_alcool = null;
                String preparacao = null;
                String ingredientes = null;
                List<Ingrediente> ing = new ArrayList<>();
                String qtd = null;
                String un = null;
                String inome = null;
                
                String s = in.nextLine();

                StringTokenizer st = new StringTokenizer(s, "-");
                while (st.hasMoreTokens()) {
                    nome = st.nextToken();
                    informacao = st.nextToken();
                    s_alcool = st.nextToken();
                    preparacao = st.nextToken();
                    ingredientes = st.nextToken();

                    StringTokenizer sting = new StringTokenizer(ingredientes, ";");
                    while (sting.hasMoreTokens()) {
                        StringTokenizer t = new StringTokenizer(sting.nextToken(), ",");
                        while (t.hasMoreTokens()) {
                            
                            qtd = t.nextToken();
                            un = t.nextToken();
                            inome = t.nextToken();
                            Ingrediente i = new Ingrediente(inome, qtd, un);
                            ing.add(i);
                        }

                    }

                }
            Bebida bebida = new Bebida();    
            bebida.setNome(nome);
            bebida.setInformacoes(informacao);
            bebida.setSemAlcool(Boolean.parseBoolean(s_alcool));
            bebida.setPreparo(preparacao);
            bebida.setIngredientes(ing);

            bebidas.add(bebida);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Bebida.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bebidas;
    }

}
