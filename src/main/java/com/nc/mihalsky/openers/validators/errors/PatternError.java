package com.nc.mihalsky.openers.validators.errors;

import com.nc.mihalsky.entities.persons.Client;

/**
 *Класс PatternError хранит данные об ошибке
 * @author Roman Mihalsky
 */
public class PatternError {
  /**Поле статус*/
  private Status status;
  /**Поле сообщение*/
  private String message;
  /**Поле время появления ошибки*/
  private long timeStamp;

  /**Конструктор для создания клиента с default значениями*/
  public PatternError(){
    this.status = Status.OK;
    this.message = "OK";
    this.timeStamp = System.currentTimeMillis();
  }

  /**Конструкто для создания клиента с параметрами.
   * @param message - сообщение
   */
  public PatternError(String message){
    this.status = Status.OK;
    this.message = message;
    this.timeStamp = System.currentTimeMillis();
  }

  /**Конструкто для создания клиента с параметрами.
   * @param message - сообщение
   * @param status - статус
   * @param timeStamp - время появления ошибки
   */
  public PatternError(Status status, String message, long timeStamp) {
    this.status = status;
    this.message = message;
    this.timeStamp = timeStamp;
  }

  /**
   * Функция получения статуса
   * @return status
   */
  public Status getStatus() {
    return status;
  }

  /**
   * Функция определения статуса {@link PatternError#status}
   * @param status - статус
   */
  public void setStatus(Status status) {
    this.status = status;
  }

  /**
   * Функция получения сообщения
   * @return message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Функция определения сообщения {@link PatternError#message}
   * @param message - сообщение
   */
  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * Функция получения сообщения
   * @return время появления ошибки
   */
  public long getTimeStamp() {
    return timeStamp;
  }

  /**
   * Функция определения времени появления ошибки {@link PatternError#timeStamp}
   * @param timeStamp - время появления ошибки
   */
  public void setTimeStamp(long timeStamp) {
    this.timeStamp = timeStamp;
  }

  /**
   * Функция для приведения объекта к строке
   */
  @Override
  public String toString() {
    return "PatternError{" +
            "status=" + status +
            ", message='" + message + '\'' +
            ", timeStamp=" + timeStamp +
            '}';
  }
}
