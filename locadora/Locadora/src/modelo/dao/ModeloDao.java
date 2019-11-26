package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.conexao.FabricaConexao;
import modelo.entidade.Fabricante;
import modelo.entidade.Modelo;

public class ModeloDao {

    private String comando;
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection Conecta;

    public void cadastrar(Modelo zona) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "insert into modelo (descricao, id_fabricante)values(?,?)";
        ps = Conecta.prepareStatement(comando);
        ps.setString(1, zona.getDescricao());
        ps.setString(2, zona.getFabricante().getCnpj());
        ps.execute();

        FabricaConexao.FecharConexao();

    }

    public void alterar(Modelo modelo) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "update modelo set descricao=?, fabricante=? where id=?";
        ps = Conecta.prepareStatement(comando);
        ps.setString(1, modelo.getDescricao());
        ps.setString(2, modelo.getFabricante().getCnpj());
        ps.setInt(3, modelo.getId());
        ps.execute();
        FabricaConexao.FecharConexao();

    }

    public void deletar(int id) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "delete from modelo where id=?";
        ps = Conecta.prepareStatement(comando);
        ps.setInt(1, id);
        ps.execute();
        FabricaConexao.FecharConexao();

    }

    public List<Modelo> Listartodos() throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "SELECT modelo.id, modelo.descricao, fabricante.cnpj, fabricante.nome from modelo inner join fabricante on modelo.id_fabricante=fabricante.cnpj;";
        ps = Conecta.prepareStatement(comando);
        rs = ps.executeQuery();

        List<Modelo> Lista = new ArrayList<>();

        while (rs.next()) {
            Modelo modelo = new Modelo();
            modelo.setId(rs.getInt("id"));
            modelo.setDescricao(rs.getString("descricao"));

            Fabricante fabricante = new Fabricante();
            fabricante.setCnpj(rs.getNString("cnpj"));
            fabricante.setNome(rs.getString("nome"));

            modelo.setFabricante(fabricante);
            Lista.add(modelo);
        }

        FabricaConexao.FecharConexao();
        return Lista;

    }

    public List<Modelo> Listartodos(String descricao) throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "SELECT modelo.id, modelo.descricao, fabricante.cnpj, fabricante.nome from modelo inner join fabricante on modelo.id_fabricante=fabricante.cnpj where descricao like '" + descricao + "%'";
        //comando = "select * from zona where nome like?";
        ps = Conecta.prepareStatement(comando);
        //ps.setString(1,nome+"%");
        rs = ps.executeQuery();

        List<Modelo> Lista = new ArrayList<>();

        while (rs.next()) {
            Modelo modelo = new Modelo();
            modelo.setId(rs.getInt("id"));
            modelo.setDescricao(rs.getString("descricao"));

            Fabricante fabricante = new Fabricante();
            fabricante.setCnpj(rs.getNString("cnpj"));
            fabricante.setNome(rs.getString("nome"));

            modelo.setFabricante(fabricante);
            Lista.add(modelo);

        }

        FabricaConexao.FecharConexao();
        return Lista;
    }

    public Modelo Buscar(int id) throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "SELECT modelo.id, modelo.descricao, fabricante.cnpj, fabricante.nome from modelo inner join fabricante on modelo.id_fabricante=fabricante.cnpj; where id = ?";
        //comando = "select * from zona where nome like?";
        ps = Conecta.prepareStatement(comando);
        //ps.setString(1,nome+"%");
        rs = ps.executeQuery();

        Modelo modelo = new Modelo();
        while (rs.next()) {

            modelo.setId(rs.getInt("id"));
            modelo.setDescricao(rs.getString("descricao"));

            Fabricante fabricante = new Fabricante();
            fabricante.setCnpj(rs.getNString("cnpj"));
            fabricante.setNome(rs.getString("nome"));

            modelo.setFabricante(fabricante);

        }

        FabricaConexao.FecharConexao();
        return modelo;

    }
}
