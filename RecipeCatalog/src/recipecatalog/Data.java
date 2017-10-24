
package recipecatalog;

import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 *
 * @author Ndey awa
 */
public class Data {
    
    //Dish names
    private String benachin,domoda,chukong,supakanja,mbahal;
    //Ingredients
    private String benachinIng,domodaIng,chukongIng,supakanjaIng,mbahalIng;
    //Instructions
    private String benachinIns,domodaIns,chukongIns,supakanjaIns,mbahalIns;
    //images
    private Icon benachinIcon,domodaIcon,chukongIcon,supakanjaIcon,mbahalIcon;
    
    public Data(){
        
        //benachine
        benachin = "Bena Chin";
      
        benachinIng = "Rice,Fish,Oil,Pepper,Black Pepper,Tomato Paste,Garlic,"
                + "Laurier,Persi,Jumbo,Aja,Onion,Dry Fish,Cray Fish,Tomato,Bitter Tomato"
                + "Cabbage,Garden Egg,Carrot,Dahar Sauce,Naweh";
        
        benachinIns = "Pound black pepper + pepper + garlic + onion,Stuck all that into the fish,"
                + "Fry the fish, Then fry the tomato paste + onions + garlic,Fry until it is brown,"
                + "Add water + salt and make the water is enough to cook the rice,When it boils put the vegetables,"
                + "Put the fish,Remove the vegs and the fish when they are cooked,Wash the rice and steam it,"
                + "Then put the black pepper + laurier + garlic + onion + jumbo and guwaana";
        
        benachinIcon = new ImageIcon(getClass().getResource("red-rice.png"));
        
        //domoda
        domoda = "Domoda";
        
        domodaIng = "Peanut butter, Meat,Tomato paste, Tomatoes, Lemon, Netetu,Guwaana pepper,Black pepper,Onion leaves,Jumbo,"
        		+ "Bitter tomato, Garden egg, Salt";
        
        domodaIns = "Wash and cut meat into bite size and add salt to it,Mix Peanut butter and tomatoes with water and add to the cooking pan,When it boils add the meat,"
        		+ "Pound Black pepper + Netetu + Lautier + Onion leaves and add to the cooking pan,Then add the vegetables + allow it to boil for 30 mins,and stir occasionally + simmer for 45 mins,"
        		+ "cook white rice apart";
        domodaIcon = new ImageIcon(getClass().getResource("domoda.png"));
        
        //chukong
        chukong = "Chu Kong";
        chukongIng = "Cat fish,Palm oil,GuwaanaPepper,Black Pepper,Tomatoes,Tomato paste,Onions,Onion leaves,Jumbo,Salt,Carbage,cassava etc.";
        
        chukongIns = "Wash the catfish with hot water+ Add palm oil on the cooking pan , Pound the black pepper+ onion leaves+ onions + guwaana +jumbo and put it all in"
        		+ "the hot palm oil until it is done, add water and allow to boil, add salt to taste, add the vegetables and the cat fish and allow them to cook for 15 mins, then serve it with boiled rice";
        chukongIcon = new ImageIcon(getClass().getResource("chu-kong.png"));
        
        //supakanja
        supakanja = "Supa Kanja";
        
        supakanjaIng = "Okra,Palm oil,Meat, Cat fish,Kereng-kereng,Smoke fish,Dry fish,Crayfish,Oyester,Lobster,Shrimps,Onion leaves,Guwaana,Netetu,Salt,Jumbo,Bitter tomato";
        
        supakanjaIns = "Wash the cat fish with hot water + cut meat to bite size and boil them with salt to taste,add dry fish and crayfish,t Chop oka into ladies finger, Pound netetu+onion leaves+chop okra,+guwaana and add to "
        		+ "the cooking pan,Simmer fo 15 mins and add oyester+lobster+shrimps+jumbo+guwaana and add palm oil,add fish and allow it to simmer for 10 mins in low heat, Serve with boiled rice";
        supakanjaIcon = new ImageIcon(getClass().getResource("okra-soup.png"));
        
        //mbahal
        mbahal = "Mbahal";
        
        mbahalIng = "Rice,grated groundnut,Smoke fish,Netetu,Guwaana,Jumbo,small onion,Dry fish,salt,water,Bitter tomato";
        
        mbahalIns = "Boil the vegetables and dry fish with salt remove the vegetables from water, Boil white rice and add the pounded netetu+onion+smoke fish+ jumbo + guwaana,then add the grated groundnut on top and leave it to "
        		+ "steam on low heat";
        mbahalIcon = new ImageIcon(getClass().getResource("mbahal.png"));
    }
    
    public String getBenachinName(){
        return benachin;
    }
    /**
     * This class contains an enhance for loop that will loop in the string of ingredients
     * and instructions and store them in an array 
     * @return and return ingredients and instruction and print each on a new line, the ingredients first then the instructions.
     */
    public String getBenachinData(){
        String[] bi = benachinIng.split(","); //ingredients string separated at comma to make array data
        String[] bs = benachinIns.split(","); //instruction string separated at comma to make array data
        String output = "Ingredients:\n";
        int x = 1; //numbering of ingredients such as 1.item1, 2.item2, etc...
        int y = 1; //numbering of instructions such as 1.item1, 2.item2, etc...
        for(String ing : bi){
            output+=x+"."+ing+"\n";
            x++;
        }
        output+="\nInstructions:\n";
        for(String ins : bs){
            output+=y+"."+ins+"\n";
            y++;
        }
        return output;
    }
    
    public Icon getBenachinIcon(){
        return benachinIcon;
    }
    
    public String getDomodaName(){
        return domoda;
    }
    
    public String getDomodaData(){
        String[] bi = domodaIng.split(",");
        String[] bs = domodaIns.split(",");
        String output = "Ingredients:\n";
        int x = 1;
        int y = 1;
        for(String ing : bi){
            output+=x+"."+ing+"\n";
            x++;
        }
        output+="\nInstructions:\n";
        for(String ins : bs){
            output+=y+"."+ins+"\n";
            y++;
        }
        return output;
    }
    
    public Icon getDomodaIcon(){
        return domodaIcon;
    }
    
    public String getChuName(){
        return chukong;
    }
    
    public String getChuData(){
        String[] bi = chukongIng.split(",");
        String[] bs = chukongIns.split(",");
        String output = "Ingredients:\n";
        int x = 1;
        int y = 1;
        for(String ing : bi){
            output+=x+"."+ing+"\n";
            x++;
        }
        output+="\nInstructions:\n";
        for(String ins : bs){
            output+=y+"."+ins+"\n";
            y++;
        }
        return output;
    }
    
    public Icon getChuIcon(){
        return chukongIcon;
    }
    
    public String getSupaName(){
        return supakanja;
    }
    
    public String getSupaData(){
        String[] bi = supakanjaIng.split(",");
        String[] bs = supakanjaIns.split(",");
        String output = "Ingredients:\n";
        int x = 1;
        int y = 1;
        for(String ing : bi){
            output+=x+"."+ing+"\n";
            x++;
        }
        output+="\nInstructions:\n";
        for(String ins : bs){
            output+=y+"."+ins+"\n";
            y++;
        }
        return output;
    }
    
    public Icon getSupaIcon(){
        return supakanjaIcon;
    }
    
    public String getMbahalName(){
        return mbahal;
    }
    
    public String getMbahalData(){
        String[] bi = mbahalIng.split(",");
        String[] bs = mbahalIns.split(",");
        String output = "Ingredients:\n";
        int x = 1;
        int y = 1;
        for(String ing : bi){
            output+=x+"."+ing+"\n";
            x++;
        }
        output+="\nInstructions:\n";
        for(String ins : bs){
            output+=y+"."+ins+"\n";
            y++;
        }
        return output;
    }
    
    public Icon getMbahaIcon(){
        return mbahalIcon;
    }
    
}
