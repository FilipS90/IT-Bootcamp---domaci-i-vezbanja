package sql;

import java.sql.*;

public class Fakultet {
	String connectionString;
	Connection con;
	
	public Fakultet(String conString) {
		connectionString = conString;
	}
	
	public void connect() {
		try {
			con=DriverManager.getConnection(connectionString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		try {
			if(con!=null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dodajStudenta(int indeks, String ime, String prezime, String datumUpisa, String datumRodjenja, String mestoRodjenja) {
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO dosije (indeks, ime, prezime, datum_upisa, datum_rodjenja, mesto_rodjenja)"
					+ " values (?, ?, ?, ?, ?, ?)");
				
			ps.setInt(1, indeks);
			ps.setString(2, ime);
			ps.setString(3, prezime);
			ps.setString(4, datumUpisa);
			ps.setString(5, datumRodjenja);
			ps.setString(6, mestoRodjenja);
			ps.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void ispisStudenata() {
		try {
		String upit = "Select d.indeks, d.ime, d.prezime, d.datum_upisa, d.datum_rodjenja, d.mesto_rodjenja"
				+ " from dosije d ";
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(upit);
		
		while(rs.next()) {
			int indeks = rs.getInt(1);
			String ime = rs.getString(2);
			String prezime = rs.getString(3);
			String upis = rs.getString(4);
			String rodjenje = rs.getString(5);
			String mesto = rs.getString(6);
			
			System.out.println(indeks + " " + ime + " " + prezime + " " + upis + " " + rodjenje + " " + mesto);
			
		}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void ispisPredmeta() {
		try {
			String upit = "Select p.id_predmeta, p.sifra, p.naziv, p.bodovi"
					+ " from predmet p";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(upit);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String sifra = rs.getString(2);
				String naziv = rs.getString(3);
				int bodovi = rs.getInt(4);
				
				System.out.println(id + " " + sifra + " " + naziv + " " + bodovi);
			}
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
}
	public void ispisBeograd() {
		try {
			String upit = "Select d.indeks, d.ime, d.prezime, d.datum_upisa, d.datum_rodjenja, d.mesto_rodjenja "
					+ " From dosije d"
					+ " Where d.mesto_rodjenja =\"Beograd\"";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(upit);
			
			while(rs.next()) {
				int indeks=rs.getInt(1);
				String ime =rs.getString(2);
				String prezime = rs.getString(3);
				String upis = rs.getString(4);
				String rodjenje = rs.getString(5);
				String mesto = rs.getString(6);
				
				System.out.println(indeks +" "+ ime + " " + prezime + " " + upis + " " + rodjenje+" "+mesto);
			}
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	public void ispisMesta() {
		try {
		String upit = "Select DISTINCT d.mesto_rodjenja"
				+ " from dosije d"
				+ " where d.mesto_rodjenja != \"null\"";
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(upit);
		
		while(rs.next()) {
			String mesto = rs.getString(1);
			
			System.out.println(mesto);
		}
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void predmeti6Plus(){
		try {
		String upit = "Select p.sifra, p.naziv from predmet p where p.bodovi>8 and p.bodovi<15";
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(upit);
		
		while(rs.next()) {
			String naziv = rs.getString(1);
			System.out.println(naziv);
		}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void predmeti8I15(){
		try {
		String upit = "Select p.sifra, p.naziv from predmet p where p.bodovi>8 and p.bodovi<15";
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(upit);
		
		while(rs.next()) {
			String naziv = rs.getString(1);
			System.out.println(naziv);
		}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void bodoviImaTacno() {
		try {
			String upit = "Select Distinct * from Ispit i where i.bodovi=81 or i.bodovi=76 or i.bodovi=59 group by id_predmeta";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(upit);
			
			while(rs.next()) {
				int indeks = rs.getInt(1);
				int id = rs.getInt(2);
				int godina = rs.getInt(3);
				String oznaka = rs.getString(4);
				int ocena = rs.getInt(5);
				String datum = rs.getString(6);
				int bodovi = rs.getInt(7);
				
				System.out.println(indeks + " " + id + " " + godina + " "+ oznaka + " " + ocena + " " + datum + " " + bodovi);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void bodoviNemaTacno() {
		try {
			String upit = "Select * from Ispit i group by id_predmeta having i.bodovi!=81 and i.bodovi!=59 and i.bodovi!=76";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(upit);
			
			while(rs.next()) {
				int indeks = rs.getInt(1);
				int id = rs.getInt(2);
				int godina = rs.getInt(3);
				String oznaka = rs.getString(4);
				int ocena = rs.getInt(5);
				String datum = rs.getString(6);
				int bodovi = rs.getInt(7);
				
				System.out.println(indeks + " " + id + " " + godina + " "+ oznaka + " " + ocena + " " + datum + " " + bodovi);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cena() {
		try {
		String upit = "Select p.naziv, p.bodovi*1500 as \"Cena ispita za samofin\" from predmet p";
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(upit);
		
		while(rs.next()) {
			String naziv = rs.getString(1);
			int cena = rs.getInt(2);
			
			System.out.println(naziv + " - "+cena+ " din");
		}
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void brisi() {
		try {
			String upit ="Delete from ispit Where ocena not between 5 and 10 ";
			Statement stm = con.createStatement();
			stm.executeUpdate(upit);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setDatumRodjenja(int indeks, String datumRodjenja) {
		try {
		PreparedStatement ps = con.prepareStatement("Update Dosije set datum_rodjenja = ? where indeks = ?");
		
		ps.setString(1, datumRodjenja);
		ps.setInt(2, indeks);
		ps.execute();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

