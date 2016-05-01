#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.generic;

import java.io.Serializable;

public interface IGenericRepository<T> {
    
    T save (T entity)
    T update (T entity)
    Boolean delete (T entity)
    T merge (T entity)
    T getEntity(Serializable id)
//    T getEntityByDetachedCriteria(DetachedCriteria criteria)
    T getEntityByHQLQuery(String stringQuery)
//    List<T> getEntities()
//    List<T> getListByDetachedCriteria(DetachedCriteria criteria)

}