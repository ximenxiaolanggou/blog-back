package center.helloworld.blog.app.system.service;

import center.helloworld.blog.app.system.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhishun.cai
 * @since 2021-12-02
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 列表
     * @param searchKey
     * @return
     */
    List<SysRole> list(String searchKey);

    /**
     * 根据名称查询
     * @param name
     * @return
     */
    SysRole findByName(String name);

    /**
     * 根据名称查询并不包含此角色
     * @param name
     * @return
     */
    SysRole findByNameIgnoreRoleId(String name, Integer roleId);
}
