#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository.querybuilder;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang3.StringUtils
import org.springframework.stereotype.Repository

import ${package}.dto.PagedSearchDTO;

@Repository
public class QueryBuilder<T extends Serializable> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private PagedSearchDTO<T> pagedSearchDTO = new PagedSearchDTO<T>();
    
    public QueryBuilder<T> withDTO(PagedSearchDTO<T> pagedSearchVO) {
        this.pagedSearchDTO = pagedSearchVO;
        return this;
    }
    
    String getOrderBy(String alias) {
        " order by ${symbol_dollar}{alias}.${symbol_dollar}{pagedSearchDTO.sortFields} ${symbol_dollar}{pagedSearchDTO.sortDirections}";
    }
    
    String getWhereAndParameters(String alias) {
        def query = ' where ';
        pagedSearchDTO.filters.each{ k, v -> (isEmpty(k, v)) ? query = query + "${symbol_dollar}{alias}.${symbol_dollar}{k} = :${symbol_dollar}{k} and " : "" }
        query + '1 = 1 ';
    }

    Boolean isEmpty(String k, Object v) {
        k && v && !v.toString().empty;
    }
    
    String getHQLQuery(String alias, String entityName) {
        getBaseSelect(alias, entityName) + getWhereAndParameters(alias) + getOrderBy(alias);
    }

    String getBaseSelect(String alias, String entityName) {
        "select ${symbol_dollar}{alias} from ${symbol_dollar}{entityName} ${symbol_dollar}{alias} ";
    }

    String getBaseSelectCount(String alias, String entityName) {
        "select count(*) from ${symbol_dollar}{entityName} ${symbol_dollar}{alias} ";
    }
    
    Integer getStart() {
        Integer.valueOf((pagedSearchDTO.getCurrentPage() - 1.intValue()) * pagedSearchDTO.getPageSize());
    }
}