package app.service.serviceImplementation;

import app.domain.entities.dto.MyDate;
import org.springframework.stereotype.Service;
import app.service.MyDateServ;

import java.util.Random;

@Service
public class MyDateServImpl implements MyDateServ {
    private static final Random random = new Random();

    @Override
    public MyDate getRandomDate() {
        return new MyDate(random.nextInt(31) + 1, random.nextInt(24));
    }

    @Override
    public MyDate plusHour(MyDate date) {

        if (date.getHour()  == 23 && date.getDay() == 31) throw new IllegalArgumentException("Дни закончились");
        if (date.getHour()  == 23) {
            date.setHour(0);
            date.setDay(date.getDay()+1);
        } else {
            date.setHour(date.getHour()+1);
        }
      return  date;
    }


}
