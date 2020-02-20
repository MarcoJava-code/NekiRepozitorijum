package jdbcdriver;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Kontrolori {

	public static void main(String[] args) {
		
		try {
			
			String url = "jdbc:mysql://localhost:3306/demo2";
			String username = "root";
			String password =  "mesqlno85";
			
			String sveIzTabele = "select * from kontrolor";
			String ubaci = "insert into kontrolor (radna_jedinica, tip_viljuskara, broj_viljuskara, uredjaj_za_kontrolu)" 
			+ "VALUES (831, 'komisioni', 55, 'ne')";
			String izbaci = "delete from kontrolor where id_kontrolor=5";
			String promeni = "update kontrolor set tip_viljuskara='smelt' where radna_jedinica=831";
			
			Connection konekcijaZaKontrolore = DriverManager.getConnection(url, username, password);
			
			Statement mojSt = konekcijaZaKontrolore.createStatement();
			
			ResultSet rs = mojSt.executeQuery(sveIzTabele);
			
			while (rs.next()) {
				System.out.println(rs.getString("uredjaj_za_kontrolu") + " " + rs.getInt("broj_viljuskara"));
			}
				
//			mojSt.execute(ubaci);
//			mojSt.execute(izbaci);
			mojSt.execute(promeni);
			
			
			
			
			
				
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
