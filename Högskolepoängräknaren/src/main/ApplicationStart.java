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
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.backend.program.ProgramSave;

public class ApplicationStart extends Application {

	int numberOfListsPressed = 0;
	int scrollSpeedMultiplier = 50;

	boolean programListHasNotBeenActivated = true;
	boolean programSpecialisationListHasNotBeenActivated = true;
	boolean modernForeignLanguagesListHasNotBeenActivated = true;

	TextField[] programCourses;

	String[] coursePointsLabels = { "Kurs", "Betyg", "Meritv�rde", "Po�ng" };

	public void start(Stage stage) throws Exception {

		VBox mainPane = new VBox();
		mainPane.setPadding(new Insets(15.0));
		VBox mainVBox = new VBox();

		Text titleText = new Text("H�gskolepo�ngr�knaren");
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

		Text ModernForeignLanguagesListRubric = new Text("Ditt spr�kval");
		ModernForeignLanguagesListRubric.setFont(new Font("Times New Roman", 20));
		programChoicePane.add(ModernForeignLanguagesListRubric, 3, 0);
		GridPane.setMargin(ModernForeignLanguagesListRubric, new Insets(10, 0, 0, 75));

		ListView<String> modernForeignLanguagesList = new ListView<>();
		ObservableList<String> ModernForeignLanguagesObservableList = FXCollections.observableArrayList(
				"Moderna spr�k (b�rjar i kurs 4)", "moderna spr�k (b�rjar i kurs 1)", "Modersm�l",
				"Kinesiska (b�rjar i kurs 4)", "Kinesiska (b�rjar i kurs 1)", "Teckenspr�k");
		modernForeignLanguagesList.setItems(ModernForeignLanguagesObservableList);
		modernForeignLanguagesList.setPrefSize(250, 100);
		GridPane.setMargin(modernForeignLanguagesList, new Insets(10.0, 0, 0, 10.0));
		programChoicePane.add(modernForeignLanguagesList, 3, 1);

		GridPane extraParameterPane = new GridPane();
		ColumnConstraints col1 = new ColumnConstraints(205.0);
		ColumnConstraints col2 = new ColumnConstraints(20.0);
		ColumnConstraints col3 = new ColumnConstraints(375.0);
		extraParameterPane.getColumnConstraints().addAll(col1, col2, col3);

		Label hasSwedishAsASecondLanguageLabel = new Label("Har du svenska som andraspr�k?");
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

		Button confirmProgramChoiceButton = new Button("Bekr�fta allt");
		confirmProgramChoiceButton.setPadding(new Insets(8.0));
		GridPane.setMargin(confirmProgramChoiceButton, new Insets(20, 0, 0, 0));
		extraParameterPane.add(confirmProgramChoiceButton, 3, 0);

		Text programChoiceInstructionText = new Text("N�r du �r klar, klicka p� 'Bekr�fta allt'");
		programChoiceInstructionText.setFont(new Font("Times New Roman", 18));
		VBox.setMargin(programChoiceInstructionText, new Insets(5, 0, 0, 0));

		Text chosenProgramDisplayText = new Text("valt program h�r!");
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

		Label pointsFromCourseInTableLabel = new Label("Po�ng");
		FlowPane.setMargin(pointsFromCourseInTableLabel, new Insets(0, 0, 0, 10));

		Label qualificationPointsInTableLabel = new Label("Meritv�rde");
		FlowPane.setMargin(qualificationPointsInTableLabel, new Insets(0, 0, 0, 10));

		courseTableUpperLabelsPane.getChildren().addAll(courseInTableLabel, gradeInTableLabel,
				pointsFromCourseInTableLabel, qualificationPointsInTableLabel);

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
		stage.setTitle("H�gskolepo�ngr�knaren");
		stage.show();

		// Increases scroll speed
		sceneScrollPane.setOnScroll(new EventHandler<ScrollEvent>() {
			@Override
			public void handle(ScrollEvent event) {
				double deltaY = event.getDeltaY() * scrollSpeedMultiplier;
				double width = sceneScrollPane.getContent().getBoundsInLocal().getWidth();
				double vvalue = sceneScrollPane.getVvalue();
				sceneScrollPane.setVvalue(vvalue + -deltaY / width);
				// deltaY/width to make the scrolling equally fast regardless of
				// the actual width of the component
			}
		});

		// Sets "specialisations" for the program in focus
		programList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

				String chosenProgram = programList.getSelectionModel().getSelectedItem().toString();

				ObservableList<String> programFocuses = FXCollections
						.observableArrayList(ProgramSave.getSpecialisationsForProgram(chosenProgram));
				programSpecialisationList.setItems(programFocuses);
				
				if(!programSpecialisationListHasNotBeenActivated && numberOfListsPressed > 0) {
					numberOfListsPressed-= 1;
				} else if(!programSpecialisationListHasNotBeenActivated) {
					numberOfListsPressed = 0;
				}
					

				programSpecialisationListHasNotBeenActivated = true;

				//numberOfListsPressed = numberOfListsPressed > 0 ? numberOfListsPressed-= 1 : 0;

				if (programListHasNotBeenActivated) {
					numberOfListsPressed += 1;
					programListHasNotBeenActivated = false;
				}

			}

		});

		// Checks whether program specialisation list has been activated to make
		// sure that all parameters have been added before courses are added,
		// The same goes for the Modern foreign languages list
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

		// Loads the courses according to the parameters the user has set
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

					programCourses = new TextField[coursesForProgram.length];
					notificationToFillInAllAlternatives.setText("");

					// Place out coursesInTable
					for (int i = 0; i < coursesForProgram.length; i++) {
						Label course = new Label(coursesForProgram[i]);

						courseTablePane.add(course, 0, i);

						// Users grade for course is added here
						programCourses[i] = new TextField();
						programCourses[i].setPrefSize(25.0, 0);
						GridPane.setMargin(programCourses[i], new Insets(0, 0, 7.5, 25));
						courseTablePane.add(programCourses[i], 1, i);
						
						// Adds the points earned from each course
						int points = ProgramSave.getPointsFromCourse(coursesForProgram[i]);
						Text pointsText = new Text(String.valueOf(points));
						GridPane.setMargin(pointsText, new Insets(0, 42, 0, 20));
						pointsText.setTranslateY(-5);
						courseTablePane.add(pointsText, 2, i);

						// Adds the parameter for qualification points
						// (meritv�rde)
						String qualificationPointsLackingZeroDecimal;
						double qualificationPoints = ProgramSave.getQualificationPointsForCourse(coursesForProgram[i]);
						if (qualificationPoints != 0.5) {
							qualificationPointsLackingZeroDecimal = String.valueOf((int) qualificationPoints);
						} else {
							qualificationPointsLackingZeroDecimal = String.valueOf(qualificationPoints);
						}

						Text qualificationPointsForCourseText = new Text(qualificationPointsLackingZeroDecimal);
						qualificationPointsForCourseText.setTranslateY(-5);
						courseTablePane.add(qualificationPointsForCourseText, 3, i);

					}

				} else {
					notificationToFillInAllAlternatives.setText("Please fill in all alternatives");
				}
			}
		});
	}
}
