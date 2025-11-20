
public abstract class Beverage {
	private String bevName;
	private Type type;
	private Size size;
	protected static final double BASE_PRICE = 2.0;
	protected static final double SIZE_PRICE = 0.5;
	
	public Beverage(String bevName, Type type, Size size) {
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	
	public String getBevName() {
		return bevName;
	}
	
	public void setBevName(String s) {
		bevName = s;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type t) {
		type = t;
	}
	
	public Size getSize() {
		return size;
	}
	
	public void setSize(Size s) {
		size = s;
	}
	
	public double addSizePrice() {
		if (this.size == Size.MEDIUM) {
			return SIZE_PRICE;
		}
		else if (this.size == Size.LARGE) {
			return SIZE_PRICE + SIZE_PRICE;
		}
		else {
			return 0.0;
		}
	}
	
	public abstract double calcPrice();
	
	@Override
	public String toString() {
		return String.format("%s, %s", bevName, size.toString());
	}
	
	@Override 
	public boolean equals(Object other) {
		if(other == null) {
			return false;
		}
		else if(!(other instanceof Beverage)) {
			return false;
		}
		Beverage otherBev = (Beverage) other;
		return (bevName.equals(otherBev.bevName) && type == otherBev.type && size == otherBev.size);
		
	}
	
	
	
	
	
}
