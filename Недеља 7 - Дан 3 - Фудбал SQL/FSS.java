package fss;

import java.sql.*;


public class FSS {
	String connectionString;
	Connection con;
	
	public FSS(String conString) {
		connectionString = conString;
	}
	
	public void connect() {
		try {
			con = DriverManager.getConnection(connectionString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		try {
			if(con!=null && !con.isClosed())
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ispisIgracTim() {
		try {
			String upit = "Select f.ime, t.naziv from Fudbaler f join Tim t"
					+ " using(idtim)";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(upit);
			
			while(rs.next()) {
				String ime = rs.getString(1);
				String naziv = rs.getString(2);
				
				System.out.println(ime+" - "+ naziv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ispisMancester() {
		try {
			String upit = "Select f.ime from Fudbaler f, Tim t where t.idtim=f.idtim and t.naziv=\"Manchester United\"";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(upit);
			
			while(rs.next()) {
				String ime = rs.getString(1);
				
				System.out.println(ime);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void brojGolova() {
		try {
			String upit = "Select f.ime, count(g.idgol) from Fudbaler f, Gol g where f.idfud=g.idfud group by f.ime";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(upit);
			
			while(rs.next()) {
				String ime = rs.getString(1);
				int broj = rs.getInt(2);
				
				System.out.println(ime+" - "+broj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void maxGol() {
		try {
			PreparedStatement ps = con.prepareStatement("select f.ime\r\n" + 
					"from (Select f.ime, f.IdFud, count(g.idgol) as golovi from Fudbaler f, Gol g where f.idfud=g.idfud group by f.ime) z, Fudbaler f\r\n" + 
					"where f.IdFud=z.IdFud\r\n" + 
					"group by f.Ime\r\n" + 
					"HAVING max(golovi) = (select max(golovi) from (Select f.ime, count(g.idgol) as golovi from Fudbaler f, Gol g where f.idfud=g.idfud group by f.ime))\r\n" + 
					"\r\n" + 
					"");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String ime = rs.getString(1);
				
				System.out.println(ime);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void brojKartona() {
		try {
			PreparedStatement ps = con.prepareStatement("SELECT z.ime, crveni, zuti\r\n" + 
					"from (Select f.ime, f.IdFud, count(k.tip) as zuti from fudbaler f, karton k WHERE f.IdFud=k.IdFud and tip=\"zuti karton\" group by f.ime) z Left JOIN\r\n" + 
					"(Select f.ime, f.IdFud, count(k.tip) as crveni from fudbaler f, karton k WHERE f.IdFud=k.IdFud and tip=\"crveni karton\") c\r\n" + 
					"on (z.IdFud=c.IdFud)\r\n" + 
					"group by z.Ime"); //znam da ima jednostavnije sa count when, to sam posle video
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String ime = rs.getString(1);
				int crveni = rs.getInt(2);
				int zuti = rs.getInt(3);
				
				System.out.println(ime+ " - "+crveni+" - "+zuti);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void gradovi(int idIgraca) {
		try {
			PreparedStatement ps = con.prepareStatement("Select t.Mesto as Grad\r\n" + 
					"from Fudbaler f, Igrao i, Utakmica u, tim t\r\n" + 
					"where f.IdFud="+idIgraca+" and f.idfud=i.IdFud and i.IdUta=u.IdUta and u.IdGost=t.IdTim\r\n" + 
					"UNION\r\n" + 
					"Select t.Mesto\r\n" + 
					"from Fudbaler f, Tim t\r\n" + 
					"where f.IdFud="+idIgraca+" and f.IdTim=t.IdTim");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String mesto = rs.getString(1);
				
				System.out.println(mesto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dodajIgraca(String imeIgraca, String imeKluba) {
		try {
			boolean klub = false;
			PreparedStatement ps = con.prepareStatement("Select t.naziv from Tim t");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String naziv=rs.getString(1);
				if(imeKluba.equals(naziv))
					klub=true;
			}
			if(klub!=true) {
				System.out.println("Ne postoji klub sa imenom koji ste uneli, pokusajte ponovo.");
				System.out.println("");
				return;
			}
			
			ps = con.prepareStatement("Insert into fudbaler (idfud, ime, idtim)"
					+ " values((select max(f.idfud)+1 from fudbaler f),?,(select t.idtim from tim t where t.naziv=?))");
			ps.setString(1, imeIgraca);
			ps.setString(2, imeKluba);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dodajTim(String nazivTima, String mesto) {
		try {
			PreparedStatement ps = con.prepareStatement("Insert into Tim (idtim, naziv, mesto)"
					+ " values ((select max(idtim)+1 from tim), ?, ?)");
			ps.setString(1, nazivTima);
			ps.setString(2, mesto);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void dodajUtakmicu(String domKlub, String gostKlub, int kolo, String ishod, int godina) {
		try {
			if(!ishod.equals("x") && !ishod.equals("1") && !ishod.equals("2")) {
				System.out.println("Uneli ste pogresan unos za ishod, validne vrednosti su x, 1 ili 2.");
			}
			boolean gost=false;
			boolean dom=false;
			
			PreparedStatement ps = con.prepareStatement("Select t.naziv from Tim t");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String naziv=rs.getString(1);
				if(gostKlub.equals(naziv)) 
					gost=true;
				if(domKlub.equals(naziv)) 
					dom=true;
				if(gost==true && dom==true)
					break;
			}
			if(gost!=true || dom!=true) {
				System.out.println("Ne postoji klub sa imenom koji ste uneli, pokusajte ponovo.");
				return;
			}
			
			ps=con.prepareStatement("Insert INTO Utakmica(IdUta, IdDomacin, IdGost, Kolo, Ishod, Godina)"
					+ " values((select max(iduta)+1 from utakmica),"
					+ " (select t.idtim from tim t where t.naziv=?),"
					+ " (select t.idtim from tim t where t.naziv=?),"
					+ " ?, ?, ?)");
			ps.setString(1, domKlub);
			ps.setString(2, gostKlub);
			ps.setInt(3, kolo);
			ps.setString(4, ishod);
			ps.setInt(5, godina);
			ps.executeUpdate();
			
			ps=con.prepareStatement("Insert into Igrao(idfud, idUta, pozicijaigraca)"
					+ " select idfud, iduta, null"
					+ " from fudbaler join tim using (idtim) join utakmica on (idtim = iddomacin"
					+ " or idtim = idgost)"
					+ " where (select max(iduta) from utakmica)");
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void obrisiTim(String ime) {
		try {
			PreparedStatement ps = con.prepareStatement("Delete from Utakmica"
					+ " where utakmica.idgost in(select t.idtim from tim t, utakmica u where t.naziv=?) and utakmica.iddomacin in(select t.idtim from tim t, utakmica u where t.naziv=?)");
			ps.setString(1, ime);
			ps.setString(2, ime);
			ps.execute();
			
			ps=con.prepareStatement("Delete from Gol where idfud in(select f.idfud from fudbaler f, tim t where t.naziv=? and f.idtim=t.idtim)");
			ps.setString(1, ime);
			ps.execute();
			
			ps=con.prepareStatement("Delete from Karton where idfud in(select f.idfud from fudbaler f, tim t where t.naziv=? and f.idtim=t.idtim)");
			ps.setString(1, ime);
			ps.execute();
			
			ps=con.prepareStatement("Delete from Igrao where idfud in(select f.idfud from fudbaler f, tim t where t.naziv=? and f.idtim=t.idtim)");
			ps.setString(1,  ime);
			ps.execute();
			
			ps=con.prepareStatement("Delete from Fudbaler where idfud in(select f.idfud from fudbaler f, tim t where t.naziv=? and f.idtim=t.idtim)");
			ps.setString(1,  ime);
			ps.execute();
			
			ps=con.prepareStatement("Delete from Tim where tim.idtim in(select t.idtim from tim t where t.naziv=?)");
			ps.setString(1,  ime);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
