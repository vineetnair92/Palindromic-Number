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
	private double min=0,max=0;
	
	/*  Function to check input values
	 *  @param minInput lower bound number
	 *  @param maxInput higher bound number
	 *  @return boolean indicating if range is valid or not
	 */
	private boolean ValidateFields(TextField minInput, TextField maxInput ){
		double temp=0;
		boolean flag=true;
		
		try
		{
			minInput.setStyle(null);
			//get Values from minimum input field
			min= Double.parseDouble(minInput.getText());
			
		}
		catch(NumberFormatException ex)
		{		// error if not a number
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
			// error if not a number
			maxInput.setStyle("-fx-border-color:red");
			flag=false;		
		}

		//If range is negative, then no palindrome exist as -121 reverse would be 121-
		if(min<0 && max<0) {
			return false;
		}
		
		//Find lower and upper bounds
		if(min>max)	{
		temp=min;
		min=max;
		max=temp;
		}

		minInput.setText((long)min+"");
		maxInput.setText((long)max+"");
				 					
		return flag;
	 	}
	
	
	
	/* Function to build the grid layout
	 *  @param grid:  The grid object argument
	 *  @return grid object
	 */
	private GridPane BuildGrid(GridPane grid){
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
	private ArrayList<Node> addNodes(ArrayList<Node> nodes, GridPane grid){
		
		// Add Labels, TextFields and Button
		
		setLabelConstraints(nodes,"Lower Limit", 0, 0);
		TextField minInputField = new TextField();
		setTextFieldConstraints(nodes, minInputField, 1, 0);
		
		setLabelConstraints(nodes,"Maximum Limit", 0, 1);
		TextField maxInputField = new TextField();
		setTextFieldConstraints(nodes, maxInputField, 1, 1);
		
		setLabelConstraints(nodes,"Result", 0, 2);		
		TextField resultField = new TextField();
		
		//restrict result field from making user to enter values 
		resultField.setDisable(true);
		resultField.setOpacity(100);
		setTextFieldConstraints(nodes, resultField, 1, 2);
		
		Button search = new Button("Search");
		GridPane.setConstraints(search, 2, 3);
		nodes.add(search);

		return nodes;
		
	}
	
	
	/* Function to set Label to grid layout
	 * @param: nodes:  A List of nodes
	 * @param: labelName: string value representing label name
	 * @param: row:  integer representing row number
	 * @param: column:  integer representing column number
	 */
	private void setLabelConstraints(ArrayList<Node> nodes, String labelName, int row, int column) {
		Label label = new Label(labelName);
		GridPane.setConstraints(label, row, column);
		nodes.add(label);			
	}
	
	
	
	/* Function to set text field values to grid layout
	 * @param: nodes:  A List of nodes
	 * @param: tf:  TextField object
	 * @param: row:  integer representing row number
	 * @param: column:  integer representing column number
	 */	
	private void setTextFieldConstraints(ArrayList<Node> nodes, TextField tf, int row, int column) {
		GridPane.setConstraints(tf, row, column);
		nodes.add(tf);
	}
	
	
	/*
	 * Function to retrieve fields from UI.
	 * @param nodes:  The List that stores each UI component
	 */
	private void RetrieveValues(ArrayList<Node> nodes) {
		try
		{
			Button searchButton = (Button) nodes.get(6);
			TextField minInput = (TextField) nodes.get(1);
			TextField maxInput = (TextField) nodes.get(3);
			TextField result = (TextField) nodes.get(5);
		
			searchButton.setOnAction( clickEvent -> {
				if(ValidateFields(minInput,maxInput))
					displayPalindrome(result);
				else{
					//Display error message if the input values are not valid numbers
					result.setText("Invalid Values");
					result.setStyle("-fx-text-fill: red; -fx-font-size: 12; -fx-font-weight: bold;");
				}
			});
		}
		catch(ClassCastException ex)
		{
			System.out.println("Cast Exception");
		}
	}
	
	
	/*
	 * Function to find and display palindromic number 
	 * @param: result: a text field
	 */
	private void displayPalindrome(TextField result) {
		// Display the largest number if there exist one
		LargestPalindrome palindrome = new LargestPalindrome(min, max);
		result.setText(palindrome.findPalindrome()+"");
		if(result.getText().startsWith("No")) {
			result.setStyle("-fx-text-fill: red; -fx-font-size: 12; -fx-font-weight: bold;");						
		}
		else
			result.setStyle("-fx-text-fill: green; -fx-font-size: 12; -fx-font-weight: bold;");
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