package com.nc.mihalsky.openers.validators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.openers.patterns.PatternPatronymic;
import com.nc.mihalsky.openers.validators.errors.DiscrepancyPatternException;
import com.nc.mihalsky.openers.validators.errors.PatternError;
import com.nc.mihalsky.openers.validators.errors.Status;

public class ValidatorPatronymic implements Validator {
  @Override
  public PatternError validate(Contract contract) {
    PatternError error = new PatternError("Patronymic OK");
    try {
      if(!((contract.getClient().getPatronymic()).matches(PatternPatronymic.patronymicPattern))){
        throw new DiscrepancyPatternException("Patronymic doe's not match with pattern");
      }
    }catch (DiscrepancyPatternException e){
      error.setMessage(e.getMessage());
      error.setStatus(Status.ERROR);
      error.setTimeStamp(System.currentTimeMillis());
    }
    return error;
  }
}
