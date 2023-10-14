import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidaCPFTest {

	@Test
	void test() {
		ValidaCPF vCPF = new ValidaCPF();
		assertFalse(vCPF.isCPF("00000000000"));
	}
	
	@Test
	void test1() {
		ValidaCPF vCPF = new ValidaCPF();
		assertFalse(vCPF.isCPF("21309360839"));		
	}
	
	@Test
	void test2() {
		ValidaCPF vCPF = new ValidaCPF();
		assertFalse(vCPF.isCPF("1111111111"));		
	}
	
	@Test
	void test3() {
		ValidaCPF vCPF = new ValidaCPF();
		assertFalse(vCPF.isCPF("erqeuoiquerique"));		
	}
}
