package com.nc.mihalsky.openers.validators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.openers.patterns.PatternDateOfBirthDay;
import com.nc.mihalsky.openers.validators.errors.DiscrepancyPatternException;
import com.nc.mihalsky.openers.validators.errors.PatternError;
import com.nc.mihalsky.openers.validators.errors.Status;

public class ValidatorDateOfBirthDay implements Validator {
  @Override
  public PatternError validate(Contract contract) {
    PatternError error = new PatternError();
    try {
      if(!((contract.getClient().getDateOfBirthDay().toString()).matches(PatternDateOfBirthDay.dateOfBirthDayPattern))){
        throw new DiscrepancyPatternException("DateOfBirthDay doe's not match with pattern");
      }
    }catch (DiscrepancyPatternException e){
      error.setMessage(e.getMessage());
      error.setStatus(Status.ERROR);
      error.setTimeStamp(System.currentTimeMillis());
      return error;
    }
    return error;
  }
}
