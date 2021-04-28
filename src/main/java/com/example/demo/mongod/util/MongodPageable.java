package com.example.demo.mongod.util;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.Min;

/**
 * @author zhanglf
 * @Date 2021/4/28 下午10:10
 */
public class MongodPageable implements Pageable {

    @Min(1)
    private Integer pageNumber = 1;
    @Min(1)
    private Integer pageSize = 10;
    private Sort sort = Sort.unsorted();

    @Override
    public int getPageNumber() {
        return this.pageNumber;
    }

    @Override
    public int getPageSize() {
        return this.pageSize;
    }

    @Override
    public long getOffset() {
        return (getPageNumber() - 1) * this.getPageSize();
    }

    @Override
    public Sort getSort() {
        return this.sort;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
