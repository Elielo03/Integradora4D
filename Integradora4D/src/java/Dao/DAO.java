/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;

/**
 *
 * @author Eliel David
 * @param <T>
 */
public interface DAO <T> {
    
   public List<T> getAll();
	public T get(int id);
	public boolean update(T bean);
	public boolean delete(T id);
	public boolean add(T bean);
}
