package com.infomaximum.services;

public class StatisticFactoryImpl implements StatisticFactory {
    @Override
    public CountingObjectsWithSameGroupAndType getCountingObjectsWithSameGroupAndType() {
        return new CountingObjectsWithSameGroupAndType();
    }

    @Override
    public SummingTotalWeightOfGroup getSummingTotalWeightOfGroup() {
        return new SummingTotalWeightOfGroup();
    }

    @Override
    public MaxWeight getMaxWeight() {
        return new MaxWeight();
    }

    @Override
    public MinWeight getMinWeight() {
        return new MinWeight();
    }
}
