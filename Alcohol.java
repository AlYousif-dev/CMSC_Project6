
public class Alcohol extends Beverage {
	private boolean weekend; 
	
	public Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName, Type.ALCOHOL, size);
		weekend = isWeekend;
	}
	
	public boolean isWeekend() {
		return weekend;
	}
	
	public double calcPrice() {
		if (weekend) {
			return BASE_PRICE + addSizePrice() + 0.6;
		}
		return BASE_PRICE + addSizePrice();
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Weekend: " + weekend + ", Price: " + calcPrice();
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(super.equals(other))) {
			return false;
		}
		else if (!(other instanceof Alcohol)) {
			return false;
		}
		Alcohol otherAlc = (Alcohol) other;
		return (weekend == otherAlc.weekend);
	}
}
