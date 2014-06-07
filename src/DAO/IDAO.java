/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author SANGYG
 * @param <T>
 */
public interface IDAO<T> {

    public void create(T t);

    public T read(T t);

    public List<T> readAll();

    public void update(T t);

    public void delete(T t);
}
