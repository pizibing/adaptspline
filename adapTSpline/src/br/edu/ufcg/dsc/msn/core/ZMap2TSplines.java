package br.edu.ufcg.dsc.msn.core;

import java.util.ArrayList;
import java.util.Collection;

public class ZMap2TSplines {
	
	private double tolerance, omega, lastMax;
	public static final double NU = 0.2;
	public static final double MI = 0.9;
	
	public ZMap2TSplines(double tolerance, double omega) {
		this.tolerance = tolerance;
		this.omega = omega;
	}
	
	public TMesh create(ZMap map) {
		TMesh mesh = new TMesh();
		this.initialize(mesh, map);
		this.optimization(mesh, map);
		while(!this.check(mesh, map).isEmpty()) {
			this.refine(mesh, map);
			this.optimization(mesh, map);
		}
		return mesh;
	}
	
	private void refine(TMesh tMesh, ZMap zMap) {
		// TODO Auto-generated method stub
		
	}

	private Collection<Knot> check(TMesh tMesh, ZMap zMap) {
		Collection<Knot> errors = new ArrayList<Knot>();
		double currentMax = 0;
		for(int i = 0; i < zMap.width(); i++) {
			for(int j = 0; j < zMap.height(); j++) {
				double distance = Math.abs(tMesh.z((double)i, (double)j) - zMap.z(i, j));
				if( distance > this.tolerance) {
					errors.add(new Knot(i, j));
				}
				if (distance > currentMax) {
					currentMax = distance;
				}
			}
			if (lastMax - currentMax > MI) {
				double tmp = this.omega - NU;
				this.omega = tmp > 0 ? tmp : 0;
			}
		}
		return errors;
	}
	
	private void optimization(TMesh tMesh, ZMap zmap){
		
	}
	
	private void initialize(TMesh tMesh, ZMap zMap) {
		tMesh.add(new Knot(0, 0));
		tMesh.add(new Knot(0, 1));
		tMesh.add(new Knot(0, zMap.height()));
		tMesh.add(new Knot(0, zMap.height() + 1));
		tMesh.add(new Knot(1, 0));
		tMesh.add(new Knot(1, 1));
		tMesh.add(new Knot(1, zMap.height()));
		tMesh.add(new Knot(1, zMap.height() + 1));
		tMesh.add(new Knot(zMap.width(), 0));
		tMesh.add(new Knot(zMap.width(), 1));
		tMesh.add(new Knot(zMap.width(), zMap.height()));
		tMesh.add(new Knot(zMap.width(), zMap.height() + 1));
		tMesh.add(new Knot(zMap.width() + 1, 0));
		tMesh.add(new Knot(zMap.width() + 1, 1));
		tMesh.add(new Knot(zMap.width() + 1, zMap.height()));
		tMesh.add(new Knot(zMap.width() + 1, zMap.height() + 1));
	}

}
