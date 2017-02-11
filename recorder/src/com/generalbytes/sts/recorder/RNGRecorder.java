package com.generalbytes.sts.recorder;

import com.generalbytes.sts.recorder.data.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RNGRecorder {
    public static void main(String[] args) {
        Configuration c = parseArguments(args);
        if (c == null) {
            usage();
        }else{
            //configuration is valid.
            if (c.getOutputType() == Configuration.OutputType.BINARY) {
                generateBinary(c);
            }else if (c.getOutputType() == Configuration.OutputType.NUMERICAL) {
                generateNumerical(c);
            }
        }
    }

    private static Configuration parseArguments(String[] args) {
        Configuration configuration = new Configuration();

        if (args.length == 0) {
            return null;
        }

        //parse type parameter
        if (args.length >= 1) {
            String type = args[0];
            if ("bin".equalsIgnoreCase(type)) {
                configuration.setOutputType(Configuration.OutputType.BINARY);
            }else if ("num".equalsIgnoreCase(type)) {
                configuration.setOutputType(Configuration.OutputType.NUMERICAL);
            }else{
                error("Unsupported test type. Valid types are only bin and num.");
            }
        }else{
            error("Missing test type parameter.");
        }

        //parse filename parameter
        if (args.length >= 2) {
            String filename = args[1];
            configuration.setFilename(filename);
        }else{
            error("Output filename needs to be specified.");
        }

        //parse range parameter
        if (args.length >= 3) {
            try {
                int range = Integer.parseInt(args[2]);
                if (configuration.getOutputType() == Configuration.OutputType.BINARY && range != 1) {
                    error("For binary type range can be only 1");
                }
                configuration.setRange(range);
            } catch (NumberFormatException e) {
                error("Range is not a valid number.");
            }
        }

        //check if number of remaining parameters are specified in pairs
        int remainingParameters = args.length - 3;
        if (remainingParameters <= 0) {
            error("Missing seed and count parameters.");
        }

        String test_string =  args[3];

        if (test_string.equalsIgnoreCase("block")) {
            //special configuration for some systems that generate only up to x values from one seed
            String seed_string = args[3 + 1]; // max seed
            long maxSeed = 0;
            try {
                seed_string = seed_string.replace("0x","").replace("h", "").replace("x","");
                maxSeed = Long.parseLong(seed_string, 16);
            } catch (NumberFormatException e) {
                error("Problem parsing seed value " + seed_string);
            }

            String block_size_string = args[3 + 2];
            long blockSize = 0;
            try {
                blockSize = Long.parseLong(block_size_string);
            } catch (NumberFormatException e) {
                error("Problem parsing block size value " + block_size_string);
            }

            String block_count_string = args[3 + 3];
            long count = 0;
            try {
                count = Long.parseLong(block_count_string);
            } catch (NumberFormatException e) {
                error("Problem parsing block count value " + block_count_string);
            }

            configuration.setRecipe(new BlockRecipe(maxSeed,count,blockSize));

        }else{
            //remaining parameters contain list of seeds and counts.
            if ((remainingParameters & 1) == 1) {
                error("seed and count parameters are not specified as pairs");
            }

            List<SeedCountPair> pairs = new ArrayList<>();
            for (int i=0;i<remainingParameters/2;i++) {
                String seed_string =  args[3 + i * 2];
                String count_string = args[3 + i * 2 + 1];

                //regular seeds specification

                long seed = 0;
                try {
                    seed_string = seed_string.replace("0x","").replace("h","").replace("x","");
                    seed = Long.parseLong(seed_string, 16);
                } catch (NumberFormatException e) {
                    error("Problem parsing seed value " + seed_string);
                }
                long count = 0;
                try {
                    count = Long.parseLong(count_string);
                } catch (NumberFormatException e) {
                    error("Problem parsing count value " + count_string);
                }
                pairs.add(new SeedCountPair(seed, count));
            }
            configuration.setRecipe(new ListRecipe(pairs));
        }


        return configuration;
    }

    private static void error(String message) {
        System.out.println("ERROR: " + message);
        usage();
        System.exit(1);
    }

    private static void usage() {
        System.out.println("USAGE:");
        System.out.println(" RNGRecorder type output_filename range seed1 count1 [seed2 count2] [seed3 count3] ...");
        System.out.println(" Parameters explained:");
        System.out.println("             type");
        System.out.println("                    bin - binary format");
        System.out.println("                    num - numerical format");
        System.out.println("             output_filename");
        System.out.println("                    name of file where the results will be written");
        System.out.println("             range");
        System.out.println("                    random numbers from range 0-range will be generated");
        System.out.println("                    for bin format only valid range is 1(0-1)");
        System.out.println("             seed");
        System.out.println("                    hex value of RNG's seed. ie. 0xffff0000");
        System.out.println("                    RNG will be seeded by this value before generating random numbers.");
        System.out.println("             count");
        System.out.println("                    decadic count of numbers that will be generated for a given seed.");
        System.out.println(" Note: ");
        System.out.println("     When more seeds and counts are specified the values will be appended into the output file.");
        System.out.println(" Advanced:");

        System.out.println("");
    }


    private static void generateBinary(Configuration c) {
        System.out.println("Writing binary output to file: " + c.getFilename() + "...");
        try {
            FileOutputStream fos = new FileOutputStream(new File(c.getFilename()));
            final ISeedRecipe recipe = c.getRecipe();
            int seedsUsed = 0;
            while (recipe.hasMorePairs()) {
                SeedCountPair pair = recipe.nextPair();
                seedsUsed++;
                IRandom rnd = getRandom(pair.getSeed());
                long count = pair.getCount();
                int value = 0;
                for (long j=0;j<count;j++) {
                    int bit = rnd.getBit() ? 1 : 0;
                    if (j % 8L == 0) {
                        if (j != 0) {
                            fos.write((byte)value); //write previous value to file.
                        }
                        value = bit << 7L;
                    }else{
                        value |= bit << (7L - (j % 8L ));
                    }
                }
                fos.write((byte)value); //write last value to file.
            }
            fos.close();
            System.out.println("Done. Seeds used: " + seedsUsed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateNumerical(Configuration c) {
        System.out.println("Writing numeric output to file: " + c.getFilename() + "...");
        try {
            FileOutputStream fos = new FileOutputStream(new File(c.getFilename()));
            final ISeedRecipe recipe = c.getRecipe();
            int seedsUsed = 0;
            while (recipe.hasMorePairs()) {
                SeedCountPair pair = recipe.nextPair();
                seedsUsed++;
                IRandom rnd = getRandom(pair.getSeed());
                long count = pair.getCount();
                for (long j=0;j<count;j++) {
                    int value = rnd.getNumber(c.getRange()+1);
                    fos.write((value +"\n").getBytes());
                }
            }
            fos.close();
            System.out.println("Done. Seeds used: " + seedsUsed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static IRandom getRandom(long seed) {
        return new ExampleRandom(seed);
    }


}
