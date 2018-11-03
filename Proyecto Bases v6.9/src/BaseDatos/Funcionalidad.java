package BaseDatos;

import RespaldosBD.InicioSesion;
import RespaldosBD.InicioSesion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Funcionalidad 
{
    private Connection conexion;
    private CallableStatement consulta;
    public static String cadenaError=null;

    public Funcionalidad() 
    {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////7
    public boolean conectar(String user, String pass) //Se crea la conexión a la base de datos Oracle
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE";
            conexion= DriverManager.getConnection(BaseDeDatos,user,pass);
        
            if(conexion!=null)
            {
                return true;
            }
            else
            {
                // System.out.println("Conexion fallida");
                return false;
            }
        }//cierra el try
        catch(Exception e)
        {
            //e.printStackTrace();
            return false;
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////

    public ResultSet usuarios()////carga los usuarios desde la base de datos de system
    {
        String query="SELECT USERNAME, account_status FROM DBA_USERS";
     
        try 
        {
            Statement stmt=null;
            stmt=conexion.createStatement();
            ResultSet resultado=stmt.executeQuery(query);
            
            return resultado;
        } 
        catch(SQLException ex) 
        {
            Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void Desconectar() // cierra la conexion con la base
    {
        try 
        {
            conexion.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Funcionalidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    
    public boolean crearRole(String role)
        {
            try {

                String query = "CREATE ROLE " + role;

                Statement stmt = conexion.createStatement();

                stmt.execute(query);
                stmt.close();
                conexion.commit();
                return true;
            } 
            catch (SQLException ex)
            {
                System.out.println(ex.toString());
                return false;
            }
          
        }//cierra crear role
    
    
    public ResultSet cargarRoles(String usuario)//retorna todos los roles de usuario
        {

               String query = "SELECT GRANTED_ROLE FROM DBA_ROLE_PRIVS WHERE GRANTEE='"+usuario+"'";
               try {
                   Statement stmt = null;
                   stmt = conexion.createStatement();;
                   ResultSet resultado = stmt.executeQuery(query);
                   return resultado;
               } catch (SQLException ex) 
               {
                   System.out.println(ex.toString());
                   return null;
               }

        }//cierra el metodo
    
    public ResultSet cargarTotalPrivilegios() ///retorna el total de los privilegios en el sistema
        {

           String query = "select * from session_privs";
               try {
                   Statement stmt = null;
                   stmt = conexion.createStatement();;
                   ResultSet resultado = stmt.executeQuery(query);

                   return resultado;
               } catch (SQLException ex) 
               {
                   System.out.println(ex.toString());
                   return null;
               }

        }
    
    public ResultSet cargarTotalRoles()///retorna todos los roles existentes en el sistema
        {
           //conectar("system", "root");

           String query = "SELECT role FROM dba_roles";
               try {
                   Statement stmt = null;
                   stmt = conexion.createStatement();;
                   ResultSet resultado = stmt.executeQuery(query);

                   return resultado;
               } catch (SQLException ex) 
               {
                   System.out.println(ex.toString());
                   return null;
               }

        }
    
    
    public boolean revocarPrivilegiosRol(String rol, String priv)
        {

            try {

                String query = "revoke " + priv + " from " + rol;

                Statement stmt = conexion.createStatement();

                stmt.execute(query);
                stmt.close();
                conexion.commit();
                 return true;
            } catch (SQLException ex) {
                Logger.getLogger(Funcionalidad.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
    
    
    public boolean otorgarPrivilegiosRol(String rol, String priv)
        {
               try 
               {

                   String query = "GRANT " + priv + " TO " + rol;

                   Statement stmt = conexion.createStatement();

                   stmt.execute(query);
                   stmt.close();
                   conexion.commit();
                    return true;
               } 
               catch (SQLException ex) {
                   Logger.getLogger(Funcionalidad.class.getName()).log(Level.SEVERE, null, ex);
                   return false;
               }
         }
    
    
    public boolean otorgarRolUsuario(String rol, String user)
        {

            try {

                String query = "GRANT " + rol + " TO "+  user;

                Statement stmt = conexion.createStatement();

                stmt.execute(query);
                stmt.close();
                conexion.commit();
                 return true;
            } catch (SQLException ex) {
                Logger.getLogger(Funcionalidad.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
    
    
    public boolean revocarRolUsuario(String rol, String user)
        {

            try {

                String query = "REVOKE " + rol + " FROM "+  user;

                Statement stmt = conexion.createStatement();

                stmt.execute(query);
                stmt.close();
                conexion.commit();
                 return true;
            } catch (SQLException ex) {
                Logger.getLogger(Funcionalidad.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
    
    
    public ResultSet cargarSesionesBD()
        {
            
            //conectar("system", "root");
            
            String query = " SELECT s.sid, s.serial#, s.username, s.program FROM   gv$session s JOIN gv$process p ON p.addr = s.paddr AND p.inst_id = s.inst_id WHERE  s.type != 'BACKGROUND'";
            try {
                Statement stmt = null;
                stmt = conexion.createStatement();;
                ResultSet resultado = stmt.executeQuery(query);

                return resultado;
            } catch (SQLException ex) 
            {
                System.out.println(ex.toString());
                return null;
            }
        }
    
    
    public boolean cerrarSesionBD(String sid, String serial,int band)
        {
            String query;
            if(band==1)
            {
                query = "ALTER SYSTEM KILL SESSION '" + sid + "," + serial + "' IMMEDIATE";
            }
            else
            {
               query = "ALTER SYSTEM DISCONNECT SESSION '" + sid + "," + serial + "' IMMEDIATE";
            }
            
            try{
            Statement stmt = conexion.createStatement();

            stmt.executeUpdate(query);
            stmt.close();
            conexion.commit();
          ///  Desconectar();//desconecta la sesion de sistem
            
             return true;
            } catch (SQLException ex) {
                System.out.println(ex.toString());
                return false;
            }

        }//cierra el metodo
    
    
    public ResultSet cargarDirectorios()
        {
            String query = "SELECT NAME,PATH FROM datapump_dir_objs";
            try {
                Statement stmt = null;
                stmt = conexion.createStatement();;
                ResultSet resultado = stmt.executeQuery(query);
                //Desconectar();
                return resultado;
            } catch (SQLException ex) 
            {
                System.out.println(ex.toString());
                return null;
            }
            
        }//cierra metodo de directorios
    
    
    public ResultSet cargarTablasUsuario(String usuario)
        { 
            String query = "SELECT table_name FROM all_tables where owner = '" + usuario +"'";
            try {
                Statement stmt = null;
                stmt = conexion.createStatement();;
                ResultSet resultado = stmt.executeQuery(query);
                return resultado;
            } catch (SQLException ex) 
            {
                System.out.println(ex.toString());
                return null;
            }
            
        }//cierra metodo de directorios
    
    
    public boolean crearDirectorio(String nombreDir, String pathDir, String user )
        {
            try 
            {
                    String query = "CREATE OR REPLACE DIRECTORY " + nombreDir + " AS '" +  pathDir +"'";

                    Statement stmt = conexion.createStatement();

                    stmt.execute(query);
                    //conexion.commit();
                        try 
                        {
                            query = "GRANT WRITE, READ ON DIRECTORY " + nombreDir + " TO " + user;
                            
                            stmt.execute(query);
                            stmt.close();
                            //conexion.commit();
                            
                            return true;
                        } //TRY PARA OTORGAR PERMISOS AL USUARIO ACTUAL
                        catch (SQLException ex) 
                        {
                            Logger.getLogger(Funcionalidad.class.getName()).log(Level.SEVERE, null, ex);
                            return false;
                        }
                }//CIERRA EL PRIMER TRY 
            catch (SQLException ex) 
                {
                    Logger.getLogger(Funcionalidad.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
        }//cierra metodo crear directorio
    public boolean EliminarDirectorio(String nombreDir){
        try {
                String query = "DROP DIRECTORY " + nombreDir;

                Statement stmt = conexion.createStatement();

                stmt.execute(query);
                stmt.close();
                return true;

            }//CIERRA EL PRIMER TRY 
            catch (SQLException ex){
                Logger.getLogger(Funcionalidad.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
    }
    
    /*Tunning*/
       
       private boolean executarQueryOptimizar(String query)
       {
            try 
            {
                Statement stmt = conexion.createStatement();
                
                query = "EXPLAIN PLAN FOR " + query;

                stmt.execute(query);
                stmt.close();
                conexion.commit();
                return true;
            } 
            catch (SQLException ex) 
            {
                cadenaError = ex.getMessage();
                
                return false;
            }
       }///cierra metodo ejecuta el query
       
       
       public ResultSet obtenerExplainPlan(String query)
       {
           
           if(executarQueryOptimizar(query))///si se tramita correctamente la consulta
           {
               query = "SELECT OPERATION,OBJECT_NAME,OPTIONS,COST,ACCESS_PREDICATES,FILTER_PREDICATES FROM plan_table";
                try {
                    Statement stmt = null;
                    stmt = conexion.createStatement();;
                    ResultSet resultado = stmt.executeQuery(query);

                    return resultado;
                } catch (SQLException ex) 
                {
                    System.out.println(ex.toString());
                    return null;
                }
           }//cierra if
           else
               return null;
            
       }///cierra metodo ejecuta el query
       
       
       public ResultSet cargarColumnasUser(String usuario,String tabla)
       {
           
           String query = "select COLUMN_NAME from ALL_TAB_COLUMNS where owner = '"+ usuario + "' AND TABLE_NAME = '"+tabla+"'";
               try {
                   Statement stmt = null;
                   stmt = conexion.createStatement();;
                   ResultSet resultado = stmt.executeQuery(query);

                   return resultado;
               } catch (SQLException ex) 
               {
                   System.out.println(ex.toString());
                   return null;
               }
            
       }///cierra metodo ejecuta el query
       
       
       public ResultSet cargarPkFkKeyTabla(String tabla)
        {
            String query = "SELECT cols.column_name, cons.constraint_name,cons.constraint_type\n" +
                                "FROM all_constraints cons, all_cons_columns cols\n" +
                                "WHERE cols.table_name = '" + tabla +"'\n" +
                                "AND NOT cons.constraint_type = 'C'\n" +
                                "AND cons.constraint_name = cols.constraint_name\n" +
                                "AND cons.owner = cols.owner";
               try {
                   Statement stmt = null;
                   stmt = conexion.createStatement();;
                   ResultSet resultado = stmt.executeQuery(query);

                   return resultado;
               } catch (SQLException ex) 
               {
                   System.out.println(ex.toString());
                   return null;
               }
        }//cierra metodo de cargar primary key
       
       
       public ResultSet cargarIndicesTabla(String tabla)
        {
            String query = "SELECT c.index_name, c.column_name FROM   all_indexes i JOIN ALL_ind_columns c "
                    + "ON  i.index_name = c.index_name WHERE  i.table_name = '"+ tabla +"'";
            
               try {
                   Statement stmt = null;
                   stmt = conexion.createStatement();;
                   ResultSet resultado = stmt.executeQuery(query);

                   return resultado;
               } catch (SQLException ex) 
               {
                   System.out.println(ex.toString() + "cargarIndices");
                   return null;
               }
        }//cierra metodo de cargar primary key
       
       
       public boolean crearIndice(String tabla, String col, String nomIndice) 
          {
               String query = "CREATE INDEX "+ nomIndice+ " ON "+ tabla + "("+col+")";
              try 
               {
                   Statement stmt = conexion.createStatement();
                   stmt.execute(query);
                   stmt.close();
                   conexion.commit();
                   return true;
               } 
               catch (SQLException ex) 
               {
                   cadenaError = ex.getMessage();

                   return false;
               }
          }///cierra metodo ejecuta el query
       
       
       public boolean eliminarIndice(String nomIndice) 
          {
               String query = "DROP INDEX " + nomIndice;
              try 
               {
                   Statement stmt = conexion.createStatement();
                   stmt.execute(query);
                   stmt.close();
                   conexion.commit();
                   return true;
               } 
               catch (SQLException ex) 
               {
                   cadenaError = ex.getMessage();

                   return false;
               }
          }///cierra metodo ejecuta el query
       
       
       public boolean crearPK(String tabla, String col, String nomPK) 
          {
               String query = "ALTER TABLE "+ tabla + " ADD CONSTRAINT " + nomPK + " PRIMARY KEY ("+col+")";
              try 
               {
                   Statement stmt = conexion.createStatement();
                   stmt.execute(query);
                   stmt.close();
                   conexion.commit();
                   return true;
               } 
               catch (SQLException ex) 
               {
                   cadenaError = ex.getMessage();

                   return false;
               }
          }///cierra metodo ejecuta el query
       
       
       public boolean eliminarPK(String tabla, String nomPK) 
          {
               String query = "ALTER TABLE "+ tabla + " DROP CONSTRAINT " + nomPK;
              try 
               {
                   Statement stmt = conexion.createStatement();
                   stmt.execute(query);
                   stmt.close();
                   conexion.commit();
                   return true;
               } 
               catch (SQLException ex) 
               {
                   cadenaError = ex.getMessage();

                   return false;
               }
          }///cierra metodo ejecuta el query
        
       
       
       /*Objetos*/

        public ResultSet cargarInfoTabla(String usuario, String tabla)
        {
            String query = "select column_name,data_type from ALL_TAB_COLUMNS where owner = '" +
                    usuario+"' AND TABLE_NAME = '"+tabla +"'";
            try
            {
                   Statement stmt = null;
                   stmt = conexion.createStatement();;
                   ResultSet resultado = stmt.executeQuery(query);

                   return resultado;
               } catch (SQLException ex) 
               {
                   System.out.println(ex.toString());
                   return null;
               }
        }
        
        
        public boolean eliminarTabla(String tabla)
        {
              String query = "DROP TABLE " + tabla;
              try 
               {
                   Statement stmt = conexion.createStatement();
                   stmt.execute(query);
                   stmt.close();
                   conexion.commit();
                   return true;
               } 
               catch (SQLException ex) 
               {
                   cadenaError = ex.getMessage();

                   return false;
               }
        }
        
        
        public boolean ejecutarCodigo (String cadena)///ametodo para base de datos generico
        {
            cadenaError=null;
            try
            {
                   Statement stmt = null;
                   stmt = conexion.createStatement();;
                   stmt.execute(cadena);

                   return true;
               } catch (SQLException ex) 
               {
                   cadenaError = ex.toString();
                   return false;
               }  
        }
        
        
        public boolean createTable (String nombTable, String cadena)///ametodo para base de datos generico
        {
            cadenaError=null;
            
            cadena= "CREATE TABLE " + nombTable +"("+cadena+")"; 
            try
            {
                   Statement stmt = null;
                   stmt = conexion.createStatement();;
                   stmt.execute(cadena);

                   return true;
               } catch (SQLException ex) 
               {
                   cadenaError = ex.toString();
                   return false;
               }  
        }   
        
        public void GeneraStats(String usuario, String tabla)
        {
            this.conectar("SYSTEM","root");
            String query;
//            if(tabla.equals("Schema"))
//            {
//                query="EXEC dbms_stats.gather_schema_stats('"+usuario+"',cascade => true);";
//            }
//            else
//            {
//                query="ANALYZE TABLE "+usuario+"."+tabla+" COMPUTE STATISTICS";
//            }
//            try
//            {
//                Statement stmt=null;
//                stmt=conexion.createStatement();
//                stmt.executeQuery(query);
//                JOptionPane.showMessageDialog(null, "¡La Estadistica se realizo exitosamente!");
//            }
//            catch(SQLException ex)
//            {
//                Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
//            }
             if(tabla.equals("Schema"))
             {
                 ResultSet resultado = this.cargarTablasUsuario(usuario);
                 try
                 {
                     while(resultado.next())
                     {
                         query="ANALYZE TABLE "+usuario+"."+resultado.getString("TABLE_NAME")+" COMPUTE STATISTICS";
                         Statement stmt=null;
                         stmt=conexion.createStatement();
                         stmt.execute(query);
                     }
                     JOptionPane.showMessageDialog(null, "Estadistica Realizada con exito!");
                 }
                 catch(SQLException ex)
                 {
                     Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);}
             }
             else
             {
                 query="ANALYZE TABLE "+usuario+"."+tabla+" COMPUTE STATISTICS";
                 try
                 {
                     Statement stmt=null;
                     stmt=conexion.createStatement();
                     stmt.execute(query);
                     JOptionPane.showMessageDialog(null, "Estadistica Realizada con exito!");
                 }
                 catch(SQLException ex)
                 {
                     Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
        }
     
        public ResultSet ConsultaStats(String usuario, String tabla)
        {
            this.conectar("SYSTEM","root");
            
            String query;
            
            if(tabla.equals("Schema"))
            {
                
                query = " SELECT OWNER, TABLE_NAME, NUM_ROWS,LAST_ANALYZED FROM DBA_TABLES WHERE OWNER='"+usuario+"'";
            
            }
            else
            {
                query = " SELECT OWNER, TABLE_NAME,NUM_ROWS, LAST_ANALYZED FROM DBA_TABLES WHERE OWNER='"+usuario+"' AND TABLE_NAME='"+tabla+"'";
            }
            
            try
            {
                Statement stmt = null;
                stmt = conexion.createStatement();;
                ResultSet resultado = stmt.executeQuery(query);
                return resultado;
            }
            catch (SQLException ex)
            {
                System.out.println(ex.toString());
                return null;
            }
        } 
}
