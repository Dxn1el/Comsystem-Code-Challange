package com.comsystem.homework;

import com.comsystem.homework.model.RobotPlan;
import com.comsystem.homework.robot.RobotOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.* ;
public class RobotOperationsTest {
    @Test
    void testDaysRequiredToCollectStones() {
        RobotOperations operations = new RobotOperations();
        int numberOfStones = 8; // Example: For collecting 8 stones
        RobotPlan result = operations.daysRequiredToCollectStones(numberOfStones);

        // To collect 8 stones optimally, assuming the robot clones for 2 days (4 robots), then digs for 1 day (4 stones)
        // But since we want at least 8 stones, we might need to adjust this example based on the implemented logic.
        // This is just a basic scenario and might need adjustments based on actual logic outcomes.
        Assertions.assertTrue(result.numberOfDays() <= 4); // Adjust based on actual implementation
        Assertions.assertEquals(8, result.numberOfStones());
        // Assertions on the actions might need to be adjusted based on the actual implementation logic
    }

    @Test
    void testExcavateStonesForDays() {
        RobotOperations operations = new RobotOperations();
        int days = 4; // Example: For 4 days
        RobotPlan result = operations.excavateStonesForDays(days);

        // Assuming the optimal strategy is to clone for half the time and dig for the rest,
        // for 4 days: clone for 2 days (4 robots), then dig for 2 days (4*2 = 8 stones)
        Assertions.assertEquals(8, result.numberOfStones());
        Assertions.assertEquals(4, result.numberOfDays());
        Assertions.assertEquals("[CLONE, CLONE, DIG, DIG]", result.robotActions().toString());
    }

}
