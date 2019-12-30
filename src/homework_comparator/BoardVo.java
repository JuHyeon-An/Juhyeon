package homework_comparator;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardVo {
   public String no;
   public String subject;
   public String content;
   public String mId;
   public String mDate;
   public String cnt;
   
   SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일hh시mm분ss초");
   String strDate = sdf.format(new Date());

   public BoardVo(String no, String subject, String content, String mId, String cnt) {
      this.no = no;
      this.subject = subject;
      this.content = content;
      this.mId = mId;
      this.mDate = strDate;
      this.cnt = cnt;

   }

   public String getNo() {
      return no;
   }

   public void setNo(String no) {
      this.no = no;
   }

   public String getSubject() {
      return subject;
   }

   public void setSubject(String subject) {
      this.subject = subject;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public String getmId() {
      return mId;
   }

   public void setmId(String mId) {
      this.mId = mId;
   }

   public String getmDate() {
      return mDate;
   }

   public void setmDate(String mDate) {
      this.mDate = mDate;
   }

   public String getCnt() {
      return cnt;
   }

   public void setCnt(String cnt) {
      this.cnt = cnt;
   }



   @Override
   public String toString() {
      String temp = "";

      String dm = "게시물번호 : {0} \n 제목 : {1} \n\n {2} \n\n 작성자 아이디 : {3} \n\n 작성일 : {4} \n\n 조회수 : {5}";
      dm += "\n-------------------------------------------------------------------------------\n\n";

      temp = MessageFormat.format(dm, no, subject, content, mId, mDate, cnt);
      return temp;
   }

}