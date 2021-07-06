package com.practical.guest.command.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
public class BaseCommand {

    @TargetAggregateIdentifier
    private final String phoneNumber;

    private final String name;
}
