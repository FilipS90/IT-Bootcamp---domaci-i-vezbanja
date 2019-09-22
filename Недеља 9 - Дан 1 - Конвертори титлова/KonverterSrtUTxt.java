package paketic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class KonverterSrtUTxt {

	public static void main(String[] args) throws Exception {
		FileReader reader = new FileReader("C:\\Users\\Filip\\Desktop\\titlovi\\Primer.srt");
		BufferedReader br = new BufferedReader(reader);
		String a = br.readLine();
		StringBuilder sb = new StringBuilder();
		String fps = "";
		String [] sms;
		String [] smls;
		boolean test = false;
		double milisec2 = 0;
		int sati = 0, minuti = 0, sec = 0, milisec=0, sum=0, q=0;
		
		while(a!=null) {
			if(a.equals("")) {
				a=br.readLine();
				continue;
			}
			char x = a.charAt(0);
			if(Character.isDigit(x)) {
				if(Integer.parseInt(Character.toString(x))==0) {
					q=0;
					fps=a.substring(0, 12);
					sms = fps.split(":");
					sati = 25*3600*(Integer.parseInt(sms[0]));
					minuti = 25*60*(Integer.parseInt(sms[1]));
					smls = sms[2].split(",");
					sec = 25*(Integer.parseInt(smls[0]));
					milisec2 = 25*Double.parseDouble(smls[1])/1000;
					milisec = (int) Math.round(milisec2);
					sum=sati+minuti+sec+milisec;
					if(test==true)
						sb.append("\n");
					sb.append("{"+Integer.toString(sum)+"}");
					test=false;
					
					fps=a.substring(17, 29);
					sms = fps.split(":");
					sati = 25*3600*(Integer.parseInt(sms[0]));
					minuti = 25*60*(Integer.parseInt(sms[1]));
					smls = sms[2].split(",");
					sec = 25*(Integer.parseInt(smls[0]));
					milisec2 = 25*Double.parseDouble(smls[1])/1000;
					milisec = (int) Math.round(milisec2);
					sum=sati+minuti+sec+milisec;
					sb.append("{"+Integer.toString(sum)+"}");
				}
			}
				else if((x>=33 && x<=47) || (x>=58 && x<126)) {
					q++;
					test=true;
					if(a.length()>4) {
					if(a.substring(0, 3).equals("<i>") || a.substring(a.length()-4, a.length()).equals("</i>")){
						String linija="";
						if(a.substring(0, 3).equals("<i>")) {
						linija=a.replace("<i>", "");
						a=linija;
						sb.append("{Y:i}");
						}
						linija=a.replace("</i>", "");
						a=linija;
					}
					if(q==2) {
						sb.append("|"+a);
					}
					else {
						sb.append(a);
					}
				}
				}
				a=br.readLine();
		}
		
		a=sb.toString();
		FileWriter fw = new FileWriter(new File("src", "Titl_txt"));
		fw.write(a);
		fw.flush();
		fw.close();
		br.close();
		reader.close();	
	}
}
