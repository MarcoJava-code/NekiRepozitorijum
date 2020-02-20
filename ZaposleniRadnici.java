package jdbcdriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ZaposleniRadnici {

	public static void main(String[] args) {
		
		try {
			
			String url = "jdbc:mysql://localhost:3306/vezbe1";
			String user = "root";
			String password =  "mesqlno85";
			
			String dodajZaposlene = "insert into odeljenja (ime, prezime, plata, mart)" + "VALUES ('Marko', 'Markovic', '30000.00', '30000.00')";
			String gradIPostanskiKod = "insert into lokacija (grad, postanski_kod,telefon)" + "VALUES ('Beograd', '011', '123')";
			String updateOdeljenja = "update odeljenja set mart=plata+(plata/10)";
			String selektujTelefone = "select telefon from lokacija";
			String imeIPrezime = "select concat(ime, ' ', prezime) as 'Ime i Prezime' from vezbe1.zaposleni_radnici";
			
			
			
			
			
			Connection konZaposleni = DriverManager.getConnection(url, user, password);
			
			Statement mojStm = konZaposleni.createStatement();
			mojStm.executeUpdate(dodajZaposlene);
			mojStm.executeUpdate(updateOdeljenja);
			
			
			
			
			
//			PreparedStatement mojPrepStm = konZaposleni.prepareStatement(selektujTelefone);
//			mojPrepStm.setInt(1, 2);
//			
//			ResultSet rs = mojPrepStm.executeQuery();
//			
//			while (rs.next()) {
//				System.out.println(rs.getInt("telefon"));
//				
//			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
