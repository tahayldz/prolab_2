

package dijkstrasalgorithm;
 

import java.util.*;
import java.io.*;

public class DijkstrasAlgorithm { 

	private static final int NO_PARENT = -1;
	static int sayac = 0;
		static int yollar[]=new int [81];
	  

		static void yazma(String[] iller)throws Exception{
		
		
			FileReader f=new FileReader("iller.txt"); 
			
		  BufferedReader an=new BufferedReader(f);
		  
			 for(int i=0;i<81;i++){
			   
			iller[i]=an.readLine();
			}
		   
			f.close();
		}
		
		

	static int fak(int sayi){

		if (sayi == 1){
			return 1;
		}
		return sayi*fak(sayi-1);
	}
		

	void dijkstra(int[][] matris, int[] baslangic, int[] toplamDizi) throws Exception
	{ 
		FileWriter fw = new FileWriter("output-all.txt",true); 
		

		int toplam=0;		


		
		for(int T=0;T<baslangic.length-1; T++) { 
			
		int nVertex = matris[0].length; 


		int[] KisaUzakliklar = new int[nVertex]; 
 
		boolean[] ekle = new boolean[nVertex]; 


		for (int vertexIndex = 0; vertexIndex < nVertex;vertexIndex++) 
		{ 
			KisaUzakliklar[vertexIndex] = Integer.MAX_VALUE; 
			ekle[vertexIndex] = false; 
		} 
		
		KisaUzakliklar[baslangic[T]] = 0; 

		int[] parents = new int[nVertex]; 

		parents[baslangic[T]] = NO_PARENT; 


		for (int i = 1; i < nVertex; i++) 
		{ 

			int nearestVertex = -1; 
			int KisaUzaklik = Integer.MAX_VALUE; 
			for (int vertexIndex = 0; vertexIndex < nVertex; vertexIndex++) 
			{ 
				if (!ekle[vertexIndex] && KisaUzakliklar[vertexIndex] < KisaUzaklik) 
				{ 
					nearestVertex = vertexIndex; 
					KisaUzaklik = KisaUzakliklar[vertexIndex]; 
				} 
			} 

			ekle[nearestVertex] = true; 

			for (int vertexIndex = 0;vertexIndex < nVertex;vertexIndex++) 
			{ 
				int kenarUzaklik = matris[nearestVertex][vertexIndex]; 
				
				if (kenarUzaklik > 0
					&& ((KisaUzaklik + kenarUzaklik) < KisaUzakliklar[vertexIndex])) 
				{ 
					parents[vertexIndex] = nearestVertex; 
					KisaUzakliklar[vertexIndex] = KisaUzaklik + kenarUzaklik; 
				} 
			} 
		} 

		toplam += yazCozum( baslangic[T], KisaUzakliklar, parents,baslangic[T+1]); 
	}

		toplamDizi[sayac]=toplam;
		
		fw.write("\ntoplam mesafe: "+toplamDizi[sayac]+"");
		fw.write("\n");
		sayac++;
				for(int i=0;i<81;i++){
				yollar[i]=0;
				}
				
			   
		if(sayac==toplamDizi.length){
			enKisa(toplamDizi);
			}
	
		fw.close();
		
	} 

	static void enKisa(int[] toplamDizi)throws Exception{

			Arrays.sort(toplamDizi);
			
			okuBakiyim(toplamDizi,toplamDizi[0]);
	}


	private static int yazCozum(int baslangic,int[] uzaklik, int[] parents, int istenen) throws Exception 
	{   
		
		FileWriter fw = new FileWriter("output-all.txt",true);
				String iller[]=new String[81];
								yazma(iller);
		int mesafe =0;
		Scanner in = new Scanner(System.in);
		int nVertex = uzaklik.length; 
		
		
		for (int vertexIndex = 0; 
				vertexIndex < nVertex; 
				vertexIndex++) 
		{ 
			if (vertexIndex != baslangic && vertexIndex == istenen) 
			{ 

				yazYOL(vertexIndex, parents,baslangic);
				
				mesafe = uzaklik[vertexIndex];
			} 
		} 
		 
		fw.close();

		 return mesafe;
	} 


	private static void yazYOL(int mevcutVertex, int[] parents,int istenen) throws Exception
	{ 
		String iller[]=new String[81];
		yazma(iller);

		FileWriter fw = new FileWriter("output-all.txt",true);
				
		if (mevcutVertex == NO_PARENT) 
		{ 
			
			return; 
		} 
		yazYOL(parents[mevcutVertex], parents,istenen); 
		
		fw.write(iller[mevcutVertex] + " "); 
				 if(mevcutVertex!=istenen)
			   yollar[mevcutVertex]=yollar[mevcutVertex]+1;

		fw.write("("+yollar[mevcutVertex]+".gecis) => " );
		
		fw.close();
	} 
	
	static void okuBakiyim(int[] enKisaMesafe, int kisaMesaf) throws Exception{
		
		FileWriter fw = new FileWriter("EnKisaYol.txt",true);
		FileWriter fw2 = new FileWriter("EnKisa5Yol.txt",true);
		int sayac=0;
		String kisaMesafe = Integer.toString(kisaMesaf);
		String kisaMesafeler[] = new String[5];
		for(int i=0;i<5;i++)
			kisaMesafeler[i] = Integer.toString(enKisaMesafe[i]);

		String[] iller = new String[2];
		String[] enKisaYOL = new String[2];
    

		FileReader f=new FileReader("output-all.txt"); 
			
		BufferedReader an=new BufferedReader(f);
		System.out.println("********************************");
		System.out.println("EN KISA YOL: ");

		while(true){
			enKisaYOL[0]=an.readLine();
			enKisaYOL[1]=an.readLine();

			if(enKisaYOL[0]==null || enKisaYOL[1] == null){
				break;
			}
			if(enKisaYOL[1].contains(kisaMesafe)){
				System.out.println(enKisaYOL[0]);
				fw.write(enKisaYOL[0]);
				System.out.println(enKisaYOL[1]);
				fw.write(enKisaYOL[1]);
				break;
			}
		}
		fw.close();
		f.close();
		f=new FileReader("output-all.txt"); 	
		an=new BufferedReader(f);
		while(true){
			iller[0]=an.readLine();
			iller[1]=an.readLine();

			if(iller[0]==null || iller[1] == null){
				break;
			}

			for(int i=0;i<5;i++){
				if(iller[1].contains(kisaMesafeler[i]) && sayac<=5){
					
					fw2.write(iller[0]+"\n");
					fw2.write(iller[1]+"\n");
					sayac++;			
				}
							
			}	
		}
    	fw2.close();
    	f.close();
	}
	static int toplamDiziBoyutu(int sehirSayisi){
 
		
		if(sehirSayisi == 6){
			return 20;
		}

		return sehirSayisi+toplamDiziBoyutu(sehirSayisi-1);
	}

	public static void main(String[] args) throws Exception 
	{
		File dosya1 = new File("output-all.txt");
		File dosya2 = new File("EnKisaYol.txt");
		File dosya3 = new File("EnKisa5Yol.txt");

		if(dosya1.exists() || dosya2.exists() || dosya3.exists())
		{ 
        dosya1.delete();
        dosya2.delete();
        dosya3.delete();
    	}
		
		Scanner in = new Scanner(System.in);
				String iller[]=new String[81];
				yazma(iller);
		Permutasyon a = new Permutasyon();
		
		System.out.println("Plaka girmek icin 1, Sehir ismi girmek icin 2");
		int secim = in.nextInt();

		System.out.println("Kaç şehre gidilecek: ");
		int sehirSayisi = in.nextInt();

		int[] istenen= new int[sehirSayisi+2];
		
		String istenenSehir[]=new String[sehirSayisi+2];
		
		istenenSehir[0]="Kocaeli";
		istenen[0]=40;

		istenenSehir[istenenSehir.length-1]="Kocaeli";
		istenen[istenenSehir.length-1]=40;

		if(secim==1){
			System.out.println("Gidilmek istenen il plakası girin: ");
			for(int i=1;i<istenen.length-1;i++)
    			istenen[i]=in.nextInt()-1;
		}		

		else if(secim==2){
			System.out.println("Gidilmek istenen il ismini girin:");
			for(int i=0;i<istenen.length-1;i++)
				istenenSehir[i]=in.nextLine();
			for(int i=0;i<istenen.length-1;i++){
				for(int j=0;j<81;j++){
					if(istenenSehir[i].equalsIgnoreCase(iller[j])){
						istenen[i]=j;
						break;
					} 
				}
			}			   
		}

		if(sehirSayisi<=5){
			int[] toplamDizi = new int[fak(sehirSayisi)];
			a.permute1(1, istenen, toplamDizi);
		}
		else{
			int[] toplamDizi = new int[toplamDiziBoyutu(sehirSayisi)];
			a.permute2(1, istenen, toplamDizi);
		}

		dosya1.delete();

		System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("\nEn kisa yol EnKisaYol.txt dosyasina yazdirildi.");
        System.out.println("\nEn kisa 5 yol EnKisa5Yol.txt dosyasina yazdirildi.");

		 
	} 
} 
