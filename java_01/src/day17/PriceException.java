package day17;

import java.io.IOException;

public class PriceException extends IOException {
	public PriceException() {
		super("PriceException : 음수 허용 안됨");
	}
	public PriceException(String msg) {
		super(msg);
	}
}
