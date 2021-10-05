package dad.rubenpablo.buscaryreemplazar;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscaryReemplazar extends Application{
	

	// View
	private Label searchLabel;
	private Label replaceLabel;
	
	private TextField searchText;
	private TextField replaceText;
	
	private CheckBox caseCheck, regexpCheck, searchCheck, highlightCheck;
	
	private Button searchButton, replaceButton, replaceAllButton, closeButton, helpButton;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Elementos de la App
		searchLabel = new Label("Buscar:");
		replaceLabel = new Label("Reemplazar con:");
		searchText = new TextField();
		replaceText = new TextField();
		searchButton = new Button("Buscar");
		replaceButton = new Button("Reemplazar");
		replaceAllButton = new Button("Reemplazar todo");
		closeButton = new Button("Cerrar");
		helpButton = new Button("Ayuda");
		
		
		//
//		replaceLabel.setMinWidth(90);
		
		// Los botones deberán intentar alcanzar el tamaño máximo que puedan
		searchButton.setMaxWidth(Double.MAX_VALUE);
		replaceButton.setMaxWidth(Double.MAX_VALUE);
		replaceAllButton.setMaxWidth(Double.MAX_VALUE);
		closeButton.setMaxWidth(Double.MAX_VALUE);
		helpButton.setMaxWidth(Double.MAX_VALUE);
		
		caseCheck = new CheckBox("Mayúsculas y minúsculas");
		caseCheck.setMinWidth(200);
		
		regexpCheck = new CheckBox("Expresión regular");
		searchCheck = new CheckBox("Buscar hacia atrás");
		highlightCheck = new CheckBox("Resaltar resultados");
		
		// 
		
		// Box
		VBox botonera = new VBox(5, searchButton, replaceButton, replaceAllButton, closeButton, helpButton);
//		FlowPane botonera = new FlowPane(botonV);
		GridPane cheques = new GridPane();
		cheques.setVgap(5);
		cheques.setHgap(5);
		cheques.add(caseCheck, 0, 0);
		cheques.add(regexpCheck, 0, 1);
		cheques.add(searchCheck, 1, 0);
		cheques.add(highlightCheck, 1, 1);
		
		
		GridPane gp = new GridPane();
		gp.setVgap(5);
		gp.setHgap(5);
		gp.addRow(0, searchLabel, searchText);
		gp.addRow(1, replaceLabel, replaceText);
		
		
		
		gp.add(botonera, 2, 0);
		gp.add(cheques, 1, 2);
		GridPane.setRowSpan(botonera, 5);
		
		CheckBox gridCheck = new CheckBox("Mostrar líneas");
		gridCheck.setSelected(false);
		gp.gridLinesVisibleProperty().bind(gridCheck.selectedProperty());
		
		// Panel Raíz
		BorderPane root = new BorderPane(gp);
		root.setBottom(gridCheck);
		
		
		
		// Escena
		Scene escena = new Scene(root, 600, 480);
		
		// Stage
		primaryStage.setTitle("Buscar y Reemplazar");
		primaryStage.setScene(escena);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
