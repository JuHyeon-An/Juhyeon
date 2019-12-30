package homework_comparator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

public class BoardMain extends JFrame {

   private JDesktopPane contentPane;
   private JMenuBar menuBar;
   private JMenu mnNewMenu;
   private JMenuItem mntmNewMenuItem;
   private JMenuItem mntmNewMenuItem_1;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               BoardMain frame = new BoardMain();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public BoardMain() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 577, 452);
      setJMenuBar(getMenuBar_1());
      contentPane = new JDesktopPane();
      contentPane.setBackground(Color.WHITE);
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setLayout(new BorderLayout(0, 0));
      setContentPane(contentPane);
   }
   
   static int count = 0;
   static BoardVo[] data = new BoardVo[100]; 
   
   
   static {
       data[0] = new BoardVo("1","����1","����1","���̵�1","��ȸ��1");
       data[1] = new BoardVo("2","����2","����2","���̵�2","��ȸ��2");
       data[2] = new BoardVo("3","����3","����3","���̵�3","��ȸ��3");
       
       count =3;
   }

   private JMenuBar getMenuBar_1() {
      if (menuBar == null) {
         menuBar = new JMenuBar();
         menuBar.add(getMnNewMenu());
      }
      return menuBar;
   }
   private JMenu getMnNewMenu() {
      if (mnNewMenu == null) {
         mnNewMenu = new JMenu("\uC785\uB825 or \uC870\uD68C");
         mnNewMenu.add(getMntmNewMenuItem());
         mnNewMenu.add(getMntmNewMenuItem_1());
      }
      return mnNewMenu;
   }
   private JMenuItem getMntmNewMenuItem() {
      if (mntmNewMenuItem == null) {
         mntmNewMenuItem = new JMenuItem("\uC785\uB825");
         mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               //�Է�
               BoardInput bi = new BoardInput();
               contentPane.add(bi);
            }
         });
      }
      return mntmNewMenuItem;
   }
   private JMenuItem getMntmNewMenuItem_1() {
      if (mntmNewMenuItem_1 == null) {
         mntmNewMenuItem_1 = new JMenuItem("\uC870\uD68C");
         mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               //��ȸ
               BoardSearch bs = new BoardSearch();
               contentPane.add(bs);
            }
         });
      }
      return mntmNewMenuItem_1;
   }
}