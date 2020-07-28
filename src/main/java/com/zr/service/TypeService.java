package com.zr.service;

import com.zr.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TypeService {
    public Page<Type> listType(Pageable pageable);

    Type findById(Long id);

    void deleteById(Long id);

    void input(Type type);
}