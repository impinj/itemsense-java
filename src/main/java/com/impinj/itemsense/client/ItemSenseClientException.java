package com.impinj.itemsense.client;

public class ItemSenseClientException extends Exception {

  private static final long serialVersionUID = 1;

  public ItemSenseClientException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public ItemSenseClientException(final String message) {
    super(message);
  }

  public ItemSenseClientException(final Throwable cause) {
    super(cause);
  }
}
