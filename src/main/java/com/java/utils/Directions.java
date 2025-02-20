package com.java.utils;

public enum Directions {
  UP("up"),
  LEFT("left"),
  RIGHT("right"),

  DOWN("down");

  private final String direction;

  Directions(String direction) {
    this.direction = direction;
  }

  public String getDirection(){
    return direction;
  }
}
