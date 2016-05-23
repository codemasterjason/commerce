package com.quest.util;

/**
 * @author Jason Park
 * @since v1.0.0
 */
public enum MessageCode {

  SUCCESS(1),
  FAIL(-1),
  DAO_FAIL(-2);

  private final int code;

  MessageCode(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }
}
