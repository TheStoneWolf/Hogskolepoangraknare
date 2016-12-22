package main;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.backend.program.ProgramSave;

public class ApplicationStart extends Application {

	int numberOfListsPressed;
	
	boolean programListHasNotBeenActivated = true;
	boolean programSpecialisationListHasNotBeenActivated = true;
	boolean modernForeignLanguagesListHasNotBeenActivated = true;

	TextField[] programCourses;
	Text[] qualificationPointsForCourse;
	
	String[] coursePointsLabels = { "Kurs", "Betyg", "Meritvärde", "Poäng" };

	public void start(Stage stage) throws Exception {

		VBox mainPane = new VBox();
		mainPane.setPadding(new Insets(15.0));
		VBox mainVBox = new VBox();
		

		Text titleText = new Text("Högskolepoängräknaren");
		titleText.setFont(new Font("Times New Roman", 28));
		Text subtitleText = new Text("   - av Simon Jansson Na16B");
		subtitleText.setFont(new Font("Times New Roman", 15));

		GridPane programChoicePane = new GridPane();
		VBox.setMargin(programChoicePane, new Insets(10.0, 0, 0, 0));

		Text theoreticalProgramListRubric = new Text("Gymnasieprogram");
		theoreticalProgramListRubric.setFont(new Font("Times New Roman", 20));
		programChoicePane.add(theoreticalProgramListRubric, 0, 0);
		GridPane.setMargin(theoreticalProgramListRubric, new Insets(0, 0, 0, 43));

		ListView<String> programList = new ListView<>();
		ObservableList<String> theoreticalProgramsObservableList = FXCollections
				.observableArrayList(ProgramSave.Programs);
		programList.setItems(theoreticalProgramsObservableList);
		programList.setPrefSize(250.0, 100.0);
		programChoicePane.add(programList, 0, 1);
		GridPane.setMargin(programList, new Insets(10.0, 15.0, 0, 0));

		Text programSpecialisationsListRubric = new Text("Inriktning");
		programSpecialisationsListRubric.setFont(new Font("Times New Roman", 20));
		programChoicePane.add(programSpecialisationsListRubric, 1, 0);
		GridPane.setMargin(programSpecialisationsListRubric, new Insets(0, 0, 0, 82.0));

		ListView<String> programSpecialisationList = new ListView<>();
		programSpecialisationList.setPrefSize(250.0, 100.0);
		programChoicePane.add(programSpecialisationList, 1, 1);
		GridPane.setMargin(programSpecialisationList, new Insets(10.0, 0, 0, 0));

		Text ModernForeignLanguagesListRubric = new Text("Ditt språkval");
		ModernForeignLanguagesListRubric.setFont(new Font("Times New Roman", 20));
		programChoicePane.add(ModernForeignLanguagesListRubric, 3, 0);
		GridPane.setMargin(ModernForeignLanguagesListRubric, new Insets(10, 0, 0, 75));

		ListView<String> modernForeignLanguagesList = new ListView<>();
		ObservableList<String> ModernForeignLanguagesObservableList = FXCollections.observableArrayList(
				"Moderna språk (börjar i kurs 4)", "moderna språk (börjar i kurs 1)", "Modersmål",
				"Kinesiska (börjar i kurs 4)", "Kinesiska (börjar i kurs 1)", "Teckenspråk");
		modernForeignLanguagesList.setItems(ModernForeignLanguagesObservableList);
		modernForeignLanguagesList.setPrefSize(250, 100);
		GridPane.setMargin(modernForeignLanguagesList, new Insets(10.0, 0, 0, 10.0));
		programChoicePane.add(modernForeignLanguagesList, 3, 1);

		GridPane extraParameterPane = new GridPane();
		ColumnConstraints col1 = new ColumnConstraints(205.0);
		ColumnConstraints col2 = new ColumnConstraints(20.0);
		ColumnConstraints col3 = new ColumnConstraints(375.0);
		extraParameterPane.getColumnConstraints().addAll(col1, col2, col3);

		Label hasSwedishAsASecondLanguageLabel = new Label("Har du svenska som andraspråk?");
		hasSwedishAsASecondLanguageLabel.setFont(new Font("Times New Roman", 15));
		GridPane.setMargin(hasSwedishAsASecondLanguageLabel, new Insets(20, 0, 0, 0));
		extraParameterPane.add(hasSwedishAsASecondLanguageLabel, 0, 0);
		CheckBox hasSwedishAsASecondLanguageCheckBox = new CheckBox();
		GridPane.setMargin(hasSwedishAsASecondLanguageCheckBox, new Insets(10, 60, 0, 0));
		extraParameterPane.add(hasSwedishAsASecondLanguageCheckBox, 1, 0);

		Text notificationToFillInAllAlternatives = new Text();
		notificationToFillInAllAlternatives.setFont(new Font("Modena", 20));
		GridPane.setMargin(notificationToFillInAllAlternatives, new Insets(20, 10, 0, 45));
		extraParameterPane.add(notificationToFillInAllAlternatives, 2, 0);

		Button confirmProgramChoiceButton = new Button("Bekräfta allt");
		confirmProgramChoiceButton.setPadding(new Insets(8.0));
		GridPane.setMargin(confirmProgramChoiceButton, new Insets(20, 0, 0, 0));
		extraParameterPane.add(confirmProgramChoiceButton, 3, 0);

		Text programChoiceInstructionText = new Text("När du är klar, klicka på 'Bekräfta allt'");
		programChoiceInstructionText.setFont(new Font("Times New Roman", 18));
		VBox.setMargin(programChoiceInstructionText, new Insets(5, 0, 0, 0));

		Text chosenProgramDisplayText = new Text("valt program här!");
		chosenProgramDisplayText.setFont(new Font("Times New Roman", 30));
		VBox.setMargin(chosenProgramDisplayText, new Insets(15, 0, 0, 0));

		FlowPane totalPointsDisplayPane = new FlowPane();
		totalPointsDisplayPane.setOrientation(Orientation.HORIZONTAL);
		VBox.setMargin(totalPointsDisplayPane, new Insets(10, 0, 7, 0));

		Text pointsAchievedNowText = new Text("Placeholder 1");
		pointsAchievedNowText.setFont(new Font("Times New Roman", 20));
		FlowPane.setMargin(pointsAchievedNowText, new Insets(0, 0, 0, 35));

		Text expectedPointsText = new Text("Placeholder 2");
		expectedPointsText.setFont(new Font("Times New Roman", 20));
		FlowPane.setMargin(expectedPointsText, new Insets(0, 0, 0, 35));

		Text pointsNeededText = new Text("Placeholder 3");
		pointsNeededText.setFont(new Font("Times New Roman", 20));
		FlowPane.setMargin(pointsNeededText, new Insets(0, 0, 0, 35));

		Text maximumPointsText = new Text("Placeholder 4");
		maximumPointsText.setFont(new Font("Times New Roman", 20));
		FlowPane.setMargin(maximumPointsText, new Insets(0, 0, 0, 35));

		totalPointsDisplayPane.getChildren().addAll(pointsAchievedNowText, expectedPointsText, pointsNeededText,
				maximumPointsText);

		FlowPane savedSetupsPane = new FlowPane();
		savedSetupsPane.setOrientation(Orientation.HORIZONTAL);

		Text savedSetupOne = new Text("Save 1");
		savedSetupOne.setFont(new Font("Times New Roman", 15.0));

		Text savedSetupTwo = new Text("Save 2");
		savedSetupTwo.setFont(new Font("Times New Roman", 15.0));
		FlowPane.setMargin(savedSetupTwo, new Insets(0, 0, 0, 10));

		Text savedSetupThree = new Text("Save 3");
		savedSetupThree.setFont(new Font("Times New Roman", 15.0));
		FlowPane.setMargin(savedSetupThree, new Insets(0, 0, 0, 10));

		Text savedSetupFour = new Text("Save 4");
		savedSetupFour.setFont(new Font("Times New Roman", 15.0));
		FlowPane.setMargin(savedSetupFour, new Insets(0, 0, 0, 10));

		savedSetupsPane.getChildren().addAll(savedSetupOne, savedSetupTwo, savedSetupThree, savedSetupFour);

		FlowPane courseTableUpperLabelsPane = new FlowPane();
		courseTableUpperLabelsPane.setPadding(new Insets(10, 0, 20, 0));

		Label courseInTableLabel = new Label("Kurs");

		Label gradeInTableLabel = new Label("Betyg");
		FlowPane.setMargin(gradeInTableLabel, new Insets(0, 0, 0, 200));

		Label extraPointsInTableLabel = new Label("Meritvärde");
		FlowPane.setMargin(extraPointsInTableLabel, new Insets(0, 0, 0, 10));

		Label pointsFromCourseInTableLabel = new Label("poäng");
		FlowPane.setMargin(pointsFromCourseInTableLabel, new Insets(0, 0, 0, 10));
		courseTableUpperLabelsPane.getChildren().addAll(courseInTableLabel, gradeInTableLabel, extraPointsInTableLabel,
				pointsFromCourseInTableLabel);

		GridPane courseTablePane = new GridPane();
		ColumnConstraints columnOneForCourseTable = new ColumnConstraints();
		columnOneForCourseTable.setPrefWidth(200.0);
		courseTablePane.getColumnConstraints().add(columnOneForCourseTable);

		ScrollPane sceneScrollPane = new ScrollPane(mainPane);
		sceneScrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		sceneScrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);

		mainPane.getChildren().addAll(titleText, subtitleText, programChoicePane, extraParameterPane,
				programChoiceInstructionText, chosenProgramDisplayText, totalPointsDisplayPane, savedSetupsPane,
				courseTableUpperLabelsPane, courseTablePane);
		mainVBox.getChildren().addAll(mainPane, sceneScrollPane);
		Scene applicationScene = new Scene(mainVBox);
		stage.setHeight(1050);
		
		sceneScrollPane.setPrefHeight(stage.getHeight());
		
		
		stage.setWidth(850.0);
		stage.setScene(applicationScene);
		stage.setTitle("Högskolepoängräknaren");
		stage.show();

		// Sets "specialisations" for the program in focus
		programList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

				String chosenProgram = programList.getSelectionModel().getSelectedItem().toString();

				ObservableList<String> programFocuses = FXCollections
						.observableArrayList(ProgramSave.getSpecialisationsForProgram(chosenProgram));
				programSpecialisationList.setItems(programFocuses);

				programSpecialisationListHasNotBeenActivated = true;

				numberOfListsPressed = numberOfListsPressed > 0 ? numberOfListsPressed-- : 0;

				if (programListHasNotBeenActivated) {
					numberOfListsPressed += 1;
					programListHasNotBeenActivated = false;
				}

			}

		});

		programSpecialisationList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

				if (programSpecialisationListHasNotBeenActivated) {
					numberOfListsPressed += 1;
					programSpecialisationListHasNotBeenActivated = false;
				}

			}

		});

		modernForeignLanguagesList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

				if (modernForeignLanguagesListHasNotBeenActivated) {
					numberOfListsPressed += 1;
					modernForeignLanguagesListHasNotBeenActivated = false;
				}

			}
		});

		confirmProgramChoiceButton.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {

				if (numberOfListsPressed == 3) {

					String chosenProgram = programList.getSelectionModel().getSelectedItem().toString();

					ProgramSave.setProgram(chosenProgram);

					courseTablePane.getChildren().clear();

					String programSpecialisation = programSpecialisationList.getSelectionModel().getSelectedItem()
							.toString();
					String modernForeignLanguagesChoice = modernForeignLanguagesList.getSelectionModel()
							.getSelectedItem().toString();

					String[] coursesForProgram = ProgramSave.getCoursesForProgram(
							hasSwedishAsASecondLanguageCheckBox.isSelected(), programSpecialisation,
							modernForeignLanguagesChoice);

					// Place out coursesInTable
					for (int i = 0; i < coursesForProgram.length; i++) {
						Label course = new Label(coursesForProgram[i]);
						GridPane.setMargin(course, new Insets(0, 0, 0, 0));
						courseTablePane.add(course, 0, i);
					}
					programCourses = new TextField[coursesForProgram.length];
					qualificationPointsForCourse = new Text[coursesForProgram.length];
					notificationToFillInAllAlternatives.setText("");
					

					for (int i = 0; i < programCourses.length; i++) {
						programCourses[i] = new TextField();
						programCourses[i].setPrefSize(25.0, 0);
						GridPane.setMargin(programCourses[i], new Insets(0, 2.5, 7.5, 25));
						courseTablePane.add(programCourses[i], 1, i);
						
						/*//Adds the parameter for qualification points (meritvärde)
						qualificationPointsForCourse[i] = ProgramSave. */
					}

				} else {
					notificationToFillInAllAlternatives.setText("Please fill in all alternatives");
				}

			}

		});
	}

}
