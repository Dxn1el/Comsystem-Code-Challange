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
        int numberOfStones = 8;
        RobotPlan result = operations.daysRequiredToCollectStones(numberOfStones);
        Assertions.assertTrue(result.numberOfDays() <= 4);
        Assertions.assertEquals(8, result.numberOfStones());

    }

    @Test
    void testExcavateStonesForDays() {
        RobotOperations operations = new RobotOperations();
        int days = 4;
        RobotPlan result = operations.excavateStonesForDays(days);


        Assertions.assertEquals(8, result.numberOfStones());
        Assertions.assertEquals(4, result.numberOfDays());
        Assertions.assertEquals("[CLONE, CLONE, DIG, DIG]", result.robotActions().toString());
    }

}
