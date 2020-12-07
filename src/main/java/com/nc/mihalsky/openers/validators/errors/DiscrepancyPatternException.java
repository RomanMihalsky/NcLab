package com.nc.mihalsky.openers.validators.errors;
/**
 *Класс DiscrepancyPatternException - ошибка несоответствия шаблону
 * @author Roman Mihalsky
 */
public class DiscrepancyPatternException extends RuntimeException{

  /**
   *Конструктор вызывает конструктор у класса радителя
   *
   * @param message - сообщение
   */
  public DiscrepancyPatternException(String message){
    super(message);
  }

  /**
   *Конструктор вызывает конструктор у класса радителя
   *
   * @param message - сообщение
   */
  public DiscrepancyPatternException(String message,Throwable cause){
    super(message,cause);
  }

  public DiscrepancyPatternException(Throwable cause){
    super(cause);
  }
}
