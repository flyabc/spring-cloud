package com.microservice.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.microservice.provider.dao.MemberMapper;
import com.microservice.provider.entity.Member;
import com.microservice.provider.service.IMemberService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author mybatis-plus
 * @since 2019-02-15
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

}
