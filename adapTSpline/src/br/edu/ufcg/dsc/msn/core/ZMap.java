package br.edu.ufcg.dsc.msn.core;

public class ZMap implements IZMap {
	
	//TODO: Tem de ter um valor de passo, para qual a distância entre os 
	//pontos concecutivos
	
	private double[][] matrix;
	
	public ZMap(double[][] matrix) {
		this.matrix = matrix;
	}
	
	public ZMap(int width, int height) {
		this(new double[width][height]);
	}

	@Override
	public double z(int x, int y) {
		//Trocado para x representar a largura da tela e y a altura
		//TODO: Criar um esquema para poder aceitar valores negativos de x e y
		return this.matrix[y][x];
	}

	@Override
	public int height() {
		return this.matrix[0].length;
	}

	@Override
	public int width() {
		return this.matrix.length;
	}

}
