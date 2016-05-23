package com.quest.util;

import java.io.Serializable;

/**
 * @author Jason Park
 * @since v1.0.0
 */
public class ResponseObj implements Serializable {

  private static final long serialVersionUID = 2743679770097388440L;

  private Integer msgCode;

  private String msg;

  private Object data;

  public ResponseObj() { }

  public ResponseObj(Integer msgCode, String msg, Object data) {
    this.msgCode = msgCode;
    this.msg = msg;
    this.data = data;
  }

  public ResponseObj(MessageCode messageCode) {
    this(messageCode.getCode(), messageCode.toString(), null);
  }

  public ResponseObj(MessageCode messageCode, Object object) {
    this(messageCode.getCode(), messageCode.toString(), object);
  }

  public Integer getMsgCode() {
    return msgCode;
  }

  public void setMsgCode(Integer msgCode) {
    this.msgCode = msgCode;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
