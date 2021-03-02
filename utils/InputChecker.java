package utils;

import data.MusicGenre;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.InputMismatchException;

/**
 * Input checker. Validates input
 */

public class InputChecker {


    Helper sc = new Helper();

    /**
     * Validates String
     * @param str - String input request
     * @param canBeNull - boolean if input can be null
     * @return String correct input
     */
    public String nextLine(String str, boolean canBeNull){
        System.out.print(str);
        String correctString = sc.nextLine();
        if (!canBeNull) {
            while (correctString.length()==0){
                System.out.println("Incorrect input");
                System.out.print(str);
                correctString = sc.nextLine();
            }
        }
        return correctString;
    }

    /**
     * Validates long
     * @param str - String input request
     * @return long correct input
     */

    public long nextLong(String str)  {
        long correctLong = 0;
        boolean correct = false;
        String buffer;

        while (!correct){
            try {
                System.out.print(str);
                buffer = sc.nextLine();
                if (buffer.length()==0){
                    throw new InputMismatchException();
                }else{
                    correctLong = Long.valueOf(buffer).longValue();
                }
                correct=true;
            }catch (InputMismatchException | NumberFormatException e){
                System.out.println("Incorrect input");
            }
        }
        return correctLong;
    }

    /**
     * Validates Integer
     * @param str - String input request
     * @param canBeNull - boolean if input can be null
     * @param mustBePositive - boolean if input value must be greater than 0
     * @return Integer correct input
     */

    public Integer nextInt(String str, boolean canBeNull, boolean mustBePositive)  {
        Integer correctInt = Integer.valueOf(0);
        boolean correct = false;
        String buffer;

        if (canBeNull && mustBePositive){
            while (!correct){
                try {
                    System.out.print(str);
                    buffer = sc.nextLine();
                    if (buffer.length()==0){
                        correctInt=null;
                        //break;
                    }else{
                        if (Integer.parseInt(buffer) >0){
                            correctInt = Integer.valueOf(buffer);
                        }else {
                            throw new InputMismatchException();
                        }
                    }
                    correct = true;
                }catch (InputMismatchException | NumberFormatException e){
                    System.out.println("Incorrect input");
                }
            }
        }else if (canBeNull){
            while (!correct){
                try {
                    System.out.print(str);
                    buffer = sc.nextLine();
                    if (buffer.length()==0){
                        correctInt=null;
                        //break;
                    }else{
                        correctInt = Integer.valueOf(buffer);
                    }
                    correct = true;
                }catch (InputMismatchException | NumberFormatException e){
                    System.out.println("Incorrect input");
                }
            }
        }else if (mustBePositive){
            while (!correct){
                try {
                    System.out.print(str);
                    buffer = sc.nextLine();
                    if (buffer.length()==0){
                        throw new InputMismatchException();
                    }else{
                        if (Integer.parseInt(buffer) >0){
                            correctInt = Integer.valueOf(buffer);
                        }else {
                            throw new InputMismatchException();
                        }
                    }
                    correct = true;
                }catch (InputMismatchException | NumberFormatException e){
                    System.out.println("Incorrect input");
                }
            }
        }else{
            while (!correct){
                try {
                    System.out.print(str);
                    buffer = sc.nextLine();
                    if (buffer.length()==0){
                        throw new InputMismatchException();
                    }else{
                        correctInt = Integer.valueOf(buffer);
                    }
                    correct = true;
                }catch (InputMismatchException | NumberFormatException e){
                    System.out.println("Incorrect input");
                }
            }
        }



        return correctInt;
    }

    /**
     * Validates MusicGenre
     * @param str - String input request
     * @return MusicGenre correct input
     */
    public MusicGenre nextMusicGenre(String str){
        MusicGenre genre = null;
        boolean correct = false;
        while (!correct){
            System.out.println(str);
            MusicGenre.printAllValues();
            String input = sc.nextLine();
            try {
                genre = MusicGenre.getEnum(input);
                correct = true;
            }catch (IllegalArgumentException e){
                System.out.println("Incorrect input");
            }
        }
        return genre;
    }

    /**
     * Validates time
     * @param str - String input request
     * @return ZonedDateTime correct input
     */
    public ZonedDateTime nextZonedDateTime(String str){
        ZonedDateTime time = null;
        LocalTime localTime = LocalTime.MIDNIGHT;
        LocalDate localDate = null;
        ZoneId zoneId = null;
        boolean correct = false;
        while (!correct){
            try {
                System.out.println(str);
                System.out.println("The format is year.month.day (2021.02.22)");
                String[] input = sc.nextLine().split("\\.", 3);
                localDate = LocalDate.of(Integer.valueOf(input[0]).intValue(), Integer.valueOf(input[1]).intValue(), Integer.valueOf(input[2]).intValue());
                correct = true;
            }catch (Exception e){
                System.out.println("Incorrect input");
            }

        }
        correct = false;
        while (!correct){
            try {
                System.out.print("Insert the offset in the format +/- and a number of hours (+3): ");
                zoneId = ZoneId.of(sc.nextLine());
                correct = true;
            }catch (Exception e){
                System.out.println("Incorrect input");
            }
        }
        time = ZonedDateTime.of(localDate, localTime,zoneId);
        return time;
    }

    /**
     * Validates Float
     * @param str - String input request
     * @param canBeNull - boolean if input can be null
     * @param mustBePositive - boolean if input value must be greater than 0
     * @return Float correct input
     */

    public Float nextFloat(String str, boolean canBeNull, boolean mustBePositive){
        Float correctFloat = Float.valueOf(0);
        boolean correct = false;
        String buffer;

        if (canBeNull && mustBePositive){
            while (!correct){
                try {
                    System.out.print(str);
                    buffer = sc.nextLine();
                    if (buffer.length()==0){
                        correctFloat=null;
                        //break;
                    }else{
                        if (Float.parseFloat(buffer) >0){
                            correctFloat = Float.valueOf(buffer);
                        }else {
                            throw new InputMismatchException();
                        }
                    }
                    correct = true;
                }catch (InputMismatchException | NumberFormatException e){
                    System.out.println("Incorrect input");
                }
            }
        }else if (canBeNull){
            while (!correct){
                try {
                    System.out.print(str);
                    buffer = sc.nextLine();
                    if (buffer.length()==0){
                        correctFloat=null;
                        //break;
                    }else{
                        correctFloat = Float.valueOf(buffer);
                    }
                    correct = true;
                }catch (InputMismatchException | NumberFormatException e){
                    System.out.println("Incorrect input");
                }
            }
        }else if (mustBePositive){
            while (!correct){
                try {
                    System.out.print(str);
                    buffer = sc.nextLine();
                    if (buffer.length()==0){
                        throw new InputMismatchException();
                    }else{
                        if (Float.parseFloat(buffer) >0){
                            correctFloat = Float.valueOf(buffer);
                        }else {
                            throw new InputMismatchException();
                        }
                    }
                    correct = true;
                }catch (InputMismatchException | NumberFormatException e){
                    System.out.println("Incorrect input");
                }
            }
        }else{
            while (!correct){
                try {
                    System.out.print(str);
                    buffer = sc.nextLine();
                    if (buffer.length()==0){
                        throw new InputMismatchException();
                    }else{
                        correctFloat = Float.valueOf(buffer);
                    }
                    correct = true;
                }catch (InputMismatchException | NumberFormatException e){
                    System.out.println("Incorrect input");
                }
            }
        }

        return correctFloat;
    }

}
