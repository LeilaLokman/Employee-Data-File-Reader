/**
 * Class used to get the data from the file to represent a country and its attributes.
 * 
 * @author Leila Lokman
 * @version 10/27/2023
 */
public class Country {
private String name;
private String capital;
private long population;
private double GDP;
private long area;
private double happinessIndex;

/**
 * Constructor to initialize a Country object with provided attributes.
 * 
 * @param name           Name of the country
 * @param capital        Capital city of the country
 * @param population     Population of the country
 * @param GDP            Gross Domestic Product of the country
 * @param area           Area of the country
 * @param happinessIndex Happiness Index of the country
 */
public Country(String name, String capital, long population, double GDP, long area, double happinessIndex) {
    this.name = name;
    this.capital = capital;
    this.population = population;
    this.GDP = GDP;
    this.area = area;
    this.happinessIndex = happinessIndex;
}

public Country(String name2, String capital2, double gdppc, double apc, double happinessIndex2) {
	// TODO Auto-generated constructor stub
}

/**
 * @return the countryName
 */
public String getCountryName() {
	return name;
}
/**
 * @param countryName the countryName to set
 * @return void
 */
public void setCountryName(String countryName) {
	this.name = countryName;
}
/**
 * @return the capitol
 */
public String getCapital() {
	return capital;
}
/**
 * @param capitol the capitol to set
 * @return void
 */
public void setCapitol(String capital) {
	this.capital = capital;
}
/**
 * @return the population
 */
public long getPopulation() {
	return population;
}
/**
 * @param population the population to set
 * @return void
 */
public void setPopulation(int population) {
	this.population = population;
}
/**
 * @return the GDP
 */
public double getGDP() {
	return GDP;
}
/**
 * @param GDP the GDP to set
 * @return void
 */
public void setGDP(int gDP) {
	GDP = gDP;
}
/**
 * @return the area
 */
public long getArea() {
	return area;
}
/**
 * @param area the area to set
 * @return void
 */
public void setArea(int area) {
	this.area = area;
}
/**
 * @return the hapinessIndex
 */
public double getHappinessIndex() {
	return happinessIndex;
}
/**
 * @param happinessIndex 
 * @paramhappinessIndex the hapinessIndex to set
 * @return void
 */
public void setHappinessIndex(double happinessIndex) {
	this.happinessIndex = happinessIndex;
}

}