package com.calltouch.phones.service;

import com.calltouch.phones.converter.CtPhoneEntityToPhoneDataConverter;
import com.calltouch.phones.dao.CtPhoneDAO;
import com.calltouch.phones.domain.PhoneData;
import com.calltouch.phones.domain.criteria.PhoneSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by morgan on 31.05.2020
 */

@Service
public class PhoneServiceImpl implements PhoneService {

    CtPhoneDAO phoneDAO;

    public PhoneServiceImpl(CtPhoneDAO phoneDAO) {
        this.phoneDAO = phoneDAO;
    }

    @Override
    public Page<PhoneData> list(PhoneSearchCriteria criteria, Pageable pageable) {
        CtPhoneEntityToPhoneDataConverter converter = new CtPhoneEntityToPhoneDataConverter();
        return new PageImpl<>(phoneDAO.list(criteria, pageable).stream().map(converter::convert).collect(Collectors.toList()), pageable, 1L);
    }

    @Override
    public void save(PhoneData data) {

    }
}
