package com.kodilla.good.patterns.SOLID;

import java.time.LocalDateTime;

public class CarRentalRepository implements RentalRepository{

    @Override
    public boolean createRental(User user, LocalDateTime from, LocalDateTime to) {
        return false;
    }
}
