/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registromaestros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author AlmodovS
 */
public class Singleton {
    
    private String url = "jdbc:sqlite:reunion";
    private static Connection connection = null;


	private Singleton()
	{
		try
		{
			/** chargement des pilotes */
			Class.forName("org.sqlite.JDBC");

			/** connexion a la database */
			connection = DriverManager.getConnection(url); //connexion a la database
			System.out.println("Conexion estable");

		} catch (SQLException e)
		{
			System.err.println("No es posible acceder a la base de datos");
			System.exit(0);
		} catch (ClassNotFoundException e)
		{
			System.err.println("No se pudo cargar el driver");
			System.exit(0);
		}
	}

	/**
	 * @return Connection
	 */
	public static Connection getConnect()
	{
		if (connection == null)
		{
			new Singleton();
		}else{
                System.out.println("CONEXION YA INICIADA");
                }

		return connection;
	}
  
    
    
}
   