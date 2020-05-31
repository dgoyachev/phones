package com.calltouch.phones.service;

import com.calltouch.phones.domain.PhoneData;
import com.calltouch.phones.domain.criteria.PhoneSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PhoneService {

    Page<PhoneData> list(PhoneSearchCriteria criteria, Pageable pageable);

    void save(PhoneData data);
}
