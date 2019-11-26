/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.conexao.FabricaConexao;
import modelo.entidade.Bairro;
import modelo.entidade.Carro;
import modelo.entidade.Fabricante;
import modelo.entidade.Modelo;

/**
 *
 * @author eduardo
 */
public class CarroDao {
      private String comando;
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection Conecta;

    public void cadastrar(Carro carro) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "insert into carro (placa,ano,id_modelo,valor_diaria)values(?,?,?,?)";
        ps = Conecta.prepareStatement(comando);
        ps.setString(1, carro.getPlaca());
        ps.setString(2, carro.getAno());
        ps.setInt(3, carro.getModelo().getId());
        ps.setDouble(4, carro.getVl_diaria());
        ps.execute();

        FabricaConexao.FecharConexao();

    }
    
       public List<Carro> Listartodos() throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "SELECT * from carro inner join modelo on carro.id_modelo=modelo.id inner join fabricante on modelo.id_fabricante = fabricante.cnpj;";
        ps = Conecta.prepareStatement(comando);
        rs = ps.executeQuery();

        List<Carro> Lista = new ArrayList<>();

        while (rs.next()) {
            Carro carro = new Carro();
            carro.setPlaca(rs.getString("placa"));
            carro.setAno(rs.getString("ano"));
            carro.setVl_diaria(rs.getDouble("valor_diaria"));
            Modelo modelo = new Modelo();
           modelo.setId(rs.getInt("id"));
           modelo.setDescricao(rs.getString("descricao"));
           Fabricante fabricante = new Fabricante();
           fabricante.setCnpj(rs.getString("cnpj"));
           fabricante.setNome(rs.getString("nome"));
           modelo.setFabricante(fabricante);
           carro.setModelo(modelo);
          Lista.add(carro);
        }

        FabricaConexao.FecharConexao();
        return Lista;

    }
}
