package com.zr.service.impl;

import com.zr.dao.TypeDao;
import com.zr.po.Type;
import com.zr.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeDao typeDao;

    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeDao.findAll(pageable);
    }

    @Override
    public Type findById(Long id) {
        return typeDao.getOne(id);
    }

    @Override
    public void deleteById(Long id) {
        typeDao.deleteById(id);
    }

    @Override
    public void input(Type type) {
        typeDao.save(type);
    }
}