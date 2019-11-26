package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.conexao.FabricaConexao;
import modelo.entidade.Acessorio;

public class AcessorioDao {

    private String comando; //receber insert into zona values(null,''a'');
    private PreparedStatement ps; //prepara o ambiente pro comando
    private ResultSet rs;  //responsavél por armazenar os dados do banco na aplicação, apenas consulta
    private Connection Conecta;

    public void cadastrar(Acessorio acessorio) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "insert into acessorio (descricao)values(?)";
        ps = Conecta.prepareStatement(comando);
        ps.setString(1, acessorio.getDescricao());
        ps.execute();

        FabricaConexao.FecharConexao();

    }

    public void alterar(Acessorio acessorio) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "update acessorio set descricao=? where id=?";
        ps = Conecta.prepareStatement(comando);
        ps.setString(1, acessorio.getDescricao());
        ps.setInt(2, acessorio.getId());
        ps.execute();
        FabricaConexao.FecharConexao();

    }

    public void deletar(int id) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "delete from acessorio where id=?";
        ps = Conecta.prepareStatement(comando);
        ps.setInt(1, id);
        ps.execute();
        FabricaConexao.FecharConexao();

    }

    public List<Acessorio> Listartodos() throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "select * from acessorio";
        ps = Conecta.prepareStatement(comando);
        rs = ps.executeQuery();

        List<Acessorio> Lista = new ArrayList<>();

        while (rs.next()) {
            Acessorio acessorio = new Acessorio();
            acessorio.setId(rs.getInt("id"));
            acessorio.setDescricao(rs.getString("descricao"));
            Lista.add(acessorio);
        }

        FabricaConexao.FecharConexao();
        return Lista;

    }

    public List<Acessorio> PeaquisarNome(String descricao) throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "select * from acessorio where descricao like '" + descricao + "%'";
        //comando = "select * from zona where nome like?";
        ps = Conecta.prepareStatement(comando);
        //ps.setString(1,nome+"%");
        rs = ps.executeQuery();

        List<Acessorio> Lista = new ArrayList<>();

        while (rs.next()) {
            Acessorio acessorio = new Acessorio();
            acessorio.setId(rs.getInt("id"));
            acessorio.setDescricao(rs.getString("descricao"));
            Lista.add(acessorio);

        }

        FabricaConexao.FecharConexao();
        return Lista;
    }
    public Acessorio Buscar(int id) throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "select * from acessorio where id = ?";
        ps = Conecta.prepareStatement(comando);
        rs = ps.executeQuery();

        Acessorio acessorio = new Acessorio();
        while (rs.next()) {
            acessorio.setId(rs.getInt("id"));
            acessorio.setDescricao(rs.getString("descricao"));
        }

        FabricaConexao.FecharConexao();
        return acessorio;

    }
}
