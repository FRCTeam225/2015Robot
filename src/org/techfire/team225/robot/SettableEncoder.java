package org.techfire.team225.robot;

import edu.wpi.first.wpilibj.Encoder;

public class SettableEncoder extends Encoder {

  int offset = 0;
  
  public SettableEncoder(int a, int b) {
    super(a,b);
  }
  
  public int get() {
    return super.get()+offset;
  }
  
  public void reset(int offset) {
    super.reset();
    this.offset = offset;
  }
}
