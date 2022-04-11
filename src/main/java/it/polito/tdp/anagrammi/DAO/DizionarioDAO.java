package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.ConnectDB;
import it.polito.tdp.anagrammi.model.Model;

public class DizionarioDAO {
	private List<String> listaParole = new LinkedList<String>();
	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public List<String> getTutteLeParole() {

		final String sql = "SELECT * FROM parola";

		List<String> parole = new LinkedList<String>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String p = rs.getString("nome");
				

				System.out.println(p);
				
				// Crea un nuovo JAVA Bean Corso
				// Aggiungi il nuovo oggetto Corso alla lista corsi
			}

			conn.close();
			
			return null;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	public boolean isCorretta(String parziale) {

			final String sql = "SELECT nome FROM parola WHERE nome=?";

			try {
				Connection conn = ConnectDB.getConnection();
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, parziale);
				ResultSet rs = st.executeQuery();

				if (rs.next()) {
					return true;
				}

				conn.close();
				return false;
				

			} catch (SQLException e) {
				// e.printStackTrace();
				throw new RuntimeException("Errore Db", e);
			}
		
	}
}
