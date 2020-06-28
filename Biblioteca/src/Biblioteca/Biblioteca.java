package Biblioteca;

import Carti.Carte;
import Oameni.Cititor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static java.lang.System.exit;

public class Biblioteca {
	public static void print(Object[] array, int length) {
		for(int i=0;i<length;i++)
			System.out.println(array[i]);
	}

	public static void cautareTitlu(Carte[] carti, int cartiLength)
	{
		//CAUTARE DUPA TITLU CARTE
		Scanner tas = new Scanner(System.in);
		System.out.print("Cautare dupa titlu: ");
		String numeCautat;
		numeCautat = tas.nextLine();
		for (int i=0;i<cartiLength;i++) {
			if (carti[i].getTitlu().equals(numeCautat))
				System.out.println("Autorul cartii este: " + carti[i].getAutor());
				/*else {
					System.out.println("Wrong title bitch!!"); //de ce apare asta de X ori dumnezeu cu mila AH SUNT X CARTI proasta sunt
				}*/ //de mentionat ca daca scrii bine tot iti arata eroare pentru restul cartilor
		}
		tas.close();
	}
	public static void cautareAutor(Carte[] carti, int cartiLength) {
		//CAUTARE DUPA AUTOR
		System.out.print("Cautare dupa autor: ");
		String autorCautat;
		Scanner tas = new Scanner(System.in);
		autorCautat=tas.nextLine();
		for (int i=0;i<cartiLength;i++) {
			if (carti[i].getAutor().equals(autorCautat))
				System.out.println("Titlul cartii este: " + carti[i].getTitlu());
			/*else {
				System.out.println("Wrong author bitch!!");
			}*/
		}
		tas.close();
	}
	public static void adaugareCarte() throws IOException {
		//ADAUGARE CARTE
		System.out.println("Ce carte vrei sa adaugi?(numecarte,autor)");
		BufferedWriter bw = new BufferedWriter(new FileWriter("carti.txt",true));
		Scanner tas = new Scanner(System.in);
		String input;
		input = tas.nextLine();
		tas.close();
		bw.newLine();
		bw.write(input);
		System.out.println("Carte adaugata cu succes!");
		bw.close();
	}
	public static void modificareCarte() throws IOException {
		//UPDATE CARTE,AUTOR(idee: sa fie separat,sa poti sa alegi carte/autor/niciuna/ambele)
		String filePath = "carti.txt";
		Scanner sc = new Scanner(new File(filePath));
		StringBuffer buffer = new StringBuffer();
		while (sc.hasNextLine()) {
			buffer.append(sc.nextLine() + System.lineSeparator());
		}
		sc.close();
		sc = new Scanner(System.in);
		String fileContents = buffer.toString();
		System.out.println("Lista carti:");
		System.out.println(fileContents);
		System.out.println("Ce carte vrei sa modifici?(numecarte,autor)");
		String oldLine = sc.nextLine();
		System.out.println("Cu ce vrei s-o inlocuiesti?(numecarte,autor)");
		String newLine = sc.nextLine();
		fileContents = fileContents.replaceAll(oldLine, newLine);
		FileWriter writer = new FileWriter(filePath);
		writer.append(fileContents);
		writer.close();
	}

	public static void stergereCarte(Carte[] carti, int cartiLength) throws IOException {
		//STERGERE CARTE
		print(carti, cartiLength);
		String filePath = "carti.txt";
		Scanner sc = new Scanner(new File(filePath));
		StringBuffer buffer = new StringBuffer();
		while (sc.hasNextLine()) {
			buffer.append(sc.nextLine()+System.lineSeparator());
		}
		String fileContents = buffer.toString();
		System.out.println("Lista carti:"+fileContents);
		sc.close();
		sc = new Scanner(System.in);
		System.out.println("Ce carte vrei sa stergi?(numecarte,autor)");
		String oldLine = sc.nextLine();
		String newLine = "";
		fileContents = fileContents.replaceAll(oldLine, newLine);
		fileContents = fileContents.replaceAll("(?m)^[ \t]*\r?\n", newLine);
		fileContents = fileContents.trim();
		FileWriter writer = new FileWriter(filePath);
		writer.append(fileContents);
		writer.flush();
		writer.close();
		System.out.println("Carte stearsa cu succes!");
	}

	public static void cautareNume(Cititor[] cititori, int cititoriLength) {
		//CAUTARE DUPA NUME CITITOR
		for(int i=0;i<cititoriLength;i++)
			System.out.println(cititori[i]);
		Scanner sc = new Scanner(System.in);
		System.out.print("Cautare dupa nume cititor: ");
		String numeCautatCit;
		numeCautatCit = sc.nextLine();
		for(int i=0;i<cititoriLength;i++) {
			if(cititori[i].getNume().equals(numeCautatCit))
				System.out.println("CNP-ul cititorului este: " + cititori[i].getCNP());
			/*else {
				System.out.println("Wrong name bitch!!"); //de ce apare asta de X ori dumnezeu cu mila AH SUNT X CARTI proasta sunt
			}*/ //de mentionat ca daca scrii bine tot iti arata eroare pentru restul cartilor
		}
	}

	public static void cautareCNP(Cititor[] cititori, int cititoriLength) {
		//CAUTARE DUPA CNP
		System.out.print("Cautare dupa CNP: ");
		Scanner sc = new Scanner(System.in);
		String CNP = sc.nextLine();
		for(int i=0;i<cititoriLength;i++) {
			if(cititori[i].getCNP().equals(CNP))
				System.out.println("Detinatorul CNP-ului este: " + cititori[i].getNume());
			/*else {
				System.out.println("Wrong CNP bitch!!");
			}*/
		}
	}

	public static void adauagareCititor() throws IOException {
		//ADAUGARE CITITOR
		System.out.println("Ce cititor vrei sa adaugi?(nume,cnp)");
		Scanner sc = new Scanner(System.in);
		String strc = sc.nextLine();
		BufferedWriter bw = new BufferedWriter(new FileWriter("cititori.txt",true));
		bw.newLine();
		bw.write(strc);
		System.out.println("Cititor adaugat cu succes!");
		bw.close();
	}

	public static void stergereCititor(Cititor[] cititori, int cititoriLength) throws IOException {
		//STERGERE CITITOR
		Scanner sc = new Scanner(new File("cititori.txt"));
		print(cititori, cititoriLength);
		StringBuffer bufferc = new StringBuffer();
		while (sc.hasNextLine()) {
			bufferc.append(sc.nextLine()+System.lineSeparator());
		}
		sc.close();
		sc = new Scanner(System.in);
		String fileContents = bufferc.toString();
		System.out.println("Lista cititori: " + fileContents);
		System.out.println("Ce cititor vrei sa stergi?(nume,cnp)");
		String oldLine = sc.nextLine();
		String newLine = "";
		fileContents = fileContents.replaceAll(oldLine, newLine);
		fileContents = fileContents.replaceAll("(?m)^[ \t]*\r?\n", newLine);
		FileWriter writerc = new FileWriter("cititori.txt");
		writerc.append(fileContents);
		writerc.flush();
		writerc.close();
		System.out.println("Cititor sters cu succes!");
	}

	public static void modificareCititor() throws IOException {
		//UPDATE CITITOR,CNP
		String filePath = "cititori.txt";
		Scanner sc = new Scanner(new File(filePath), StandardCharsets.UTF_8);
		StringBuffer bufferC = new StringBuffer();
		while (sc.hasNextLine()) {
			bufferC.append(sc.nextLine()).append(System.lineSeparator());
		}
		String fileContents = bufferC.toString();
		System.out.println("Lista cititori:");
		System.out.println(fileContents);
		sc.close();
		sc = new Scanner(System.in);
		System.out.println("Ce cititor vrei sa modifici?(nume,cnp)");
		String oldLineC = sc.nextLine();
		System.out.print("Cu ce vrei sa-l inlocuiesti?");
		String newLineC = sc.nextLine();
		fileContents = fileContents.replaceAll(oldLineC, newLineC);
		FileWriter writer = new FileWriter(filePath);
		writer.append(fileContents);
		writer.flush();
		writer.close();
	}

	public static int showMenu() {
		int option = 0;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Main Menu:");
		System.out.println("--------------");
		System.out.println("1. Lista carti");
		System.out.println("2. Lista cititori");
		System.out.println("3. Cautare titlu");
		System.out.println("4. Cautare autor");
		System.out.println("5. Adaugare carte");
		System.out.println("6. Modificare carte");
		System.out.println("7. Stergere carte");
		System.out.println("8. Cautare nume");
		System.out.println("9. Cautare CNP");
		System.out.println("10. Adaugare cititor");
		System.out.println("11. Modificare cititor");
		System.out.println("12. Stergere cititor");
		System.out.println("13. Quit");
		System.out.println("--------------");
		System.out.print("Enter your choice: ");
		option = Integer.parseInt(keyboard.nextLine());
		return option;
	}

	public static void main(String[] args) throws IOException {
		Carte[] carti = new Carte[100];
		File file = new File("carti.txt");
        Scanner fin = new Scanner(file);
		String linie;
		int cartiLength = 0;
		while(fin.hasNextLine()) {
			linie = fin.nextLine();
			String[] date = linie.split(",");
			carti[cartiLength] = new Carte();
			carti[cartiLength].setTitlu(date[0]);
			carti[cartiLength].setAutor(date[1]);
			cartiLength++;
		}
		fin.close();

		//basically same thing as for books
		Cititor[] cititori = new Cititor[100];
		file = new File("cititori.txt");
		fin = new Scanner(file);
		int cititoriLength = 0;
		while(fin.hasNextLine()) {
			linie = fin.nextLine();
			String[] date = linie.split(",");
			cititori[cititoriLength] = new Cititor();
			cititori[cititoriLength].setNume(date[0]);
			cititori[cititoriLength].setCNP(date[1]);
			cititoriLength++;
		}
		fin.close();

		int option = 0;
		while (option != 13)
		{
			option = showMenu();
			switch (option) {
				case 1:
					print(carti, cartiLength);
					break;
				case 2:
					print(cititori, cititoriLength);
					break;
				case 3:
					cautareTitlu(carti, cartiLength);
					break;
				case 4:
					cautareAutor(carti, cartiLength);
					break;
				case 5:
					adaugareCarte();
					break;
				case 6:
					modificareCarte();
					break;
				case 7:
					stergereCarte(carti, cartiLength);
					break;
				case 8:
					cautareNume(cititori, cititoriLength);
					break;
				case 9:
					cautareCNP(cititori, cititoriLength);
					break;
				case 10:
					adaugareCititor();
					break;
				case 11:
					modificareCititor();
					break;
				case 12:
					stergereCititor(cititori, cititoriLength);
					break;
				case 13:
					exit(0);
				default:
					System.out.println("Invalid option");
			}
		}
	}
}
