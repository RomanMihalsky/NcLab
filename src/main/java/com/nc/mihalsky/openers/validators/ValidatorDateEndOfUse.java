package com.nc.mihalsky.openers.validators;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.openers.patterns.PatternDateEndOfUse;
import com.nc.mihalsky.openers.validators.errors.DiscrepancyPatternException;
import com.nc.mihalsky.openers.validators.errors.PatternError;
import com.nc.mihalsky.openers.validators.errors.Status;

/**
 *Класс ValidatorDateEndOfUse проверяет параметр контракта {@link Contract#dateEndOfUse}
 * @author Roman Mihalsky
 */
public class ValidatorDateEndOfUse implements Validator {

  /**
   *Функция проверяет dateEndOfUse
   * @param contract - контракт
   * @return PatternError - данные об ошибке
   */
  @Override
  public PatternError validate(Contract contract) {
    PatternError error = new PatternError("DateEndOfUse OK ");
    try {
      if(!((contract.getDateEndOfUse().toString()).matches(PatternDateEndOfUse.dateEndOfUsePattern))){
        throw new DiscrepancyPatternException("DateEndOfUse doe's not match with pattern");
      }
    }catch (DiscrepancyPatternException e){
      error.setMessage(e.getMessage());
      error.setStatus(Status.ERROR);
      error.setTimeStamp(System.currentTimeMillis());
    }
    return error;
  }
}
