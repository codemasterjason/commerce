package com.quest.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author Jason Park
 * @since v1.0.0
 */
@Component
public class ResponseFactory {

  public ResponseEntity get(MessageCode messageCode, Object object, HttpStatus httpStatus) {
    return new ResponseEntity<>(new ResponseObj(messageCode, object), httpStatus);
  }

  public ResponseEntity get(MessageCode messageCode, Object object) {
    return new ResponseEntity<>(new ResponseObj(messageCode, object), HttpStatus.OK);
  }

  public ResponseEntity get(MessageCode messageCode, HttpStatus httpStatus) {
    return new ResponseEntity<>(new ResponseObj(messageCode.getCode(), messageCode.toString(), null), httpStatus);
  }

  public ResponseEntity get(MessageCode messageCode) {
    return new ResponseEntity<>(new ResponseObj(messageCode.getCode(), messageCode.toString(), null), HttpStatus.OK);
  }
}
