package com.zl.service.impl;

import com.zl.service.RoleService;

import java.util.Arrays;
import java.util.List;

public class RoleServiceImpl implements RoleService {
    @Override
    public List<String> queryUserByName(String userName) {
        return Arrays.asList("role1","role2","role3");
    }
}
