package center.helloworld.blog.app.system.mapper;

import center.helloworld.blog.app.system.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 分页
     *
     * @param pageInfo
     * @param searchKey
     * @return
     */
    IPage<SysUser> page(Page<SysUser> pageInfo, @Param("searchKey") String searchKey);
}
