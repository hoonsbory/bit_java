package day23;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Account_test {
	public static void main(String[] args) {
		String filename = "account.obj";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fos);
			
			Set<Account> set = new HashSet<Account>();
			
			Account a = new Account("신재훈", "1234", 8000000, "2019-02");
			Account b = new Account("홍길동", "1235", 100, "2020-02");
			set.add(a);
			set.add(b);
			set.add(new Account("이국희", "123", 200000, "2020-12"));
//			String name = "홍길덩";
//			Date d = new Date();
			oos.writeObject(set);
			oos.flush();
			System.out.println("파일에 저장되었습니다!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fos != null)
					fos.close();
				if (oos != null)
					oos.close();
			} catch (Exception e2) {
			}
		}

		System.out.println("======main end=======");
	}

	
}

class Account extends Object implements Serializable{
	String name;
	transient String pw; //비밀번호는 스트림을 통과하면 안됨. transient를 써서 스트림 통과못함.
	int money;
	String number;

	public Account() {

	}

	

	public Account(String name, String pw, int money, String number) {
		super();
		this.name = name;
		this.pw = pw;
		this.money = money;
		this.number = number;
	}



	@Override
	public String toString() {
		return "Account [name=" + name + ", pw=" + pw + ", number=" + number + ", money=" + money + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + money;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (money != other.money)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		return true;
	}

}