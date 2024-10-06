package com.kingg.api_vacunas_panama.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class NumDosisEnumConverter implements AttributeConverter<NumDosisEnum, String> {

    @Override
    public String convertToDatabaseColumn(NumDosisEnum attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public NumDosisEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        dbData = dbData.trim().toUpperCase();
        for (NumDosisEnum num : NumDosisEnum.values()) {
            if (num.getValue().equalsIgnoreCase(dbData)) {
                return num;
            }
        }
        throw new IllegalArgumentException("Not supported value of Numero Dosis: " + dbData);
    }
}
