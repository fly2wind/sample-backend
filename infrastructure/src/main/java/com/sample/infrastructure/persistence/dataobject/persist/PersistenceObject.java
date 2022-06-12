package com.sample.infrastructure.persistence.dataobject.persist;

import java.io.Serializable;

public interface PersistenceObject<T> extends Serializable {
    T toEntityObject();
}
