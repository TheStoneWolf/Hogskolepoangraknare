package main.backend.program;

import java.util.ArrayList;

public class ProgramSave {

	private static String program;

	private static double qualificationPointsForModernForeignLanguages = 0;
	private static double qualificationPointsForMathematics = 0;

	public static String[] Programs = { "Naturvetenskapsprogrammet", "Samhällsvetenskapsprogrammet",
			"Ekonomiprogrammet", "Teknikprogrammet", "Estetiska programmet", "Humanistiska programmet",
			"Barn- och fritidsprogrammet", "Bygg- och anläggningsprogrammet", "El- och energiprogrammet",
			"Fordons- och transportprogrammet", "Handel- och administrationsprogrammet", "Hantverksprogrammet",
			"Hotell- och turismprogrammet", "Industritekniska programmet", "Naturbruksprogrammet",
			"Resturang- och livsmedelsprogrammet", "VVS- och fastighetsprogrammet", "Vård- och omsorgsprogrammet" };

	private static String[] coursesNatureCommon = { "Engelska 5", "Engelska 6", "Historia 1c", "Idrott och Hälsa 1",
			"Matematik 1c", "Matematik 2c", "Matematik 3c", "Religionskunskap 1", "Samhällskunskap 1b", "Biologi 1",
			"Fysik 1a", "Kemi 1" };

	private static String[] courseNatureNatureScience = { "Biologi 2", "Fysik 2", "Kemi 2", "Matematik 4" };

	private static String[] courseNatureNatureScienceAndSociety = { "Ett Naturvetenskapligt Ämne", "Geografi 1",
			"Samhällskunskap 2" };

	private static String[] swedishAsASecondLanguageCourses = { "Svenska som Andraspråk 1", "Svenska som Andraspråk 2",
			"Svenska som Andraspråk 3" };

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
				|| program == "Humanistiska programmet" || program == "Samhällsvetenskapsprogrammet") {
			returnArrayList.add(ProgramSave.getModernForeignLanguages(modernForeignLanguagesChoice, 0));
		}
		if (program == "Humanistiska programmet" || program == "Samhällsvetenskapsprogrammet") {
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
			specialisationsForProgramArrayList.add("Naturvetenskap och samhälle");
			break;
		case "Samhällsvetenskapsprogrammet":
			specialisationsForProgramArrayList.add("Beteendevetenskap");
			specialisationsForProgramArrayList.add("Medier, Information och Kommunikation");
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
			specialisationsForProgramArrayList.add("Samhällsbyggande och Miljö");
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
			specialisationsForProgramArrayList.add("Språk");
			break;
		case "Barn- och fritidsprogrammet":
			specialisationsForProgramArrayList.add("Fritid och Hälsa");
			specialisationsForProgramArrayList.add("Pedagogiskt Arbete");
			specialisationsForProgramArrayList.add("Socialt Arbete");
			break;
		case "Bygg- och anläggningsprogrammet":
			specialisationsForProgramArrayList.add("Anläggninsfordon");
			specialisationsForProgramArrayList.add("Husbyggnad");
			specialisationsForProgramArrayList.add("Mark och anläggning");
			specialisationsForProgramArrayList.add("Måleri");
			specialisationsForProgramArrayList.add("Plåtslageri");
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
			specialisationsForProgramArrayList.add("Frisör");
			specialisationsForProgramArrayList.add("Textil Design");
			specialisationsForProgramArrayList.add("Övriga Hantverk");
			break;
		case "Hotell- och turismprogrammet":
			specialisationsForProgramArrayList.add("Hotell och Konferens");
			specialisationsForProgramArrayList.add("Turism och Resor");
			break;
		case "Industritekniska programmet":
			specialisationsForProgramArrayList.add("Driftsäkerhet och Underhåll");
			specialisationsForProgramArrayList.add("Processteknik");
			specialisationsForProgramArrayList.add("Produkt och Maskinteknik");
			specialisationsForProgramArrayList.add("Svetsteknik");
			break;
		case "Naturbruksprogrammet":
			specialisationsForProgramArrayList.add("Djur");
			specialisationsForProgramArrayList.add("Lantbruk");
			specialisationsForProgramArrayList.add("Skog");
			specialisationsForProgramArrayList.add("Trädgård");
			break;
		case "Resturang- och livsmedelsprogrammet":
			specialisationsForProgramArrayList.add("Bageri och Konditori");
			specialisationsForProgramArrayList.add("Färskvaror, Delikatesser och Catering");
			specialisationsForProgramArrayList.add("Kök och Servering");
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

		String[] specialisationsForProgramArray = new String[specialisationsForProgramArrayList.size() - 1];
		specialisationsForProgramArray = specialisationsForProgramArrayList.toArray(specialisationsForProgramArray);

		return specialisationsForProgramArray;
	}

	public static double getQualificationPointsForCourse(String course) {

		double qualificationPoints = 0.0;

		switch (course) {
		case "Moderna språk 4":
			qualificationPoints = 1.0;
			break;
		case "Moderna språk 5":
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
