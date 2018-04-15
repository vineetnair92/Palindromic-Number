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
	
	/*  Function to check input values
	 *  @param minInput lower bound number
	 *  @param maxInput higher bound number
	 *  @return boolean indicating if range is valid or not
	 */
	public boolean ValidateFields(TextField minInput, TextField maxInput ){

		double min=0,max=0;
		boolean flag=true;
		
		try
		{
			minInput.setStyle(null);
			//get Values from minimum input field
			min= Double.parseDouble(minInput.getText());
			
		}
		catch(NumberFormatException ex)
		{
				minInput.setStyle("-fx-border-color:red");
				flag=false;
		}

		try
		{
			maxInput.setStyle(null);	
			//get Value from maximum input field
			max= Double.parseDouble(maxInput.getText());
		}
		catch(NumberFormatException e)
		{
			maxInput.setStyle("-fx-border-color:red");
			flag=false;		
		}

		if(min<0 && max<0) {
			return false;
		}
		//Find lower and upper bounds
		if(max>min)	{
			minInput.setText((long)min+"");
			maxInput.setText((long)max+"");
		}
		else{
			minInput.setText((long)max+"");
			maxInput.setText((long)min+"");
		}
				 					
		return flag;
	 	}
	

	
	
	/* Function to build the grid layout
	 * 
	 *  @param grid:  The grid object argument
	 *  @return grid object
	 */
	public GridPane BuildGrid(GridPane grid){
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
	
	
	
	/*
	 * Function to retrieve fields from UI.
	 * 	 
	 * @param nodes:  The List that stores each UI component
	 */
	public void RetrieveValues(ArrayList<Node> nodes) {
		try
		{
			Button searchButton = (Button) nodes.get(6);
			TextField minInput = (TextField) nodes.get(1);
			TextField maxInput = (TextField) nodes.get(3);
			TextField result = (TextField) nodes.get(5);
		
			searchButton.setOnAction( clickEvent -> 
			{
				if(ValidateFields(minInput,maxInput))
				{
					//TODO: Get Palindromic Number
					result.setText("");
				}
				else
				{
					result.setText("Invalid Values");
					result.setStyle("-fx-text-fill: red; -fx-font-size: 16; -fx-font-weight: bold;");
				}
			});
		}
		catch(ClassCastException ex)
		{
			System.out.println("Cast Exception");
		}
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
		
		//Get values from input fields
		RetrieveValues(nodes);
		
		//Display
		Scene scene= new Scene(gp, 500,500);
		primaryStage.setScene(scene);
		primaryStage.show();	
	
	}
	

	
	/*Main function
	 * @param args: an Array of command line arguments
	 */
	public static void main(String args[]) {
		launch(args);
	}
		
}