package main.backend.program;

import java.util.ArrayList;

public class ProgramSave {

	private static String program;

	private static double qualificationPointsForModernForeignLanguages = 0;
	private static double qualificationPointsForMathematics = 0;

	public static String[] Programs = { "Naturvetenskapsprogrammet", "Samh�llsvetenskapsprogrammet",
			"Ekonomiprogrammet", "Teknikprogrammet", "Estetiska programmet", "Humanistiska programmet",
			"Barn- och fritidsprogrammet", "Bygg- och anl�ggningsprogrammet", "El- och energiprogrammet",
			"Fordons- och transportprogrammet", "Handel- och administrationsprogrammet", "Hantverksprogrammet",
			"Hotell- och turismprogrammet", "Industritekniska programmet", "Naturbruksprogrammet",
			"Resturang- och livsmedelsprogrammet", "VVS- och fastighetsprogrammet", "V�rd- och omsorgsprogrammet" };

	private static String[] coursesNatureCommon = { "Engelska 5", "Engelska 6", "Historia 1c", "Idrott och H�lsa 1",
			"Matematik 1c", "Matematik 2c", "Matematik 3c", "Religionskunskap 1", "Samh�llskunskap 1b", "Biologi 1",
			"Fysik 1a", "Kemi 1" };

	private static String[] courseNatureNatureScience = { "Biologi 2", "Fysik 2", "Kemi 2", "Matematik 4" };

	private static String[] courseNatureNatureScienceAndSociety = { "Ett Naturvetenskapligt �mne", "Geografi 1",
			"Samh�llskunskap 2" };

	private static String[] swedishAsASecondLanguageCourses = { "Svenska som Andraspr�k 1", "Svenska som Andraspr�k 2",
			"Svenska som Andraspr�k 3" };

	private static String[] normalSwedishCourses = { "Svenska 1", "Svenska 2", "Svenska 3" };

	public static void setProgram(String newProgram) {
		program = newProgram;
	}

	public static String[] getCoursesForProgram(boolean hasSwedishAsASecondLanguage, String programSpecialisation,
			String modernForeignLanguagesChoice) {

		ArrayList<String> returnArrayList = new ArrayList<String>();

		switch (program) {
		case "Naturvetenskapsprogrammet":
			for (String course : coursesNatureCommon)
				returnArrayList.add(course);
			if (programSpecialisation == "Naturvetenskap") {
				for (String specialisationCourse : courseNatureNatureScience)
					returnArrayList.add(specialisationCourse);
			} else {
				for (String specialisationCourse : courseNatureNatureScienceAndSociety)
					returnArrayList.add(specialisationCourse);
			}
			break;
		}

		if (hasSwedishAsASecondLanguage) {
			for (String course : swedishAsASecondLanguageCourses)
				returnArrayList.add(course);
		} else {
			for (String course : normalSwedishCourses)
				returnArrayList.add(course);
		}

		if (program == "Ekonomiprogrammet" || program == "Naturvetenskapsprogrammet"
				|| program == "Humanistiska programmet" || program == "Samh�llsvetenskapsprogrammet") {
			returnArrayList.add(ProgramSave.getModernForeignLanguages(modernForeignLanguagesChoice, 0));
		}
		if (program == "Humanistiska programmet" || program == "Samh�llsvetenskapsprogrammet") {
			returnArrayList.add(ProgramSave.getModernForeignLanguages(modernForeignLanguagesChoice, 1));
		}

		String[] returnArray = new String[returnArrayList.size()];
		returnArray = returnArrayList.toArray(returnArray);

		return returnArray;
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
			specialisationsForProgramArrayList.add("Medier, Information och Kommunikation");
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
			specialisationsForProgramArrayList.add("Samh�llsbyggande och Milj�");
			specialisationsForProgramArrayList.add("Teknikvetenskap");
			break;
		case "Estetiska programmet":
			specialisationsForProgramArrayList.add("Bild och Formgivning");
			specialisationsForProgramArrayList.add("Dans");
			specialisationsForProgramArrayList.add("Estetik och Media");
			specialisationsForProgramArrayList.add("Musik");
			specialisationsForProgramArrayList.add("Teater");
			break;
		case "Humanistiska programmet":
			specialisationsForProgramArrayList.add("Kultur");
			specialisationsForProgramArrayList.add("Spr�k");
			break;
		case "Barn- och fritidsprogrammet":
			specialisationsForProgramArrayList.add("Fritid och H�lsa");
			specialisationsForProgramArrayList.add("Pedagogiskt Arbete");
			specialisationsForProgramArrayList.add("Socialt Arbete");
			break;
		case "Bygg- och anl�ggningsprogrammet":
			specialisationsForProgramArrayList.add("Anl�ggninsfordon");
			specialisationsForProgramArrayList.add("Husbyggnad");
			specialisationsForProgramArrayList.add("Mark och anl�ggning");
			specialisationsForProgramArrayList.add("M�leri");
			specialisationsForProgramArrayList.add("Pl�tslageri");
			break;
		case "El- och energiprogrammet":
			specialisationsForProgramArrayList.add("Automation");
			specialisationsForProgramArrayList.add("Dator- och Kommunikationsteknik");
			specialisationsForProgramArrayList.add("Elteknik");
			specialisationsForProgramArrayList.add("Energiteknik");
			break;
		case "Fordons- och transportprogrammet":
			specialisationsForProgramArrayList.add("Godshantering");
			specialisationsForProgramArrayList.add("Karosseri och Lackering");
			specialisationsForProgramArrayList.add("Lastbil och Mobila Maskiner");
			specialisationsForProgramArrayList.add("Personbil");
			specialisationsForProgramArrayList.add("Transport");
			break;
		case "Handel- och administrationsprogrammet":
			specialisationsForProgramArrayList.add("Administrativ Service");
			specialisationsForProgramArrayList.add("Handel och Service");
			break;
		case "Hantverksprogrammet":
			specialisationsForProgramArrayList.add("Finsnickeri");
			specialisationsForProgramArrayList.add("Florist");
			specialisationsForProgramArrayList.add("Fris�r");
			specialisationsForProgramArrayList.add("Textil Design");
			specialisationsForProgramArrayList.add("�vriga Hantverk");
			break;
		case "Hotell- och turismprogrammet":
			specialisationsForProgramArrayList.add("Hotell och Konferens");
			specialisationsForProgramArrayList.add("Turism och Resor");
			break;
		case "Industritekniska programmet":
			specialisationsForProgramArrayList.add("Drifts�kerhet och Underh�ll");
			specialisationsForProgramArrayList.add("Processteknik");
			specialisationsForProgramArrayList.add("Produkt och Maskinteknik");
			specialisationsForProgramArrayList.add("Svetsteknik");
			break;
		case "Naturbruksprogrammet":
			specialisationsForProgramArrayList.add("Djur");
			specialisationsForProgramArrayList.add("Lantbruk");
			specialisationsForProgramArrayList.add("Skog");
			specialisationsForProgramArrayList.add("Tr�dg�rd");
			break;
		case "Resturang- och livsmedelsprogrammet":
			specialisationsForProgramArrayList.add("Bageri och Konditori");
			specialisationsForProgramArrayList.add("F�rskvaror, Delikatesser och Catering");
			specialisationsForProgramArrayList.add("K�k och Servering");
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

		String[] specialisationsForProgramArray = new String[specialisationsForProgramArrayList.size() - 1];
		specialisationsForProgramArray = specialisationsForProgramArrayList.toArray(specialisationsForProgramArray);

		return specialisationsForProgramArray;
	}

	public static double getQualificationPointsForCourse(String course) {

		double qualificationPoints = 0.0;

		switch (course) {
		case "Moderna spr�k 4":
			qualificationPoints = 1.0;
			break;
		case "Moderna spr�k 5":
			if (qualificationPointsForModernForeignLanguages < 1.5)
				qualificationPoints = 0.5;
			break;
		case "Engelska 7":
			qualificationPoints = 1.0;
			break;
		case "Matematik 2":
			qualificationPoints = 0.5;
			break;
		case "Matematik 3":
			qualificationPoints = 0.5;
			break;
		case "Matematik 4":
			qualificationPoints = 0.5;
			break;
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
