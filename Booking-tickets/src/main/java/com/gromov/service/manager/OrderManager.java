package com.gromov.service.manager;
import com.gromov.service.db.query.*;
import com.gromov.models.tables.Order;
import com.gromov.service.db.query.queryBuilder.QueryStringBuilder;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class OrderManager {
    private Queries queries;
    public OrderManager(Queries queries) {
        this.queries = queries;
    }
    public void makeOrder() throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, SQLException {

    }

}
