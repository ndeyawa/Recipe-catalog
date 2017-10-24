
package recipecatalog;
import javax.swing.Icon;
/**
 *Implements a Dish that goes later in the dishes array list such as Domoda, Benachin etc.
 * @author Ndey awa
 */
public class Dish {
    
    //instances
    private String name;
    private String data;
    private Icon icon;
    
    /**
     *Implements Constructor
     * @param n name of recipe
     * @param d
     * @param i
     */
    public Dish(String n,String d, Icon i){
       name = n;
       data = d;
       icon = i;
    }
    
    /**
     *
     * @return name of recipe
     */
    public String getName(){
        return name;
    }
    
    /**
     *
     * @return recipe description
     */
    public String getData(){
        return data;
    }
    
    public Icon getIcon(){
        
        return icon;
    }
    
}
