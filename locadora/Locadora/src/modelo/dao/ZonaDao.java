
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.conexao.*;
import modelo.entidade.*;

public class ZonaDao {
    
    private String comando; //receber insert into zona values(null,''a'');
    private static PreparedStatement ps; //prepara o ambiente pro comando
    private static ResultSet rs;  //responsavél por armazenar os dados do banco na aplicação, apenas consulta
    private static Connection Conecta;
    
// metodos
    
    public void cadastrar(Zona zona) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "insert into zona (nome)values(?)";
        ps = Conecta.prepareStatement(comando);
        ps.setString(1, zona.getNome());
        ps.execute();

        FabricaConexao.FecharConexao();

    } // fim metodo

    public void alterar(Zona zona) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "update zona set nome=? where id=?";
        ps = Conecta.prepareStatement(comando);
        ps.setString(1, zona.getNome());
        ps.setInt(2, zona.getId());
        ps.execute();
        FabricaConexao.FecharConexao();

    } // fim metodo

    public void deletar(int id) throws SQLException {

        Conecta = FabricaConexao.Conectar();
        comando = "delete from zona where id=?";
        ps = Conecta.prepareStatement(comando);
        ps.setInt(1, id);
        ps.execute();
        FabricaConexao.FecharConexao();

    }

    public List<Zona> Listartodos() throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "select * from zona";
        ps = Conecta.prepareStatement(comando);
        rs = ps.executeQuery();

        List<Zona> Lista = new ArrayList<>();

        while (rs.next()) {
            Zona zona = new Zona();
            zona.setId(rs.getInt("id"));
            zona.setNome(rs.getString("nome"));
            Lista.add(zona);

        }

        FabricaConexao.FecharConexao();
        return Lista;

    }

    public List<Zona> Listartodos(String nome) throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "select * from zona where nome like '" + nome + "%'";
        //comando = "select * from zona where nome like?";
        ps = Conecta.prepareStatement(comando);
        //ps.setString(1,nome+"%");
        rs = ps.executeQuery();

        List<Zona> Lista = new ArrayList<>();

        while (rs.next()) {
            Zona zona = new Zona();
            zona.setId(rs.getInt("id"));
            zona.setNome(rs.getString("nome"));
            Lista.add(zona);

        }

        FabricaConexao.FecharConexao();
        return Lista;
    }//fim classe

    public Zona Buscar(int id) throws SQLException {
        Conecta = FabricaConexao.Conectar();
        comando = "select * from zona where id = ?";
        //comando = "select * from zona where nome like?";
        ps = Conecta.prepareStatement(comando);
        ps.setInt(1,id);
        rs = ps.executeQuery();

        //List<Zona> Lista = new ArrayList<>();
        Zona zona = new Zona();
        while (rs.next()) {

            zona.setId(rs.getInt("id"));
            zona.setNome(rs.getString("nome"));
            //    Lista.add(zona);

        }

        FabricaConexao.FecharConexao();
        // return Lista;
//fim classe
        return zona;

    }
    
    
}

