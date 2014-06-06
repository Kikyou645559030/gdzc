package com.gdzc.commons.orm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Liu_Zhichao on 14-6-6.
 */
@NoRepositoryBean
public abstract interface LzcJpaRepository<T,ID extends Serializable> extends JpaRepository<T,ID> {
    public abstract List<T> queryByMap(Map<String, Object> map);
}
