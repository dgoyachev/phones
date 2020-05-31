package com.calltouch.phones.dao;

import com.calltouch.phones.domain.criteria.PhoneSearchCriteria;
import com.calltouch.phones.entity.CtPhoneEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * Created by morgan on 31.05.2020
 */

@Repository
public class CtPhoneDAO {
    @Transactional(readOnly = true)
    public List<CtPhoneEntity> list(PhoneSearchCriteria criteria, Pageable pageable) {
        return Collections.singletonList(new CtPhoneEntity(1, 7495123456L, "desc"));
    }
}
