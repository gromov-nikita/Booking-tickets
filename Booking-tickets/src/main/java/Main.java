import com.gromov.models.transport.Transport;

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
        int[] rows = {
                6,4,2
        };
        int[] columns = {
                10,6,3
        };
        Transport plane = new Transport(3,rows,columns);
        for(String x : plane.getLayOut()) {
            System.out.println(x);
        }
    }
}
