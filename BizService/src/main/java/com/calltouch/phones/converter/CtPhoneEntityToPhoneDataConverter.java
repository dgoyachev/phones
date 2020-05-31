package com.calltouch.phones.converter;

import com.calltouch.phones.domain.PhoneData;
import com.calltouch.phones.entity.CtPhoneEntity;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by morgan on 31.05.2020
 */

public class CtPhoneEntityToPhoneDataConverter implements Converter<CtPhoneEntity, PhoneData> {

    @Override
    public PhoneData convert(CtPhoneEntity phoneEntity) {
        return new PhoneData(
                phoneEntity.getId(),
                phoneEntity.getNumber(),
                phoneEntity.getDescription()
        );
    }
}
