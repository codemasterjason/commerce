package com.quest.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * @author Jason Park
 * @since v1.0.0
 */
public class RowBounds {

  @NotNull
  Integer offset;

  @NotNull
  Integer rowCount;

  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public Integer getRowCount() {
    return rowCount;
  }

  public void setRowCount(Integer rowCount) {
    this.rowCount = rowCount;
  }

  @Override
  public String toString() {
    return "RowBounds{" +
        "offset=" + offset +
        ", rowCount=" + rowCount +
        '}';
  }
}
