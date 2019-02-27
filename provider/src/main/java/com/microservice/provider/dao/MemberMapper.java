package com.microservice.provider.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.microservice.provider.entity.Member;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author mybatis-plus
 * @since 2019-02-15
 */
@Mapper
public interface MemberMapper extends BaseMapper<Member> {

}
