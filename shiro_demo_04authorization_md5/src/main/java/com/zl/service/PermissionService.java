package com.zl.service;

import com.zl.domain.User;

import java.util.List;

public interface PermissionService {
    List<String> queryPermissionByUserName(String userName);
}
