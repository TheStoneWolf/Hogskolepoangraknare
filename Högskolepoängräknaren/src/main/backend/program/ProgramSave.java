package main.backend.program;

import java.util.ArrayList;

public class ProgramSave {

	private static String program;

	private static double qualificationPointsForModernForeignLanguages = 0;
	private static double qualificationPointsForMathematics = 0;

	public static String[] Programs = { "Naturvetenskapsprogrammet", "Samh�llsvetenskapsprogrammet",
			"Ekonomiprogrammet", "Teknikprogrammet", "Estetiska programmet", "Humanistiska programmet",
			"Barn- och fritidsprogrammet", "Bygg- och anl�ggningsprogrammet", "El- och energiprogrammet",
			"Fordons- och transportprogrammet", "Handels- och administrationsprogrammet", "Hantverksprogrammet",
			"Hotell- och turismprogrammet", "Industritekniska programmet", "Naturbruksprogrammet",
			"Restaurang- och livsmedelsprogrammet", "VVS- och fastighetsprogrammet", "V�rd- och omsorgsprogrammet" };

	private static String[] swedishAsASecondLanguageCourses = { "Svenska som Andraspr�k 1", "Svenska som Andraspr�k 2",
			"Svenska som Andraspr�k 3" };

	private static String[] swedishCourses = { "Svenska 1", "Svenska 2", "Svenska 3" };

	private static String[] coursesWithOnly50Points = { "Historia 1a1", "Historia 1a2", "Religionskunskap 1",
			"Religionskunskap 2", "Samh�llskunskap 1a1", "Samh�llskunskap 1a2", "Naturkunskap 1a1", "Naturkunskap 1a2",
			"Psykologi 1", "Filosofi 1", "Konstarterna och samh�llet", "Psykologi 2a", "Bild och form 1a1", "Cad 1",
			"Filosofi 2" };

	private static String[] coursesWith200Points = { "Fordons- och transportbranschens villkor och arbetsomr�den",
			"Fordonsteknik - introduktion", "Hantverk - introduktion", "Naturbruk", "Ensemble med k�rs�ng",
			"Fritids- och friskv�rdsverksamheter", "Pedagogiskt arbete", "Socialt arbete", "Anl�ggningsf�rare 1",
			"Anl�ggningsf�rare 2", "Anl�ggningsf�rare 3", "Anl�ggningsf�rare 4", "Husbyggnad 2",
			"Husbyggnad 3 - ombyggnad", "Husbyggnadsprocessen", "Anl�ggning 2", "Anl�ggningsprocessen", "M�leri 1",
			"M�leriprocessen", "Pl�tslageriprocessen", "Elinstallationer", "Maskinell godshantering",
			"Lageradministration och terminallogistik", "Riktningsteknik - introduktion",
			"Lackeringsteknik - introduktion", "Maskin- och lastbilsteknik - introduktion",
			"Personbilsteknik - introduktion", "Yrkestrafik 1a", "Finsnickeri 1", "Finsnickeri 2", "Florist 1",
			"Florist 2", "Fris�r 1", "Fris�r 2", "Textil design 1", "Textil design 2", "Hantverksteknik 1",
			"Hantverksteknik 2" };

	private static String[] coursesWith300Points = { "Reparation av lastbilar och mobila maskiner",
			"Reparation av personbilar och l�tta transportfordon", "Yrkestrafik 1b" };

	public static void setProgram(String newProgram) {
		program = newProgram;
	}

	public static int getPointsFromCourse(String course) {
		int points = 100;

		for (int i = 0; i < coursesWithOnly50Points.length; i++) {
			if (course == coursesWithOnly50Points[i]) {
				points = 50;
				return points;
			}
		}

		for (int i = 0; i < coursesWith200Points.length; i++) {
			if (course == coursesWith200Points[i]) {
				points = 200;
				return points;
			}
		}
		if (course == "Fysik 1a" || course == "Teknik 1" || course == "Medicin 1"
				|| course == "V�rd och omsorgsarbete 2") {
			points = 150;
			return points;
		}

		for (int i = 0; i < coursesWith300Points.length; i++) {
			if (course == coursesWith300Points[i]) {
				points = 300;
				return points;
			}
		}

		return points;
	}

	public static String[] getCoursesForProgram(boolean hasSwedishAsASecondLanguage, String programSpecialisation,
			String modernForeignLanguagesChoice) {

		boolean programIsHigherEducationPrepatoryProgram = false;

		ArrayList<String> returnArrayList = new ArrayList<String>();
		if (program == "Naturvetenskapsprogrammet" || program == "Ekonomiprogrammet"
				|| program == "Samh�llsvetenskapsprogrammet" || program == "Estetiska programmet"
				|| program == "Humanistiska programmet") {
			programIsHigherEducationPrepatoryProgram = true;
		}

		/*
		 * Foundation Subjects
		 */

		// Math courses
		if (program == "Naturvetenskapsprogrammet" || program == "Teknikprogrammet") {
			returnArrayList.add("Matematik 1c");
			returnArrayList.add("Matematik 2c");
			returnArrayList.add("Matematik 3c");
		} else if (program == "Samh�llsvetenskapsprogrammet" || program == "Ekonomiprogrammet") {
			returnArrayList.add("Matematik 1b");
			returnArrayList.add("Matematik 2b");
		} else if (program == "Estetiska programmet" || program == "Humanistiska programmet") {
			returnArrayList.add("Matematik 1b");
		} else {
			returnArrayList.add("Matematik 1a");
		}

		// Swedish courses
		if (programIsHigherEducationPrepatoryProgram) {
			returnArrayList.addAll(ProgramSave.getSwedishCourses(3, hasSwedishAsASecondLanguage));

		} else if (program == "V�rd- och omsorgsprogrammet" || program == "Barn- och fritidsprogrammet") {
			returnArrayList.addAll(ProgramSave.getSwedishCourses(2, hasSwedishAsASecondLanguage));
		} else {
			returnArrayList.addAll(ProgramSave.getSwedishCourses(1, hasSwedishAsASecondLanguage));
		}

		// English courses
		if (programIsHigherEducationPrepatoryProgram || program == "Hotell- och turismprogrammet") {
			returnArrayList.add("Engelska 5");
			returnArrayList.add("Engelska 6");
		} else {
			returnArrayList.add("Engelska 5");
		}

		// History courses
		if (program == "Naturvetenskapsprogrammet" || program == "Samh�llsvetenskapsprogrammet"
				|| program == "Ekonomiprogrammet") {
			returnArrayList.add("Historia 1b");
		} else if (program == "Humanistiska programmet") {
			returnArrayList.add("Historia 1b");
			returnArrayList.add("Historia 2b - kultur");
		} else {
			returnArrayList.add("Historia 1a1");
		}

		// Theology courses
		returnArrayList.add("Religionskunskap 1");

		// Social science courses
		if (programIsHigherEducationPrepatoryProgram) {
			returnArrayList.add("Samh�llskunskap 1b");
			if (program == "Ekonomiprogrammet") {
				returnArrayList.add("Samh�llskunskap 2");
			}
		} else {
			returnArrayList.add("samh�llskunskap 1a1");
			if (program == "V�rd- och omsorgsprogrammet" || program == "Barn- och fritidsprogrammet") {
				returnArrayList.add("Samh�llskunskap 1a2");
			}
		}

		// Natural science courses
		if (program == "Humanistiska programmet" || program == "Samh�llsvetenskapsprogrammet"
				|| program == "Teknikprogrammet" || program == "Ekonomiprogrammet") {
			returnArrayList.add("Naturkunskap 1b");
		} else {
			returnArrayList.add("Naturkunskap 1a1");
			if (program == "Barn- och fritidsprogrammet") {
				returnArrayList.add("Naturkunskap 1a2");
			}
		}

		// Physical education course
		returnArrayList.add("Idrott och h�lsa 1");

		/*
		 * Other Subjects
		 */

		switch (program) {
		case "Naturvetenskapsprogrammet": // Moderna spr�k
			ProgramSave.setCoursesInArrayList(returnArrayList, "Kemi 1", "Biologi 1", "Fysik 1a");
			if (programSpecialisation == "Naturvetenskap") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Biologi 2", "Fysik 2", "Kemi 2");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Ett naturvetenskapligt �mne", "Geografi 1",
						"Samh�llskunskap 2");
			}
			break;

		case "Ekonomiprogrammet": // Moderna spr�k
			ProgramSave.setCoursesInArrayList(returnArrayList, "F�retagsekonomi 1", "Privatejuridik", "Psykologi 1");
			if (programSpecialisation == "Ekonomi") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Entrepren�rskap och f�retagande",
						"F�retagsekonomi 2", "Matematik 3b");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Filosofi 1", "Aff�rsjuridik",
						"R�tten och samh�llet", "Psykologi 2a");
			}
			break;

		case "Samh�llsvetenskapsprogrammet": // Moderna spr�k 200
			ProgramSave.setCoursesInArrayList(returnArrayList, "Psykologi 1", "Filosofi 1");
			if (programSpecialisation == "Beteendevetenskap") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Ledarskap och organisation", "Kommunikation",
						"Psykologi 2a", "Samh�llskunskap 2", "Sociologi");
			} else if (programSpecialisation == "Medier, information och kommunikation") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Journalistik, reklam och information 1",
						"Medieproduktion", "Medier, samh�lle och kommunikation 1", "Psykologi 2a");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Geografi 1", "Historia 2a", "Religionskunskap 2",
						"Samh�llskunskap 2", "Samh�llskunskap 3");
			}
			break;

		case "Teknikprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Fysik 1a", "Kemi 1", "Teknik 1");
			if (programSpecialisation == "Design och produktutveckling") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Bild och form 1a1", "Cad 1", "Design 1",
						"Konstruktion 1");
			} else if (programSpecialisation == "Informations- och medieteknik") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Dator- och n�tverksteknik", "Programmering 1",
						"Webbutveckling 1");
			} else if (programSpecialisation == "Produktionsteknik") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Mekatronik 1", "Produktionskunskap 1",
						"Produktionsutrustning 1");
			} else if (programSpecialisation == "Samh�llsbyggande och milj�") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Arkitektur - hus", "H�llbart samh�llsbyggande",
						"Byggnadsverk");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Fysik 2", "Matematik 4", "Teknik 2");
			}
			break;

		case "Estetiska programmet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Estetisk kommunikation 1",
					"Konstarterna och samh�llet");
			if (programSpecialisation == "Bild och formgiving") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Bild", "Bild och form 1b", "Form", "Bildteori");
			} else if (programSpecialisation == "Dans") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Dansgestaltning 1", "Dansteknik 1", "Dansteknik 2",
						"Dansteori");
			} else if (programSpecialisation == "Estetik och media") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Digitalt skapande 1", "Medieproduktion 1",
						"Medieproduktion 2", "Medier, samh�lle och kommunikation 1");
			} else if (programSpecialisation == "Musik") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Instrument eller s�ng 1", "Ensemble med k�rs�ng",
						"Geh�rs- och musikl�ra 1");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Scenisk gestaltning 1", "Scenisk gestaltning 2",
						"Scenisk gestaltning 3", "Teaterteori");
			}
			break;
		case "Humanistiska programmet": // Moderna spr�k 200
			ProgramSave.setCoursesInArrayList(returnArrayList, "Filosofi 1", "M�nniskans spr�k 1");
			if (programSpecialisation == "Kultur") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Filosofi 2", "Kultur- och idehistoria",
						"Samtida kulturuttryck", "Psykologi 1", "Litteratur");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Latin - spr�k och kultur 1", "Valfritt spr�k 1",
						"Valfritt spr�k 2", "Valfritt spr�k 3");
			}
			break;

		case "Barn- och fritidsprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "H�lsopedagogik", "Kommunikation",
					"L�rande och utveckling", "M�nniskors milj�er", "Pedagogiskt ledarskap");
			if (programSpecialisation == "Fritid och h�lsa") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Fritids- och friskv�rdsverksamheter",
						"Fritids- och idrottskunskap");
			} else if (programSpecialisation == "Pedagogiskt arbete") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Barns l�rande och v�xande", "Pedagogiskt arbete");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Socialt arbete", "Sociologi");
			}
			break;

		case "Bygg- och anl�ggningsprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Bygg och anl�ggning 1", "Bygg och anl�ggning 2");
			if (programSpecialisation == "Anl�ggningsfordon") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Anl�ggningsf�rare 1", "Anl�ggningsf�rare 2",
						"Anl�ggningsf�rare 3", "Anl�ggningsf�rare 4", "Anl�ggningsf�rare - process");
			} else if (programSpecialisation == "Husbyggnad") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Husbyggnad 1", "Husbyggnad 2",
						"Husbyggnad 3 - ombyggnad", "Husbyggnadsprocessen");
			} else if (programSpecialisation == "Mark och anl�ggning") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Anl�ggning 1", "Anl�ggning 2",
						"Anl�ggningsprocessen");
			} else if (programSpecialisation == "M�leri") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "M�leri 1", "M�leriprocessen");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Pl�tslageri - grunder", "Pl�tslageriprocessen",
						"Ventilationspl�tslageri");
			}
			break;

		case "El- och energiprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Datorteknik 1a", "Elektromekanik", "Energiteknik 1",
					"Mekatronik 1");
			if (programSpecialisation == "Automation") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Praktisk ell�ra", "M�t- och reglerteknik",
						"M�t- och styrteknik", "Programmerbara system");
			} else if (programSpecialisation == "Dator- och kommunikationsteknik") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Dator- och n�tverksteknik",
						"Elektronik och mikrodatorteknik", "Kommunikationsn�t 1", "N�tverksteknik");
			} else if (programSpecialisation == "Elteknik") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Elkraftteknik", "Praktisk ell�ra",
						"Elinstallationer", "Kommunikationsn�t 1");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Avhj�lpande underh�ll 1", "Praktisk ell�ra",
						"Energiteknik 2", "F�rnybar energi");
			}
			break;

		case "Fordons- och transportprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList,
					"Fordons- och transportbranschens vilkor och arbetsomr�den", "Fordonsteknik - introduktion");
			if (programSpecialisation == "Godshantering") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Maskinell godshantering",
						"Lageradministration och terminallogistik");
			} else if (programSpecialisation == "Karosseri och lackering") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Riktningsteknik - introduktion",
						"Lackeringsteknik - introduktion");
			} else if (programSpecialisation == "Lastbil och mobila maskiner") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Maskin- och lastbilsteknik - introduktion",
						"Reparation av lastbilar och mobila maskiner");
			} else if (programSpecialisation == "Personbil") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Personbilsteknik - introduktion",
						"Reparation av personbilar och l�tta transportfordon");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Yrkestrafik 1a", "Yrkestrafik 1b");
			}
			break;

		case "Handels- och administrationsprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Entrepren�rskap", "Servicekunskap",
					"Branschkunskap inom handel och administration", "Information och kommunikation 1");
			if (programSpecialisation == "Administrativ service") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Administration 1", "Aff�rskommunikation",
						"Information och kommunikation", "Intern och extern kommunikation",
						"Ledarskap och organisation");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Personlig f�rs�ljning 1",
						"Aff�rsutveckling och ledarskap", "Praktisk marknadsf�ring 1", "Ink�p 1", "N�thandel 1");
			}
			break;

		case "Hantverksprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Entrepren�rskap", "Hantverk - introduktion",
					"Tradition och utveckling");
			if (programSpecialisation == "Finsnickeri") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Finsnickeri 1", "Finsnickeri 2",
						"Material och milj�");
			} else if (programSpecialisation == "Florist") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Florist 1", "Florist 2", "Material och milj�");
			} else if (programSpecialisation == "Fris�r") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Fris�r 1", "Fris�r 2", "Material och milj�");
			} else if (programSpecialisation == "Textil design") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Textil design 1", "Textil design 2",
						"Material och milj�");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Hantverksteknik 1", "Hantverksteknik 2",
						"Material och milj�");
			}
			break;

		case "Hotell- och turismprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Bes�ksn�ringen", "Entrepren�rskap",
					"Konferens och evenemang", "Logi", "Resm�l och resv�gar", "Service och bem�tande");
			if (programSpecialisation == "Hotell och konferens") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Konferens 1", "Recpetion 1",
						"Frukost och buffeservering", "V�ningsservice 1");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Aktiviteter och upplevelser", "H�llbar turism",
						"Marknadsf�ring och f�rs�ljning", "Reseproduktion och f�rs�ljning");
			}
			break;

		case "Industritekniska programmet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Industritekniska processer 1",
					"M�nniskan i industrin 1", "Produktionskunskap 1", "Produktionsutrustning 1");
			if (programSpecialisation == "Drifts�kerhet och underh�ll") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Avhj�lpande underh�ll 1",
						"Underh�ll - drifts�kerhet", "Underh�ll - elteknik", "Underh�ll - lager och sm�rjteknik");
			} else if (programSpecialisation == "Processteknik") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Industritekniska processer 2",
						"Produktionskunskap 2", "Produktionsutrustning 2", "Produktionsutrustning 3");
			} else if (programSpecialisation == "Produkt och maskinteknik") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Datorstyrd produktion", "Produktionsutrustning 2",
						"Produktutveckling 1");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Produktutveckling 1", "K�lsvets 1", "Svets grund",
						"Tillverkningsunderlag 1");
			}
			break;

		case "Naturbruksprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Entrepren�rskap", "Naturbruk");
			if (programSpecialisation == "Djur") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Djurens biologi", "Djuren i naturbruket",
						"Djurh�llning");
			} else if (programSpecialisation == "Lantbruk") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Marken och v�xternas biologi",
						"Djuren i naturbruket", "Fordon och redskap");
			} else if (programSpecialisation == "Skog") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Marken och v�xternas biologi",
						"Motor- och r�jmotors�g 1", "M�ngbruk av skog");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Marken och v�xternas biologi", "Fordon och redskap",
						"V�xtkunskap 1");
			}
			break;

		case "Restaurang- och livsmedelsprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Hygien", "Livsmedels- och n�ringskunskap 1",
					"Branschkunskap inom restaurang och livsmedel", "Service och bem�tande 1");
			if (programSpecialisation == "Bageri och konditori") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Bageri 1", "Choklad och konfektyr", "Konditori 1");
			} else if (programSpecialisation == "F�rskvaror, delikatess och catering") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Personlig f�rs�ljning 1", "Personlig f�rs�ljning 2",
						"Livsmedels- och n�ringskunskap 2", "Mat och butik 1", "Mat och dryck i kombination",
						"Service och bem�tande 2");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Mat och dryck i kombination", "Matlagning 1",
						"Servering 1");
			}
			break;

		case "VVS- och fastighetsprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Praktisk ell�ra", "Systemuppbygnad", "V�rmel�ra",
					"Verktyg- och materialhantering");
			if (programSpecialisation == "Fastighet") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Elkraftteknik", "Fastighetsf�rvaltning",
						"Fastighetsservice - byggnader");
			} else if (programSpecialisation == "Kyl- och v�rmepumpsteknik") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Elkraftteknik", "Kyl- och v�rmepumpsteknik - grund",
						"Kyl- och v�rmepumpsteknik - milj� och s�kerhet");
			} else if (programSpecialisation == "VVS") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Entreprenadteknik", "Sanitetsteknik 1",
						"VVS svets och l�dning r�r", "V�rmeteknik 1");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Elkraftteknik", "Luftbehandling",
						"Ventilationsteknik - injustering");
			}
			break;

		case "V�rd- och omsorgsprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "H�lsopedagogik", "Medicin 1",
					"Etik och m�nniskans livsvilkor", "Psykiatri 1", "Psykologi 1", "Specialpedagogik 1",
					"V�rd och omsorgsarbete 1", "V�rd och omsorgsarbete 2");
			break;
		}

		String[] returnArray = new String[returnArrayList.size()];
		returnArray = returnArrayList.toArray(returnArray);

		return returnArray;
	}

	private static void setCoursesInArrayList(ArrayList<String> arrayList, String... courses) {

		boolean isAnotherCourseOfSameSubjectInArrayList = false;
		for (int i = 0; i < courses.length; i++) {
			for (int j = 0; j < arrayList.size(); j++) {
				if (ProgramSave.getFirstWordFromSentence(arrayList.get(j))
						.equals(ProgramSave.getFirstWordFromSentence(courses[i]))) {
					arrayList.add(ProgramSave.getIndexOfOtherSubjectsInArrayList(arrayList, courses[i]), courses[i]);
					isAnotherCourseOfSameSubjectInArrayList = true;
					break;
				}
			}
			if (!isAnotherCourseOfSameSubjectInArrayList)
				arrayList.add(courses[i]);
			isAnotherCourseOfSameSubjectInArrayList = false;
		}
	}

	private static int getIndexOfOtherSubjectsInArrayList(ArrayList<String> arrayList, String course) {

		int index = 0;

		String subject = ProgramSave.getFirstWordFromSentence(course);

		// Finds the index of the subject
		for (int i = 0; i < arrayList.size(); i++) {

			String subjectInFocusInArrayList = ProgramSave.getFirstWordFromSentence((String) arrayList.get(i));

			// If the subject in focus is the last one in the array, don't
			// calculate the next (non-existing) one
			String nextSubjectInArrayList = !(i + 1 == arrayList.size())
					? ProgramSave.getFirstWordFromSentence((String) arrayList.get(i + 1)) : "Last subject in array";

			if (subject.equals(subjectInFocusInArrayList) && !(subject.equals(nextSubjectInArrayList))) {
				index = i + 1;
				return index;
			}

		}

		return index;
	}

	private static String getFirstWordFromSentence(String sentence) {
		char[] wordInChars = new char[sentence.length()];
		int i = 0;

		do {
			wordInChars[i] = sentence.charAt(i);
			i++;
			
			

		} while ( i < sentence.length() && wordInChars[i - 1] != ' ');
		String wordWithTrailingWhiteSpaces = String.valueOf(wordInChars);
		String word = wordWithTrailingWhiteSpaces.trim();

		return word;
	}

	private static ArrayList<String> getSwedishCourses(int coursesToTake, boolean hasSwedishAsASecondLanguage) {

		ArrayList<String> swedishCoursesToTake = new ArrayList<>();

		if (hasSwedishAsASecondLanguage) {
			for (int i = 0; i < coursesToTake; i++) {
				swedishCoursesToTake.add(swedishAsASecondLanguageCourses[i]);
			}
		} else {
			for (int i = 0; i < coursesToTake; i++) {
				swedishCoursesToTake.add(swedishCourses[i]);
			}
		}

		return swedishCoursesToTake;
	}

	public static String[] getSpecialisationsForProgram(String program) {

		ArrayList<String> specialisationsForProgramArrayList = new ArrayList<>();

		switch (program) {
		case "Naturvetenskapsprogrammet":
			specialisationsForProgramArrayList.add("Naturvetenskap");
			specialisationsForProgramArrayList.add("Naturvetenskap och samh�lle");
			break;
		case "Samh�llsvetenskapsprogrammet":
			specialisationsForProgramArrayList.add("Beteendevetenskap");
			specialisationsForProgramArrayList.add("Medier, information och kommunikation");
			specialisationsForProgramArrayList.add("Samh�llsvetenskap");
			break;
		case "Ekonomiprogrammet":
			specialisationsForProgramArrayList.add("Ekonomi");
			specialisationsForProgramArrayList.add("Juridik");
			break;
		case "Teknikprogrammet":
			specialisationsForProgramArrayList.add("Design och produktutveckling");
			specialisationsForProgramArrayList.add("Informations- och medieteknik");
			specialisationsForProgramArrayList.add("Produktionsteknik");
			specialisationsForProgramArrayList.add("Samh�llsbyggande och milj�");
			specialisationsForProgramArrayList.add("Teknikvetenskap");
			break;
		case "Estetiska programmet":
			specialisationsForProgramArrayList.add("Bild och formgivning");
			specialisationsForProgramArrayList.add("Dans");
			specialisationsForProgramArrayList.add("Estetik och media");
			specialisationsForProgramArrayList.add("Musik");
			specialisationsForProgramArrayList.add("Teater");
			break;
		case "Humanistiska programmet":
			specialisationsForProgramArrayList.add("Kultur");
			specialisationsForProgramArrayList.add("Spr�k");
			break;
		case "Barn- och fritidsprogrammet":
			specialisationsForProgramArrayList.add("Fritid och h�lsa");
			specialisationsForProgramArrayList.add("Pedagogiskt arbete");
			specialisationsForProgramArrayList.add("Socialt arbete");
			break;
		case "Bygg- och anl�ggningsprogrammet":
			specialisationsForProgramArrayList.add("Anl�ggningsfordon");
			specialisationsForProgramArrayList.add("Husbyggnad");
			specialisationsForProgramArrayList.add("Mark och anl�ggning");
			specialisationsForProgramArrayList.add("M�leri");
			specialisationsForProgramArrayList.add("Pl�tslageri");
			break;
		case "El- och energiprogrammet":
			specialisationsForProgramArrayList.add("Automation");
			specialisationsForProgramArrayList.add("Dator- och kommunikationsteknik");
			specialisationsForProgramArrayList.add("Elteknik");
			specialisationsForProgramArrayList.add("Energiteknik");
			break;
		case "Fordons- och transportprogrammet":
			specialisationsForProgramArrayList.add("Godshantering");
			specialisationsForProgramArrayList.add("Karosseri och lackering");
			specialisationsForProgramArrayList.add("Lastbil och mobila maskiner");
			specialisationsForProgramArrayList.add("Personbil");
			specialisationsForProgramArrayList.add("Transport");
			break;
		case "Handels- och administrationsprogrammet":
			specialisationsForProgramArrayList.add("Administrativ service");
			specialisationsForProgramArrayList.add("Handel och service");
			break;
		case "Hantverksprogrammet":
			specialisationsForProgramArrayList.add("Finsnickeri");
			specialisationsForProgramArrayList.add("Florist");
			specialisationsForProgramArrayList.add("Fris�r");
			specialisationsForProgramArrayList.add("Textil design");
			specialisationsForProgramArrayList.add("�vriga hantverk");
			break;
		case "Hotell- och turismprogrammet":
			specialisationsForProgramArrayList.add("Hotell och konferens");
			specialisationsForProgramArrayList.add("Turism och resor");
			break;
		case "Industritekniska programmet":
			specialisationsForProgramArrayList.add("Drifts�kerhet och underh�ll");
			specialisationsForProgramArrayList.add("Processteknik");
			specialisationsForProgramArrayList.add("Produkt och maskinteknik");
			specialisationsForProgramArrayList.add("Svetsteknik");
			break;
		case "Naturbruksprogrammet":
			specialisationsForProgramArrayList.add("Djur");
			specialisationsForProgramArrayList.add("Lantbruk");
			specialisationsForProgramArrayList.add("Skog");
			specialisationsForProgramArrayList.add("Tr�dg�rd");
			break;
		case "Restaurang- och livsmedelsprogrammet":
			specialisationsForProgramArrayList.add("Bageri och konditori");
			specialisationsForProgramArrayList.add("F�rskvaror, delikatess och catering");
			specialisationsForProgramArrayList.add("K�k och servering");
			break;
		case "VVS- och fastighetsprogrammet":
			specialisationsForProgramArrayList.add("Fastighet");
			specialisationsForProgramArrayList.add("Kyl- och v�rmepumpsteknik");
			specialisationsForProgramArrayList.add("Ventilationsteknik");
			specialisationsForProgramArrayList.add("VVS");
			break;
		case "V�rd- och omsorgsprogrammet":
			specialisationsForProgramArrayList.add("Inga inriktningar");
			break;
		}

		String[] specialisationsForProgramArray = new String[specialisationsForProgramArrayList.size()];
		specialisationsForProgramArray = specialisationsForProgramArrayList.toArray(specialisationsForProgramArray);

		return specialisationsForProgramArray;
	}

	public static double getQualificationPointsForCourse(String course) {

		double qualificationPoints = 0.0;

		switch (course) {
		case "Moderna spr�k 4":
			qualificationPoints = 1.0;
			return qualificationPoints;
		case "Moderna spr�k 5":
			if (qualificationPointsForModernForeignLanguages < 1.5)
				qualificationPoints = 0.5;
			return qualificationPoints;
		case "Engelska 7":
			qualificationPoints = 1.0;
			return qualificationPoints;
		}

		// Gives qualification points only to mathematics courses 3 and above
		if (course.length() > 9) {
			if ((course.substring(0, 9)).equals("Matematik")) {
				qualificationPoints = 0.5;
				if (course.charAt(10) == '1' || course.charAt(10) == '2') {
					qualificationPoints = 0.0;
				}
			}
		}

		return qualificationPoints;
	}

	private static String getModernForeignLanguages(String modernForeignLanguagesChoice, int courseNumber) {

		String modernForeignLanguageCourse = new String();

		switch (modernForeignLanguagesChoice) {
		case "Moderna spr�k (b�rjar i kurs 4)":
			modernForeignLanguageCourse = "Moderna spr�k " + (courseNumber + 4);
			break;
		case "Modersm�l":
			modernForeignLanguageCourse = "Modersm�l " + (courseNumber + 1);
			break;
		case "Moderna spr�k (b�rjar i kurs 1":
			modernForeignLanguageCourse = "Moderna spr�k " + (courseNumber + 1);
			break;
		case "Kinesiska (b�rjar i kurs 4)":
			modernForeignLanguageCourse = "Kinesiska " + (courseNumber + 4);
			break;
		case "Kinesiska (b�rjar i kurs 1)":
			modernForeignLanguageCourse = "Kinesiska " + (courseNumber + 1);
			break;
		case "Svenskt teckenspr�k":
			modernForeignLanguageCourse = "Svenskt teckenspr�k " + (courseNumber + 1);
			break;
		}

		return modernForeignLanguageCourse;

	}

}
