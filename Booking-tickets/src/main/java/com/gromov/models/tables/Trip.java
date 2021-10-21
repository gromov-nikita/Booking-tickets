package com.gromov.models.tables;
import com.gromov.models.interfaces.Table;

import java.sql.Timestamp;
public class Trip implements Table {
    private Path path;
    private Timestamp date;
    private Transport transport;
    public Trip(Path path, Timestamp date, Transport transport) {
        this.path = path;
        this.date = date;
        this.transport = transport;
    }
    public Path getPath() {
        return path;
    }
    public Timestamp getDate() {
        return date;
    }
    public Transport getTransport() {
        return transport;
    }
}
