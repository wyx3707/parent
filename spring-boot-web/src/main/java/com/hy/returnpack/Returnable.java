package com.hy.returnpack;

import java.io.Serializable;

public interface Returnable<T> extends Serializable {
    int getHttpCode();

    String getHttpMessage();

    T getT();
}
