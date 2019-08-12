package interface_ex_tv;

interface TV {
	public void poweron();
	public void poweroff();
}

class STV implements TV{
	public void poweron() {
		System.out.println("STV poweron");
	}

	public void poweroff() {
		System.out.println("STV poweroff");

	}
}

class LTV implements TV {
	public void poweron() {
		System.out.println("LTV on");
	}

	public void poweroff() {
		System.out.println("LTV off");
	}
	
	
}

class ITV implements TV{
	public void poweron() {
		System.out.println("ITV on");
	}

	public void poweroff() {
		System.out.println("ITV off");
	}
	
}
