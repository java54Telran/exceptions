package telran.exceptions.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.exceptions.BallBrokenFloor;

class BallBrokenFloorTest {

	private static final int N_FLOORS = 100;
	private static final int N_RUNS = N_FLOORS * 4;

	@Test
	void test() {
		for (int i = 0; i < N_RUNS; i++) {
			BallBrokenFloor bbf = new BallBrokenFloor(N_FLOORS);
			assertEquals(bbf.getBrokenFloor(), getMinBrokenFloor(bbf));
		}
	}

	private int getMinBrokenFloor(BallBrokenFloor bbf) {
		//using binary search algorithm and only method checkFloor
		//of the class BallBrokenFloor 
		//you should find minimal floor, from which a ball will be broken
		int lowerFloor = 1;
		int upperFloor = N_FLOORS;
		int intermediate = (lowerFloor + upperFloor) / 2;
		while (lowerFloor <= upperFloor) {
			try {
				bbf.checkFloor(intermediate);
				lowerFloor = intermediate + 1;
			} catch (Exception e) {
				upperFloor = intermediate - 1;
			}
			intermediate = (lowerFloor + upperFloor) / 2;
		}
		return lowerFloor;
	}

}
