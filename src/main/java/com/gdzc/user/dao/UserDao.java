package com.gdzc.user.dao;

import com.gdzc.commons.orm.LzcJpaRepository;
import com.gdzc.user.entity.Member;

import java.util.List;

/**
 * Created by Liu_Zhichao on 14-6-11.
 */
public interface UserDao extends LzcJpaRepository<Member,String> {

    /**
     * 查询所有用户
     * @return
     */
    public List<Member> getAll();

    /**
     * 根据登录名和密码查询用户
     * @param loginName
     * @param password
     * @return
     */
    public Member findByLoginNameAndPassword(String loginName,String password);
}
