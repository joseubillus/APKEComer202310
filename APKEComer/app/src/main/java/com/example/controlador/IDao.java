package com.example.controlador;

public interface IDao<T> {

    void getList(String bus)throws Exception;
    void getAdd(T obj)throws Exception;
    void getUp(T obj)throws Exception;
    void getDel()throws Exception;
    T getItem(int f);
    int getSize();
}
