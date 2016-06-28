package mx.com.mentoringit.interfaces;

import java.util.List;

public interface IGenericDAO<T> {
	
	public Integer save(T emp) throws Exception;
	public void edit(T emp) throws Exception;
	public T find(Class<T> clase,int idEntity) throws Exception;
	public Boolean delete(T emp) throws Exception;
	public List findAll(Class<T> clase) throws Exception;
}
