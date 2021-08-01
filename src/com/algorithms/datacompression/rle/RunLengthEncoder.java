package com.algorithms.datacompression.rle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunLengthEncoder {

    public static String encode(String source) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            int runLength = 1;

            while (i + 1 < source.length() && source.charAt(i) == source.charAt(i + 1)) {
                runLength++;
                i++;
            }

            if (runLength > 1) {
                stringBuilder.append(runLength);
            }

            stringBuilder.append(source.charAt(i));
        }

        return stringBuilder.toString();
    }

    public static String decode(String decodedSource) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
        Matcher matcher = pattern.matcher(decodedSource);

        while(matcher.find()){
            int num = 1;
            try{
                num = Integer.parseInt(matcher.group());
                matcher.find();
            }catch (Exception ignored){

            }

            while (num-- != 0){
                stringBuilder.append(matcher.group());
            }
        }

        return stringBuilder.toString();
    }
}
