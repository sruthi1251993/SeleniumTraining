package com.netcore.FlipkartMobileSearch.convertor;

import com.netcore.FlipkartMobileSearch.model.Mobile;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class CsvConvertor {


  public void sortAndExportToCsv(List<Mobile> mobileList) throws IOException {
    mobileList.sort((mob1, mob2) -> {
      if (mob1.getPriceInInt().equals(mob2.getPriceInInt())) {
        if (mob1.getStorage().equals(mob2.getStorage())) {
          return mob1.getRatingsInInt().compareTo(mob2.getRatingsInInt());
        } else {
          return mob1.getStorage().compareTo(mob2.getStorage());
        }
      } else {
        return mob1.getPriceInInt().compareTo(mob2.getPriceInInt());
      }
    });

    mobileList.forEach(System.out::println);
    this.convertMoblieListToCsv(mobileList);
  }


  public String escapeSpecialCharacters(String data) {
    String escapedData = data.replaceAll("\\R", " ");
    if (data.contains(",") || data.contains("\"") || data.contains("'")) {
      data = data.replace("\"", "\"\"");
      escapedData = "\"" + data + "\"";
    }
    return escapedData;
  }


  public void convertMoblieListToCsv(List<Mobile> mobileList) throws IOException {
    File csvOutputFile = new File("/tmp/report.csv");
    try (PrintWriter pw = new PrintWriter(csvOutputFile, "UTF-8")) {
      pw.println(getHeaders());
      mobileList.stream()
          .map(this::convertToCSV)
          .forEach(pw::println);
    }

  }

  private String getHeaders() {
    return "Device Details, Price, Ratings";
  }

  public String convertToCSV(Mobile mobile) {
    StringBuilder csvRow = new StringBuilder();

    csvRow.append(escapeSpecialCharacters(mobile.getName()))
        .append(",")
        .append(escapeSpecialCharacters(mobile.getPrice()))
        .append(",")
        .append(escapeSpecialCharacters(mobile.getNumberOfRatings()));

    return csvRow.toString();
  }


}
