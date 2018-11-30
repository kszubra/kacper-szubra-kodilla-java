package com.kodilla.good.patterns.challenges.three.producers;

import com.kodilla.good.patterns.challenges.three.OrderForProducer;

public interface Producer {
    boolean process(OrderForProducer order);
}
