package com.quest.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jason Park
 * @since v1.0.0
 */
public class ListParamValidator implements Validator {

  @Override
  public boolean supports(Class<?> aClass) {
    return ArrayList.class.equals(aClass);
  }

  @Override
  public void validate(Object o, Errors errors) {
    List<?> listParam = (List<?>)o;
    if (listParam.isEmpty()) {
      errors.reject("EMPTY_LIST");
    }
    if (listParam.size() > 5) {
      errors.reject("OVER_SIZE");
    }
  }
}
