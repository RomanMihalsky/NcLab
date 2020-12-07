package com.nc.mihalsky.openers.validators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.persons.Client;
import com.nc.mihalsky.openers.patterns.PatternPhoneNumber;
import com.nc.mihalsky.openers.validators.errors.DiscrepancyPatternException;
import com.nc.mihalsky.openers.validators.errors.PatternError;
import com.nc.mihalsky.openers.validators.errors.Status;

/**
 *Класс ValidatorPhoneNumber проверяет параметр клиента {@link Client#phoneNumber}
 * @author Roman Mihalsky
 */
public class ValidatorPhoneNumber implements Validator {
  /**
   *Функция проверяет phoneNumber
   * @param contract - контракт
   * @return PatternError - данные об ошибке
   */
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
