/**
   File:  Discussion7.java   
   Author:  Ji Ye (Eunice) Kim
   Class:  CMIS 141 6980
   Creation Date:  04/12/2021
   Description:  This program contains a class and method
*/
public class Discussion8 {

	public static class Thermometer{ // static class so  a static class can access only the static members of the outer class.
		
		//attribute
		public String season;
		public double high, low;
	
		// constructor to assign value to attribute
		public  Thermometer(String season, double high, double low) {
			this.season = season;
			this.high = high;
			this.low = low; 
		}	
		
		// class methods (actions or behaviors)
		
		public double getHighTempCelsius() { // compute High Temp in Celsius
			double cel = (high-32)*1.8;
			return cel; 	
		}
	
		public double getLowTempCelsius() { // compute Low Temp in Celsius
		    return ((low - 32)*1.8); 	
		}
	
		
		public double[] getTempCelsius(int h, int l) { // compute 2 Temps in Celsius
		    return new double[]{(h - 32)*1.8, (l - 32)*1.8}; 	
	    }
	
	}	
	
		
	public static void main (String[] args) {
		
		Thermometer season1 = new Thermometer ("Spring",58,55);
		Thermometer season2 = new Thermometer ("Summer",65,48);
		Thermometer season3 = new Thermometer ("Autumn",67,60);
		Thermometer season4 = new Thermometer ("Winter",68,63);
		
		System.out.println("For " + season1.season + ", your Thermometer is set at: "+ season1.high + " at highest, "+ season1.low + " at lowest");
		System.out.println("In Celsius, " + "season1.getHighTempCelsius()"+" at highest, " + "season1.getLowTempCelsius()" +" at lowest\n");
		
		System.out.println("For " + season2.season + ", your Thermometer is set at: "+ season2.high + " at highest, "+ season2.low + " at lowest\n");
		System.out.println("In Celsius, " + season1.getHighTempCelsius()+" at highest, " + season1.getLowTempCelsius() +" at lowest\n");	
		
		System.out.println("For " + season3.season + ", your Thermometer is set at: "+ season3.high + " at highest, "+ season3.low + " at lowest\n");
		System.out.println("In Celsius, " + season3.getHighTempCelsius()+" at highest, " + season3.getLowTempCelsius() +" at lowest\n");		
		
		System.out.println("For " + season4.season + ", your Thermometer is set at: "+ season4.high + " at highest, "+ season4.low + " at lowest\n");
		System.out.println("In Celsius, " + season4.getHighTempCelsius()+" at highest, " + season4.getLowTempCelsius() +" at lowest\n");		
		
		
	}		
}


