package com.nc.mihalsky.openers.validators;


import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.openers.patterns.PatternDateStartOfUse;
import com.nc.mihalsky.openers.validators.errors.DiscrepancyPatternException;
import com.nc.mihalsky.openers.validators.errors.PatternError;
import com.nc.mihalsky.openers.validators.errors.Status;

public class ValidatorDateStartOfUse implements Validator {
  @Override
  public PatternError validate(Contract contract) {
    PatternError error = new PatternError();
    try {
      if(!((contract.getDateStartOfUse().toString()).matches(PatternDateStartOfUse.dateStartOfUsePattern))){
        throw new DiscrepancyPatternException("DateStartOfUse doe's not match with pattern");
      }
    }catch (DiscrepancyPatternException e){
      error.setMessage(e.getMessage());
      error.setStatus(Status.ERROR);
      error.setTimeStamp(System.currentTimeMillis());

    }
    return error;
  }
}
