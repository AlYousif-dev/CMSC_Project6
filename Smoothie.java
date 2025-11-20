
public class Smoothie extends Beverage {
	private int fruits;
	private boolean protein;
	
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
		super(bevName,Type.SMOOTHIE,size);
		fruits = numOfFruits;
		protein = addProtein;
	}
	
	public int getNumOfFruits() {
		return fruits;
	}
	
	public boolean getAddProtein() {
		return protein;
	}
	
	public double calcPrice() {
		if (protein) {
			return BASE_PRICE + addSizePrice() + 1.50 + 0.5 * fruits;
		}
		return BASE_PRICE + addSizePrice() + 0.5 * fruits;
	}
	
	@Override 
	public String toString() {
		return super.toString() + ", Fruits: " + fruits + ", Protein: " + protein + ", Price: " + calcPrice();
	}
	
	@Override
	public boolean equals(Object other) {
		if(!(super.equals(other))) {
			return false;
		}
		else if (!(other instanceof Smoothie)) {
			return false;
		}
		Smoothie otherSmoothie = (Smoothie) other;
		return(fruits == otherSmoothie.fruits && protein == otherSmoothie.protein);
	}
	
}
