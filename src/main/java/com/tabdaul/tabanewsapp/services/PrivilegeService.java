package com.tabdaul.tabanewsapp.services;

import com.tabdaul.tabanewsapp.Entities.Privilege;

import java.util.List;

/**
 * @author MOSAED ALOTAIBI (MASAAD)
 * @created 10/30/2022 at 03:06
 */
public interface PrivilegeService {

    List<Privilege> findAll();
    Privilege save(Privilege privilege);
}
