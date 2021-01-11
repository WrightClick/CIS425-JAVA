/**
 * @author Matt Wright
 * Goal: Write a class to store tax amounts and calculate
 * a final product cost based off of the tax rate.
 * Implementation: A TaxWhiz class, a main method and a receipt printing
 * 		function.
 */
package edu.buffalostate.cis425.fa19.exercises.wright;
import static java.lang.System.*;
import java.text.NumberFormat;

public class TaxWhiz {
    private double taxRate;

    //default constructor
    public TaxWhiz(){
        this.taxRate = 0;
    }
    //parameter constructor
    public TaxWhiz(double rate){
        this.taxRate = rate / 100;
    }
    /**
     * @param newRate -- new tax rate
     * Changes tax rate by incrementing
     */
    public void changeTax(double rateChange){
        this.taxRate += rateChange / 100;
    }
    /**
     * @param productCost -- cost of the product to determine tax for
     * @return the tax amount
     */
    public double calcTax(double productCost) {
        return this.taxRate * productCost;
    }

//--------------------------------------------------------------------------------
// MAIN METHOD
//--------------------------------------------------------------------------------
    
    /**
     * @param args
     * Creates two TaxWhiz objects to store tax rates, creates a number format for currency object,
     * declares the cost of two items and passes it all to a reciept printing function. After this,
     * the tax rates are changed and everything is passed again to repreint a new receipt.
     */
    public static void main(String args[]){
    	
    	//Creates two new TaxWhiz objects and uses constructor to set taxRate
    	TaxWhiz taxRateOne = new TaxWhiz(8.75);
    	TaxWhiz taxRateTwo = new TaxWhiz(4.75);
    	
    	NumberFormat currency = NumberFormat.getCurrencyInstance();
    	
    	double appleCost = 4.99;
    	double jacketCost = 89.99;
    	
    	//prints receipt with original tax rates of 8.75 and 4.75
    	printReciept(taxRateOne, taxRateTwo, currency, appleCost, jacketCost);
    	
    	//increments each tax rate by 1%.
    	taxRateOne.changeTax(1);
    	taxRateTwo.changeTax(1);
    	
    	out.println("NEW TAX RATE\n\n");
    	
    	//prints new receipt with new tax rates of 9.75 and 5.75
    	printReciept(taxRateOne, taxRateTwo, currency, appleCost, jacketCost);
    	
    }//end main
    
    
//--------------------------------------------------------------------------------
// RECIEPT PRINTING FUNCTION
//--------------------------------------------------------------------------------
    /**
     * @param taxRateOne - TaxWhiz object carrying taxRate attribute for calculation
     * @param taxRateTwo - TaxWhiz object carrying taxRate attribute for calculation
     * @param currency - NumberFormat getCurrencyInstance() object for formatting
     * @param appleCost - base cost of the apple for calculation
     * @param jacketCost - base cost of the jacket for calculation
     */
    public static void printReciept(TaxWhiz taxRateOne, TaxWhiz taxRateTwo, NumberFormat currency, double appleCost, 
    		double jacketCost) {
    	
    	//calculates all of the amounts, sums them then formats with a currency format
    	String total = 
    			currency.format((appleCost + taxRateOne.calcTax(appleCost)) 
    			+ (jacketCost + taxRateTwo.calcTax(jacketCost)));
    	
    	//joins all of the variables together to calculate and print cost, tax and total
    	String receipt = 
    			"\n--------------------------------\n"
    			+ "Clerk:\tJoel\n--------------\n"
    			+ "\nItem: Apples 12oz\tCost: " + currency.format(appleCost) + "\tTax: " 
    				+ currency.format(taxRateOne.calcTax(appleCost))
    				+ "\tItem Total: " + currency.format(appleCost + taxRateOne.calcTax(appleCost))
    			+ "\nItem: Jacket\t\tCost: " + currency.format(jacketCost) + "\tTax: " 
    				+ currency.format(taxRateTwo.calcTax(jacketCost))
    				+ "\tItem Total: " + currency.format(jacketCost + taxRateTwo.calcTax(jacketCost))
    			+ "\n\nSubotal:\t" + currency.format(appleCost + jacketCost)
    			+ "\nTotal Tax:\t" + currency.format(taxRateOne.calcTax(appleCost) + taxRateTwo.calcTax(jacketCost))
    			+ "\nTotal:\t\t" + total
    			+ "\n\nThank you, have a nice day!\n--------------------------------\n\n";
    	
    	//prints original receipt
    	out.println(receipt);
    }

}//end TaxWhiz class