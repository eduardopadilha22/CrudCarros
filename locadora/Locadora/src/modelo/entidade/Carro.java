
package modelo.entidade;

public class Carro {
   
    private String placa;
    private String ano;
    private double vl_diaria;
    private Modelo modelo;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public double getVl_diaria() {
        return vl_diaria;
    }

    public void setVl_diaria(double vl_diaria) {
        this.vl_diaria = vl_diaria;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
}


