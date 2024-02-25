package com.comsystem.homework.robot;
import java.util.*;

import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;

public class RobotOperations {

    public RobotPlan excavateStonesForDays(int days) {
        int cloneDays = days / 2;
        int digDays = days - cloneDays;
        int numberOfStones = (int) Math.pow(2, cloneDays) * digDays;

        List<RobotAction> actions = new ArrayList<>(Collections.nCopies(cloneDays, RobotAction.CLONE));
        actions.addAll(Collections.nCopies(digDays, RobotAction.DIG));

        return new RobotPlan(days, numberOfStones, actions);
    }

    public RobotPlan daysRequiredToCollectStones(int numberOfStones) {
        int days = 1;
        while (true) {
            int maxStones = 0;
            for (int cloneDays = 0; cloneDays <= days; cloneDays++) {
                int digDays = days - cloneDays;
                int currentStones = (int) Math.pow(2, cloneDays) * digDays;
                maxStones = Math.max(maxStones, currentStones);
                if (maxStones >= numberOfStones) {
                    List<RobotAction> actions = new ArrayList<>(Collections.nCopies(cloneDays, RobotAction.CLONE));
                    actions.addAll(Collections.nCopies(digDays, RobotAction.DIG));
                    return new RobotPlan(days, maxStones, actions);
                }
            }
            days++;
        }
    }
}


