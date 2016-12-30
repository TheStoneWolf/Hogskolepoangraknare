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
			"Resturang- och livsmedelsprogrammet", "VVS- och fastighetsprogrammet", "V�rd- och omsorgsprogrammet" };

	private static String[] swedishAsASecondLanguageCourses = { "Svenska som Andraspr�k 1", "Svenska som Andraspr�k 2",
			"Svenska som Andraspr�k 3" };

	private static String[] swedishCourses = { "Svenska 1", "Svenska 2", "Svenska 3" };

	private static String[] coursesWithOnly50Points = { "Historia 1a1", "Historia 1a2", "Religionskunskap 1",
			"Religionskunskap 2", "Samh�llskunskap 1a1", "Samh�llskunskap 1a2", "Naturkunskap 1a1", "Naturkunskap 1a2",
			"Psykologi 1", "Filosofi 1", "Konstarterna och samh�llet" };

	public static void setProgram(String newProgram) {
		program = newProgram;
	}

	public static int getPointsFromCourse(String course) {
		int points = 100;

		for (int i = 0; i < coursesWithOnly50Points.length; i++) {
			if (course == coursesWithOnly50Points[i])
				points = 50;
		}
		if (course == "Fysik 1a" || course == "Teknik 1" || course == "Medicin 1"
				|| course == "V�rd och omsorgsarbete 2") {
			points = 150;
		} else if (course == "Fordons- och transportbranschens villkor och arbetsomr�den"
				|| course == "Fordonsteknik - introduktion" || course == "Hantverk - introduktion"
				|| course == "Naturbruk") {
			points = 200;
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
			ProgramSave.setCoursesInArrayList(returnArrayList, "Matematik 1c", "Matematik 2c", "Matematik 3c");
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
			break;

		case "Ekonomiprogrammet": // Moderna spr�k
			ProgramSave.setCoursesInArrayList(returnArrayList, "F�retagsekonomi 1", "Privatejuridik", "Psykologi 1");
			break;

		case "Samh�llsvetenskapsprogrammet": // Moderna spr�k 200
			ProgramSave.setCoursesInArrayList(returnArrayList, "Psykologi 1", "Filosofi 1");
			break;

		case "Teknikprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Fysik 1a", "Kemi 1", "Teknik 1");
			break;

		case "Estetiska programmet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Estetisk kommunikation 1",
					"Konstarterna och samh�llet");
			break;
		case "Humanistiska programmet": // Moderna spr�k 200
			ProgramSave.setCoursesInArrayList(returnArrayList, "Filosofi 1", "M�nniskans spr�k 1");
			break;

		case "Barn- och fritidsprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "H�lsopedagogik", "Kommunikation",
					"L�rande och utveckling", "M�nniskors milj�er", "Pedagogiskt ledarskap");
			break;

		case "Bygg- och anl�ggningsprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Bygg och anl�ggning 1", "Bygg och anl�ggning 2");
			break;

		case "El- och energiprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Datorteknik 1a", "Elektromekanik", "Energiteknik 1",
					"Mekatronik 1");
			break;

		case "Fordons- och transportprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList,
					"Fordons- och transportbranschens vilkor och arbetsomr�den", "Fordonsteknik - introduktion");
			break;

		case "Handels- och administrationsprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Entrepren�rskap", "Servicekunskap",
					"Branschkunskap inom handel och administration", "Information och kommunikation 1");
			break;

		case "Hantverksprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Entrepren�rskap", "Hantverk - introduktion",
					"Tradition och utveckling");
			break;

		case "Hotell- och turismprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Bes�ksn�ringen", "Entrepren�rskap",
					"Konferens och evenemang", "Logi", "Resm�l och resv�gar", "Service och bem�tande");
			break;

		case "Industritekniska programmet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Industritekniska processer 1",
					"M�nniskan i industrin 1", "Produktionskunskap 1", "Produktionsutrustning 1");
			break;

		case "Naturbruksprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Entrepren�rskap", "Naturbruk");
			break;

		case "Restaurang- och livsmedelsprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Hygien", "Livsmedels- och n�ringskunskap 1",
					"Branschkunskap inom restaurang och livsmedel", "Service och bem�tande 1");
			break;

		case "VVS- och fastighetsprogrammet":
			ProgramSave.setCoursesInArrayList(returnArrayList, "Praktisk ell�ra", "Systemuppbygnad", "V�rmel�ra",
					"Verktyg- och materialhantering");
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

	private static void setCoursesInArrayList(ArrayList arrayList, String... courses) {

		for (int i = 0; i < courses.length; i++) {
			arrayList.add(courses[i]);
		}
	}

	private static int getIndexOfOtherSubjectsInArrayList(ArrayList arrayList, String course) {

		int index = -1;

		String subject = ProgramSave.getFirstWordFromSentence(course);

		// Finds the index of the subject
		for (int i = 0; i < arrayList.size(); i++) {

			String subjectInFocusInArrayList = ProgramSave.getFirstWordFromSentence((String) arrayList.get(i));

			String nextSubjectInArrayList = ProgramSave.getFirstWordFromSentence((String) arrayList.get(i + 1));
			if (subject.equals(subjectInFocusInArrayList) && !(subject.equals(nextSubjectInArrayList))) {
				return index;
			}

		}

		return index;
	}

	private static String getFirstWordFromSentence(String sentence) {
		char[] wordInChars = new char[sentence.length()];
		int i = 0;

		do {
			wordInChars[i] = sentence.charAt(i++);

		} while (wordInChars[i - 1] != ' ');
		String word = String.valueOf(wordInChars);

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
		case "Handels- och administrationsprogrammet":
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
		case "Restaurang- och livsmedelsprogrammet":
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
