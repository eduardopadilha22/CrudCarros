package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.conexao.FabricaConexao;
import modelo.entidade.Bairro;
import modelo.entidade.Endereco;
import modelo.entidade.Zona;

public class EnderecoDao {

    private String comando;
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection Conecta;

    public void cadastrar(Endereco endereco) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "insert into endereco (cep, rua, bairro)values(?,?,?)";
        ps = Conecta.prepareStatement(comando);
        ps.setString(1, endereco.getCep());
        ps.setString(2, endereco.getRua());
        ps.setInt(3, endereco.getBairro().getId());
        ps.execute();

        FabricaConexao.FecharConexao();

    }

    public void alterar(Endereco endereco) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "update endereco set rua=?, bairro=? where cep=?";
        ps = Conecta.prepareStatement(comando);
        ps.setString(1, endereco.getCep());
        ps.setString(2, endereco.getRua());
        ps.setInt(3, endereco.getBairro().getId());
        ps.execute();
        FabricaConexao.FecharConexao();

    }

    public void deletar(int id) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "delete from endereco where id=?";
        ps = Conecta.prepareStatement(comando);
        ps.setInt(1, id);
        ps.execute();
        FabricaConexao.FecharConexao();

    }

    public List<Endereco> Listartodos() throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "select * from endereco";
        ps = Conecta.prepareStatement(comando);
        rs = ps.executeQuery();

        List<Endereco> Lista = new ArrayList<>();

        while (rs.next()) {

            Endereco endereco = new Endereco();
            endereco.setCep(rs.getString("cep"));
            endereco.setRua(rs.getString("rua"));

            Bairro bairro = new Bairro();
            bairro.setId(rs.getInt("id"));
            bairro.setNome(rs.getString("nome"));

            endereco.setBairro(bairro);
            Lista.add(endereco);
        }

        FabricaConexao.FecharConexao();
        return Lista;

    }

    public List<Endereco> PesquisarNome(String nome) throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "select * from endereco where nome like '" + nome + "%'";
        ps = Conecta.prepareStatement(comando);
        rs = ps.executeQuery();

        List<Endereco> Lista = new ArrayList<>();

        while (rs.next()) {

            Endereco endereco = new Endereco();
            endereco.setCep(rs.getString("cep"));
            endereco.setRua(rs.getString("rua"));

            Bairro bairro = new Bairro();
            bairro.setId(rs.getInt("id"));
            bairro.setNome(rs.getString("nome"));

            endereco.setBairro(bairro);
            Lista.add(endereco);

        }

        FabricaConexao.FecharConexao();
        return Lista;
    }

    public Endereco Buscar(int id) throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "select * from endereco where id =" + id;
        ps = Conecta.prepareStatement(comando);
        rs = ps.executeQuery();

        Endereco endereco = new Endereco();
        while (rs.next()) {

            endereco.setCep(rs.getString("cep"));
            endereco.setRua(rs.getString("rua"));

            Bairro bairro = new Bairro();
            bairro.setId(rs.getInt("id"));
            bairro.setNome(rs.getString("nome"));

            endereco.setBairro(bairro);
        }

        FabricaConexao.FecharConexao();
        return endereco;
    }
}
