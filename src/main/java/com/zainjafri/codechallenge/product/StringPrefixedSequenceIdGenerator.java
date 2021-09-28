package com.zainjafri.codechallenge.product;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;
import org.springframework.data.mapping.MappingException;
import java.io.Serializable;
import java.util.Properties;

//Custom Generator Class for Generating Sequence in form of P01,P02,P03 and so on...
public class StringPrefixedSequenceIdGenerator extends SequenceStyleGenerator {

    //public static final String VALUE_PREFIX_PARAMETER = "valuePrefix";
    //public static final String VALUE_PREFIX_DEFAULT = "P";
    private String valuePrefix;

    public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
    public static final String NUMBER_FORMAT_DEFAULT = "%02d";
    private String numberFormat;

    @Override
    public Serializable generate(SharedSessionContractImplementor session,
                                 Object object) throws HibernateException {
        return valuePrefix + String.format(numberFormat, super.generate(session, object));
    }

    @Override
    public void configure(Type type, Properties params,
                          ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(LongType.INSTANCE, params, serviceRegistry);
        valuePrefix = "P";
        numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER,
                params, NUMBER_FORMAT_DEFAULT);
    }

}