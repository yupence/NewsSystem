package com.zr.service;

import com.zr.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagService {

    Page<Tag> listTag(Pageable pageable);

    void delete(Long id);

    Tag findTagById(Long id);

    void input(Tag tag);
}