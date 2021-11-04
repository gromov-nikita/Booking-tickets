import com.gromov.models.entity.TripEntity;
import com.gromov.service.hibernate.HibernateUtil;
import com.gromov.service.manager.OrderManager;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import java.util.List;

/*
Develop a ticket booking application
When user start to work with the application, the user must register,
if user cancels registration, the user is given access to the application in a read mode
(for example, only viewing flights),
The user should be given the opportunity to see the order history.the user can cancel the order by clicking on
the appropriate button.
After completion of order user should see information about status order.
All input data (date of flight, first name ….) should have error handling.
User can leave comments about any flight. Need to provide option to give user information about ticket booking
(pdf, email)

Use patterns, logging, properties file
db: ms sql
 */
public class Main {
    public static void main(String[] args) {
        List<TripEntity> trips = OrderManager.getTrips();
        String answer = "";
        for(int i = 0; i < trips.size(); i++) {
            answer+= trips.get(i).toString() + "\n";
        }
        System.out.println(answer);

    }
}
