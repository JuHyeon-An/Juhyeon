package MemberAndProductApp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductVo {

	private String serial; // yyyy - mm - dd - serial 형태로 저장
	private String pCode;
	private String pName;
	private int    ea; // 수량
	private Date   nal; // 입고, 출고일자
	
	
//	매개변수 있는 생성자 하나, 없는 생성자 하나 오버로딩
	ProductVo(){}
	
	ProductVo(String serial, String pCode, String pName, int ea, Date nal){
		this.serial = serial;
		this.pCode = pCode;
		this.pName = pName;
		this.ea = ea;
		this.nal = nal;
	}
	
	
//	동등객체인지 아닌지 판단하기 위한 (1차) => 선택
	@Override
	public int hashCode() {
		return this.serial.hashCode(); // 시리얼 번호가 동일하면 똑같은 코드
	}

	
//	검색을 용이하게 하기 위한 equals => 필수
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
	
		if (obj instanceof ProductVo) {
			ProductVo vo = (ProductVo) obj;
		
			result = serial.indexOf(vo.getSerial()) > -1 ||
					pCode.indexOf(vo.getpCode()) > -1 ||
					pName.indexOf(vo.getpName()) > -1;
		
		}
		return result;
	}
	
	@Override
	public String toString() {
		
		DecimalFormat df = new DecimalFormat("#,###,###"); // 수량 : 천단위 분류기호
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)"); // 날짜형식
		
		String tempEa = df.format(this.ea);
		String tempDate = sdf.format(this.nal);
		
		String temp = String.format("%s\t%s\t%s\t%s\t%s\n",
				this.serial, this.pCode, this.pName, tempEa, tempDate);
		
		return temp;
	}
	
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getEa() {
		return ea;
	}
	public void setEa(int ea) {
		this.ea = ea;
	}
	public Date getNal() {
		return nal;
	}
	public void setNal(Date nal) {
		this.nal = nal;
	}

	
	
	
}
