/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nkdvgdcheckerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author NicoleDillon
 */
public class CheckerBoard {
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private Color lightColor;
    private Color darkColor;
    private AnchorPane board;
    
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight) {
        this(numRows, numCols, boardWidth, boardHeight, Color.RED, Color.BLACK);
    }
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public Color getLightColor() {
        return lightColor;
    }
    
    public Color getDarkColor() {
        return darkColor;
    }
    
    public int getNumRows() {
        return numRows;
    }
    
    public int getNumCols() {
        return numCols;
    }
    
    public double getWidth() {
        return boardWidth;
    }
    
    public double getHeight() {
        return boardHeight;
    }
    
    public double getRectangleWidth() {
        return Math.ceil(boardWidth/numCols); 
    }
    
    public double getRectangleHeight() {
        return Math.ceil(boardHeight/numRows);
    }
    
    public AnchorPane build() {
        
        this.board = new AnchorPane();
        board.getChildren().clear();
        Color color;
        for (int row = 0; row < numRows; row++) {
            for (int column = 0; column < numCols; column++) {
                if (row%2 == 0 && column%2 == 0 || row%2 != 0 && column%2 != 0){
                    color = lightColor;
                }
                else {
                    color = darkColor;
                }
                
                Rectangle rect = new Rectangle(getRectangleWidth(), getRectangleHeight(), color);
                rect.setLayoutX(column * getRectangleWidth());
                rect.setLayoutY(row * getRectangleHeight());
      
                board.getChildren().add(rect);
            }
        }
        
        return board;
    }
    
    public AnchorPane getBoard(){
        if (board == null) {
            return null;
        }
        else {
            return build();
        }
    }
}
