package day24;

import java.util.ArrayList;
import java.util.Vector;

public class test01 {
	public static void main(String[] args) {
		System.out.println("=============main start==========");
		Account account = new Account("2019001", "신재훈", Integer.MAX_VALUE);
		Job1 j1 = new Job1(account);
		Job1 j2 = new Job1(account);
		
		Thread t1 = new Thread(j1, "통장");
		Thread t2 = new Thread(j2, "카드");
		
		t1.start();
		t2.start();
		
		System.out.println("=============main end==========");
		
		ArrayList a;  //어레이는 싱크로나이즈드 안돼있음 벡터는 되어있음
		Vector b;
	}
	}

class Job1 implements Runnable {

	Account ac;
	
	public Job1() {
		
	}
	
	public Job1(Account ac) {
		super();
		this.ac = ac;
	}


	@Override

	public void run() {
		for (int i = 0; i < 5; i++) {
			int money = (int)(Math.random()*7+1)*1000;
			ac.withdraw(money);
		}
	}

}

class Account {
	String number, name;
	int money;

	public Account() {

	}

	public Account(String number, String name, int money) {
		super();
		this.number = number;
		this.name = name;
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account [number=" + number + ", name=" + name + ", money=" + money + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + money;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
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
		return true;
	}

	public synchronized void withdraw(int money) { //싱크로나이즈드 블락걸면 다른애들은 간섭못함.
		System.out.println("=====출금" + money + "==========");
		System.out.println(Thread.currentThread());
		if (this.money >= money) {
			this.money -= money;
			System.out.println("출금완료");
			System.out.println("잔고 : " + this.money);
		} else {
			System.out.println("잔액 부족");
		}

		System.out.println("============================");
	}

}