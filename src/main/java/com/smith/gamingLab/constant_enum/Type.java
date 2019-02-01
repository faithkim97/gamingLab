package com.smith.gamingLab.constant_enum;

import java.util.List;

public interface Type {

    String getText();

    List<Type> convertStringToTypeList(List<String> list);
}
