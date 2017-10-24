
package recipecatalog;
import javax.swing.JFrame;

/**
 * The main class that runs the whole application and creates the catalog object
 * @author Ndey awa
 */
public class RecipeCatalog extends JFrame{
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
        
        Catalog catalog = new Catalog();
        catalog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        catalog.setSize(500, 650);
        catalog.setVisible(true);
        
    }
    
}
