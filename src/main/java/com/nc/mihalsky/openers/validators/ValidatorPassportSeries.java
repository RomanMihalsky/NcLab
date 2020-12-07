package com.nc.mihalsky.openers.validators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.openers.validators.errors.PatternError;

public class ValidatorPassportSeries implements Validator {
  @Override
  public PatternError validate(Contract contract) {
    return null;
  }
}
