/*
 * Copyright © 2018 CHANGLEI. All rights reserved.
 */

package me.box.app.elevator.control;

import me.box.app.elevator.model.OutsideFloor;

import java.util.stream.Stream;

/**
 * Created by box on 2018/3/16.
 * <p>
 * 组装电梯
 */
@SuppressWarnings("SameParameterValue")
public class Assembler {

    private ElevatorManager mElevatorManager;

    public static ElevatorManager install() {
        Assembler assembler = new Assembler();
        ElevatorManager manager = assembler.mElevatorManager;
        if (manager == null) {
            manager = new ElevatorManager(assembler.assemble());
            assembler.mElevatorManager = manager;
        }
        return manager;
    }

    /**
     * 组装电梯
     *
     * @return 组装好的电梯
     */
    private Elevator assemble() {
        return new Elevator(OutsideFloor.createFloors(range(-2, 1, 14)));
    }

    private static Integer[] range(int seed, int speed, int count) {
        return Stream.iterate(seed, index -> index + speed).limit(count).toArray(value -> new Integer[count]);
    }
}
