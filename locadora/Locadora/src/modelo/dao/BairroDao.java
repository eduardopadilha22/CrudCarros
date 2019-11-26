package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.conexao.FabricaConexao;
import modelo.entidade.Bairro;
import modelo.entidade.Zona;


public class BairroDao {

    private String comando;
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection Conecta;

    public void cadastrar(Bairro bairro) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "insert into bairro (nome, zona)values(?,?)";
        ps = Conecta.prepareStatement(comando);
        ps.setString(1, bairro.getNome());
        ps.setInt(2, bairro.getZona().getId());
        ps.execute();

        FabricaConexao.FecharConexao();

    }

    public void alterar(Bairro bairro) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "update bairro set nome=?, zona=? where id=?";
        ps = Conecta.prepareStatement(comando);
        ps.setString(1, bairro.getNome());
        ps.setInt(2, bairro.getZona().getId());
        ps.setInt(3, bairro.getId());
        ps.execute();
        FabricaConexao.FecharConexao();

    }

    public void deletar(int id) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "delete from bairro where id=?";
        ps = Conecta.prepareStatement(comando);
        ps.setInt(1, id);
        ps.execute();
        FabricaConexao.FecharConexao();

    }

    public List<Bairro> Listartodos() throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "select bairro.id, bairro.nome, zona.id, zona.nome from bairro inner join zona on bairro.id_zona=zona.id;";
        ps = Conecta.prepareStatement(comando);
        rs = ps.executeQuery();

        List<Bairro> Lista = new ArrayList<>();

        while (rs.next()) {
            Bairro bairro = new Bairro();
            bairro.setNome(rs.getString("nome"));

            Zona zona = new Zona();
            zona.setId(rs.getInt("id"));
            zona.setNome(rs.getString("nome"));

            bairro.setZona(zona);
            Lista.add(bairro);
        }

        FabricaConexao.FecharConexao();
        return Lista;

    }

    public List<Bairro> PesquisarNome(String nome) throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "select bairro.id, bairro.nome, zona.id, zona.nome from bairro inner join zona on bairro.id_zona=zona.id where nome like '" + nome + "%'";
        ps = Conecta.prepareStatement(comando);
        rs = ps.executeQuery();

        List<Bairro> Lista = new ArrayList<>();

        while (rs.next()) {
            Bairro bairro = new Bairro();
            bairro.setNome(rs.getString("nome"));

            Zona zona = new Zona();
            zona.setId(rs.getInt("id"));
            zona.setNome(rs.getString("nome"));

            bairro.setZona(zona);
            Lista.add(bairro);

        }

        FabricaConexao.FecharConexao();
        return Lista;
    }

    public Bairro Buscar(int id) throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "select bairro.id, bairro.nome, zona.id, zona.nome from bairro inner join zona on bairro.id_zona=zona.id bairro where id =" + id;
        ps = Conecta.prepareStatement(comando);
        rs = ps.executeQuery();

        Bairro bairro = new Bairro();
        while (rs.next()) {

            bairro.setNome(rs.getString("nome"));
            Zona zona = new Zona();
            zona.setId(rs.getInt("id"));
            zona.setNome(rs.getString("nome"));
            bairro.setZona(zona);
        }

        FabricaConexao.FecharConexao();
        return bairro;

    }
}
