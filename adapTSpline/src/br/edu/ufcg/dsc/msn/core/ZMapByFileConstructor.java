package br.edu.ufcg.dsc.msn.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ZMapByFileConstructor {
	
	private int width, height;
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public ZMap create(String path) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File(path));
		String id = sc.nextLine(); //ler a linha do arquivo que descreve que é um ZMap no nosso formato
		this.width = sc.nextInt();
		this.height = sc.nextInt();
		sc.nextLine();
		double matrix[][] = new double[this.width][this.height];
		for(int i = 0; i < matrix.length; i++) {
			String line = sc.nextLine();
			Scanner liner = new Scanner(line);
			for(int j = 0; j < matrix[0].length; j++) {
				double d = liner.nextDouble();
				matrix[i][j] = d; 
			}
		}
		
		return new ZMap(matrix);
	}

}
