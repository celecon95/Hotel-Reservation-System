package com.practical.guest.common.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
public class BaseEvent {

    @TargetAggregateIdentifier
    private final String phoneNumber;

    private final String name;
}
