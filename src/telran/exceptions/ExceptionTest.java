package telran.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExceptionTest {

	int floorsThatYouWant = 1000000;

	@Test
	void ballBrokenFloorTest() {
		BallBrokenFloor bbf = new BallBrokenFloor(floorsThatYouWant);
		assertEquals(bbf.getFloor(), getMinFloor(bbf));
	}

	private int getMinFloor(BallBrokenFloor bbf) {
		int serchingFloor = 0;
	//	int secret = bbf.getFloor();
		int minFloor = 1;
		int maxFloor = floorsThatYouWant;
		while (minFloor <= maxFloor) {
			int middle = (minFloor + maxFloor) / 2;
			try {
				bbf.broken(middle);
				minFloor = middle + 1;
			} catch (Exception e) {
				try {
					bbf.broken(middle - 1);
					serchingFloor = middle;
					return serchingFloor;
				} catch (Exception e2) {
					maxFloor = middle - 1;
				}
			}
		}
		return serchingFloor;
	}

//	@Test
//	void testExeption() {
//		int res = 0;
//		try {
//			res = itThrowsCheckedException(10000);
//			System.out.println("everything fine");
//		} catch (RuntimeException e) {
//			System.out.println(e.getMessage());
//			res = 100;
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			res = 200;
//		}
//
//		assertEquals(100, res);
//	}
//
//	private int itThrowsCheckedException(int number) throws Exception {
//		if (number < 0) {
//			throw new Exception("just test checked exception");
//		}
//		if (number > 1000) {
//			throw new RuntimeException("wrong number ");
//		}
//		return number * 2;
//	}
}
