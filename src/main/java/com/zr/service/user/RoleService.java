package com.zr.service.user;

import com.zr.dao.entity.Role;
import com.zr.dao.entity.RoleQuery;
import com.zr.service.BaseService;

import java.util.List;

/**
 * Created by Miste on 3/20/2018.
 *
 * 用户角色服务
 */
public interface RoleService extends BaseService<Role, RoleQuery> {
    boolean updatePermission(Integer roleId, List<Integer> permissions) ;

}