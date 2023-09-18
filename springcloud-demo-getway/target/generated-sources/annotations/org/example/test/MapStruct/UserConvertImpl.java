package org.example.test.MapStruct;

import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-11T16:04:15+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_333 (Oracle Corporation)"
)
public class UserConvertImpl implements UserConvert {

    @Override
    public UserBO convert(UserDO userDO) {
        if ( userDO == null ) {
            return null;
        }

        UserBO userBO = new UserBO();

        return userBO;
    }
}
