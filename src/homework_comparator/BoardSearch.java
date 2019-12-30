package homework_comparator;

import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.awt.event.ActionEvent;

public class BoardSearch extends JInternalFrame {
   private JPanel panel;
   private JButton btnNewButton;
   private JScrollPane scrollPane;
   private JTextArea textArea;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               BoardSearch frame = new BoardSearch();
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
   public BoardSearch() {
      super("Board Search",true,true,true,true);
      setBounds(100, 100, 455, 403);
      getContentPane().add(getPanel(), BorderLayout.NORTH);
      getContentPane().add(getScrollPane(), BorderLayout.CENTER);
      setVisible(true);

   }

   private JPanel getPanel() {
      if (panel == null) {
         panel = new JPanel();
         panel.setPreferredSize(new Dimension(10, 30));
         panel.add(getBtnNewButton());
      }
      return panel;
   }
   
   
   private JButton getBtnNewButton() {
      if (btnNewButton == null) {
         btnNewButton = new JButton("\uB0B4\uB9BC\uCC28\uC21C \uC815\uB82C");
         btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
               //3번 배열에 저장된 내용을 작성일 순으로 내림차순 정렬
               
//               boolean sort = true;
//               int lastIndex = BoardMain.count - 1; //
//               while (sort) {
//                  sort = false;
//                  for (int i = 0; i < lastIndex; i++) {
//                     int result = Objects.compare(BoardMain.data[i],BoardMain.data[i+1] , new BoardComparator());
//                     if (result<0) {
//                        BoardVo t =BoardMain.data[i];
//                        BoardMain.data[i]= BoardMain.data[i+1];
//                        BoardMain.data[i+1] =  t;
//                        sort = true;
//                     }
//                  }
//                  lastIndex--;
//               }         
            	Collections.sort(Arrays.asList(BoardMain.data), new BoardComparator());
            	StringBuilder sb = new StringBuilder(1024);
            	for (int i = 0; i < BoardMain.count; i++) {
            		sb.append(BoardMain.data[i].toString());
            	}
            	textArea.setText(sb.toString());
            	
            }
         });
      }
      return btnNewButton;
   }
   private JScrollPane getScrollPane() {
      if (scrollPane == null) {
         scrollPane = new JScrollPane();
         scrollPane.setViewportView(getTextArea());
      }
      return scrollPane;
   }
   private JTextArea getTextArea() {
      if (textArea == null) {
         textArea = new JTextArea();
      }
      return textArea;
   }
}