package com.calltouch.phones.service;

import com.calltouch.phones.converter.CtPhoneEntityToPhoneDataConverter;
import com.calltouch.phones.dao.CtPhoneDAO;
import com.calltouch.phones.domain.PhoneData;
import com.calltouch.phones.domain.criteria.PhoneSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created by morgan on 31.05.2020
 */

@Service
public class PhoneServiceImpl implements PhoneService {

    private final CtPhoneDAO phoneDAO;
    private final CtPhoneEntityToPhoneDataConverter phoneEntityToPhoneDataConverter;

    @Autowired
    public PhoneServiceImpl(CtPhoneDAO phoneDAO, CtPhoneEntityToPhoneDataConverter phoneEntityToPhoneDataConverter) {
        this.phoneDAO = phoneDAO;
        this.phoneEntityToPhoneDataConverter = phoneEntityToPhoneDataConverter;
    }

    @Override
    public Page<PhoneData> list(PhoneSearchCriteria criteria, Pageable pageable) {
        return new PageImpl<>(phoneDAO.list(criteria, pageable).stream().map(phoneEntityToPhoneDataConverter::convert).collect(Collectors.toList()), pageable, 1L);
    }

    @Override
    public void save(PhoneData data) {

    }
}
