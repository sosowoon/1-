package bean;

public class SellCategoriesDTO {
	private String sellCategoryName;
	private double sellAmountPercentage;
	public String getSellCategoryName() {
		return sellCategoryName;
	}
	public void setSellCategoryName(String sellCategoryName) {
		this.sellCategoryName = sellCategoryName;
	}
	public double getSellAmountPercentage() {
		return sellAmountPercentage;
	}
	public void setSellAmountPercentage(double sellAmountPercentage) {
		this.sellAmountPercentage = sellAmountPercentage;
	}
}
