package com.netcore.FlipkartMobileSearch.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParserUtils {
  public static Integer parseAndGetRatings(String ratings) {
    ratings = ratings.trim().replace(",", "");
    return Integer.parseInt(ratings);
  }

  public static Integer parseAndGetStorage(String name) {


    String numberMatcher = "\\d{2,3}";
    Pattern pattern = Pattern.compile(numberMatcher);
    Matcher matcher = pattern.matcher(name);
    if (matcher.find()) {
      return Integer.parseInt(matcher.group(0));
    }

    return 0;
  }

  public static Integer parseAndGetPrice(String prodPrice) {
    if (prodPrice == null || prodPrice.length() == 1) {
      return 0;
    }
    return Integer.valueOf(prodPrice.substring(1).replace(",",""));
  }
}
