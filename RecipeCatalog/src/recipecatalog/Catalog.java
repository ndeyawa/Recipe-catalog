
package recipecatalog;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
/**
 *Implements Catalog:
 * Class that creates and manages the UI of the application
 * and all the work-flows necessary to view, suggest, and
 * select a dish. It also manages the Dish class and the Data class
 * to create objects from each for necessary implementation of the Catalog.
 * @author Ndey awa
 */
public class Catalog extends JFrame{
   
	private static final long serialVersionUID = 1L;
	/*
     The Catalog list of all dishes 
    */
    private ArrayList<Dish> dishes;
    private ArrayList<Dish> suggestionList;
    private Data data;
    private Dish benachin,domoda,chukong,supakanja,mbahal;
    
    /*
     Front User Interface Design 
    */
    
    //Top icons on front UI
    private JPanel captionPanel; //top most panel
    private JLabel caption1; //icon
   
    //main big UI front view design 
    private JPanel midPanel; //the main window
    private JLabel bigFrontLabel1; //big image
    private JLabel bigFrontLabel2; //big image
    
    //Design the global buttons showing at the bottom of all interfaces
    private JPanel buttonsPanel; //holding all global buttons
    private JButton[] button; //all buttons at once
    private String[] buttonName; //it is singular for better code reading
    private JButton[] dishButtons; //dish names on dish list as buttons
    
    /*
     Dish Suggestion Panel Design 
    */
  
    //Field Labels
    private JLabel dishNameLabel;
    private JLabel dishDescriptionLabel;
    
    //Input Fields
    private JTextField dishNameField;
    private JTextArea dishDescriptionPane;
    
    /*
     A Single Dish View Design 
    */
    
    //outlook
    private JLabel dishName;
    private JTextArea dishIngredients;
    private JLabel dishImage;
    private JPanel singleDishPanel;
    private JScrollPane dishScrollPane;
    
    /*
     Dish List Design: List of All Dishes 
    */
    
    //outlook
    private JButton suggestions;
    private JPanel dishListPanel;
   
    private Box vertical1;
    /**
     *Implements constructor
     */
    public Catalog(){
        
      super("Recipe Catalog"); //JFrame constructor
      
      // Creating the dish list 
      dishes = new ArrayList<>();
      suggestionList = new ArrayList<>();
      data = new Data();
      //create dishes
      benachin = new Dish(data.getBenachinName(),data.getBenachinData(),data.getBenachinIcon());
      dishes.add(benachin);
      
      domoda = new Dish(data.getDomodaName(),data.getDomodaData(),data.getDomodaIcon());
      dishes.add(domoda);
      
      chukong = new Dish(data.getChuName(),data.getChuData(),data.getChuIcon());
      dishes.add(chukong);
      
      supakanja = new Dish(data.getSupaName(),data.getSupaData(),data.getSupaIcon());
      dishes.add(supakanja);
      
      mbahal = new Dish(data.getMbahalName(),data.getMbahalData(),data.getMbahaIcon());
      dishes.add(mbahal);
            
      // Front User Interface Setup 
      captionPanel = new JPanel();
      captionPanel.setLayout(new GridLayout(1,1));
      Icon topIcon = new ImageIcon(getClass().getResource("recipes2.png"));
      caption1 = new JLabel();
      caption1.setIcon(topIcon);
      captionPanel.add(caption1);
      add(captionPanel,BorderLayout.NORTH);
      
      midPanel = new JPanel();
      midPanel.setLayout(new GridLayout(1,1));
      midPanel.setBackground(Color.black);
      final Icon bigIcon1 = new ImageIcon(getClass().getResource("cookart1.png"));
      final Icon bigIcon2 = new ImageIcon(getClass().getResource("cookart2.png"));
      JLabel container = new JLabel();
      container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));//add the 2 images according to y axis one on top the other down
      bigFrontLabel1 = new JLabel();
      bigFrontLabel2 = new JLabel();
      bigFrontLabel1.setIcon(bigIcon1);
      bigFrontLabel2.setIcon(bigIcon2);
      container.add(bigFrontLabel1);
      container.add(bigFrontLabel2);
      midPanel.add(container);
      
      add(midPanel,BorderLayout.CENTER);// the middle panel should be at center
      
      String names = "Home,Suggest,List,Close";
      buttonName = names.split(",");
      buttonsPanel = new JPanel();
      buttonsPanel.setLayout(new GridLayout(1,buttonName.length));
      button = new JButton[buttonName.length];
      for(int i=0; i<buttonName.length; i++){
          button[i] = new JButton(buttonName[i]);
          buttonsPanel.add(button[i]);
      }
      add(buttonsPanel,BorderLayout.SOUTH);
      
      
      //dish buttons box for all dish list
      vertical1 = Box.createVerticalBox(); //box to hold all dish names as buttons
      vertical1.setSize(600, 400); //width = 600, height = 400
      dishButtons = new JButton[dishes.size()]; //initialize dish buttons arrays
      for(int i=0; i<dishes.size(); i++){
          dishButtons[i] = new JButton(dishes.get(i).getName()); //naming buttons
          vertical1.add( Box.createVerticalStrut(25)); //adding space of 25px btw buttons
          vertical1.add(dishButtons[i]); //adding button to box
      }
        suggestions = new JButton("View Suggestions"); //separate button 
        dishListPanel = new JPanel();
        dishListPanel.setLayout(new GridLayout(1,1)); //1 row 1 col
        vertical1.add( Box.createVerticalStrut(25));
        vertical1.add(suggestions); //add suggestion button 
        dishListPanel.add(vertical1); //add box to panel
        add(dishListPanel,BorderLayout.WEST); //add panel to left of JFrame
        dishListPanel.setVisible(false); //not showing by default but after some button click
      
      
      // Suggest Dish UI Setup 
      dishNameLabel = new JLabel("Dish Name");
      dishDescriptionLabel = new JLabel("Description");
      
      dishNameField = new JTextField(10);
      dishDescriptionPane = new JTextArea(5,5); //5 rows 5 columns
      dishDescriptionPane.setLineWrap(true); //automatic newline at pane's edge
     
      //final because it is to be used in an anonymous class
     // object to hold different kinds of objects as an array for the JOptionPane
      //for Suggesting a dish
      final Object[] creationPanel = {dishNameLabel,dishNameField,
                                dishDescriptionLabel,dishDescriptionPane
                                };
    
    // Single Dish View Panel setup
      singleDishPanel = new JPanel();
      singleDishPanel.setLayout(new GridLayout(3,1));
      dishName = new JLabel();
      dishName.setFont(new Font("Serif",Font.BOLD,48));//to make it a nice visible caption
      dishImage = new JLabel();
      dishIngredients = new JTextArea(30,10);
      dishIngredients.setLineWrap(true);
      dishIngredients.setWrapStyleWord(true);
      dishIngredients.setEditable(false);
      singleDishPanel.add(dishName);
      singleDishPanel.add(dishImage);
      dishScrollPane = new JScrollPane(dishIngredients);
      dishScrollPane.setPreferredSize(new Dimension(300, 500));
      singleDishPanel.add(dishScrollPane);
      add(singleDishPanel,BorderLayout.EAST); //add to right side of JFrame
      singleDishPanel.setVisible(false);
       
      
      // Global buttons actions setup 
      
      //Home Button Action
      button[0].addActionListener(new ActionListener(){

          @Override
          public void actionPerformed(ActionEvent e) {
              
              dishListPanel.setVisible(false);//hide list
              singleDishPanel.setVisible(false);//hide dish view
              midPanel.setVisible(true); //show home page
              
          }
      
      });
      
      //Suggest Button Action
      //inside a method we have a class constructor that also has a method which does the trick
      button[1].addActionListener(new ActionListener(){ 

          @Override
          public void actionPerformed(ActionEvent e) {
              
              dishNameField.setText(null); //to prepare for next input
              dishDescriptionPane.setText(null); //to prepare for next input
              
              int option = JOptionPane.showConfirmDialog(rootPane, creationPanel, "Suggest A New Dish", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION){
                    String dishName = dishNameField.getText();
                    String dishDesc = dishDescriptionPane.getText();                  
                    
                    recordDish(new Dish(dishName,dishDesc,null));

                    
                    JOptionPane.showMessageDialog(captionPanel, "Dish: "+dishName+"\nhas been successfully created.");
                }else{
                    JOptionPane.showMessageDialog(captionPanel, "You did not enter any Dish Name.\nHence, nothing was saved!");
                }
              
          }
      
      });
      
      //List Button Action
      button[2].addActionListener(new ActionListener(){

          @Override
          public void actionPerformed(ActionEvent e){
            
            midPanel.setVisible(false);
            singleDishPanel.setVisible(false);
            dishListPanel.setVisible(true);
          }
      
      });
      
      //Close Button Action
      button[3].addActionListener(new ActionListener(){

          @Override
          public void actionPerformed(ActionEvent e) {
              
              System.exit(0);
              
          }
      
      });
      
      //Dish Buttons Actions
      //create object for all dish button listeners
       DishButtonsHandler dbh = new DishButtonsHandler();
      //all the dish names buttons are given action listener
      dishButtons[0].addActionListener(dbh);
      dishButtons[1].addActionListener(dbh);
      dishButtons[2].addActionListener(dbh);
      dishButtons[3].addActionListener(dbh);
      dishButtons[4].addActionListener(dbh);
      suggestions.addActionListener(dbh);
      
    }//End of Constructor Catalog()
    
    //to add dish to suggestion list
    private void recordDish(Dish d){
        suggestionList.add(d);
    }
    
    //to retrieve all suggestions
    private String getSuggestions(){
        String output = "Suggestion List:\n";
        for(int i=0; i<suggestionList.size(); i++){
            output+="Dish Name: "+suggestionList.get(i).getName()+"\nDescription: "+suggestionList.get(i).getData()+"\n";
        }
        
        return output;
    }
    
    /**
     * 
     *Action Listener for Dish Buttons implementing all the actions based on the 
     *dish name (button) clicked. The clicked button has a name for example
     * Bena Chin which is tested on if it's equal to clicked button name, then
     * do a particular thing.
    */
    private class DishButtonsHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            singleDishPanel.setVisible(true);
            
            if(e.getActionCommand().equals("Bena Chin")){
                dishName.setText(benachin.getName());
                dishIngredients.setText(benachin.getData());
                dishImage.setIcon(benachin.getIcon());
            }else if(e.getActionCommand().equals("Domoda")){
                dishName.setText(domoda.getName());
                dishIngredients.setText(domoda.getData());
                dishImage.setIcon(domoda.getIcon());
            }else if(e.getActionCommand().equals("Chu Kong")){
                dishName.setText(chukong.getName());
                dishIngredients.setText(chukong.getData());
                dishImage.setIcon(chukong.getIcon());
            }else if(e.getActionCommand().equals("Supa Kanja")){
                dishName.setText(supakanja.getName());
                dishIngredients.setText(supakanja.getData());
                dishImage.setIcon(supakanja.getIcon());
            }else if(e.getActionCommand().equals("Mbahal")){
                dishName.setText(mbahal.getName());
                dishIngredients.setText(mbahal.getData());
                dishImage.setIcon(mbahal.getIcon());
            }else if(e.getActionCommand().equals("View Suggestions")){
               
                singleDishPanel.setVisible(false);
                String output = getSuggestions();
                if(suggestionList.size() > 0){
                   JOptionPane.showMessageDialog(captionPanel, output, "Suggestions", JOptionPane.PLAIN_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(captionPanel, "No Suggestions are available yet!\nPlease make a suggestion by \njust clicking on \"Suggest\" Button.");
                }
                
            }
        }
        
    }
    
}
