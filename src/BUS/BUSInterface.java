/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package BUS;

import java.util.ArrayList;

/**
 *
 * @author hieun
 * @param <T>
 */
public interface BUSInterface<T> {

    boolean add(T t);

    boolean update(T t);

    boolean delete(int id);

    T getById(int id);

    ArrayList<T> getAll();
}
