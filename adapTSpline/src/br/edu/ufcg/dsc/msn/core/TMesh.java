package br.edu.ufcg.dsc.msn.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TMesh {
	
	private List<Knot> knotsInS;
	
	public TMesh() {
		this.knotsInS = new ArrayList<Knot>();
	}
	
	public void add(Knot knot) {
		Iterator<Knot> i = knotsInS.iterator();
		int pos = 0;
		while(i.hasNext()) {
			if(i.next().getS() < knot.getS())
				pos++;
			else break;
		}
		this.knotsInS.add(pos, knot);
	}

	public double z(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<Knot> boundingBox(Knot knot) {
		List<Knot> square = new ArrayList<Knot>();
		if(!this.knotsInS.isEmpty()) {
			Knot p1, p2, p3, p4;
			Iterator<Knot> i = this.knotsInS.iterator();
			p1 = p2 = p3 = p4 = i.next();
			while(i.hasNext()) {
				
			}
			square.add(p1);
			square.add(p2);
			square.add(p3);
			square.add(p4);
		}
		return square;
	}


}
