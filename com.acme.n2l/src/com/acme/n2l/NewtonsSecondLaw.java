package com.acme.n2l;

import org.eclipse.uomo.units.SI;
import org.eclipse.uomo.units.impl.quantity.AccelerationAmount;
import org.eclipse.uomo.units.impl.quantity.ForceAmount;
import org.eclipse.uomo.units.impl.quantity.MassAmount;

public class NewtonsSecondLaw {

	public static final ForceAmount calculateForce(MassAmount m, AccelerationAmount a) {
		double m_kg = m.doubleValue(SI.KILOGRAM);
		double a_si = a.doubleValue(SI.METRES_PER_SQUARE_SECOND);
		
		return new ForceAmount(m_kg * a_si, SI.NEWTON);
	}
}
