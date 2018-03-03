package com.kodilla.good.patterns.SOLID;

import java.time.LocalDateTime;

public class CarRentalService implements RentalService{

    public boolean rent(final User user, final LocalDateTime carRentFrom, final LocalDateTime carRentTo){
        System.out.println("Renting Car to: " + user.getName() + user.getSurname()
        + " from: " + carRentFrom.toString() + " to: " + carRentTo.toString());
        return true;
    }

    @Override
    public boolean createRental(User user, LocalDateTime from, LocalDateTime to) {
        return false;
    }


}
