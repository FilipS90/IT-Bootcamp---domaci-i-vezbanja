package projekat;

import java.sql.*;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Zadatak {
	String connectionString;
	Connection con;
	
	public Zadatak(String conString) {
		connectionString = conString;
	}
	
	public void connect() {
		try {
			con=DriverManager.getConnection(connectionString);
		}
		catch(SQLException e) {
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
	
	public String logovanje() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Unesite korisnicko ime: ");
			String ime = sc.next();
			System.out.println("Unesite password: ");
			String pass = sc.next();
			
			String upit = "Select Korisnik.Username, Korisnik.Password from Korisnik";
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(upit);
			
			while(rs.next()) {
				String username = rs.getString(1);
				String password = rs.getString(2);
				
				if(pass.equals(password) && username.equals(ime)) {
					System.out.println("Uspesna prijava.");
					return ime;
				}
			}
			
			ime="";
			System.out.println("Prijava neuspesna, korisnicko ime ili lozinka nisu validni.");
			return ime;
			
			
		} catch (SQLException e) {
			String ime="";
			System.out.println("Prijava neuspesna, korisnicko ime ili lozinka nisu validni.");
			e.printStackTrace();
			return ime;
		}
	}
	
	public void registracija() {
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite svoje korisnicko ime: ");
		String ime = sc.next();
		System.out.println("Unesite svoju lozinku: ");
		String lozinka = sc.next();
		System.out.println("Unesite ponovo lozinku: ");
		String loz = sc.next();
		
		if(!loz.equals(lozinka)) {
			System.out.println("Uneta lozinka nije ista.");
			return;
		}
		
		char ne = ' ';
		
		if(lozinka.length()<5) {
			System.out.println("Lozinka mora imati minimum 5 karaktera.");
			return;
		}
		for(int i=0;i<ime.length();i++) {
			if(ime.charAt(i)==ne) {
				System.out.println("Korisnicko ime ne moze imati prazan prostor.");
				return;
			}
		}
		for(int i=0;i<lozinka.length();i++) {
			if(lozinka.charAt(i)==ne) {
				System.out.println("Korisnicko ime ne moze imati prazan prostor.");
				return;
			}
		}
		
		String upit = "Select Korisnik.Username, Korisnik.Password from Korisnik";
		
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(upit);
		
		while(rs.next()) {
			String user = rs.getString(1);
			
			if(ime.equals(user)) {
				System.out.println("Korisnicko ime postoji u sistemu.");
				return;
			}
		}
		PreparedStatement ps = con.prepareStatement("Insert into Korisnik (Username, Password) "
				+ "Values (?,?)");
		ps.setString(1, ime);
		ps.setString(2, lozinka);
		ps.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void uplata(String ime) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Prethodno ste kupili: ");
			boolean q=false;
			PreparedStatement ps = con.prepareStatement("Select p.idauto, p.username, m.naziv from Model m, Automobil a,"
					+ " Prodaja p where Username=? and p.idauto=a.idauto and a.idmodel=m.idmodel");
			
			ps.setString(1, ime);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				q=true;
				int id = rs.getInt(1);
				String korisnik = rs.getString(2);
				String model = rs.getString(3);
				System.out.println(id + " - "+ korisnik + " - "+model);
			}
			
			if(q==false) {
				System.out.println("Nemate vec kupljenih automobila.");
				return;
			}
			
			System.out.println("Odaberite ID automobila za koji zelite da izvrsite uplatu:");
			int id=sc.nextInt();
			
			ps=con.prepareStatement("Select p.idauto, p.username from Prodaja p");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				int a = rs.getInt(1);
				String u = rs.getString(2);
				if(a==id && ime.equals(u)) {
					q=false;
				}
			}
			if(q) {
				System.out.println("Uneli ste ID automobila koji niste kupili, pokusajte opet.");
				return;
			}
			q=true;
			
			System.out.println("Odaberite iznos koji zelite da uplatite za odabrani ID:");
			int iznos=sc.nextInt();
		
			LocalDate datum=java.time.LocalDate.now();
			ps=con.prepareStatement("Insert into Uplata (idauto, iznos, datum, iduplata) "
					+ "values (?, ?,'"+datum+"', (select max(iduplata)+1 from Uplata))");
			ps.setInt(1, id);
			ps.setInt(2, iznos);
			ps.execute();
			System.out.println("Uplata uspesno izvrsena.");
			
			ps = con.prepareStatement("Select a.cena, sum(u.iznos) from Automobil a, Uplata u where a.idauto=? and u.idauto=?");
			ps.setInt(1, id);
			ps.setInt(2, id);
			rs = ps.executeQuery();
			rs.next();
			int cena = rs.getInt(1);
			int uplaceno = rs.getInt(2);			
			if(uplaceno>cena) {
				System.out.println("Izvrsene uplate su vece od cene, storniran je visak od "+(uplaceno-cena)+".");
				
				ps = con.prepareStatement("Update Uplata set iznos=iznos-"+(uplaceno-cena)+" where uplata.iduplata in("
						+ "select max(iduplata) from Uplata)");  //izmena na uplati u bazi
				ps.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void kupovina(String ime) {
		try {
			Scanner sc = new Scanner(System.in);
			PreparedStatement ps = con.prepareStatement("Select a.idauto, m.naziv, a.cena"
					+ " from Automobil a, Model m where Status='n' and a.idmodel=m.idmodel");
			ResultSet rs = ps.executeQuery();
			boolean q=true;
			LocalDate datum = java.time.LocalDate.now();
			
			while(rs.next()) {
				int idA = rs.getInt(1);
				String naziv = rs.getString(2);
				int cena = rs.getInt(3);
				q=false;
				
				System.out.println(idA + " - "+naziv+" - "+cena);
			}
			
			if(q) {
				System.out.println("Nema raspolozivih automobila na lageru.");
				return;
			}
			q=true;
			
			System.out.println("Odaberite ID automobila koji zelite da kupite");
			int id = sc.nextInt();
			ps = con.prepareStatement("Select a.idauto from Automobil a where a.idauto="+id);
			rs = ps.executeQuery();
			if(rs.next()) {
				q=false;
			}
			
			if(q) {
				System.out.println("Navedeni ID vozila ne postoji za vozila na lageru.");
				return;
			}
			
			ps = con.prepareStatement("Update Automobil set Status = 'p' where idauto="+id);
			ps.execute();
			
			ps = con.prepareStatement("Update Model set BrProdatih=BrProdatih+1 where idmodel in(select a.idmodel from automobil a where a.idauto="+id+")");
			ps.execute();
			
			java.sql.Date date = java.sql.Date.valueOf(datum);
			ps = con.prepareStatement("Insert into Prodaja (idauto, username, datum) "
					+ "values (?, ?, ?)");
			ps.setInt(1, id);
			ps.setString(2, ime);
			ps.setDate(3, date);
			ps.execute();
			
			System.out.println("Uspesna kupovina vozila.");
			
		} catch (SQLException e) {
			System.out.println("Doslo je do greske, pokusajte opet.");
			e.printStackTrace();
		}
	}
	
	public void admin(String ime) {
		boolean q=true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Dobrodosli u ADMIN meni:");
		System.out.println("Opcija 1 - Za promenu cene vozila odredjenog modela.");
		System.out.println("Opcija 2 - Za nabavku novih vozila.");
		int n = sc.nextInt();
		
		if(n==1) {
			System.out.println("Odaberite ID modela vozila za koje zelite da promenite cenu.");
			try {
				PreparedStatement ps = con.prepareStatement("Select Distinct m.idmodel, m.naziv from Model m, Automobil a"
						+ " where m.naziv is not null and a.idmodel=m.idmodel and a.status='n'");
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					q=false;
					int model = rs.getInt(1);
					String naziv = rs.getString(2);
					System.out.println(model+" - "+naziv);
				}
				
				if(q) {
					System.out.println("Nema vozila na stanju.");
					return;
				}
				q=true;
				
				int id = sc.nextInt();
				
				ps= con.prepareStatement("Select m.idmodel from Model m, Automobil a where a.status='n' and a.idmodel"
						+ "=m.idmodel and m.idmodel="+id);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					int mt = rs.getInt(1);
					if(mt==id)
						q=false;
				}
				
				if(q) {
					System.out.println("Na stanju nema modela sa zadatim ID-jem.");
					return;
				}
				q=true;
				
				System.out.println("Upisite novu cenu za odabrani model:");
				int nCena=sc.nextInt();
				
				ps = con.prepareStatement("Update Automobil set Cena=? where idmodel=? and status='n'");
				ps.setInt(1, nCena);
				ps.setInt(2, id);
				ps.execute();
				
				System.out.println("Uspesno ste promenili cenu vozila.");
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(n==2) {
			try {
					Random rand=new Random();
					System.out.println("Odaberite ID modela koji zelite da kupite:");
					PreparedStatement ps = con.prepareStatement("Select m.idmodel, m.naziv from Model m"
							+ " where m.naziv is not null");
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()) {
						int mod = rs.getInt(1);
						String naziv = rs.getString(2);
						System.out.println(mod+" - "+naziv);
					}
					
					int id=sc.nextInt();
					
					ps = con.prepareStatement("Select m.idmodel from Model m where naziv is not null");
					rs = ps.executeQuery();
					while(rs.next()) {
						int x = rs.getInt(1);
						if(x==id)
							q=false;
					}
					
					if(q) {
						System.out.println("ID modela ne postoji u bazi.");
						return;
					}
					q=true;
					
					System.out.println("Koliko vozila izabranog modela zelite:");
					int h=sc.nextInt();
					
					for(int i=0;i<h;i++) {
						ps = con.prepareStatement("Insert into Automobil (idmodel, cena, idDob, status)"
								+ " values(?, (select a.cena from Automobil a where a.idmodel=?), "+rand.nextInt(2)+1+", 'n')");
						ps.setInt(1, id);
						ps.setInt(2, id);
						ps.execute();
						ps = con.prepareStatement("Insert into Nabavka(idAuto, NabavnaCena)"
								+ " values((select max(a.idauto) from Automobil a), (select a.cena from"
								+ " Automobil a where a.idauto in(select max(a.idauto) from Automobil a)-6000))");
						ps.execute();
						
					}
					
					System.out.println("Uspesno ste izvrsili nabavku "+h+" vozila.");
					
						
				} catch (SQLException e) {
					System.out.println("Greska, pokusajte ponovo.");
					e.printStackTrace();
				}
			
		}
		
	}
}
