package br.edu.ufcg.dsc.msn.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import br.edu.ufcg.dsc.msn.core.IZMap;
import br.edu.ufcg.dsc.msn.core.ZMapByFileConstructor;


public class TSplineTests {
	
	@Test
	public void test_ZMapCreation1() throws Exception {
		IZMap m = new ZMapByFileConstructor().create("maps/plano.txt");
		assertEquals(10, m.width());
		assertEquals(10, m.height());
		for(int x = 0; x < m.width(); x++) {
			for(int y = 0; y < m.height(); y++) {
				assertEquals(5.0, m.z(x, y), 1e-3);
			}
		}
	}
	
	@Test
	public void test_ZMapCreation2() throws Exception {
		IZMap m = new ZMapByFileConstructor().create("maps/ladeira1.txt");
		assertEquals(5, m.width());
		assertEquals(10, m.height());
		for(int x = 0; x < m.width(); x++) {
			for(int y = 0; y < m.height(); y++) {
				assertEquals(((double)10 - y), m.z(x, y), 1e-3);
			}
		}
	}

	@Test
	public void test_ZMapCreation3() throws Exception {
		IZMap m = new ZMapByFileConstructor().create("maps/ladeira2.txt");
		assertEquals(10, m.width());
		assertEquals(5, m.height());
		for(int x = 0; x < m.width(); x++) {
			for(int y = 0; y < m.height(); y++) {
				assertEquals(((double)10 - x), m.z(x, y), 1e-3);
			}
		}
	}
	
	@Test
	public void test_ZMap2TSpline1() throws Exception {
		
	}

}
