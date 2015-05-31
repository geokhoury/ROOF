package jo.edu.gju.roof.OfyService;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

import jo.edu.gju.roof.entities.*;

public class OfyService {
    static {
        factory().register(Room.class);
        factory().register(Schedule.class);
        factory().register(Reservation.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}