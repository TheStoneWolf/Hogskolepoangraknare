package main.backend.program;

import java.util.ArrayList;

public class ProgramSave {

	private static String program;

	private static double qualificationPointsForModernForeignLanguages = 0;
	private static double qualificationPointsForMathematics = 0;

	public static String[] Programs = { "Naturvetenskapsprogrammet", "Samhällsvetenskapsprogrammet",
			"Ekonomiprogrammet", "Teknikprogrammet", "Estetiska programmet", "Humanistiska programmet",
			"Barn- och fritidsprogrammet", "Bygg- och anläggningsprogrammet", "El- och energiprogrammet",
			"Fordons- och transportprogrammet", "Handels- och administrationsprogrammet", "Hantverksprogrammet",
			"Hotell- och turismprogrammet", "Industritekniska programmet", "Naturbruksprogrammet",
			"Restaurang- och livsmedelsprogrammet", "VVS- och fastighetsprogrammet", "Vård- och omsorgsprogrammet" };

	private static String[] swedishAsASecondLanguageCourses = { "Svenska som Andraspråk 1", "Svenska som Andraspråk 2",
			"Svenska som Andraspråk 3" };

	private static String[] swedishCourses = { "Svenska 1", "Svenska 2", "Svenska 3" };

	private static String[] coursesWithOnly50Points = { "Historia 1a1", "Historia 1a2", "Religionskunskap 1",
			"Religionskunskap 2", "Samhällskunskap 1a1", "Samhällskunskap 1a2", "Naturkunskap 1a1", "Naturkunskap 1a2",
			"Psykologi 1", "Filosofi 1", "Konstarterna och samhället", "Psykologi 2a", "Bild och form 1a1", "Cad 1",
			"Filosofi 2" };

	private static String[] coursesWith200Points = { "Fordons- och transportbranschens villkor och arbetsområden",
			"Fordonsteknik - introduktion", "Hantverk - introduktion", "Naturbruk", "Ensemble med körsång",
			"Fritids- och friskvårdsverksamheter", "Pedagogiskt arbete", "Socialt arbete", "Anläggningsförare 1",
			"Anläggningsförare 2", "Anläggningsförare 3", "Anläggningsförare 4", "Husbyggnad 2",
			"Husbyggnad 3 - ombyggnad", "Husbyggnadsprocessen", "Anläggning 2", "Anläggningsprocessen", "Måleri 1",
			"Måleriprocessen", "Plåtslageriprocessen", "Elinstallationer", "Maskinell godshantering",
			"Lageradministration och terminallogistik", "Riktningsteknik - introduktion",
			"Lackeringsteknik - introduktion", "Maskin- och lastbilsteknik - introduktion",
			"Personbilsteknik - introduktion", "Yrkestrafik 1a", "Finsnickeri 1", "Finsnickeri 2", "Florist 1",
			"Florist 2", "Frisör 1", "Frisör 2", "Textil design 1", "Textil design 2", "Hantverksteknik 1",
			"Hantverksteknik 2" };

	private static String[] coursesWith300Points = { "Reparation av lastbilar och mobila maskiner",
			"Reparation av personbilar och lätta transportfordon", "Yrkestrafik 1b" };

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
				|| course == "Vård och omsorgsarbete 2") {
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
				|| program == "Samhällsvetenskapsprogrammet" || program == "Estetiska programmet"
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
		} else if (program == "Samhällsvetenskapsprogrammet" || program == "Ekonomiprogrammet") {
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

		} else if (program == "Vård- och omsorgsprogrammet" || program == "Barn- och fritidsprogrammet") {
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
		if (program == "Naturvetenskapsprogrammet" || program == "Samhällsvetenskapsprogrammet"
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
			returnArrayList.add("Samhällskunskap 1b");
			if (program == "Ekonomiprogrammet") {
				returnArrayList.add("Samhällskunskap 2");
			}
		} else {
			returnArrayList.add("samhällskunskap 1a1");
			if (program == "Vård- och omsorgsprogrammet" || program == "Barn- och fritidsprogrammet") {
				returnArrayList.add("Samhällskunskap 1a2");
			}
		}

		// Natural science courses
		if (program == "Humanistiska programmet" || program == "Samhällsvetenskapsprogrammet"
				|| program == "Teknikprogrammet" || program == "Ekonomiprogrammet") {
			returnArrayList.add("Naturkunskap 1b");
		} else {
			returnArrayList.add("Naturkunskap 1a1");
			if (program == "Barn- och fritidsprogrammet") {
				returnArrayList.add("Naturkunskap 1a2");
			}
		}

		// Physical education course
		returnArrayList.add("Idrott och hälsa 1");

		/*
		 * Other Subjects
		 */

		switch (program) {
		case "Naturvetenskapsprogrammet": // Moderna språk
			ProgramSave.setCoursesInArrayList(returnArrayList, "Kemi 1", "Biologi 1", "Fysik 1a");
			if (programSpecialisation == "Naturvetenskap") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Biologi 2", "Fysik 2", "Kemi 2");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Ett naturvetenskapligt ämne", "Geografi 1",
						"Samhällskunskap 2");
			}
			break;

		case "Ekonomiprogrammet": // Moderna språk
			ProgramSave.setCoursesInArrayList(returnArrayList, "Företagsekonomi 1", "Privatejuridik", "Psykologi 1");
			if (programSpecialisation == "Ekonomi") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Entreprenörskap och företagande",
						"Företagsekonomi 2", "Matematik 3b");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Filosofi 1", "Affärsjuridik",
						"Rätten och samhället", "Psykologi 2a");
			}
			break;

		case "Samhällsvetenskapsprogrammet": // Moderna språk 200
			ProgramSave.setCoursesInArrayList(returnArrayList, "Psykologi 1", "Filosofi 1");
			if (programSpecialisation == "Beteendevetenskap") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Ledarskap och organisation", "Kommunikation",
						"Psykologi 2a", "Samhällskunskap 2", "Sociologi");
			} else if (programSpecialisation == "Medier, information och kommunikation") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Journalistik, reklam och information 1",
						"Medieproduktion", "Medier, samhälle och kommunikation 1", "Psykologi 2a");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Geografi 1", "Historia 2a", "Religionskunskap 2",
						"Samhällskunskap 2", "Samhällskunskap 3");
			}
			break;

		case "Teknikprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Fysik 1a", "Kemi 1", "Teknik 1");
			if (programSpecialisation == "Design och produktutveckling") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Bild och form 1a1", "Cad 1", "Design 1",
						"Konstruktion 1");
			} else if (programSpecialisation == "Informations- och medieteknik") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Dator- och nätverksteknik", "Programmering 1",
						"Webbutveckling 1");
			} else if (programSpecialisation == "Produktionsteknik") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Mekatronik 1", "Produktionskunskap 1",
						"Produktionsutrustning 1");
			} else if (programSpecialisation == "Samhällsbyggande och miljö") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Arkitektur - hus", "Hållbart samhällsbyggande",
						"Byggnadsverk");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Fysik 2", "Matematik 4", "Teknik 2");
			}
			break;

		case "Estetiska programmet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Estetisk kommunikation 1",
					"Konstarterna och samhället");
			if (programSpecialisation == "Bild och formgiving") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Bild", "Bild och form 1b", "Form", "Bildteori");
			} else if (programSpecialisation == "Dans") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Dansgestaltning 1", "Dansteknik 1", "Dansteknik 2",
						"Dansteori");
			} else if (programSpecialisation == "Estetik och media") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Digitalt skapande 1", "Medieproduktion 1",
						"Medieproduktion 2", "Medier, samhälle och kommunikation 1");
			} else if (programSpecialisation == "Musik") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Instrument eller sång 1", "Ensemble med körsång",
						"Gehörs- och musiklära 1");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Scenisk gestaltning 1", "Scenisk gestaltning 2",
						"Scenisk gestaltning 3", "Teaterteori");
			}
			break;
		case "Humanistiska programmet": // Moderna språk 200
			ProgramSave.setCoursesInArrayList(returnArrayList, "Filosofi 1", "Människans språk 1");
			if (programSpecialisation == "Kultur") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Filosofi 2", "Kultur- och idehistoria",
						"Samtida kulturuttryck", "Psykologi 1", "Litteratur");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Latin - språk och kultur 1", "Valfritt språk 1",
						"Valfritt språk 2", "Valfritt språk 3");
			}
			break;

		case "Barn- och fritidsprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Hälsopedagogik", "Kommunikation",
					"Lärande och utveckling", "Människors miljöer", "Pedagogiskt ledarskap");
			if (programSpecialisation == "Fritid och hälsa") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Fritids- och friskvårdsverksamheter",
						"Fritids- och idrottskunskap");
			} else if (programSpecialisation == "Pedagogiskt arbete") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Barns lärande och växande", "Pedagogiskt arbete");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Socialt arbete", "Sociologi");
			}
			break;

		case "Bygg- och anläggningsprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Bygg och anläggning 1", "Bygg och anläggning 2");
			if (programSpecialisation == "Anläggningsfordon") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Anläggningsförare 1", "Anläggningsförare 2",
						"Anläggningsförare 3", "Anläggningsförare 4", "Anläggningsförare - process");
			} else if (programSpecialisation == "Husbyggnad") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Husbyggnad 1", "Husbyggnad 2",
						"Husbyggnad 3 - ombyggnad", "Husbyggnadsprocessen");
			} else if (programSpecialisation == "Mark och anläggning") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Anläggning 1", "Anläggning 2",
						"Anläggningsprocessen");
			} else if (programSpecialisation == "Måleri") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Måleri 1", "Måleriprocessen");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Plåtslageri - grunder", "Plåtslageriprocessen",
						"Ventilationsplåtslageri");
			}
			break;

		case "El- och energiprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Datorteknik 1a", "Elektromekanik", "Energiteknik 1",
					"Mekatronik 1");
			if (programSpecialisation == "Automation") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Praktisk ellära", "Mät- och reglerteknik",
						"Mät- och styrteknik", "Programmerbara system");
			} else if (programSpecialisation == "Dator- och kommunikationsteknik") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Dator- och nätverksteknik",
						"Elektronik och mikrodatorteknik", "Kommunikationsnät 1", "Nätverksteknik");
			} else if (programSpecialisation == "Elteknik") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Elkraftteknik", "Praktisk ellära",
						"Elinstallationer", "Kommunikationsnät 1");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Avhjälpande underhåll 1", "Praktisk ellära",
						"Energiteknik 2", "Förnybar energi");
			}
			break;

		case "Fordons- och transportprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList,
					"Fordons- och transportbranschens vilkor och arbetsområden", "Fordonsteknik - introduktion");
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
						"Reparation av personbilar och lätta transportfordon");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Yrkestrafik 1a", "Yrkestrafik 1b");
			}
			break;

		case "Handels- och administrationsprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Entreprenörskap", "Servicekunskap",
					"Branschkunskap inom handel och administration", "Information och kommunikation 1");
			if (programSpecialisation == "Administrativ service") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Administration 1", "Affärskommunikation",
						"Information och kommunikation", "Intern och extern kommunikation",
						"Ledarskap och organisation");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Personlig försäljning 1",
						"Affärsutveckling och ledarskap", "Praktisk marknadsföring 1", "Inköp 1", "Näthandel 1");
			}
			break;

		case "Hantverksprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Entreprenörskap", "Hantverk - introduktion",
					"Tradition och utveckling");
			if (programSpecialisation == "Finsnickeri") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Finsnickeri 1", "Finsnickeri 2",
						"Material och miljö");
			} else if (programSpecialisation == "Florist") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Florist 1", "Florist 2", "Material och miljö");
			} else if (programSpecialisation == "Frisör") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Frisör 1", "Frisör 2", "Material och miljö");
			} else if (programSpecialisation == "Textil design") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Textil design 1", "Textil design 2",
						"Material och miljö");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Hantverksteknik 1", "Hantverksteknik 2",
						"Material och miljö");
			}
			break;

		case "Hotell- och turismprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Besöksnäringen", "Entreprenörskap",
					"Konferens och evenemang", "Logi", "Resmål och resvägar", "Service och bemötande");
			if (programSpecialisation == "Hotell och konferens") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Konferens 1", "Recpetion 1",
						"Frukost och buffeservering", "Våningsservice 1");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Aktiviteter och upplevelser", "Hållbar turism",
						"Marknadsföring och försäljning", "Reseproduktion och försäljning");
			}
			break;

		case "Industritekniska programmet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Industritekniska processer 1",
					"Människan i industrin 1", "Produktionskunskap 1", "Produktionsutrustning 1");
			if (programSpecialisation == "Driftsäkerhet och underhåll") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Avhjälpande underhåll 1",
						"Underhåll - driftsäkerhet", "Underhåll - elteknik", "Underhåll - lager och smörjteknik");
			} else if (programSpecialisation == "Processteknik") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Industritekniska processer 2",
						"Produktionskunskap 2", "Produktionsutrustning 2", "Produktionsutrustning 3");
			} else if (programSpecialisation == "Produkt och maskinteknik") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Datorstyrd produktion", "Produktionsutrustning 2",
						"Produktutveckling 1");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Produktutveckling 1", "Kälsvets 1", "Svets grund",
						"Tillverkningsunderlag 1");
			}
			break;

		case "Naturbruksprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Entreprenörskap", "Naturbruk");
			if (programSpecialisation == "Djur") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Djurens biologi", "Djuren i naturbruket",
						"Djurhållning");
			} else if (programSpecialisation == "Lantbruk") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Marken och växternas biologi",
						"Djuren i naturbruket", "Fordon och redskap");
			} else if (programSpecialisation == "Skog") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Marken och växternas biologi",
						"Motor- och röjmotorsåg 1", "Mångbruk av skog");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Marken och växternas biologi", "Fordon och redskap",
						"Växtkunskap 1");
			}
			break;

		case "Restaurang- och livsmedelsprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Hygien", "Livsmedels- och näringskunskap 1",
					"Branschkunskap inom restaurang och livsmedel", "Service och bemötande 1");
			if (programSpecialisation == "Bageri och konditori") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Bageri 1", "Choklad och konfektyr", "Konditori 1");
			} else if (programSpecialisation == "Färskvaror, delikatess och catering") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Personlig försäljning 1", "Personlig försäljning 2",
						"Livsmedels- och näringskunskap 2", "Mat och butik 1", "Mat och dryck i kombination",
						"Service och bemötande 2");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Mat och dryck i kombination", "Matlagning 1",
						"Servering 1");
			}
			break;

		case "VVS- och fastighetsprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Praktisk ellära", "Systemuppbygnad", "Värmelära",
					"Verktyg- och materialhantering");
			if (programSpecialisation == "Fastighet") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Elkraftteknik", "Fastighetsförvaltning",
						"Fastighetsservice - byggnader");
			} else if (programSpecialisation == "Kyl- och värmepumpsteknik") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Elkraftteknik", "Kyl- och värmepumpsteknik - grund",
						"Kyl- och värmepumpsteknik - miljö och säkerhet");
			} else if (programSpecialisation == "VVS") {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Entreprenadteknik", "Sanitetsteknik 1",
						"VVS svets och lödning rör", "Värmeteknik 1");
			} else {
				ProgramSave.setCoursesInArrayList(returnArrayList, "Elkraftteknik", "Luftbehandling",
						"Ventilationsteknik - injustering");
			}
			break;

		case "Vård- och omsorgsprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Hälsopedagogik", "Medicin 1",
					"Etik och människans livsvilkor", "Psykiatri 1", "Psykologi 1", "Specialpedagogik 1",
					"Vård och omsorgsarbete 1", "Vård och omsorgsarbete 2");
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
			specialisationsForProgramArrayList.add("Naturvetenskap och samhälle");
			break;
		case "Samhällsvetenskapsprogrammet":
			specialisationsForProgramArrayList.add("Beteendevetenskap");
			specialisationsForProgramArrayList.add("Medier, information och kommunikation");
			specialisationsForProgramArrayList.add("Samhällsvetenskap");
			break;
		case "Ekonomiprogrammet":
			specialisationsForProgramArrayList.add("Ekonomi");
			specialisationsForProgramArrayList.add("Juridik");
			break;
		case "Teknikprogrammet":
			specialisationsForProgramArrayList.add("Design och produktutveckling");
			specialisationsForProgramArrayList.add("Informations- och medieteknik");
			specialisationsForProgramArrayList.add("Produktionsteknik");
			specialisationsForProgramArrayList.add("Samhällsbyggande och miljö");
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
			specialisationsForProgramArrayList.add("Språk");
			break;
		case "Barn- och fritidsprogrammet":
			specialisationsForProgramArrayList.add("Fritid och hälsa");
			specialisationsForProgramArrayList.add("Pedagogiskt arbete");
			specialisationsForProgramArrayList.add("Socialt arbete");
			break;
		case "Bygg- och anläggningsprogrammet":
			specialisationsForProgramArrayList.add("Anläggningsfordon");
			specialisationsForProgramArrayList.add("Husbyggnad");
			specialisationsForProgramArrayList.add("Mark och anläggning");
			specialisationsForProgramArrayList.add("Måleri");
			specialisationsForProgramArrayList.add("Plåtslageri");
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
			specialisationsForProgramArrayList.add("Frisör");
			specialisationsForProgramArrayList.add("Textil design");
			specialisationsForProgramArrayList.add("Övriga hantverk");
			break;
		case "Hotell- och turismprogrammet":
			specialisationsForProgramArrayList.add("Hotell och konferens");
			specialisationsForProgramArrayList.add("Turism och resor");
			break;
		case "Industritekniska programmet":
			specialisationsForProgramArrayList.add("Driftsäkerhet och underhåll");
			specialisationsForProgramArrayList.add("Processteknik");
			specialisationsForProgramArrayList.add("Produkt och maskinteknik");
			specialisationsForProgramArrayList.add("Svetsteknik");
			break;
		case "Naturbruksprogrammet":
			specialisationsForProgramArrayList.add("Djur");
			specialisationsForProgramArrayList.add("Lantbruk");
			specialisationsForProgramArrayList.add("Skog");
			specialisationsForProgramArrayList.add("Trädgård");
			break;
		case "Restaurang- och livsmedelsprogrammet":
			specialisationsForProgramArrayList.add("Bageri och konditori");
			specialisationsForProgramArrayList.add("Färskvaror, delikatess och catering");
			specialisationsForProgramArrayList.add("Kök och servering");
			break;
		case "VVS- och fastighetsprogrammet":
			specialisationsForProgramArrayList.add("Fastighet");
			specialisationsForProgramArrayList.add("Kyl- och värmepumpsteknik");
			specialisationsForProgramArrayList.add("Ventilationsteknik");
			specialisationsForProgramArrayList.add("VVS");
			break;
		case "Vård- och omsorgsprogrammet":
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
		case "Moderna språk 4":
			qualificationPoints = 1.0;
			return qualificationPoints;
		case "Moderna språk 5":
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
		case "Moderna språk (börjar i kurs 4)":
			modernForeignLanguageCourse = "Moderna språk " + (courseNumber + 4);
			break;
		case "Modersmål":
			modernForeignLanguageCourse = "Modersmål " + (courseNumber + 1);
			break;
		case "Moderna språk (börjar i kurs 1":
			modernForeignLanguageCourse = "Moderna språk " + (courseNumber + 1);
			break;
		case "Kinesiska (börjar i kurs 4)":
			modernForeignLanguageCourse = "Kinesiska " + (courseNumber + 4);
			break;
		case "Kinesiska (börjar i kurs 1)":
			modernForeignLanguageCourse = "Kinesiska " + (courseNumber + 1);
			break;
		case "Svenskt teckenspråk":
			modernForeignLanguageCourse = "Svenskt teckenspråk " + (courseNumber + 1);
			break;
		}

		return modernForeignLanguageCourse;

	}

}
