package com.kodilla.good.patterns.SOLID;

import java.time.LocalDateTime;

public interface RentalRepository {

    boolean createRental(User user, LocalDateTime from, LocalDateTime to);

}
