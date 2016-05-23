package com.quest.util;

import org.springframework.stereotype.Component;

/**
 * @author Jason Park
 * @since v1.0.0
 */
@Component
public class ResponseFactory {

  public ResponseObj get(MessageCode messageCode, Object object) {
    return new ResponseObj(messageCode, object);
  }

  public ResponseObj get(MessageCode messageCode) {
    return new ResponseObj(messageCode.getCode(), messageCode.toString(), null);
  }
}
