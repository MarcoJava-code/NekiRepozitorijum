package jdbcdriver;

import java.sql.*;
import java.util.concurrent.locks.StampedLock;

public class Srodstvo {

	public static void main(String[] args) {
		
		//CRUD aplikacije - create, read, update, delete
		
		try {
			
			String url = "jdbc:mysql://localhost:3306/srodstvo";
			String username = "root";
			String password =  "mesqlno85";
		
			String innerJoin = "SELECT ime_dete, ime_osoba, prezime_dete FROM osoba " + 
							"INNER JOIN dete " + "ON osoba.id_osoba = dete.id_osoba";
			
			String selektujSve = "SELECT * from osoba";
			
			String rightJoin = "SELECT ime_dete, ime_osoba, prezime_dete FROM osoba\r\n" + 
					"RIGHT JOIN dete \r\n" + 
					"ON osoba.id_osoba = dete.id_osoba";
			
			//Dobijanje konkcije
			
			Connection mojaKonekcija = DriverManager.getConnection(url, username, password);
			
			//Create statement
			
			Statement myStmt = mojaKonekcija.createStatement();

			
			//Execute query
			
			//READ
			
/*			ResultSet rs = myStmt.executeQuery(imeIPrezimeZaposlenih);
			
			while (rs.next()) {
				System.out.println(rs.getString("ime") + " " + rs.getString("prezime"));	
			}
		
			
/*			//INSERT
			
			myStmt.executeUpdate(dodajNovogZaposlenog);
			System.out.println("Insert successfully");
*/
			
			
			//UPDATE
			
/*			myStmt.executeUpdate(promeniPodatakZaposlenog);
			System.out.println("Update successfully");
*/
			
			//DELETE
/*			int rowAffected = myStmt.executeUpdate(izbrisiZaposlenog);
			System.out.println("Row affected: " + rowAffected);
*/

			
			//PRAVLJENJE UPITA SA PARAMETRIMA
			
			PreparedStatement prepStmt = mojaKonekcija.prepareStatement(rightJoin);
			
			
			ResultSet resultSet = prepStmt.executeQuery();
			
			while (resultSet.next()) {
			// System.out.println(resultSet.getString("ime_dete") + " " + resultSet.getString("ime_osoba") + " " + resultSet.getString("prezime_dete"));	
			// System.out.println(resultSet.getString("ime_osoba"));
			System.out.println(resultSet.getString("ime_dete") + " " + resultSet.getString("ime_osoba") + " " + resultSet.getString("prezime_dete"));	

			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
