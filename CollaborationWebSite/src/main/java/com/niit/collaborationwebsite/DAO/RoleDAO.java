package com.niit.collaborationwebsite.DAO;

import java.util.List;


import com.niit.collaborationwebsite.model.Role;

public interface RoleDAO {

    void saveOrUpdateRole(Role role);
	
	void deleteRole(String Id);

	Role getRole(String Id);

	List<Role> listRoles();

	
}
