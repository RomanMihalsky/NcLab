package com.nc.mihalsky.openers.validators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.openers.validators.errors.PatternError;

public class ValidatorDateEndOfUse implements Validator {
  @Override
  public PatternError validate(Contract contract) {
    return null;
  }
}
