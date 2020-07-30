package com.zr.service;

import com.zr.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {
    Page<Type> listType(Pageable pageable);

    Type findById(Long id);

    void deleteById(Long id);

    void input(Type type);

    List<Type> listType();

    List<Type> findTop(int i);
}