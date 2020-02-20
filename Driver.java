package jdbcdriver;

import java.sql.*;
import java.util.concurrent.locks.StampedLock;

public class Driver {

	public static void main(String[] args) {
		
		//CRUD aplikacije - create, read, update, delete
		
		try {
			
			String url = "jdbc:mysql://localhost:3306/demo";
			String username = "root";
			String password =  "mesqlno85";
		
			String getId = "select id_zaposleni from zaposleni where email='ana@gmail.com' and prezime='Milanovic'";
			String imeIPrezimeZaposlenih = "select * from zaposleni";		//Dobijanje svih zaposlenih iz tabele zaposleni
			String dodajNovogZaposlenog = "insert into zaposleni (ime, prezime, email,  plata)"
					+ " VALUES ('Ana', 'Milanovic', 'ana@gmail.com', 82000.00)";
			String promeniPodatakZaposlenog = "update zaposleni set plata=87000.00 where email='ana@gmail.com'";
			String izbrisiZaposlenog = "delete from zaposleni where id_zaposleni =6";
			String selektujPodatke = "select * from zaposleni where plata between ? and ?";
			
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
			
			PreparedStatement prepStmt = mojaKonekcija.prepareStatement(selektujPodatke);
			prepStmt.setDouble(1, 80000.00);
			prepStmt.setDouble(2, 100000.00);
			
			
			ResultSet resultSet = prepStmt.executeQuery();
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString("ime") + " " + resultSet.getString("prezime") + " " + resultSet.getString("plata"));	
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
