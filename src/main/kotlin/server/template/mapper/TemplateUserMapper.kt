package server.template.mapper;

import server.template.entity.TemplateUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 测试用户表 Mapper 接口
 * </p>
 *
 * @author edoclin
 * @since 2022-09-19
 */
@Mapper
interface TemplateUserMapper : BaseMapper<TemplateUser>
