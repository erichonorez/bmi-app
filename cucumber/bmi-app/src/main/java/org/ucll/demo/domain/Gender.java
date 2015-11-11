package org.ucll.demo.domain;

public enum Gender {

	MALE {
    public boolean isMale() {
      return true;
    }
  }, FEMALE {
    public boolean isFemale() {
      return true;
    }
  };

  public boolean isMale() {
    return false;
  }

  public boolean isFemale() {
    return false;
  }

}
