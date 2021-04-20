package app.service;

import app.domain.entities.dto.MyDate;

public interface MyDateServ {
    MyDate getRandomDate();

    MyDate plusHour(MyDate date);
}

