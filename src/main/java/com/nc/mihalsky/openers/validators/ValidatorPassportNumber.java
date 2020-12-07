package com.nc.mihalsky.openers.validators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.openers.patterns.PatternPassportNumber;
import com.nc.mihalsky.openers.validators.errors.DiscrepancyPatternException;
import com.nc.mihalsky.openers.validators.errors.PatternError;
import com.nc.mihalsky.openers.validators.errors.Status;

public class ValidatorPassportNumber implements Validator {
  @Override
  public PatternError validate(Contract contract) {
    PatternError error = new PatternError();
    try {
      if(!((""+contract.getClient().getPassportNumber()).matches(PatternPassportNumber.passportNumberPattern))){
        throw new DiscrepancyPatternException("PassportNumber doe's not match with pattern");
      }
    }catch (DiscrepancyPatternException e){
      error.setMessage(e.getMessage());
      error.setStatus(Status.ERROR);
      error.setTimeStamp(System.currentTimeMillis());
    }
    return error;
  }
}
