package com.gromov.models.interfaces;

public interface Table {
    default String getTableName() {
        return this.getClass().getSimpleName();
    }
}
