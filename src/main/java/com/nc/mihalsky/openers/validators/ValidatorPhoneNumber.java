package com.nc.mihalsky.openers.validators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.openers.patterns.PatternPhoneNumber;
import com.nc.mihalsky.openers.validators.errors.DiscrepancyPatternException;
import com.nc.mihalsky.openers.validators.errors.PatternError;
import com.nc.mihalsky.openers.validators.errors.Status;

public class ValidatorPhoneNumber implements Validator {
  @Override
  public PatternError validate(Contract contract) {
    PatternError error = new PatternError("PhoneNumber OK");
    try {
      if(!((""+contract.getClient().getPhoneNumber()).matches(PatternPhoneNumber.phoneNumberPattern))){
        throw new DiscrepancyPatternException("PhoneNumber doe's not match with pattern");
      }
    }catch (DiscrepancyPatternException e){
      error.setMessage(e.getMessage());
      error.setStatus(Status.ERROR);
      error.setTimeStamp(System.currentTimeMillis());
    }
    return error;
  }
}
