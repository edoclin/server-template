package server.template.service.impl;

import server.template.entity.TemplateUser;
import server.template.mapper.TemplateUserMapper;
import server.template.service.ITemplateUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试用户表 服务实现类
 * </p>
 *
 * @author edoclin
 * @since 2022-09-19
 */
@Service
open class TemplateUserServiceImpl : ServiceImpl<TemplateUserMapper, TemplateUser>(), ITemplateUserService {

}
