## Alcoholmeter

## Paul Hauser // Lucas Gigondan // Gil Flassch--Trauth
https://github.com/popo-source/AlcoolTester

# __Software Engineering__
# __Inhaltsverzeichnis__

## __Einleitung__
Im Rahmen einer Projektarbeit möchten wir Ihnen eine Blutalkohlgehalt-Software vorstellen, die wir mit Hilfe von Software-Engineering-Methoden im Team entwickelt haben. Ziel des Projektes war es, Methoden wie Scrum oder Agile praktisch anzuwenden und alle wichtigen Phasen der strukturierten Softwareentwicklung zu durchlaufen. Um dies zu erreichen, haben wir ein Blutalkohlgehaltdiagramm erstellt, das für jeden anpassbar ist. Der Zweck dieser Anwendung ist es, den Blutalkoholgehalt einer Person im Zeitverlauf zu berechnen.

* ### Ziele des Projekts:
Wir wollen eine Software entwickeln, die es dem Benutzer ermöglicht, seinen Blutalkoholgehalt im Laufe der Zeit zu berechnen. Er muss in der Möglichkeit sein, seine Charakteristika wie Nachname, Vorname, Geschlecht und Gewicht einzugeben.
Die Person hat die Möglichkeit, eine Liste von Alkohol und der aufgenommenen Menge zu erstellen. Der Benutzer muss angeben, ob er gegessen hat oder nicht.
Die Grafik muss an die verschiedenen Parameter angepasst werden.

* ### Randbedingungen:
Das Programm wird in der Programmiersprache Java erstellt.
Das Projektteam besteht aus drei Personen. 
Zur Programmierung wird Eclipse und Scene Builder verwendet.
Die Klassen des Programms sollen über die entsprechenden Unit-Tests verfügen.
Das Projekt soll auf GitHub veröffentlich werden.
Die Buildautomatisierung soll mit MAVEN erfolgen.
Das Programm soll mittels einer dafür erstellten JAR-Datei und dem Befehl java-jar xxxxx.jar ausgeführt werden können.

* ## __Buildanleitung__
Speichern Sie Ihre src Datei von Ihre Git Projekt auf Ihre Rechner.

Löschen Sie Ihre src Datei von Ihre Git Projekt.

Fügen Sie die pom.xml Datei mit die geeignete Initialiesierung in das Git Projekt.

Fügen Sie die src Ordner von einen Maven Projekt in das Git Projekt.

Klicken Sie auf den rechten Maus Taste in "AlcoolTest": ->Configure ->Convert to Maven.

Fügen Sie Ihre eigene Package in das Ordner src/main/java.

Klicken Sie auf den rechten Maus Taste in "AlcoolTest": ->Run as ->Maven clean.

Klicken Sie auf den rechten Maus Taste in "AlcoolTest": ->Run as ->Maven install.

Prüfen Sie in das Ordner "target" ob Sie eine Datei .jar haben.

* ## __Bedienungsanleitung__
1. Öffnen Sie das Alkoholtest.
2. Klicken Sie auf „New" um Personen und Alkohole hinzuzufügen.
3. Füllen Sie die angezeigten Fenster aus und klicken Sie auf Ok. 
4. Klicken Sie auf „Add" um die konsumierten Alkohole und die Menge zu speichern.
5. Geben Sie die verbrauchte Alkoholmenge in das angezeigte Fenster ein und klicken Sie auf Ok.
6. Kreuzen Sie eines der beiden Kästchen "Yes" oder "No" an, um die Frage zu beantworten: „Have you eaten?“.
7. Zum Schluss klicken Sie auf „Graphic“. Sie erhalten ein Diagramm, das den Blutalkoholgehalt im Laufe der Zeit anzeigt.
8. Sie können immer eine Person, einen Alkohol oder den Alkoholkonsum einer Person jederzeit löschen, indem Sie die Zeile wählen und auf „Delete“ klicken.
9. Sie können die Informationen ändern, indem Sie die Zeile auswählen und auf „Edit" klicken.

* ## __Test Cases__
Test Case # | Test Case Description | Test Data | Expected Result | Actual Result | Pass/Fail
-- | --- | ------------ | --------- | --- | ---
1 | Check results on entering valid PersonData | Firstname: Paul <br></b>Lastname: Muster <br></b>Weight: 80 kg <br></b>Sex: man | No error message should be generated and the person's information is displayed in the table. | As Expected | Pass |
2 | Check results on entering valid AlcoholData | Alcoholname: Beer <br></b>Degrees: 5% <br></b>Quantity: 100cl| No error message should be generated and the alcohol's information is displayed in the table. | As Expected | Pass |


* ## __Userstory mit Akzeptanzkriterien__

US | Name | Beschreibung | SP | Priorität
-- | ---------------- | ------------------------------------------------------------------------------------------------ | -- | --
1 | Diagramminitializierung | Als Benutzer möchte ich meinen Alkoholgehalt im Blut als Funktion der Zeit kennenlernen. <br><b> Akzeptanzkriterien: <br></b>- Test, ob die Funktion der Taste " Graphic " funktioniert.<br></b>- Test zur Darstellung einer Grafik, die den Blutalkoholspiegel als Funktion der Zeit anzeigt.| 5 | 1 |
2  | Personanzeige | Als Benutzer möchte ich meinen Alkoholgehalt anhand meiner persönlichen Eigenschaften berechnen können. <br><b> Akzeptanzkriterien: <br></b>- Test, ob die Fensterbedienung zur Eingabe von Name, Vorname, Gewicht und Geschlecht einer Person fonctioniert. <br></b>- Test, um den Namen, Vornamen und das Gewicht der Person in einer Tabelle anzuzeigen.| 3 | 1 |
3  | Alkohlanzeige | Als Benutzer möchte ich in der Lage sein, eine vordefinierte Alkoholliste zu erstellen. <br><b> Akzeptanzkriterien: <br></b>- Test, ob die Funktionsfähigkeit des Fensters, mit dem der Name des Alkohols und der Prozentsatz davon eingegeben werden können, funktionieren. <br></b>- Test zur Anzeige des Namens des Alkohols und des Alkoholanteils in einer Tabelle.| 3 | 1 |
4  | Mengenanzeige |Als Benutzer möchte ich meinen Alkoholgehalt basierend auf meinem Konsum verschiedener Alkohole berechnen können. <br><b> Akzeptanzkriterien: <br></b>- Test, ob die Function der Taste " Add " funktioniert. <br></b>- Test, ob die Funktion des Fensters, die es ermöglicht, die Menge jedes aufgenommenen Alkohols einzugeben, funktionieren. <br></b>- Test zur Anzeige des Namens des Alkohols und der Menge in einer Tabelle. | 3 | 1 |
5  | Newmethode | Als Benutzer möchte ich einige von mir eingegebene Variablen hinzufügen können. <br><b> Akzeptanzkriterien: <br></b>- Test, ob die Funktion der Taste "New" funktioniert. <br></b>- Test, ob die Fensterbedienung, die es ermöglicht, neue Personen oder neue Alkohole hinzuzufügen, funktioniert. | 2 | 3 |
6  | Editmethode | Als Benutzer möchte ich einige der von mir eingegebenen Variablen ändern können. <br><b> Akzeptanzkriterien: <br></b>- Test, ob die Funktion der Taste "Edit" funktiniert. <br></b>- Test, ob die Anzeige der Parameter der ausgewählten Zeile funktioniert.| 2 | 2 |
7  | Deletemethode | Als Benutzer möchte ich einige der von mir eingegebenen Variablen löschen können. <br><b> Akzeptanzkriterien: <br></b>- Test, ob die Funktion der Taste " Delete " funktioniert. <br></b>- Test, ob die Funktion des Fensters, damit Sie die Auswahl löschen können, funktionieren.| 2 | 3 |
8  | Two-Choicemethode | Als Benutzer möchte ich angeben können, ob ich gegessen habe oder nicht. <br><b> Akzeptanzkriterien: <br></b>- Test, ob die beiden Kontrollkästchen "Yes" und "No" funktionieren..| 3 | 4 |
9  | Fehlermeldunganzeige | Als Programmierer möchte ich, dass alle Informationen ausgewählt werden, bevor das Diagramm angezeigt wird.<br><b> Akzeptanzkriterien: <br></b>- Test, ob der Anzeige der Fehlermeldung funktioniert, wenn eine Auswahl fehlt.| 2 | 2 |
10  | Testmethode | Als Entwickler möchte ich ein einfach wartbares Programm damit alle Informatiker es bearbeiten können. <br><b> Akzeptanzkriterien: <br></b>- Test, ob die verschiedenen Klassen fonctionnieren.| 2 | 4 |


* ## __Releaseplan mit den Ausbaustufen__
Sprint 1 | Sprint 2 | Sprint 3 | Sprint 4
------|------|------|------
US 1, 3, 4, 5, 6, 7 | US 2 | US 8 | US 9, 10

* ## __Taskliste für die Umsetzung der User Story__

User Story 1 | Als Benutzer möchte ich meinen Alkoholgehalt im Blut als Funktion der Zeit kennenlernen. | 
Zeitaufwandschätzung |
-- | ---------------------------------------------------------------------------------- | -- 
| Task 1 | Erstellung der Taste " Graphic ". | 15 Minuten |
| Task 2 | Darstellung einer Grafik, die den Blutalkoholspiegel als Funktion der Zeit anzeigt.| 3 Stunde |

User Story 2  | Als Benutzer möchte ich meinen Alkoholgehalt anhand meiner persönlichen Eigenschaften berechnen können. | 
Zeitaufwandschätzung |
-- | ---------------------------------------------------------------------------------- | -- 
| Task 1 | Der Name, Vorname, Gewicht und Geschlecht einer Person müssen eingegeben werden können. | 30 Minuten | 
| Task 2 | Der Name, Vorname und das Gewicht der Person müssen in einer Tabelle angezeigt werden. | 1 Stunde |

User Story 3  | Als Benutzer möchte ich in der Lage sein, eine vordefinierte Alkoholliste zu erstellen. | 
Zeitaufwandschätzung |
-- | ---------------------------------------------------------------------------------- | -- 
| Task 1 | Der Name des Alkohols und der Prozentsatz davon müssen eingegeben werden können.| 30 Minuten |
| Task 2 | Der Name des Alkohols und der Alkoholanteils müssen in einer Tabelle angezeigt werden.| 1 Stunde |

User Story 4  | Als Benutzer möchte ich meinen Alkoholgehalt basierend auf meinem Konsum verschiedener Alkohole berechnen können. | 
Zeitaufwandschätzung |
-- | ---------------------------------------------------------------------------------- | -- 
| Task 1 | Erstellung der Taste " Add ". | 15 Minuten |
| Task 2 | Anzeige des Fensters, mit dem die Menge jedes aufgenommenen Alkohols eingegeben kann.| 1 Stunde |
| Task 3 | Der Name des Alkohols und die Menge müssen in einer Tabelle angezeigt werden. | 1 Stunde |

User Story 5  | Als Benutzer möchte ich einige von mir eingegebene Variablen hinzufügen können. | 
Zeitaufwandschätzung |
-- | ---------------------------------------------------------------------------------- | -- 
| Task 1 | Erstellung der Taste "Neu". | 15  Minuten |
| Task 2 | Anzeige des Fensters, mit dem neue Personen oder neue Alkohole hinzuzufügen können. | 1 Stunde |

User Story 6  | Als Benutzer möchte ich einige der von mir eingegebenen Variablen ändern können. | 
Zeitaufwandschätzung |
-- | ---------------------------------------------------------------------------------- | -- 
| Task 1 | Erstellung der Taste "Edit". | 15 Minuten |
| Task 2 | Anzeige des Fensters, mit dem die Auswahl ändern kann.| 1 Stunde |

User Story 7  | Als Benutzer möchte ich einige der von mir eingegebenen Variablen löschen können. | 
Zeitaufwandschätzung |
-- | ---------------------------------------------------------------------------------- | -- 
| Task 1 | Erstellung der Taste " Delete ". | 15 Minuten |
| Task 2 | Anzeige des Fensters, mit dem die Auswahl löschen kann.| 1 Stunde |

User Story 8  | Als Entwickler möchte ich ein einfach wartbares Programm damit alle Informatiker es bearbeiten können. | 
Zeitaufwandschätzung |
-- | ---------------------------------------------------------------------------------- | -- 
| Task 1 | Erstellen einer Two-Choice-Frage "Have you eaten?". | 1 Stunde |

User Story 9  | Als Programmierer möchte ich, dass alle Informationen ausgewählt werden, bevor das Diagramm angezeigt wird. | 
Zeitaufwandschätzung |
-- | ---------------------------------------------------------------------------------- | -- 
| Task 1 | Anzeige einer Fehlermeldung.| 1 Stunde |

User Story 10  | Als Entwickler möchte ich ein einfach wartbares Programm damit alle Informatiker es bearbeiten können. | 
Zeitaufwandschätzung |
-- | ---------------------------------------------------------------------------------- | -- 
| Task 1 | Mehrere Klassen hinzufügen. | 1 Stunde |
| Task 2 | Logisches Design und liesbar.| 1 Stunde |

* ### __Tasklist__
Task | Zeitbedarf
------ | -------
Diagrammgleichung erstellen | 3 St
Startseite erstellen | 4 St
Personseite erstellen | 1 St
Alkohlseite erstellen | 1 St
Mengeseite erstellen | 1 St
Diagrammseite erstellen | 2 St
Design | 2 St
Testen | 3 St
   
* ## __Dokumentation wichtiger Code Snippets__

__showMainOverview()__
```
public void showMainOverview() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("views/MainOverview.fxml"));
			AnchorPane mainOverview = (AnchorPane) loader.load();
			
			MainOverviewController controller = loader.getController();
			controller.setMainApp(this);
			
			rootLayout.setCenter(mainOverview);
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
   ```
  Diese Methode zeigt die MainOverview (Startseite) in der Mitte unseres RootLayouts an.

__initialize()__

	@FXML
	private void initialize() {
		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
		
		alcoolNameColumn.setCellValueFactory(cellData -> cellData.getValue().alcoolNameProperty());
		degreeColumn.setCellValueFactory(cellData -> cellData.getValue().degreeProperty().asObject());
		
		selectedAlcoolColumn.setCellValueFactory(cellData -> cellData.getValue().alcoolNameProperty());
		quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());
		
		personTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		        alcoolTable.getSelectionModel().clearSelection();
		        selectedAlcoolTable.getSelectionModel().clearSelection();
		    }
		});
		
		alcoolTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		        personTable.getSelectionModel().clearSelection();
		        selectedAlcoolTable.getSelectionModel().clearSelection();
		    }
		});
		
		selectedAlcoolTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		        personTable.getSelectionModel().clearSelection();
		        alcoolTable.getSelectionModel().clearSelection();
		    }
		});
	}

Diese Methode ermöglicht es die gesamte MainOverview zu initialisieren. Die Spalten jeder Tabelle werden dann initialisiert. 

__getPersonData()__
```
public ObservableList<Person> getPersonData() {
        return personData;
    }
```
Mit dieser Methode kann man die Informationen, die eine Person gerade im Fenster "EditPersonDialog" eingegeben hat, erhalten und in der Personentabelle auflisten.
