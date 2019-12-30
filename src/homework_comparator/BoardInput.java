package homework_comparator;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BoardInput extends JInternalFrame {
   private JLabel lblNewLabel;
   private JLabel label;
   private JLabel lblNewLabel_1;
   private JLabel lblNewLabel_2;
   private JLabel lblNewLabel_3;
   private JLabel lblNewLabel_4;
   private JTextField no;
   private JTextField subject;
   private JTextField content;
   private JTextField mId;
   private JTextField mDate;
   private JTextField cnt;
   private JButton btnNewButton;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               BoardInput frame = new BoardInput();
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
   public BoardInput() {
      super("BoardInput",true,true,true,true);
      setBounds(100, 100, 450, 300);
      getContentPane().setLayout(null);
      getContentPane().add(getLblNewLabel());
      getContentPane().add(getLabel());
      getContentPane().add(getLblNewLabel_1());
      getContentPane().add(getLblNewLabel_2());
      getContentPane().add(getLblNewLabel_3());
      getContentPane().add(getLblNewLabel_4());
      getContentPane().add(getNo());
      getContentPane().add(getSubject());
      getContentPane().add(getContent());
      getContentPane().add(getMId());
      getContentPane().add(getMDate());
      getContentPane().add(getCnt());
      getContentPane().add(getBtnNewButton());
      setVisible(true);

   }

   private JLabel getLblNewLabel() {
      if (lblNewLabel == null) {
         lblNewLabel = new JLabel("\uAC8C\uC2DC\uBB3C \uBC88\uD638");
         lblNewLabel.setBounds(12, 10, 83, 15);
      }
      return lblNewLabel;
   }
   private JLabel getLabel() {
      if (label == null) {
         label = new JLabel("\uC81C\uBAA9");
         label.setBounds(12, 35, 57, 15);
      }
      return label;
   }
   private JLabel getLblNewLabel_1() {
      if (lblNewLabel_1 == null) {
         lblNewLabel_1 = new JLabel("\uB0B4\uC6A9");
         lblNewLabel_1.setBounds(12, 60, 57, 15);
      }
      return lblNewLabel_1;
   }
   private JLabel getLblNewLabel_2() {
      if (lblNewLabel_2 == null) {
         lblNewLabel_2 = new JLabel("\uC544\uC774\uB514");
         lblNewLabel_2.setBounds(12, 85, 76, 15);
      }
      return lblNewLabel_2;
   }
   private JLabel getLblNewLabel_3() {
      if (lblNewLabel_3 == null) {
         lblNewLabel_3 = new JLabel("\uC791\uC131\uC77C");
         lblNewLabel_3.setBounds(12, 118, 57, 15);
      }
      return lblNewLabel_3;
   }
   private JLabel getLblNewLabel_4() {
      if (lblNewLabel_4 == null) {
         lblNewLabel_4 = new JLabel("\uC870\uD68C\uC218");
         lblNewLabel_4.setBounds(12, 154, 57, 15);
      }
      return lblNewLabel_4;
   }
   private JTextField getNo() {
      if (no == null) {
         no = new JTextField();
         no.setBounds(107, 7, 116, 21);
         no.setColumns(10);
      }
      return no;
   }
   private JTextField getSubject() {
      if (subject == null) {
         subject = new JTextField();
         subject.setBounds(107, 32, 116, 21);
         subject.setColumns(10);
      }
      return subject;
   }
   private JTextField getContent() {
      if (content == null) {
         content = new JTextField();
         content.setBounds(107, 57, 116, 21);
         content.setColumns(10);
      }
      return content;
   }
   private JTextField getMId() {
      if (mId == null) {
         mId = new JTextField();
         mId.setBounds(107, 82, 116, 21);
         mId.setColumns(10);
      }
      return mId;
   }
   private JTextField getMDate() {
      if (mDate == null) {
         mDate = new JTextField();
         mDate.setBounds(107, 115, 116, 21);
         mDate.setColumns(10);
      }
      return mDate;
   }
   private JTextField getCnt() {
      if (cnt == null) {
         cnt = new JTextField();
         cnt.setBounds(107, 151, 116, 21);
         cnt.setColumns(10);
      }
      return cnt;
   }
   private JButton getBtnNewButton() {
      if (btnNewButton == null) {
         btnNewButton = new JButton("\uD655\uC778");
         btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                  
                  
                  String s1 = no.getText();
                  String s2 = subject.getText();
                  String s3 = content.getText();
                  String s4 = mId.getText();
                  String s6 = cnt.getText();
                  
                  BoardMain.data[BoardMain.count] = new BoardVo(s1,s2,s3,s4,s6);
                  BoardMain.count++;
            }
            
         });
         btnNewButton.setBounds(107, 206, 97, 23);
      }
      return btnNewButton;
   }
}