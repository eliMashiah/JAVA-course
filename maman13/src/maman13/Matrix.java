package maman13;
/**
 * This class Represents information about a Matrix
 * @author Eliyahu Mashiah
 *@version 11.12.2018
 */
public class Matrix {

	private int [] [] _matrix;
	
	/**
	 * Constructs a Matrix for a two-dimensional array the  dimensions as well as the values of this Matrix will be the same as the dimensions and values of the given two-dimensional array. 
	 * @param array two-dimensional array with a random size and values which will be used to construct the matrix
	 */
	public Matrix(int [] [] array)
	{
		_matrix=new int [getRows(array)][getColumns(array)];//duplicate the given array size to _matrix
		
		for (int i=0; i<getRows(_matrix); i++ )//row counter
		{
	        for (int j = 0; j < getColumns(_matrix); j++)//column counter
	        {
	        	_matrix[i][j]=array[i][j];//fills _matrix array with the "array" array values
	        }
		}
	}
	
	/**
	 * Constructs a size1 by size2 Matrix of zeroes. 
	 * @param size1 The number of rows in the array
	 * @param size2 The number of columns in the array
	 */
	public Matrix(int size1, int size2)
	{
    _matrix= new int[size1][size2];//constructs a two dimensional array using the given sizes; 
    
    for (int i = 0; i < size1; i++)//row counter
    {
        for (int j = 0; j < size2; j++)//column counter
        {
            _matrix[i][j] = 0;//fills _matrix array with 0
        }
    }
    
	}
	/**
	 * Returns a string representation of Matrix.
	 * @return A String representation of the Matrix
	 */
	public String toString()
	{
		String s="";
		for (int i=0; i<getRows(_matrix); i++)//row counter
		{
			for (int j=0; j<getColumns(_matrix); j++)//column counter
			{
				s+=_matrix[i][j];
				if(j<getColumns(_matrix)-1)//checks if it's the last column of the row if true it doesn't print a tab 
				{
					s+="\t";
				}
			}
			s+="\n";//prints a new line in the end of a row. 
		}
		return s;//returns the string representation of the matrix
	}
	
	/**
	 * returns the matrix fliped horizontally 
	 * @return a new matrix flipped horizontally 
	 */
	public Matrix flipHorizontal()
	{
		int [] [] matrix= copyMatrix();//copies the original matrix
		int temp;
        for (int i = 0; i < getColumns(matrix)/2; i++)//column counter
        {
            for (int j = 0; j < getRows(matrix); j++)//row counter
            {
            	temp = matrix[j][i];//saves the original value of the cell 
            	matrix[j][i] = matrix[j][getColumns(matrix) - i - 1];//puts the value of the cell in the horizontal reflecting cell  
            	matrix[j][getColumns(matrix) - i - 1] = temp;//sets the value of the reflecting cell to original cell's value
            }
        }
 
        return new Matrix(matrix);

	}
	
	/**
	 * returns the matrix fliped vertically 
	 * @return a new matrix flipped vertically 
	 */
	public Matrix flipVertical()
	{
		int [] [] matrix= copyMatrix();//copies the original matrix
		int temp;
        for (int i = 0; i < getRows(matrix)/2; i++)//row counter
        {
            for (int j = 0; j < getColumns(matrix); j++)//column counter
            {
            	temp = matrix[i][j];//saves the original value of the cell 
            	matrix[i][j] = matrix[getRows(matrix) - i - 1][j];//puts the value of the cell in the vertical reflecting cell
            	matrix[getRows(matrix) - i - 1][j] = temp;//sets the value of the reflecting cell to original cell's value
            }
        }
 
        return new Matrix(matrix);

	}
	
	/**
	 * Rotates the matrix clockwise
	 * @return a new matrix after being rotated clockwise
	 */
	public Matrix rotateClockwise()
	{
		
		int [] [] originalMatrix= copyMatrix();//copies the original matrix
		int [] [] clockwiseMatrix= new int [getColumns(originalMatrix)][getRows(originalMatrix)];//creates a new array size columns*rows of the original matrix 
		for (int i = 0; i < getColumns(clockwiseMatrix); i++)//columns counter of the new matrix
		{
			for (int j = 0; j <  getRows(clockwiseMatrix); j++)//rows counter of the new matrix
			{
					clockwiseMatrix[j][getColumns(clockwiseMatrix)-1-i]=originalMatrix[i][j];////puts the value of the cell in the clockwise index of the rotated clockwise matrix
			}
			
		}
		
		return new Matrix(clockwiseMatrix);
	}
	
	/**
	 * Rotates the matrix counter clockwise
	 * @return a new matrix after it has been rotated counter clockwise
	 */
	public Matrix rotateCounterClockwise()
	{
		
		int [] [] originalMatrix= copyMatrix();//copies the original matrix
		int [] [] counterClockwiseMatrix= new int [getColumns(originalMatrix)][getRows(originalMatrix)];//creates a new array size columns*rows of the original matrix 
		for (int i = 0; i < getColumns(counterClockwiseMatrix); i++)//columns counter of the new matrix
		{
			for (int j = 0; j <  getRows(counterClockwiseMatrix); j++)//rows counter of the new matrix
			{
					counterClockwiseMatrix[getRows(counterClockwiseMatrix)-1-j][i]=originalMatrix[i][j];///puts the value of the cell in the counter clockwise index of the rotated counter clockwise matrix
			}
			
		}
		
		return new Matrix(counterClockwiseMatrix);
	}
	
	private int getRows(int [] [] array)//a method which returns the rows of an array 
	{
		int rows=array.length;
		return rows;
	}
	
	private int getColumns(int [] [] array)//a method which returns the columns of an array  
	{
		int columns=array[0].length;
		return columns;
	}
	
	
	private int [] [] copyMatrix()//a method which copies _matrix
	{
	    int [][] copyMatrix= new int [getRows(_matrix)] [getColumns(_matrix)];
	    for(int i = 0; i< getRows(_matrix); i++){
	        for (int j = 0; j < getColumns(_matrix); j++){
	           	copyMatrix[i][j] = _matrix[i][j];
	        }
	    }
	    return copyMatrix;
	}
}//end class
