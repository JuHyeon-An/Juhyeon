package MemberAndProductApp;

public class MemberVo {

	private String mId;
	private String pwd;
	private String mName;
	private String phone;
	
	public MemberVo(String mId, String pwd, String mName, String phone) {
		this.mId = mId;
		this.pwd = pwd;
		this.mName = mName;
		this.phone = phone;
	}
	
	@Override
	public int hashCode() {
		return mId.hashCode() + phone.hashCode(); 

	}
	
	@Override
	public boolean equals(Object obj) { // obj가 어떤 타입인지 알 수 없다. (Object는 모든 클래스의 부모라)
		boolean result = false;
		if(obj instanceof MemberVo) {
			MemberVo vo = (MemberVo) obj;
			if(vo.getmId().equals(mId) && vo.getPhone().equals(phone)) {
				result = true;
			}
		}
		return result;
	}
	
	@Override
	public String toString() {
		return mId + "\t" + pwd + "\t" + mName + "\t" + phone + "\n"; // 추후 변경
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
