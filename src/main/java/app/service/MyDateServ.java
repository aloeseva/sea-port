package app.service;

import app.domain.entities.dto.MyDate;

public interface MyDateServ {
    MyDate getRandomDate();

    String toString(MyDate date);

    MyDate plusHour(MyDate date);
}

