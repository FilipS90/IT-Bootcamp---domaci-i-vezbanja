package paketic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class KonverterTxtUSrt {

	public static void main(String[] args) throws Exception {
		FileReader reader = new FileReader("C:\\Users\\Filip\\Desktop\\titlovi\\Primer.txt");
		BufferedReader br = new BufferedReader(reader);
		String a = br.readLine();
		StringBuilder sb = new StringBuilder();
		String fps = "";
		String fps2= "";
		String tekst="";
		String ssati, ssati2, sminuti, sminuti2, ssec, ssec2;
		int broj=1, q=0, sati = 0, sati2=0, minuti = 0,minuti2=0, i=1;
		double sec = 0, sec2=0;
		
		while(a!=null) {
			for(;i<15;i++) {
				if(a.charAt(i)>57 || a.charAt(i)<48) 
					q++;
					if(a.charAt(i)==123)
						continue;
				if(q==0) 
					fps+=a.charAt(i);
				if(q==2)
					fps2+=a.charAt(i);
				if(q==3)
					break;
			}
			q=0;
			sec = Double.parseDouble(fps)/25;
			sec2= Double.parseDouble(fps2)/25;
			
			while(sec>3600) {
				sati++;
				sec-=3600;
			}
			
			while(sec2>3600) {
				sati2++;
				sec2-=3600;
			}
			
			minuti = (int) Math.floor(sec/ 60);
			sec-=minuti*60;
			minuti2= (int) Math.floor(sec2/60);
			sec2-=minuti2*60;
			sec=Math.round(sec*100.0)/100.0;
			sec2=Math.round(sec2*100.0)/100.0;
			
			ssati="0"+Integer.toString(sati);
			ssati2="0"+Integer.toString(sati2);
			if(minuti<10)
				sminuti="0"+Integer.toString(minuti);
			else
				sminuti=Integer.toString(minuti);
			if(minuti2<10)
				sminuti2="0"+Integer.toString(minuti2);
			else
				sminuti2=Integer.toString(minuti2);
			if(sec<10) {
				ssec="0"+Double.toString(sec)+"0";
				if(ssec.length()==5)
					ssec+="0";
			}
			else {
				ssec=Double.toString(sec)+"0";
					if(ssec.length()==5)
						ssec+="0";
					if(ssec.length()==4)
						ssec+="00";
				}
			if(sec2<10) {
				ssec2="0"+Double.toString(sec2)+"0";
				if(ssec2.length()==5)
						ssec2+="0";
				}
			else {
				ssec2=Double.toString(sec2)+"0";
					if(ssec2.length()==5)
						ssec2+="0";
					if(ssec2.length()==4)
						ssec2+="00";
			}
			
			fps=ssati+":"+sminuti+":"+ssec;
			fps2=ssati2+":"+sminuti2+":"+ssec2;
			
			fps=fps.replace(".", ",");
			fps2=fps2.replace(".", ",");
			
			if(a.contains("|"))
				a=a.replace("|", "\n");
			if(a.charAt(++i)==123) {
				i+=4;
				tekst="<i>"+a.substring(i, a.length())+"</i>";
			}
			else
				tekst=a.substring(i, a.length());
			
			sb.append(broj+++"\n");
			sb.append(fps+" --> "+fps2+"\n");
			sb.append(tekst+"\n\n");
			
			sec=0;
			sec2=0;
			minuti=0;
			minuti2=0;
			sati=0;
			sati2=0;
			fps="";
			fps2="";
			i=1;
			
			a = br.readLine();
			
		}
		
		a=sb.toString();
		FileWriter fw = new FileWriter (new File("src", "SRC_title"));
		fw.write(a);
		fw.flush();
		fw.close();
		br.close();
		reader.close();

	}

}
