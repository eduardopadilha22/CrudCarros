
package modelo.entidade;

public class Locacao {
    
    private int id;
    private String statuss;
    private String dt_final;
    private String dt_inicial;
    private String dt_locacao;
    private double vl_diaria;
    private Usuario usuario;
    private Cliente cliente;
    private Carro carro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatuss() {
        return statuss;
    }

    public void setStatuss(String statuss) {
        this.statuss = statuss;
    }

    public String getDt_final() {
        return dt_final;
    }

    public void setDt_final(String dt_final) {
        this.dt_final = dt_final;
    }

    public String getDt_inicial() {
        return dt_inicial;
    }

    public void setDt_inicial(String dt_inicial) {
        this.dt_inicial = dt_inicial;
    }

    public String getDt_locacao() {
        return dt_locacao;
    }

    public void setDt_locacao(String dt_locacao) {
        this.dt_locacao = dt_locacao;
    }

    public double getVl_diaria() {
        return vl_diaria;
    }

    public void setVl_diaria(double vl_diaria) {
        this.vl_diaria = vl_diaria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    
}


