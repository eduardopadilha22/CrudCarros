
package modelo.entidade;


public class Acecarro {
    
    private int id;
    private Acessorio acessorio;
    private Carro carro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Acessorio getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(Acessorio acessorio) {
        this.acessorio = acessorio;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}


