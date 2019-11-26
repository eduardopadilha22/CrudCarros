package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.conexao.FabricaConexao;
import modelo.entidade.Usuario;

public class UsuarioDao {

    private String comando;
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection Conecta;

    public void cadastrar(Usuario usuario) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "insert into usuario (nome,login,senha)values(?,?,?)";
        ps = Conecta.prepareStatement(comando);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getLogin());
        ps.setString(3, usuario.getSenha());
        ps.execute();

        FabricaConexao.FecharConexao();

    }

    public void alterar(Usuario usuario) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "update usuario set nome=?, login=?, senha=? where id=?";
        ps = Conecta.prepareStatement(comando);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getLogin());
        ps.setString(3, usuario.getSenha());
        ps.setInt(4, usuario.getId());
        ps.execute();
        FabricaConexao.FecharConexao();

    }

    public void deletar(int id) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "delete from usuario where id=?";
        ps = Conecta.prepareStatement(comando);
        ps.setInt(1, id);
        ps.execute();
        FabricaConexao.FecharConexao();

    }

    public List<Usuario> Listartodos() throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "select * from usuario";
        ps = Conecta.prepareStatement(comando);
        rs = ps.executeQuery();

        List<Usuario> Lista = new ArrayList<>();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
            Lista.add(usuario);

        }

        FabricaConexao.FecharConexao();
        return Lista;

    }

    public List<Usuario> PeaquisarNome(String nome) throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "select * from usuario where nome like '" + nome + "%'";
        //comando = "select * from zona where nome like?";
        ps = Conecta.prepareStatement(comando);
        //ps.setString(1,nome+"%");
        rs = ps.executeQuery();

        List<Usuario> Lista = new ArrayList<>();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
            Lista.add(usuario);

        }

        FabricaConexao.FecharConexao();
        return Lista;
    }

    public Usuario Buscar(int id) throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "select * from usuario where id = ?";
        ps = Conecta.prepareStatement(comando);
        rs = ps.executeQuery();
        
        Usuario usuario = new Usuario();
        while (rs.next()) {

            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("login"));
            usuario.setSenha(rs.getString("senha"));
        }

        FabricaConexao.FecharConexao();
        return usuario;

    }
}
