package io_App;

import java.io.Serializable;

public class MemberVo implements Serializable{
// 객체를 생성해서 메모리에 올리는게 아니라면 직렬화 필요
//	Serializable  : 추상메소드가 X (구현만 하면 된다)
	
	static long serialVersionUID = 1L; // 상수에 임의의 번호
	// 1L 이 번호가 똑같으면 같은 컴퓨터에서 작업했다고 간주함
	// 서로 다른 컴퓨터에서 컴파일 하더라도 시리얼호 UID 번호값이 같으면 동일한 컴퓨터에서 컴파일한 파일로 인식
	
	private String mId;
	private String pwd;
	private String mName;
	private String phone;
//	보안을 위해 필드 : private, 이에 대한 getter setter를 public으로 작성
//	setter, getter 메소드 내에 권한자만 값에 접근할 수 있는 조건을 세팅함
	
	public MemberVo(String mId, String pwd, String mName, String phone) {
		this.mId = mId;
		this.pwd = pwd;
		this.mName = mName;
		this.phone = phone;
	}
	
	@Override
	public int hashCode() {
		return mId.hashCode() + phone.hashCode();
//		아이디와 연락처가 똑같으면 동등객체 (값이 똑같다는 것과는 다른 의미)
//		Id, pwd 등 다 달라도 hashCode 상수 1로 리턴하면 동등객체로 인식함
//		그에 반해 equals는 안쪽의 값 하나 하나를 비교하는 것에 가깝다

	}
	
	@Override
	public boolean equals(Object obj) { // obj가 어떤 타입인지 알 수 없다. (Object는 모든 클래스의 부모라)
		String find = (String)obj;
		boolean result = false;
			if(mId.indexOf(find)>=0 ||
			   mName.indexOf(find)>=0 || 
			   phone.indexOf(find)>=0) {
				result = true;
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
