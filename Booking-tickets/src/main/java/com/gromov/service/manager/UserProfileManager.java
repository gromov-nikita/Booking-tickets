package com.gromov.service.manager;
import com.gromov.models.tables.User;
import com.gromov.service.db.query.Queries;
import com.gromov.service.db.query.queryBuilder.QueryStringBuilder;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class UserProfileManager {
    private Queries queries;
    public UserProfileManager(Queries queries) {
        this.queries = queries;
    }
    public User logIn(String email, String password) throws NoSuchFieldException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            SQLException, InstantiationException {
        List<User> user = queries.pull(QueryStringBuilder.selectBy(User.class,
                User.class.getField("email"),email),User.class);
        if(user.size() != 0) {
            if(user.get(0).getPassword() == password) {
                return user.get(0);
            }
            else throw new IllegalArgumentException("password not found");
        }
        throw new IllegalArgumentException("email or password not found");
    }
    public User signUp(String firstName, String lastName,String email, String passportID, String password) throws
            NoSuchMethodException, IllegalAccessException, InvocationTargetException, SQLException {
        User user = new User(firstName,lastName,passportID,email,password);
        queries.push(QueryStringBuilder.insert(user));
        return user;
    }
    public void makeOrder() {

    }
}
