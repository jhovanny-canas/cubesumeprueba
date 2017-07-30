package com.humanbpo.prueba.dto;

public class MatrixImpl implements matrix {

	private int[][][] matrix;
	private int suma;
	
	public MatrixImpl(int tamano)
	{
		this.matrix = new int[tamano][tamano][tamano];
		for (int i= 0; i < tamano; i++)
		{
			for (int j =0 ; j < tamano; j ++)
			{
				for (int k = 0; k < tamano; k ++){
					this.matrix[i][j][k]=0;
				}
			}
		}
		this.suma = 0;
	}
	
	
	public void update(String update)
	{
		String [] data = update.split(" ");
		int x = Integer.parseInt(data[0])-1;
		int y = Integer.parseInt(data[1])-1;
		int z = Integer.parseInt(data[2])-1;
		this.matrix[x][y][z] = Integer.parseInt(data[3]);
	}
	
	public void query(String query){
		this.suma=0;
		String [] data = query.split(" ");
		int dimenIniciouno = Integer.parseInt(data[0])-1;
		int dimenIniciodos = Integer.parseInt(data[1])-1;
		int dimenIniciotres = Integer.parseInt(data[2])-1;
		int dimenFinuno = Integer.parseInt(data[3])-1;
		int dimenFindos = Integer.parseInt(data[4])-1;
		int dimenFintres = Integer.parseInt(data[5])-1;
		
		for(int x = dimenIniciouno; x <=dimenFinuno; x ++){
			for(int y = dimenIniciodos; y <= dimenFindos; y ++){
				for (int z= dimenIniciotres; z<= dimenFintres; z++){
					this.suma += this.matrix[x][y][z];
				}
			}
		}
			
	}


	public int[][][] getMatrix() {
		return matrix;
	}


	public void setMatrix(int[][][] matrix) {
		this.matrix = matrix;
	}


	public int getSuma() {
		return suma;
	}


	public void setSuma(int suma) {
		this.suma = suma;
	}
	
}
