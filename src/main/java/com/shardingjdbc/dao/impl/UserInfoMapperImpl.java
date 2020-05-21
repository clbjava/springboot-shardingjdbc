package com.shardingjdbc.dao.impl;

import com.shardingjdbc.dao.UserInfoMapper;
import com.shardingjdbc.dto.UserInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("com.shardingjdbc.dao.UserInfoMapper")
public class UserInfoMapperImpl extends  AbstractDao implements UserInfoMapper {
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(UserInfo record) {
        try (SqlSession session = getSqlSession()) {
            UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
            return mapper.insert(record);
        }
    }

    @Override
    public int insertSelective(UserInfo record) {
        return 0;
    }

    @Override
    public UserInfo selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return 0;
    }
}
