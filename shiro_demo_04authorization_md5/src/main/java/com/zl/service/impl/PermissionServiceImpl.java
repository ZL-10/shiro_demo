package com.zl.service.impl;

import com.zl.domain.User;
import com.zl.service.PermissionService;

import java.util.Arrays;
import java.util.List;

public class PermissionServiceImpl implements PermissionService {
    @Override
    public List<String> queryPermissionByUserName(String userName) {
        return Arrays.asList("user:query","user:add","query:update","user:delete");
    }
}
