package com.hp.up.business.repository;

import com.hp.up.core.Entity.Role;
import com.hp.up.core.Entity.RoleResourcePermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * @Author haopeng
 * @Date 2017/9/11 17:12
 */

@Component
public interface RoleRepository extends BaseRepository<Role>{

    String findRoleIds(Long userId);

    List<Role> getRolesByids(String ids);

    List<Role> getRolesWithPermissionByids(String ids);

    List<RoleResourcePermission> getRoleResourcePermission(final Long id);

    int deleteRoleResourcePermissionByRoleId(final long roleId);

    int insertRoleResourcePermission(@Param(value = "roleId") final Long roleId, @Param(value = "resourceId") final Long resourceId,
                                     @Param(value = "permissionIds") final String permissionIds);

}
