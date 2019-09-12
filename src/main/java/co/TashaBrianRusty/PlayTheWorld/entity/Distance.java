package co.TashaBrianRusty.PlayTheWorld.entity;

import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GeodeticCurve;
import org.gavaghan.geodesy.GlobalCoordinates;

public class Distance {

	GeodeticCalculator geoCalc = new GeodeticCalculator();
	Ellipsoid reference = Ellipsoid.WGS84;
	GlobalCoordinates origin = new GlobalCoordinates(42.3356398, -83.0502464);
	GlobalCoordinates destination = new GlobalCoordinates(42.3667297, -71.0150276);
	GeodeticCurve geoCurve = geoCalc.calculateGeodeticCurve(reference, origin, destination);
	double output = geoCurve.getEllipsoidalDistance() / 1000.0;
	
	public Distance() {
		super();
	}

	public Distance(GeodeticCalculator geoCalc, Ellipsoid reference, GlobalCoordinates origin,
			GlobalCoordinates destination, GeodeticCurve geoCurve, double output) {
		super();
		this.geoCalc = geoCalc;
		this.reference = reference;
		this.origin = origin;
		this.destination = destination;
		this.geoCurve = geoCurve;
		this.output = output;
	}

	public Distance(double lat1, double lon1, double lat2, double lon2) {
		this.origin = new GlobalCoordinates(lat1, lon1);
		this.destination = new GlobalCoordinates(lat2, lon2);
	}

	public double getOutput() {
		return output;
	}

	public void setOutput(double output) {
		this.output = output;
	}
}
