package com.zr.service.impl;

import com.zr.dao.TagDao;
import com.zr.po.Tag;
import com.zr.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDao tagDao;
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagDao.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        tagDao.deleteById(id);
    }

    @Override
    public Tag findTagById(Long id) {
        return tagDao.getOne(id);
    }

    @Override
    public void input(Tag tag) {
        tagDao.save(tag);
    }
}