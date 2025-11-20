
public class Coffee extends Beverage {
	private boolean xtShot;
	private boolean xtSyrup;
	
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		super(bevName,Type.COFFEE,size);
		xtShot = extraShot;
		xtSyrup = extraSyrup;
	}
	
	public boolean getExtraShot() {
		return xtShot;
	}
	
	public boolean getExtraSyrup() {
		return xtSyrup;
	}
	
	public double calcPrice() {
		if (xtShot && xtSyrup) {
			return BASE_PRICE + addSizePrice() + 1.0;
		}
		else if (xtShot || xtSyrup) {
			return BASE_PRICE + addSizePrice() + 0.5;
		}
		return BASE_PRICE + addSizePrice();
	}
	
	@Override 
	public String toString() {
		return super.toString() + ", Extra Shot: " + xtShot + ", Extra Syrup: " + xtSyrup + ", Price: " + calcPrice();
	}
	
	@Override
	public boolean equals(Object other) {
		if(!(super.equals(other))){
			return false;
		}
		else if(!(other instanceof Coffee)) {
			return false;
		}
		Coffee otherCoffee = (Coffee) other;
		return xtShot == otherCoffee.xtShot && xtSyrup == otherCoffee.xtSyrup;
	}
}