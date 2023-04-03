package com.infomaximum.services;

public interface StatisticFactory {

    CountingObjectsWithSameGroupAndType getCountingObjectsWithSameGroupAndType();

    SummingTotalWeightOfGroup getSummingTotalWeightOfGroup();

    MaxWeight getMaxWeight();

    MinWeight getMinWeight();
}
