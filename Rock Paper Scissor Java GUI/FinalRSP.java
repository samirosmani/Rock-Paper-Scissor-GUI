/*
 *CSCI 185 M-05/M-06
 *Jungi Park, Samir Osmani, Fidan Kelmendi
 *Homework #3: Create your own Java GUI
 *May 4, 2019
 */
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.*;
import javax.imageio.ImageIO;
public class FinalRSP extends javax.swing.JFrame {
 // Variables declaration for JLabel
 private javax.swing.JLabel ComputerLabel;
 private javax.swing.JLabel HumanLabel;
 private javax.swing.JLabel Limage;
 private javax.swing.JLabel LscoreLabel;
 private javax.swing.JLabel Rimage;
 private javax.swing.JLabel RscoreLabel;
 private javax.swing.JLabel ShowResultLabel;
 private javax.swing.JLabel vsLabel;

 // Variables declaration for JButton
 private javax.swing.JButton PaperButton;
 private javax.swing.JButton ResetButton;
 private javax.swing.JButton RockButton;
 private javax.swing.JButton ScissorButton;

 // End of variables declaration

 // these two variables will track the user's and computer's scores
 private static int userScore = 0;
 private static int computerScore = 0;
 
 // Counter for number of round
 private int numGames = 0;
 //Counter for number of games tied.
 private int gamesTied = 0;
 
 // variable for getting player name
 private static String userName1;

 // Creates new form RockScissorPaper
 public FinalRSP() {
  initComponents();
 }

 // This method is called from within the constructor to initialize the form.
 private void initComponents() {

  // JButton
  RockButton = new javax.swing.JButton();
  ScissorButton = new javax.swing.JButton();
  PaperButton = new javax.swing.JButton();
  ResetButton = new javax.swing.JButton();

  // JLabel
  vsLabel = new javax.swing.JLabel();
  LscoreLabel = new javax.swing.JLabel();
  RscoreLabel = new javax.swing.JLabel();
  HumanLabel = new javax.swing.JLabel();
  ComputerLabel = new javax.swing.JLabel();
  Limage = new javax.swing.JLabel();
  Rimage = new javax.swing.JLabel();
  ShowResultLabel = new javax.swing.JLabel();


  // setting JFrame title, always on top. location, and size
  setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
  setTitle("The Famous Rock Paper Scissor Game!");
  setLocation(new java.awt.Point());
  setMaximumSize(new java.awt.Dimension(800, 800));
  setResizable(false);
  setSize(new java.awt.Dimension(500, 500));

  // setting rockButton's background color, font color, size, and text
  RockButton.setBackground(new java.awt.Color(255, 51, 51));
  RockButton.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
  RockButton.setText("Rock");
  // setting actionListener for rockButton : adding addActionListener
  RockButton.addActionListener(new java.awt.event.ActionListener() {
   public void actionPerformed(java.awt.event.ActionEvent evt) {
    RockButtonActionPerformed(evt);
   }
  });

  // setting ScissorButton's background color , font color, size, and text
  ScissorButton.setBackground(new java.awt.Color(255, 204, 0));
  ScissorButton.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
  ScissorButton.setText("Scissor");
  // setting actionListener for rockButton : adding addActionListener
  ScissorButton.addActionListener(new java.awt.event.ActionListener() {
   public void actionPerformed(java.awt.event.ActionEvent evt) {
    ScissorButtonActionPerformed(evt);
   }
  });

  // setting PaperButton's background color ,font color, size, and text
  PaperButton.setBackground(new java.awt.Color(0, 204, 204));
  PaperButton.setFont(new java.awt.Font("Tahoma", 0, 50));
  PaperButton.setText("Paper");
  // setting actionListener for PaperButton : adding addActionListener
  PaperButton.addActionListener(new java.awt.event.ActionListener() {
   public void actionPerformed(java.awt.event.ActionEvent evt) {
    PaperButtonActionPerformed(evt);
   }
  });

  // setting ResetButton text size : adding Reset
  ResetButton.setFont(new java.awt.Font("Tahoma", 0, 36));
  ResetButton.setText("Reset");
  // setting actionListener for ResetButton
  ResetButton.addActionListener(new java.awt.event.ActionListener() {
   public void actionPerformed(java.awt.event.ActionEvent evt) {
    ResetButtonActionPerformed(evt);
   }
  });

  // setting VSJLabel font size 
  // setting VSJLabel for font VS
  vsLabel.setFont(new java.awt.Font("Tahoma", 0, 220));
  vsLabel.setText("vs");

  // setting Left Score JLabel font size
  // setting Left Score JLabel for player's score : if player win, the number will increment
  LscoreLabel.setFont(new java.awt.Font("Tahoma", 0, 45));

  // setting Right Score JLabel font size
  // setting Right Score JLabel for computer's score : if computer win, the number will
  // increment
  RscoreLabel.setFont(new java.awt.Font("Tahoma", 0, 45));

  // setting player's JLabel font size
  // getting Player's name
  HumanLabel.setFont(new java.awt.Font("Tahoma", 0, 35)); // NOI18N
  HumanLabel.setText(userName1);

  // setting compjuter's JLabel font size
  // Displaying Player's name
  ComputerLabel.setFont(new java.awt.Font("Tahoma", 0, 35)); // NOI18N
  ComputerLabel.setText("Computer");

  // setting result's JLabel font size, changing font color, adding Who wins?
  ShowResultLabel.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
  ShowResultLabel.setForeground(new java.awt.Color(255, 51, 51));
  ShowResultLabel.setText("Who wins?");

  // formatting layout
  javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
  getContentPane().setLayout(layout);
  layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
    .createSequentialGroup()
    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
        layout.createSequentialGroup().addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(Limage, javax.swing.GroupLayout.PREFERRED_SIZE, 230,
            javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(
            RockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 240,
            javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
            layout.createSequentialGroup().addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.RELATED,
              javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(
              ComputerLabel,
              javax.swing.GroupLayout.PREFERRED_SIZE, 229,
              javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup().addGap(135, 135, 135)
            .addGroup(layout
              .createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(vsLabel,
                javax.swing.GroupLayout.PREFERRED_SIZE, 222,
                javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(
                ScissorButton,
                javax.swing.GroupLayout.PREFERRED_SIZE, 240,
                javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(
              javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140,
              Short.MAX_VALUE)
            .addGroup(layout
              .createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(PaperButton,
                javax.swing.GroupLayout.PREFERRED_SIZE, 240,
                javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(Rimage,
                javax.swing.GroupLayout.PREFERRED_SIZE, 230,
                javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(RscoreLabel,
                javax.swing.GroupLayout.PREFERRED_SIZE, 199,
                javax.swing.GroupLayout.PREFERRED_SIZE)))))
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout
          .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup().addGap(29, 29, 29)
            .addComponent(HumanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 232,
              javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup().addContainerGap()
            .addComponent(LscoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 218,
              javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(130, 130, 130)
            .addGroup(layout
              .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(ShowResultLabel,
                javax.swing.GroupLayout.PREFERRED_SIZE, 237,
                javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(ResetButton,
                javax.swing.GroupLayout.PREFERRED_SIZE, 249,
                javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addGap(0, 0, Short.MAX_VALUE)))
    .addContainerGap()));
  layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
    .createSequentialGroup().addGap(14, 14, 14)
    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
      .addComponent(ComputerLabel).addComponent(HumanLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
        53, javax.swing.GroupLayout.PREFERRED_SIZE))
    .addGap(2, 2, 2)
    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
      .addComponent(RockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
        javax.swing.GroupLayout.PREFERRED_SIZE)
      .addComponent(ScissorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
        javax.swing.GroupLayout.PREFERRED_SIZE)
      .addComponent(PaperButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110,
        javax.swing.GroupLayout.PREFERRED_SIZE))
    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup().addGap(134, 134, 134)
        .addComponent(vsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 240,
          javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(102, 102, 102))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
        layout.createSequentialGroup()
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(Limage, javax.swing.GroupLayout.PREFERRED_SIZE, 280,
            javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(Rimage, javax.swing.GroupLayout.PREFERRED_SIZE, 280,
            javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(73, 73, 73)))
    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
      .addComponent(ShowResultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
        javax.swing.GroupLayout.PREFERRED_SIZE)
      .addComponent(LscoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69,
        javax.swing.GroupLayout.PREFERRED_SIZE)
      .addComponent(RscoreLabel))
    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(ResetButton,
      javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
    .addContainerGap(29, Short.MAX_VALUE)));
  // help to be sized to fit the preferred size
  pack();
 } // end of initComponents() 
 /***************************************************************
  ** GreetingUser - greeting user and explaining game of rules. Inputs: None.
  ** Outputs: None.
  ***************************************************************/
 public static void GreetingUser() {
  JOptionPane.showMessageDialog(null,"Welcome to Paper, Scissor and Rock\n\nHere are the rules:\n1)Scissors cuts Paper\n2)Paper covers Rock\n3)Rock breaks Scissors");
 }
 /***************************************************************
  ** GetValidUserInput - asking user's name Inputs: promptStr - Displaying role of
  * game Outputs: userInput - user's Name
  ***************************************************************/
 public static String GetUserName(String promptStr) {
 String userInput; // variable for user's input as String type
  userInput = JOptionPane.showInputDialog(promptStr);
   try{
  if (userInput.equals(""))
    throw new IllegalArgumentException();
 else if (userInput == null)
    throw new NullPointerException();
  }//end try
  catch (IllegalArgumentException a){
    JOptionPane.showMessageDialog(null,"Please enter an actual name! NO BLANKS.");
  }
     catch (NullPointerException a){
     JOptionPane.showMessageDialog(null,"Game is terminated. Thank you for playing!");  
    System.exit(0);
  }//end catch
  return userInput;
 }
 /***************************************************************
  ** ComputerCPiture - Generate random computer's choice and displaying picture
  ** Inputs: None 
  **Outputs: computerchoice - return random number of computerchoice
  **
  ***************************************************************/
 // Method Genereate Computer choice and displaying picture according to choice
 public int ComputerCPiture() {
  BufferedImage img = null;
  // Variabel for generating random number for computer choice
  int computerchoice = (int) (Math.random() * 3);
  try {
   if (computerchoice == 0) {
    // you should change address where the picture is stored from your own computer.
    img = ImageIO.read(new File("rock.jpg"));
   } else if (computerchoice == 1) {
    // you should change address where the picture is stored from your own computer.
    img = ImageIO.read(new File("scissors.jpg"));
   } else if (computerchoice == 2) {
    // you should change address where the picture is stored from your own computer.
    img = ImageIO.read(new File("paper.jpg"));
   }
  } catch (IOException e) {
   e.printStackTrace();
  }
  Image rightpic = img.getScaledInstance(Rimage.getWidth(), Rimage.getHeight(), Image.SCALE_SMOOTH);
  ImageIcon icon2 = new ImageIcon(rightpic);
  Rimage.setIcon(icon2);

  return computerchoice;
 }
 /***************************************************************
 ** ComparingNum - if user's tie return 0, win return 1, and lose return 2.
 ** Inputs: yourchoice - user's input.
 **     computerchoice - computer's input.
 ** Outputs: result - returning 0(tie), 1(win), and 2(lose).
 ***************************************************************/
 public static int ComparingNum (int yourchoice, int computerchoice )
 {
  int resultNum = 0; //Initialing variable for integer type
  //cause 0: You tie 
  if (yourchoice == 0 && computerchoice == 0 )
  {
  resultNum = 0;
  }
  else if (yourchoice == 1 && computerchoice == 1)
  {
  resultNum = 0;
  }
  else if (yourchoice == 2 && computerchoice == 2)
  {
  resultNum = 0;
  } 
  //Case 1: You win:)
  else if (yourchoice == 0 && computerchoice  == 1  )
  {
  resultNum = 1; 
  }
  else if (yourchoice == 1 && computerchoice  == 0  )
  {
  resultNum = 1;   
  }
        else if (yourchoice == 2 && computerchoice  == 0  )
        {
        resultNum = 1;
  } 
  //Case 2: You lose :(
        else if (yourchoice == 2 && computerchoice  == 1  )
  {
        resultNum = 2;
  }
  else if (yourchoice == 0 && computerchoice  == 2  ) 
  {
  resultNum = 2;
  }
  else if (yourchoice == 1 && computerchoice  == 0  )
  {
  resultNum = 2;
  }
  return resultNum;
 }
 /***************************************************************
  ** Comparing - deciding who win,lose,or tie. Inputs: yourchoice - user's Input.
  ** computerchoice - computer's Input. Outputs: result - According to result, the
  * sentence will print out.
  ***************************************************************/
 public String Comparing(int yourchoice, int computerchoice) {
   numGames++;
  // cause 0: You are Rock
  if (yourchoice == computerchoice) {
    gamesTied++;
   return ("It's Tie!");
  } else if (yourchoice == 0 && computerchoice == 1) {
   userScore++;
   return ("You Win");
  } else if (yourchoice == 0 && computerchoice == 2) {
   computerScore++;
   return ("You Lose!");
  }
  // cause 1: You are Scissor
  else if (yourchoice == 1 && computerchoice == 0) {
   computerScore++;
   return ("You Lose!");
  } else if (yourchoice == 1 && computerchoice == 2) {
   userScore++;
   return ("You Win");
  }
  // Case 2: You are Paper
  else if (yourchoice == 2 && computerchoice == 0) {
   userScore++;
   return ("You Win");
  } else if (yourchoice == 2 && computerchoice == 1) {
   computerScore++;
   return ("You Lose!");
  }
  return null;
 }
 // RockButton's actionListiner Method
 private void RockButtonActionPerformed(java.awt.event.ActionEvent evt) {
  // Displaying Rock image at the LeftLable
  BufferedImage img = null;
  // Reading picture jpg type file
  try {
   // you should change address where the picture is stored from your own computer.
   img = ImageIO.read(new File("rock.jpg"));
  } catch (IOException e) {
   e.printStackTrace();
  }
  // Resizing picture for Label
  Image leftpic = img.getScaledInstance(Limage.getWidth(), Limage.getHeight(), Image.SCALE_SMOOTH);
  ImageIcon icon1 = new ImageIcon(leftpic);
  Limage.setIcon(icon1);

  // calling method for computer choice's picture
  int computerChoice = ComputerCPiture();
  
  // printing game result at ShowResultLabel
  ShowResultLabel.setText(Comparing(0, computerChoice));
  
  // getting result as integer
  int numResult =  ComparingNum (0, computerChoice);
  // Displaying player's and user's score
  LscoreLabel.setText("Score: " + userScore);
  RscoreLabel.setText("Score: " + computerScore);
 }

 // ScissorButton's actionListiner Method
 private void ScissorButtonActionPerformed(java.awt.event.ActionEvent evt) {
  // Displaying scissor image at the LeftLabel
  BufferedImage img = null;
  // Reading picture jpg type file
  try {
   // you should change address where the picture is stored from your own computer.
   img = ImageIO.read(new File("scissors.jpg"));
  } catch (IOException e) {
   e.printStackTrace();
  }
  // Resizing picture for Label
  Image rightpic = img.getScaledInstance(Limage.getWidth(), Limage.getHeight(), Image.SCALE_SMOOTH);
  ImageIcon icon = new ImageIcon(rightpic);
  Limage.setIcon(icon);

  // calling method for computer choice's picture
  int computerChoice = ComputerCPiture();

  // printing game result at ShowResultLabel
  ShowResultLabel.setText(Comparing(1, computerChoice));
  
  // getting result as integer
  int numResult =  ComparingNum (1, computerChoice);
  // Displaying player's and user's score
  LscoreLabel.setText("Score: " + userScore);
  RscoreLabel.setText("Score: " + computerScore);
 }

 // PaperButton's actionListiner Method
 private void PaperButtonActionPerformed(java.awt.event.ActionEvent evt) {
  // Displaying paper image at the LeftLabel
  BufferedImage img = null;
  // Reading picture jpg type file
  try {
   // you should change address where the picture is stored from your own computer.
   img = ImageIO.read(new File("paper.jpg"));
  } catch (IOException e) {
   e.printStackTrace();
  }
  // Resizing picture for Label
  Image rightpic = img.getScaledInstance(Limage.getWidth(), Limage.getHeight(), Image.SCALE_SMOOTH);
  ImageIcon icon = new ImageIcon(rightpic);
  Limage.setIcon(icon);
  // calling method for computer choice's picture
  int computerChoice = ComputerCPiture();

  // printing game result at ShowResultLabel
  ShowResultLabel.setText(Comparing(2, computerChoice));
  
  // getting result as integer
  int numResult =  ComparingNum (2, computerChoice);  
  // Displaying player's and user's score
  LscoreLabel.setText("Score: " + userScore);
  RscoreLabel.setText("Score: " + computerScore);
 }
 // Reset's actionListiner Method
 private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {
  JOptionPane.showMessageDialog(null,"Hello there " +userName1+"!\n\nHere is a summary of your last game:\nIn a total of "+numGames+ " games played, you won "+userScore+" games\nwhile your opponent, the computer won "+ computerScore+" games.\nYou and the computer tied "+gamesTied+" games.");
  Limage.setIcon(null);
  Rimage.setIcon(null);
  ShowResultLabel.setText(null);
  userScore = 0;
  computerScore = 0;
  // Displaying player's and user's score
  LscoreLabel.setText("Score: " + userScore);
  RscoreLabel.setText("Score: " + computerScore);
 }
 public static void main(String args[]) {
  // Displaying role message
  GreetingUser();
  // getting user's name and repeats if user enters a blank string
    do {
    userName1 = GetUserName("What is your name?");
    } while (userName1.equals(""));
  // Instantiating RSPversion2 object
  FinalRSP a = new FinalRSP();
  // Making Visible JFrame
  a.setVisible(true);
  // Displaying player's and user's score
  a.LscoreLabel.setText("Score: " + userScore);
  a.RscoreLabel.setText("Score: " + computerScore);
 }
}// end class