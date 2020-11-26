package com.nc.mihalsky.openers;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.persons.Client;
import com.nc.mihalsky.openers.creators.CreatorClientFromCsv;
import com.nc.mihalsky.openers.creators.CreatorContractFromCsv;
import com.nc.mihalsky.openers.patterns.*;
import com.nc.mihalsky.simple.SimpleArray;
import com.nc.mihalsky.simple.SimpleArrayContract;
import com.nc.mihalsky.simple.SimpleList;
import com.nc.mihalsky.simple.SimpleListContract;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CsvOpener implements Opener{
  public static final String CSV_FILE_PATH = "src\\main\\resources\\csvFile.csv";
  private static List<String[]> allData;
  private final TitlePattern[] patterns;
  private HashMap<String,TitlePattern> mapPatterns;

  public CsvOpener(){
    patterns = new TitlePattern[]{
            new PatternCondition1(),
            new PatternCondition2(),
            new PatternDateStartOfUse(),
            new PatternDateEndOfUse(),
            new PatternDateOfBirthDay(),
            new PatternGender(),
            new PatternName(),
            new PatternPassportNumber(),
            new PatternPassportSeries(),
            new PatternPatronymic(),
            new PatternPhoneNumber(),
            new PatternSurname(),
            new PatternTariff()
    };
    this.mapPatterns = new HashMap<>();
  }

  @Override
  public SimpleArrayContract<Contract> readFileToSimpleList(String fileName) {
    readData(fileName);
    findPositions();
    SimpleArrayContract<Contract> contracts = fillUp();

    return contracts;
  }

  private SimpleArrayContract<Contract> fillUp() {
    String [][] csvValues = getArrayOfValues();
    CreatorClientFromCsv creator = new CreatorClientFromCsv(mapPatterns);
    CreatorContractFromCsv creatorContract = new CreatorContractFromCsv(mapPatterns);
    SimpleArrayContract<Contract> list = new SimpleArrayContract<>();
    for(int i = 1;i < csvValues.length;i++){
      Client client = creator.create(csvValues[i]);
      Contract contract = creatorContract.create(csvValues[i],client);
      list.add(contract);
    }
    return list;
  }

  private void findPositions() {
    String [][] csvValues = getArrayOfValues();
    String [] titles = csvValues[0];

    for(int i = 0; i < titles.length;i ++){
      for (int j = 0;j < patterns.length;j++){
        if (titles[i].matches(patterns[j].getTitle())){
          patterns[j].setIndexOfTitle(i);
          mapPatterns.put(patterns[j].getTitle(),patterns[j]);
        }
      }
    }
  }

  private void parseData() {

  }

  private void readData(String fileName) {
    try {
      FileReader fileReader = new FileReader(fileName);

      CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();

      CSVReader csvReader = new CSVReaderBuilder(fileReader).withCSVParser(csvParser).build();

      allData = csvReader.readAll();

    }catch (Exception e){
      e.printStackTrace();
    }
  }

  private static String[][] getArrayOfValues(){
    String [][] csvValues = new String[allData.size()][];
    allData.toArray(csvValues);
    return csvValues;
  }
}
