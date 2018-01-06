import java.util.ArrayList;

/**
 * @author Muhammad Fiaz and Sharod Celestin 
 * The items class is used to generate and perform action on object items.
 *
 */

public class Items {
	
	
	/**
	 * @param aName  to name the item present in the itemName field.
	 * @param aDescription to describe the items present in itemDescription field.
	 */
	public Items(String aName,String aDescription) {
		this.itemName = aName;
		this.itemDescription = aDescription;
	}
		
		/**A setter for the item name which will use 
		 * @param itemN to store the item.
		 */
		public void setItemName(String itemN) {
			itemName = itemN;
		}
		
    /**A getter for the item name which will use 
     * @return to return the names of the item present in the field.
     */
    /**This method 
     * @return the item name
     */
    public String getItemName() {
	return itemName;
	
}
    /**this method uses
     * @param itemD to give the description of the item.
     */
    public void setItemDescription(String itemD) {
    	itemName = itemD;
    }
    /**This method 
     * @return the description.
     */
    public String getItemDescription() {
    	return itemDescription;
    }

	/**A protected field for the item name because it will be used in Player and Room class as well.
	 * A private field for item description.
	 */
	protected String itemName;
	private String itemDescription;
}