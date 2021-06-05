package app.service.serviceImplementation;

import app.domain.entities.dto.MyDate;
import app.domain.entities.dto.ShipDto;
import app.service.MyDateServ;
import app.service.PortServ;
import app.service.SimulationServ;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimulationServImpl implements SimulationServ {
    static Logger LOGGER = Logger.getLogger(SimulationServImpl.class);
    private final PortServ portServ;
    private final MyDateServ myDateServ;

    @Autowired
    public SimulationServImpl(PortServ portServ, MyDateServ myDateServ){
        this.portServ = portServ;
        this.myDateServ = myDateServ;
    }

    @Override
    public void start() throws InterruptedException {
        MyDate date = new MyDate(1, 0);
        portServ.initPort();

        while (true) {
//            System.out.println("--------------" + date.toString() + "--------------");
            LOGGER.info("--------------" + date + "--------------");
            portServ.unloadShips(date);
            ShipDto shipDto = portServ.getNotArrivedShipOrEmpty();
            if (shipDto != null) {
                portServ.shipArrival(shipDto, new MyDate(date));
            }
            portServ.checkUnload(date);
            date = myDateServ.plusHour(date);
            Thread.sleep(500);
        }
    }
}
