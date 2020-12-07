package com.nc.mihalsky.openers.validators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.openers.validators.errors.PatternError;

public interface Validator {
  PatternError validate(Contract contract);
}
