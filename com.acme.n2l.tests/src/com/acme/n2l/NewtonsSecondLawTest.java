package com.acme.n2l;

import static org.junit.Assert.assertEquals;

import org.eclipse.uomo.units.SI;
import org.eclipse.uomo.units.impl.quantity.AccelerationAmount;
import org.eclipse.uomo.units.impl.quantity.ForceAmount;
import org.eclipse.uomo.units.impl.quantity.MassAmount;
import org.eclipse.uomo.units.impl.system.USCustomary;
import org.junit.Test;
import org.unitsofmeasurement.quantity.Acceleration;
import org.unitsofmeasurement.quantity.Force;
import org.unitsofmeasurement.unit.Unit;

public class NewtonsSecondLawTest {

	@Test
	public void testCalculateForce() {
		MassAmount m = new MassAmount(1000, SI.KILOGRAM);
		AccelerationAmount a = new AccelerationAmount(2.5, SI.METRES_PER_SQUARE_SECOND);
		ForceAmount force = NewtonsSecondLaw.calculateForce(m, a);
		assertEquals(2500, force.doubleValue(SI.NEWTON), 0.0001);
	}
	
	@Test
	public void testWithOddUnits() {
		MassAmount m = new MassAmount(100, USCustomary.POUND);
		@SuppressWarnings("unchecked") // we know this creates an acceleration!
		Unit<Acceleration> inch_per_square_second = (Unit<Acceleration>)USCustomary.INCH.divide(SI.SECOND).divide(SI.SECOND);
		System.out.println(inch_per_square_second);
		AccelerationAmount a = new AccelerationAmount(100, inch_per_square_second);
		ForceAmount force = NewtonsSecondLaw.calculateForce(m, a);
		assertEquals(867961.6621451874, force.doubleValue(SI.NEWTON), 0.0000000001);
		// Pound-force (http://en.wikipedia.org/wiki/Pound-force) is a unit for Force in English engineering units and British gravitational units 
		Unit<Force> poundForce = SI.NEWTON.multiply(4.448222);
		assertEquals(3860886.16071079, force.doubleValue(poundForce), 0.0000000001);				
	}
	
}
