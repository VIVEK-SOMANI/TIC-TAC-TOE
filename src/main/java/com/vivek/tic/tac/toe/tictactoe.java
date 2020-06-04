/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
<dependency>
            <groupId>unknown.binary</groupId>
            <artifactId>AbsoluteLayout</artifactId>
            <version>SNAPSHOT</version>
        </dependency>

 */
package com.vivek.tic.tac.toe;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author user
 */
public class tictactoe extends javax.swing.JFrame {
    
    
    
    private String player1,player2,p1sign,p2sign;
    private int p1=0,p2=0,draw=0;
    int rounds_count=0, count=0,win_flag=0;
    char X=' ',O=' ',status=' ',point=' ';
    char game[]={' ',' ',' ',' ',' ',' ',' ',' ',' '};
    boolean flag_position=false,letsplay_flag=false;
    public tictactoe() {
        initComponents();
        setSize(1400,750);
        setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                 exit();
            }
            });
        
        
    }
    private JFrame exframe ;
    void exit()
    {
        exframe = new JFrame("EXIT");
        if(JOptionPane.showConfirmDialog(exframe, "Are you Sure you want to exit? ","TIC TAC TOE",
                JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
        {
            System.exit(0);
        }
        else 
            return;
    }

    void setwinflag()
    {
        if(status==X)
        {
            win_flag=1;
        }
        else if(status==O)
        {
            win_flag=2;
            
        }
        else
            win_flag=0;
    }
    private void check_for_result()
    {
        if(win_flag==1)
        {
            
            resultscreen.setText(player1.toUpperCase() +" won this round");
            p1++;
            
            disable_board();
            nextround();
        }
        else if(win_flag==2)
        {
         resultscreen.setText(player2.toUpperCase() +" won this round");
         p2++;
            disable_board();
            nextround();   
        }
        else if(count==9 && win_flag==0)
        {
            resultscreen.setText("This round was a draw");
            draw++;nextround();
        }
        
        
        
    }
    private  void disable_board()
    {
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
    }
    private  void enable_board()
    {
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
    }
    
    private void final_result()
    {
        if(p1>p2)
        {
            resultscreen.setText(player1 +"won this GAME");
        }
        else if(p2>p1)
        {
            resultscreen.setText(player2 +"won this GAME");
            
        }
        else
            resultscreen.setText("This game is a Draw");
        letsplay_flag=false;
    }
    private void nextround()
    {
        
         score_board();
         if(rounds_count!=(p1+p2+draw))
         {
             commandscreen.setText("Click Next Round");
             nextround.setEnabled(true);
         }
         else
         {  
             if(p1>p2)
                 resultscreen.setText(player1.toUpperCase()+ " WINS");
             else if(p1<p2)
                 resultscreen.setText(player2.toUpperCase()+" WINS");
             else
                 resultscreen.setText("GAME DRAW");
             
             disable_board();
             disablekeys();
             disableframes();
             
             letsplay_flag=false;
             scoreboard.setEnabled(true);
             
             resetscore.setEnabled(false);
             result.setEnabled(true);
             restart.setEnabled(true);
             
             commandscreen.setText("Click Restart");
         }
    }
    
    private void resetbuttons()
    {
        commandscreen.setText("");
        count=0;
        game[0]=' ';
        game[1]=' ';game[2]=' ';game[3]=' ';game[4]=' ';game[5]=' ';game[6]=' ';
        game[8]=' ';game[7]=' ';
      b1.setText(" ");
      b2.setText(" ");
      b3.setText(" ");
      b4.setText(" ");
      b5.setText(" ");
      b6.setText(" ");
      b7.setText(" ");
      b8.setText(" ");
      b9.setText(" ");
      screen.setText("");
      resultscreen.setText(" ");
    }
    private boolean check_key(int n,char character)
    {
        if(game[n]==p1sign.charAt(0)||game[n]==p2sign.charAt(0))
        {
            count--;
            return false;
        }
        else 
        {    
            game[n]=character;
            return true;
        }
    }
    
   
    private char check()
    {

        if (game[0] == game[1] && game[1] == game[2] && game[1] == X)
		return X;
	else if (game[0] == game[1] && game[1] == game[2] && game[1] == O)
		return O;
	else if (game[0] == game[3] && game[3] == game[6] && game[0] == X)
		return X;
	else if (game[0] == game[3] && game[3] == game[6] && game[0] == O)
		return O;
	else if (game[0] == game[4] && game[4] == game[8] && game[0] == X)
		return X;
	else if (game[0] == game[4] && game[4] == game[8] && game[0] == O)
		return O;
	else if (game[1] == game[4] && game[4] == game[7] && game[1] == X)
		return X;
	else if (game[1] == game[4] && game[4] == game[7] && game[1] == O)
		return O;
	else if (game[2] == game[5] && game[5] == game[8] && game[2] == X)
		return X;
	else if (game[2] == game[5] && game[5] == game[8] && game[2] == O)
		return O;
	else if (game[2] == game[4] && game[4] == game[6] && game[2] == X)
		return X;
	else if (game[2] == game[4] && game[4] == game[6] && game[2] == O)
		return O;
	else if (game[3] == game[4] && game[4] == game[5] && game[5] == X)
		return X;
	else if (game[3] == game[4] && game[4] == game[5] && game[5] == O)
		return O;
	else if (game[1] == game[4] && game[4] == game[7] && game[1] == X)
		return X;
	else if (game[1] == game[4] && game[4] == game[7] && game[1] == O)
		return O;
	else
		return 'c';
}
    private void lets_play()
    {
        
        X=p1sign.charAt(0);
        O=p2sign.charAt(0);
        enablekeys();
        enableframes();
        letsplay_flag=true;
        
    }
    private void reset_score()
    {
        p1=0;p2=0;
    }
    private void disablekeys()
    {
        disable_board();
        letsplay.setEnabled(false);
    }
    private void disableframes()
    {
        gameboard.setEnabled(false);
        result.setEnabled(false);
        scoreboard.setEnabled(false);
        player.setEnabled(true);
    }
    private void reset_details()
    {
        p1name.setText("Enter Your Name");
        p2name.setText("Enter Your Name");
        p1symbol.setText("Enter Your Symbol");
        p2symbol.setText("Enter Your Symbol");
        resetbuttons();
    }
    
    private void enablekeys()
    {
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
        letsplay.setEnabled(true);
    }
    private void enablescores()
    {
        p1score.setEnabled(true);
        p2score.setEnabled(true);
    }
    private void disablescores()
    {
        p1score.setEnabled(false);
        p2score.setEnabled(false);
    }
    private void enableframes()
    {
        gameboard.setEnabled(true);
        result.setEnabled(true);
        scoreboard.setEnabled(true);
        player.setEnabled(true);
    }
    
    private void score_board()
    {
        p1score.setText(Integer.toString(p1));
        p2score.setText(Integer.toString(p2));
    }
    
    private void player_details()
    {
        player1=p1name.getText();
        if(player1.length()==0)
        {
            player1= "PLAYER X";
        }
        p1sign=p1symbol.getText();
        player2=p2name.getText();
        if(player2.length()==0)
        {
            player2="PLAYER o";
        }
        p2sign=p2symbol.getText();
        try
        {
            rounds_count=Integer.parseInt(rounds.getText());
            if(rounds_count>11)
            {
                rounds_count=11;
            rounds.setText("11");
            }
            
        }
        catch(NumberFormatException e)
        {
            letsplay.setEnabled(false);
            commandscreen.setText("Number of Rounds must be a number");
        }
        
        if(p1sign.length()==0||p2sign.length()==0 )
        {
            letsplay.setEnabled(false);
            commandscreen.setText("Symbol can't stay empty.");
        }
        else if( p1sign.length()>1 ||p2sign.length()>1)
        {
            letsplay.setEnabled(true);
            commandscreen.setText("Symbol should be a single charecter");
        }
        else if(p1sign.equals(p2sign))
        {
            letsplay.setEnabled(false);
            commandscreen.setText("Symbols cannot be Same");
        }
        else
        {
            lets_play();
            screen.setText(player1+"'s turn");
        }
        
    }
    private void start()
    {
        disablekeys();
        
        disableframes();
        letsplay_flag=false;
    }
    void enableplayername()
    {
        p1scname.setText(player1);
        p2scname.setText(player2);
    }
    void disableplayername()
    {
        p1scname.setText("Player 1:");
        p2scname.setText("Player 2:");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        result = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        resultscreen = new javax.swing.JTextField();
        gameboard = new javax.swing.JPanel();
        screen = new javax.swing.JLabel();
        b3 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        scoreboard = new javax.swing.JPanel();
        p2scname = new javax.swing.JLabel();
        p1scname = new javax.swing.JLabel();
        p1score = new javax.swing.JTextField();
        resetscore = new javax.swing.JButton();
        nextround = new javax.swing.JButton();
        restart = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        p2score = new javax.swing.JTextField();
        startgame = new javax.swing.JButton();
        player = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        p1symbol = new javax.swing.JTextField();
        p2name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        p1name = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        p2symbol = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        letsplay = new javax.swing.JButton();
        resetdetails = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        rounds = new javax.swing.JTextField();
        commandscreen = new javax.swing.JTextField();

        jLabel1.setBackground(new java.awt.Color(255, 255, 204));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("NAME");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 204), 1, true));

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("TIC-TAC-TOE");
        setBackground(new java.awt.Color(102, 153, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(204, 204, 255));
        setLocation(new java.awt.Point(100, 50));

        jPanel1.setBackground(new java.awt.Color(229, 193, 73));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(14, 700));

        header.setBackground(new java.awt.Color(0, 0, 0));
        header.setFont(new java.awt.Font("Snap ITC", 3, 80)); // NOI18N
        header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.setLabelFor(header);
        header.setText("TIC - TAC - TOE ");
        header.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        result.setBackground(new java.awt.Color(153, 0, 0));
        result.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 204));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("RESULT");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 153), 2));

        resultscreen.setBackground(new java.awt.Color(229, 193, 70));
        resultscreen.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        resultscreen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        resultscreen.setText("\n\n");
        resultscreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultscreenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout resultLayout = new javax.swing.GroupLayout(result);
        result.setLayout(resultLayout);
        resultLayout.setHorizontalGroup(
            resultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultLayout.createSequentialGroup()
                .addGroup(resultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(resultLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(resultscreen, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(resultLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        resultLayout.setVerticalGroup(
            resultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resultLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(resultscreen, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gameboard.setBackground(new java.awt.Color(153, 0, 0));
        gameboard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        screen.setBackground(new java.awt.Color(255, 255, 204));
        screen.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        screen.setForeground(new java.awt.Color(229, 193, 70));
        screen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        screen.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 153), 1, true));

        b3.setBackground(new java.awt.Color(229, 193, 70));
        b3.setFont(new java.awt.Font("Times New Roman", 1, 65)); // NOI18N
        b3.setBorderPainted(false);
        b3.setFocusPainted(false);
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        b1.setBackground(new java.awt.Color(229, 193, 70));
        b1.setFont(new java.awt.Font("Times New Roman", 1, 65)); // NOI18N
        b1.setBorderPainted(false);
        b1.setFocusPainted(false);
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b2.setBackground(new java.awt.Color(229, 193, 70));
        b2.setFont(new java.awt.Font("Times New Roman", 1, 65)); // NOI18N
        b2.setBorderPainted(false);
        b2.setFocusPainted(false);
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        b6.setBackground(new java.awt.Color(229, 193, 70));
        b6.setFont(new java.awt.Font("Times New Roman", 1, 65)); // NOI18N
        b6.setBorderPainted(false);
        b6.setFocusPainted(false);
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });

        b4.setBackground(new java.awt.Color(229, 193, 70));
        b4.setFont(new java.awt.Font("Times New Roman", 1, 65)); // NOI18N
        b4.setBorderPainted(false);
        b4.setFocusPainted(false);
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        b5.setBackground(new java.awt.Color(229, 193, 70));
        b5.setFont(new java.awt.Font("Times New Roman", 1, 65)); // NOI18N
        b5.setBorderPainted(false);
        b5.setFocusPainted(false);
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });

        b9.setBackground(new java.awt.Color(229, 193, 70));
        b9.setFont(new java.awt.Font("Times New Roman", 1, 65)); // NOI18N
        b9.setBorderPainted(false);
        b9.setFocusPainted(false);
        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });

        b7.setBackground(new java.awt.Color(229, 193, 70));
        b7.setFont(new java.awt.Font("Times New Roman", 1, 65)); // NOI18N
        b7.setBorderPainted(false);
        b7.setFocusPainted(false);
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });

        b8.setBackground(new java.awt.Color(229, 193, 70));
        b8.setFont(new java.awt.Font("Times New Roman", 1, 65)); // NOI18N
        b8.setBorderPainted(false);
        b8.setFocusPainted(false);
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gameboardLayout = new javax.swing.GroupLayout(gameboard);
        gameboard.setLayout(gameboardLayout);
        gameboardLayout.setHorizontalGroup(
            gameboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameboardLayout.createSequentialGroup()
                .addGroup(gameboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameboardLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(screen, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gameboardLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gameboardLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gameboardLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        gameboardLayout.setVerticalGroup(
            gameboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameboardLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(screen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(gameboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(gameboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(gameboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scoreboard.setBackground(new java.awt.Color(153, 0, 0));
        scoreboard.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 204, 51)));
        scoreboard.setToolTipText("");

        p2scname.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        p2scname.setForeground(new java.awt.Color(255, 255, 204));
        p2scname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p2scname.setText("PLAYER 2  :");

        p1scname.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        p1scname.setForeground(new java.awt.Color(255, 255, 204));
        p1scname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p1scname.setText("PLAYER 1  :");

        p1score.setBackground(new java.awt.Color(255, 204, 153));
        p1score.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        p1score.setText("0");
        p1score.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                p1scoreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                p1scoreFocusLost(evt);
            }
        });

        resetscore.setBackground(new java.awt.Color(255, 255, 204));
        resetscore.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        resetscore.setText("RESET SCOREBOARD");
        resetscore.setToolTipText("");
        resetscore.setBorderPainted(false);
        resetscore.setSelected(true);
        resetscore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetscoreActionPerformed(evt);
            }
        });

        nextround.setBackground(new java.awt.Color(255, 255, 204));
        nextround.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        nextround.setText("Next Round");
        nextround.setToolTipText("");
        nextround.setBorderPainted(false);
        nextround.setSelected(true);
        nextround.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextroundActionPerformed(evt);
            }
        });

        restart.setBackground(new java.awt.Color(255, 255, 204));
        restart.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        restart.setText("Restart");
        restart.setToolTipText("");
        restart.setBorderPainted(false);
        restart.setSelected(true);
        restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 204));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("SCOREBOARD");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 153), 2));

        p2score.setBackground(new java.awt.Color(255, 204, 153));
        p2score.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        p2score.setText("0");
        p2score.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                p2scoreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                p2scoreFocusLost(evt);
            }
        });

        javax.swing.GroupLayout scoreboardLayout = new javax.swing.GroupLayout(scoreboard);
        scoreboard.setLayout(scoreboardLayout);
        scoreboardLayout.setHorizontalGroup(
            scoreboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scoreboardLayout.createSequentialGroup()
                .addGroup(scoreboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(scoreboardLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(scoreboardLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(p1scname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(p1score, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(scoreboardLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(p2scname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(p2score, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(scoreboardLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(nextround, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(restart, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(scoreboardLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(resetscore, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        scoreboardLayout.setVerticalGroup(
            scoreboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scoreboardLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(scoreboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p1scname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p1score, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(scoreboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p2scname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p2score, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(scoreboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nextround, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restart, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(resetscore, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        startgame.setBackground(new java.awt.Color(229, 193, 70));
        startgame.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        startgame.setText("EXIT");
        startgame.setToolTipText("");
        startgame.setBorderPainted(false);
        startgame.setSelected(true);
        startgame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startgameActionPerformed(evt);
            }
        });

        player.setBackground(new java.awt.Color(153, 0, 0));
        player.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(153, 204, 0)));
        player.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 204));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PLAYER 1");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 204), 1, true));

        jLabel4.setBackground(new java.awt.Color(255, 255, 204));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("NAME");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 204), 1, true));

        p1symbol.setBackground(new java.awt.Color(255, 204, 153));
        p1symbol.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        p1symbol.setText("Enter Your Symbol");
        p1symbol.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                p1symbolFocusGained(evt);
            }
        });

        p2name.setBackground(new java.awt.Color(255, 204, 153));
        p2name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        p2name.setText("Enter Your Name");
        p2name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                p2nameFocusGained(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 204));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Symbol");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 204), 1, true));

        jLabel6.setBackground(new java.awt.Color(255, 255, 204));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("NAME");
        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 204), 1, true));

        p1name.setBackground(new java.awt.Color(255, 204, 153));
        p1name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        p1name.setText("Enter Your Name");
        p1name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                p1nameFocusGained(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 204));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Number of Rounds");
        jLabel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 204), 1, true));

        p2symbol.setBackground(new java.awt.Color(255, 204, 153));
        p2symbol.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        p2symbol.setText("Enter Symbol of a 1 charecter");
        p2symbol.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                p2symbolFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                p2symbolFocusLost(evt);
            }
        });
        p2symbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p2symbolActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 204));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 204));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("PLAYER 2");
        jLabel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 204), 1, true));

        letsplay.setBackground(new java.awt.Color(255, 255, 204));
        letsplay.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        letsplay.setText("Lets Play !");
        letsplay.setToolTipText("");
        letsplay.setBorderPainted(false);
        letsplay.setSelected(true);
        letsplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                letsplayMouseClicked(evt);
            }
        });
        letsplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                letsplayActionPerformed(evt);
            }
        });
        letsplay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                letsplayKeyTyped(evt);
            }
        });

        resetdetails.setBackground(new java.awt.Color(255, 255, 204));
        resetdetails.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        resetdetails.setText("RESET");
        resetdetails.setBorderPainted(false);
        resetdetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetdetailsActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 204));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 204));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Symbol");
        jLabel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 204), 1, true));

        rounds.setBackground(new java.awt.Color(255, 204, 153));
        rounds.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        rounds.setText("Maximum 11");
        rounds.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                roundsFocusGained(evt);
            }
        });

        javax.swing.GroupLayout playerLayout = new javax.swing.GroupLayout(player);
        player.setLayout(playerLayout);
        playerLayout.setHorizontalGroup(
            playerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(playerLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(p1name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(playerLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(p1symbol, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(playerLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(playerLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(p2name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(playerLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(p2symbol, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(playerLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(rounds, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(playerLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(letsplay, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(playerLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(resetdetails, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        playerLayout.setVerticalGroup(
            playerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(playerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p1name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(playerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p1symbol, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(playerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p2name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(playerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p2symbol, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(playerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rounds, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(letsplay, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(resetdetails)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        commandscreen.setBackground(new java.awt.Color(153, 0, 0));
        commandscreen.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        commandscreen.setForeground(new java.awt.Color(255, 255, 204));
        commandscreen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        commandscreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commandscreenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(player, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(gameboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(startgame, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(result, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scoreboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(commandscreen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(commandscreen, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(scoreboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(player, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(gameboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(40, 40, 40)
                                .addComponent(startgame, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        startgame.getAccessibleContext().setAccessibleDescription("Click to Start the Game");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 1398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(header)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1402, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void restartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartActionPerformed
        resetbuttons();  
        letsplay.setEnabled(true);
        reset_details();
        resetbuttons();
        reset_score();
        score_board();
        disableplayername();
    }//GEN-LAST:event_restartActionPerformed

    private void startgameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startgameActionPerformed
        exit();        // TODO add your handling code here:
    }//GEN-LAST:event_startgameActionPerformed

    private void letsplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_letsplayMouseClicked
        player_details();
        

            // TODO add your handling code here:
    }//GEN-LAST:event_letsplayMouseClicked

    private void p1nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_p1nameFocusGained
        commandscreen.setText("Enter name of player 1");
        p1name.setText("");
    }//GEN-LAST:event_p1nameFocusGained

    private void p1symbolFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_p1symbolFocusGained
        commandscreen.setText("Enter Symbol of player 1");
        p1symbol.setText("");
    }//GEN-LAST:event_p1symbolFocusGained

    private void p2nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_p2nameFocusGained
        commandscreen.setText("Enter name of player 2"); 
        p2name.setText(""); 
    }//GEN-LAST:event_p2nameFocusGained

    private void p2symbolFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_p2symbolFocusGained
        commandscreen.setText("Enter Symbol of player 1");
        p2symbol.setText("");
    }//GEN-LAST:event_p2symbolFocusGained

    private void p1scoreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_p1scoreFocusGained
        p1score.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_p1scoreFocusGained

    private void p2scoreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_p2scoreFocusGained
        
        p2score.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_p2scoreFocusGained

    private void p1scoreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_p1scoreFocusLost
        p1score.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_p1scoreFocusLost

    private void p2scoreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_p2scoreFocusLost
        p2score.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_p2scoreFocusLost

    private void resetdetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetdetailsActionPerformed
        letsplay.setEnabled(true);
        reset_details();
        resetbuttons();
        reset_score();
        score_board();
        disableplayername();
        // TODO add your handling code here:
    }//GEN-LAST:event_resetdetailsActionPerformed

    private void p2symbolFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_p2symbolFocusLost
        letsplay.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_p2symbolFocusLost

    private void p2symbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p2symbolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p2symbolActionPerformed

    private void roundsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_roundsFocusGained
       commandscreen.setText("Enter total number of games");
        rounds.setText("");
            // TODO add your handling code here:
    }//GEN-LAST:event_roundsFocusGained

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        if(count<9)
        count++;
        else
        {
            status=check();
            setwinflag();
            check_for_result();
        }
        if(count%2!=0)
            point=p1sign.charAt(0);
        else 
            point=p2sign.charAt(0);
        
        if(check_key(0,point))
        {
            b1.setText(""+point);
            status=check();setwinflag();
            check_for_result();
            if(count%2==0) screen.setText(player1+"'s turn");
            else screen.setText(player2+"'s turn");
        }
        else 
            screen.setText("INVALID MOVE");
        
       // update(0,point);
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        // TODO add your handling code here:
        if(count<9)
        count++;
        else
        {
            status=check();
            setwinflag();
            check_for_result();
        }
        if(count%2!=0)
            point=p1sign.charAt(0);
        else 
            point=p2sign.charAt(0);
        if(check_key(1,point))
        {
            b2.setText(""+point);
            status=check();
            setwinflag();
            check_for_result();
            if(count%2==0) screen.setText(player1+"'s turn");
            else screen.setText(player2+"'s turn");
        }
        else 
            screen.setText("INVALID MOVE");
        
        //update(1,point);
    }//GEN-LAST:event_b2ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        // TODO add your handling code here:
        if(count<9)
        count++;
        else
        {
            status=check();
            setwinflag();
            check_for_result();
        }
        
        
        if(count%2!=0)
            point=p1sign.charAt(0);
        else 
            point=p2sign.charAt(0);
        if(check_key(2,point))
        {
            b3.setText(""+point);
            status=check();
            setwinflag();
            check_for_result();
            if(count%2==0) screen.setText(player1+"'s turn");
            else screen.setText(player2+"'s turn");
        }
        else 
            screen.setText("INVALID MOVE");
       // update(2,point);
    }//GEN-LAST:event_b3ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        // TODO add your handling code here:
        if(count<9)
        count++;
        else
        {
            status=check();check_for_result();
            setwinflag();
        }
        if(count%2!=0)
            point=p1sign.charAt(0);
        else 
            point=p2sign.charAt(0);
        if(check_key(3,point))
        {
            b4.setText(""+point);
            status=check();
            setwinflag();
            if(count%2==0) screen.setText(player1+"'s turn");
            else screen.setText(player2+"'s turn");
            check_for_result();
        }
        else 
            screen.setText("INVALID MOVE");
       // update(3,point);
    }//GEN-LAST:event_b4ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        // TODO add your handling code here:
        if(count<9)
        count++;
        else
        {
            status=check();
            setwinflag();
            check_for_result();
                    
        }
        if(count%2!=0)
            point=p1sign.charAt(0);
        else 
            point=p2sign.charAt(0);
        if(check_key(4,point))
        {
            b5.setText(""+point);
            status=check();
            setwinflag();check_for_result();
            if(count%2==0) screen.setText(player1+"'s turn");
            else screen.setText(player2+"'s turn");
        }
        else 
            screen.setText("INVALID MOVE");
        
    }//GEN-LAST:event_b5ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        if(count<9)
        count++;
        else
        {
            status=check();
            setwinflag();
        }
        
        if(count%2!=0)
            point=p1sign.charAt(0);
        else 
            point=p2sign.charAt(0);
        if(check_key(5,point))
        {
            b6.setText(""+point);
            status=check();
            setwinflag();
            check_for_result();
            if(count%2==0) screen.setText(player1+"'s turn");
            else screen.setText(player2+"'s turn");
        }
        else 
            screen.setText("INVALID MOVE");
    }//GEN-LAST:event_b6ActionPerformed

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
        if(count<9)
        count++;
        else
        {
            status=check();
            setwinflag();check_for_result();
        }
        if(count%2!=0)
            point=p1sign.charAt(0);
        else 
            point=p2sign.charAt(0);
        if(check_key(6,point))
        {
            b7.setText(""+point);
            status=check();
            setwinflag();check_for_result();
            if(count%2==0) screen.setText(player1+"'s turn");
            else screen.setText(player2+"'s turn");
        }
        else 
            screen.setText("INVALID MOVE");
    }//GEN-LAST:event_b7ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
        if(count<9)
        count++;
        else
        {
            status=check();
            setwinflag();
        }
        if(count%2!=0)
            point=p1sign.charAt(0);
        else 
            point=p2sign.charAt(0);
       if(check_key(7,point))
        {
            b8.setText(""+point);
            status=check();
            setwinflag();check_for_result();
            if(count%2==0) screen.setText(player1+"'s turn");
            else screen.setText(player2+"'s turn");
        }
        else 
            screen.setText("INVALID MOVE");
    }//GEN-LAST:event_b8ActionPerformed

    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b9ActionPerformed
        if(count<9)
        count++;
        else
        {
            status=check();
            setwinflag();check_for_result();
        }
        if(count%2!=0)
            point=p1sign.charAt(0);
        else 
            point=p2sign.charAt(0);
        if(check_key(8,point))
        {
            b9.setText(""+point);
            status=check();
            setwinflag();check_for_result();
            if(count%2==0) screen.setText(player1+"'s turn");
            else screen.setText(player2+"'s turn");
        }
        else 
            screen.setText("INVALID MOVE");
    }//GEN-LAST:event_b9ActionPerformed

    private void nextroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextroundActionPerformed
        // TODO add your handling code here:
        if(letsplay_flag==true)
        {
            resetbuttons();
        
        screen.setText(player1+"'s turn");
        lets_play();
        }
        else
            return;
    }//GEN-LAST:event_nextroundActionPerformed

    private void letsplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_letsplayActionPerformed
        // TODO add your handling code here:
        player_details();enableplayername();
        commandscreen.setText("GAME IS ON");
        
    }//GEN-LAST:event_letsplayActionPerformed

    private void resetscoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetscoreActionPerformed
        reset_score();
        enablescores();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_resetscoreActionPerformed

    private void letsplayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_letsplayKeyTyped
        // TODO add your handling code here:
        player_details();enableplayername();
        commandscreen.setText("GAME IS ON");
    }//GEN-LAST:event_letsplayKeyTyped

    private void commandscreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commandscreenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_commandscreenActionPerformed

    private void resultscreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultscreenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resultscreenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        tictactoe ob=new tictactoe();
       
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
        
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tictactoe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tictactoe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tictactoe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tictactoe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                 ob.setVisible(true);
                 ob.disablekeys();
                 ob.disableframes();
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    private javax.swing.JTextField commandscreen;
    private javax.swing.JPanel gameboard;
    private javax.swing.JLabel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton letsplay;
    private javax.swing.JButton nextround;
    private javax.swing.JTextField p1name;
    private javax.swing.JLabel p1scname;
    private javax.swing.JTextField p1score;
    private javax.swing.JTextField p1symbol;
    private javax.swing.JTextField p2name;
    private javax.swing.JLabel p2scname;
    private javax.swing.JTextField p2score;
    private javax.swing.JTextField p2symbol;
    private javax.swing.JPanel player;
    private javax.swing.JButton resetdetails;
    private javax.swing.JButton resetscore;
    private javax.swing.JButton restart;
    private javax.swing.JPanel result;
    private javax.swing.JTextField resultscreen;
    private javax.swing.JTextField rounds;
    private javax.swing.JPanel scoreboard;
    private javax.swing.JLabel screen;
    private javax.swing.JButton startgame;
    // End of variables declaration//GEN-END:variables

}
