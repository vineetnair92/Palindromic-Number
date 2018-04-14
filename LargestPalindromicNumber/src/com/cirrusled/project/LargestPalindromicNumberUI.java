package com.cirrusled.project;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import java.util.ArrayList;

public class LargestPalindromicNumberUI extends Application {
	
	/*	 Function to build the grid layout
	 * 
	 *  @param grid:  The grid object argument
	 *    @return grid object
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
		public ArrayList<Node> addNodes(ArrayList<Node> nodes, GridPane grid)
		{
		
			return nodes;
		}
		
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setTitle("Largest Palindromic Number- JavaFX Application");

		ArrayList<Node> nodes = new ArrayList<Node>();
		GridPane gp = new GridPane();
		gp = BuildGrid(gp);
		nodes = addNodes(nodes,gp);
		
		gp.getChildren().addAll(nodes);
		
		Scene scene= new Scene(gp, 500,500);
		primaryStage.setScene(scene);
		primaryStage.show();	
		}
	
	
	public static void main(String args[]) {
		launch(args);
	}
	
	}
 	