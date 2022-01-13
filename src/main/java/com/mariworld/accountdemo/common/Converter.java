package com.mariworld.accountdemo.common;

public interface Converter<E,D> {
    E convertTo(D dto);
}
