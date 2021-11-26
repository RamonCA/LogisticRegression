package com.mithrill;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class dataSet {

    public static List<Data> readData(String filename) {
        List<Data> dataSet = new ArrayList<>();
        Path path = Paths.get(filename);
        try (BufferedReader br = Files.newBufferedReader(path,
                StandardCharsets.US_ASCII)) {

            String line = br.readLine();
            while (line != null){
                String [] attributes = line.split(",");
                Data data = createData(attributes);
                dataSet.add(data);
                line = br.readLine();
            }
        }catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return dataSet;
    }

    private static Data createData(String [] metadata){
        double input_x = Double.parseDouble(metadata[5]);
        double output_y = Double.parseDouble(metadata[8]);

        return new Data(input_x, output_y);
    }
}
