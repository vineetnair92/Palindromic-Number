package com.cirrusled.project;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;


import java.util.ArrayList;

public class LargestPalindromicNumberUI extends Application {
	
	/* Function to build the grid layout
	 * 
	 *  @param grid:  The grid object argument
	 *  @return grid object
	 */
	public GridPane BuildGrid(GridPane grid)
		{
			grid.setPadding(new Insets(20, 20, 20, 20));
			grid.setVgap(30);
			grid.setHgap(30);		
			return grid;
		}
				
	
	/*
	 * Function to add elements to grid.
	 * 	 
	 * @param nodes:  The List to store the each element.
	 * @param grid:   The grid object 
	 * @return List with UI components
	 */
	public ArrayList<Node> addNodes(ArrayList<Node> nodes, GridPane grid){
		
		// Add Labels, TextFields and Button
		Label minLimit = new Label("Lower Limit");
		grid.setConstraints(minLimit, 0, 0);
		nodes.add(minLimit);			
		TextField minInputField = new TextField();
		grid.setConstraints(minInputField, 1, 0);
		nodes.add(minInputField);
					
		Label maxLimit = new Label("Maximum Limit");
		grid.setConstraints(maxLimit, 0, 1);
		nodes.add(maxLimit);
		
		TextField maxInputField = new TextField();
		grid.setConstraints(maxInputField, 1, 1);
		nodes.add(maxInputField);
		
		Label result = new Label("Result");
		grid.setConstraints(result, 0, 2);
		nodes.add(result);
		
		TextField resultField = new TextField();
		grid.setConstraints(resultField, 1, 2);
		resultField.setDisable(true);
		nodes.add(resultField);
		
		Button search = new Button("Search");
		grid.setConstraints(search, 2, 3);
		nodes.add(search);

		return nodes;
		
	}
		
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setTitle("Largest Palindromic Number- JavaFX Application");

		ArrayList<Node> nodes = new ArrayList<Node>();
		GridPane gp = new GridPane();
		
		// Get grid layout
		gp = BuildGrid(gp);	
		//Get UI components
		nodes = addNodes(nodes,gp);
		//Add all the UI Components to the grid
		gp.getChildren().addAll(nodes);
		
		//Display
		Scene scene= new Scene(gp, 500,500);
		primaryStage.setScene(scene);
		primaryStage.show();	
		}
	
	
	public static void main(String args[]) {
		launch(args);
	}
	
	}
 	