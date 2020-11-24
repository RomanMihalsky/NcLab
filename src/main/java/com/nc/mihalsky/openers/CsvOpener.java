package com.nc.mihalsky.openers;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.simple.SimpleListContract;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.List;

public class CsvOpener implements Opener{
  public static final String CSV_FILE_PATH = "src\\main\\resources\\csvFile.csv";
  private static List<String[]> allData;

  @Override
  public SimpleListContract<Contract> readFileToSimpleList(String fileName) {
    readData(fileName);

    return null;
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
