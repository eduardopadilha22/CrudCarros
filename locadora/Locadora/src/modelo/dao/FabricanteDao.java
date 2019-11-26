package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.conexao.FabricaConexao;
import modelo.entidade.Fabricante;

public class FabricanteDao {

    private String comando;
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection Conecta;

    public void cadastrar(Fabricante fabricante) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "insert into fabricante (cnpj,nome)values(?,?)";
        ps = Conecta.prepareStatement(comando);
        ps.setString(1, fabricante.getCnpj());
        ps.setString(2, fabricante.getNome());
        ps.execute();

        FabricaConexao.FecharConexao();

    }

    public void alterar(Fabricante fabricante) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "update fabricante set nome=? where cnpj=?";
        ps = Conecta.prepareStatement(comando);
        ps.setString(1, fabricante.getNome());
        ps.setString(2, fabricante.getCnpj());
        ps.execute();
        FabricaConexao.FecharConexao();

    }

    public void deletar(int id) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "delete from fabricante where cnpj=?";
        ps = Conecta.prepareStatement(comando);
        ps.setInt(1, id);
        ps.execute();
        FabricaConexao.FecharConexao();

    }

    public List<Fabricante> Listartodos() throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "select * from fabricante";
        ps = Conecta.prepareStatement(comando);
        rs = ps.executeQuery();

        List<Fabricante> Lista = new ArrayList<>();

        while (rs.next()) {
            Fabricante fabricante = new Fabricante();
            fabricante.setCnpj(rs.getString("cnpj"));
            fabricante.setNome(rs.getString("nome"));
            Lista.add(fabricante);
        }

        FabricaConexao.FecharConexao();
        return Lista;

    }

    public List<Fabricante> PesquisarNome(String nome) throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "select * from fabricante where nome like '" + nome + "%'";
        //comando = "select * from zona where nome like?";
        ps = Conecta.prepareStatement(comando);
        //ps.setString(1,nome+"%");
        rs = ps.executeQuery();

        List<Fabricante> Lista = new ArrayList<>();

        while (rs.next()) {
            Fabricante fabricante = new Fabricante();
            fabricante.setCnpj(rs.getString("cnpj"));
            fabricante.setNome(rs.getString("nome"));
            Lista.add(fabricante);

        }

        FabricaConexao.FecharConexao();
        return Lista;
    }
    public Fabricante Buscar(String cnpj) throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "select * from fabricante where cnpj ="+cnpj;
        //comando = "select * from zona where nome like?";
        ps = Conecta.prepareStatement(comando);
        //ps.setString(1,nome+"%");
        rs = ps.executeQuery();

       
       Fabricante fabricante = new Fabricante();
        while (rs.next()) {

            fabricante.setCnpj(rs.getString("cnpj"));
            fabricante.setNome(rs.getString("nome"));
        }

        FabricaConexao.FecharConexao();
        return fabricante;

    }
}
