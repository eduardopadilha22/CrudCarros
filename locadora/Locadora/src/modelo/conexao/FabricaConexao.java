package modelo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FabricaConexao {
    private static String url ="jdbc:mysql://localhost:3306/locadora?useTimezone=true&serverTimezone=UTC";
    private static String usuario="root";
    private static String senha="pass123";
    private static Connection con = null;
 
    public static Connection Conectar(){
       
      
          try {
              Class.forName("com.mysql.jdbc.Driver");
            try {
                con = DriverManager.getConnection(url,usuario,senha);
                System.out.println("Conectado com o Banco");
                
            } catch (SQLException ex) {
                System.out.println("usuario ou senha incorreto"+ex.getMessage());
                
            }
          } catch (ClassNotFoundException ex) {
              
                   System.out.println("Não encontrou o arquivo"+ex.getMessage());
          }
        return con;
    
    }
    
   public static void FecharConexao(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
}